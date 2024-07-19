package org.services;

import org.model.player.*;

public interface IEstadoPeon {
    void jugar(Jugador jugador);
    void descansar(Jugador jugador);
    void encarcelar(Jugador jugador);
}