package org.persistence.services;

import org.model.card.CartaProvincia;
import org.persistence.entities.CartaProvinciaEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CartaProvinciaService {
    CartaProvincia GuardarCartaProvincia(CartaProvincia cartaProvincia);
    List<CartaProvincia> BuscarCartas();
    CartaProvincia BuscarCartaProvincia(Long id);
    CartaProvincia ActualizarCarta(CartaProvincia cartaProvincia);
    boolean BorrarCarta(Long id);
    void BorrarCartas();
}
