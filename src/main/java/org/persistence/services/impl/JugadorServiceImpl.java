package org.persistence.services.impl;

import org.model.enums.EstadosJugadores;
import org.model.player.Jugador;
import org.modelmapper.ModelMapper;
import org.persistence.entities.JugadorEntity;
import org.persistence.repositories.JugadorRepository;
import org.persistence.services.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@ComponentScan("org.config")
public class JugadorServiceImpl implements JugadorService {
    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    JugadorServiceImpl(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
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

    /*id
     * nom
     * dinero
     * pos
     * est
     * tarjetaLib
     * doblesCons*/



    @Override
    public Jugador GuardarJugador(Jugador jugador) {
        JugadorEntity auxGuardar = new JugadorEntity();//modelMapper.map(jugador, JugadorEntity.class);
        auxGuardar.setNombre(jugador.getNombre());
        auxGuardar.setDinero(jugador.getDinero());
        auxGuardar.setPosicion(jugador.getPosicion());
        auxGuardar.setTarjetaLiberacion(jugador.getTarjetaLiberacion());
        auxGuardar.setDoblesConsecutivos(jugador.getDoblesConsecutivos());
        auxGuardar.setEstado(jugador.getEstado().getValue());
        jugadorRepository.save(auxGuardar);
        jugador.setId(auxGuardar.getId());
        return jugador;
    }

    @Override
    public Jugador BuscarJugador() {
        Optional<JugadorEntity> jugadorEntity;
        try{
             jugadorEntity = Optional.ofNullable(jugadorRepository.findAll().get(0));
            if(jugadorEntity.isPresent()){
                Jugador auxReturn = modelMapper.map(jugadorEntity.get(), Jugador.class);
                auxReturn.setEstado(this.getEstadoByInt(jugadorEntity.get().getEstado()));
                auxReturn.setPropiedades(new ArrayList<>());
                return auxReturn;
            }
        }
        catch(Exception ex){
            System.out.println("No hay jugador ni partida guardada!");
        }
        return null;
    }

    @Override
    public Jugador ActualizarJugador(Long id, Jugador jugador) {
        Optional<JugadorEntity> jugadorEntity = jugadorRepository.findById(id);
        if(jugadorEntity.isPresent()){
            jugadorEntity.get().setDinero(jugador.getDinero());
            jugadorEntity.get().setEstado(jugador.getEstado().getValue());
            jugadorEntity.get().setPosicion(jugador.getPosicion());
            jugadorEntity.get().setTarjetaLiberacion(jugador.getTarjetaLiberacion());
            jugadorEntity.get().setDoblesConsecutivos(jugador.getDoblesConsecutivos());
            jugadorRepository.save(jugadorEntity.get());
            return jugador;
        }
        return null;
    }

    @Override
    public boolean BorrarJugador(Long id) {
        boolean auxBorrar = false;
        Optional<JugadorEntity> auxReturn = jugadorRepository.findById(id);
        if(auxReturn.isPresent()){
            jugadorRepository.delete(auxReturn.get());
            auxBorrar = true;
        }
        return auxBorrar;
    }

    @Override
    public boolean ExisteJugador() {
        boolean auxReturn = false;
        List<JugadorEntity> lista = jugadorRepository.findAll();
        if (!lista.isEmpty()){
            auxReturn=true;
        }
        return auxReturn;
    }

    @Override
    public void BorrarJugadores() {
        jugadorRepository.deleteAll();
    }
}
