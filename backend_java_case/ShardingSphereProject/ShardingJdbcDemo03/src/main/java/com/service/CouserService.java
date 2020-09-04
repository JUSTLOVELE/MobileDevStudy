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

    public void save() {

        for(int i=0; i<100; i++) {

            Course course = new Course();
            course.setCid(Long.valueOf(i));
            course.setCname("test");
            course.setUserId(Long.valueOf(i));
            course.setcStatus("normal");
            _couserDao.save(course);

        }
    }

}
