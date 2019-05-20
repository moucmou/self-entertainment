package com.self.entertainment.unclassified;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.TimeUnit;

/**
 * @author AmazingZ
 * @date 2019/4/17 10:48
 */
public class CuratorTest {

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework= CuratorFrameworkFactory.newClient("",new RetryNTimes(10,5000));
        curatorFramework.start();
        try {
            curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/my/path",new byte[0]);
            curatorFramework.getCuratorListenable().addListener(new CuratorListener() {
                @Override
                public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
                    //todo
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        InterProcessMutex interProcessMutex=new InterProcessMutex(curatorFramework,"/my/path");
        if ( interProcessMutex.acquire(3, TimeUnit.SECONDS) )
        {
            try
            {
                // do some work inside of the critical section here
            }
            finally
            {
                interProcessMutex.release();
            }
        }
    }
}
