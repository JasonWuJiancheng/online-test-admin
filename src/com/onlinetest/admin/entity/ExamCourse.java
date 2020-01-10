package com.onlinetest.admin.entity;

import java.io.Serializable;

/**
 * @author JasonWu
 * @create 2020-01-07-15:31
 */
public class ExamCourse implements Serializable {

    private String examCourseId;
    private String name;
    private String startTime;
    private String endTime;

    public ExamCourse() {
    }

    public ExamCourse(String examCourseId, String name, String startTime, String endTime) {
        this.examCourseId = examCourseId;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getExamCourseId() {
        return examCourseId;
    }

    public void setExamCourseId(String examCourseId) {
        this.examCourseId = examCourseId;
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
        return "ExamCourse{" +
                "examCourseId='" + examCourseId + '\'' +
                ", name='" + name + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
