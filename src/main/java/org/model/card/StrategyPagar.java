package org.model.card;

import org.model.bank.Banco;
import org.services.IPeon;
import org.services.IStrategyAzar;

public class StrategyPagar implements IStrategyAzar {
    private final int montoAPagar;
    private final Banco banco;

    @Override
    public void activarEfecto(IPeon jugador) {

        System.out.println("El jugador ha pagado $" + montoAPagar + " Pesos.");
        banco.cobrarMonto(jugador,montoAPagar);
    }
    public StrategyPagar(int montoAPagar, Banco banco) {

        this.montoAPagar = montoAPagar;
        this.banco = banco;
    }
}
