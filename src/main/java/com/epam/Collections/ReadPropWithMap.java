package com.epam.Collections;

import com.epam.Exceptions.ReadPropertiesTask2;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ReadPropWithMap {
    private ReadPropertiesTask2 readPropertiesTask2=new ReadPropertiesTask2();
    private Map<String,String> mapResursProp=new HashMap<>();

    void readPropFile(String nameProperty){

        if (readPropertiesTask2.readPropFile(nameProperty)){
            Set<String> setKeyProp = readPropertiesTask2.getKeyProperties();
            for (String stringSetTmp:
                 setKeyProp) {
                mapResursProp.put(stringSetTmp,readPropertiesTask2.getObject(stringSetTmp));
            }

        }

    }
    String getValuePropFromMap(String key){
        String nullCheck= mapResursProp.get(key);
        if(nullCheck!=null)return nullCheck;
        System.out.println("Key is not found, please try again");
        return "Key is not found";
    }
    void printAllValues() throws UnsupportedEncodingException {
        for (String tmpStr:
            mapResursProp.values() ) {
            String s1 = new String(tmpStr.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println(s1);

        }

    }
    public static void main(String[] args) throws UnsupportedEncodingException {
       ReadPropWithMap readPropWithMap=new ReadPropWithMap();
        readPropWithMap.readPropFile("FailedPatch");
        readPropWithMap.readPropFile(null);
        readPropWithMap.readPropFile("prop");
        String st= readPropWithMap.getValuePropFromMap("prop.key1");
        String s1 = new String(st.getBytes("ISO-8859-1"), "UTF-8");
        System.out.println(s1);
        //readPropWithMap.printAllValues();
    }
}
