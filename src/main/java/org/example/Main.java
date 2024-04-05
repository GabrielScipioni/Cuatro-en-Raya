package org.example;

import java.util.Scanner;

public class Main {
    // Define las variables de color
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Tablero tab = new Tablero();
        Scanner scan = new Scanner(System.in);

        tab.mostrarTablero();
        int turno = 1;
        while (!tab.hayGanador) {
            char ficha = (turno % 2 != 0) ? 'X' : 'O';
            System.out.println("Turno del jugador " + ficha + ". Ingrese una coordenada:");
            int cord = scan.nextInt();
            if (cord >= 1 && cord <= 7) {
                if (!tab.colocarFicha(cord, ficha)) {
                    // Imprimir advertencia en rojo
                    System.out.println(ANSI_RED + "¡Columna llena! Elige otra." + ANSI_RESET);
                    continue;
                }
                tab.mostrarTablero();
                turno++;
            } else {
                // Imprimir advertencia en rojo
                System.out.println(ANSI_RED + "¡Coordenada inválida! Debe ser un número entre 1 y 7." + ANSI_RESET);
            }
        }
    }
}
