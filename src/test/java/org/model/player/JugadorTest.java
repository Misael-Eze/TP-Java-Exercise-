package org.model.player;

import org.junit.Test;

import org.model.card.CartaProvincia;
import org.model.card.MazoPropiedades;
import org.model.enums.Provincias;
import org.model.enums.Zonas;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue; // Para JUnit 5

import static org.mockito.Mockito.verify;

public class JugadorTest {

    @Test
    public void testComprarPropiedad_SuficienteDinero() {
        // Arrange
        Jugador jugador = new Jugador("Jugador 1", "Azul");
        CartaProvincia carta = new CartaProvincia(Long.valueOf(1), Provincias.BUENOS_AIRES, Zonas.SUR, 100, 50, 200, 300);

        // Act
        boolean resultado = jugador.comprarPropiedad(carta);

        // Assert
        assertTrue(resultado);
        assertEquals(34700, jugador.getDinero()); // Dinero restante después de la compra
        assertTrue(jugador.getCartas().contains(carta)); // La carta se agregó a las propiedades del jugador
    }

    @Test
    public void testVenderPropiedad_PropiedadExistente() {
        // Arrange
        Jugador jugador = new Jugador("Jugador 1", "Azul");
        CartaProvincia carta = new CartaProvincia(Long.valueOf(1), Provincias.BUENOS_AIRES, Zonas.SUR, 100, 50, 200, 300);
        jugador.agregarCarta(carta);
        int dineroEsperado = 35000 + carta.getValorHipoteca() / 2; // Dinero esperado después de la venta

        // Act
        boolean resultado = jugador.venderPropiedad(carta);

        // Assert
        assertTrue(resultado);
        assertEquals(dineroEsperado, jugador.getDinero()); // Dinero restante después de la venta
        assertTrue(!jugador.getCartas().contains(carta)); // La propiedad se eliminó de las propiedades del jugador
    }
    @Test
    public void testComprarEstancia_DineroSuficiente() {
        // Arrange
        Jugador jugador = new Jugador("Jugador 1", "Azul");
        CartaProvincia cartaProvincia = new CartaProvincia(Long.valueOf(1), Provincias.BUENOS_AIRES, Zonas.SUR, 100, 50, 700, 300);
        cartaProvincia.setConteoChacras(4); // Se tienen las 4 chacras requeridas
        // Act
        boolean compraExitosa = jugador.comprarEstancia(cartaProvincia);

        // Assert
        assertTrue(compraExitosa);
        assertEquals(34500, jugador.getDinero()); // Dinero restante después de la compra
        assertEquals(0, cartaProvincia.getConteoChacras()); // Se devuelven las chacras al banco
        assertEquals(1, cartaProvincia.getConteoEstancias()); // Se agrega una estancia
    }

    @Test
    public void testVenderEstancia() {
        // Arrange
        Jugador jugador = new Jugador("Jugador 1", "Azul");
        CartaProvincia cartaProvincia = new CartaProvincia(Long.valueOf(1), Provincias.BUENOS_AIRES, Zonas.SUR, 100, 50, 200, 300);
        cartaProvincia.setConteoEstancias(1); // Se tiene una estancia para vender

        // Act
        boolean ventaExitosa = jugador.venderEstancia(cartaProvincia);

        // Assert
        assertTrue(ventaExitosa); // La venta debe ser exitosa
        assertEquals(35200, jugador.getDinero()); // El dinero debe aumentar en el valor de la estancia vendida
        assertEquals(0, cartaProvincia.getConteoEstancias()); // La estancia debe ser vendida y su conteo debe ser cero
    }


