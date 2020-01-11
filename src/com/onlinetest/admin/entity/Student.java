package com.onlinetest.admin.entity;

/**
 * @author JasonWu
 * @create 2020-01-11-15:40
 */
public class Student {

    private String studentId;
    private String studentNum;
    private String name;
    private String pwd;

    private String majorId;
    private String majorName;
    private String gradeId;
    private String gradeName;
    private String classId;
    private String className;

    public Student(String studentId, String studentNum, String name, String pwd, String classId) {
        this.studentId = studentId;
        this.studentNum = studentNum;
        this.name = name;
        this.pwd = pwd;
        this.classId = classId;
    }

    public Student(String studentId, String studentNum, String name, String pwd, String majorId, String majorName, String gradeId, String gradeName, String classId, String className) {
        this.studentId = studentId;
        this.studentNum = studentNum;
        this.name = name;
        this.pwd = pwd;
        this.majorId = majorId;
        this.majorName = majorName;
        this.gradeId = gradeId;
        this.gradeName = gradeName;
        this.classId = classId;
        this.className = className;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
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

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentNum='" + studentNum + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", majorId='" + majorId + '\'' +
                ", majorName='" + majorName + '\'' +
                ", gradeId='" + gradeId + '\'' +
                ", gradeName='" + gradeName + '\'' +
                ", classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
