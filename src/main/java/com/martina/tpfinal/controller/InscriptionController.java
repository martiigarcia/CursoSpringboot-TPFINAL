package com.martina.tpfinal.controller;

import com.martina.tpfinal.dto.InscriptionDTO;
import com.martina.tpfinal.service.InscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscriptions")
@AllArgsConstructor
public class InscriptionController {

    private final InscriptionService inscriptionService;

    @PostMapping()
    public InscriptionDTO save(@RequestBody InscriptionDTO inscriptionDTO) {
        return inscriptionService.save(inscriptionDTO);
    }

    @PutMapping("/{id}")
    public InscriptionDTO update(@PathVariable Long id, @RequestBody InscriptionDTO inscriptionDTO) {
        return inscriptionService.update(id, inscriptionDTO);
    }

    @GetMapping("/{id}")
    public InscriptionDTO find(@PathVariable Long id) {
        return inscriptionService.find(id);
    }

    @GetMapping()
    public List<InscriptionDTO> findAll() {
        return inscriptionService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        inscriptionService.delete(id);
    }
}
