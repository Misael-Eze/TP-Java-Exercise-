package org.model.console;

//import org.example.bank.Banco;
//import jdk.javadoc.internal.doclets.toolkit.util.Utils;
import org.model.board.Tablero;
import org.model.box.Casillero;
import org.model.card.CartaCompania;
import org.model.card.CartaFerrocarril;
import org.model.card.CartaProvincia;
import org.model.enums.TipoCasillero;
import org.model.player.Bot;
import org.model.player.Dados;
import org.model.player.Jugador;
import org.services.IPeon;
import org.services.IPropiedad;

import java.util.List;
import java.util.Scanner;

/*
         Negro:\033[30m
         Rojo:\033[31m
         Verde:\033[32m
         Amarillo:\033[33m
         Azul:\033[34m
         Magenta:\033[35m
         Blanco:\033[37m
         Cyan:\033[36m
         Reset:\u001B[0m
 */

public class Consola {


    // La única instancia de la clase Consola
    private static Consola instancia;
    private Scanner control;
    private Grafico graficos;
    private Validacion validador;
    private Tablero tableroJuego;


    // Constructor privado para evitar la creación de instancias desde fuera
//    private Consola(Grafico graficos, Validacion validacion, Scanner scanner, Tablero tablero) {
//        this.control = scanner;
//        this.graficos = graficos;
//        this.validador = validacion;
//        this.tableroJuego = tablero;
//    }

    public Consola(){
        control = new Scanner(System.in);
        graficos = new Grafico();
        validador = new Validacion();
    }

    // Método estático para obtener la única instancia de la clase
//    public static Consola getInstancia(Grafico graficos, Validacion validacion, Scanner scanner, Tablero tablero) {
//        if (instancia == null) {
//            instancia = new Consola(graficos, validacion, scanner, tablero);
//        }
//        return instancia;
//    }

    //----------------------------------------------------------------------------------------------------

    /*

    mostrarMenuBanco(){} (en proceso) *metodo de validacion de saldo en cuenta, *metodo de validacion de capacidad de adquisicion de mejora/propiedad

    * */

    //agregar recuperar partida

    //TODO:ENVIAR DATOS RECIBIDOS HACIA PARTIDA
    //TODO:[CONSOLA] TIENE QUE MOSTRAR TITULO,SEGUIR PARTIDA O NUEVA PARTIDA Y ELEGIR DIFICULTAD

    public int ofrecerHipotecar(List<IPropiedad> propiedades){
        for (int i = 0; i < propiedades.size(); i++) {
            System.out.println(i+" - "+propiedades.get(i).getDescripcion());
        }
        System.out.println("Seleccione una Propiedad para hipotecar: ");
        return validador.pedirIndexValido(propiedades, control.nextInt());
    }

    public int pedirMontoParaGanar(){
        int montoParaGanar = 0;
        System.out.println("Ingrese el monto para ganar (entre 100000 y 999999)");
        montoParaGanar = validador.pedirMontoValido(control.nextInt());
        return montoParaGanar;
    }

    public int seleccionarDificultad() {
        int respuestaDificultad;
        System.out.println(graficos.getGraficoseleccionarDificultad());
        respuestaDificultad = validador.pedirNumeroValido3Opciones(control.nextLine(), control);
        return respuestaDificultad;
    }

    public int opcionSeleccionPartida() {
        int respuestaPartida;
        System.out.println(graficos.getOpcionSeleccionPartida());
        respuestaPartida = validador.pedirNumeroValido(control.nextLine());
        return respuestaPartida;
    }


    public void menuInicial() {
        System.out.println(graficos.getGraficoTitulo()+"\r");
    }

