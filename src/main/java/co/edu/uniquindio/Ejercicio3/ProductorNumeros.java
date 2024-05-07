package co.edu.uniquindio.Ejercicio3;

import java.util.Queue;

public class ProductorNumeros extends Thread {
    private Buffer buffer;
    private Queue<Character> caracteresObjetivo;
    private boolean detenerProduccion = false;

    public ProductorNumeros(Buffer buffer, Queue<Character> caracteresObjetivo) {
        this.buffer = buffer;
        this.caracteresObjetivo = caracteresObjetivo;
    }
    public void detenerProduccion() {
        detenerProduccion = true;
    }


    public void run() {
        int index = 1;
        while (true) {
            char numero = Character.forDigit(index % 10, 10);
            buffer.lanzar(numero);
            System.out.println("Productor de Numeros ha lanzado: " + numero);
            index++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}