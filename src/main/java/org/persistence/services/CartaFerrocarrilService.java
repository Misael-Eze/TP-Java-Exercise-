package org.persistence.services;

import org.model.card.CartaCompania;
import org.model.card.CartaFerrocarril;
import org.persistence.repositories.CartaFerrocarrilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartaFerrocarrilService {
    CartaFerrocarril GuardarCartaFerrocarril(CartaFerrocarril cartaFerrocarril);
    List<CartaFerrocarril> BuscarCartas();
    CartaFerrocarril BuscarCarta(Long idCarta);
    CartaFerrocarril ActualizarCarta(CartaFerrocarril cartaFerrocarril);
    boolean BorrarCarta(Long idCarta);
    void BorrarCartas();
}
