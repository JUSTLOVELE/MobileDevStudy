package com.example.action;

import java.util.Random;

import com.exmaple.util.Greeting_v2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exmaple.util.Greeting;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/**
 * @RestController 包含 @Controller和@RsponseBody
 * @author yangzuliang
 *
 */
@RestController
public class GreetingAction {

	private static final String TEMPLATE = "Hello, %s!";

	@RequestMapping("/greeting_v2")
	public HttpEntity<Greeting_v2> greeting_v2(
			@RequestParam(value = "name", defaultValue = "World") String name) {

		Greeting_v2 greeting = new Greeting_v2(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingAction.class).greeting(name)).withSelfRel());

		return new ResponseEntity<>(greeting, HttpStatus.OK);
	}


	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		Greeting g = new Greeting(new Random().nextLong(), name);
		return g;
	}
}
