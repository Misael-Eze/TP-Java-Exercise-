package org.model.box.strategys;
import org.model.enums.EstadosJugadores;
import org.services.IPeon;
import org.services.IStrategyCasillero;

public class StrategyCasilleroMarchePreso implements IStrategyCasillero {
    @Override
    public void accionCasillero(IPeon jugador) {
        jugador.setPosicion(14);
        jugador.setEstado(EstadosJugadores.PRESO);
    }
}
