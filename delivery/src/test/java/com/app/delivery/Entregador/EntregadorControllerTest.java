package com.app.delivery.Entregador;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class EntregadorControllerTest {

    MockMvc mockMvc;

    @InjectMocks
    EntregadorController entregadorController;

    @Mock
    EntregadorService entregadorService;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(entregadorController).build();
    }

    @Test
    public void test_criar_entregador() {
        Entregador entregador = new Entregador();
        when(entregadorService.save(entregador)).thenReturn(entregador);
        
        Entregador savedEntregador = entregadorController.save(entregador);
        
        verify(entregadorService, times(1)).save(entregador);
        Assertions.assertEquals(entregador, savedEntregador);
    }

    @Test
    public void test_lista_todos_entregadores() {

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
        when(entregadorService.findAll()).thenReturn(entregadores);

        List<EntregadorDTO> entregadorDTOs = entregadorController.findAll();

        verify(entregadorService, times(1)).findAll();
        Assertions.assertEquals(entregadores.size(), entregadorDTOs.size());
        Assertions.assertEquals(entregadores.get(0).getId(), entregadorDTOs.get(0).getId());
        Assertions.assertEquals(entregadores.get(1).getId(), entregadorDTOs.get(1).getId());
        Assertions.assertEquals(entregadores.get(0).getNome(), entregadorDTOs.get(0).getNome());
        Assertions.assertEquals(entregadores.get(1).getNome(), entregadorDTOs.get(1).getNome());
    }

    @Test
    public void test_lista_entregador_id() {

        Entregador entregador = new Entregador();
        entregador.setId((long) 1);
        entregador.setNome("Carlos");
        entregador.setCpf("11111111111");
        entregador.setTipo_veiculo("moto");
        entregador.setPreco_viagem((double) 10);
        entregador.setStatus_ocupacao(EntregadorOcupacao.DISPONIVEL);
        entregador.setStatus_utilizacao(EntregadorUtilizacao.LIBERADO);

        when(entregadorService.findById((long)1)).thenReturn(entregador);

        EntregadorDTO entregadorDTO = entregadorController.findById((long)1);

        verify(entregadorService, times(1)).findById((long)1);
        Assertions.assertEquals(entregador.getId(), entregadorDTO.getId());
        Assertions.assertEquals(entregador.getNome(), entregadorDTO.getNome());
    }
    
    @Test
    public void test_lista_entregador_nome() {

        Entregador entregador = new Entregador();
        entregador.setId((long) 1);
        entregador.setNome("Carlos");
        entregador.setCpf("11111111111");
        entregador.setTipo_veiculo("moto");
        entregador.setPreco_viagem((double) 10);
        entregador.setStatus_ocupacao(EntregadorOcupacao.DISPONIVEL);
        entregador.setStatus_utilizacao(EntregadorUtilizacao.LIBERADO);

        when(entregadorService.findByNomeEntregador("Carlos")).thenReturn(entregador);
        
        EntregadorDTO foundEntregador = entregadorController.findByNomeEntregador("Carlos");
        
        verify(entregadorService, times(1)).findByNomeEntregador("Carlos");
        Assertions.assertNotNull(foundEntregador);
        Assertions.assertEquals(entregador.getId(), foundEntregador.getId());
        Assertions.assertEquals(entregador.getNome(), foundEntregador.getNome());
    }


    @Test
    public void test_deleta_entregador() {
        
        Entregador entregador = new Entregador();
        entregador.setId((long) 1);
        entregador.setNome("Carlos");
        entregador.setCpf("11111111111");
        entregador.setTipo_veiculo("moto");
        entregador.setPreco_viagem((double) 10);
        entregador.setStatus_ocupacao(EntregadorOcupacao.DISPONIVEL);
        entregador.setStatus_utilizacao(EntregadorUtilizacao.LIBERADO);

        when(entregadorService.existsbyId((long) 1)).thenReturn(true);
        ResponseEntity<Void> response = entregadorController.deleteById((long) 1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(entregadorService, times(1)).deleteById((long) 1);
    }

    @Test
    public void test_edita_entregador() {
        
        Entregador entregador = new Entregador();
        entregador.setId((long) 1);
        entregador.setNome("Carlos");
        entregador.setCpf("11111111111");
        entregador.setTipo_veiculo("moto");
        entregador.setPreco_viagem((double) 10);
        entregador.setStatus_ocupacao(EntregadorOcupacao.DISPONIVEL);
        entregador.setStatus_utilizacao(EntregadorUtilizacao.LIBERADO);

        entregador.setId((long) 1);
        when(entregadorService.existsbyId((long) 1)).thenReturn(true);
        when(entregadorService.save(entregador)).thenReturn(entregador);
        ResponseEntity<Entregador> response = entregadorController.update((long) 1, entregador);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(entregador, response.getBody());
    }
}