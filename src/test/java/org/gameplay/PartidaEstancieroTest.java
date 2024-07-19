package org.gameplay;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.model.bank.Banco;
import org.model.board.Tablero;
import org.model.card.MazoPropiedades;
import org.model.console.Consola;
import org.model.player.Bot;
import org.model.player.Jugador;
import org.services.IPeon;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PartidaEstancieroTest {

    private Tablero tablero;
    private Banco banco = new Banco();
    private MazoPropiedades mazo = new MazoPropiedades();
    private List<IPeon> jugadoresPartida = new ArrayList<>();
    private Jugador jugador = new Jugador("Test");
    private IPeon bot = new Bot();


    @Test
    void getWinner() {
        PartidaEstanciero partida = new PartidaEstanciero();
        partida.setWinner(jugador);
        assertEquals(jugador, partida.getWinner());
    }

    @Test
    void crearPartida() {
        tablero = new Tablero(mazo, banco, new Consola());
        PartidaEstanciero partida = new PartidaEstanciero();
        partida.setJugadoresPartida(jugadoresPartida);
        partida.setTableroPartida(tablero);
        partida.crearPartida(tablero, jugador, jugadoresPartida);
        PartidaEstanciero partida2 = new PartidaEstanciero();
        partida2.crearPartida(tablero,jugador,jugadoresPartida);
        assertEquals(partida2.getTableroPartida(), partida.getTableroPartida());
        assertEquals(partida2.getJugadoresPartida(), partida.getJugadoresPartida());

    }

    @Test
    void getBancoPartida() {
        PartidaEstanciero partida = new PartidaEstanciero();
        partida.setBancoPartida(banco);
        assertEquals(banco, partida.getBancoPartida());
    }

    @Test
    void getPropiedades() {
        PartidaEstanciero partida = new PartidaEstanciero();
        partida.setPropiedades(mazo);
        assertEquals(mazo, partida.getPropiedades());
    }

    @Test
    void getTableroPartida() {
        PartidaEstanciero partida = new PartidaEstanciero();
        tablero = new Tablero(mazo, banco, new Consola());
        partida.setTableroPartida(tablero);
        assertEquals(tablero, partida.getTableroPartida());
    }

    @Test
    void getJugadoresPartida() {
        List<IPeon> jugadoresPartidaTest = new ArrayList<>();
        PartidaEstanciero partida = new PartidaEstanciero();
        partida.setJugadoresPartida(jugadoresPartida);
        assertEquals(jugadoresPartidaTest, partida.getJugadoresPartida());
    }

    @Test
    void GetWinner2() {
        PartidaEstanciero partida = new PartidaEstanciero();
        partida.setWinner(bot);
        IPeon jugadorW = partida.getWinner();
        IPeon jugadorTest = new Bot();
        assertEquals(jugadorTest, jugadorW);
    }
}