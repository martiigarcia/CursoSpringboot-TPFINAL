package com.martina.tpfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private int dni;
    private LocalDate birthDate;
}
