package com.onlinetest.admin.entity;

/**
 * @author JasonWu
 * @create 2020-01-11-1:10
 */
public class Major {

    private String majorId;
    private String name;

    public Major(String majorId, String name) {
        this.majorId = majorId;
        this.name = name;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId='" + majorId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
