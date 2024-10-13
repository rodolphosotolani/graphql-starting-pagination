package br.com.rts.estudos.graphql.startingpagination;

import net.datafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StartingPaginationApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartingPaginationApplication.class, args);
    }

    @Bean
    public Faker getFaker(){
        return new Faker();
    }
}
