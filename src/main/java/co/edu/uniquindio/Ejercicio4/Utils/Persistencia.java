package co.edu.uniquindio.Ejercicio4.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Persistencia {
    private static final String RUTA_ARCHIVO_LETRAS = "src/main/java/resources/Respaldo/LetrasSobrantes.txt";

    public static void guardarLetrasSobrantes(List<Character> letrasSobrantes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA_ARCHIVO_LETRAS))) {
            StringBuilder sb = new StringBuilder();
            for (char letra : letrasSobrantes) {
                sb.append(letra).append(", "); // Agregar la letra seguida de una coma y un espacio
            }
            // Eliminar la última coma y espacio si hay letras sobrantes
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 2);
            }
            // Escribir las letras sobrantes en el archivo
            writer.write(sb.toString());
            System.out.println("Lista de letras sobrantes guardada en " + RUTA_ARCHIVO_LETRAS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}