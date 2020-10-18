package com.example.action;

import com.example.DemoApplication;
import com.example.service.TeacherCrudService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {DemoApplication.class})
public class TestCrudJPA {

    @Autowired
    private TeacherCrudService _teacherCrudService;

    @Test
    public void findByTeacherName() {
        _teacherCrudService.findByTeacherName("测试名字1");
    }
}
