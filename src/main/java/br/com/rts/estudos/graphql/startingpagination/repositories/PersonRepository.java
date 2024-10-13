package br.com.rts.estudos.graphql.startingpagination.repositories;

import br.com.rts.estudos.graphql.startingpagination.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
