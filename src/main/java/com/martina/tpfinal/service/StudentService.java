package com.martina.tpfinal.service;

import com.martina.tpfinal.dto.StudentDTO;
import com.martina.tpfinal.model.Student;
import com.martina.tpfinal.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentDTO save(StudentDTO studentDTO) {
        Student student = new Student(null, studentDTO.getName(), studentDTO.getSurname(), studentDTO.getEmail(), studentDTO.getDni(), studentDTO.getBirthDate());
        studentRepository.save(student);
        return studentDTO;
    }

    public StudentDTO update(Long id, StudentDTO studentDTO) {
        Student student = new Student(id, studentDTO.getName(), studentDTO.getSurname(), studentDTO.getEmail(), studentDTO.getDni(), studentDTO.getBirthDate());
        studentRepository.save(student);
        return studentDTO;
    }

    public StudentDTO find(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isEmpty()) {
            throw new RuntimeException("No existe un estudiante con ese id");
        }
        Student student = studentOptional.get();
        return new StudentDTO(student.getId(), student.getName(), student.getSurname(), student.getEmail(), student.getDni(), student.getBirthDate());
    }

    public List<StudentDTO> findAll() {
        return studentRepository.findAll()
                .stream().map(c -> new StudentDTO(c.getId(), c.getName(), c.getSurname(), c.getEmail(), c.getDni(), c.getBirthDate())
                ).collect(Collectors.toList());
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }


}
