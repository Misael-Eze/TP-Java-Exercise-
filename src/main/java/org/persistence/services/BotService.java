package org.persistence.services;

import org.model.player.Bot;
import org.persistence.entities.BotEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BotService {
    Bot GuardarBot(Bot bot);
    List<Bot> BuscarBots();
    Bot BuscarBot(Long id);
    Bot ActualizarBot(Long id, Bot bot);
    boolean BorrarBot(Long idBot);
    void BorrarBots();
}
