package org.model.player.strategyBot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.model.card.CartaProvincia;
import org.model.enums.Provincias;
import org.model.enums.Zonas;
import org.services.IPropiedad;
import org.services.IStrategyBot;

import static org.junit.jupiter.api.Assertions.*;

class StrategyBotAgresivoTest {
    @Test
    public void testStrategyBotAgresivo() {
        IStrategyBot strategy = new StrategyBotAgresivo();

        // Test de compra de propiedad
        IPropiedad propiedad1 = new CartaProvincia(Long.valueOf(1), Provincias.TUCUMAN, Zonas.NORTE, 100, 50, 75, 200);
        assertTrue(strategy.decidirCompraPropiedad(propiedad1, 1000, 5));

        // Test de venta de propiedad
        assertFalse(strategy.decidirVenderPropiedad(propiedad1, 500));

        // Test de compra de estancia
        assertTrue(strategy.decidirComprarEstancia(propiedad1, 1000, 5));

        // Test de venta de estancia
        assertFalse(strategy.decidirVenderEstancia(propiedad1, 500));

        // Test de compra de chacra
        assertTrue(strategy.decidirComprarChacra(propiedad1, 1000, 5));

        // Test de venta de chacra
        assertFalse(strategy.decidirVenderChacra(propiedad1, 500));
    }

}