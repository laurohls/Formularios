package org.camunda.bpm.formulario.Resource;

import java.util.List;
import java.util.Optional;

import org.camunda.bpm.formulario.Model.Processo;
import org.camunda.bpm.formulario.Service.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/processos")
@Slf4j
@RequiredArgsConstructor
public class ProcessoController {

   @Autowired
   ProcessoService processoService;

   @GetMapping
   public ResponseEntity<List<Processo>> findAll() {
      return ResponseEntity.ok(processoService.findAll());
   }

   @PostMapping
   public ResponseEntity create(@Validated @RequestBody Processo product) {
        return ResponseEntity.ok(processoService.save(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Processo> findById(@PathVariable Long id) {
        Optional<Processo> stock = processoService.findById(id);
        if (!stock.isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Processo> update(@PathVariable Long id, @Validated @RequestBody Processo product) {
        if (!processoService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(processoService.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!processoService.findById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        processoService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}       