package com.ex.batchprocessing.process;

import com.ex.batchprocessing.model.Person;
import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, String> {
    @Override
    public String process(Person person) throws Exception {
        String greeting = "Hello " + person.getFirstName() + " "
                + person.getLastName() + "!";
        System.out.println(greeting);
        return greeting;
    }
}
