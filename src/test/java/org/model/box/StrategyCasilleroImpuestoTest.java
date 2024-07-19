package org.model.box;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.model.bank.Banco;
import org.model.box.strategys.StrategyCasilleroImpuesto;
import org.model.box.strategys.StrategyCasilleroMarchePreso;
import org.model.player.Jugador;

import static org.junit.jupiter.api.Assertions.*;


class StrategyCasilleroImpuestoTest {
    private Jugador jugador;
    private StrategyCasilleroImpuesto estrategia;
    private final int impuestoALosReditos = 5000;
    private final int impuestoALasVentas = 2000;

    @BeforeEach
    void setUp() {
        jugador = new Jugador("Jugador1", "Rojo");
        estrategia = new StrategyCasilleroImpuesto(new Banco());
    }

    @Test
    void jugadorCaeEnImpuestoALosReditos(){
        int montoFinal = jugador.getDinero() - impuestoALosReditos;
        //Seteamos la posicion del jugador en el casillero 4
        jugador.setPosicion(4);
        estrategia.accionCasillero(jugador);
        assertEquals(montoFinal, jugador.getDinero());
    }

    @Test
    void jugadorCaeEnImpuestoALasVentas(){
        int montoFinal = jugador.getDinero() - impuestoALasVentas;
        jugador.setPosicion(41);
        estrategia.accionCasillero(jugador);
        assertEquals(montoFinal, jugador.getDinero());
    }

}