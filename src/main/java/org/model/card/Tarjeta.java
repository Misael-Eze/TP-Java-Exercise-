package org.model.card;

import org.services.IPeon;
import org.services.IStrategyAzar;
import org.services.ITarjeta;

public class Tarjeta implements ITarjeta {
    private final int id;
    private final String descripcion;
    private final IStrategyAzar strategy;

    public Tarjeta(int id, IStrategyAzar strategy,String descripcion) {
        this.id = id;
        this.strategy = strategy;
        this.descripcion = descripcion;
    }

    @Override
    public void activarCarta(IPeon jugador) {
        strategy.activarEfecto(jugador);
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    public int getId() {
        return id;
    }
}
