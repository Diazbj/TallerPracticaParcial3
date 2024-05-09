package co.edu.uniquindio.Ejercicio4;


public class Buffer {
    private char[] buffer = new char[10];
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

        if (siguiente == 10) {
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

        char[] letras = new char[3]; // Cambiar el tamaño a 3
        if (siguiente >= 3) { // Verificar si hay al menos 3 caracteres en el buffer
            letras[0] = buffer[siguiente - 3]; // Recoger el tercer carácter desde el final
            letras[1] = buffer[siguiente - 2]; // Recoger el segundo carácter desde el final
            letras[2] = buffer[siguiente - 1]; // Recoger el último carácter
            siguiente -= 3; // Ajustar el índice siguiente
        } else if (siguiente == 2) {
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