package org.model.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.model.card.CartaProvincia;
import org.model.card.MazoPropiedades;
import org.model.console.Consola;
import org.model.enums.EstadosJugadores;
import org.model.enums.Provincias;
import org.model.enums.Zonas;
import org.model.player.Jugador;
import org.services.ITarjeta;

import java.io.Console;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BancoTest {
    private Jugador jugador;
    private MazoPropiedades propiedades;
    private Consola consola = Mockito.mock(Consola.class);
    private Banco bancoMock = Mockito.mock(Banco.class);

    private Banco banco;

    @BeforeEach
    void setUp() {
        propiedades = new MazoPropiedades();
        jugador = new Jugador("Agustin");
        banco = new Banco(consola, propiedades);
//        bancoMock = new Banco(consola, propiedades);
    }

    @Test
    void venderPropiedad(){
        CartaProvincia cartaProvincia = propiedades.getMazoProvincias().get(0);
        when(consola.ofrecerPropiedad(jugador, cartaProvincia)).thenReturn(true);
        banco.ofrecerPropiedad(jugador, cartaProvincia);
        assertEquals(jugador, cartaProvincia.getDuenio());
    }

    @Test
    void jugadorNoTienePropiedadesQuedaEnBancarrota(){
        EstadosJugadores estadoAnterior = jugador.getEstado();
        System.out.println("Estado anterior: "+estadoAnterior);
        banco.ofrecerHipoteca(jugador);
        EstadosJugadores estadoActual = jugador.getEstado();
        System.out.println("Estado actual: "+estadoActual);
        assertNotEquals(estadoAnterior, estadoActual);
        assertEquals(EstadosJugadores.BANCARROTA, estadoActual);
    }

    @Test
    void jugadorCompraChacras(){
        CartaProvincia cartaProvincia = propiedades.getMazoProvincias().get(0);
        when(bancoMock.puedeAgregarChacra(jugador, cartaProvincia)).thenReturn(true);

        bancoMock.ofrecerMejoras(jugador, cartaProvincia);
        assertEquals(1, cartaProvincia.getConteoChacras());
    }

    

}