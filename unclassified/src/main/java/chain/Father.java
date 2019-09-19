package chain;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author AmazingZ
 * @date 2019/8/7 18:28
 */
public class Father {


    public Father() {
        System.out.println("父类构造方法");
    }

    {
        System.out.println("父类非费静态代码块");
    }

    static {
        System.out.println("我是父类静态代码块");
    }


    public static class TestRecursiveTask extends RecursiveTask<Long> implements Serializable {

        private static final long serialVersionUID = -1317409913285144792L;
        private int start;
        private int end;
        private int threshold;

        public TestRecursiveTask(int start, int end, int threshold) {
            this.start = start;
            this.end = end;
            this.threshold = threshold;
        }

        @Override
        protected Long compute() {

            if (end - start <= threshold) {
                return computeByUnit();
            }
            int mid = (start + end) / 2;

            TestRecursiveTask left = new TestRecursiveTask(start, mid, threshold);
            TestRecursiveTask right = new TestRecursiveTask(mid + 1, end, threshold);
            invokeAll(left, right);
            return left.join() + right.join();
        }

        Long computeByUnit() {
            Long sum = 0L;
            for (int i = start; i <= end; i++) {
                sum = sum + i;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long start1 = System.currentTimeMillis();
        ForkJoinTask<Long> forkJoinTask = forkJoinPool.submit(new TestRecursiveTask(0, 100000, 100));
        Long x = forkJoinTask.join();
        System.err.println(System.currentTimeMillis()-start1);
        int y = 0;
        Long start2 = System.currentTimeMillis();
        for (int i = 0; i <= 100000; i++) {
            y = y + i;
        }
        System.err.println(System.currentTimeMillis() - start2);
        assert  x == 3;

        System.err.println(x);
        RedisTemplate<String,String> redisTemplate=new RedisTemplate<>();
        redisTemplate.executePipelined(new RedisCallback() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.openPipeline();
                try {
                    connection.zCount("123".getBytes("utf-8"),0,10);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

}
