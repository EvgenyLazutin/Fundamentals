package com.epam.In_Out;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class InputStreamTask1 {
    private String pathIn;
    private String pathOut;
    public static String[] KeyWords = {"public", "abstract", "continue", "for", "new", "switch", "assert",
            "default", "goto", "package", "synchronized", "boolean", "do", "if", "private", "this",
            "break", "double", "implements", "protected", "throw", "byte", "else", "import", "public",
            "throws", "case", "enum", "instanceof", "return", "transient", "catch", "extends",
            "int", "short", "try", "char", "final", "interface", "static", "void", "class",
            "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while"};
    private Set<String> SetKeyWords = new HashSet<>();
    private Map<String, Integer> MapKeyWords = new HashMap<>();

     InputStreamTask1(String path) {
        this.pathIn = path;
    }

 private    void InputStreamTask1Read() {
        try (FileInputStream fin = new FileInputStream(pathIn)) {
            byte[] buffer = new byte[fin.available()];// считаем файл в буфер
            fin.read(buffer, 0, fin.available());
            System.out.println("Содержимое файла:");
            String str = new String(buffer, "UTF-8");
            // str.trim();
            String[] strmas = str.split("\\s|\\(|\\)|\\[|\\.");
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
                            int tmp;
                            tmp=MapKeyWords.get(strmas[i]);
                            MapKeyWords.put(strmas[i], tmp+1);
                        }

                    }

                }

            }
            for (Map.Entry entry : MapKeyWords.entrySet()) {
                    System.out.println("Key: " + entry.getKey() + "; Quantity: "
                            + entry.getValue());
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    private void InputStreamTask1Write(String PathOut) {
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(PathOut);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try (DataOutputStream dos = new DataOutputStream(outputStream)) {
            // записываем значения
            for (Map.Entry entry : MapKeyWords.entrySet()) {
                dos.writeUTF((String) entry.getKey());
                dos.writeInt((int) entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        InputStreamTask1 Test =new InputStreamTask1("/home/jon/IdeaProjects/" +
                "JavaFundamentals/src/main/java/com/epam/Intro/IntroTask4.java");
        Test.InputStreamTask1Read();
        Test.InputStreamTask1Write("/home/jon/IdeaProjects/JavaFundamentals/src/main/resources/" +
                "TestInputStreamTask1.txt");

    }
}
//        Set<String> SetKeyWords=new HashSet<>();
//        Map<String,Integer> MapKeyWords=new HashMap<>();
//String[] KeyWords={"public","abstract",	"continue",	"for",	"new",	"switch", "assert",
//        "default",	"goto",	"package",	"synchronized","boolean","do","if",	"private","this",
//        "break","double","implements",	"protected","throw","byte",	"else","import","public",
//        "throws","case","enum",	"instanceof","return","transient","catch","extends",
//        "int",	"short","try","char","final","interface","static","void","class",
//        "finally",	"long",	"strictfp",	"volatile","const",	"float","native","super","while"};
//            try(FileInputStream fin=new FileInputStream("/home/jon/IdeaProjects/" +
//                    "JavaFundamentals/src/main/java/com/epam/Intro/IntroTask4.java"))
//            {
////                System.out.println("Размер файла: " + fin.available() + " байт(а)");
////
////                int i=-1;
////                while((i=fin.read())!=-1){
////
////                    System.out.print((char)i);
//                byte[] buffer = new byte[fin.available()];
//// считаем файл в буфер
//                fin.read(buffer, 0, fin.available());
//
//                System.out.println("Содержимое файла:");
////                for(int i=0; i<buffer.length;i++){
////
////                    System.out.print((char)buffer[i]);
////                }
//               String str= new String(buffer, "UTF-8");
//            // str.trim();
//               String [] strmas=str.split("\\s");
//                for (int i = 0; i < strmas.length; i++) {
//                    for (String it:
//                           KeyWords ) {
//                        boolean flag=false;
//                        if (strmas[i].contains(it)){
//                            flag=SetKeyWords.add(strmas[i]);
//                            if(flag){
//                                MapKeyWords.put(strmas[i],1);
//                            }
//                            if(!flag){
//                                MapKeyWords.put(strmas[i],+1);
//                            }
//
//                        }
//
//                    }
//
//                }
//                for (Map.Entry entry : MapKeyWords.entrySet()) {
//                    System.out.println("Key: " + entry.getKey() + " Value: "
//                            + entry.getValue());
//                }
//
//
////            for (Map.Entry entry : MapKeyWords.entrySet()) {
////                System.out.println("Key: " + entry.getKey() + " Value: "
////                        + entry.getValue());
////
////                outputStream.write((byte[]) entry.getKey());
////                outputStream.write((byte[]) entry.getValue());
////            }
//            } catch(IOException ex){
//
//                System.out.println(ex.getMessage());
//            }
//        }
//    }





