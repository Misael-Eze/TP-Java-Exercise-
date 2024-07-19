package org.services.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.model.bank.Banco;
import org.model.card.StrategyLiberar;
import org.model.player.Jugador;
import org.services.IPeon;

public class StrategyLiberarTest extends TestCase {
    private IPeon jugador;
    private StrategyLiberar strategyLiberar;
    private Banco banco;
    @Before
    public void SetUp(){
        jugador = new Jugador("Jugador 1","Azul");
        strategyLiberar = new StrategyLiberar();
    }

    @Test
    public void testActivarEfectoConTarjetaLiberacion() {
        jugador.recibirTarjetaLiberacion();
        assertTrue(jugador.tieneTarjetaLiberacion());

        strategyLiberar.activarEfecto(jugador);

        assertFalse(jugador.tieneTarjetaLiberacion());
    }

    @Test
    public void testActivarEfectoSinTarjetaLiberacion() {
        assertFalse(jugador.tieneTarjetaLiberacion());

        strategyLiberar.activarEfecto(jugador);

        assertFalse(jugador.tieneTarjetaLiberacion());
    }
}