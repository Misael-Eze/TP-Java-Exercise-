package org.services.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.model.bank.Banco;
import org.model.card.StrategyAvanzarRetroceder;
import org.model.player.Jugador;
import org.services.IPeon;

import static org.junit.Assert.assertEquals;

public class StrategyAvanzarRetrocederTest extends TestCase {
    private IPeon jugador;
    private StrategyAvanzarRetroceder strategyAvanzarRetroceder;
    private Banco banco;
    @Before
    public void SetUp(){
        jugador = new Jugador("Jugador 1","Azul");

    }

    @Test
    public void AvanzarHasta(){
        strategyAvanzarRetroceder = new StrategyAvanzarRetroceder(10);
        strategyAvanzarRetroceder.activarEfecto(jugador);
        assertEquals(10,jugador.getPosicion());
    }
}