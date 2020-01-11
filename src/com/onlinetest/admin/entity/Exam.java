package com.onlinetest.admin.entity;

/**
 * @author JasonWu
 * @create 2020-01-11-21:10
 */
public class Exam {

    private String examId;
    private String examName;
    private String eTypeId;
    private String teaId;
    private String courseId;
    private String sTime;
    private String eTime;
    private int isComp; //是否阅卷
    private int isJoin; //是否添加题库
    private String cTime;  //封卷时间

    private String eTypeName;
    private String teaName;
    private String courseName;

    public Exam(String examId, String examName, String eTypeId, String teaId, String courseId, String sTime, String eTime, int isComp, int isJoin, String cTime) {
        this.examId = examId;
        this.examName = examName;
        this.eTypeId = eTypeId;
        this.teaId = teaId;
        this.courseId = courseId;
        this.sTime = sTime;
        this.eTime = eTime;
        this.isComp = isComp;
        this.isJoin = isJoin;
        this.cTime = cTime;
    }

    public Exam(String examId, String examName, String eTypeId, String teaId, String courseId, String sTime, String eTime, int isComp, int isJoin, String cTime, String eTypeName, String teaName, String courseName) {
        this.examId = examId;
        this.examName = examName;
        this.teaId = teaId;
        this.eTypeId = eTypeId;
        this.courseId = courseId;
        this.sTime = sTime;
        this.eTime = eTime;
        this.isComp = isComp;
        this.isJoin = isJoin;
        this.cTime = cTime;
        this.eTypeName = eTypeName;
        this.teaName = teaName;
        this.courseName = courseName;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public String geteTypeId() {
        return eTypeId;
    }

    public void seteTypeId(String eTypeId) {
        this.eTypeId = eTypeId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public int getIsComp() {
        return isComp;
    }

    public void setIsComp(int isComp) {
        this.isComp = isComp;
    }

    public int getIsJoin() {
        return isJoin;
    }

    public void setIsJoin(int isJoin) {
        this.isJoin = isJoin;
    }

    public String getcTime() {
        return cTime;
    }

    public void setcTime(String cTime) {
        this.cTime = cTime;
    }

    public String geteTypeName() {
        return eTypeName;
    }

    public void seteTypeName(String eTypeName) {
        this.eTypeName = eTypeName;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId='" + examId + '\'' +
                ", examName='" + examName + '\'' +
                ", teaId='" + teaId + '\'' +
                ", eTypeId='" + eTypeId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", sTime='" + sTime + '\'' +
                ", eTime='" + eTime + '\'' +
                ", isComp=" + isComp +
                ", isJoin=" + isJoin +
                ", cTime='" + cTime + '\'' +
                ", eTypeName='" + eTypeName + '\'' +
                ", teaName='" + teaName + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
