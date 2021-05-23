package com.example.component;

import com.example.model.TestEventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TestNoAnnotationListener implements ApplicationListener<TestEventModel> {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void onApplicationEvent(TestEventModel event) {
        System.out.println("非注解监听器：" + event.getMsg());
    }

    /**
     *  事件发布方法
     */
    public void pushListener(String msg) {
        applicationEventPublisher.publishEvent(new TestEventModel(this, msg));
    }
}
