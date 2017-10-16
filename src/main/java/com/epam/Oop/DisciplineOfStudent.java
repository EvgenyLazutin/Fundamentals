package com.epam.Oop;

import java.util.Comparator;

public class DisciplineOfStudent implements Comparator<DisciplineOfStudent> {
    private DisciplineForStudent discipline;
    private String assessment;

    public DisciplineOfStudent(DisciplineForStudent discipline, String assessment) {
        this.discipline = discipline;
        this.assessment = assessment;
    }

    public DisciplineOfStudent() {
    }

    @Override
    public int compare(DisciplineOfStudent a, DisciplineOfStudent b) {

        return (a.getAssessment().compareTo(b.getAssessment()));
    }
    public DisciplineForStudent getDiscipline() {
        return discipline;
    }

    public String getAssessment() {
        return assessment;
    }
}
