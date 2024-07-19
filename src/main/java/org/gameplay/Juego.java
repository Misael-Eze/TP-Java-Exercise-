
package org.gameplay;

import org.model.bank.Banco;
import org.model.board.Tablero;
import org.model.card.CartaCompania;
import org.model.card.CartaFerrocarril;
import org.model.card.CartaProvincia;
import org.model.card.MazoPropiedades;
import org.model.console.Consola;
import org.model.console.Grafico;
import org.model.console.Validacion;
import org.model.enums.ColoresJugador;
import org.model.player.Bot;
import org.model.player.Jugador;
import org.persistence.facade.EstancieroFacade;
import org.services.IModoJuego;
import org.services.IPeon;
import org.services.IPropiedad;
import org.services.impl.ModoDificil;
import org.services.impl.ModoFacil;
import org.services.impl.ModoMedio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Juego {
    private PartidaEstanciero partida;
    private IModoJuego modoJuego;
    private EstancieroFacade facade;
    private boolean firstSave;
    private Consola consola;

    public void setModoJuego(IModoJuego modoJuego) {
        this.modoJuego = modoJuego;
    }

    public IModoJuego getModoJuego() {
        return modoJuego;
    }

    public Juego(EstancieroFacade facade){
        partida = new PartidaEstanciero();
        this.consola = new Consola();
        this.facade = facade;
        firstSave = true;
    }

    public void comenzarJuego(){
        /*if (facade.ExisteJugadorPartida()){
            int respuesta = consola.decidirGuardarPartida();

            if (respuesta == 1) {
                consola.esperar();
                if (recuperarPartida()){
                    boolean auxSalir = false;
                    while(!auxSalir){
                        auxSalir = this.correrPartida();
                    }
                    this.actualizarPartida();
                   //System.exit(0);

                }
                else{
                    System.out.println("No se encontro una partida guardada...");
                    comenzarJuego();
                }
            } else if (respuesta ==2) {
                facade.LimpiarBd();

            }
        }*/


        consola.menuInicial();

        int auxSeleccionPartida = consola.opcionSeleccionPartida();
        if (auxSeleccionPartida == 1) {
            if(facade.ExisteJugadorPartida()){
                int respuesta = consola.decidirGuardarPartida();
                if (respuesta==1){
                    facade.LimpiarBd();
                    nuevaPartida();
                }
                else{
                    return;
                }
            }
            else{
                nuevaPartida();
            }
        }
        else if (auxSeleccionPartida == 2) {
            if (recuperarPartida()){
                boolean auxSalir = false;
                while(!auxSalir){
                    auxSalir = this.correrPartida();
                }
                this.actualizarPartida();
                System.exit(0);
            }
            else{
                System.out.println("No se encontro una partida guardada...");
                comenzarJuego();
            }
        }
    }


    public boolean recuperarPartida(){
        boolean auxReturn = false;
        firstSave = false;
        MazoPropiedades propiedades = new MazoPropiedades();
        Banco banco = new Banco(consola, propiedades);
        Tablero tablero = new Tablero(propiedades, banco, consola);
        partida.setPropiedades(propiedades);
        partida.setTableroPartida(tablero);
        //Implementar el uso del facade.
        this.partida.setJugadoresPartida(this.facade.RecuperarJugadorConBots());
        if(this.partida.getJugadoresPartida().size()<3) {
            return false;
        }
        List<IPropiedad> auxObtain = new ArrayList<>();
        auxObtain.addAll(facade.BuscarTarjetasCompania());
        auxObtain.addAll(facade.BuscarTarjetasFerrocarril());
        auxObtain.addAll(facade.BuscarTarjetasProvincia());
        this.partida.getPropiedades().actualizarPropiedades(auxObtain);
        for(IPropiedad tarjeta : auxObtain){
//                tablero.getPropiedades().actualizarPropiedad();
//                Banco.getInstancia().agregarCartaAlMazo(tarjeta);
            for(IPeon peon : partida.getJugadoresPartida()){
                if(Objects.equals(tarjeta.getIdDuenio(), peon.getId())){
                    if(peon instanceof Jugador){
                        ((Jugador) peon).getPropiedades().add(tarjeta);
                    } else if (peon instanceof Bot) {
                        ((Bot) peon).getPropiedades().add(tarjeta);
                        }
                    }
                }
            }
        auxReturn = true;
        return auxReturn;
    }

    public void nuevaPartida(){
        this.partida = new PartidaEstanciero();

        //Creacion de jugador
        String nombJugador = consola.darBienvenidaYPedirNombre();
        Jugador jugador = new Jugador(nombJugador);

        //Seleccion de modo de juego
        IModoJuego modoJuego = null;
        while(modoJuego == null) {
            int auxSeleccionDificultad = consola.seleccionarDificultad();
            switch (auxSeleccionDificultad) {
                case 1:
                    modoJuego = new ModoFacil();
                    break;
                case 2:
                    modoJuego = new ModoMedio();
                    break;
                case 3:
                    modoJuego = new ModoDificil();
                    break;
                default:
                    System.out.println("Ingrese una opcion valida.");
            }
        }

        //Pedir monto para ganar
        int dinero = consola.pedirMontoParaGanar();
        partida.setCantidadGanar(dinero);
//        partida.cre

        //Crear propiedades en blanco y tablero
        MazoPropiedades propiedades = new MazoPropiedades();
        Banco banco = new Banco(consola, propiedades);
        Tablero tablero = new Tablero(propiedades, banco, consola);

        //Crear partida con los valores creados anteriormente
        partida.crearPartida(tablero, jugador, modoJuego.getBots());

        boolean auxSalir = false;
        while(!auxSalir){
            auxSalir = this.correrPartida();
        }
        System.out.println("Juego terminado, saliendo...");
        if (partida.getWinner() != null){
            IPeon ganador = partida.getWinner();
            consola.mostrarGandor(ganador);
        }
        if (firstSave){
            this.guardarPartida();
        }
        else{
            this.actualizarPartida();
        }
    }

    public boolean correrPartida(){
        return partida.iniciarPartida();
    }

    public PartidaEstanciero guardarPartida(){
        //mediante el uso del facade guardar => Jugador, bot y cartas.
        //SOLO PARA QUE SE GUARDE LA INFO DE LA PARTIDA POR PRIMERA VEZ!!!
        if(firstSave){
            this.facade.GuardarPeones(this.partida.getJugadoresPartida());
            this.facade.GuardarTarjetasCompania(this.partida.getPropiedades().obtenerCartasCompaniaConDuenio());
            this.facade.GuardarTarjetasProvincia(this.partida.getPropiedades().obtenerCartasProvinciaConDuenio());
            this.facade.GuardarTarjetasFerrocarril(this.partida.getPropiedades().obtenerCartasFerrocarrilConDuenio());
            firstSave = false;
        }
        return this.partida;
    }

    public PartidaEstanciero actualizarPartida(){
        //mediante el uso del facade actualizar datos de la partida
        this.facade.ActualizarPeones(partida.getJugadoresPartida());
        this.facade.ActualizarTarjetasCompania(this.partida.getTableroPartida().getPropiedades().obtenerCartasCompaniaConDuenio());
        this.facade.ActualizarTarjetasProvincia(this.partida.getTableroPartida().getPropiedades().obtenerCartasProvinciaConDuenio());
        this.facade.ActualizarTarjetasFerrocarril(this.partida.getTableroPartida().getPropiedades().obtenerCartasFerrocarrilConDuenio());
        return partida;
    }
}
