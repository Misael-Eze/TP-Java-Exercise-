package org.model.box.strategys;

import org.services.IPeon;
import org.services.IStrategyCasillero;

public class StrategyCasilleroComisaria implements IStrategyCasillero {
    @Override
    public void accionCasillero(IPeon jugador) {
        //Si el jugador cae en éste casillero no hace nada
        //Pero si el jugador cae en marche-preso es enviado a éste casillero
    }
}
