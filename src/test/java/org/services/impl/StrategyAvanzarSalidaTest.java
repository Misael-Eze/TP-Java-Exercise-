package org.services.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.model.bank.Banco;
import org.model.card.StrategyAvanzarSalida;
import org.model.player.Jugador;
import org.services.IPeon;

public class StrategyAvanzarSalidaTest extends TestCase {

    private IPeon jugador;
    private StrategyAvanzarSalida strategyAvanzarSalida;
    private Banco banco;
    @Before
    public void SetUp(){
        jugador = new Jugador("Jugador 1","Azul");
        strategyAvanzarSalida = new StrategyAvanzarSalida();
    }

    @Test
    public void testAvanzarHastaSalida() {
        jugador.avanzarHasta(10);
        strategyAvanzarSalida.activarEfecto(jugador);
        assertEquals(0, jugador.getPosicion());
    }
}