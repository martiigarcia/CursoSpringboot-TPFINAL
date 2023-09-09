package com.martina.tpfinal.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Builder
@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String surname;
    private String email;
    private int dni;
    private LocalDate birthDate;


    //true: mayor de edad
    //false: menor de edad
    public boolean idAdult() {
        LocalDate currentDate = LocalDate.now(); //fecha de hoy
        LocalDate adultDate = birthDate.plusYears(18); // Calcula la fecha en la que se alcanza la mayoría de edad (18 años)

        return !currentDate.isBefore(adultDate); // Retorna true si la fecha actual no es antes de la fecha de mayoría de edad

    }
}
