package com.app.delivery.Entregador;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/entregador")
public class EntregadorController {
    
    @Autowired
    private EntregadorService entregadorService;

    @GetMapping
    public List<EntregadorDTO> findAll() {
        List<Entregador> entregadores = entregadorService.findAll();
        return EntregadorDTO.converter(entregadores);
    }

    @GetMapping("/{id}")
    public EntregadorDTO findById(@PathVariable Long id) {
        Entregador entregador = entregadorService.findById(id);
        return new EntregadorDTO(entregador);
    }

    @GetMapping("/nome/{nome}")
    public EntregadorDTO findByNomeEntregador(@PathVariable String nome) {
        Entregador entregador = entregadorService.findByNomeEntregador(nome);
        return new EntregadorDTO(entregador);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entregador save(@Valid @RequestBody Entregador entregador) {
        return entregadorService.save(entregador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (!entregadorService.existsbyId(id)) {
            return ResponseEntity.notFound().build();
        }
        entregadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entregador> update(@Valid @PathVariable Long id, @RequestBody Entregador entregador) {
        if (!entregadorService.existsbyId(id)) {
            return ResponseEntity.notFound().build();
        }
        entregador = entregadorService.save(entregador);
        return ResponseEntity.ok(entregador);
    }


}
