package com.epam.maksym_yena.java.lecture_7.task_5.data;

public class Curriculum {

    private String nameCurriculum;

    public Curriculum(String nameCurriculum) {
        this.nameCurriculum = nameCurriculum;
    }

    public String getNameCurriculum() {
        return nameCurriculum;
    }

    public void setNameCurriculum(String nameCurriculum) {
        this.nameCurriculum = nameCurriculum;
    }

    @Override
    public String toString() {
        return nameCurriculum;
    }
}
