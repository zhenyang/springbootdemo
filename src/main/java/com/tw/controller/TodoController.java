package com.tw.controller;

import com.tw.domain.Todo;
import com.tw.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "todos")
public class TodoController {
    @Autowired
    TodoRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> getAll() {
        return repository.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Todo get(@PathVariable String id) {
        return repository.findOne(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        repository.save(todo);
        return new ResponseEntity<>(todo, null, HttpStatus.CREATED);
    }
}
