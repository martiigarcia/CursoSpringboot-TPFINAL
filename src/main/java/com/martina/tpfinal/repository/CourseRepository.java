package com.martina.tpfinal.repository;

import com.martina.tpfinal.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    //A
    @Query("SELECT c FROM Course c")
    List<Course> findAllCourses();

    //E -> A
    List<Course> findAll();

    //F:

    //con derivada
    List<Course> findAllByStartDateAfter(LocalDate date);

    //con Query
    @Query("SELECT c FROM Course c WHERE c.startDate > DATE ('2020-02-01')")
    List<Course> findAllCoursesByStartDateAfter(LocalDate date);
}
