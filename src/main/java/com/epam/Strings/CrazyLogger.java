package com.epam.Strings;

import com.epam.Oop.ClassPreamble;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@ClassPreamble(
        date = "17.10.1017"
)
public class CrazyLogger {
    private StringBuilder logger;
    private int countLoger;

    public CrazyLogger() {
        this.logger = new StringBuilder();
    }
    void addLog(String message){

        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-YYYY : HH-mm");
        logger.append(formatter.format(ZonedDateTime.now())+"- "+ message);
        countLoger++;
    }

    void findInformation(String find){
        int tmp= logger.indexOf(find);
        if(tmp!=-1){
            System.out.println(logger.substring(tmp,tmp+30));
        }else{
            System.out.println("Strings not found!");
        }
    }
    public static void main(String[] args) {
        CrazyLogger logerTest=new CrazyLogger();
        logerTest.addLog("First log");
        logerTest.addLog("Second log");
        logerTest.addLog("end log");
        logerTest.findInformation("Second");
        logerTest.findInformation("GGGGG");
    }

}