    @Test
    public void testComprarChacra() {
        // Arrange
        Jugador jugador = new Jugador("Jugador 1", "Azul");
        CartaProvincia cartaProvincia = new CartaProvincia(Long.valueOf(1), Provincias.BUENOS_AIRES, Zonas.SUR, 100, 50, 200, 300);
        CartaProvincia cartaProvincia2 = new CartaProvincia(Long.valueOf(2), Provincias.BUENOS_AIRES, Zonas.SUR, 100, 50, 200, 300);
        CartaProvincia cartaProvincia3 = new CartaProvincia(Long.valueOf(3), Provincias.BUENOS_AIRES, Zonas.SUR, 100, 50, 200, 300);
        CartaProvincia cartaProvincia4 = new CartaProvincia(Long.valueOf(4), Provincias.BUENOS_AIRES, Zonas.SUR, 100, 50, 200, 300);
        jugador.agregarCarta(cartaProvincia);
        jugador.agregarCarta(cartaProvincia2);
        jugador.agregarCarta(cartaProvincia3);
        jugador.agregarCarta(cartaProvincia4);
        // Act
        boolean compraExitosa = jugador.comprarChacra(cartaProvincia);

        // Assert
        assertTrue(compraExitosa);
        assertEquals(34950, jugador.getDinero());
    }

    @Test
    public void testVenderChacra() {
        // Arrange
        Jugador jugador = new Jugador("Jugador 1", "Azul");
        CartaProvincia cartaProvincia = new CartaProvincia(Long.valueOf(1), Provincias.BUENOS_AIRES, Zonas.SUR, 100, 50, 200, 300);
        jugador.agregarCarta(cartaProvincia);
        cartaProvincia.setConteoChacras(1);
        // Act
        boolean ventaExitosa = jugador.venderChacra(cartaProvincia);

        // Assert
        assertTrue(ventaExitosa);
        assertEquals(35025, jugador.getDinero());
    }

    @Test
    public void testPoseeTodasLasPropiedadesDeProvincia_CuatroCartas() {
        MazoPropiedades mazoPropiedades = new MazoPropiedades();
        // Arrange
        Jugador jugador = new Jugador("Jugador 1", "Azul");
        CartaProvincia carta1 = new CartaProvincia(Long.valueOf(1), Provincias.BUENOS_AIRES, Zonas.SUR, 100, 50, 200, 300);
        CartaProvincia carta2 = new CartaProvincia(Long.valueOf(2), Provincias.BUENOS_AIRES, Zonas.SUR, 100, 50, 200, 300);
        CartaProvincia carta3 = new CartaProvincia(Long.valueOf(3), Provincias.BUENOS_AIRES, Zonas.SUR, 100, 50, 200, 300);
        CartaProvincia carta4 = new CartaProvincia(Long.valueOf(4), Provincias.BUENOS_AIRES, Zonas.SUR, 100, 50, 200, 300);
        jugador.agregarCarta(carta1);
        jugador.agregarCarta(carta2);
        jugador.agregarCarta(carta3);
        jugador.agregarCarta(carta4);

        // Act
        boolean resultado = mazoPropiedades.poseeTodasLasProvincias(jugador, carta1);

        // Assert
        assertTrue(resultado);
    }
    @Test
    public void testPagarMonto_SuficienteDinero() {
        // Arrange
        Jugador jugador = new Jugador("Jugador 1", "Azul");
        jugador.setDinero(500); // Dinero suficiente para pagar el alquiler

        // Act
        boolean resultado = jugador.pagarMonto(200);

        // Assert
        assertTrue(resultado);
        assertEquals(300, jugador.getDinero()); // Dinero restante después de pagar el alquiler
    }

    @Test
    public void testCobrarAlquiler() {
        // Arrange
        Jugador jugador = new Jugador("Jugador 1", "Azul");
        jugador.setDinero(500); // Dinero inicial
        int alquiler = 200; // Monto del alquiler

        // Act
        boolean resultado = jugador.pagarMonto(alquiler);

        // Assert
        assertTrue(resultado);
        assertEquals(700, jugador.getDinero()); // Dinero restante después de cobrar el alquiler
    }

    @Test
    public void testTirarDado() {
        // Arrange
        Jugador jugador = new Jugador("Jugador 1", "Azul");

        // Act & Assert
        assertDoesNotThrow(jugador::tirarDado); // Verificar si no se lanza ninguna excepción al tirar el dado
    }


}