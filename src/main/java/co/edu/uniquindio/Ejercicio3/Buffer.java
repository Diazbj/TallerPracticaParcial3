package co.edu.uniquindio.Ejercicio3;


public class Buffer {
    private char[] buffer = new char[12];
    private int siguiente = 0;
    private boolean estaLleno = false;
    private boolean estaVacio = true;

    public synchronized void lanzar(char c) {
        while (estaLleno) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        buffer[siguiente] = c;
        siguiente++;

        if (siguiente == 12) {
            estaLleno = true;
        }
        estaVacio = false;
        notifyAll();
    }

    public synchronized char[] recoger() {
        while (estaVacio) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        char[] letras = new char[2];
        if (siguiente >= 2) {
            letras[0] = buffer[siguiente - 2];
            letras[1] = buffer[siguiente - 1];
            siguiente -= 2;
        } else if (siguiente == 1) {
            letras[0] = buffer[siguiente - 1];
            siguiente -= 1;
        }

        if (siguiente == 0) {
            estaVacio = true;
        }
        estaLleno = false;
        notifyAll();

        return letras;
    }
}