package org.services;


import org.model.enums.TipoTarjeta;

//Interfaz que queda para las tarjetas de azar
public interface ITarjeta {
//    int getIdCarta();
//    TipoTarjeta getTipoCarta();
//    //void accionTarjeta() ????
    void activarCarta(IPeon jugador);
    String getDescripcion();
}

