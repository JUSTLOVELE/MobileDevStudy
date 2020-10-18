package com.exmaple.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

public class Greeting_v2 extends RepresentationModel<Greeting_v2> {

    private final String content;

    @JsonCreator
    public Greeting_v2(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
