package org.model.box.strategys;
import org.model.bank.Banco;
import org.model.card.CartaCompania;
import org.services.IPeon;
import org.services.IPropiedad;
import org.services.IStrategyCasillero;
import org.services.IStrategyCasilleroPropiedad;

/**
 * Ferrocarriles y compañias que los jugadores pueden adquirir
 */
public class StrategyCasilleroCompania implements IStrategyCasilleroPropiedad {
    private final Banco banco;
    public StrategyCasilleroCompania(Banco banco) {
        this.banco = banco;
    }

    @Override
    public void accionCasillero(IPeon jugador, IPropiedad compania) {
//        if (compania.getDuenio() != null && compania.getDuenio() == jugador) {
            if (compania.getDuenio() == null) {
                banco.ofrecerPropiedad(jugador, compania);
            } else if (compania.getDuenio() != null && compania.getDuenio() != jugador) {
                banco.cobrarAlquiler(jugador, compania);
            }
       // }
    }
}


//El problema en tu clase StrategyCasilleroCompania es que estás realizando una
//verificación incorrecta en la condición if para compania.getDuenio(). Vamos a corregir y mejorar
//la lógica para evitar el NullPointerException y asegurar que la comparación del dueño (duenio)
//funcione correctamente:

//public class StrategyCasilleroCompania implements IStrategyCasilleroPropiedad {
//
//    @Override
//    public void accionCasillero(IPeon jugador, IPropiedad compania) {
//        if (compania == null) {
//            System.out.println("Error: La compañía no está inicializada correctamente.");
//            return; // Salir del método si la compañía es null
//        }
//
//        if (compania.getDuenio() == null) {
//            Banco.getInstancia().ofrecerPropiedad(jugador, compania);
//        } else if (compania.getDuenio().equals(jugador)) {
//            // Aquí podrías querer ofrecer mejoras o realizar alguna otra acción específica
//        } else {
//            Banco.getInstancia().cobrarAlquilerCompania(jugador, (CartaCompania) compania);
//        }
//    }
//}