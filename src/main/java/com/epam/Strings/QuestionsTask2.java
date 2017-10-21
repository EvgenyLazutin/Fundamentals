package com.epam.Strings;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class QuestionsTask2 {

    public static void main(String[] args) {

        String language = "";

        System.out.println("1 – Английский");

        System.out.println("2 – Русский");

        int i = 0;
        Scanner conInput=new Scanner(System.in);
                if(conInput.hasNextInt()){
                    i=conInput.nextInt();
                }

        switch (i) {

case 1:
            language = "EN";

            break;

case 2:
            language = "ru";
        }

        Locale current = new Locale(language);

        ResourceBundle rb = ResourceBundle.getBundle("prop", current);

        try {

            String st = rb.getString("prop.key1");

            String s1 = new String(st.getBytes("ISO-8859-1"), "UTF-8");

            System.out.println(s1);

            st = rb.getString("prop.key2");

            String s2 = new String(st.getBytes("ISO-8859-1"), "UTF-8");

            System.out.println(s2);

            st = rb.getString("prop.key3");

            String s3 = new String(st.getBytes("ISO-8859-1"), "UTF-8");

            System.out.println(s3);

            st = rb.getString("prop.key7");

            String s4 = new String(st.getBytes("ISO-8859-1"), "UTF-8");

            System.out.println(s4);


        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        }
        Scanner conInput2=new Scanner(System.in);
        if(conInput2.hasNextInt()){
            i=conInput2.nextInt();
        }

        try {

            switch (i) {

                case 1:
                    String answ = rb.getString("prop.key4");

                    String answ1 = new String(answ.getBytes("ISO-8859-1"), "UTF-8");

                    System.out.println(answ1);

                    break;

                case 2:
                    answ = rb.getString("prop.key5");

                    String answ2 = new String(answ.getBytes("ISO-8859-1"), "UTF-8");

                    System.out.println(answ2);

                    break;

                case 3:
                    answ = rb.getString("prop.key6");

                    String answ3 = new String(answ.getBytes("ISO-8859-1"), "UTF-8");

                    System.out.println(answ3);

                    break;
            }
        }catch (IOException e1) {

            e1.printStackTrace();

        }


    }

}