    public void mostrarInfoPropiedad(IPropiedad propiedad){
        String plantillaCompaniaFerrocarril =
                "  ╔════════════════════════════════════════╗\n" +
                        "  ║                                        ║\n" +
                        "  ║   %-25s            ║\n" +
                        "  ║                                        ║\n" +
                        "  ╠════════════════════════════════════════╣\n" +
                        "  ║      Valor: %-6s  Dueño: %-12s║\n" + // Agrupamos Valor y Dueño en una línea
                        "  ║                                        ║\n" +
                        "  ║                                        ║\n" +
                        "  ╠════════════════════════════════════════╣\n" +
                        "  ║           Hipoteca: %-12s       ║\n" +
                        "  ║                                        ║\n" +
                        "  ╚════════════════════════════════════════╝\n";



        String plantillaProvincia =
                "  ╔════════════════════════════════════════╗\n" +
                        "  ║                                        ║\n" +
                        "  ║        %-25s       ║\n" +
                        "  ║                                        ║\n" +
                        "  ╠════════════════════════════════════════╣\n" +
                        "  ║    Valor: %-6s    Dueño: %-12s║\n" + // Agrupamos Valor y Dueño en una línea
                        "  ║                                        ║\n" +
                        "  ║           Alquiler: %-12s       ║\n" +
                        "  ╠════════════════════════════════════════╣\n" +
                        "  ║           Chacra: %-12s         ║\n" +
                        "  ║           Estancia: %-12s       ║\n" +
                        "  ╚════════════════════════════════════════╝\n";


        String mensaje = "";

        if (propiedad instanceof CartaProvincia){
            CartaProvincia provincia = (CartaProvincia) propiedad;
            mensaje = String.format(plantillaProvincia,
                    provincia.getDescripcion(),
                    provincia.getValor(),
                    (provincia.getDuenio() == null) ? "Sin dueño" : provincia.getDuenio().getNombre(),
                    provincia.getValorAlquiler(),
                    provincia.getValorChacra(),
                    provincia.getValorEstancia());
        } else if (propiedad instanceof CartaCompania || propiedad instanceof CartaFerrocarril) {
            mensaje = String.format(plantillaCompaniaFerrocarril,
                    propiedad.getDescripcion(),
                    propiedad.getValor(),
                    (propiedad.getDuenio() == null) ? "Sin dueño" : propiedad.getDuenio().getNombre(),
                    propiedad.getValorHipoteca());
        }
        System.out.println(mensaje);

    }

    public int mostrarMenuTurno(Jugador jugador, Tablero tablero) {
        // Obtener detalles del jugador
        String estadoJugador = jugador.getEstado().toString();

        // Construir el mensaje del menú de turno
        String mensaje = String.format(
                "  ╔═════════════════════════╗\n" +
                        "  ║        TURNO            ║\n" +
                        "  ╠═════════════════════════╣\n" +
                        "  ║ Jugador: %-12s   ║\n" +
                        "  ║ Casilla: %-12d   ║\n" +
                        "  ║ Estado: %-12s    ║\n" +
                        "  ║ Dinero: %-12d    ║\n" +
                        "  ╠═════════════════════════╣\n" +
                        "  ║ 1 - Tirar Dados         ║\n" +
                        "  ║ 2 - Salir del juego     ║\n" +
                        "  ╚═════════════════════════╝",
                jugador.getNombre(),
                jugador.getPosicion(),
                estadoJugador,
                jugador.getDinero()
        );


        // Mostrar el mensaje del menú
        System.out.println(mensaje);

        // Pedir y validar la respuesta del jugador
        int respuestaValidada = validador.pedirNumeroValido(control.nextLine());
        if (respuestaValidada == 1){
            // Informar sobre la casilla actual
            System.out.println("Casilla actual");
            informarCasillaActual(tablero, jugador.getPosicion());
        }
        return respuestaValidada; //revizar!!!!!!!!!!!!!!!!!
    }

    public void informarTurnoBot(Tablero tablero, Bot jugador) {

    }

