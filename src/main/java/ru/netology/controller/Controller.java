package ru.netology.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.netology.model.PERSONS;
import ru.netology.repository.Repos;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/persons")
public class Controller {

    @Autowired
    Repos reposiroty;

    @GetMapping("/by-city")
    protected List<PERSONS> getPersonsByCity(@RequestParam (value = "city", required = false) String city) {
        return reposiroty.getPersonsByCity(city);
    }
}

// http://localhost:8080/persons/by-city?city=Paris