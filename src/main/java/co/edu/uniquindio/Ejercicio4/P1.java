package co.edu.uniquindio.Ejercicio4;

import java.util.Queue;
import java.util.Random;

public class P1 extends Thread {
    private Buffer buffer;
    private char[] caracteres;
    private Queue<Character> caracteresObjetivo;

    public P1(Buffer buffer, char[] caracteres, Queue<Character> caracteresObjetivo) {
        this.buffer = buffer;
        this.caracteres = caracteres;
        this.caracteresObjetivo = caracteresObjetivo;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int index = 0;
        while (true) {
            char caracter = caracteres[rand.nextInt(caracteres.length)];
            if (esCaracter(caracter)) {
                buffer.lanzar(caracter);
                System.out.println("Productor de caracteres especiales ha lanzado: " + caracter);
            }
            index++;
            try {
                Thread.sleep(350);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para verificar si un caracter es una vocal
    public static boolean esCaracter(char c) {
        // Verificar si el carácter es una caracter especial.
        if (c == '@' || c == '#' || c == '-' || c == '*' || c == '$' || c == '(' || c == ')' || c == '/' || c == '%' || c == '+'||c==':'||c==';') {
            return true;
        }
        return false;
    }
}