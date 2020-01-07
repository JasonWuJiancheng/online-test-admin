package com.onlinetest.admin.entity;

/**
 * @author JasonWu
 * @create 2020-01-07-15:31
 */
public class ExamType {

    private String examTypeId;
    private String name;
    private String startTime;
    private String endTime;

    public ExamType() {
    }

    public ExamType(String examTypeId, String name, String startTime, String endTime) {
        this.examTypeId = examTypeId;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(String examTypeId) {
        this.examTypeId = examTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "ExamType{" +
                "examTypeId='" + examTypeId + '\'' +
                ", name='" + name + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
