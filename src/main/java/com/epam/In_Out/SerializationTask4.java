package com.epam.In_Out;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationTask4 implements Serializable{

    private List<String> collectionFilms;
    private String nameColection;

    public SerializationTask4(String nameColection ) {
        collectionFilms=new ArrayList<>();
        this.nameColection=nameColection;
    }
    void addFilmToColection(String film){
        collectionFilms.add(film);
    }
    boolean deleteFilmFromColection(String film){
        return collectionFilms.remove(film);
    }
    void showColection(){
        System.out.println("Name of collection: "+nameColection);
        for (String collectionFilm : collectionFilms) {
            System.out.println(collectionFilm);
        }
    }
    void saveColection(String patch){
        try (FileOutputStream outputStream = new FileOutputStream("/home/jon/IdeaProjects/JavaFundamentals/src/main/resources/" +
                "TestInputStreamTask1.txt");
             //ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream))
        {
            objectOutputStream.writeObject(this);
            System.out.println("Object is serialization!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    SerializationTask4 loadColection(String patch)  {
        try (FileInputStream fileInput= new FileInputStream(patch)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInput);
            SerializationTask4 Test4 = (SerializationTask4) objectInputStream.readObject();
            System.out.println("Object is deserialization!");
            return Test4;
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        SerializationTask4 serializationTask4=new SerializationTask4("Horror");
        serializationTask4.addFilmToColection("It");
        serializationTask4.addFilmToColection("The Mist");
        serializationTask4.addFilmToColection("Sow");
        serializationTask4.showColection();
        serializationTask4.deleteFilmFromColection("It");
        serializationTask4.showColection();
        serializationTask4.saveColection("/home/jon/IdeaProjects/JavaFundamentals/src/main/resources/" +
                "TestInputStreamTask1.txt");
        System.out.println("+++++++++++++++++++++++++++++++++");
        SerializationTask4 DesColection=serializationTask4.loadColection("/home/jon/IdeaProjects/JavaFundamentals/src/main/resources/" +
                "TestInputStreamTask1.txt");
        DesColection.showColection();









    }
}
