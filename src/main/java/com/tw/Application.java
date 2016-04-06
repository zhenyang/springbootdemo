package com.tw;

import com.tw.domain.People;
import com.tw.repository.PeopleRepository;
import com.tw.util.ExternalConfigComponent;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(new Object[]{ExternalConfigComponent.class});

        springApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(PeopleRepository peopleRepository) {
        return (evt) ->
        {
            peopleRepository.deleteAll();
            Arrays.asList("jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
                    .forEach(a -> {
                        peopleRepository.save(new People(a, a));
                    });
        };
    }
}
