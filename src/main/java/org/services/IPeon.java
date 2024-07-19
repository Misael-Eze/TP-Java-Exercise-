package org.services;

import org.model.card.CartaProvincia;
import org.model.enums.EstadosJugadores;

import java.util.List;

public interface IPeon {
    boolean comprarEstancia(CartaProvincia provincia);
    boolean venderEstancia(IPropiedad propiedad);
    boolean comprarChacra(CartaProvincia provincia);
    boolean venderChacra(IPropiedad propiedad);
    boolean comprarPropiedad(IPropiedad propiedad);
    boolean venderPropiedad(IPropiedad propiedad);
    boolean pagarMonto(int monto);
    boolean cobrarMonto(int monto);
    void tirarDado();
    public boolean tieneTarjetaLiberacion();
    boolean usarTarjetaLiberacion();
    void irALaCarcel ();
    String getNombre();
    public void recibirTarjetaLiberacion();
    void avanzarHasta(int posicion);
    int getPosicion();
    int getDinero();
    void setPosicion(int posicion);
    void setEstado(EstadosJugadores estado);
    Long getId();
    public List<IPropiedad> getPropiedades();
    EstadosJugadores getEstado();
    int getTurnosDescansando();
    void setTurnosDescansando(int turnosDescansando);
}
