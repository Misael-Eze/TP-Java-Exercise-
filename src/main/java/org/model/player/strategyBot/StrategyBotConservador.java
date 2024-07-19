package org.model.player.strategyBot;

import org.model.card.CartaProvincia;
import org.model.enums.Provincias;
import org.services.IPropiedad;
import org.services.IStrategyBot;

import java.util.Arrays;
import java.util.List;

public class StrategyBotConservador implements IStrategyBot {
    private static final List<Provincias> PROVINCIAS_PREFERIDAS = Arrays.asList(Provincias.FORMOSA, Provincias.RIO_NEGRO, Provincias.SALTA);
    private static final int COMPRA_FUERA_PREFERENCIA_CADA_N = 5;
    private static final double MAX_COSTO_CONSTRUCCION = 0.3;



    @Override
    public boolean decidirCompraPropiedad(IPropiedad propiedad, int dinero, int cantidadCompras) {
        if (propiedad instanceof CartaProvincia) {
            if (PROVINCIAS_PREFERIDAS.contains(Provincias.valueOf(((CartaProvincia) propiedad).getProvincia().toString()))){
                return true;
            } else {
                return cantidadCompras >= COMPRA_FUERA_PREFERENCIA_CADA_N ;
            }
        }
        return false;
    }

    @Override
    public boolean decidirVenderPropiedad(IPropiedad propiedad, int dinero) {
        // Lógica de venta: Vende propiedad solo si no tiene dinero
        return dinero <= propiedad.getValorHipoteca();
    }

    @Override
    public boolean decidirComprarEstancia(IPropiedad propiedad, int dinero, int propiedadesVendidas) {
        // Construirá mejoras solo cuando el costo de la construcción no sobrepase el 30% de su dinero en cuenta
        return propiedad.getValorEstancia() <= dinero * MAX_COSTO_CONSTRUCCION;
    }

    @Override
    public boolean decidirVenderEstancia(IPropiedad propiedad, int dinero) {
        // Lógica de venta de estancia: No vende estancias
        return dinero <= propiedad.getValorEstancia();
    }

    @Override
    public boolean decidirComprarChacra(IPropiedad propiedad, int dinero, int propiedadesVendidas) {
        // Construirá mejoras solo cuando el costo de la construcción no sobrepase el 30% de su dinero en cuenta
        return propiedad.getValorChacra() <= dinero * MAX_COSTO_CONSTRUCCION;
    }

    @Override
    public boolean decidirVenderChacra(IPropiedad propiedad, int dinero) {
        // Lógica de venta de chacra: No vende chacras
        return dinero <= propiedad.getValorChacra();
    }

}
