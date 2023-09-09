package com.martina.tpfinal.controller;

import com.martina.tpfinal.dto.CourseDTO;
import com.martina.tpfinal.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping()
    public CourseDTO save(@RequestBody CourseDTO courseDTO) {
        return courseService.save(courseDTO);
    }

    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable Long id, @RequestBody CourseDTO courseDTO) {
        return courseService.update(id, courseDTO);
    }

    @GetMapping("/{id}")
    public CourseDTO find(@PathVariable Long id) {
        return courseService.find(id);
    }

    @GetMapping()
    public List<CourseDTO> findAll() {
        return courseService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }
}
