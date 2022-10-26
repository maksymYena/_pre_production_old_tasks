package com.epam.maksym_yena.java.lecture_7.task_5.data;

public class Student {
    private String nameStudent;
    private Curriculum curriculumStudent;

    public Student(String nameStudent, Curriculum curriculumStudent)  {
        this.nameStudent = nameStudent;
        this.curriculumStudent = curriculumStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Curriculum getCurriculumStudend() {
        return curriculumStudent;
    }


    public void setCurriculumStudend(Curriculum curriculumStudend) {
        this.curriculumStudent = curriculumStudend;
    }

    @Override
    public String toString() {
        return "Student: " + nameStudent + "\n" +
                "CURRICULUM:"  + curriculumStudent + "\n";
    }
}
