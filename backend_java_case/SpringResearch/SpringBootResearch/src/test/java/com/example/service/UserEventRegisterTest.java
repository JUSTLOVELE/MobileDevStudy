package com.example.service;

import com.example.DemoApplication;
import com.example.component.TestNoAnnotationListener;
import org.junit.jupiter.api.Test;
import com.example.component.UserEventRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {DemoApplication.class})
public class UserEventRegisterTest {

    @Autowired
    private UserEventRegister _userEventRegister;

    @Autowired
    private TestNoAnnotationListener _testNoAnnotationListener;

    @Test
    public void noAnnotationListenerTest() {
        _testNoAnnotationListener.pushListener("hello ");
    }

    @Test
    public void  UserEventRegisterTest() {
        try{
            _userEventRegister.register();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
