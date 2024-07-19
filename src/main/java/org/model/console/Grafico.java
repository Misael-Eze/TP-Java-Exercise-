package org.model.console;
import org.model.enums.TipoCasillero;
import static org.model.enums.TipoCasillero.*;

import java.util.List;

import org.model.enums.*;
import org.services.IPeon;
import org.services.IPropiedad;


public class Grafico {


    public Grafico(){

    }

    public String getGraficoTitulo() {
        return graficoTitulo;
    }

    public String getGraficoDivisor() {
        return graficoDivisor;
    }

    public String getGraficoComisaria() {
        return graficoComisaria;
    }

    public String getGraficoBanco() {
        return graficoBanco;
    }

    public String getGraficoDados() {
        return graficoDados;
    }

    public String getGraficoMejoraPropiedad() {
        return graficoMejoraPropiedad;
    }

    public String getGraficoChacra() {
        return graficoChacra;
    }

    public String getGraficoPropiedad() {
        return graficoPropiedad;
    }

    public String getGraficoEstancia() {
        return graficoEstancia;
    }

    public String getGraficoseleccionarDificultad() {
        return graficoseleccionarDificultad;
    }

    public String getGraficoCompraPropiedad() {
        return graficoCompraPropiedad;
    }

    public String getGraficoEstadoPreso() {
        return graficoEstadoPreso;
    }

    public String getGraficoEstadoDescanso() {
        return graficoEstadoDescanso;
    }

    public String getOpcionSeleccionPartida() {
        return opcionSeleccionPartida;
    }

    public String getGraficoProvincia() {
        return graficoProvincia;
    }

    public String getGraficoCompania() {
        return graficoCompania;
    }

    public String getGraficoDestino() {
        return graficoDestino;
    }

    public String getGraficoEstacionamiento() {
        return graficoEstacionamiento;
    }

    public String getGraficoFerrocarril() {
        return graficoFerrocarril;
    }

    public String getGraficoImpuesto() {
        return graficoImpuesto;
    }

    public String getGraficoPremio() {
        return graficoPremio;
    }

    public String getGraficoSalida() {
        return graficoSalida;
    }

    public String getGraficoSuerte() {
        return graficoSuerte;
    }

    public String getOpcionGuardarPartida(){return opcionGuardarPartida;}

    public String getTerminarPartida(IPeon peon){return terminarPartida +" "+ peon.getNombre()+ " "+peon.getDinero();}

    public String getDecidirGuardarPartida() {
        return decidirGuardarPartida;
    }

    private String terminarPartida = "El ganador de la partida es:";
    
    private String decidirGuardarPartida =
            "  ╔════════════════════════════════════╗\n" +
                    "  ║                                    ║\n" +
                    "  ║     HAY UNA PARTIDA GUARDADA       ║\n" +
                    "  ║        DESEA  BORRARLA?            ║\n" +
                    "  ║                                    ║\n" +
                    "  ║             1 - SI                 ║\n" +
                    "  ║             2 - NO                 ║\n" +
                    "  ║                                    ║\n" +
                    "  ╚════════════════════════════════════╝\n";


    private String graficoTitulo =
            "  ╔════════════════════════════════════════════════════╗\n" +
                    "  ║                                                    ║\n" +
                    "  ║                     ESTANCIERO                     ║\n" +
                    "  ║                                                    ║\n" +
                    "  ║   405313-ALMEIDA            MISAEL                 ║\n" +
                    "  ║   114393-ARTUSA             MANUEL                 ║\n" +
                    "  ║   405862-BARRIONUEVO        SANTIAGO               ║\n" +
                    "  ║   114005-RAMIRA             RAIN                   ║\n" +
                    "  ║   405226-PAREDES            ESTEBAN                ║\n" +
                    "  ║   114245-SANDOVAL           AGUSTIN                ║\n" +
                    "  ╚════════════════════════════════════════════════════╝\n";





