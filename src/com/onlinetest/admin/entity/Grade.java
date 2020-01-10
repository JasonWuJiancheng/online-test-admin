package com.onlinetest.admin.entity;

/**
 * @author JasonWu
 * @create 2020-01-10-22:33
 */
public class Grade {

    private String gradeId;
    private String name;

    public Grade(String gradeId, String name) {
        this.gradeId = gradeId;
        this.name = name;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId='" + gradeId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
