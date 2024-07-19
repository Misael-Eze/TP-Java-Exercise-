package org.model.box;

import org.model.enums.TipoCasillero;
import org.services.IPeon;
import org.services.IPropiedad;
import org.services.IStrategyCasilleroPropiedad;

/**
 * Clase que representa a los casilleros que pueden ser una propiedad
 * (Provincia, Compañía, Ferrocarril)
 * @see IPropiedad
 * @see IStrategyCasilleroPropiedad
 */
public class CasilleroPropiedad extends Casillero{
    private IStrategyCasilleroPropiedad estrategiaPropiedad;
    private IPropiedad propiedad;

    public void setPropiedad(IPropiedad propiedad) {
        this.propiedad = propiedad;
    }

    public IPropiedad getPropiedad() {
        return propiedad;
    }

    public CasilleroPropiedad(int nroCasillero, TipoCasillero tipoCasillero, IStrategyCasilleroPropiedad strategyPropiedad) {
        super(nroCasillero, tipoCasillero);
        this.estrategiaPropiedad = strategyPropiedad;
    }

    public void accionCasillero(IPeon jugador){
        estrategiaPropiedad.accionCasillero(jugador, propiedad);
    }
}
