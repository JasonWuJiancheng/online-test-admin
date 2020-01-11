package com.onlinetest.admin.dao;

import com.onlinetest.admin.entity.Major;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-11-1:11
 */
public interface MajorDao {

    List<Major> selectAll();

    Major selectByKeyWord();

    //返回刚插入的数据uuid
    String insert(Major major);

    int deleteById(String majorId);

    int update(Major major);
}
