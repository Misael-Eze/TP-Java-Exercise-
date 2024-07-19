package org.model.card;


import org.model.bank.Banco;
import org.services.IPeon;
import org.services.IStrategyAzar;
import org.services.ITarjeta;

import java.util.*;

public class MazoDestinoSuerte {
    private final Map<Integer, ITarjeta> mazoDestino;
    private final Map<Integer, ITarjeta>  mazoSuerte;
    private final List<Integer> cartasUtilizadasMazoDestino;
    private final List<Integer> cartasUtilizadasMazoSuerte;
    private final Banco banco;

    public MazoDestinoSuerte(Banco banco) {
        this.banco = banco;

        mazoDestino = new HashMap<>();
        mazoSuerte = new HashMap<>();
        cartasUtilizadasMazoDestino = new ArrayList<>();
        cartasUtilizadasMazoSuerte = new ArrayList<>();
        inicializarCartas();
        mezclarCartas();
    }

    private void inicializarCartas() {
        // Crear estrategias

        IStrategyAzar strategyPreso = new StrategyPreso();
        IStrategyAzar strategyCobrar10000 = new StrategyCobrar(10000);
        IStrategyAzar strategyAvanzarBodega = new StrategyAvanzarRetroceder(25);//VER QUE CASILLERO ES BODEGA
        IStrategyAzar strategyAvanzarBSASNor= new StrategyAvanzarRetroceder(20);//VER QUE CASILLERO ES
        IStrategyAzar strategyAvanzarSALNor = new StrategyAvanzarRetroceder(15);//VER QUE CASILLERO ES
        IStrategyAzar strategyPagar300 = new StrategyPagar(300,banco);
        IStrategyAzar strategyCobrar3000 = new StrategyCobrar(3000);
        IStrategyAzar strategyCobrar1000 = new StrategyCobrar(1000);
        IStrategyAzar strategyAvanzarSalida = new StrategyAvanzarSalida();
        IStrategyAzar strategyPagar3000 = new StrategyPagar(3000,banco);
        //VOLVER3PASOSATRAS
        IStrategyAzar strategyPagar400 = new StrategyPagar(400,banco);
        //PAGARSEGUNPROP
        //PAGARSEGUNPROP
        IStrategyAzar strategyAvanzarSFNor = new StrategyAvanzarRetroceder(26);//VER QUE CASILLERO ES
        IStrategyAzar strategyLiberacion = new StrategyLiberar();
        IStrategyAzar strategyCobrar500 = new StrategyCobrar(500);
        IStrategyAzar strategyCobrar400 = new StrategyCobrar(400);
        IStrategyAzar strategyPagar1000 = new StrategyPagar(1000,banco);
        IStrategyAzar strategyCobrar2000 = new StrategyCobrar(2000);
        IStrategyAzar strategyCobrar4000 = new StrategyCobrar(4000);
        IStrategyAzar strategyCobrar200 = new StrategyCobrar(200);
        //hacerPagara los jugadores
        IStrategyAzar strategyAvanzarFORSUR = new StrategyAvanzarRetroceder(33);//VER QUE CASILLERO ES
        IStrategyAzar strategyPagar200 = new StrategyPagar(200,banco);


        // Crear cartas con IDs para Suerte
        mazoSuerte.put(1, new Tarjeta(1, strategyPreso,"Marche preso directamente"));
        mazoSuerte.put(2, new Tarjeta(2, strategyCobrar10000,"Ha ganado la grande"));
        mazoSuerte.put(3, new Tarjeta(3, strategyAvanzarBodega,"Avance hasta la Bodega"));
        mazoSuerte.put(4, new Tarjeta(4, strategyAvanzarBSASNor,"Siga hasta Buenos Aires, Zona Norte"));
        mazoSuerte.put(5, new Tarjeta(5, strategyAvanzarSALNor,"Siga hasta Salta, Zona Norte"));
        mazoSuerte.put(6, new Tarjeta(6, strategyPagar300,"Multa por exceso de Velocidad"));
        mazoSuerte.put(7, new Tarjeta(7, strategyCobrar3000,"Ganó en las carreras"));
        mazoSuerte.put(8, new Tarjeta(8, strategyCobrar1000,"Por Intereses bancarios"));
        mazoSuerte.put(9, new Tarjeta(9, strategyAvanzarSalida,"Avance Hasta Salida"));
        mazoSuerte.put(10, new Tarjeta(10, strategyPagar3000,"Por gastos colegiales."));
        //VOLVER3PASOSATRAS
        mazoSuerte.put(11, new Tarjeta(11, strategyPagar400,"Multa camionera"));
        //PAGARSEGUNPROP
        //PAGARSEGUNPROP
        mazoSuerte.put(12, new Tarjeta(12, strategyAvanzarSFNor,"Siga hasta santa fe,Zona Norte"));
        mazoSuerte.put(13, new Tarjeta(13, strategyLiberacion,"Habeas Corpus concedido. Con esta tarjeta sale usted gratuitamente de la comisaria."));








        // Crear cartas con IDs para el Destino
        mazoDestino.put(1, new Tarjeta(14, strategyCobrar500,"5% de interés sobre cédulas hipotecarias"));
        mazoDestino.put(2, new Tarjeta(15, strategyLiberacion,"Con esta Tarjeta sale usted de la comisaria"));
        mazoDestino.put(3, new Tarjeta(16, strategyPreso,"Marche Preso directamente"));
        mazoDestino.put(4, new Tarjeta(17, strategyCobrar400,"Devolución de impuesto"));
        mazoDestino.put(5, new Tarjeta(18, strategyPagar1000,"Pague su poliza de seguro"));
        mazoDestino.put(6, new Tarjeta(19, strategyCobrar2000,"Ha ganado concurso agricola"));
        mazoDestino.put(7, new Tarjeta(20, strategyCobrar4000,"Error de cálculos del Banco"));
        mazoDestino.put(8, new Tarjeta(21, strategyPagar1000,"Gastos de Farmacia"));
        mazoDestino.put(9, new Tarjeta(22, strategyCobrar200,"Ha obtenido un segundo premio de belleza"));
        //hacerPagara los jugadores
        mazoDestino.put(10, new Tarjeta(23, strategyCobrar2000,"Ha ganado concurso agricola"));
        mazoDestino.put(11, new Tarjeta(24, strategyCobrar2000,"Herencia"));
        mazoDestino.put(12, new Tarjeta(25, strategyCobrar1000,"Por venta de acciones"));
        mazoDestino.put(13, new Tarjeta(26, strategyAvanzarSalida,"Siga hasta la Salida"));
        mazoDestino.put(14, new Tarjeta(27, strategyAvanzarFORSUR,"Vuelve atras hasta Formosa, Zona Sur"));
        mazoDestino.put(15, new Tarjeta(28, strategyPagar200,"Por Multa"));







        // Agregar más cartas según tus necesidades para el mazo 2
    }

    private void mezclarCartas() {

        cartasUtilizadasMazoDestino.addAll(mazoDestino.keySet());
        cartasUtilizadasMazoSuerte.addAll(mazoSuerte.keySet());

        Collections.shuffle(cartasUtilizadasMazoDestino);
        Collections.shuffle(cartasUtilizadasMazoSuerte);
    }

    public void activarCartaDestino(IPeon jugador) {
        Integer id = cartasUtilizadasMazoDestino.remove(0); // Saca primer ID
        ITarjeta tarjeta = mazoDestino.get(id);
        tarjeta.activarCarta(jugador);
        cartasUtilizadasMazoDestino.add(id);
    }

    public void activarCartaSuerte(IPeon jugador) {
        Integer id = cartasUtilizadasMazoSuerte.remove(0); // Sacar el primer ID
        ITarjeta tarjeta = mazoSuerte.get(id);
        tarjeta.activarCarta(jugador);
        cartasUtilizadasMazoSuerte.add(id);
    }

}