    private String opcionSeleccionPartida =
            "  ╔════════════════════════════════════╗\n" +
                    "  ║                                    ║\n" +
                    "  ║          OPCIÓN DE JUEGO           ║\n" +
                    "  ║                                    ║\n" +
                    "  ║       1 - NUEVA PARTIDA            ║\n" +
                    "  ║   2 - CARGAR PARTIDA ANTERIOR      ║\n" +
                    "  ║                                    ║\n" +
                    "  ╚════════════════════════════════════╝\n";

    private String opcionGuardarPartida =
            "  ╔════════════════════════════════════╗\n" +
                    "  ║                                    ║\n" +
                    "  ║          GUARDA PARTIDA?           ║\n" +
                    "  ║                                    ║\n" +
                    "  ║             1 - SI                 ║\n" +
                    "  ║             2 - NO                 ║\n" +
                    "  ║                                    ║\n" +
                    "  ╚════════════════════════════════════╝\n";





    private String graficoseleccionarDificultad =
            "  ╔════════════════════════════════════════════════════╗\n" +
                    "  ║                                                    ║\n" +
                    "  ║               SELECCIONAR DIFICULTAD               ║\n" +
                    "  ║                                                    ║\n" +
                    "  ║                   1 - FÁCIL                        ║\n" +
                    "  ║                   2 - MEDIO                        ║\n" +
                    "  ║                   3 - DIFÍCIL                      ║\n" +
                    "  ║                                                    ║\n" +
                    "  ╚════════════════════════════════════════════════════╝\n";


    private String graficoEstancia="     ':.\n" +
            "         []_____\n" +
            "        /\\      \\\n" +
            "    ___/  \\__/\\__\\__\n" +
            "---/\\___\\ |''''''|__\\-- ---\n" +
            "   ||'''| |''||''|''|\n" +
            "   ``\"\"\"`\"`\"\"))\"\"`\"\"`";



    private String graficoChacra="           x\n" +
            ".-. _______|\n" +
            "|=|/     /  \\\n" +
            "| |_____|_\"\"_|\n" +
            "|_|_[X]_|____|";


    private String graficoDescanso =
            "   ╔═══════════════╗\n" +
                    "   ║               ║\n" +
                    "   ║   DESCANSO    ║\n" +
                    "   ║               ║\n" +
                    "   ╚═══════════════╝\n";





    private String graficoPropiedad = //incluir el costo dentro como un metodo
            "   ╔═══════════════╗\n" +
                    "  ║               ║\n" +
                    "  ║  PROPIEDAD    ║\n" +
                    "  ║               ║\n" +
                    "  ╚═══════════════╝\n";



    private String graficoCompania =
            " ╔═══════════════╗\n" +
                    "  ║               ║\n" +
                    "  ║   COMPAÑIA    ║\n" +
                    "  ║               ║\n" +
                    "  ╚═══════════════╝\n";



    private String graficoMejoraPropiedad =
            "   ╔═════════════╗\n" +
                    "  ║             ║\n" +
                    "  ║   MEJORA    ║\n" +
                    "  ║             ║\n" +
                    "  ╚═════════════╝\n";



    private String graficoCompraPropiedad =
            "   ╔═════════════╗\n" +
                    "  ║             ║\n" +
                    "  ║   COMPRA    ║\n" +
                    "  ║             ║\n" +
                    "  ╚═════════════╝\n";



    private String graficoDados="   _______\n" +
            "  /\\ o o o\\\n" +
            " /o \\ o o o\\_______\n" +
            "<    >------>   o /|\n" +
            " \\ o/  o   /_____/o|\n" +
            "  \\/______/     |oo|\n" +
            "        |   o   |o/\n" +
            "        |_______|/";



