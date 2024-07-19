package org.model.board;

import org.model.bank.Banco;
import org.model.box.*;
import org.model.box.strategys.*;
import org.model.card.*;
import org.model.console.Consola;
import org.model.enums.Provincias;
import org.model.enums.TipoCasillero;
import org.model.enums.Zonas;
import org.services.IPeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tablero {
//    private final List<TipoCasillero> NO_USA_BANCO = Arrays.asList(TipoCasillero.COMISARIA, Tipo
    /**
     * Lista de casilleros del tablero
     */
    private Casillero[] casilleros;
    private MazoPropiedades propiedades;
    private Banco banco;
    private MazoDestinoSuerte destinoSuerte;
    private Consola consola;

    public Casillero getCasillero(int nroCasillero) {
        return casilleros[nroCasillero];
    }

    public MazoPropiedades getPropiedades() {
        return propiedades;
    }

    public Tablero(MazoPropiedades propiedades, Banco banco, Consola consola) {
        this.casilleros = new Casillero[42];
        this.propiedades = propiedades;
        this.banco = banco;
        this.consola = consola;
        this.destinoSuerte = new MazoDestinoSuerte(banco);
        this.inicializarCasilleros();
        this.asignarPropiedades();
    }

    private void inicializarCasilleros() {
        casilleros[0] = new Casillero(0, TipoCasillero.SALIDA, new StrategyCasilleroSalida(banco));
        casilleros[1] = new CasilleroPropiedad(1, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Formosa - Zona Sur
        casilleros[2] = new CasilleroPropiedad(2, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Formosa - Zona Centro
        casilleros[3] = new CasilleroPropiedad(3, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Formosa - Zona Norte
        casilleros[4] = new Casillero(4, TipoCasillero.IMPUESTO, new StrategyCasilleroImpuesto(banco));
        casilleros[5] = new CasilleroPropiedad(5, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Rio Negro - Zona Sur
        casilleros[6] = new CasilleroPropiedad(6, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Rio Negro - Zona Norte
        casilleros[7] = new Casillero(7, TipoCasillero.PREMIO, new StrategyCasilleroPremio(banco));
        casilleros[8] = new CasilleroPropiedad(8, TipoCasillero.COMPANIA, new StrategyCasilleroCompania(banco)); //Compañia petrolera
        casilleros[9] = new CasilleroPropiedad(9, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Salta - Zona Sur
        casilleros[10] = new Casillero(10, TipoCasillero.DESTINO, new StrategyCasilleroDestino());
        casilleros[11] = new CasilleroPropiedad(11, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Salta - Zona Centro
        casilleros[12] = new CasilleroPropiedad(12, TipoCasillero.FERROCARRIL, new StrategyCasilleroFerrocarril(banco)); //Ferrocarril - Belgrano
        casilleros[13] = new CasilleroPropiedad(13, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Salta - Zona Norte
        casilleros[14] = new Casillero(14, TipoCasillero.COMISARIA, new StrategyCasilleroComisaria());
        casilleros[15] = new Casillero(15, TipoCasillero.SUERTE, new StrategyCasilleroSuerte());
        casilleros[16] = new CasilleroPropiedad(16, TipoCasillero.COMPANIA, new StrategyCasilleroCompania(banco)); //Bodega
        casilleros[17] = new CasilleroPropiedad(17, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Mendoza - Zona Sur
        casilleros[18] = new CasilleroPropiedad(18, TipoCasillero.FERROCARRIL, new StrategyCasilleroFerrocarril(banco)); //Ferrocarril - San Martin
        casilleros[19] = new CasilleroPropiedad(19, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Mendoza - Zona Centro
        casilleros[20] = new CasilleroPropiedad(20, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Mendoza - Zona Norte
        casilleros[21] = new Casillero(21, TipoCasillero.DESCANSO, new StrategyCasilleroDescanso(consola));
        casilleros[22] = new CasilleroPropiedad(22, TipoCasillero.FERROCARRIL, new StrategyCasilleroFerrocarril(banco)); //Ferrocarril - B. Mitre
        casilleros[23] = new CasilleroPropiedad(23, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Santa Fe - Zona Sur
        casilleros[24] = new CasilleroPropiedad(24, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Santa Fe - Zona Centro
        casilleros[25] = new Casillero(25, TipoCasillero.DESTINO, new StrategyCasilleroDestino());
        casilleros[26] = new CasilleroPropiedad(26, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Santa Fe - Zona Norte
        casilleros[27] = new CasilleroPropiedad(27, TipoCasillero.FERROCARRIL, new StrategyCasilleroFerrocarril(banco)); //Ferrocarril - Urquiza
        casilleros[28] = new Casillero(28, TipoCasillero.ESTACIONAMIENTO, new StrategyCasilleroEstacionamiento());
        casilleros[29] = new CasilleroPropiedad(29, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Tucuman - Zona Sur
        casilleros[30] = new CasilleroPropiedad(30, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Tucuman - Zona Norte
        casilleros[31] = new CasilleroPropiedad(31, TipoCasillero.COMPANIA, new StrategyCasilleroCompania(banco)); //Compañia Ingenio
        casilleros[32] = new CasilleroPropiedad(32, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Cordoba - Zona Sur
        casilleros[33] = new CasilleroPropiedad(33, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Cordoba - Zona Centro
        casilleros[34] = new CasilleroPropiedad(34, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Cordoba - Zona Norte
        casilleros[35] = new Casillero(35, TipoCasillero.MARCHE_PRESO, new StrategyCasilleroMarchePreso());
        casilleros[36] = new Casillero(36, TipoCasillero.SUERTE, new StrategyCasilleroSuerte());
        casilleros[37] = new CasilleroPropiedad(37, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Buenos Aires - Zona Sur
        casilleros[38] = new Casillero(38, TipoCasillero.DESTINO, new StrategyCasilleroDestino());
        casilleros[39] = new CasilleroPropiedad(39, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Buenos Aires - Zona Centro
        casilleros[40] = new CasilleroPropiedad(40, TipoCasillero.PROVINCIA, new StrategyCasilleroProvincia(banco)); //Buenos Aires - Zona Norte
        casilleros[41] = new Casillero(41, TipoCasillero.IMPUESTO, new StrategyCasilleroImpuesto(banco));
    }

    public void asignarPropiedades(){
        for (CartaProvincia provincia : propiedades.getMazoProvincias()){
            if (casilleros[provincia.getNroCasillero()] instanceof CasilleroPropiedad){
                ((CasilleroPropiedad) casilleros[provincia.getNroCasillero()]).setPropiedad(provincia);
            }
        }
        for (CartaCompania compania : propiedades.getMazoCompanias()){
            if (casilleros[compania.getNroCasillero()] instanceof CasilleroPropiedad){
                ((CasilleroPropiedad) casilleros[compania.getNroCasillero()]).setPropiedad(compania);
            }
        }
        for (CartaFerrocarril ferrocarril: propiedades.getMazoFerrocarriles()){
            if (casilleros[ferrocarril.getNroCasillero()] instanceof CasilleroPropiedad){
                ((CasilleroPropiedad) casilleros[ferrocarril.getNroCasillero()]).setPropiedad(ferrocarril);
            }
        }
    }





    public void moverJugador(IPeon jugador, int cantMovimientos){
        int posicionInicial = jugador.getPosicion();
        int posicionFinal = (posicionInicial + cantMovimientos) % casilleros.length;
        jugador.setPosicion(posicionFinal);
        if (posicionInicial > posicionFinal){
            casilleros[0].accionCasillero(jugador);
        }
    }

    public void accionCasillero(IPeon jugador){
        Casillero casilleroActual = casilleros[jugador.getPosicion()];
        if (casilleroActual.getTipoCasillero() == TipoCasillero.DESTINO){
            destinoSuerte.activarCartaDestino(jugador);
        } else if (casilleroActual.getTipoCasillero() == TipoCasillero.SUERTE) {
            destinoSuerte.activarCartaSuerte(jugador);
        }
        casilleros[jugador.getPosicion()].accionCasillero(jugador);
    }

    public List<CartaProvincia> obtenerCartasProvinciaSinDuenio(){
        List<CartaProvincia> auxReturn = new ArrayList<CartaProvincia>();
        for(Casillero casillero : casilleros){
            if(casillero instanceof CasilleroPropiedad){
                CasilleroPropiedad casilleroPropiedad = (CasilleroPropiedad) casillero;
                if(casilleroPropiedad.getPropiedad() instanceof CartaProvincia){
                    CartaProvincia carta = (CartaProvincia) casilleroPropiedad.getPropiedad();
                    if(carta.getDuenio() == null){
                        auxReturn.add(carta);
                    }
                }
            }
        }
        return auxReturn;
    }

    public List<CartaCompania> obtenerCartasCompaniaSinDuenio(){
        List<CartaCompania> auxReturn = new ArrayList<>();
        for(Casillero casillero : casilleros){
            if(casillero instanceof CasilleroPropiedad){
                CasilleroPropiedad casilleroPropiedad = (CasilleroPropiedad) casillero;
                if(casilleroPropiedad.getPropiedad() instanceof CartaCompania){
                    CartaCompania carta = (CartaCompania) casilleroPropiedad.getPropiedad();
                    if(carta.getDuenio() == null){
                        auxReturn.add(carta);
                    }
                }
            }
        }
        return auxReturn;
    }
}
