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

    public Entregador findByNomeEntregador(String nome) {
        return entregadorRepository.findByNome(nome);
    }

    public Entregador save(Entregador entregador) {
        return entregadorRepository.save(entregador);
    }

    public void deleteById(Integer id) {
        entregadorRepository.deleteById(id);
    }

    public Entregador update(Integer id, Entregador entregador) {
        Entregador entregadorUpdate = entregadorRepository.findById(id).orElse(null);
        entregadorRepository.save(entregadorUpdate);
        return entregadorUpdate;
    }

}
