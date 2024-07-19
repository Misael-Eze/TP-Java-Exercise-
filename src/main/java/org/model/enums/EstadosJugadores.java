package org.model.enums;

public enum EstadosJugadores {
    JUGANDO(1),
    PRESO(2),
    DESCANSANDO(3),
    BANCARROTA(4);

    private final int value;

    public int getValue() {
        return value;
    }

    private EstadosJugadores(int value) {
        this.value = value;
    }
}
