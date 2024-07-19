package org.model.box;

import org.model.enums.TipoCasillero;
import org.services.IPeon;
import org.services.IStrategyCasillero;

/**
 * Clase que representa los casilleros del tablero
 */
public class Casillero {

    /**
     * Identificador del número de casillero
     */
    private int nroCasillero;
    /**
     * Tipo de casillero que puede ser
     *
     * @see TipoCasillero
     */
    private TipoCasillero tipoCasillero;
    /**
     * Implementacion del patrón Strategy para las distintas acciones de cada tipo de casillero
     */
    private IStrategyCasillero estrategiaCasillero;

    public void setTipoCasillero(TipoCasillero tipoCasillero) {
        this.tipoCasillero = tipoCasillero;
    }

    public TipoCasillero getTipoCasillero() {
        return tipoCasillero;
    }

    public int getNroCasillero() {
        return nroCasillero;
    }

    public void setNroCasillero(int nroCasillero) {
        this.nroCasillero = nroCasillero;
    }

    /**
     * Constructor sin parametros inicializa los atributos en 0 ó null
     */
    public Casillero() {
        nroCasillero = 0;
        tipoCasillero = null;
        estrategiaCasillero = null;
    }

    public Casillero(int nroCasillero, TipoCasillero tipoCasillero , IStrategyCasillero estrategiaCasillero) {
        this.nroCasillero = nroCasillero;
        this.tipoCasillero = tipoCasillero;
        this.estrategiaCasillero = estrategiaCasillero;
    }

    public Casillero(int nroCasillero, TipoCasillero tipoCasillero) {
        this.nroCasillero = nroCasillero;
        this.tipoCasillero = tipoCasillero;
    }


    public Casillero(TipoCasillero tipoCasillero) {
        this.tipoCasillero = tipoCasillero;
    }

    public void accionCasillero(IPeon jugador){
        estrategiaCasillero.accionCasillero(jugador);
    }
}
