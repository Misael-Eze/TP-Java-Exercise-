package org.services;

import org.model.enums.Provincias;
import org.model.enums.TipoTarjeta;

public interface IPropiedad {
    String getDescripcion();
    int getValor();
    int getValorHipoteca();
    boolean isHipotecado();
    void setHipotecado(boolean hipotecado);
    int getValorChacra();
    int getValorEstancia();
    TipoTarjeta getTipoTarjeta();
    void setDuenio(IPeon jugador);
    void setIdDuenio(Long idDuenio);
    int calcularAlquiler(int input);
    IPeon getDuenio();
    Long getIdDuenio();
    int getNroCasillero();
}
