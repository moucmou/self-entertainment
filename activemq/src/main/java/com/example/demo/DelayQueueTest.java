package com.example.demo;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author AmazingZ
 * @date 2019/7/10 16:04
 */
public class DelayQueueTest {


    public static void main(String[] args) {
        DelayQueue<DelayQueueDelayed> delayQueue = new DelayQueue<>();
        delayQueue.put(new DelayQueueDelayed(LocalDateTime.now().plusSeconds(5), "1"));
        delayQueue.put(new DelayQueueDelayed(LocalDateTime.now().plusSeconds(11), "2"));

        try {
            while (true) {
                System.out.println(delayQueue.take().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class DelayQueueDelayed implements Delayed {

        private LocalDateTime expirationTime;
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public DelayQueueDelayed(LocalDateTime expirationTime, String name) {
            this.expirationTime = expirationTime;
            this.name = name;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return expirationTime.toInstant(ZoneOffset.of("+8")).toEpochMilli() - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            DelayQueueDelayed delayQueueDelayed = (DelayQueueDelayed) o;
            return this.expirationTime.isBefore(delayQueueDelayed.getExpirationTime()) ? -1 : this.expirationTime.isAfter(delayQueueDelayed.getExpirationTime()) ? 1 : 0;
        }

        public LocalDateTime getExpirationTime() {
            return expirationTime;
        }

        public void setExpirationTime(LocalDateTime expirationTime) {
            this.expirationTime = expirationTime;
        }
    }
}
