package org.model.enums;

public enum Provincias {
    FORMOSA(1),
    RIO_NEGRO(2),
    SALTA(3),
    MENDOZA(4),
    SANTA_FE(5),
    TUCUMAN(6),
    BUENOS_AIRES(7),
    CORDOBA(8);

    private final int value;

    public int getValue() {
        return value;
    }

    private Provincias(int value){
        this.value=value;
    }
}
