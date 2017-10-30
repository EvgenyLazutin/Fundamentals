package com.epam.In_Out;

import java.io.*;

public class Utf8ToUtf16Task3 {
    private String textSource;

    public Utf8ToUtf16Task3(String textSource) {
        try {
            this.textSource = new String(textSource.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    void setTextSourceToUtf16(String patch){
        try (Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(patch),"UTF-16"))) {
           out.write(textSource);
            System.out.println("Decoding complite!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

       Utf8ToUtf16Task3 TestTask3=new Utf8ToUtf16Task3("Тестовая строка!");
       TestTask3.setTextSourceToUtf16("/home/jon/IdeaProjects/JavaFundamentals/src/main/resources/" +
        "TestInputStreamTask1.txt");

    }
}
