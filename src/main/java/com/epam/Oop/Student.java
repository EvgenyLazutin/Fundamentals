package com.epam.Oop;

import java.util.ArrayList;
import java.util.Collections;

import static com.epam.Oop.DisciplineForStudent.*;

public class Student  {
    private String nameOfStudent;
    private int groupOfStudens;
    private ArrayList<DisciplineOfStudent> discipliceOfStedent;


    Student(String nameOfStudent, int groupOfStudens) {
        this.nameOfStudent = nameOfStudent;
        this.groupOfStudens = groupOfStudens;
        discipliceOfStedent=new ArrayList<DisciplineOfStudent>();

    }
    void addDiscipline(DisciplineOfStudent tmp){
        this.discipliceOfStedent.add(tmp);
    }

    @Override
    public String toString() {
        return "Student{" +
                "discipliceOfStedent=" + discipliceOfStedent +
                '}';
    }

    void sortStudentAssesment(){
        Collections.sort(discipliceOfStedent,new DisciplineOfStudent());

    }
    public static void main(String[] args) {
Student TestStudent=new Student("Alex",102);
TestStudent.addDiscipline(new DisciplineOfStudent(MATHEMATICS,"5"));
TestStudent.addDiscipline(new DisciplineOfStudent(CHEMICALS,"3"));
TestStudent.addDiscipline(new DisciplineOfStudent(LITERATURE,"Assessment"));
TestStudent.sortStudentAssesment();
        System.out.println(TestStudent.toString());

    }
}