    private String graficoBanco = "         _._._                       _._._\n" +
            "        _|   |_                     _|   |_\n" +
            "        | ... |_._._._._._._._._._._| ... |\n" +
            "        | ||| |  o BANCO ESTANCIERO o  | ||| |\n" +
            "        | \"\"\" |  \"\"\"    \"\"\"    \"\"\"  | \"\"\" |\n" +
            "   ())  |[-|-]| [-|-]  [-|-]  [-|-] |[-|-]|  ())\n" +
            "  (())) |     |---------------------|     | (()))\n" +
            " (())())| \"\"\" |  \"\"\"    \"\"\"    \"\"\"  | \"\"\" |(())())\n" +
            " (()))()|[-|-]|  :::   .-\"-.   :::  |[-|-]|(()))()\n" +
            " ()))(()|     | |~|~|  |_|_|  |~|~| |     |()))(()\n" +
            "    ||  |_____|_|_|_|__|_|_|__|_|_|_|_____|  ||\n" +
            "||==============================================|| \n" +
            "         1-𝓒𝓸𝓶𝓹𝓻𝓪𝓻                            \n" +
            "         2-𝓜𝓮𝓳𝓸𝓻𝓪𝓻                            \n" +
            "         3-𝓢𝓪𝓵𝓲𝓻                                \n" +
            "||==============================================||";



    private String graficoPetrolera ="⠀⠀⠀⣾⣷⣦⡀⠀⠀⠀⢀⣴⣾⣷⡄⠀\n" +
            "⠀⠀⠀⠙⠿⣿⣷⡀⠀⢠⣿⣿⡿⣟⣀⠀\n" +
            "⠀⠰⣿⣿⣶⣄⠹⣇⢀⡿⠋⣵⣾⣿⣿⠆\n" +
            "⢰⣶⣶⣶⣤⣈⠓⢹⢸⢁⡾⠟⠋⠉⠁⠀\n" +
            "⠈⠛⠛⠉⠉⠙⠳⢌⠀⡞⠰⢶⡆⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⣤⣤⣤⡄⠀⠁⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⢸⠃⢻⠀⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⠀⡯⠓⠹⡇⠀⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⠀⣻⢟⠛⢛⢿⠃⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⢀⡯⠔⠋⠓⠬⣇⠀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⠀⣸⠓⠢⣄⡤⠚⢻⡀⠀⠀⠀\n" +
            "⠀⠀⠀⠀⢀⣧⠔⠊⠁⠉⠒⢬⣇⠀⠀⠀\n" +
            "⠀⠀⣶⣶⣾⣷⣶⣶⣶⣶⣶⣶⣿⣶⣶⡆";

    private String graficoBodega ="         _\n" +
            "      _-'_'-_\n" +
            "   _-' _____ '-_\n" +
            "_-' ___________ '-_\n" +
            " |___|||||||||___|\n" +
            " |___|||||||||___|\n" +
            " |___|||||||o|___|\n" +
            " |___|||||||||___|\n" +
            " |___|||||||||___|\n" +
            " |___|||||||||___|";



    private String graficoDestino ="  ╔═══════════════╗\n" +
            "  ║      !        ║\n" +
            "  ║   DESTINO     ║\n" +
            "  ║               ║\n" +
            "  ╚═══════════════╝\n";



    private String graficoEstadoPreso ="  ╔═══════════════╗\n" +
            "  ║    JUGADOR    ║\n" +
            "  ║     PRESO     ║\n" +
            "  ║               ║\n" +
            "  ╚═══════════════╝\n";

    private String graficoEstadoDescanso ="  ╔═══════════════╗\n" +
            "  ║    JUGADOR    ║\n" +
            "  ║  DESCANSANDO  ║\n" +
            "  ║               ║\n" +
            "  ╚═══════════════╝\n";




    private String graficoFerrocarril ="  ╔═══════════════╗\n" +
            "  ║               ║\n" +
            "  ║  FERROCARRIL  ║\n" +
            "  ║               ║\n" +
            "  ╚═══════════════╝\n";



