package com.example.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FormModel {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 5, max = 25)
    private String username;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
