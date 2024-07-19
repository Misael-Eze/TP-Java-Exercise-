package org.services.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.model.bank.Banco;
import org.model.card.StrategyCobrar;
import org.model.player.Jugador;

public class StrategyCobrarTest extends TestCase {

    private Jugador jugador;
    private StrategyCobrar strategyCobrar;
    private final int montoACobrar = 1000;
    private Banco banco;
    @Before
    public void SetUp(){
        jugador = new Jugador("Jugador 1","Azul");
        strategyCobrar = new StrategyCobrar(montoACobrar);
    }

    @Test
    public void testActivarEfecto() {
        int dineroInicial = jugador.getDinero();

        strategyCobrar.activarEfecto(jugador);

        assertEquals(dineroInicial + montoACobrar, jugador.getDinero());
    }
}