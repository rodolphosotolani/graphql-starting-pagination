package br.com.rts.estudos.graphql.startingpagination.dataloader;

import br.com.rts.estudos.graphql.startingpagination.entities.Address;
import br.com.rts.estudos.graphql.startingpagination.entities.Person;
import br.com.rts.estudos.graphql.startingpagination.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoaderCommandRunner implements CommandLineRunner {

    private static final int COUNT_PERSONS = 50;

    private final PersonRepository personRepository;
    private final Faker faker;
    
    @Override
    public void run(String... args) throws Exception {

        for (int count = 0; count < COUNT_PERSONS; count++) {

            personRepository
                    .save(Person
                            .builder()
                            .firstName(faker.name().firstName())
                            .lastName(faker.name().lastName())
                            .phoneNumber(faker.phoneNumber().phoneNumber())
                            .email(faker.internet().emailAddress())
                            .address(Address
                                    .builder()
                                    .address(faker.address().streetAddress())
                                    .city(faker.address().city())
                                    .state(faker.address().state())
                                    .zipCode(faker.address().zipCode())
                                    .build())
                            .build());
        }

    }
}
