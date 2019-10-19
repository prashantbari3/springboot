package com.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParentController {

    @Autowired
    private ParentRepository repository;

    // Find
    @GetMapping("/parents")
    List<Parent> findAll() {
        return repository.findAll();
    }


}
