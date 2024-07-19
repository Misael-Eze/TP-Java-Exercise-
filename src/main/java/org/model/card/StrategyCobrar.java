package org.model.card;

import org.services.IPeon;
import org.services.IStrategyAzar;

public class StrategyCobrar implements IStrategyAzar {
    private final int montoACobrar;
    public StrategyCobrar(int montoACobrar) {
        this.montoACobrar = montoACobrar;
    }
    @Override
    public void activarEfecto(IPeon jugador) {
        jugador.cobrarMonto(montoACobrar);//jugador.CobrarMonto(montoACobrar);
        System.out.println("El jugador ha cobrado " + montoACobrar + " unidades.");
    }
}
