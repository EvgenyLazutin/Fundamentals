package com.epam.Oop;

public class DisciplineOfStudent {
    private DisciplineForStudent discipline;
    private String assessment;

    public DisciplineOfStudent(DisciplineForStudent discipline, String assessment) {
        this.discipline = discipline;
        this.assessment = assessment;
    }

    public DisciplineForStudent getDiscipline() {
        return discipline;
    }

    public String getAssessment() {
        return assessment;
    }
}
