package com.epam.Multithreading;

import com.epam.Exceptions.ReadPropertiesTask2;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ReadPropMultithreadedTask2 extends ReadPropertiesTask2 implements Runnable {
    private ConcurrentLinkedQueue<String> queue=new ConcurrentLinkedQueue<>();

    protected ReadPropMultithreadedTask2(String nameProperty) {
        super.readPropFile(nameProperty);
        queue.addAll(getKeyProperties());


    }

    @Override
    public void run() {
        while (!queue.isEmpty()) {

            System.out.print(Thread.currentThread().getName()+"  ");
            System.out.println(getObject( queue.poll()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public static void main(String[] args) {

        ExecutorService executorService= Executors.newFixedThreadPool(3);
        ReadPropMultithreadedTask2 task2=new ReadPropMultithreadedTask2("prop_en");
        executorService.execute(new Thread(task2,"4"));
        executorService.execute(new Thread(task2,"2"));
        executorService.execute(new Thread(task2,"3"));
        executorService.shutdown();

    }
}
