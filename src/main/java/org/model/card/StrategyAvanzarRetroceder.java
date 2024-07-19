package org.model.card;

import org.services.IPeon;
import org.services.IStrategyAzar;


public class StrategyAvanzarRetroceder implements IStrategyAzar {
    private final int casillaNumero;
    public StrategyAvanzarRetroceder(int casillaNumero) {
        this.casillaNumero = casillaNumero;
    }
    @Override
    public void activarEfecto(IPeon jugador) {
        jugador.avanzarHasta(casillaNumero);
        System.out.println("El jugador se movio a la casilla Numero:" + casillaNumero);
    }
}
