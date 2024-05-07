package co.edu.uniquindio.Ejercicio1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Consumidor extends Thread {
    private final BufferArchivo buffer;
    private final String palabra;
    private int contador = 0;

    public Consumidor(String palabra, BufferArchivo buffer) {
        this.palabra = palabra;
        this.buffer = buffer;
    }

    public int getContador() {
        return contador;
    }

    @Override
    public void run() {
        try {
            while (true) {
                File archivo = buffer.obtenerArchivo();
                if (archivo == null) {
                    break; // Salir del bucle si no hay mas archivos en el buffer
                }
                if (contienePalabra(archivo, palabra)) {
                    contador++;
                }
            }
            System.out.println("Cantidad de archivos que contienen la palabra '" + palabra + "': " + contador);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private boolean contienePalabra(File archivo, String palabraClave) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            StringBuilder contenido = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n"); // Concatenar todas las líneas del archivo
            }
            // Buscar la palabra en el contenido completo del archivo
            return contenido.toString().contains(palabraClave);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
