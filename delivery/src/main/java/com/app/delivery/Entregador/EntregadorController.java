package com.app.delivery.Entregador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregador")
public class EntregadorController {
    
    @Autowired
    private EntregadorService entregadorService;

    @GetMapping
    public List<Entregador> findAll() {
        return entregadorService.findAll();
    }

    @GetMapping("/{id}")
    public Entregador findById(@PathVariable Integer id) {
        return entregadorService.findById(id);
    }

    @GetMapping("/nome/{nome}")
    public Entregador findByNomeEntregador(@PathVariable String nome) {
        return entregadorService.findByNomeEntregador(nome);
    }

    @PostMapping
    public Entregador save(@RequestBody Entregador entregador) {
        return entregadorService.save(entregador);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        entregadorService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Entregador update(@PathVariable Integer id, @RequestBody Entregador entregador) {
        return entregadorService.update(id, entregador);
    }
 

}
