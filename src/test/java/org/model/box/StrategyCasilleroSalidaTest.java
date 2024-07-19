package org.model.box;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.model.bank.Banco;
import org.model.box.strategys.StrategyCasilleroImpuesto;
import org.model.box.strategys.StrategyCasilleroSalida;
import org.model.player.Jugador;

import static org.junit.jupiter.api.Assertions.*;

class StrategyCasilleroSalidaTest {
    private Jugador jugador;
    private StrategyCasilleroSalida estrategia;
    private final int montoACobrarEnSalida = 5000;

    @BeforeEach
    void setUp() {
        jugador = new Jugador("JugadorTest", "Rojo");
        estrategia = new StrategyCasilleroSalida(new Banco());
    }

    @Test
    void accionCasilleroSalida(){
        int montoFinal = jugador.getDinero() + montoACobrarEnSalida;
        estrategia.accionCasillero(jugador);
        assertEquals(montoFinal, jugador.getDinero());
    }

}