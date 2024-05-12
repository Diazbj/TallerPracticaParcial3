package co.edu.uniquindio.Ejercicio4;

import java.util.Queue;

public class P4 extends Thread {
    private Buffer buffer;
    private char[] caracteres;
    private Queue<Character> caracteresObjetivo;

    public P4(Buffer buffer, char[] caracteres, Queue<Character> caracteresObjetivo) {
        this.buffer = buffer;
        this.caracteres = caracteres;
        this.caracteresObjetivo = caracteresObjetivo;
    }

    @Override
    public void run() {
        int index = 0;
        while (true) {
            char caracter = caracteres[index % caracteres.length];
            if (esVocal(caracter)) {
                buffer.lanzar(caracter);
                System.out.println("Productor de vocales ha lanzado: " + caracter);
            }
            index++;
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para verificar si un caracter es una vocal
    public static boolean esVocal(char c) {
        // Verificar si el carácter es una vocal en minúscula
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        // Verificar si el carácter es una vocal en mayúscula
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        // Si no es ninguna de las anteriores, no es una vocal
        return false;
    }
}