package com.martina.tpfinal.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
}
