package org.model.box.strategys;

import org.model.bank.Banco;
import org.services.IPeon;
import org.services.IStrategyCasillero;

public class StrategyCasilleroPremio implements IStrategyCasillero {
    private final Banco banco;

    public StrategyCasilleroPremio(Banco banco){
        this.banco = banco;
    }
    @Override
    public void accionCasillero(IPeon jugador) {
        System.out.println("El jugador "+jugador.getNombre()+" ha sido beneficiado con un Premio Ganadero\n");
        System.out.println("Cobra 2500");
        banco.pagarAlJugador(jugador, 2500);
    }
}
