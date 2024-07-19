package org.services;

import org.model.card.CartaProvincia;

public interface IStrategyBot {
    boolean decidirCompraPropiedad(IPropiedad propiedad, int dinero, int cantidadCompras);

    boolean decidirVenderPropiedad(IPropiedad propiedad, int dinero);

    boolean decidirComprarEstancia(IPropiedad propiedad, int dinero, int propiedadesVendidas);

    boolean decidirVenderEstancia(IPropiedad propiedad, int dinero);

    boolean decidirComprarChacra(IPropiedad propiedad, int dinero, int propiedadesVendidas);

    boolean decidirVenderChacra(IPropiedad propiedad, int dinero);
}