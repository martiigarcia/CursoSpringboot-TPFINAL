package com.martina.tpfinal.repository;

import com.martina.tpfinal.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
