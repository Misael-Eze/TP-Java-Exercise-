package org.model.player;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.model.bank.Banco;
import org.model.card.CartaProvincia;
import org.model.enums.*;
import org.services.*;



import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class Bot implements IPeon {
    private Long id;
    private String nombre;
    private String color;
    private int dinero;
    private int posicion;
    private boolean tarjetaLiberacion;
    private EstadosJugadores estado;
    private List<IPropiedad> propiedades;
    private IStrategyBot estrategia;
    private Banco banco;
    public int cartaseliminadas = 0;
    private int doblesConsecutivos;
    private int turnosDescansando;



    // Constructor que pide el color del bot y la estrategia
    public Bot(String nombre, IStrategyBot estrategia) {
        this.nombre = nombre;
        this.posicion = 0;
        this.estado = EstadosJugadores.JUGANDO; // Estado inicial JUGANDO
        this.dinero = 35000;
        this.propiedades = new ArrayList<>();
        this.estrategia = estrategia;
        this.tarjetaLiberacion = false;
    }

    public Bot(){
        this.id=0L;
        this.nombre = "bot";
        this.posicion = 0;
        this.estado = EstadosJugadores.JUGANDO;
        this.dinero = 35000;
        this.propiedades = new ArrayList<>();
        this.estrategia=null;
        this.banco=null;
        this.tarjetaLiberacion = false;
    }

    public Bot(Long id, String color, IStrategyBot estrategia){
        this.id=id;
        this.nombre = "bot";
        this.color = color;
        this.posicion = 0;
        this.estado = EstadosJugadores.JUGANDO;
        this.dinero = 35000;
        this.propiedades = new ArrayList<>();
        this.estrategia=estrategia;
        this.banco=banco;
        this.tarjetaLiberacion = false;
    }

    // Getters y Setters

    public int getTurnosDescansando(){
        return turnosDescansando;
    }

    public void setTurnosDescansando(int turnosDescansando){
        this.turnosDescansando = turnosDescansando;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public EstadosJugadores getEstado() {
        return estado;
    }

    public void setEstado(EstadosJugadores estado) {
        this.estado = estado;
    }

    public List<IPropiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<IPropiedad> propiedades) {
        this.propiedades = propiedades;
    }

    public void setEstrategia(IStrategyBot strategyBot){this.estrategia=strategyBot;}
    public IStrategyBot getEstrategia(){return this.estrategia;}

    public void setBanco(Banco banco){this.banco=banco;}

    public boolean getTarjetaLiberacion(){return this.tarjetaLiberacion;}

    public void agregarCarta(IPropiedad tarjeta) {
        propiedades.add(tarjeta);
        System.out.println(nombre+" ha recibido la carta tipo " + tarjeta.getDescripcion());
    }

    // Implementación de los métodos de IPeon
    @Override
    public boolean comprarEstancia(CartaProvincia cartaProvincia) {
        cartaProvincia.agregarEstancia();
        return pagarMonto(cartaProvincia.getValorEstancia());
//        if (!(propiedad instanceof CartaProvincia)) {
//            return false;
//        }

//        CartaProvincia cartaProvincia = (CartaProvincia) propiedad;
        // Consultar la estrategia para decidir si comprar la estancia
//        List<IPropiedad> mazo = banco.getMazo();
//        if (!estrategia.decidirComprarEstancia(cartaProvincia, this.dinero, mazo.size())) {
//            return false;
//        }
//
//        if (cartaProvincia.getConteoChacras() < 4 || cartaProvincia.getConteoEstancias() > 0) {
//            return false; // No se puede comprar estancia si no hay al menos 4 chacras o ya hay una estancia
//        }
//
//        int costoTotal = cartaProvincia.getValorEstancia() - (4 * cartaProvincia.getValorChacra());
//
//        if (dinero < costoTotal) {
//            return false; // No tiene suficiente dinero
//        }
//
//        dinero -= costoTotal;
//        cartaProvincia.setConteoChacras(cartaProvincia.getConteoChacras() - 4);
//        cartaProvincia.setConteoEstancias(cartaProvincia.getConteoEstancias() + 1);
//        System.out.println(nombre + " ha comprado una estancia de la propiedad " + cartaProvincia.getDescripcion());
//        return true;
    }

    @Override
    public boolean venderEstancia(IPropiedad propiedad) {
        if (!(propiedad instanceof CartaProvincia)) {
            return false;
        }

        CartaProvincia cartaProvincia = (CartaProvincia) propiedad;
        // Consultar la estrategia para decidir si vender la estancia
        if (!estrategia.decidirVenderEstancia(cartaProvincia, dinero)) {
            return false;
        }

        if (cartaProvincia.getConteoEstancias() == 0) {
            return false; // No hay estancia para vender
        }

        dinero += cartaProvincia.getValorEstancia();
        cartaProvincia.setConteoEstancias(cartaProvincia.getConteoEstancias() - 1);
        System.out.println(nombre + " ha vendido una estancia de la propiedad " + cartaProvincia.getDescripcion());
        return true;
    }

    @Override
    public boolean comprarChacra(CartaProvincia provincia) {
        provincia.agregarChacra();
        return pagarMonto(provincia.getValorChacra());
//        CartaProvincia cartaProvincia = (CartaProvincia) propiedad;
//        Provincias provincia = cartaProvincia.provincia;
//        // Consultar la estrategia para decidir si comprar la chacra
//        List<IPropiedad> mazo = banco.getMazo();
//        if (!estrategia.decidirComprarChacra(cartaProvincia, dinero, mazo.size())) {
//            return false;
//        }
//
//        if (!poseeTodasLasPropiedadesDeProvincia(provincia)) {
//            return false; // No posee todas las propiedades de la provincia
//        }
//
//        if (!puedeAgregarChacra(provincia, cartaProvincia)) {
//            return false; // No se puede agregar una chacra debido a la diferencia de chacras
//        }
//
//        int valorChacra = cartaProvincia.getValorChacra();
//
//        if (dinero < valorChacra) {
//            return false; // No tiene suficiente dinero
//        }
//
//        dinero -= valorChacra;
//        cartaProvincia.setConteoChacras(cartaProvincia.getConteoChacras() + 1);
//        System.out.println(nombre + " ha comprado una chacra de la propiedad " + cartaProvincia.getDescripcion());
//        return true;
    }

    @Override
    public boolean venderChacra(IPropiedad propiedad) {
        if (!(propiedad instanceof CartaProvincia)) {
            return false;
        }

        CartaProvincia cartaProvincia = (CartaProvincia) propiedad;
        // Consultar la estrategia para decidir si vender la chacra
        if (!estrategia.decidirVenderChacra(cartaProvincia, dinero)) {
            return false;
        }

        if (cartaProvincia.getConteoChacras() == 0) {
            return false; // No hay chacra para vender
        }

        dinero += cartaProvincia.getValorChacra() / 2; // Vender a mitad del valor
        cartaProvincia.setConteoChacras(cartaProvincia.getConteoChacras() - 1);
        System.out.println(nombre + " ha vendido una chacra de la propiedad " + cartaProvincia.getDescripcion());
        return true;
    }

    @Override
    public boolean comprarPropiedad(IPropiedad propiedad) {
        if (this.dinero < propiedad.getValor()){
            return false;
        }
        if (estrategia.decidirCompraPropiedad(propiedad, this.dinero, propiedades.size())){
            pagarMonto(propiedad.getValor());
            agregarCarta(propiedad);
            return true;
        }
        return false;

//        if (propiedad == null ) {
//            return false;
//        }


//        if (!estrategia.decidirCompraPropiedad(propiedad, dinero, calcularCantidadComprasRealizadas())) {
//            return false;
//        }
//
//        if (dinero < propiedad.getValorHipoteca()) { // Puedes usar otro valor si es necesario
//            return false; // No tiene suficiente dinero
//        }
//
//        dinero -= propiedad.getValorHipoteca(); // Puedes usar otro valor
//        // Puedes usar otro valor si es necesario
//        agregarCarta(propiedad);
//        Banco.getInstancia().removerCartaDelMazo(propiedad);
//        System.out.println(nombre + " ha comprado la propiedad " + propiedad.getDescripcion());
//        return true;
    }

    @Override
    public boolean venderPropiedad(IPropiedad propiedad) {
//        if (propiedad == null || !(propiedad instanceof CartaProvincia)) {
//            return false;
//        }
//
//        if (!propiedades.contains(propiedad)) {
//            return false; // El jugador no posee esta propiedad
//        }
//
//
//        // Consultar la estrategia para decidir si vender la propiedad
//        if (!estrategia.decidirVenderPropiedad(propiedad, dinero)) {
//            return false;
//        }
//
//        dinero += propiedad.getValorHipoteca()/2; // Puedes usar otro valor si es necesario
//        propiedades.remove(propiedad);
//        Banco.getInstancia().agregarCartaAlBanco(propiedad);
//        System.out.println(nombre + " ha vendido la propiedad " + propiedad.getDescripcion() + " de vuelta al banco.");
        return true;
    }

    @Override
    public boolean pagarMonto(int valorAlquiler) {
        if (dinero < valorAlquiler) {
            return false;
        }
        dinero -= valorAlquiler;
        return true;
    }

    @Override
    public boolean cobrarMonto(int monto) {
        dinero += monto;
        return true;
    }

    public void tirarDado() {
        Dados.getInstance().rollDice();
//        if (estado == EstadosJugadores.PRESO) {
//            System.out.println(nombre + " está en la cárcel y no puede tirar los dados.");
//            return;
//        }
//
//        DadosSingleton dados = DadosSingleton.getInstance();
//        dados.rollDice();
//        int suma = dados.getDiceSum();
//        this.posicion = (this.posicion + suma) % 72; // Ejemplo: asumiendo 72 casillas en el tablero
//        System.out.println(nombre + " ha tirado los dados: " + dados.getFirstDice() + " y " + dados.getSecondDice() + " (Suma: " + suma + ")");
//        System.out.println(nombre + " ahora está en la posición: " + this.posicion);
//
//
//        if (dados.getFirstDice() == dados.getSecondDice()) {
//            doblesConsecutivos++;
//            if (doblesConsecutivos == 3) {
//                irALaCarcel();
//            } else {
//                System.out.println(nombre + " ha sacado dobles y puede tirar de nuevo.");
//                tirarDado();
//            }
//        } else {
//            doblesConsecutivos = 0;
//        }
    }

    @Override
    public boolean tieneTarjetaLiberacion() {
        return tarjetaLiberacion;
    }

    @Override
    public boolean usarTarjetaLiberacion() {
        if (tarjetaLiberacion) {
            tarjetaLiberacion = false;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void irALaCarcel() {
        avanzarHasta(20); // Asumiendo que la posición 20 es la cárcel
        System.out.println(nombre + " ha ido a la cárcel.");
        this.estado = EstadosJugadores.PRESO; // Actualiza el estado del jugador a "EN_CARCEL"
        doblesConsecutivos = 0; // Reiniciar el contador de dobles
    }


    @Override
    public String getNombre() {
        return nombre;
    }


    @Override
    public void recibirTarjetaLiberacion() {
        tarjetaLiberacion = true;
    }

    @Override
    public void avanzarHasta(int posicion) {
        setPosicion(posicion);
    }

    // Método para verificar si el jugador posee todas las propiedades de una provincia
    boolean poseeTodasLasPropiedadesDeProvincia(Provincias provincia) {
        for (IPropiedad tarjeta : propiedades) {
            if (tarjeta instanceof CartaProvincia && ((CartaProvincia) tarjeta).getProvincia().equals(provincia)) {
                continue;
            }
            return false;
        }
        return true;
    }

    // Método para verificar si se puede agregar una chacra a una propiedad según las reglas
//    boolean puedeAgregarChacra(Provincias provincia, CartaProvincia propiedad) {
//        int cantidadChacras = propiedad.getConteoChacras();
//        int cantidadEstancias = propiedad.getConteoEstancias();
//
//        // No se puede tener más de una estancia por propiedad
//        if (cantidadEstancias > 0) {
//            return false;
//        }
//
//        // Verificar que no haya una diferencia de dos chacras entre las propiedades de la provincia
//        for (IPropiedad tarjeta : propiedades) {
//            if (tarjeta instanceof CartaProvincia && ((CartaProvincia) tarjeta).getProvincia().equals(provincia)) {
//                CartaProvincia otraPropiedad = (CartaProvincia) tarjeta;
//                int diferenciaChacras = Math.abs(cantidadChacras - otraPropiedad.getConteoChacras());
//                if (diferenciaChacras >= 2) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

//    public int calcularCantidadComprasRealizadas() {
//        return propiedades.size();
//    }

    public void setDoblesConsecutivos(int doblesConsecutivos){
        this.doblesConsecutivos=doblesConsecutivos;
    }
    public int getDoblesConsecutivos() {
        return this.doblesConsecutivos;
    }
}