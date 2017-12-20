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
    private final String pathFile="ProducerConsumer/src/"+
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
                            if(buffer[i].getText()=="Exit"){break;}
                        }
                        if(buffer[bufSteak-1].getText()=="Exit"){break;}
                        Arrays.sort(buffer);
                        writerFile(pathFile, buffer);

                    } catch (InterruptedException e) {
                        // executing thread has been interrupted, exit loop
                        break;
                    }
                }
                Message [] steakBuf=new Message[bufSteak];
                System.arraycopy(buffer, 0,steakBuf,0,bufSteak);
                Arrays.sort(steakBuf);
                writerFile(pathFile, steakBuf);
            }
        });
        consumerThread.start();

    }

    public void stopConsuming() {
        consumerThread.interrupt();
    }

    /**
     * Private method for write messages to file and to console.
     *
     * @param pathOut the path to file.
     *
     * @param message massive of messages for writing.
     */

  private void writerFile(String pathOut, Message message[]){
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(pathOut, true))) {
            for (Message aMessage : message) {
                bufferedWriter.write(aMessage.toString());
                System.out.println(aMessage);
            }

        } catch (IOException e) {
            System.out.println(e + "Path to file or file incorrect! Writing will be on " +
                    "temporary file lazutin-out.txt");
            try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter("ProducerConsumer/src/" +
                    "main/resources/lazutin-out.txt", true))) {
                for (Message aMessage : message) {
                    bufferedWriter.write(aMessage.toString());
                    System.out.println(aMessage);
                }

            } catch (IOException j) {
                e.printStackTrace();
            }
        }
    }

   private void clearFile(String pathOut){
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(pathOut))) {
                bufferedWriter.write("");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File is not clear!  File " +pathOut+" is not available, please close file and try again!");
        }
    }
}
