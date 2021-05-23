package com.example.component;

import com.example.model.Person;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

    /**
     * 使用SpEL表达式
     * @param person
     * @throws Exception
     */
    @EventListener(condition = "#person.name!=null")
    public void handleEvent(Person person) throws Exception{
        System.out.println(person.toString());
    }

}
