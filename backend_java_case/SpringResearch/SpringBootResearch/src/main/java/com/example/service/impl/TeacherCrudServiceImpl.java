package com.example.service.impl;

import com.example.dao.TeacherCrudDao;
import com.example.entity.TeacherEntity;
import com.example.service.TeacherCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;

@Service
@Transactional(rollbackFor = Exception.class)
public class TeacherCrudServiceImpl implements TeacherCrudService {

    @Autowired
    private TeacherCrudDao _teacherCrudDao;

    @Override
    public void findByTeacherName(String name) {

        PageRequest pageRequest = PageRequest.of(2, 15);
        Page<TeacherEntity> pages = _teacherCrudDao.findByTeacherName(name, pageRequest);
        Iterator<TeacherEntity> iterator = pages.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
