package co.edu.uniquindio.Ejercicio1;

import java.io.File;

public class Main  extends Thread {
    public static void main(String[] args) {
        File directorio = new File("src/main/java/resources"); // Cambiar por la ruta del directorio deseado

        BufferArchivo buffer = new BufferArchivo();
        ProductorCasa productorCasa = new ProductorCasa(directorio, buffer);
        ProductorAzul productorAzul = new ProductorAzul(directorio, buffer);

        productorCasa.start(); // Iniciar el productor para "casa"
        productorAzul.start(); // Iniciar el productor para "azul"

        try {
            productorCasa.join(); // Esperar a que termine el productor para "casa"
            productorAzul.join(); // Esperar a que termine el productor para "azul"
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
