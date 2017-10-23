package com.epam.Strings;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTask3 {

    public static void main(String[] args) {


        Pattern ptrn=Pattern.compile("(Рис)+..[0-9]{1,4}");

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("" +
                    "/home/jon/IdeaProjects/JavaFundamentals/src/main/resources/" +
                    "Java.SE.03.Information handling_task_attachment.html"),"CP1251"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String strLine;
        System.out.println(br.toString());
        try {
            while ((strLine=br.readLine())!=null){
               Matcher result=ptrn.matcher(strLine);
               boolean flag=false;
               while (result.find()) {
                   System.out.println("Result: " + result.group());
                       flag=true;
                   }
                if(flag) {
                    System.out.println("Строка: " + strLine);
               }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

