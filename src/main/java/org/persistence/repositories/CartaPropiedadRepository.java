package org.persistence.repositories;

import org.model.card.CartaProvincia;
import org.model.enums.Provincias;
import org.persistence.entities.CartaProvinciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartaPropiedadRepository extends JpaRepository<CartaProvinciaEntity,Long> {
    Optional<List<CartaProvinciaEntity>> findCartasPropiedadByProvincia(int provincia);
}