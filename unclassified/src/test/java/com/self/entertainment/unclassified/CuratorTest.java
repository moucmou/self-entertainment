package com.self.entertainment.unclassified;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.api.CuratorWatcher;
import org.apache.curator.retry.RetryNTimes;
import org.apache.dubbo.remoting.zookeeper.ZookeeperClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author AmazingZ
 * @date 2019/4/17 10:48
 */
public class CuratorTest {
    /**
     * 可以对事件注册多种不同的监听器，比如checkExists(能监听到对节点的增删改),getData(对节点的增删和修改数据),getChildren（对子节点的增删改）
     *
     * @throws Exception
     */
    @Test
    public void testSetdata() throws Exception {
        try (
                CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("119.3.10.221:2181", new RetryNTimes(10, 5000));
        ) {
            curatorFramework.start();
            /**
             * 创建的临时节点的子节点连带创建的父节点是不会被删除的，切记
             */
            curatorFramework.checkExists().usingWatcher(new CuratorWatcher() {
                @Override
                public void process(WatchedEvent event) throws Exception {
                    System.out.println("我被触发了吗");
                }
            }).forPath("/my/path/lock/zz");

            curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/my/path/lock/zz");

            curatorFramework.checkExists().forPath("/my/path/lock/zz");
            System.out.println();
            curatorFramework.delete().forPath("/my/path/lock/zz");
        }

    }

    /**
     * getData的监听器对节点的数据进行修改也能接收到报警，但是是只能收到一次报警的，需要在收到的报警中接着再次注册监听事件
     *
     * @throws Exception
     */
    @Test
    public void testSetdataWatcher() throws Exception {
        try (
                CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("119.3.10.221:2181", new RetryNTimes(10, 5000));
        ) {
            curatorFramework.start();
            curatorFramework.getData().usingWatcher(new CuratorWatcher() {
                @Override
                public void process(WatchedEvent event) throws Exception {

                    System.out.println("我被触发了吗" + event);
                }
            }).forPath("/my/path/lock");
            curatorFramework.setData().forPath("/my/path/lock", "helloworld".getBytes());
            curatorFramework.setData().forPath("/my/path/lock", "helloworld12".getBytes());
            System.out.println();
        }
    }

    /**
     * getChildren的监听器不能监听到子节点树修改，只能监听到子节点的节点增删改
     *
     * @throws Exception
     */
    @Test
    public void testGetChildrenWatcher() throws Exception {
        try (
                CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("119.3.10.221:2181", new RetryNTimes(10, 5000));
        ) {
            curatorFramework.start();
            curatorFramework.getChildren().usingWatcher(new CuratorWatcher() {
                @Override
                public void process(WatchedEvent event) throws Exception {

                    System.out.println("我被触发了吗" + event);
                }
            }).forPath("/my/path/lock");
//            curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/my/path/lock/zz");
            curatorFramework.setData().forPath("/my/path/lock/zz", "wocaonima".getBytes());

            System.out.println();
        }
    }

    /**
     * 监听新客户端的连接吗？   可以的
     *
     * @throws Exception
     */
    @Test
    public void testConnectionWatcher() throws Exception {
        try (
                CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient("119.3.10.221:2181", new RetryNTimes(10, 5000));
        ) {
            CountDownLatch countDownLatch=new CountDownLatch(1);
            curatorFramework.start();
            curatorFramework.getCuratorListenable().addListener(new CuratorListener() {
                @Override
                public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
                    System.out.println("我被触发了吗" + event);
                    countDownLatch.countDown();
                }

            });
            /**
             * 获取sessionid & passwd可以恢复session 的连接   ?? 怎么做的
             */
            curatorFramework.getZookeeperClient().getZooKeeper().getSessionId();
            curatorFramework.getZookeeperClient().getZooKeeper().getSessionPasswd();
//            curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/my/path/lock/zz");
//            curatorFramework.setData().forPath("/my/path/lock/zz", "wocaonima".getBytes());
            countDownLatch.await();
        }
    }

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
                curatorFramework.getData().forPath("/my/path/lock");
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
