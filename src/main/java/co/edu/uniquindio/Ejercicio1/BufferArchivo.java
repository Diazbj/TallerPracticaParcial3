package co.edu.uniquindio.Ejercicio1;

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class BufferArchivo {

    private final Queue<File> buffer = new LinkedList<>();

    public synchronized void agregarArchivo(File archivo) {
        buffer.add(archivo);
        notify(); // Notificar a los consumidores que hay archivos disponibles
    }

    public synchronized File obtenerArchivo() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait(); // Esperar si no hay archivos disponibles
        }
        return buffer.poll();
    }
}
