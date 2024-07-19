package org.model.card;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.model.enums.TipoTarjeta;
import org.model.player.Dados;
import org.services.IPeon;
import org.services.IPropiedad;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CartaCompania implements IPropiedad {

    private Long id;
    private IPeon duenio;
    private String descripcion;
    private TipoTarjeta tipoTarjeta;
    private Long idDuenio;
    private int valorAlquiler;
    private int valorHipoteca;
    private boolean hipotecado;
    private int nroCasillero;

    public CartaCompania(int nroCasillero, String descripcion,int valor, int valorHipoteca) {
        this.duenio = null;
        this.tipoTarjeta = TipoTarjeta.COMPANIA;
        this.valorAlquiler = valor;
        this.nroCasillero = nroCasillero;
        this.descripcion = descripcion;
        this.valorHipoteca = valorHipoteca;
        this.hipotecado = false;
    }

    public CartaCompania(int nroCasillero, String descripcion,int valor, int valorHipoteca, IPeon duenio) {
        this.duenio = duenio;
        this.tipoTarjeta = TipoTarjeta.COMPANIA;
        this.valorAlquiler = valor;
        this.nroCasillero = nroCasillero;
        this.descripcion = descripcion;
        this.valorHipoteca = valorHipoteca;
        this.hipotecado = false;
    }

    public CartaCompania(Long id, int valor, int valorHipoteca) {
        this.id = id;
        this.tipoTarjeta = TipoTarjeta.COMPANIA;
        this.valorAlquiler = valor;
        this.valorHipoteca = valorHipoteca;
        idDuenio = 0L;
        this.hipotecado = false;  // Inicialmente no está hipotecado
    }

    public Long getIdCarta() {
        return id;
    }

    public TipoTarjeta getTipoCarta() {
        return tipoTarjeta;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public int getValor() {
        return valorAlquiler;
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
        return 0;
    }

    @Override
    public int getValorEstancia() {
        return 0;
    }

    @Override
    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    @Override
    public int calcularAlquiler(int cantCompanias) {
        Dados.getInstance().rollDice();
        int valorDados = Dados.getInstance().getDiceSum();
        System.out.println("Valor dados: " + valorDados);
        switch (cantCompanias) {
            case 1:
                return valorDados * 100;
            case 2:
                return valorDados * 200;
            case 3:
                return valorDados * 300;
            default:
                return 0;
        }
    }



    @Override
    public void setDuenio(IPeon jugador) {
        this.duenio = jugador;
    }

    @Override
    public IPeon getDuenio() {
        return duenio;
    }
}
