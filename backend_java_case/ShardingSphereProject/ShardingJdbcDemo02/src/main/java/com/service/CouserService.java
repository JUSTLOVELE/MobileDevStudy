package com.service;

import com.dao.CouserDao;
import com.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yangzl 2020.09.02
 * @version 1.00.00
 * @Description:
 * @history:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CouserService {

    @Autowired
    private CouserDao _couserDao;

    //奇数cid测试
    public void save01() {

        Course course = new Course();
        course.setCid(111L);
        course.setCname("test");
        course.setUserId(101L);
        course.setcStatus("normal");
        _couserDao.save(course);
    }

    //偶数cid测试
    public void save02() {

        Course course = new Course();
        course.setCid(112L);
        course.setCname("test");
        course.setUserId(100L);
        course.setcStatus("normal");
        _couserDao.save(course);
    }

}
