package org.model.box;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.model.bank.Banco;
import org.model.box.strategys.StrategyCasilleroImpuesto;
import org.model.box.strategys.StrategyCasilleroPremio;
import org.model.player.Jugador;

import static org.junit.jupiter.api.Assertions.*;

class StrategyCasilleroPremioTest {
    private Jugador jugador;
    private StrategyCasilleroPremio estrategia;
    private final int premioGanadero = 2500;

    @BeforeEach
    void setUp() {
        jugador = new Jugador("Jugador1", "Rojo");
        estrategia = new StrategyCasilleroPremio(new Banco());
    }

    @Test
    void accionCasilleroPremioGanadero(){
        int montoFinal = jugador.getDinero() + premioGanadero;
        estrategia.accionCasillero(jugador);
        assertEquals(montoFinal, jugador.getDinero());
    }

}