package com.service;

import com.dao.TeacherDao;
import com.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yangzl 2020.09.04
 * @version 1.00.00
 * @Description:
 * @history:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TeacherService {

    @Autowired
    private TeacherDao _tTeacherDao;

    public void save() {

        for(int i=0; i<100; i++) {
            Teacher teacher = new Teacher();
            teacher.settId(Long.valueOf(i));
            teacher.settName("test" + i);
            _tTeacherDao.save(teacher);
        }
    }
}
