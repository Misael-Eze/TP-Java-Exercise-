package org.persistence.services;

import org.model.card.CartaCompania;
import org.persistence.entities.CartaEmpresaEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CartaEmpresaService {
    CartaCompania GuardarCartaEmpresa(CartaCompania cartaCompania);
    List<CartaCompania> BuscarCartas();
    CartaCompania BuscarCarta(Long idCarta);
    CartaCompania ActualizarCarta(CartaCompania cartaCompania);
    boolean BorrarCarta(Long idCarta);
    void BorrarCartas();
}
