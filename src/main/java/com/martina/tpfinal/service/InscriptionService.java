package com.martina.tpfinal.service;

import com.martina.tpfinal.dto.InscriptionDTO;
import com.martina.tpfinal.model.Course;
import com.martina.tpfinal.model.Inscription;
import com.martina.tpfinal.model.Status;
import com.martina.tpfinal.model.Student;
import com.martina.tpfinal.repository.CourseRepository;
import com.martina.tpfinal.repository.InscriptionRepository;
import com.martina.tpfinal.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InscriptionService {

    private final InscriptionRepository inscriptionRepository;
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public InscriptionDTO save(InscriptionDTO inscriptionDTO) {

        Course course = courseRepository.findById(
                inscriptionDTO.getCourse()
        ).orElseThrow(() -> new RuntimeException("No existe un curso con ese id."));

        Student student = studentRepository.findById(
                inscriptionDTO.getStudent()
        ).orElseThrow(() -> new RuntimeException("No existe un estudiante con ese id."));

        if (!student.idAdult())
            throw new RuntimeException("El estudiante no puede ser menor de edad.");

        Inscription inscription = new Inscription(null, inscriptionDTO.getDate(), Status.valueOf(inscriptionDTO.getStatus()), course, student);
        inscriptionRepository.save(inscription);
        return inscriptionDTO;
    }

    public InscriptionDTO update(Long id, InscriptionDTO inscriptionDTO) {

        Course course = courseRepository.findById(
                inscriptionDTO.getCourse()
        ).orElseThrow(() -> new RuntimeException("No existe un curso con ese id."));

        Student student = studentRepository.findById(
                inscriptionDTO.getStudent()
        ).orElseThrow(() -> new RuntimeException("No existe un estudiante con ese id."));

        Inscription inscription = new Inscription(id, inscriptionDTO.getDate(), Status.valueOf(inscriptionDTO.getStatus()), course, student);
        inscriptionRepository.save(inscription);
        return inscriptionDTO;
    }

    public InscriptionDTO find(Long id) {
        Optional<Inscription> inscriptionOptional = inscriptionRepository.findById(id);
        if (inscriptionOptional.isEmpty()) {
            throw new RuntimeException("No existe una inscripcion con ese id");
        }
        Inscription inscription = inscriptionOptional.get();
        return new InscriptionDTO(inscription.getId(), inscription.getDate(), inscription.getStatus().name(),
                inscription.getCourse().getId(), inscription.getStudent().getId());
    }

    public List<InscriptionDTO> findAll() {
        return inscriptionRepository.findAll()
                .stream().map(inscription ->
                        new InscriptionDTO(inscription.getId(), inscription.getDate(), inscription.getStatus().name(),
                                inscription.getCourse().getId(), inscription.getStudent().getId())
                ).collect(Collectors.toList());
    }

    public void delete(Long id) {
        inscriptionRepository.deleteById(id);
    }

}
