package com.onlinetest.admin.entity;

/**
 * @author JasonWu
 * @create 2020-01-10-21:35
 */
public class Teacher {

    private String teacherId;
    private String name;

    public Teacher(String teacherId, String name) {
        this.teacherId = teacherId;
        this.name = name;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
