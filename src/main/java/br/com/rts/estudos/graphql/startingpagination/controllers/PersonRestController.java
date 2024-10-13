package br.com.rts.estudos.graphql.startingpagination.controllers;

import br.com.rts.estudos.graphql.startingpagination.entities.Person;
import br.com.rts.estudos.graphql.startingpagination.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonRestController {

    private final PersonRepository personRepository;

    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson() {
        return ResponseEntity
                .ok(personRepository.findAll());
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Person>> getAllPerson(@RequestParam Integer page,
                                                     @RequestParam Integer size) {

        return ResponseEntity
                .ok(personRepository.findAll(
                        PageRequest.of(page, size)));
    }

}
