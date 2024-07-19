package org.persistence.services;

import org.model.player.Jugador;
import org.persistence.entities.JugadorEntity;
import org.springframework.stereotype.Service;

@Service
public interface JugadorService {
    Jugador GuardarJugador(Jugador jugador);
    Jugador BuscarJugador();
    Jugador ActualizarJugador(Long id, Jugador jugador);
    boolean BorrarJugador(Long id);
    boolean ExisteJugador();
    void BorrarJugadores();
}
