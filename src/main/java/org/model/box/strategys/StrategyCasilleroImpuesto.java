package org.model.box.strategys;

import org.model.bank.Banco;
import org.services.IPeon;
import org.services.IStrategyCasillero;

public class StrategyCasilleroImpuesto implements IStrategyCasillero {
    private final Banco banco;

    public StrategyCasilleroImpuesto(Banco banco){
        this.banco = banco;
    }

    @Override
    public void accionCasillero(IPeon jugador) {
        if (jugador.getPosicion() == 4){
            System.out.println("Impuesto a los reditos \nPague 5000");
            banco.cobrarMonto(jugador, 5000);
        } else if (jugador.getPosicion() == 41) {
            System.out.println("Impuesto a las ventas \nPague 2000");
            banco.cobrarMonto(jugador, 2000);
        }
    }
}
