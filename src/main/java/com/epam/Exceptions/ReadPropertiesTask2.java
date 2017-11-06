package com.epam.Exceptions;

import java.io.UnsupportedEncodingException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class ReadPropertiesTask2 {


    //private String pathFileProp;
    private ResourceBundle resourceBundle;
    void readPropFile(String nameProperty) throws SecurityException{

        try {

            if(nameProperty==null){throw new NullPointerException("File nme is Null");}

                this.resourceBundle = ResourceBundle.getBundle(nameProperty);
               // this.pathFileProp=nameProperty;
                System.out.println("Property file is read!");


        }catch (NullPointerException e){
            System.out.println("Patch to file is Null");
        }catch (MissingResourceException e){
            System.out.println("File not found!");
        }


    }

    String getObject(String key){
      try {
       return resourceBundle.getString(key);
    }catch (MissingResourceException e){
          System.out.println("key is not in the file!");
          return "Key is not found!";
      }
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

        ReadPropertiesTask2 readPropertiesTask2=new ReadPropertiesTask2();
        readPropertiesTask2.readPropFile("FailedPatch");
        readPropertiesTask2.readPropFile(null);
        readPropertiesTask2.readPropFile("prop");
        String st =readPropertiesTask2.getObject("prop.key1");
        String s1 = new String(st.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(s1);
        System.out.println(readPropertiesTask2.getObject("key100"));


    }

}
