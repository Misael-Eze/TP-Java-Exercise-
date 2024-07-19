package org.model.box.strategys;
import org.services.IPeon;
import org.services.IStrategyCasillero;

public class StrategyCasilleroEstacionamiento implements IStrategyCasillero {
    @Override
    public void accionCasillero(IPeon jugador) {
        //Solo tendría que avisar al jugador que está en el casillero de descanso
        //No hace nada mas
    }
}
