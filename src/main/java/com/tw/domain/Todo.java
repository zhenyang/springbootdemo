package com.tw.domain;

import org.springframework.data.annotation.Id;

public class Todo {
    @Id
    private String id;
    private String title;
    private boolean archived;
    private boolean done;

    public Todo() {
    }

    public Todo(String title, boolean archived, boolean done) {
        this.title = title;
        this.archived = archived;
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public boolean isArchived() {
        return archived;
    }

    public boolean isDone() {
        return done;
    }
}
