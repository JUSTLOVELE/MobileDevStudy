package com.control;

import com.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
public class HelloAction {

    private static final String TEMPLATE = "HELLO, %s!";

    @RequestMapping("/greeting")
    public HttpEntity<User> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        User user = new User(String.format(TEMPLATE, name));
        user.add(linkTo(methodOn(HelloAction.class).greeting(name)).withSelfRel());

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping("/user")
    public User user(@RequestParam(value = "name", defaultValue = "World") String name) {

        User user = new User(String.format(TEMPLATE, name));
        user.add(linkTo(methodOn(HelloAction.class).greeting(name)).withSelfRel());

        return user;
    }
}
