package org.model.player.strategyBot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.model.card.CartaProvincia;
import org.model.enums.Provincias;
import org.model.enums.Zonas;
import org.services.IPropiedad;
import org.services.IStrategyBot;

import static org.junit.jupiter.api.Assertions.*;

class StrategyBotConservadorTest {
    // Test para decidirCompraPropiedad
    @Test
    public void testDecidirCompraPropiedad_ProvinciaPreferida() {
        IStrategyBot strategy = new StrategyBotConservador();
        IPropiedad propiedadFormosa = new CartaProvincia(Long.valueOf(1), Provincias.FORMOSA, Zonas.CENTRO, 200, 70, 100, 300);
        assertTrue(strategy.decidirCompraPropiedad(propiedadFormosa, 1000, 5));
    }

    @Test
    public void testDecidirCompraPropiedad_CantidadComprasMultiplo() {
        IStrategyBot strategy = new StrategyBotConservador();
        IPropiedad propiedadCordoba = new CartaProvincia(Long.valueOf(1), Provincias.CORDOBA, Zonas.CENTRO, 250, 80, 110, 320);
        assertFalse(strategy.decidirCompraPropiedad(propiedadCordoba, 1000, 4));
    }

    // Test para decidirVenderPropiedad
    @Test
    public void testDecidirVenderPropiedad_DineroInsuficiente() {
        IStrategyBot strategy = new StrategyBotConservador();
        IPropiedad propiedad = new CartaProvincia(Long.valueOf(1), Provincias.FORMOSA, Zonas.CENTRO, 200, 70, 100, 300);
        assertTrue(strategy.decidirVenderPropiedad(propiedad, 0));
    }

    // Test para decidirComprarEstancia
    @Test
    public void testDecidirComprarEstancia_CostoConstruccionSuficiente() {
        IStrategyBot strategy = new StrategyBotConservador();
        IPropiedad propiedad = new CartaProvincia(Long.valueOf(1), Provincias.FORMOSA, Zonas.CENTRO, 200, 70, 100, 300);
        assertTrue(strategy.decidirComprarEstancia(propiedad, 1000, 2));
    }

    // Test para decidirVenderEstancia
    @Test
    public void testDecidirVenderEstancia_DineroSuficiente() {
        IStrategyBot strategy = new StrategyBotConservador();
        IPropiedad propiedad = new CartaProvincia(Long.valueOf(1), Provincias.FORMOSA, Zonas.CENTRO, 200, 70, 100, 300);
        assertFalse(strategy.decidirVenderEstancia(propiedad, 400));
    }

    // Test para decidirComprarChacra
    @Test
    public void testDecidirComprarChacra_CostoConstruccionSuficiente() {
        IStrategyBot strategy = new StrategyBotConservador();
        IPropiedad propiedad = new CartaProvincia(Long.valueOf(1), Provincias.FORMOSA, Zonas.CENTRO, 200, 70, 100, 300);
        assertTrue(strategy.decidirComprarChacra(propiedad, 1000, 5));
    }

    // Test para decidirVenderChacra
    @Test
    public void testDecidirVenderChacra_DineroSuficiente() {
        IStrategyBot strategy = new StrategyBotConservador();
        IPropiedad propiedad = new CartaProvincia(Long.valueOf(1), Provincias.FORMOSA, Zonas.CENTRO, 200, 70, 100, 300);
        assertFalse(strategy.decidirVenderChacra(propiedad, 400));
    }

}