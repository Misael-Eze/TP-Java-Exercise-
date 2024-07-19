package org.gameplay;

import lombok.Getter;
import lombok.Setter;
import org.model.bank.Banco;
import org.model.board.Tablero;
//import org.model.card.Mazo;
import org.model.card.MazoPropiedades;
import org.model.console.Consola;
import org.model.enums.EstadosJugadores;
import org.model.player.Bot;
import org.model.player.Dados;
import org.model.player.Jugador;
import org.persistence.facade.EstancieroFacade;
import org.persistence.services.BotService;
import org.services.IEstadoPeon;
import org.services.IPeon;
import org.springframework.data.repository.query.parser.Part;


import java.util.ArrayList;
import java.util.List;


public class PartidaEstanciero {
    @Getter
    @Setter
    private Banco bancoPartida;
    //private Mazo mazoPartida;

    @Getter
    @Setter
    private MazoPropiedades propiedades;

    @Getter
    @Setter
    private Tablero tableroPartida;
    @Getter
    @Setter
    private List<IPeon> jugadoresPartida = new ArrayList<>();
    private int turnoActual;
    @Setter
    @Getter
    private IPeon winner;
    @Setter
    private Integer cantidadGanar;
    private Consola consolaJuego;
    private Dados dados;




    public PartidaEstanciero(){
        this.dados = new Dados();
        this.propiedades = new MazoPropiedades();
        this.jugadoresPartida = new ArrayList<>();
//        this.tableroPartida = new Tablero(propiedades);
        this.consolaJuego = new Consola();
        this.winner = null;
    }


    /**
     * Constructor para testear
     * @param dados
     * @param consola
     * @param tablero
     */
    public PartidaEstanciero(Dados dados, Consola consola, Tablero tablero){
        this.dados = dados;
        this.propiedades = new MazoPropiedades();
        this.jugadoresPartida = new ArrayList<>();
        this.tableroPartida = tablero;
        this.consolaJuego = consola;
        this.winner = null;
    }


    public IPeon getWinner() {
        return winner;
    }

    public void iniciarPartida(Jugador jugador, List<IPeon> bots){
        propiedades = new MazoPropiedades();
        jugadoresPartida.add(jugador);
        jugadoresPartida.addAll(bots);
    }

    public void cargarPartida(List<IPeon> jugadorConBots){
        propiedades = new MazoPropiedades();
        jugadoresPartida.addAll(jugadorConBots);
    }


    public void crearPartida(Tablero tablero, Jugador jugador, List<IPeon> bots) {
        //AGREGAR PARA VER CUANTO DINERO SE GANA, SI ES Q EL JUGADOR ELIGE ESA OPCION!
        propiedades = tablero.getPropiedades();
        tableroPartida = tablero;
        jugadoresPartida = new ArrayList<>();
        jugadoresPartida.add(jugador);
        jugadoresPartida.addAll(bots);
    }


    public boolean iniciarPartida() {
        int turnoActual = 0;
        boolean salirYGuardar = false;
        while (!salirYGuardar){
            IPeon jugadorActual = jugadoresPartida.get(turnoActual);
            System.out.println("Turno de "+jugadorActual.getNombre());
            if (jugadorActual instanceof Jugador){
                int eleccion = consolaJuego.mostrarMenuTurno((Jugador) jugadorActual, this.tableroPartida);
                if (eleccion == 1){
                    jugarTurno(jugadorActual);
                } else if (eleccion == 2) {

                   int respuesta = consolaJuego.ofrecerGuardarPartida();

                    if (respuesta == 1){
                        //guardar la partida

                    }
                    else if (respuesta == 2){
                        //aca tiene que limpiar la base de datos tambien

                    }
                    salirYGuardar = true;
                }
            } else if (jugadorActual instanceof Bot) {
                jugarTurno(jugadorActual);
            }
            verificarSiHayGanador();
            if (winner != null){
                return true;
            }
            turnoActual = (turnoActual + 1) % jugadoresPartida.size();

        }
        return true;
    }

    public void verificarSiHayGanador(){
        int cantJugadores = jugadoresPartida.size();
        int cantEnBancarrota = 0;
        IPeon peonEnJuego = null;
        for (IPeon jugador : jugadoresPartida){
            if(jugador.getEstado() == EstadosJugadores.BANCARROTA){
                cantEnBancarrota++;
            }else{
                peonEnJuego = jugador;
            }

            if (jugador.getDinero() >= cantidadGanar) {
                setWinner(jugador);
            }
        }
        if (cantEnBancarrota == (cantJugadores - 1)){
            setWinner(peonEnJuego);
        }
    }
    
    public void jugarTurno(IPeon jugador){
        int doblesConsecutivos = 0;
        boolean dadosIguales = false;
        do {
            if (jugador.getEstado() == EstadosJugadores.JUGANDO) {
                if (doblesConsecutivos == 3) {
                    jugador.irALaCarcel();
                    break;
                }
                this.dados.rollDice();
                int sumaDados = this.dados.getDiceSum();
                consolaJuego.mostrarTirarDados(dados);
                if (this.dados.dadosIguales()) {
                    System.out.println("El jugador " + jugador.getNombre() + " sacado dados iguales! Dobles consecutivos: " + doblesConsecutivos);
                    dadosIguales = true;
                    doblesConsecutivos++;
                } else {
                    dadosIguales = false;
                }
                tableroPartida.moverJugador(jugador, sumaDados);
                System.out.println("El jugador " + jugador.getNombre() + " avanzó " + this.dados.getDiceSum() + " casillas");
                consolaJuego.informarCasillaActual(this.tableroPartida, jugador.getPosicion());
                tableroPartida.accionCasillero(jugador);
            } else if (jugador.getEstado() == EstadosJugadores.PRESO) {
                System.out.println("El jugador " + jugador.getNombre() + " se encuentra encarcelado.");
                jugador.setEstado(EstadosJugadores.JUGANDO);
            } else if (jugador.getEstado() == EstadosJugadores.DESCANSANDO && jugador.getTurnosDescansando() > 0){
                jugador.setTurnosDescansando(jugador.getTurnosDescansando() - 1);
                if (jugador.getTurnosDescansando() == 0){
                    jugador.setEstado(EstadosJugadores.JUGANDO);
                }
                System.out.println("Jugador descansando por "+jugador.getTurnosDescansando()+" turnos restantes");
            }
        } while (dadosIguales && doblesConsecutivos <= 3) ;

    }




//    private boolean verificarWinner(){
//        //Busca si hay un ganador, es decir si se cumple la condicion de que supere la cantidad para ganar o sea igual
//        // y se lo da a winner lo que nos devuelve true, si no que no haya ganador.
//        boolean aux  = false;
//        IPeon jugadorPeon;
//        if (this.cantidadGanar == null){
//            for (int i = 0; i < jugadoresPartida.size(); i++) {
//                jugadorPeon = jugadoresPartida.get(i);
//                if (jugadorPeon.getDinero()<= -1){
//                    winner = jugadorPeon;
//                    aux = true;
//                }
//            }
//        }
//        else {
//            for (IPeon jugador : jugadoresPartida) {
//                if (jugador.getDinero() >= cantidadGanar) {
//                    winner = jugador;
//                    aux = true;
//                }
//            }
//        }
//        return  aux;
//    }
}