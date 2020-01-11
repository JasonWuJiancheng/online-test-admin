package com.onlinetest.admin.service.impl;

import com.onlinetest.admin.dao.MajorDao;
import com.onlinetest.admin.dao.impl.MajorDaoImpl;
import com.onlinetest.admin.entity.Major;
import com.onlinetest.admin.service.MajorService;

import java.util.List;

/**
 * @author JasonWu
 * @create 2020-01-11-1:17
 */
public class MajorServiceImpl implements MajorService {

    private MajorDao majorDao = new MajorDaoImpl();

    @Override
    public List<Major> getAllMajor() {
        return majorDao.selectAll();
    }

    @Override
    public int updateMajor(Major major) {
        return majorDao.update(major);
    }

    @Override
    public int deleteMajor(Major major) {
        return majorDao.deleteById(major.getMajorId());
    }

    @Override
    public int deleteMajors(List<Major> majors) {
        int res = 0;
        if(majors!=null){
            for(Major major : majors){
                majorDao.deleteById(major.getMajorId());
            }
        }
        return res;
    }

    @Override
    public String insertMajor(Major major) {
        return majorDao.insert(major);
    }
}
