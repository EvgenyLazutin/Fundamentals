package com.test;

import com.test.Message.Priority;

/**
 * Message factory singleton. This class should not need to be modified during
 * the exercise.
 */
public class MessageFactory {

    public static Message generateMessage(int counter) throws InterruptedException {
        // insert artificial delay simulating a time-consuming message production process...
        long sleepTime = 50 + (long) ((Math.random() - 0.8) * 10);
        Thread.sleep(sleepTime);

        return new Message(System.currentTimeMillis(), getRandomPriority(),
                "Message for you sir! (" + counter + ")");
    }

    private static Priority getRandomPriority() {
        int randomInt = (int) Math.floor((3 * Math.random()));
        switch (randomInt) {
            case 0:
                return Priority.LOW;
            case 1:
                return Priority.MEDIUM;
            case 2:
                return Priority.HIGH;
            default:
                return null;
        }
    }
}
