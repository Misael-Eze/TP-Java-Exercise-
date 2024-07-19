package org.persistence.repositories;

import org.persistence.entities.JugadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JugadorRepository extends JpaRepository<JugadorEntity,Long> {
    public Optional<JugadorEntity> findById(Long id);
}
