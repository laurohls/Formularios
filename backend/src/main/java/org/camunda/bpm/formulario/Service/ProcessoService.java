package org.camunda.bpm.formulario.Service;

import lombok.RequiredArgsConstructor;

import org.camunda.bpm.formulario.Model.Processo;
import org.camunda.bpm.formulario.Repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

@RequiredArgsConstructor
public class ProcessoService {

    @Autowired
    private ProcessoRepository processoRespository;

    public List<Processo> findAll() {
        return processoRespository.findAll();
    }

    public Optional<Processo> findById(Long id) {
        return processoRespository.findById(id);
    }

    public Processo save(Processo stock) {
        return processoRespository.save(stock);
    }

    public void deleteById(Long id) {
        processoRespository.deleteById(id);
    }
}