package org.model.box.strategys;

import org.model.bank.Banco;
import org.model.card.CartaFerrocarril;
import org.services.IPeon;
import org.services.IPropiedad;
import org.services.IStrategyCasillero;
import org.services.IStrategyCasilleroPropiedad;

public class StrategyCasilleroFerrocarril implements IStrategyCasilleroPropiedad {
    private final Banco banco;
    public StrategyCasilleroFerrocarril(Banco banco) {
        this.banco = banco;
    }
    @Override
    public void accionCasillero(IPeon jugador, IPropiedad ferrocarril) {
        if (ferrocarril.getDuenio() == null){
            banco.ofrecerPropiedad(jugador, ferrocarril);
        }else if (ferrocarril.getDuenio() != null && ferrocarril.getDuenio() != jugador){
            banco.cobrarAlquiler(jugador, ferrocarril);
        }
    }
}


//    El problema que estás experimentando con el método accionCasillero de StrategyCasilleroFerrocarril
//    se debe a que estás intentando invocar el método getDuenio() en el objeto ferrocarril sin verificar primero si ferrocarril es null.
//    Esto genera un NullPointerException cuando ferrocarril no ha sido inicializado correctamente antes de pasar a accionCasillero.

//public class StrategyCasilleroFerrocarril implements IStrategyCasilleroPropiedad {
//
//    @Override
//    public void accionCasillero(IPeon jugador, IPropiedad ferrocarril) {
//        if (ferrocarril == null) {
//            System.out.println("Error: El ferrocarril no está inicializado correctamente.");
//            return; // O manejar de otra forma
//        }
//
//        if (ferrocarril.getDuenio() == null) {
//            Banco.getInstancia().ofrecerPropiedad(jugador, ferrocarril);
//        } else if (ferrocarril.getDuenio() != jugador) {
//            Banco.getInstancia().cobrarAlquilerFerrocarril(jugador, (CartaFerrocarril) ferrocarril);
//        }
//    }
//}