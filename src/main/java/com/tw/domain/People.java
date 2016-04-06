package com.tw.domain;

import org.springframework.data.annotation.Id;

public class People {
    @Id
    private String id;
    private String firstName;
    private String lastName;

    public People() {
    }

    public People(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }
}
