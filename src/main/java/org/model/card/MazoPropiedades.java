package org.model.card;

import org.model.enums.Provincias;
import org.model.enums.Zonas;
import org.services.IPeon;
import org.services.IPropiedad;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MazoPropiedades {

    private List<CartaCompania> mazoCompanias;
    private List<CartaProvincia> mazoProvincias;
    private List<CartaFerrocarril> mazoFerrocarriles;


    public List<CartaCompania> getMazoCompanias() {
        return mazoCompanias;
    }

    public void setMazoCompanias(List<CartaCompania> mazoCompanias) {
        this.mazoCompanias = mazoCompanias;
    }

    public List<CartaProvincia> getMazoProvincias() {
        return mazoProvincias;
    }

    public List<CartaFerrocarril> getMazoFerrocarriles() {
        return mazoFerrocarriles;
    }



    public MazoPropiedades() {
        iniciarMazos();
    }

    private void iniciarMazos() {
        mazoProvincias = new ArrayList<>();
        mazoCompanias = new ArrayList<>();
        mazoFerrocarriles = new ArrayList<>();


        //Carga Mazo Provincias
        mazoProvincias.add(new CartaProvincia(1, "Formosa - Zona Sur", Provincias.FORMOSA, Zonas.SUR, 1000,40, 1000, 1000, 500));
        mazoProvincias.add(new CartaProvincia(2, "Formosa - Zona Centro", Provincias.FORMOSA, Zonas.CENTRO, 1000,40, 1000, 1000, 500));
        mazoProvincias.add(new CartaProvincia(3, "Formosa - Zona Norte", Provincias.FORMOSA, Zonas.NORTE, 1200,80, 1000, 1000, 600));
        mazoProvincias.add(new CartaProvincia(5, "Rio Negro - Zona Sur", Provincias.RIO_NEGRO, Zonas.SUR, 2000,110, 1000, 1000, 1000));
        mazoProvincias.add(new CartaProvincia(6, "Rio Negro - Zona Norte", Provincias.RIO_NEGRO, Zonas.NORTE, 2200,150, 1000, 1000, 1100));
        mazoProvincias.add(new CartaProvincia(9, "Salta - Zona Sur", Provincias.SALTA, Zonas.SUR, 2600,200, 1500, 1500, 1300));
        mazoProvincias.add(new CartaProvincia(11, "Salta - Zona Centro", Provincias.SALTA, Zonas.CENTRO, 2600,200, 1500, 1500, 1300));
        mazoProvincias.add(new CartaProvincia(13, "Salta - Zona Norte", Provincias.SALTA, Zonas.NORTE, 3000,230, 1500, 1500, 1500));
        mazoProvincias.add(new CartaProvincia(17, "Mendoza - Zona Sur", Provincias.MENDOZA, Zonas.SUR, 3400,250, 2000, 2000, 1700));
        mazoProvincias.add(new CartaProvincia(19, "Mendoza - Zona Centro", Provincias.MENDOZA, Zonas.CENTRO, 3400,250, 2000, 2000, 1700));
        mazoProvincias.add(new CartaProvincia(20, "Mendoza - Zona Norte", Provincias.MENDOZA, Zonas.NORTE, 3800,300, 2000, 2000, 1900));
        mazoProvincias.add(new CartaProvincia(23, "Santa Fe - Zona Sur", Provincias.SANTA_FE, Zonas.SUR, 4200,350, 2500, 2500, 2100));
        mazoProvincias.add(new CartaProvincia(24, "Santa Fe - Zona Centro", Provincias.SANTA_FE, Zonas.CENTRO, 4200,350, 2500, 2500, 2100));
        mazoProvincias.add(new CartaProvincia(26, "Santa Fe - Zona Norte", Provincias.SANTA_FE, Zonas.NORTE, 4600,400, 2500, 2500, 2300));
        mazoProvincias.add(new CartaProvincia(29, "Tucuman - Zona Sur", Provincias.TUCUMAN, Zonas.SUR, 5000,400, 3000, 3000, 2500));
        mazoProvincias.add(new CartaProvincia(30, "Tucuman - Zona Norte", Provincias.TUCUMAN, Zonas.NORTE, 5400,350, 3000, 3000, 2700));
        mazoProvincias.add(new CartaProvincia(32, "Cordoba - Zona Sur", Provincias.CORDOBA, Zonas.SUR, 6000,500, 3000, 3000, 3000));
        mazoProvincias.add(new CartaProvincia(33, "Cordoba - Zona Centro", Provincias.CORDOBA, Zonas.CENTRO, 6000,450, 3000, 3000, 3000));
        mazoProvincias.add(new CartaProvincia(34, "Cordoba - Zona Norte", Provincias.CORDOBA, Zonas.NORTE, 6400,550, 3000, 3000, 3200));
        mazoProvincias.add(new CartaProvincia(37, "Buenos Aires - Zona Sur", Provincias.BUENOS_AIRES, Zonas.SUR, 7000,650, 4000, 4000, 3500));
        mazoProvincias.add(new CartaProvincia(39, "Buenos Aires - Zona Centro", Provincias.BUENOS_AIRES, Zonas.CENTRO, 7000,650, 4000, 4000, 3500));
        mazoProvincias.add(new CartaProvincia(40, "Buenos Aires - Zona Norte", Provincias.BUENOS_AIRES, Zonas.NORTE, 7400,1000, 4000, 4000, 3700));

        //Carga Mazo Compañias
        mazoCompanias.add(new CartaCompania(8, "Compañia Petrolera",3800, 1900));
        mazoCompanias.add(new CartaCompania(16, "Bodega",3800, 1900));
        mazoCompanias.add(new CartaCompania(31, "Ingenio",3800, 1900));


        //Carga Mazo Ferrocarril
        mazoFerrocarriles.add(new CartaFerrocarril(12, "Ferrocarril - Gral. Belgrano",3600, 1900));
        mazoFerrocarriles.add(new CartaFerrocarril(18, "Ferrocarril - Gral. San Martin",3600, 1800));
        mazoFerrocarriles.add(new CartaFerrocarril(22, "Ferrocarril - Gral. B. Mitre",3600, 1800));
        mazoFerrocarriles.add(new CartaFerrocarril(27, "Ferrocarril - Gral. Urquiza",3600, 1700));
    }

    public List<CartaCompania> obtenerCartasCompaniaConDuenio(){
        List<CartaCompania> companiasConDuenio = new ArrayList<>();
        for (CartaCompania compania : mazoCompanias){
            if (compania.getDuenio() != null){
                companiasConDuenio.add(compania);
            }
        }
        return companiasConDuenio;
    }

    public List<CartaProvincia> obtenerCartasProvinciaConDuenio(){
        List<CartaProvincia> provinciasConDuenio = new ArrayList<>();
        for (CartaProvincia provincia : mazoProvincias){
            if (provincia.getDuenio() != null){
                provinciasConDuenio.add(provincia);
            }
        }
        return provinciasConDuenio;
    }

    public List<CartaFerrocarril> obtenerCartasFerrocarrilConDuenio(){
        List<CartaFerrocarril> ferrocarrilConDuenio = new ArrayList<>();
        for (CartaFerrocarril ferrocarril : mazoFerrocarriles){
            if (ferrocarril.getDuenio() != null){
                ferrocarrilConDuenio.add(ferrocarril);
            }
        }
        return ferrocarrilConDuenio;
    }

    public void actualizarPropiedad(IPropiedad propiedad){
        if (propiedad instanceof CartaProvincia){
            mazoProvincias.forEach(cartaProvincia ->{
                if (cartaProvincia.getNroCasillero() == propiedad.getNroCasillero()){
                    mazoProvincias.set(mazoProvincias.indexOf(cartaProvincia), (CartaProvincia) propiedad);
                }
            });
        } else if (propiedad instanceof CartaCompania) {
            mazoCompanias.forEach(cartaCompania -> {
                if (cartaCompania.getNroCasillero() == propiedad.getNroCasillero()) {
                    mazoCompanias.set(mazoCompanias.indexOf(cartaCompania), (CartaCompania) propiedad);
                }
            });
        } else if (propiedad instanceof CartaFerrocarril) {
            mazoFerrocarriles.forEach(cartaFerrocarril -> {
                if (cartaFerrocarril.getNroCasillero() == propiedad.getNroCasillero()) {
                    mazoFerrocarriles.set(mazoFerrocarriles.indexOf(cartaFerrocarril), (CartaFerrocarril) propiedad);
                }
            });
        }
    }




    public void actualizarPropiedades(List<IPropiedad> propiedades) {
        for (IPropiedad propiedad : propiedades) {
            if (propiedad instanceof CartaProvincia){
                mazoProvincias.forEach(cartaProvincia -> {
                    if (cartaProvincia.getNroCasillero() == propiedad.getNroCasillero()) {
                        mazoProvincias.set(mazoProvincias.indexOf(cartaProvincia), (CartaProvincia) propiedad);
                    }
                });
            } else if (propiedad instanceof CartaCompania) {
                mazoCompanias.forEach(cartaCompania -> {
                    if (cartaCompania.getNroCasillero() == propiedad.getNroCasillero()) {
                        mazoCompanias.set(mazoCompanias.indexOf(cartaCompania), (CartaCompania) propiedad);
                    }
                });
            } else if (propiedad instanceof CartaFerrocarril) {
                mazoFerrocarriles.forEach(cartaFerrocarril -> {
                    if (cartaFerrocarril.getNroCasillero() == propiedad.getNroCasillero()) {
                        mazoFerrocarriles.set(mazoFerrocarriles.indexOf(cartaFerrocarril), (CartaFerrocarril) propiedad);
                    }
                });
            }
        }
    }



    public List<CartaProvincia> obtenerCartasProvinciaSinDuenio(){
        List<CartaProvincia> provinciasSinDuenio = new ArrayList<CartaProvincia>();
        for (CartaProvincia provincia : mazoProvincias) {
            if (provincia.getDuenio() == null){
                provinciasSinDuenio.add(provincia);
            }
        }
        return provinciasSinDuenio;
    }

    public List<CartaCompania> obtenerCartasCompaniaSinDuenio(){
        List<CartaCompania> companiasSinDuenio = new ArrayList<CartaCompania>();
        for (CartaCompania compania : mazoCompanias) {
            if (compania.getDuenio() == null){
                companiasSinDuenio.add(compania);
            }
        }
        return companiasSinDuenio;
    }

    public int cantFerrocarrilesPorDuenio(IPeon jugador){
        int cantFerrocarriles = 0;
        for (CartaFerrocarril ferrocarril : mazoFerrocarriles) {
            if (ferrocarril.getDuenio() == jugador){
                cantFerrocarriles++;
            }
        }
        return cantFerrocarriles;
    }

    public int cantCompaniasPorDuenio(IPeon jugador){
        int cantCompanias = 0;
        for (CartaCompania compania : mazoCompanias) {
            if (compania.getDuenio() == jugador){
                cantCompanias++;
            }
        }
        return cantCompanias;
    }

    public List<IPropiedad> obtenerPropiedadesVendidas(){
        List<IPropiedad> propiedadesVendidas = new ArrayList<>();
        for (CartaProvincia provincia : mazoProvincias) {
            if (provincia.getDuenio() != null){
                propiedadesVendidas.add(provincia);
            }
        }
        for (CartaCompania compania : mazoCompanias) {
            if (compania.getDuenio() != null){
                propiedadesVendidas.add(compania);
            }
        }
        for (CartaFerrocarril ferrocarril : mazoFerrocarriles) {
            if (ferrocarril.getDuenio() != null){
                propiedadesVendidas.add(ferrocarril);
            }
        }
        return propiedadesVendidas;
    }

    public List<CartaProvincia> obtenerProvinciasVendidas(){
        List<CartaProvincia> provinciasVendidas = new ArrayList<>();
        for(CartaProvincia provincia : mazoProvincias){
            if (provincia.getDuenio() != null){
                provinciasVendidas.add(provincia);
            }
        }
        return provinciasVendidas;
    }

    public List<CartaProvincia> provinciasJugador(IPeon jugador){
        List<CartaProvincia> provinciasJugador = new ArrayList<>();
        List<IPropiedad> propiedadesJugador = jugador.getPropiedades();
        for (IPropiedad propiedad : propiedadesJugador){
            if (propiedad instanceof CartaProvincia){
                provinciasJugador.add((CartaProvincia) propiedad);
            }
        }
        return provinciasJugador;
    }

    public boolean poseeTodasLasProvincias(IPeon peon, CartaProvincia provincia) {

        int cantProvincias = 0;
        List<CartaProvincia> provinciasJugador =  this.provinciasJugador(peon);
        for (CartaProvincia carta : provinciasJugador) {
            if (carta.getProvincia() == provincia.getProvincia()){
                cantProvincias++;
            }
        }
        if (provincia.getProvincia() == Provincias.RIO_NEGRO || provincia.getProvincia() == Provincias.TUCUMAN){
            int provinciaCompleta = 2;
            return cantProvincias == provinciaCompleta;
        }else{
            int provinciaCompleta = 3;
            return cantProvincias == provinciaCompleta;
        }
    }

    public List<CartaProvincia> filtrarProvinciasPor(Provincias nombreProvincia) {
        List<CartaProvincia> provinciasFiltradas = new ArrayList<>();
        for (CartaProvincia provincia : mazoProvincias) {
            if (provincia.getProvincia().equals(nombreProvincia)) {
                provinciasFiltradas.add(provincia);
            }
        }
        return provinciasFiltradas;
    }



}
