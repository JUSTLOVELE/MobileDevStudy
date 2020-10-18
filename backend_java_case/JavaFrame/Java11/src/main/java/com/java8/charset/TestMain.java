package com.java8.charset;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class TestMain {

    @Test
    public void case01() {

        String str = new String("hellow".getBytes(), StandardCharsets.UTF_8);
    }
}
