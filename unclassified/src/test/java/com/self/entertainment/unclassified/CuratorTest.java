package com.self.entertainment.unclassified;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author AmazingZ
 * @date 2019/4/17 10:48
 */
public class CuratorTest {

    public static void main(String[] args) throws Exception {
        Executor executor = Executors.newSingleThreadExecutor();

        Thread t1 = new Thread(() -> {
            CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("119.3.10.221:2181", new RetryNTimes(10, 5000));
            curatorFramework.start();
            try {
                for (int i = 0; i < 9; i++) {
                    curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/my/path/lock/zz", new byte[0]);
                }
                List<String> test = curatorFramework.getChildren().forPath("/my/path/lock");
                curatorFramework.getData().usingWatcher(new CuratorWatcher() {
                    @Override
                    public void process(WatchedEvent event) throws Exception {

                        System.out.println("怎么肥4，监听不生效？");
                        System.out.println();
                    }
                });
//                curatorFramework.create().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath("/my/path/lock/zz", new byte[0]);
                System.out.println();
                curatorFramework.getCuratorListenable().addListener(new CuratorListener() {
                    @Override
                    public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
                        //todo
                        System.out.println("怎么肥4，监听不生效？");
                        System.out.println();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        executor.execute(t1);
        TimeUnit.SECONDS.sleep(200000);
//        t1.start();
//        t1.join();
//        InterProcessMutex interProcessMutex=new InterProcessMutex(curatorFramework,"/my/path");
//        if ( interProcessMutex.acquire(3, TimeUnit.SECONDS) )
//        {
//            try
//            {
//                // do some work inside of the critical section here
//            }
//            finally
//            {
//                interProcessMutex.release();
//            }
//        }
    }
}
