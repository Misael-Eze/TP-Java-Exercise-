package org.services.impl;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.model.bank.Banco;
import org.model.card.StrategyPagar;
import org.model.player.Jugador;
import org.services.IPeon;

public class StrategyPagarTest extends TestCase {

    private IPeon jugador;
    private StrategyPagar strategyPagar;
    private Banco banco;
    @Before
    public void SetUp(){
        jugador = new Jugador("Jugador 1","Azul");
    }

    @Test
    public void testActivarEfectoConDineroSuficiente() {
        strategyPagar = new StrategyPagar(5000, banco);
        int dineroInicial = jugador.getDinero();

        strategyPagar.activarEfecto(jugador);

        assertEquals(dineroInicial - 5000, jugador.getDinero());
    }

    @Test
    public void testActivarEfectoSinDineroSuficiente() {
        strategyPagar = new StrategyPagar(40000, banco); // Monto mayor al dinero inicial del jugador

        int dineroInicial = jugador.getDinero();
        strategyPagar.activarEfecto(jugador);


        assertEquals(dineroInicial, jugador.getDinero());
    }
}