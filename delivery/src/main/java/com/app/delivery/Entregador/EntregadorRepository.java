package com.app.delivery.Entregador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Integer> {
    Entregador findByNome(String nome);
}
    
