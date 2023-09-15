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
    List<Student> findAll();

    //C
    @Query("SELECT s from Student s WHERE s.dni>20000000 AND s.surname='Romero'")
    List<Student> findAllStudentsByDNIGreaterThan20MAndSurnameIsRomero();

    //E -> B
    @Query("SELECT s FROM Student s")
    List<Student> findAllStudents();


    //E -> C
    //de estas cual seria la correcta?
    List<Student> findByDniGreaterThanAndSurnameEquals(int dni, String surname);

    List<Student> findByDniGreaterThanAndSurname(int dni, String surname);

    //I
    //Listar todos los estudiantes de forma paginada y ordenada ascendente por DNI.
    //Probar las siguientes combinaciones:
    //a. pagina 1, tamaño 5
    //b. pagina 0, tamaño 2

    List<Student> findAllByOrderByDniAsc();
//    Page<Student> findAllByOrderByDniAsc(Pageable pageable);

    //las paginas para probar:
//    Pageable page1 = PageRequest.of(1, 5); // página 1, tamaño 5
//    Pageable page0 = PageRequest.of(0, 2); // página 0, tamaño 2


    //no funciona:
//    studentRepository.findAll(PageRequest.of(1, 5, Sort.by(Sort.Direction.ASC, "dni")));

    //funciona
    //studentRepository.findAll(PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "dni")));

}