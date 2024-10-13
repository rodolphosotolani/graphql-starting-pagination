package br.com.rts.estudos.graphql.startingpagination.controllers;

import br.com.rts.estudos.graphql.startingpagination.entities.Person;
import br.com.rts.estudos.graphql.startingpagination.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PersonGraphController {

    private final PersonRepository personRepository;

    @QueryMapping
    public List<Person> allPerson(){
        return personRepository.findAll();
    }

    @QueryMapping
    public Page<Person> allPersonPaged(@Argument int page, @Argument int size){
        return personRepository.findAll(PageRequest.of(page, size));
    }

}
