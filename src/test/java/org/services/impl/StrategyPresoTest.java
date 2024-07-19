package org.services.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.model.bank.Banco;
import org.model.card.StrategyPreso;
import org.model.player.Jugador;
import org.services.IPeon;

public class StrategyPresoTest extends TestCase {
    private IPeon jugador;
    private StrategyPreso strategyPreso;
    private Banco banco;
    @Before
    public void SetUp(){
        jugador = new Jugador("Jugador 1","Azul");
        strategyPreso = new StrategyPreso();
    }

    @Test
    public void testActivarEfecto() {

        int posicionInicial = jugador.getPosicion();
        strategyPreso.activarEfecto(jugador);

        assertEquals(10, jugador.getPosicion());

    }

}