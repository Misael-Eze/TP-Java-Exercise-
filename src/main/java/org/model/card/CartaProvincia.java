package org.model.card;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.model.enums.Provincias;
import org.model.enums.TipoTarjeta;
import org.model.enums.Zonas;
import org.services.IPeon;
import org.services.IPropiedad;
import org.services.ITarjeta;

import java.util.HashMap;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CartaProvincia implements IPropiedad {

    private Long idCarta;
    private String descripcion;
    private IPeon duenio;
    private Long idDuenio;
    private TipoTarjeta tipoCarta;
    public Provincias provincia;
    private Zonas zona;
    private int valorCompra;
    private int valorChacra;
    private int valorEstancia;
    private int valorHipoteca;
    private boolean hipotecado;
    private int conteoChacras;
    private int conteoEstancias;
    private int nroCasillero;
    private int valorAlquiler;

    public CartaProvincia(int nroCasillero, String descripcion, Provincias provincia, Zonas zona, int valor, int valorAlquiler, int valorChacra, int valorEstancia, int valorHipoteca) {
        this.nroCasillero = nroCasillero;
        this.valorAlquiler = valorAlquiler;
        this.tipoCarta = TipoTarjeta.PROVINCIA;
        this.duenio = null;
        this.descripcion = descripcion;
        this.provincia = provincia;
        this.valorCompra = valor;
        this.zona = zona;
        this.valorChacra = valorChacra;
        this.valorEstancia = valorEstancia;
        this.valorHipoteca = valorHipoteca;
        this.hipotecado = false;
        this.conteoChacras = 0;
        this.conteoEstancias = 0;
    }

    public CartaProvincia(Long idCarta, Provincias provincia, Zonas zona, int valor, int valorChacra, int valorEstancia, int valorHipoteca) {
        this.idCarta = idCarta;
        this.descripcion = "";
        this.tipoCarta = TipoTarjeta.PROVINCIA;
        this.duenio = null;
        this.provincia = provincia;
        this.valorCompra = valor;
        this.valorChacra = valorChacra;
        this.valorEstancia = valorEstancia;
        this.valorHipoteca = valorHipoteca;
        this.hipotecado = false;
        this.conteoChacras = 0;
        this.conteoEstancias = 0;
    }

    public Provincias getProvincias(){
        return this.provincia; }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public int getValor(){return this.valorCompra;}

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
        return valorChacra;
    }

    @Override
    public int getValorEstancia() {
        return valorEstancia;
    }

    @Override
    public TipoTarjeta getTipoTarjeta() {
        return tipoCarta;
    }

    @Override
    public int calcularAlquiler(int cantChacras) {
        switch (cantChacras){
            case 1:
                return valorAlquiler * 4;
            case 2:
                return valorAlquiler * 8;
            case 3:
                return valorAlquiler * 16;
            case 4:
                return valorAlquiler * 30;
            case 5:
                return valorAlquiler * 45;
            default:
                return valorAlquiler;
        }
    }

    @Override
    public void setDuenio(IPeon jugador) {
        this.duenio = jugador;
    }

    @Override
    public void setIdDuenio(Long idDuenio) {
        this.idDuenio=idDuenio;
    }

    public void agregarChacra(){
        this.conteoChacras++;
    }

    public void agregarEstancia(){
        this.conteoChacras = 5;
        this.conteoEstancias++;
    }


}

