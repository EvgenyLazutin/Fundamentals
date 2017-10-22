package com.epam.Strings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class RegExTask3 {

    public static void main(String[] args) {

        Pattern ptrn=Pattern.compile("Рис.+");
        FileReader fileForReader = null;
        try {
            fileForReader = new FileReader("/home/jon/IdeaProjects/JavaFundamentals/src/main/resources/Java.SE.03.Information handling_task_attachment.html");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fileForReader);
        String strLine;
        String[] result = new String[10];
        try {
            while ((strLine=br.readLine())!=null){
               result=ptrn.split(strLine);

            }
            for (String str:
                    result ) {
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fileForReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

