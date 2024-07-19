package org.model.card;

import org.services.IPeon;
import org.services.IStrategyAzar;

import java.util.List;

public class StrategyCobrarJugadores implements IStrategyAzar {

    private final int montoACobrar;
    private final List<IPeon>jugadores;

    public StrategyCobrarJugadores(int montoACobrar, List<IPeon> jugadores) {
        this.montoACobrar = montoACobrar;
        this.jugadores = jugadores;
    }


    @Override
    public void activarEfecto(IPeon jugador) {
        for (IPeon otroJugador : jugadores) {
            if (otroJugador != jugador) {
                boolean pagoExitoso = otroJugador.pagarMonto(montoACobrar);//otroJugador.PagarMonto(montoACobrar);
                if (pagoExitoso) {
                    jugador.cobrarMonto(montoACobrar);//recibirPago(montoACobrar);
                    System.out.println("El jugador " + otroJugador.toString() + " ha pagado " + montoACobrar + " unidades al jugador " + jugador.toString());
                } else {
                    System.out.println("El jugador " + otroJugador.toString() + " no tiene suficiente dinero para pagar.");
                    // Menu de hipoteca?
                }
            }
        }
    }
}
