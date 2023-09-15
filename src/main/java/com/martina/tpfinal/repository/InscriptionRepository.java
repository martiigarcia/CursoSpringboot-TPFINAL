package com.martina.tpfinal.repository;

import com.martina.tpfinal.model.Inscription;
import com.martina.tpfinal.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    //D
    @Query("SELECT i from Inscription i where i.status='RECHAZADA' OR i.status='PENDIENTE'")
    List<Inscription> findAllInscriptionsRefusedORPending();

    //E -> D
    List<Inscription> findByStatusIn(List<Status> statuses); // Consulta derivada para buscar Inscription con status 'RECHAZADA' o 'PENDIENTE'

//    default List<Inscription> findAllInscriptionRefusedORPending() { // Método para encontrar todas las Inscription con status 'RECHAZADA' o 'PENDIENTE'
//        return findByStatusIn(List.of(Status.RECHAZADA,  Status.PENDIENTE));
//    }

    //G
    //Listar todas las inscripciones en base a un parámetro de estado
    @Query("SELECT i FROM Inscription i WHERE i.status = :status")
    List<Inscription> findInscriptionsByStatus(@Param("status") Status status);


    //H
    //Listar todas las inscripciones en base a un parámetro de estado utilizando consulta nativa
    @Query(value = "SELECT * FROM inscription WHERE status = :status", nativeQuery = true)
    List<Inscription> findInscriptionsByStatusNative(@Param("status") String status);


}
