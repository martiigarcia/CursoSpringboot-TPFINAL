package com.martina.tpfinal.controller;

import com.martina.tpfinal.dto.StudentDTO;
import com.martina.tpfinal.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping()
    public StudentDTO save(@RequestBody StudentDTO studentDTO) {
        return studentService.save(studentDTO);
    }

    @PutMapping("/{id}")
    public StudentDTO update(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        return studentService.update(id, studentDTO);
    }

    @GetMapping("/{id}")
    public StudentDTO find(@PathVariable Long id) {
        return studentService.find(id);
    }

    @GetMapping()
    public List<StudentDTO> findAll() {
        return studentService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
