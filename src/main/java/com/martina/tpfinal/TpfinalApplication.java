package com.martina.tpfinal;

import com.martina.tpfinal.model.Status;
import com.martina.tpfinal.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;

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

            //punto A: Listar todos los cursos
            courseRepository.findAllCourses();

            //PUNTO B: Listar todos los estudiantes
            studentRepository.findAllStudents();

            //PUNTO C: Listar todos los estudiantes que tengan un dni mayor a 20M y que su apellido  “Romero”
            studentRepository.findAllStudentsByDNIGreaterThan20MAndSurnameIsRomero();

            //PUNTO D: Listar todas las inscripciones rechazadas o pendiente
            inscriptionRepository.findAllInscriptionsRefusedORPending();

            //PUNTO E: Implementar las consultas (A, B, C y D) mediante *consulta derivada*

            //PUNTO E -> A
            courseRepository.findAll();

            //PUNTO E -> B
            studentRepository.findAll();

            //PUNTO E -> C
            studentRepository.findByDniGreaterThanAndSurnameEquals(20000000, "Romero");
            studentRepository.findByDniGreaterThanAndSurname(20000000, "Romero");

            //PUNTO E -> D
            inscriptionRepository.findByStatusIn(List.of(Status.PENDIENTE, Status.ACEPTADA));


            //PUNTO F: Listar todos los cursos que hayan empezado después de “01/02/2020”
            courseRepository.findAllByStartDateAfter(LocalDate.of(2020, 2, 1));

            //PUNTO G: Listar todas las inscripciones en base a un parámetro de estado
            inscriptionRepository.findInscriptionsByStatus(Status.ACEPTADA);

            //PUNTO H: Listar todas las inscripciones en base a un parámetro de estado utilizando consulta nativa
            inscriptionRepository.findInscriptionsByStatusNative(Status.RECHAZADA.toString());


            //PUNTO I: Listar todos los estudiantes de forma paginada y ordenada ascendente por DNI.

            //A: pagina 1, tamaño 5
            studentRepository.findAllByOrderByDniAsc(PageRequest.of(1, 5));

            //B: pagina 0, tamaño 2
            studentRepository.findAllByOrderByDniAsc(PageRequest.of(0, 2));
        };
    }

}
