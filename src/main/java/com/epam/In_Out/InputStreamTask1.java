package com.epam.In_Out;

import java.io.FileInputStream;
import java.io.IOException;


public class InputStreamTask1 {
    public static void main(String[] args) {


            try(FileInputStream fin=new FileInputStream("/home/jon/IdeaProjects/" +
                    "JavaFundamentals/src/main/java/com/epam/Intro/IntroTask4.java"))
            {
//                System.out.println("Размер файла: " + fin.available() + " байт(а)");
//
//                int i=-1;
//                while((i=fin.read())!=-1){
//
//                    System.out.print((char)i);
                byte[] buffer = new byte[fin.available()];
// считаем файл в буфер
                fin.read(buffer, 0, fin.available());

                System.out.println("Содержимое файла:");
                for(int i=0; i<buffer.length;i++){

                    System.out.print((char)buffer[i]);
                }

            } catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
    }





