package co.edu.uniquindio.Ejercicio3;

import java.util.Queue;

public class ProductorVocales extends Thread {
    private Buffer buffer;
    private Queue<Character> caracteresObjetivo;
    private char[] vocales = {'a', 'e', 'i', 'o', 'u'};
    private boolean detenerProduccion = false;


    public ProductorVocales(Buffer buffer, Queue<Character> caracteresObjetivo) {
        this.buffer = buffer;
        this.caracteresObjetivo = caracteresObjetivo;
    }


    public void detenerProduccion() {
        detenerProduccion = true;
    }

    public void run() {
        int index = 0;
        while (true) {
            char vocal = vocales[index % vocales.length];
            buffer.lanzar(vocal);
            System.out.println("Productor de Vocales ha lanzado: " + vocal);
            index++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}