    public void informarCasillaActual(Tablero tablero, int posicionActual) {
        Casillero casillero = tablero.getCasillero(posicionActual);
        TipoCasillero tipoCasillero = casillero.getTipoCasillero();
        String grafico = "";

        switch (tipoCasillero) {
            case PROVINCIA:
                grafico = graficos.getGraficoProvincia();
//                mostrarMenuBanco();
                break;
            case COMISARIA:
                grafico = graficos.getGraficoComisaria();
                break;
            case COMPANIA:
                grafico = graficos.getGraficoCompania();
                break;
            case DESTINO:
                grafico = graficos.getGraficoDestino();
                break;
            case DESCANSO:
                grafico = graficos.getGraficoEstadoDescanso();
                break;
            case ESTACIONAMIENTO:
                grafico = graficos.getGraficoEstacionamiento();
                break;
            case FERROCARRIL:
                grafico = graficos.getGraficoFerrocarril();
                break;
            case IMPUESTO:
                grafico = graficos.getGraficoImpuesto();
                break;
            case MARCHE_PRESO:
                grafico = graficos.getGraficoEstadoPreso();
                break;
            case PREMIO:
                grafico = graficos.getGraficoPremio();
                break;
            case SALIDA:
                grafico = graficos.getGraficoSalida();
                break;
            case SUERTE:
                grafico = graficos.getGraficoSuerte();
                break;
            default:
                grafico = "Tipo de casillero desconocido";
                break;
        }
        System.out.println(grafico+"\n"+"Casillero nro: "+casillero.getNroCasillero());
        esperar();
    }
    //-----------------------------------------------------------------------------
    public void mostrarMenuBanco(Jugador jugador, IPropiedad propiedad) {
        System.out.println(graficos.getGraficoBanco());

        boolean salirDelBucle = false;

        while (!salirDelBucle) {
            System.out.print("Seleccione una opción: ");
            int seleccion = validador.pedirNumeroValido3Opciones(control.nextLine(), control);

            switch (seleccion) {
                case 1:
                    // Llamada al método ofrecerPropiedad con los parámetros adecuados
                    ofrecerPropiedad(jugador, propiedad);
                    salirDelBucle = true;
                    break;
                case 2:
                    // TODO: implementar la lógica para la mejora de propiedades
                    System.out.println("Mejora!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                case 3:
                    System.out.println("Seleccionaste Salir");
                    salirDelBucle = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }
    }

    //-----------------------------------------------------------------------------

//    public boolean mostrarMenuMejora(Jugador jugador, IPropiedad propiedad) {
//
//        boolean auxRespuesta = false;
//
//        String displayMejora = String.format(graficos.getGraficoMejoraPropiedad());
//        System.out.println(displayMejora);
//
//        int respuestaMejora = validador.pedirNumeroValido(control.nextLine());
//
//        if (respuestaMejora == 1) {
//         mostrarComprarEstancia();
//
//        } else if (respuestaMejora == 2) {
//
//         mostrarComprarChacra();
//        }
//        return auxRespuesta;
//    }


    public boolean ofrecerComprarEstancia(CartaProvincia provincia) {
        String displayEstancia = graficos.getGraficoEstancia();
        System.out.println(displayEstancia); // muestra el display gráfico del precio
        this.mostrarInfoPropiedad(provincia);
        System.out.println("Desea comprar una Estancia?\n1-SI\n2-NO");

        int respuestaEstancia = validador.pedirNumeroValido(control.nextLine());

        switch (respuestaEstancia) {
            case 1:
                String displayMejoraAdquirida = String.format(graficos.getGraficoEstancia() + "\n%s adquirida", provincia.getDescripcion());
                System.out.println(displayMejoraAdquirida);
                // Lógica para mejorar la estancia (compra)
                // Aquí deberías implementar la lógica de compra según tus requisitos
                esperar();
                return true; // Indica que se decidió mejorar la estancia
            case 2:
                System.out.println("Saliendo");
                esperar();
                return false; // Indica que no se desea mejorar la estancia
            default:
                System.out.println("Opción no válida. Saliendo.");
                esperar();
                return false; // Por defecto, se asume que no se desea mejorar la estancia
        }
    }




    //------------------------------------------------------------------------------

    public boolean ofrecerPropiedad(Jugador jugador, IPropiedad propiedad) {
        boolean auxResultado = false;
        this.mostrarInfoPropiedad(propiedad);
        System.out.println("Desea Comprarla?\n1-SI\n2-NO");
        //Info de la propiedad
            int respuestaCompra = validador.pedirNumeroValido(control.nextLine());
            if (respuestaCompra == 1) {
                auxResultado = true;
                System.out.println("Propiedad Adquirida");
                String displayCompra = String.format(graficos.getGraficoCompraPropiedad());
                System.out.println(displayCompra);

//                esperar();
            } else if (respuestaCompra == 2) {
                System.out.println("Saliendo");
                esperar();
            } else {
                System.out.println("Respuesta incorrecta");
            }

            return auxResultado;
    }
    /**
     * Muestra el gráfico de la chacra y permite al jugador decidir si desea mejorarla.
     * Devuelve true si el jugador decide mejorarla y la compra se realiza con éxito, false en otros casos.
     */
    public boolean ofrecerComprarChacra(CartaProvincia provincia) {
        String displayChacra = graficos.getGraficoChacra();
        System.out.println(displayChacra);
        mostrarInfoPropiedad(provincia);
        System.out.println(
                "Desea comprar una Estancia?\n1-SI\n2-NO"
        );

        int respuestaChacra = validador.pedirNumeroValido(control.nextLine());

        switch (respuestaChacra) {
            case 1:
                String displayMejoraAdquirida = String.format(graficos.getGraficoChacra() + "\n%s adquirida", provincia.getDescripcion());
                System.out.println(displayMejoraAdquirida);
                esperar();
                return true;
//                if (jugador.getDinero() >= propiedad.getValorChacra()) {
//                    jugador.comprarChacra(propiedad);
//
//                     // Se realizó la compra con éxito
//                } else {
//                    System.out.println("No tienes suficiente dinero para mejorar la chacra.");
//                    esperar();
//                    return false; // No se pudo realizar la compra por falta de dinero
//                }
            case 2:
                System.out.println("Saliendo");
                esperar();
                return false; // El jugador decide no mejorar la chacra
            default:
                System.out.println("Opción no válida. Saliendo.");
                esperar();
                return false; // Opción inválida, no se realiza ninguna acción
        }
    }

    public void mostrarTirarDados(Dados dados) {
        //deberia tomar la instancia del dado del jugador del turno

        String resultadoDado = String.format(graficos.mostrarGraficoDados(dados.getFirstDice(), dados.getSecondDice()));
        System.out.println(resultadoDado);

        esperar();
    }

    public void esperar() {
        try {
            // Pausa la ejecución durante 3 segundos (3000 milisegundos)
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Manejo de excepciones si se interrumpe la pausa
            e.printStackTrace();
        }
    }

    public String darBienvenidaYPedirNombre() {
        System.out.println("Bienvenid@! Ingrese su nombre");
        String nombreJugador = control.nextLine();
        return nombreJugador;
    }

    public void informarPagoAlquiler(IPeon jugador, IPropiedad propiedad, int totalAlquiler) {

        System.out.println(jugador.getNombre()+" debe pagar "+totalAlquiler+" al jugador "+propiedad.getDuenio().getNombre());

    }

    //--------------------------------------------------------------------------------//

    public int ofrecerGuardarPartida(){
        String mensaje = graficos.getOpcionGuardarPartida();
        System.out.println(mensaje);
        int respuesta = validador.pedirNumeroValido(control.nextLine());
        return respuesta;
    }

    //--------------------------------------------------------------------------------//

    public int decidirGuardarPartida(){
        String mensaje = graficos.getDecidirGuardarPartida();
        System.out.println(mensaje);
        int respuesta = validador.pedirNumeroValido(control.nextLine());
        return respuesta;
    }

    public boolean preguntarSiQuiereDescansar(IPeon jugador) {
        boolean quiereDescansar = false;
        System.out.println("Casillero Descanso\n");
        System.out.println("Desea descansar por 2 turnos?\n1-SI\n2-NO");
        int opcionSeleccionada = validador.pedirNumeroValido(control.nextLine());
        if (opcionSeleccionada == 1) {
            quiereDescansar = true;
        }
        return quiereDescansar;
    }

    public void mostrarGandor(IPeon ganador) {
        System.out.println("Ganador de la partida: "+ganador.getNombre()+"\n");
        System.out.println("Dinero Obtenido: "+ganador.getDinero());
        System.out.println("Propiedades del ganador: ");
        for (int i = 0; i < ganador.getPropiedades().size(); i++) {
            System.out.println((i+1)+" - "+ganador.getPropiedades().get(i).getDescripcion());
        }
    }

    public void terminarPartida(IPeon winner) {
        System.out.println(graficos.getTerminarPartida(winner)+"\r");
    }

}
