package com.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;

public class Consumer {

    private BlockingQueue<Message> queue;
    private Thread consumerThread = null;
    private final int bufSize=10;
    private final String pathFile="ProducerConsumer/src/" +
            "main/resources/messageoutput.txt";

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    public void startConsuming() {
        Message [] buffer=new Message[bufSize];
        clearFile(pathFile);
        consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int bufSteak=0;
                while (true) {
                    try {
                        for (int i = 0; i < bufSize; i++) {
                            buffer[i] = queue.take();
                            bufSteak=i+1;
                        }
                        Arrays.sort(buffer);
                        writerFile(pathFile, buffer);

                    } catch (InterruptedException e) {
                        Message [] steakBuf=new Message[bufSteak];
                        System.arraycopy(buffer, 0,steakBuf,0,bufSteak);
                        Arrays.sort(steakBuf);
                        writerFile(pathFile, steakBuf);
                        // executing thread has been interrupted, exit loop
                        break;
                    }
                }
            }
        });
        consumerThread.start();

    }

    public void stopConsuming() {
        consumerThread.interrupt();
    }

  private void writerFile(String pathOut, Message message[]){
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(pathOut, true))) {
            for (Message aMessage : message) {
                bufferedWriter.write(aMessage.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   private void clearFile(String pathOut){
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(pathOut))) {
                bufferedWriter.write("");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
