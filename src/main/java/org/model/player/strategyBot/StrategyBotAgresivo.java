package org.model.player.strategyBot;

import org.model.card.CartaProvincia;
import org.model.enums.Provincias;
import org.model.enums.TipoTarjeta;
import org.services.IPropiedad;
import org.services.IStrategyBot;

import java.util.Arrays;
import java.util.List;

public class StrategyBotAgresivo implements IStrategyBot {
    private static final List<Provincias> PROVINCIAS_PREFERIDAS = Arrays.asList(Provincias.TUCUMAN, Provincias.CORDOBA, Provincias.BUENOS_AIRES);
    private static final List<TipoTarjeta> TIPOS_PROP_PREFERIDOS = Arrays.asList(TipoTarjeta.FERROCARRIL, TipoTarjeta.COMPANIA);
    private static final double MAX_COSTO_CONSTRUCCION = 1.0; // No hay límite de construcción de mejoras

//    @Override
//    public boolean decidirCompraPropiedad(IPropiedad propiedad, int dinero, int cantidadCompras) {
//        // Siempre compra propiedades, priorizando las provincias preferidas y los tipos preferidos
//        if (PROVINCIAS_PREFERIDAS.contains(Provincias.valueOf(propiedad.getProvincia().toString())) ||
//                TIPOS_PROP_PREFERIDOS.contains(propiedad.getTipoTarjeta())) {
//            return true;
//        }
//        return true; // Siempre compra propiedades sin importar la preferencia
//    }

    @Override
    public boolean decidirCompraPropiedad(IPropiedad propiedad, int dinero, int cantidadCompras) {
        // Siempre compra propiedades, priorizando las provincias preferidas y los tipos preferidos
        if(propiedad instanceof CartaProvincia){
            if (PROVINCIAS_PREFERIDAS.contains(Provincias.valueOf(((CartaProvincia) propiedad).getProvincia().toString()))){
                return true;
            }
        }
        else if(TIPOS_PROP_PREFERIDOS.contains(propiedad.getTipoTarjeta())) {
            return true;
        }
        return true; // Siempre compra propiedades sin importar la preferencia
    }


    @Override
    public boolean decidirVenderPropiedad(IPropiedad propiedad, int dinero) {
        // Lógica de venta: No vende propiedades
        return dinero <= propiedad.getValorHipoteca();
    }

    @Override
    public boolean decidirComprarEstancia(IPropiedad propiedad, int dinero, int propiedadesVendidas) {
        // Prioriza la expansión rápida y construye mejoras cada vez que pueda
        return true;
    }

    @Override
    public boolean decidirVenderEstancia(IPropiedad propiedad, int dinero) {
        // Lógica de venta de estancia: No vende estancias
        return dinero <= propiedad.getValorEstancia();
    }

    @Override
    public boolean decidirComprarChacra(IPropiedad propiedad, int dinero, int propiedadesVendidas) {
        // Prioriza la expansión rápida y construye mejoras cada vez que pueda
        return propiedad.getValor() < dinero;
    }

    @Override
    public boolean decidirVenderChacra(IPropiedad propiedad, int dinero) {
        // Lógica de venta de chacra: No vende chacras
        return dinero <= propiedad.getValorChacra();
    }
}
