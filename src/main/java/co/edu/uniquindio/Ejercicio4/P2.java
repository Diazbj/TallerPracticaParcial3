package co.edu.uniquindio.Ejercicio4;

import java.util.Queue;

public class P2 extends Thread {
    private Buffer buffer;
    private char[] caracteres;
    private Queue<Character> caracteresObjetivo;

    public P2(Buffer buffer, char[] caracteres, Queue<Character> caracteresObjetivo) {
        this.buffer = buffer;
        this.caracteres = caracteres;
        this.caracteresObjetivo = caracteresObjetivo;
    }

    @Override
    public void run() {
        int index = 0;
        while (true) {
            char caracter = caracteres[index % caracteres.length];
            if (esDigito(caracter)) {
                buffer.lanzar(caracter);
                System.out.println("Productor de numeros ha lanzado: " + caracter);
            }
            index++;
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para verificar si un caracter es numero
    public static boolean esDigito(char c) {
        // Verificar si el carácter es numero
        if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
            return true;
        }
        return false;
    }
}