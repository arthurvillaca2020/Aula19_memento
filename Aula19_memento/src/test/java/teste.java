import org.example.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class teste {

    @Test
    void deveArmazenarEstados() {
        Jogador jogador = new Jogador();
        jogador.setEstado(JogadorEstadoAFK.getInstance());
        jogador.setEstado(JogadorEstadoAtivo.getInstance());
        assertEquals(2, jogador.getEstados().size());
    }

    @Test
    void deveRetornarEstadoInicial() {
        Jogador jogador = new Jogador();
        jogador.setEstado(JogadorEstadoAFK.getInstance());
        jogador.setEstado(JogadorEstadoAtivo.getInstance());
        jogador.restauraEstado(0);
        assertEquals(JogadorEstadoAFK.getInstance(), jogador.getEstado());
    }

    @Test
    void deveRetornarEstadoAnterior() {
        Jogador jogador = new Jogador();
        jogador.setEstado(JogadorEstadoAFK.getInstance());
        jogador.setEstado(JogadorEstadoDescansado.getInstance());
        jogador.setEstado(JogadorEstadoAtivo.getInstance());
        jogador.setEstado(JogadorEstadoCombate.getInstance());
        jogador.restauraEstado(2);
        assertEquals(JogadorEstadoAtivo.getInstance(), jogador.getEstado());
    }

    @Test
    void deveRetornarExcecaoIndiceInvalido() {
        try {
            Jogador jogador = new Jogador();
            jogador.restauraEstado(0);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }
}

