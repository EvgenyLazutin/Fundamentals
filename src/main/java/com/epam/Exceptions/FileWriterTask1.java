package com.epam.Exceptions;

import java.io.*;

public class FileWriterTask1 {
    private String name;
    private String pathInCataloge;
    private String pathInFile;

    public FileWriterTask1(String nameObject) {
        this.name = name;
    }

    void showFile(String path) {

        try {
            File file = new File(path);
            if (file.exists()) {
                File[] fileShow = file.listFiles();
                if (fileShow != null) {
                    for (File aFileShow : fileShow) {
                        System.out.println(aFileShow);
                    }
                    this.pathInCataloge = path;
                }
            }
        } catch (NullPointerException e) {
            //e.printStackTrace();
            System.out.println("Catalog or file is not found, please try again");
        }
    }

    boolean deleteLastFile()throws SecurityException{
        File file=new File(pathInFile);
        if (file.exists()){
            boolean flag= file.delete();
            if(flag){
                System.out.println("File deleted successfully!");
                return flag;
            }
        }
        System.out.println("File is not deleted!");
        return false;
    }

    boolean deleteFileInThisCataloge(String fileName) throws SecurityException {
        this.pathInFile=this.pathInCataloge+"/"+fileName;
        return deleteLastFile();
    }

    private boolean hasFileInCataloge(String fileName) throws NullPointerException{
            File file = new File(pathInCataloge + "/" + fileName);
        return file.exists();
    }

    boolean creatFileInThisCataloge(String nameOfFile) {

        try {
            if (!hasFileInCataloge(nameOfFile)) {
                File file = new File(pathInCataloge + "/" + nameOfFile);

                try {
                    this.pathInFile = pathInCataloge + "/" + nameOfFile;
                    System.out.println("File is create!");
                    return file.createNewFile();
                } catch (IOException e) {
                    System.out.println("File is not create");
                }
            }
            System.out.println("File is already exists!");
            this.pathInFile = pathInCataloge + "/" + nameOfFile;
            return false;
        }catch (NullPointerException e){
            System.out.println("Name of file is incorrect!");
            return false;
        }
    }

    void writeAddInLastFile(String addToFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter
                (new FileWriter(pathInFile,true))) {
            bufferedWriter.write(addToFile);
            bufferedWriter.write(0x0A);
        } catch (IOException e) {
            System.out.println("String is non added to file!");
        }
    }
    boolean writeAddInFileInThisCataloge(String nameFile, String addToFile){
        try {
            if (hasFileInCataloge(nameFile)){
                this.pathInFile=this.pathInCataloge+"/"+nameFile;
                writeAddInLastFile(addToFile);
                return true;
            }
        }catch (NullPointerException e){
            System.out.println("Name of file is incorrect!");
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        FileWriterTask1 fileWriterTask1 = new FileWriterTask1("Test1Exeptions");
        fileWriterTask1.showFile("/home/jon/IdeaProjects/JavaFundamentals/src/main/resources/");
        fileWriterTask1.deleteFileInThisCataloge("TestExseptionsModule.txt");
        fileWriterTask1.creatFileInThisCataloge("TestExseptionsModule.txt");
        fileWriterTask1.writeAddInLastFile("First string!");
        fileWriterTask1.writeAddInFileInThisCataloge("TestExseptionsModule.txt", "Second string");
        fileWriterTask1.deleteFileInThisCataloge("TestExseptionsModule.txt");
    }

}