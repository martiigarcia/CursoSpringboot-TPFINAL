package com.martina.tpfinal;

import com.martina.tpfinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TpfinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpfinalApplication.class, args);
    }

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    InscriptionRepository inscriptionRepository;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            //para probar el courserepository
            courseRepository.findAll();

            //para probar el studentrepository
            studentRepository.findAll();

            //para probar el inscriptionrepository
            inscriptionRepository.findAll();
        };
    }

}
