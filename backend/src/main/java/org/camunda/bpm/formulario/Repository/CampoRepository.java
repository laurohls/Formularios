package org.camunda.bpm.formulario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.camunda.bpm.formulario.Model.Campo;



@Repository
public interface CampoRepository extends JpaRepository<Campo, Long> {
    
}