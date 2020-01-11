package com.onlinetest.admin.service;

import com.onlinetest.admin.entity.Major;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-11-1:16
 */
public interface MajorService {

    List<Major> getAllMajor();

    int updateMajor(Major major);

    int deleteMajor(Major major);

    int deleteMajors(List<Major> majors);

    String insertMajor(Major major);

}
