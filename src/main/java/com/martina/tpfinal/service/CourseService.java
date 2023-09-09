package com.martina.tpfinal.service;

import com.martina.tpfinal.dto.CourseDTO;
import com.martina.tpfinal.model.Course;
import com.martina.tpfinal.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;


    public CourseDTO save(CourseDTO courseDTO) {
        Course course = new Course(null, courseDTO.getName(), courseDTO.getDescription(), courseDTO.getStartDate(), courseDTO.getEndDate());
        courseRepository.save(course);
        return courseDTO;
    }

    public CourseDTO update(Long id, CourseDTO courseDTO) {
        Course course = new Course(id, courseDTO.getName(), courseDTO.getDescription(), courseDTO.getStartDate(), courseDTO.getEndDate());
        courseRepository.save(course);
        return courseDTO;
    }

    public CourseDTO find(Long id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isEmpty()) {
            throw new RuntimeException("No existe un curso con ese id");
        }
        Course course = courseOptional.get();
        return new CourseDTO(course.getId(), course.getName(), course.getDescription(), course.getStartDate(), course.getEndDate());

    }

    public List<CourseDTO> findAll() {
        return courseRepository.findAll()
                .stream().map(c -> new CourseDTO(c.getId(), c.getName(), c.getDescription(), c.getStartDate(), c.getEndDate())
                ).collect(Collectors.toList());
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}
