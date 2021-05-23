package com.example.component;

import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class UserEventRegister {

    @Autowired
    private ApplicationEventPublisher _eventPublisher;

    public void register() throws Exception {

        Person person = new Person("yzl", 29);
        //发布事件到UserEventListener中
        _eventPublisher.publishEvent(person);
    }
}
