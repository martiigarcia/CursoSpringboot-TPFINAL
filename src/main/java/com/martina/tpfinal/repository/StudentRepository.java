package com.martina.tpfinal.repository;

import com.martina.tpfinal.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    //B
    @Query("SELECT s FROM Student s")
    List<Student> findAllStudents();


    //C
    @Query("SELECT s from Student s WHERE s.dni>20000000 AND s.surname='Romero'")
    List<Student> findAllStudentsByDNIGreaterThan20MAndSurnameIsRomero();

    //E -> B
    List<Student> findAll();


    //E -> C
    //de estas cual seria la correcta?
    List<Student> findByDniGreaterThanAndSurnameEquals(int dni, String surname);

    List<Student> findByDniGreaterThanAndSurname(int dni, String surname);

    //I
    //Listar todos los estudiantes de forma paginada y ordenada ascendente por DNI.
    //Probar las siguientes combinaciones:
    //a. pagina 1, tamaño 5
    //b. pagina 0, tamaño 2
    Page<Student> findAllByOrderByDniAsc(Pageable pageable);

}