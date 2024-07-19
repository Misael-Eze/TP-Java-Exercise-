package org.persistence.repositories;

import org.model.player.Bot;
import org.persistence.entities.BotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BotRepository extends JpaRepository<BotEntity, Long> {
    public Optional<BotEntity> findById(Long id);
    public Optional<List<BotEntity>> findBotEntitiesById(Long id);
}