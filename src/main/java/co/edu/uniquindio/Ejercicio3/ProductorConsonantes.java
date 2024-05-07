package co.edu.uniquindio.Ejercicio3;


import java.util.Queue;


public class ProductorConsonantes extends Thread {
    private Buffer buffer;
    private Queue<Character> caracteresObjetivo;
    private char[] consonantes = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', '�', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};

    private boolean detenerProduccion = false;
    public ProductorConsonantes(Buffer buffer, Queue<Character> caracteresObjetivo) {
        this.buffer = buffer;
        this.caracteresObjetivo = caracteresObjetivo;
    }

    public void detenerProduccion() {
        detenerProduccion = true;
    }


    public void run() {
        int index = 0;
        while (true) {
            char consonante = consonantes[index % consonantes.length];
            buffer.lanzar(consonante);
            System.out.println("Productor de Consonantes ha lanzado: " + consonante);
            index++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}