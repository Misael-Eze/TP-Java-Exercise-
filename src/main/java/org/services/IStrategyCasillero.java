package org.services;
import org.model.box.Casillero;

import java.util.Optional;

/**
 * Interfaz que define los métodos para la implementacion del patrón Strategy en la clase Casillero
 * @see Casillero
 */

public interface IStrategyCasillero {
    void accionCasillero(IPeon jugador);
}
