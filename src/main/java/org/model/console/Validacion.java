package org.model.console;

import org.model.player.Jugador;
import org.services.IPropiedad;

import java.util.List;
import java.util.Scanner;

public class Validacion {
    private static final String ERROR_NUMERO_VALIDO = "Debes ingresar 1 para SI o 2 para NO.";
    private static final String ERROR_OPCION_VALIDO = "Debes ingresar 1, 2 o 3.";
    private static final int MONTO_MIN = 100000;
    private static final int MONTO_MAX = 999999;

    private static Scanner scanner;

    public Validacion() {
        scanner = new Scanner(System.in);
    }

    public int pedirNumeroValido(String input) {
        int numero;
        while (true) {
            try {
                numero = Integer.parseInt(input);
                if (numero == 1 || numero == 2) {
                    break;
                } else {
                    System.out.println(ERROR_NUMERO_VALIDO);
                    input = scanner.nextLine();
                }
            } catch (NumberFormatException e) {
                System.out.println(ERROR_NUMERO_VALIDO);
                input = scanner.nextLine();
            }
        }
        return numero;
    }

    public int pedirMontoValido(int input){
        boolean inputValido = false;
        while (!inputValido) {
            if (input >= MONTO_MIN && input <= MONTO_MAX) {
                inputValido = true;
            }else {
                System.out.println("Debe ingresar un numero entre 100000 y 999999");
                input = scanner.nextInt();
            }
        }
        return input;
    }

    public int pedirNumeroValido3Opciones(String entrada, Scanner scanner) {
        try {
            int opcion = Integer.parseInt(entrada);
            if (opcion >= 1 && opcion <= 3) {
                return opcion;
            } else {
                System.out.println("Por favor, ingrese una opción válida (1-3).");
                return pedirNumeroValido3Opciones(scanner.nextLine(), scanner);
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese un número válido (1-3).");
            return pedirNumeroValido3Opciones(scanner.nextLine(), scanner);
        }
    }



    public char pedirLetraValida(char letra) {
        while (true) {
            if (letra == 'B' || letra == 'D' || letra == 'S') {
                break;
            } else {
                System.out.println("Debes ingresar B, D o S.");
                letra = scanner.next().charAt(0);
            }
        }
        return letra;
    }

    public int pedirIndexValido(List<IPropiedad> propiedades, int index) {
        boolean inputValido = false;
        while(!inputValido){
            if (index <= propiedades.size()) {
                inputValido = true;
            }else{
                System.out.println("Debe ingresar un número entre 0 y "+propiedades.size());
                index = scanner.nextInt();
            }
        }
        return index;
    }

//    public boolean validarSaldoCuenta(Jugador jugador, IPropiedad propiedad){
//        boolean resultado = false;
//
//        int saldoJugador = jugador.getDinero();
//        int costoPropiedad = propiedad.getValor();
//
//        if (saldoJugador >= costoPropiedad) {
//            resultado = true;
//        }
//        return resultado;
//    }

}
