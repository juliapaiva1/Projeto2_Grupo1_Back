package com.app.delivery.Entregador;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class EntregadorServiceTest {

    MockMvc mockMvc;

    @Mock
    private EntregadorRepository entregadorRepository;

    @InjectMocks
    private EntregadorService entregadorService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(entregadorService).build();
    }

    @Test
    public void testFindAll() {

        List<Entregador> entregadores = new ArrayList<>();

        Entregador entregador1 = new Entregador();
        entregador1.setId((long) 1);
        entregador1.setNome("Carlos");
        entregador1.setCpf("11111111111");
        entregador1.setTipo_veiculo("moto");
        entregador1.setPreco_viagem((double) 10);
        entregador1.setStatus_ocupacao(EntregadorOcupacao.DISPONIVEL);
        entregador1.setStatus_utilizacao(EntregadorUtilizacao.LIBERADO);

        Entregador entregador2 = new Entregador();
        entregador2.setId((long) 2);
        entregador2.setNome("Roberto");
        entregador2.setCpf("22222222222");
        entregador2.setTipo_veiculo("moto");
        entregador2.setPreco_viagem((double) 9.5);
        entregador2.setStatus_ocupacao(EntregadorOcupacao.DISPONIVEL);
        entregador2.setStatus_utilizacao(EntregadorUtilizacao.LIBERADO);
        
        entregadores.add(entregador1);
        entregadores.add(entregador2);
        when(entregadorRepository.findAll()).thenReturn(entregadores);

        List<Entregador> result = entregadorService.findAll();

        verify(entregadorRepository).findAll();
        assertEquals(entregadores, result);
    }

    @Test
    public void testFindById() {

        Entregador entregador = new Entregador();
        entregador.setId((long) 1);
        entregador.setNome("Carlos");
        entregador.setCpf("11111111111");
        entregador.setTipo_veiculo("moto");
        entregador.setPreco_viagem((double) 10);
        entregador.setStatus_ocupacao(EntregadorOcupacao.DISPONIVEL);
        entregador.setStatus_utilizacao(EntregadorUtilizacao.LIBERADO);

        when(entregadorRepository.findById((long) 1)).thenReturn(Optional.of(entregador));

        Entregador result = entregadorService.findById((long) 1);

        verify(entregadorRepository).findById((long) 1);
        assertEquals(entregador, result);
    }

    @Test
    public void testFindByNomeEntregador() {

        Entregador entregador = new Entregador();
        entregador.setId((long) 1);
        entregador.setNome("Carlos");
        entregador.setCpf("11111111111");
        entregador.setTipo_veiculo("moto");
        entregador.setPreco_viagem((double) 10);
        entregador.setStatus_ocupacao(EntregadorOcupacao.DISPONIVEL);
        entregador.setStatus_utilizacao(EntregadorUtilizacao.LIBERADO);

        when(entregadorRepository.findByNome("Carlos")).thenReturn(entregador);

        Entregador result = entregadorService.findByNomeEntregador("Carlos");

        verify(entregadorRepository).findByNome("Carlos");
        assertEquals(entregador, result);
    }

    @Test
    public void testSave() {
        
        Entregador entregador = new Entregador();
        entregador.setId((long) 1);
        entregador.setNome("Carlos");
        entregador.setCpf("11111111111");
        entregador.setTipo_veiculo("moto");
        entregador.setPreco_viagem((double) 10);
        entregador.setStatus_ocupacao(EntregadorOcupacao.DISPONIVEL);
        entregador.setStatus_utilizacao(EntregadorUtilizacao.LIBERADO);

        when(entregadorRepository.save(any(Entregador.class))).thenReturn(entregador);

        Entregador result = entregadorService.save(entregador);

        verify(entregadorRepository).save(any(Entregador.class));
        assertEquals(entregador, result);
    }

@Test
    public void testDeleteByIdExists() {

        Entregador entregador = new Entregador();
        entregador.setId((long) 1);
        entregador.setNome("Carlos");
        entregador.setCpf("11111111111");
        entregador.setTipo_veiculo("moto");
        entregador.setPreco_viagem((double) 10);
        entregador.setStatus_ocupacao(EntregadorOcupacao.DISPONIVEL);
        entregador.setStatus_utilizacao(EntregadorUtilizacao.LIBERADO);

        when(entregadorRepository.existsById((long) 1)).thenReturn(true);

        entregadorService.deleteById((long) 1);

        verify(entregadorRepository).deleteById((long) 1);
    }

    public void testUpdateExists() {

        Entregador entregador = new Entregador();
        entregador.setId((long) 1);
        entregador.setNome("Carlos");
        entregador.setCpf("11111111111");
        entregador.setTipo_veiculo("moto");
        entregador.setPreco_viagem((double) 10);
        entregador.setStatus_ocupacao(EntregadorOcupacao.DISPONIVEL);
        entregador.setStatus_utilizacao(EntregadorUtilizacao.LIBERADO);

        when(entregadorRepository.existsById((long) 1)).thenReturn(true);
        when(entregadorRepository.findById((long) 1)).thenReturn(Optional.of(entregador));
        when(entregadorRepository.save(any(Entregador.class))).thenReturn(entregador);

        Entregador result = entregadorService.update((long) 1, entregador);

        verify(entregadorRepository).existsById((long) 1);
        verify(entregadorRepository).findById((long) 1);
        verify(entregadorRepository).save(any(Entregador.class));
        assertEquals(entregador, result);
    }

}