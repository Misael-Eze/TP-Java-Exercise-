package org.model.card;

import lombok.Getter;
import lombok.Setter;
import org.model.enums.Provincias;
import org.model.enums.TipoTarjeta;
import org.services.IPeon;
import org.services.IPropiedad;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class CartaFerrocarril implements IPropiedad {
    private Long id;
    private IPeon duenio;
    private Long idDuenio;
    private String descripcion;
    private TipoTarjeta tipoTarjeta;
    private int valor;
    private int valorHipoteca;
    private int nroCasillero;
    private boolean hipotecado;

    public CartaFerrocarril(int nroCasillero, String descripcion, int valor, int valorHipoteca) {
        this.duenio = null;
        this.tipoTarjeta = TipoTarjeta.FERROCARRIL;
        this.valor = valor;
        this.nroCasillero = nroCasillero;
        this.descripcion = descripcion;
        this.valorHipoteca = valorHipoteca;
        this.hipotecado = false;
    }

    public int getNroCasillero(){
        return nroCasillero;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public int getValor() {
        return valor;
    }

    @Override
    public int getValorHipoteca() {
        return valorHipoteca;
    }

    @Override
    public boolean isHipotecado() {
        return hipotecado;
    }

    @Override
    public void setHipotecado(boolean hipotecado) {
        this.hipotecado = hipotecado;
    }

    @Override
    public int getValorChacra() {
        return getValorChacra();
    }

    @Override
    public int getValorEstancia() {
        return getValorEstancia();
    }

    @Override
    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    @Override
    public void setDuenio(IPeon jugador) {
        this.duenio = jugador;
    }

    @Override
    public void setIdDuenio(Long idDuenio){this.idDuenio=idDuenio;}

    @Override
    public int calcularAlquiler(int cantFerrocarriles) {
        switch (cantFerrocarriles) {
            case 1:
                return 500;
            case 2:
                return 1000;
            case 3:
                return 2000;
            case 4:
                return 4000;
            default:
                return 0;
        }
    }



    @Override
    public IPeon getDuenio() {
        return null;
    }
    @Override
    public Long getIdDuenio(){return this.idDuenio;}

}
