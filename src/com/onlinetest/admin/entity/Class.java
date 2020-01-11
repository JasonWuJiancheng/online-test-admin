package com.onlinetest.admin.entity;

/**
 * @author JasonWu
 * @create 2020-01-11-13:46
 */
public class Class {

    private String classId;
    private String majorId;
    private String majorName;
    private String gradeId;
    private String gradeName;
    private String name;

    public Class(String classId, String majorId, String gradeId, String name) {
        this.classId = classId;
        this.majorId = majorId;
        this.gradeId = gradeId;
        this.name = name;
    }

    public Class(String classId, String majorId, String majorName, String gradeId, String gradeName, String name) {
        this.classId = classId;
        this.majorId = majorId;
        this.majorName = majorName;
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.name = name;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Class{" +
                "classId='" + classId + '\'' +
                ", majorId='" + majorId + '\'' +
                ", majorName='" + majorName + '\'' +
                ", gradeId='" + gradeId + '\'' +
                ", gradeName='" + gradeName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
