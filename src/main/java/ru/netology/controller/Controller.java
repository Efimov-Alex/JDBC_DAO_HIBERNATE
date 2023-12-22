package ru.netology.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.netology.model.PERSONS;
import ru.netology.repository.Repos;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class Controller {

    @Autowired
    private final Repos repository;


    @GetMapping("/by-city")
    protected List<PERSONS> findPersonByCityOfLiving(@RequestParam (value = "city", required = false) String city) {
        return repository.findPersonByCityOfLiving(city);
    }
    @GetMapping("/by-age")
    protected List<PERSONS> findPersonByContact_AgeLessThanOrderByContactAsc(@RequestParam(value = "age", required = false) Integer age){
        return repository.findPersonByContact_AgeLessThanOrderByContactAsc(age);
    }

    @GetMapping("/by-name&surname")
    protected Optional<PERSONS> findPersonByContact_NameAndContact_Surname(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "surname", required = false) String surname){
        return repository.findPersonByContact_NameAndContact_Surname(name, surname);
    }

}
/*
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
// http://localhost:8080/persons/by-age?age=21
// http://localhost:8080/persons/by-name&surname?name=alex&surname=smirnov

 */