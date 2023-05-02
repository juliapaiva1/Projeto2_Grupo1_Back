package com.app.delivery.Entregador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorService {
    
    @Autowired
    private EntregadorRepository entregadorRepository;

    public List<Entregador> findAll() {
        return entregadorRepository.findAll();
    }

    public Entregador findById(Integer id) {
        return entregadorRepository.findById(id).orElse(null);
    }

    public List<Entregador> findByNomeEntregador(String nome) {
        return entregadorRepository.findByNomeEntregador(nome);
    }

    public Entregador save(Entregador entregador) {
        return entregadorRepository.save(entregador);
    }

    public void deleteById(Integer id) {
        entregadorRepository.deleteById(id);
    }

}