    private String graficoProvincia ="  ╔═══════════════╗\n" +
            "  ║               ║\n" +
            "  ║  PROVINCIA    ║\n" +
            "  ║               ║\n" +
            "  ╚═══════════════╝\n";



    private String graficoSuerte ="  ╔═══════════════╗\n" +
            "  ║       ?       ║\n" +
            "  ║    SUERTE     ║\n" +
            "  ║               ║\n" +
            "  ╚═══════════════╝\n";



    private String graficoImpuesto =
            "  ╔═══════════════╗\n" +
                    "  ║               ║\n" +
                    "  ║   IMPUESTO    ║\n" +
                    "  ║               ║\n" +
                    "  ╚═══════════════╝\n";




    private String graficoPremio =
            "  ╔═══════════════╗\n" +
                    "  ║               ║\n" +
                    "  ║    PREMIO     ║\n" +
                    "  ║               ║\n" +
                    "  ╚═══════════════╝\n";




    private String graficoEstacionamiento =
            "   ╔══════════════════════╗\n" +
                    "   ║                      ║\n" +
                    "   ║   ESTACIONAMIENTO    ║\n" +
                    "   ║                      ║\n" +
                    "   ╚══════════════════════╝\n";

    private String graficoMarchePreso =
            "   ╔══════════════════════╗\n" +
                    "   ║                      ║\n" +
                    "   ║     MARCHE PRESO     ║\n" +
                    "   ║                      ║\n" +
                    "   ╚══════════════════════╝\n";



    private String graficoSalida =
            "   ╔══════════════════════╗\n" +
                    "   ║                      ║\n" +
                    "   ║        SALIDA        ║\n" +
                    "   ║                      ║\n" +
                    "   ╚══════════════════════╝\n";


    //grafico de cartel de informe de precio




    private String graficoComisaria="   ,   /\\   ,\n" +
            "  / '-'  '-' \\\n" +
            "  |  POLICÍA  |\n" +
            "  |   .--.   |\n" +
            "  |  ( 19 )  |\n" +
            "  \\   '--'   /\n" +
            "   '--.  .--'\n" +
            "       \\/";


    private String graficoDivisor="-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-=x=-";


    //metodo del grafico de cartel de informe de precio




    public String mostrarGraficoDados(int resultadoDado1, int resultadoDado2){
        String resultado = graficoDados + "\nEl resultado del dado 1 es: "+resultadoDado1+"\nResultado del dado 2 es: "+resultadoDado2;
        return resultado;
    }




    //-----------------------------------------------------------------------------

//    public void mostrarTerminarPartida(String nombre, int dinero, List<IPropiedad> propiedadesJugador) {
//        // Crear una línea divisoria
//        String lineaDivisoria = "  ╔═══════════════════════════════════╗";
//
//        // Crear el encabezado del reporte
//        String encabezado = String.format(
//                "  ║       REPORTE FINAL DE PARTIDA    ║\n" +
//                        "  ╠═══════════════════════════════════╣\n" +
//                        "  ║ Jugador: %-22s ║\n" +
//                        "  ║ Dinero: $%-21d ║\n" +
//                        "  ╠═══════════════════════════════════╣",
//                nombre, dinero
//        );
//
//        // Crear la lista de propiedades
//        StringBuilder propiedades = new StringBuilder();
//        for (IPropiedad propiedad : propiedadesJugador) {
//            propiedades.append(String.format("  ║ Propiedad: %-21s ║\n", propiedad.getDescripcion()));
//        }
//
//        // Si no tiene propiedades, añadir una línea correspondiente
//        if (propiedades.length() == 0) {
//            propiedades.append("  ║ Propiedades: Ninguna              ║\n");
//        }
//
//        // Crear el pie del reporte
//        String pie = "  ╚═══════════════════════════════════╝";
//
//        // Unir todas las partes y mostrar el reporte
//        System.out.println(lineaDivisoria);
//        System.out.println(encabezado);
//        System.out.print(propiedades);
//        System.out.println(pie);
//    }






}

