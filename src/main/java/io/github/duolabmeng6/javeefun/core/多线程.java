package io.github.duolabmeng6.javeefun.core;




import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + ":");

    }
}

public class 多线程 {
    public static void main(String[] args) {
        // 创建一个线程池对象，控制要创建几个线程对象。
        // public static ExecutorService newFixedThreadPool(int nThreads)
        ExecutorService pool = Executors.newFixedThreadPool(10);

        // 可以执行Runnable对象或者Callable对象代表的线程
//        pool.submit(new MyRunnable());
//        pool.submit(new MyRunnable());
        for (int i=0;i<1000;i++){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(pool.submit(new MyRunnable()));
            System.out.println("=========");
            
            System.out.println("投递任务完成");
        }

        //结束线程池
        pool.shutdown();
    }
}