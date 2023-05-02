package com.app.delivery.Entregador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Integer> {
    List<Entregador> findByNomeEntregador(String nome);
}
    
