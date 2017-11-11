package com.epam.Exceptions;

import java.io.UnsupportedEncodingException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

public class ReadPropertiesTask2 {


    //private String pathFileProp;
    private ResourceBundle resourceBundle;
  public boolean readPropFile(String nameProperty) throws SecurityException{

        try {

            if(nameProperty==null){throw new NullPointerException("File nme is Null");}

                this.resourceBundle = ResourceBundle.getBundle(nameProperty);
               // this.pathFileProp=nameProperty;
                System.out.println("Property file is read!");
                return true;

        }catch (NullPointerException e){
            System.out.println("Patch to file is Null");
            return false;
        }catch (MissingResourceException e){
            System.out.println("File not found!");
            return false;
        }


    }

   public String getObject(String key){
      try {
       return resourceBundle.getString(key);
    }catch (MissingResourceException e){
          System.out.println("key is not in the file!");
          return "Key is not found!";
      }
    }

    public Set<String> getKeyProperties(){
        return resourceBundle.keySet();
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
