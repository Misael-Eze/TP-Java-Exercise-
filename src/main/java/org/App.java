package org;

//import org.gameplay.Juego;
//import org.gameplay.PartidaEstanciero;
import org.gameplay.Juego;
import org.persistence.facade.EstancieroFacade;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableAutoConfiguration
@EnableJpaRepositories("org.persistence.repositories")
@EntityScan(basePackages = "org.persistence.entities")
@ComponentScan(basePackages = {"org.persistence.facade", "org.persistence.services", "org.persistence.repositories"})

public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        EstancieroFacade facade = context.getBean(EstancieroFacade.class);
        Correr(facade);
        Juego juego = new Juego(facade);
//        Pa1rtidaEstanciero partida= new PartidaEstanciero();
        juego.comenzarJuego();
    }





    public static void Correr(EstancieroFacade facade){
        //PRUEBAS PARA SERVICIO JUGADOR
        /*List<IPeon> peones = new ArrayList<>();
        Jugador jugador = new Jugador();
        jugador.setNombre("Chancha");
        jugador.setEstado(EstadosJugadores.JUGANDO);
        jugador.setDoblesConsecutivos(0);
        jugador.setDinero(35000);
        jugador.setPosicion(1);
        jugador.recibirTarjetaLiberacion();
        peones.add(jugador);
        facade.GuardarPeones(peones);
        Jugador nuevoJugador = facade.RecuperarJugador();
        System.out.println(nuevoJugador.getNombre());
        nuevoJugador.setDinero(300);
        nuevoJugador.recibirTarjetaLiberacion();
        peones.clear();
        peones.add(nuevoJugador);
        facade.ActualizarPeones(peones);
        System.out.println("Actualizado");
        Jugador chancha123= facade.RecuperarJugador();
        System.out.println(chancha123.getDinero());
        System.out.println(facade.BorrarPeones(peones));
        Jugador j = facade.RecuperarJugador();
        System.out.println("chancha1");*/
        //PRUEBAS PARA SERVICIO BOT
        /*List<IPeon> peones = new ArrayList<>();
        Bot bot = new Bot();
        bot.setEstrategia(new StrategyBotEquilibrado());
        bot.setEstado(EstadosJugadores.JUGANDO);
        bot.setPosicion(1);
        bot.setDinero(35000);
        bot.setDoblesConsecutivos(0);
        peones.add(bot);
        facade.GuardarPeones(peones);
        System.out.println("Bot: " + bot.getEstado());
        Bot traerBot = facade.RecuperarBots().get(0);
        System.out.println(traerBot.getId());
        traerBot.setDinero(3000);
        traerBot.setDoblesConsecutivos(2);
        peones.clear();
        peones.add(traerBot);
        System.out.println(facade.ActualizarPeones(peones));
        System.out.println("chancha");*/
        //PRUEBA DE SERVICIO CARTAPROVINCIA
        /*CartaProvincia cartaProvincia = new CartaProvincia();
        cartaProvincia.setProvincia(Provincias.TUCUMAN);
        cartaProvincia.setTipoCarta(TipoTarjeta.PROVINCIA);
        cartaProvincia.setConteoChacras(0);
        cartaProvincia.setDescripcion("Carta de Prueba.");
        cartaProvincia.setHipotecado(false);
        cartaProvincia.setValorAlquiler(1300);
        cartaProvincia.setValorHipoteca(100);
        facade.GuardarTarjetaProvincia(cartaProvincia);
        System.out.println("chanch!");
        CartaProvincia cartaGuardada = facade.BuscarTarjetasProvincia().get(0);
        System.out.println(cartaGuardada.getDescripcion());
        cartaGuardada.setIdDuenio(1);
        cartaGuardada.setConteoChacras(2);
        List<CartaProvincia> cards = new ArrayList<>();
        cards.add(cartaGuardada);
        System.out.println(facade.ActualizarTarjetasProvincia(cards));
        System.out.println("Chancha");*/
        //PRUEBAS DE CARTA EMPRESA!
        /*List<CartaCompania> cards = new ArrayList<>();
        CartaCompania cartaCompania = new CartaCompania();
        cartaCompania.setTipoTarjeta(TipoTarjeta.COMPANIA);
        cartaCompania.setHipotecado(false);
        cartaCompania.setDescripcion("Carta empresa!");
        cartaCompania.setValorAlquiler(1000);
        cartaCompania.setValorHipoteca(200);
        cards.add(cartaCompania);
        facade.GuardarTarjetasCompania(cards);
        System.out.println("Chanch");
        CartaCompania tarjetaGuardada = facade.BuscarTarjetasCompania().get(0);
        System.out.println(tarjetaGuardada.getTipoTarjeta().getValue());
        tarjetaGuardada.setDescripcion("Tarjeta nueva");
        tarjetaGuardada.setValorAlquiler(2400);
        cards.clear();
        cards.add(tarjetaGuardada);
        System.out.println(facade.ActualizarTarjetasCompania(cards));
        System.out.println("Check");*/
    }
}
