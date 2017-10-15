package com.epam.Intro;

public class Main {

    public static void main(String[] args) {
       int tmp[]={2,-4,6767,7,789,55,-45,1, 88, 47};
Task_2.numberOfElSmollerE(tmp);
IntroTask3 TestIntroTask3=new IntroTask3(1,10);
TestIntroTask3.FunctionF(2);
IntroTask4 TestIntroTask4=new IntroTask4(10,3,67,3,100,45,30000,44,2,1,5);
TestIntroTask4.SearchMaxValue();
IntroTask5 TestIntroTask5=new IntroTask5(8,8);
TestIntroTask5.printMatrica();

IntroTask6NoteChange Test6IntroTask6NoteChange=new IntroTask6NoteChange(10);
Test6IntroTask6NoteChange.addNote("First");
Test6IntroTask6NoteChange.addNote("Second");
Test6IntroTask6NoteChange.addNote("Third");
Test6IntroTask6NoteChange.addNote("Fourth");
Test6IntroTask6NoteChange.getAllNote();
Test6IntroTask6NoteChange.deleteNote(1);
Test6IntroTask6NoteChange.getAllNote();
    }
}

