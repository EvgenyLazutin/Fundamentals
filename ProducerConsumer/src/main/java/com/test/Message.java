package com.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Message implements Comparable<Message> {

    public enum Priority {

        HIGH, MEDIUM, LOW
    }

    private long timestamp;
    private Priority priority;
    private String text;

    public Message(long timestamp, Priority priority, String text) {
        this.timestamp = timestamp;
        this.priority = priority;
        this.text = text;
    }

    public Message(String exit) {
        this.timestamp = 0;
        this.priority = Priority.LOW;
        this.text = exit;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY : HH-mm");
        cal.setTimeInMillis( getTimestamp() );
        return "Date: " +format.format(cal.getTime())+
                ", priority: " + getPriority() +
                ", Message: " + getText() + '\n';
    }

    @Override
    public int compareTo(Message o) {
        return (getPriority().compareTo(o.priority));
    }

}
