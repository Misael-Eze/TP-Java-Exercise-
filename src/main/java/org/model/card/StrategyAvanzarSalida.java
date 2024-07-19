package org.model.card;

import org.services.IPeon;
import org.services.IStrategyAzar;

public class StrategyAvanzarSalida implements IStrategyAzar {
    @Override
    public void activarEfecto(IPeon jugador) {
        jugador.avanzarHasta(0);
    }
}
