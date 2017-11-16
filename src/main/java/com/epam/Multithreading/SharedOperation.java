package com.epam.Multithreading;

import java.util.ArrayList;
import java.util.List;

public class SharedOperation {

    private List<String> list;
    public SharedOperation() {
        list = new ArrayList<String>();
    }
    public void setOperation(String operation) {
        list.add(operation);
    }
    public String getOperation() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }
    boolean hasOperation(){
        if(list.size()>0) return true;
        return false;
    }
}
