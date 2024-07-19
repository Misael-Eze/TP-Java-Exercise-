package org.model.bank;


import org.model.board.Tablero;
import org.model.card.*;
import org.model.console.Consola;
import org.model.console.Grafico;
import org.model.console.Validacion;
import org.model.enums.EstadosJugadores;
import org.model.enums.Provincias;
import org.model.player.Bot;
import org.model.player.Jugador;
import org.services.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private static Banco instancia;
    private MazoPropiedades propiedades;
    private List<IPropiedad> propiedadesVendidas;
    private Consola consola;

    public Banco(){
        propiedades = new MazoPropiedades();
        propiedadesVendidas = new ArrayList<>();
        consola = new Consola();
    }

    public Banco(Consola consola, MazoPropiedades propiedades){
        this.consola = consola;
        this.propiedades = propiedades;
        this.propiedadesVendidas = new ArrayList<>();
    }

    public MazoPropiedades getPropiedades() {
        return propiedades;
    }

    public void agregarCartaAlMazo(IPropiedad tarjeta) {
        propiedadesVendidas.add(tarjeta);
    }

    public IPropiedad obtenerCarta(int indice) {
        if (indice < 0 || indice >= propiedadesVendidas.size()) {
            return null;
        }
        return propiedadesVendidas.get(indice);
    }

    public void removerCartaDelMazo(IPropiedad tarjeta) {
        propiedadesVendidas.remove(tarjeta);
    }

    public void agregarCartaAlBanco(IPropiedad tarjeta) {
        propiedadesVendidas.add(tarjeta);
        System.out.println("El banco ha recibido la carta de la propiedad " + tarjeta.getDescripcion());
    }

    public List<IPropiedad> getMazo() {
        return propiedadesVendidas;
    }

    public void setMazo(List<IPropiedad> mazo) {
        this.propiedadesVendidas = mazo;
    }



    public List<IPropiedad> obtenerPropiedadesPorDuenio(IPeon jugador) {
        List<IPropiedad> propiedades = new ArrayList<>();
        for (IPropiedad propiedad : propiedadesVendidas) {
            if (propiedad.getDuenio() == jugador) {
                propiedades.add(propiedad);
            }
        }
        return propiedades;
    }

    //TODO:AGREGAR LA INTERFAZ DE MENU BANCO SEGUN LA OPCION
    //TODO:FIJARSE SI EL IPEON ES UNA INSTANCIA DE JUGADOR, SI NO FIJARSE SI ES UN BOT, PASARLE LA PROPIEDAD A LA ESTRATEGIA DEL BOT Y SEGUN EL RETORNO COMPRAR O NO.
    public boolean ofrecerPropiedad(IPeon jugador, IPropiedad propiedad) {
        if (jugador instanceof Jugador) {
            //Verificar que al jugador le alcanza el dinero para comprar la propiedad
            if (propiedad.getValor() < jugador.getDinero()){
                boolean quiereComprar = consola.ofrecerPropiedad((Jugador) jugador, propiedad);
                if (quiereComprar) {
                    propiedadesVendidas.add(propiedad);
                    jugador.comprarPropiedad(propiedad);
                    propiedad.setDuenio(jugador);
                    propiedad.setIdDuenio(jugador.getId());
                    return true;
                }
                return false;
            }
        } else if (jugador instanceof Bot) {
            if (propiedad.getValor() < jugador.getDinero()){
                if (jugador.comprarPropiedad(propiedad)){
                    propiedadesVendidas.add(propiedad);
                    propiedad.setDuenio(jugador);
                    propiedad.setIdDuenio(jugador.getId());
                    return true;
                }
                return false;
            }
        }

//        if(jugador.comprarPropiedad(propiedad)){
//            propiedadesVendidas.add(propiedad);
//            propiedad.setDuenio(jugador);
//            return true;
//        }
        return false;
    }

    //TODO:AGREAGAR LA INTERFAZ DEL MENU SEGUN LA OPCION
    //TODO:SI ES JUGADOR MOSTRAR MENU DE OPCIONES Y MEJORAR EN BASE A SUS FONDOS (SALDO)
    //TODO:FIJARSE EN LA ESTRATEGIA DEL BOT PARA COMPRAR MEJORAS.
    public boolean ofrecerMejoras(IPeon jugador, CartaProvincia provincia) {
        if (puedeAgregarChacra(jugador, provincia)) {
            if (jugador instanceof Jugador){
                boolean quiereComprarChacra = consola.ofrecerComprarChacra(provincia);
                if (quiereComprarChacra) {
                    return jugador.comprarChacra(provincia);
                }
            } else if (jugador instanceof Bot) {
                List<CartaProvincia> provinciasVendidas = propiedades.obtenerProvinciasVendidas();
                boolean quiereComprarChacra = ((Bot) jugador).getEstrategia().decidirComprarChacra(provincia, jugador.getDinero(), provinciasVendidas.size());
                if (quiereComprarChacra) {
                    return jugador.comprarChacra(provincia);
                }
            }
        } else if (puedeAgregarEstancia(jugador, provincia)) {
            if (jugador instanceof Jugador){
                boolean quiereComprarEstancia = consola.ofrecerComprarEstancia(provincia);
                if (quiereComprarEstancia){
                    return jugador.comprarEstancia(provincia);
                }
            } else if (jugador instanceof Bot) {
                List<CartaProvincia> provinciasVendidas = propiedades.obtenerProvinciasVendidas();
                boolean quiereComprarEstancia = ((Bot) jugador).getEstrategia().decidirComprarEstancia(provincia, jugador.getDinero(), provinciasVendidas.size());
                if (quiereComprarEstancia) {
                    return jugador.comprarEstancia(provincia);
                }
            }
        }
        return false;
    }

    public boolean puedeAgregarChacra(IPeon jugador, CartaProvincia provincia){
        boolean alcanzaDinero = provincia.getValorChacra() <= jugador.getDinero();
        int conteoChacras = provincia.getConteoChacras();
        int conteoEstancias = provincia.getConteoEstancias();
        return conteoChacras < 4 && conteoEstancias == 0 && alcanzaDinero;
    }

    public boolean puedeAgregarEstancia(IPeon jugador, CartaProvincia provincia){
        boolean alcanzaDinero = provincia.getValorEstancia() <= jugador.getDinero();
        int conteoChacras = provincia.getConteoChacras();
        int conteoEstancias = provincia.getConteoEstancias();
        return conteoChacras == 4 && conteoEstancias == 0 && alcanzaDinero;
    }

    public void cobrarAlquiler(IPeon jugador, IPropiedad propiedad){
        int cant = 0;
        if (propiedad instanceof CartaProvincia){
            cant = ((CartaProvincia) propiedad).getConteoChacras();
        } else if (propiedad instanceof CartaCompania) {
            cant = propiedades.cantCompaniasPorDuenio(propiedad.getDuenio());
        } else if (propiedad instanceof CartaFerrocarril) {
            cant = propiedades.cantFerrocarrilesPorDuenio(propiedad.getDuenio());
        }
        int totalAlquiler = propiedad.calcularAlquiler(cant);
        if (!jugador.pagarMonto(totalAlquiler)){
            ofrecerHipoteca(jugador);
        }
        propiedad.getDuenio().cobrarMonto(totalAlquiler);
        consola.informarPagoAlquiler(jugador, propiedad, totalAlquiler);
    }


    /**
     * Le paga al jugador el monto ingresado
     * @param jugador
     * @param monto
     */
    public void pagarAlJugador(IPeon jugador, int monto) {
        jugador.cobrarMonto(monto);
    }

    /**
     * Le cobra al jugador el monto ingresado
     * @param jugador
     * @param monto
     */
    public void cobrarMonto(IPeon jugador, int monto) {
        boolean pudoCobrar = jugador.pagarMonto(monto);
    }

    public void ofrecerHipoteca(IPeon jugador){
        List<IPropiedad> propiedades = jugador.getPropiedades();

        //Si no tiene propiedaes el jugador queda en Bancarrota
        if (propiedades.isEmpty()){
            jugador.setEstado(EstadosJugadores.BANCARROTA);
        }

        if (jugador instanceof Jugador){
            int seleccion = consola.ofrecerHipotecar(propiedades);
        }
    }

    public boolean jugadorPagaAOtroJugador(IPeon jugadorPaga, IPeon jugadorRecibe, int monto){
        if (jugadorPaga.pagarMonto(monto)){
            jugadorPaga.cobrarMonto(monto);
            return true;
        }
        return false;
    }

    public void venderAlgunaPropiedad(IPeon jugador){
        List<IPropiedad> propiedadesJugador = jugador.getPropiedades();

        //Si no tiene propiedaes el jugador queda en Bancarrota
        if (propiedadesJugador.isEmpty()){
            System.out.println("El jugador "+jugador.getNombre()+" no tiene propiedades, queda en bancarrota");
            jugador.setEstado(EstadosJugadores.BANCARROTA);
        }else{
            IPropiedad propiedadVendida = propiedadesJugador.get(0);
            propiedadesJugador.remove(0);
            this.pagarAlJugador(jugador, propiedadVendida.getValor());
            propiedadVendida.setDuenio(null);
            System.out.println("El jugador "+jugador.getNombre()+" vendió una de sus propiedades al banco");
            System.out.println("Propiedad vendida: \n"+propiedadVendida.getDescripcion());
            propiedades.actualizarPropiedad(propiedadVendida);
        }
    }
}
