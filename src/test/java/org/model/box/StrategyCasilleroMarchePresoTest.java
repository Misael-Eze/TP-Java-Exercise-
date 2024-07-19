package org.model.box;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.model.box.strategys.StrategyCasilleroMarchePreso;
import org.model.enums.EstadosJugadores;
import org.model.player.Jugador;

import static org.junit.jupiter.api.Assertions.*;

class StrategyCasilleroMarchePresoTest {

    private Jugador jugador;
    private StrategyCasilleroMarchePreso estrategia;

    @BeforeEach
    void setUp() {
        jugador = new Jugador("Jugador1", "Rojo");
        estrategia = new StrategyCasilleroMarchePreso();
    }

    @Test
    void accionCasilleroMarchePreso() {
        estrategia.accionCasillero(jugador);
        assertEquals(EstadosJugadores.PRESO, jugador.getEstado());
        assertEquals(14, jugador.getPosicion());
    }

}