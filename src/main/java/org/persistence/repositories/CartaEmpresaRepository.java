package org.persistence.repositories;

import org.model.card.CartaCompania;
import org.persistence.entities.CartaEmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaEmpresaRepository extends JpaRepository<CartaEmpresaEntity, Long> {
}
