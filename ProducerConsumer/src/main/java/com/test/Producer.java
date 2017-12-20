package com.test;

import java.util.concurrent.BlockingQueue;

public class Producer {

    private BlockingQueue<Message> queue;
    private volatile int messageCounter = 0;
    private Thread ProducerThread = null;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    public void startProducing() {
        ProducerThread =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (messageCounter <=103) {
                        Message message = MessageFactory.generateMessage(messageCounter);
                        queue.add(message);
                        messageCounter++;
                    }

                } catch (InterruptedException e) {
                    // exit loop quietly
                }finally {
                    Message messageExit =new Message("Exit");
                    queue.add(messageExit);
                }
            }
        });
        ProducerThread.start();
    }

    public void stopProducing() {

        // set message counter to maximum number of messages to stop loop, allowing thread to exit
        messageCounter = 100;
    }
}
