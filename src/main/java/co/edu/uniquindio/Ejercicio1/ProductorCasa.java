package co.edu.uniquindio.Ejercicio1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ProductorCasa  extends Thread {
    private final File directorio;
    private final BufferArchivo buffer;
    private int contador = 0;


    public ProductorCasa(File directorio, BufferArchivo buffer) {
        this.directorio = directorio;
        this.buffer = buffer;
    }


    public void run() {
        buscarYAgregarArchivos("casa");
        //System.out.println("Numero de archivos llamados 'casa': " + contador);

    }


    private void buscarYAgregarArchivos(String palabra) {
        buscarYAgregarArchivosEnDirectorio(directorio, palabra);
    }

    private void buscarYAgregarArchivosEnDirectorio(File dir, String palabra) {
        File[] archivos = dir.listFiles();
        if (archivos != null) {
            for (File archivo : archivos) {
                if (archivo.isDirectory()) {
                    buscarYAgregarArchivosEnDirectorio(archivo, palabra); // Búsqueda recursiva en subdirectorios
                } else {
                    int contador = contarOcurrencias(archivo, palabra);
                    if (contador > 0) {
                        System.out.println("Archivo '" + archivo.getName() + "' contiene la palabra '" + palabra + "': " + contador + " veces");
                        buffer.agregarArchivo(archivo);
                    }
                }
            }
        }
    }

    private int contarOcurrencias(File archivo, String palabra) {
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Contamos todas las ocurrencias de la palabra en la línea
                int lastIndex = 0;
                while (lastIndex != -1) {
                    lastIndex = linea.indexOf(palabra, lastIndex);
                    if (lastIndex != -1) {
                        contador++;
                        lastIndex += palabra.length();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contador;
    }
}