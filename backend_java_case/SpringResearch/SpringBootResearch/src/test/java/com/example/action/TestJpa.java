package com.example.action;

import com.example.DemoApplication;
import com.example.service.TeacherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest(classes = {DemoApplication.class})
public class TestJpa {

    @Autowired
    private TeacherService _teacherService;

    @Test
    public void queryPagin() {
        _teacherService.queryPagin();
    }

    @Test
    public void saveTest() {
        _teacherService.saveTeacher(UUID.randomUUID().toString(), "测试名字1");
    }

    @Test
    public void updateTest() {

        String opId = "3a405b46-4e68-4dba-8744-933d6526ade4";
        _teacherService.updateName(opId, "更新名字");
    }

    @Test
    public void queryWithName() {
        _teacherService.queryWithName("更新名字");
    }

    @Test
    public void queryWithNameList() {
        _teacherService.queryWithNameList("更新名字");
    }

    @Test
    public void saveWithException() {

        try{
            _teacherService.saveWithException();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

}
