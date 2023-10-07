package io.github.duolabmeng6.javaefun.util;

import cn.hutool.core.lang.Snowflake;

import java.util.concurrent.CountDownLatch;

public class SnowflakeIdGenerator {

    private static long machineId = 0;
    private static long datacenterId = 0;

    private static class SingletonHolder {
        private static final SnowflakeIdGenerator INSTANCE = new SnowflakeIdGenerator();
    }

    private SnowflakeIdGenerator() {
    }

    public static SnowflakeIdGenerator getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public long generateUniqueId() {
        return SnowflakeSingleton.getInstance().nextId();
    }

    private static class SnowflakeSingleton {
        private static final Snowflake SNOWFLAKE_INSTANCE = new Snowflake(datacenterId, machineId);

        private SnowflakeSingleton() {
        }

        public static Snowflake getInstance() {
            return SNOWFLAKE_INSTANCE;
        }
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(10000);
        long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                System.out.println(SnowflakeIdGenerator.getInstance().generateUniqueId());
                latch.countDown();
            }).start();
        }

        try {
            System.out.println("主线程" + Thread.currentThread().getName() + "等待子线程执行完成...");
            latch.await(); // 阻塞当前线程，直到计数器的值为0
            System.out.println("主线程" + Thread.currentThread().getName() + "开始执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("雪花算法用时： ");
        System.out.println(System.currentTimeMillis() - start);
    }
}
