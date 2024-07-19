package org.model.player.strategyBot;

import org.model.card.CartaProvincia;
import org.model.enums.Provincias;
import org.model.enums.TipoTarjeta;
import org.services.IPropiedad;
import org.services.IStrategyBot;

import java.util.Arrays;
import java.util.List;

public class StrategyBotEquilibrado implements IStrategyBot {
    private static final List<Provincias> PROVINCIAS_PREFERIDAS = Arrays.asList(Provincias.MENDOZA, Provincias.SANTA_FE, Provincias.TUCUMAN);
    private static final TipoTarjeta PROPIEDAD_PREFERIDA = TipoTarjeta.FERROCARRIL;
    private static final int COMPRA_FUERA_PREFERENCIA_CADA_N = 3;
    private static final double MAX_COSTO_CONSTRUCCION = 0.5;
    private static final double MIN_PROP_VENDIDAS_PARA_CONSTRUIR = 0.75;

//    @Override
//    public boolean decidirCompraPropiedad(IPropiedad propiedad, int dinero, int cantidadCompras) {
//        if (PROVINCIAS_PREFERIDAS.contains(Provincias.valueOf(propiedad.getProvincia())) ||
//                propiedad.getTipoTarjeta() == PROPIEDAD_PREFERIDA) {
//            return true;
//        } else {
//            return cantidadCompras % COMPRA_FUERA_PREFERENCIA_CADA_N == 0;
//        }
//    }

    @Override
    public boolean decidirCompraPropiedad(IPropiedad propiedad, int dinero, int cantidadCompras) {
        if(propiedad instanceof CartaProvincia){
            if (PROVINCIAS_PREFERIDAS.contains(Provincias.valueOf(((CartaProvincia) propiedad).getProvincia().toString()))){
                return true;
            }
        }
        else if( propiedad.getTipoTarjeta() == PROPIEDAD_PREFERIDA){
            return true;
        }
        return cantidadCompras % COMPRA_FUERA_PREFERENCIA_CADA_N == 0;
    }

    @Override
    public boolean decidirVenderPropiedad(IPropiedad propiedad, int dinero) {
        // Lógica de venta: No vende propiedades
        return dinero <= propiedad.getValorHipoteca();
    }

    @Override
    public boolean decidirComprarEstancia(IPropiedad propiedad, int dinero, int propiedadesVendidas) {
        if (dinero * MAX_COSTO_CONSTRUCCION >= propiedad.getValorEstancia() ||
                propiedadesVendidas > 22) {
            return true;
        }
        return false;
    }

    @Override
    public boolean decidirVenderEstancia(IPropiedad propiedad, int dinero) {
        // Lógica de venta de estancia: No vende estancias
        return dinero <= propiedad.getValorEstancia();
    }

    @Override
    public boolean decidirComprarChacra(IPropiedad propiedad, int dinero, int propiedadesVendidas) {
        if (dinero * MAX_COSTO_CONSTRUCCION >= propiedad.getValorChacra() ||
                propiedadesVendidas > 22) {
            return true;
        }
        return false;
    }

    @Override
    public boolean decidirVenderChacra(IPropiedad propiedad, int dinero) {
        // Lógica de venta de chacra: No vende chacras
        return dinero <= propiedad.getValorChacra();
    }
}
