package com.epam.In_Out;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.epam.In_Out.InputStreamTask1.KeyWords;

public class ReaderWriterTask2 {
    private String pathIn;
    private Set<String> SetKeyWords = new HashSet<>();
    private Map<String, Integer> MapKeyWords = new HashMap<>();

     ReaderWriterTask2(String pathIn) {
        this.pathIn = pathIn;
    }

    void readerFile(){
        try(FileReader fileRead=new FileReader(pathIn)){
            BufferedReader bufferedReader=new BufferedReader(fileRead);
            StringBuffer stringBuffer=new StringBuffer();
            String tmp;
            while ((tmp=bufferedReader.readLine())!=null){
                stringBuffer.append(tmp);
            }
            String[] strmas = stringBuffer.toString().split("\\s|\\(|\\)|\\[|;|,|\\.");
            for (int i = 0; i < strmas.length; i++) {
                for (String it :
                        KeyWords) {
                    boolean flag = false;
                    if (strmas[i].contains(it)) {
                        flag = SetKeyWords.add(strmas[i]);
                        if (flag) {
                            MapKeyWords.put(strmas[i], 1);
                        }
                        if (!flag) {
                            int tmpInt;
                            tmpInt=MapKeyWords.get(strmas[i]);
                            MapKeyWords.put(strmas[i], tmpInt+1);
                        }

                    }

                }

            }
            for (Map.Entry entry : MapKeyWords.entrySet()) {
                System.out.println("Key: " + entry.getKey() + "; Quantity: "
                        + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writerFile(String pathOut){
        try(BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(pathOut))) {
            for (Map.Entry entry : MapKeyWords.entrySet()) {
                bufferedWriter.write((String) entry.getKey());
                bufferedWriter.write((int) entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {

        ReaderWriterTask2  Test =new ReaderWriterTask2 ("/home/jon/IdeaProjects/" +
                "JavaFundamentals/src/main/java/com/epam/Intro/IntroTask3.java");
      Test.readerFile();
     Test.writerFile("/home/jon/IdeaProjects/JavaFundamentals/src/main/resources/" +
             "TestInputStreamTask1.txt");

    }
}
