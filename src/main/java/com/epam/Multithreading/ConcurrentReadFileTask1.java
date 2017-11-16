package com.epam.Multithreading;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentReadFileTask1 extends Thread{

    private final SharedOperation resource;
    private DepositOperation[] massivDeposit;
    private Random rand = new Random();

    public ConcurrentReadFileTask1(SharedOperation resource, String name) {
        super(name);
        this.resource = resource;
       massivDeposit=new DepositOperation[15];
        for (int i = 0; i <15; i++) {
            massivDeposit[i]=new DepositOperation(i*1000,rand.nextInt(100000));
        }
    }


    @Override
    public void run() {

            while (resource.hasOperation()) try (Scanner scanner = new Scanner(getOperationThread())) {
                if(!scanner.hasNextInt())break;
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


    private String getOperationThread() throws InterruptedException {
        String operation;
            System.out.println("Thread: " + getName() + "read string");
           operation = resource.getOperation();
            System.out.println("Thread: " + getName() + "get operation");
            return operation;
        }

    public static void main(String[] args) throws InterruptedException {
       SharedOperation sharedOperation=new SharedOperation("/home/jon/IdeaProjects/JavaFundamentals" +
               "/src/main/resources/DepositeOperation.txt");
        ExecutorService executorService= Executors.newFixedThreadPool(5);
        executorService.execute(new
                ConcurrentReadFileTask1( sharedOperation,"1"));
        executorService.execute(new
                ConcurrentReadFileTask1( sharedOperation,"2"));
        executorService.execute(new
                ConcurrentReadFileTask1( sharedOperation,"3"));
        executorService.execute(new
                ConcurrentReadFileTask1( sharedOperation,"4"));
        executorService.execute(new
                ConcurrentReadFileTask1( sharedOperation,"5"));
        executorService.shutdown();



    }

}
