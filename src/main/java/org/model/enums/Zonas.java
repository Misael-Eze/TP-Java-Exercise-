package org.model.enums;

public enum Zonas {
    NORTE(1),
    CENTRO(2),
    SUR(3);

    private final int value;

    public int getValue() {
        return value;
    }

    private Zonas(int value){
        this.value=value;
    }
}
