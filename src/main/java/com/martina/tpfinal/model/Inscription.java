package com.martina.tpfinal.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Entity
@Table(name = "inscription")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private LocalDate date;
    private String state; //aceptada, rechazada, pendiente

    @ManyToOne
    private Course course;

    @ManyToOne
    private Student student;


}
