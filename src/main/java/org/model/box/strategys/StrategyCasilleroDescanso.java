package org.model.box.strategys;
import org.model.console.Consola;
import org.model.enums.EstadosJugadores;
import org.model.player.Bot;
import org.model.player.Jugador;
import org.services.IPeon;
import org.services.IStrategyCasillero;

public class StrategyCasilleroDescanso implements IStrategyCasillero {
    private Consola consola;

    public StrategyCasilleroDescanso(Consola consola) {
        this.consola = consola;
    }

    @Override
    public void accionCasillero(IPeon jugador) {
        boolean respuesta = false;
        if (jugador instanceof Jugador){
            respuesta = consola.preguntarSiQuiereDescansar(jugador);
        } else if (jugador instanceof Bot){
//            respuesta = (Bot) jugador.consultarDescanso();
        }
        if (respuesta){
            jugador.setEstado(EstadosJugadores.DESCANSANDO);
            jugador.setTurnosDescansando(2);
        }
    }
}
