package org.model.box.strategys;
import org.model.bank.Banco;
import org.model.card.CartaFerrocarril;
import org.model.card.CartaProvincia;
import org.services.IPeon;
import org.services.IPropiedad;
import org.services.IStrategyCasillero;
import org.services.IStrategyCasilleroPropiedad;

public class StrategyCasilleroProvincia implements IStrategyCasilleroPropiedad {
    private final Banco banco;

    public StrategyCasilleroProvincia(Banco banco){
        this.banco = banco;
    }
    @Override
    public void accionCasillero(IPeon jugador, IPropiedad provincia) {
        if (provincia.getDuenio() == null){
            banco.ofrecerPropiedad(jugador, provincia);
        }else if (provincia.getDuenio() == jugador) {
            //Solo puede mejorar si posee la serie completa de Provincias
            if (banco.getPropiedades().poseeTodasLasProvincias(jugador, (CartaProvincia) provincia)){
                banco.ofrecerMejoras(jugador, (CartaProvincia) provincia);
            }else{
                System.out.println("Para realizar mejoras se necesita tener la provincia completa.");
            }
        }else{
            banco.cobrarAlquiler(jugador, provincia);
        }
    }


}

/*
* Para solucionar el error NullPointerException que estás experimentando en el método accionCasillero de StrategyCasilleroProvincia,
*  donde se produce al intentar invocar getDuenio() en el objeto provincia, necesitas asegurarte de que el objeto provincia no sea null
*  antes de intentar acceder a sus métodos. Aquí te explico cómo puedes manejar esto:
* */



//public class StrategyCasilleroProvincia implements IStrategyCasilleroPropiedad {
//
//    @Override
//    public void accionCasillero(IPeon jugador, IPropiedad provincia) {
//        if (provincia == null) {
//            // Manejar el caso donde provincia es null (puede lanzar una excepción o realizar alguna acción alternativa)
//            System.out.println("Error: La provincia es nula.");
//            return; // Salir del método o manejar el error según el contexto
//        }
//
//        if (provincia.getDuenio() == null) {
//            Banco.getInstancia().ofrecerPropiedad(jugador, provincia);
//        } else if (provincia.getDuenio() == jugador) {
//            // Implementar lógica para ofrecer mejoras
//            Banco.getInstancia().ofrecerMejoras(jugador, (CartaProvincia) provincia); // Implementa este método en Banco si no está
//        } else {
//            Banco.getInstancia().cobrarAlquilerProvincia(jugador, (CartaProvincia) provincia);
//        }
//    }
//}
