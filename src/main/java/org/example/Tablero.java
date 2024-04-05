package org.example;

import java.awt.*;

public class Tablero {
    private static final Color GREEN = Color.GREEN;
    private static final Color BLUE = Color.BLUE;
    int filas=6;
    int columnas=7;
    boolean hayGanador=false;
    private final char[][] table;

    public Tablero(){
        table = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                table[i][j] ='_';
            }
        }
    }

    public void mostrarTablero() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                // Verifica el contenido de la celda para determinar el color
                Color color;
                if (table[i][j] == 'X') {
                    color = GREEN;
                } else if (table[i][j] == 'O') {
                    color = BLUE;
                } else {
                    color = Color.WHITE; // Otros caracteres en blanco
                }
                // Imprime el carácter con el color correspondiente
                System.out.print(colorToHex(color) + table[i][j] + "\u001B[0m" + "   ");
            }
            System.out.println();
        }
        // Mostrar las coordenadas de las columnas
        System.out.println("1   2   3   4   5   6   7");
    }

    public boolean colocarFicha(int columna, char ficha) {
        columna--; // Ajustar la columna a partir de 0
        for (int i = filas - 1; i >= 0; i--) {
            if (table[i][columna] == '_') {
                table[i][columna] = ficha;
                return true;
            }
        }
        return false; // Columna llena
    }

    private String colorToHex(Color color) {
        return String.format("\u001B[38;2;%d;%d;%dm", color.getRed(), color.getGreen(), color.getBlue());
    }
}
