package org.persistence.facade;

import org.model.card.CartaCompania;
import org.model.card.CartaFerrocarril;
import org.model.card.CartaProvincia;
import org.model.player.Bot;
import org.model.player.Jugador;
import org.persistence.services.*;
import org.services.IPeon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan
public class EstancieroFacade {
    private final BotService botService;
    private final JugadorService jugadorService;
    private final CartaEmpresaService cartaEmpresaService;
    private final CartaProvinciaService cartaProvinciaService;
    private final CartaFerrocarrilService cartaFerrocarrilService;

    @Autowired
    public EstancieroFacade(JugadorService jugadorService, BotService botService, CartaEmpresaService cartaEmpresaService, CartaProvinciaService cartaProvinciaService, CartaFerrocarrilService cartaFerrocarrilService) {
        this.jugadorService = jugadorService;
        this.botService = botService;
        this.cartaEmpresaService=cartaEmpresaService;
        this.cartaProvinciaService = cartaProvinciaService;
        this.cartaFerrocarrilService = cartaFerrocarrilService;
    }

    //PEONES (JUGADOR O BOT)
    public boolean GuardarPeones(List<IPeon> peones){
        boolean aux = false;
        try{
            for(IPeon peon: peones){
                if(peon instanceof Jugador){
                    Jugador jugador= (Jugador) peon;
                    this.jugadorService.GuardarJugador(jugador);
                } else if (peon instanceof Bot) {
                    Bot bot = (Bot) peon;
                    this.botService.GuardarBot(bot);
                }
            }
            aux=true;
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            aux=false;
        }
        return aux;
    }

    public boolean ActualizarPeones(List<IPeon> peones){
        boolean aux = false;
        try{
            for(IPeon peon: peones){
                if(peon instanceof Jugador){
                    Jugador jugador= (Jugador) peon;
                    this.jugadorService.ActualizarJugador(jugador.getId(),jugador);
                } else if (peon instanceof Bot) {
                    Bot bot = (Bot) peon;
                    this.botService.ActualizarBot(bot.getId(),bot);
                }
            }
            aux=true;
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            aux=false;
        }
        return aux;
    }

    public Jugador RecuperarJugador(){
        return jugadorService.BuscarJugador();
    }

    public List<Bot> RecuperarBots(){
        return botService.BuscarBots();
    }

    //Por si queremos traer directamente juntos los bots y el jugador.
    public List<IPeon> RecuperarJugadorConBots(){
        List<IPeon> auxReturn = new ArrayList<>();
        auxReturn.add(this.RecuperarJugador());
        auxReturn.addAll(this.RecuperarBots());
        return auxReturn;
    }

    //Para su uso al terminar la partida.
    public boolean BorrarPeones(List<IPeon> peones){
        boolean aux = false;
        try{
            for(IPeon peon: peones){
                if(peon instanceof Jugador){
                    Jugador jugador= (Jugador) peon;
                    this.jugadorService.BorrarJugador(jugador.getId());
                } else if (peon instanceof Bot) {
                    Bot bot = (Bot) peon;
                    this.botService.BorrarBot(bot.getId());
                }
            }
            aux=true;
        }
        catch (Exception ex){
            System.out.println(ex.toString());
            aux=false;
        }
        return aux;
    }

    //CARTAS
    public List<CartaCompania> BuscarTarjetasCompania(){
        return this.cartaEmpresaService.BuscarCartas();
    }

    public List<CartaProvincia> BuscarTarjetasProvincia(){
        return this.cartaProvinciaService.BuscarCartas();
    }

    public List<CartaFerrocarril> BuscarTarjetasFerrocarril(){return this.cartaFerrocarrilService.BuscarCartas();}

    public boolean GuardarTarjetasCompania(List<CartaCompania> listaCartas){
        boolean aux = false;
        try {
            for (CartaCompania carta : listaCartas) {
                this.cartaEmpresaService.GuardarCartaEmpresa(carta);
            }
            aux=true;
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return aux;
    }

    public boolean GuardarTarjetasFerrocarril(List<CartaFerrocarril> listaCartas){
        boolean aux = false;
        try {
            for (CartaFerrocarril carta : listaCartas) {
                this.cartaFerrocarrilService.GuardarCartaFerrocarril(carta);
            }
            aux=true;
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return aux;
    }

    public boolean GuardarTarjetasProvincia(List<CartaProvincia> listaCartas){
        boolean aux = false;
        try {
            for (CartaProvincia carta : listaCartas) {
                this.cartaProvinciaService.GuardarCartaProvincia(carta);
            }
            aux=true;
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return aux;
    }

    public boolean GuardarTarjetaProvincia(CartaProvincia carta){
        boolean auxReturn = false;
        try{
            cartaProvinciaService.GuardarCartaProvincia(carta);
            auxReturn=true;
        }
        catch(Exception exception){
            System.out.println(exception.toString());
        }
        return auxReturn;
    }

    public boolean ActualizarTarjetasCompania(List<CartaCompania> listaCartas){
        boolean aux = false;
        try {
            for (CartaCompania carta : listaCartas) {
                this.cartaEmpresaService.ActualizarCarta(carta);
            }
            aux=true;
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return aux;
    }

    public boolean ActualizarTarjetasFerrocarril(List<CartaFerrocarril> listaCartas){
        boolean aux = false;
        try {
            for (CartaFerrocarril carta : listaCartas) {
                this.cartaFerrocarrilService.ActualizarCarta(carta);
            }
            aux=true;
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return aux;
    }

    public boolean ActualizarTarjetasProvincia(List<CartaProvincia> listaCartas){
        boolean aux = false;
        try {
            for (CartaProvincia carta : listaCartas) {
                this.cartaProvinciaService.ActualizarCarta(carta);
            }
            aux=true;
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return aux;
    }

    public boolean BorrarTarjetasCompania(List<CartaCompania> listaCartas){
        boolean aux = false;
        try {
            for (CartaCompania carta : listaCartas) {
                this.cartaEmpresaService.BorrarCarta(carta.getIdCarta());
            }
            aux=true;
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return aux;
    }

    public boolean BorrarTarjetasProvincia(List<CartaProvincia> listaCartas){
        boolean aux = false;
        try {
            for (CartaProvincia carta : listaCartas) {
                this.cartaProvinciaService.BorrarCarta(carta.getIdCarta());
            }
            aux=true;
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return aux;
    }

    public boolean BorrarTarjetasFerrocarril(List<CartaFerrocarril> listaCartas){
        boolean aux = false;
        try {
            for (CartaFerrocarril carta : listaCartas) {
                this.cartaFerrocarrilService.BorrarCarta(carta.getId());
            }
            aux=true;
        }
        catch (Exception ex){
            System.out.println(ex.toString());
        }
        return aux;
    }

    public boolean ExisteJugadorPartida(){
        return this.jugadorService.ExisteJugador();
    }

    public  void LimpiarBd(){
        jugadorService.BorrarJugadores();
        botService.BorrarBots();
        cartaProvinciaService.BorrarCartas();
        cartaEmpresaService.BorrarCartas();
        cartaFerrocarrilService.BorrarCartas();
    }
}
