package com.tw.controller;

import com.tw.domain.People;
import com.tw.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "people")
public class PeopleController {
    @Autowired
    PeopleRepository peopleRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<People> getAll() {
        return peopleRepository.findAll();
    }

    @RequestMapping(path = "/{id}",method = RequestMethod.GET)
    public People get(@PathVariable String id) {
        return peopleRepository.findOne(id);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<People> create(@RequestBody People people) {
        peopleRepository.save(people);
        return new ResponseEntity<>(people, null, HttpStatus.CREATED);
    }
}
