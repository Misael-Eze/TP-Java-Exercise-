package org.persistence.services.impl;

import org.model.bank.Banco;
import org.model.enums.EstadosJugadores;
import org.model.player.Bot;
import org.model.player.strategyBot.*;
import org.modelmapper.ModelMapper;
import org.persistence.entities.BotEntity;
import org.persistence.repositories.BotRepository;
import org.persistence.services.BotService;
import org.services.IStrategyBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ComponentScan("org.persistence.repositories")
@Service
public class BotServiceImpl implements BotService {
    @Autowired
    private BotRepository botRepository;

    @Qualifier("modelMapper")
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public BotServiceImpl(BotRepository botRepository) {
        this.botRepository = botRepository;
    }

    public IStrategyBot getStrategyByInt(int idStrategy){
        IStrategyBot auxReturn = null;
        switch (idStrategy){
            case 1:
                auxReturn= new StrategyBotConservador();
                break;
                case 2:
                    auxReturn= new StrategyBotEquilibrado();
                    break;
                    case 3:
                        auxReturn= new StrategyBotAgresivo();
                        break;
        }
        return auxReturn;
    }

    /*
    * Para las estrategias de los bots:
    * Conservador = 1
    * Equilibrado = 2
    * Agresivo = 3
     */
    public int getIntStrategy(IStrategyBot strategyBot){
        int auxReturn = 0;
        if(strategyBot instanceof StrategyBotAgresivo){
            auxReturn=3;
        }
        else if(strategyBot instanceof StrategyBotEquilibrado){
            auxReturn=2;
        } else if (strategyBot instanceof StrategyBotConservador) {
            auxReturn=1;
        }
        return auxReturn;
    }

    public EstadosJugadores getEstadoByInt(int estado){
        switch (estado){
            case 1:
                return EstadosJugadores.JUGANDO;
            case 2:
                return EstadosJugadores.PRESO;
            case 3:
                return EstadosJugadores.DESCANSANDO;
            default:
                return null;
        }
    }

    /*
     * id
     * nom
     * dinero
     * pos
     * tarjetaLib
     * estado
     * estrategia
     * doblesCons
     */

    @Override
    public Bot GuardarBot(Bot bot){
        BotEntity auxGuardar = new BotEntity();
        auxGuardar.setNombre(bot.getNombre());
        auxGuardar.setDinero(bot.getDinero());
        auxGuardar.setPosicion(bot.getPosicion());
        auxGuardar.setTarjetaLiberacion(bot.getTarjetaLiberacion());
        auxGuardar.setDoblesConsecutivos(bot.getDoblesConsecutivos());
        auxGuardar.setEstado(bot.getEstado().getValue());
        auxGuardar.setEstrategia(this.getIntStrategy(bot.getEstrategia()));
        botRepository.save(auxGuardar);
        bot.setId(auxGuardar.getId());
        return bot;
    }

    @Override
    public List<Bot> BuscarBots() {
        List<Bot> auxReturn = new ArrayList<>();
        List<BotEntity> bots = botRepository.findAll();
            for (BotEntity botEntity : bots){
                Bot aux = modelMapper.map(botEntity, Bot.class);
                aux.setEstrategia(this.getStrategyByInt(botEntity.getEstrategia()));
                aux.setEstado(this.getEstadoByInt(botEntity.getEstado()));
                aux.setPropiedades(new ArrayList<>());
                auxReturn.add(aux);
        }
        return auxReturn;
    }

    @Override
    public Bot BuscarBot(Long idBot) {
        Optional<BotEntity> botEntity = botRepository.findById(idBot);
        if(botEntity.isPresent()){
            Bot auxReturn = modelMapper.map(botEntity.get(), Bot.class);
            auxReturn.setEstrategia(this.getStrategyByInt(botEntity.get().getEstrategia()));
            auxReturn.setEstado(this.getEstadoByInt(botEntity.get().getEstado()));
            auxReturn.setPropiedades(new ArrayList<>());
//            auxReturn.setBanco(Banco.getInstancia());
            return auxReturn;
        }
        return null;
    }

    @Override
    public Bot ActualizarBot(Long idPartida, Bot bot) {
        Optional<BotEntity> botEntity = botRepository.findById(idPartida);
        if(botEntity.isPresent()){
            botEntity.get().setDinero(bot.getDinero());
            botEntity.get().setEstado(bot.getEstado().getValue());
            botEntity.get().setPosicion(bot.getPosicion());
            botEntity.get().setTarjetaLiberacion(bot.getTarjetaLiberacion());
            botEntity.get().setDoblesConsecutivos(bot.getDoblesConsecutivos());
            botRepository.save(botEntity.get());
            return bot;
        }
        return null;
    }

    @Override
    public boolean BorrarBot(Long idBot) {
        boolean auxBorrar = false;
        Optional<BotEntity> auxReturn = botRepository.findById(idBot);
        if(auxReturn.isPresent()){
            botRepository.delete(auxReturn.get());
            auxBorrar = true;
        }
        return auxBorrar;
    }

    @Override
    public void BorrarBots() {
        botRepository.deleteAll();
    }

}
