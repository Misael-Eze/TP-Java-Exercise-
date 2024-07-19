package org.model.box.strategys;
import org.model.bank.Banco;
import org.services.IPeon;
import org.services.IStrategyCasillero;

public class StrategyCasilleroSalida implements IStrategyCasillero {
    private final Banco banco;

    public StrategyCasilleroSalida(Banco banco){
        this.banco = banco;
    }

    @Override
    public void accionCasillero(IPeon jugador) {
        System.out.println(jugador.getNombre()+" pasó por la salida, cobra 5000");
        //Cuando el jugador pasa por el casillero cobra 5000
        //Se usa el método pagarMonto que se podria cambiar a algo mas generico como pagar directamente

        banco.pagarAlJugador(jugador, 5000);
    }
}
