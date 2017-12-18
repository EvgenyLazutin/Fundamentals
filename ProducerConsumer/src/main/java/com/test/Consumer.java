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

    public Consumer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    public void startConsuming() {
        Message [] buffer=new Message[bufSize];
        clearFile("/home/jon/IdeaProjects/" +
                "JavaFundamentals/ProducerConsumer/src/" +
                "main/resources/messageoutput.txt");
        consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {

                        for (int i = 0; i < bufSize; i++) {
                            buffer[i] = queue.take();
                        }
                        Arrays.sort(buffer);
                        writerFile("/home/jon/IdeaProjects/" +
                                "JavaFundamentals/ProducerConsumer/src/" +
                                "main/resources/messageoutput.txt", buffer);

                    } catch (InterruptedException e) {
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
            for (int i = 0; i < message.length; i++) {
                bufferedWriter.write(message[i].toString());
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
