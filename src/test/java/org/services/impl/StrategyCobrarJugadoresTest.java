package org.services.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.model.bank.Banco;
import org.model.card.StrategyCobrarJugadores;
import org.model.player.Jugador;
import org.services.IPeon;

import java.util.Arrays;
import java.util.List;

public class StrategyCobrarJugadoresTest extends TestCase {

    private IPeon jugador;
    private IPeon jugador1;
    private IPeon jugador2;
    private List<IPeon> jugadores;
    private StrategyCobrarJugadores strategyCobrarJugadores;
    private final int montoACobrar = 1000;
    private Banco banco;
    @Before
    public void SetUp(){
        jugador = new Jugador("Jugador 1","Azul");
        jugador1 = new Jugador("bot1", "Azul");
        jugador2 = new Jugador("bot2", "Amarillo");
        jugadores = Arrays.asList(jugador, jugador1, jugador2);
        strategyCobrarJugadores = new StrategyCobrarJugadores(montoACobrar, jugadores);
    }

//    @Test
//    public void testActivarEfecto() {
//        int dineroInicialJugadorPrincipal = jugadorPrincipal.getDinero();
//        int dineroInicialJugador1 = jugador1.getDinero();
//        int dineroInicialJugador2 = jugador2.getDinero();
//
//        strategyCobrarJugadores.activarEfecto(jugadorPrincipal);
//
//        assertEquals(dineroInicialJugadorPrincipal + 2 * montoACobrar, jugadorPrincipal.getDinero());
//        assertEquals(dineroInicialJugador1 - montoACobrar, jugador1.getDinero());
//        assertEquals(dineroInicialJugador2 - montoACobrar, jugador2.getDinero());
//        }
   }
