package org.model.player;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.model.card.*;
import org.model.enums.*;
import org.services.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class Jugador implements IPeon {
    private Long id;
    private String nombre;
    private String color;
    private int dinero;
    private int posicion;
    private EstadosJugadores estado;
    private List<IPropiedad> propiedades;
    private boolean tarjetaLiberacion;
    int doblesConsecutivos;
    private int turnosDescansando;



    public Jugador(String nombre, String color) {
        this.id = 1L;
        this.nombre = nombre;
        this.color = color;
        this.posicion = 0;
        this.estado = EstadosJugadores.JUGANDO;
        this.dinero = 35000;
        this.propiedades = new ArrayList<>();
        this.turnosDescansando = 0;
    }

    public Jugador() {
        this.id = 1L;
    }

    public Jugador(String nomJugador) {
        this.id = 1L;
        this.nombre = nomJugador;
        this.posicion = 0;
        this.estado = EstadosJugadores.JUGANDO;
        this.dinero = 35000;
        this.propiedades = new ArrayList<>();
        this.turnosDescansando = 0;
    }

    public List<IPropiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(List<IPropiedad> propiedades) {
        this.propiedades = propiedades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {this.color = color;}

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

    public int getTurnosDescansando(){
        return turnosDescansando;
    }



    public void setEstado(EstadosJugadores estado) {
        this.estado = estado;
    }

    public List<IPropiedad> getCartas() {
        return propiedades;
    }

    public void setCartas(List<IPropiedad> cartas) {
        this.propiedades = propiedades;
    }

    public boolean getTarjetaLiberacion(){return this.tarjetaLiberacion;}

    public void setTarjetaLiberacion(boolean tarjetaLiberacion) {this.tarjetaLiberacion = tarjetaLiberacion;}

    public int getDoblesConsecutivos() {return doblesConsecutivos;}
    public void setDoblesConsecutivos(int doblesConsecutivos){this.doblesConsecutivos=doblesConsecutivos;}

    public void agregarCarta(IPropiedad tarjeta) {
        propiedades.add(tarjeta);
        System.out.println(nombre + " ha recibido la carta tipo " + tarjeta.getDescripcion());
    }


    @Override
    public boolean comprarEstancia(CartaProvincia provincia) {
        provincia.agregarEstancia();
        return this.cobrarMonto(provincia.getValorEstancia());
    }

    @Override
    public boolean venderEstancia(IPropiedad propiedad) {
        if (!(propiedad instanceof CartaProvincia)) {
            return false;
        }

        CartaProvincia cartaProvincia = (CartaProvincia) propiedad;

        if (cartaProvincia.getConteoEstancias() == 0) {
            System.out.println("No hay estancia para vender");
            return false; // No hay estancia para vender
        }

        dinero += cartaProvincia.getValorEstancia();
        cartaProvincia.setConteoEstancias(cartaProvincia.getConteoEstancias() - 1);
        System.out.println(nombre + " ha vendido la estancia en la propiedad " + propiedad.getDescripcion());
        return true;
    }


    @Override
    public boolean comprarChacra(CartaProvincia provincia) {
        provincia.agregarChacra();
        return pagarMonto(provincia.getValorChacra());
    }

    @Override
    public boolean venderChacra(IPropiedad propiedad) {
        if (!(propiedad instanceof CartaProvincia)) {
            return false;
        }

        CartaProvincia cartaProvincia = (CartaProvincia) propiedad;

        if (cartaProvincia.getConteoChacras() == 0) {
            System.out.println("No hay chacra para vender");
            return false; // No hay chacra para vender
        }

        dinero += cartaProvincia.getValorChacra() / 2; // Vender a mitad del valor
        cartaProvincia.setConteoChacras(cartaProvincia.getConteoChacras() - 1);
        System.out.println(nombre + " ha vendido una chacra en la propiedad " + propiedad.getDescripcion());
        return true;
    }

    @Override
    public boolean comprarPropiedad(IPropiedad propiedad) {
        //Si no le alcanza, no puede comprarla
        if(this.getDinero() < propiedad.getValor()){
            return false;
        }
        this.pagarMonto(propiedad.getValor());
        this.agregarCarta(propiedad);
        return true;
    }

    @Override
    public boolean venderPropiedad(IPropiedad propiedad) {
//        if (propiedad == null ) {
//            return false;
//        }
//
//        if (!propiedades.contains(propiedad)) {
//            System.out.println("El jugador no posee esta propiedad");
//            return false; // El jugador no posee esta propiedad
//        }
//
//        CartaProvincia cartaProvincia = (CartaProvincia) propiedad;
//
//        dinero += cartaProvincia.getValorHipoteca()/2; // Puedes usar otro valor si es necesario
//        propiedades.remove(propiedad);
//        Banco.getInstancia().agregarCartaAlBanco(propiedad);
//        System.out.println(nombre + " ha vendido la propiedad " + propiedad.getDescripcion() + " de vuelta al banco.");
        return true;
    }

    @Override
    public boolean pagarMonto(int monto) {
        if (dinero < monto) {
            return false;
        }
        dinero -= monto;
        return true;
    }

    @Override
    public boolean cobrarMonto(int monto) {
        dinero += monto;
        return true;
    }

    public void tirarDado() {
        Dados.getInstance().rollDice();
    }


   @Override
   public boolean tieneTarjetaLiberacion() {

      return tieneTarjetaLiberacion();
   }
   @Override
   public void recibirTarjetaLiberacion() {
      tarjetaLiberacion = true;
   }

   @Override
   public void avanzarHasta(int posicion) {
      this.posicion = posicion;
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
   public void irALaCarcel () {
       avanzarHasta(14); // Asumiendo que la posición 20 es la cárcel
       System.out.println(nombre + " ha ido a la cárcel.");
       this.estado = EstadosJugadores.PRESO; // Actualiza el estado del jugador a "EN_CARCEL"
//       doblesConsecutivos = 0; // Reiniciar el contador de dobles
      }

//    @Override
//    public void recibirPago(int monto) {
//        dinero += monto;
//    }
}