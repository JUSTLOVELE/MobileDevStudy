package com.example.service.impl;

import com.example.dao.TeacherDao;
import com.example.entity.TeacherEntity;
import com.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@Transactional(rollbackFor = Exception.class)
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherDao _teacherDao;

    @Override
    public void queryPagin() {

        PageRequest pageRequest = PageRequest.of(0, 15);
        Page<TeacherEntity> pages = _teacherDao.findAll(pageRequest);
        Iterator<TeacherEntity> iterator = pages.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }
    }

    @Override
    public void saveTeacher(String opId, String name) {

        TeacherEntity entity = new TeacherEntity();
        entity.setOpId(opId);
        entity.setTeacherName(name);
        _teacherDao.save(entity);
    }

    @Override
    public void updateName(String opId, String name) {
        _teacherDao.updateName(opId, name);
    }

    @Override
    public void queryWithName(String name) {
        TeacherEntity entity = _teacherDao.queryWithName(name);
        System.out.println(entity.toString());
    }

    @Override
    public void queryWithNameList(String name) {

        List<Map<String, Object>> list = _teacherDao.queryWithNameList(name);
        System.out.println(list.get(0));

        for(Map.Entry<String, Object> e: list.get(0).entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
    }

    @Override
    public void saveWithException() {

        TeacherEntity entity = new TeacherEntity();
        entity.setOpId("11");
        entity.setTeacherName("22");
        _teacherDao.save(entity);
        throw new RuntimeException("故意报错");
    }
}
