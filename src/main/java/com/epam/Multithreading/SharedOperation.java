package com.epam.Multithreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SharedOperation {

    private List<String> list;
    private  String pathToResurce;

    public SharedOperation(String path) {

        list = new ArrayList<String>();
        pathToResurce=path;
        ReadOperation();
    }

    private void ReadOperation() {

        try (FileReader fileRead = new FileReader(pathToResurce);
             BufferedReader bufferedReader = new BufferedReader(fileRead)){
            String tmp;
            System.out.println("Read File");
            while ((tmp = bufferedReader.readLine()) != null) {
                  setOperation(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void setOperation(String operation) {
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
