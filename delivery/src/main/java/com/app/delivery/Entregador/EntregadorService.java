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

    public Entregador findById(Long id) {
        return entregadorRepository.findById(id).orElse(null);
    }

    public Entregador findByNomeEntregador(String nome) {
        return entregadorRepository.findByNome(nome);
    }

    public Entregador save(Entregador entregador) {
        return entregadorRepository.save(entregador);
    }

    public void deleteById(Long id) {
        entregadorRepository.deleteById(id);
    }

    public Entregador update(Long id, Entregador entregador) {
        Entregador entregadorUpdate = entregadorRepository.findById(id).orElse(null);
        if (entregadorUpdate != null) {
            entregadorUpdate.setNome(entregador.getNome());
            entregadorUpdate.setTipo_veiculo(entregador.getTipo_veiculo());
            entregadorUpdate.setStatus_ocupacao(entregador.getStatus_ocupacao());
            entregadorUpdate.setStatus_utilizacao(entregador.getStatus_utilizacao());
            entregadorRepository.save(entregadorUpdate);
        }
        return entregadorUpdate;}

    public boolean existsbyId(Long id) {
        return entregadorRepository.existsById(id);
    }

}
