package com.martina.tpfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class InscriptionDTO {
    private Long id;
    private LocalDate date;
    private String state; //aceptada, rechazada, pendiente
    private Long course;
    private Long student;
}
