package org.model.enums;

public enum TipoTarjeta {
    FERROCARRIL(1),
    COMPANIA(2),
    PROVINCIA(3);

    private final int value;

    public int getValue() {
        return value;
    }

    private TipoTarjeta(int value){
        this.value = value;
    }

}
