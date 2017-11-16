package com.epam.Multithreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class SynchronizedReadFileTask1 extends Thread{

    private String pathToResurce;
    private final SharedOperation resource;
    private DepositOperation[] massivDeposit;
    private Random rand = new Random();

    public SynchronizedReadFileTask1(String pathToResurce, SharedOperation resource,String name) {
        super(name);
        this.pathToResurce = pathToResurce;
        this.resource = resource;
       massivDeposit=new DepositOperation[15];
        for (int i = 0; i <15; i++) {
            massivDeposit[i]=new DepositOperation(i*1000,rand.nextInt(100000));
        }
    }


    @Override
    public void run() {
       // ReadOperation();
        while (resource.hasOperation()) {
            try (Scanner scanner = new Scanner(getOperationThread())) {
                int depFrom = scanner.nextInt();
                int val = scanner.nextInt();
                int depTo = scanner.nextInt();
                for (int i = 0; i < massivDeposit.length; i++) {
                    if (massivDeposit[i].getNumberDep() == depFrom) {
                        massivDeposit[i].depPlus(val);
                        for (int j = 0; j < massivDeposit.length; j++) {
                            if (massivDeposit[j].getNumberDep() == depTo) {
                                massivDeposit[j].depPlus(~val);
                            }
                        }
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    void ReadOperation() {

        try (FileReader fileRead = new FileReader(pathToResurce);
            BufferedReader bufferedReader = new BufferedReader(fileRead)){
            String tmp;
                while ((tmp = bufferedReader.readLine()) != null) {
                    System.out.println("Thread: " + getName() + " write string");
                    synchronized(resource) {
                    resource.setOperation(tmp);
                    resource.notifyAll();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getOperationThread() throws InterruptedException {
        String operation;
        synchronized (resource) {
            System.out.println("Thread: " + getName() + "read string");
           operation = resource.getOperation();
            while (operation == null) {
                System.out.println("Thread: " + getName() + "wait");
                resource.wait();
                System.out.println("Thread: " + getName() + "work");
               operation = resource.getOperation();
            }
            System.out.println("Thread: " + getName() + "get operation");
            return operation;
        }
    }
    public static void main(String[] args) throws InterruptedException {
       SharedOperation sharedOperation=new SharedOperation();
       SynchronizedReadFileTask1 S1=new
               SynchronizedReadFileTask1("/home/jon/IdeaProjects/JavaFundamentals" +
               "/src/main/resources/DepositeOperation.txt", sharedOperation,"1");
       S1.ReadOperation();
        SynchronizedReadFileTask1 S2=new
                SynchronizedReadFileTask1("/home/jon/IdeaProjects/JavaFundamentals" +
                "/src/main/resources/DepositeOperation.txt", sharedOperation,"2");
        SynchronizedReadFileTask1 S3=new
                SynchronizedReadFileTask1("/home/jon/IdeaProjects/JavaFundamentals" +
                "/src/main/resources/DepositeOperation.txt", sharedOperation,"3");
        S1.start();
        S2.start();
        S3.start();
        S1.join();
        S2.join();
        S3.join();


    }

}
