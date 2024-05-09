package co.edu.uniquindio.Ejercicio4;

import java.util.Queue;

public class P3 extends Thread {
    private Buffer buffer;
    private char[] caracteres;
    private Queue<Character> caracteresObjetivo;

    public P3(Buffer buffer, char[] caracteres, Queue<Character> caracteresObjetivo) {
        this.buffer = buffer;
        this.caracteres = caracteres;
        this.caracteresObjetivo = caracteresObjetivo;
    }

    @Override
    public void run() {
        int index = 0;
        while (true) {
            char caracter = caracteres[index % caracteres.length];
            if (esConsonante(caracter)) {
                buffer.lanzar(caracter);
                System.out.println("Productor de consonantes ha lanzado: " + caracter);
            }
            index++;
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para verificar si un caracter es una vocal
    private boolean esConsonante(char c) {
        return !P4.esVocal(c)&&!P2.esDigito(c)&&!P1.esCaracter(c);
    }
}