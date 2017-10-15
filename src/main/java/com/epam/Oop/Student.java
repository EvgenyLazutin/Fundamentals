package com.epam.Oop;

import java.util.ArrayList;
import java.util.Comparator;

public class Student implements Comparator<DisciplineOfStudent> {
    private String nameOfStudent;
    private int groupOfStudens;
    private ArrayList<DisciplineOfStudent> discipliceOfStedent;

    @Override
    public int compare(DisciplineOfStudent a, DisciplineOfStudent b) {

        return (a.getAssessment().compareTo(b.getAssessment()));
    }

    public Student(String nameOfStudent, int groupOfStudens) {
        this.nameOfStudent = nameOfStudent;
        this.groupOfStudens = groupOfStudens;
        discipliceOfStedent=new ArrayList<DisciplineOfStudent>();

    }
    public void addDiscipline(DisciplineOfStudent tmp){
        this.discipliceOfStedent.add(tmp);
    }

    public static void main(String[] args) {
Student TestStudent=new Student("Alex",102);
TestStudent.addDiscipline(new DisciplineOfStudent(DisciplineForStudent.MATHEMATICS,"5"));
TestStudent.addDiscipline(new DisciplineOfStudent(DisciplineForStudent.CHEMICALS,"3"));
TestStudent.addDiscipline(new DisciplineOfStudent(DisciplineForStudent.LITERATURE,"Assessment"));

    }
}
