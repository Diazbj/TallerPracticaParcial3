package co.edu.uniquindio.Ejercicio4;



import co.edu.uniquindio.Ejercicio4.Utils.Persistencia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ejecucion extends Thread {

    public static void main(String[] args) {
        // Definir el array de caracteres
//        char[] caracteres = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'ñ', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z','B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'P', 'Q', 'R', 'S', 'T', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'e', 'i', 'o', 'u', '@','#','-', '*', '$','(',')','/', '%', '+', ':',';','_'};
        char[] caracteres = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'ñ', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'e', 'i', 'o', 'u', '@','#','/', '%', '+',':',';','_'};

        // Crear el buffer y la cola de caracteres objetivo
        Buffer buffer = new Buffer();
        Queue<Character> caracteresObjetivo = new LinkedList<>();
        String palabraObjetivo = "progr@macion_3#2023%";
//        String palabraObjetivo = "prog";
        for (char c : palabraObjetivo.toCharArray()) {
            caracteresObjetivo.add(c);
        }

        // Lista para letras no utilizadas
        List<Character> letrasNoUsadas = new ArrayList<>();

        // Crear productores y consumidor con el array de caracteres
        P4 p4 = new P4(buffer, caracteres, caracteresObjetivo);
        P3 p3 = new P3(buffer, caracteres, caracteresObjetivo);
        P2 p2 = new P2(buffer, caracteres, caracteresObjetivo);
        P1 p1 = new P1(buffer, caracteres, caracteresObjetivo);
        Consumidor consumidor = new Consumidor(buffer, letrasNoUsadas, palabraObjetivo);

        // Iniciar hilos
        p4.start();
        p3.start();
        p2.start();
        p1.start();
        consumidor.start();

        // Esperar a que todos los hilos terminen
        try {
            consumidor.join();
            p4.join();
            p3.join();
            p2.join();
            p1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Detener la producción del consumidor
        consumidor.detenerProduccion();

        // Mostrar resultados
        System.out.println("Palabra formada: " + consumidor.getPalabraFormada());
        System.out.println("Letras no utilizadas: " + letrasNoUsadas);
        Persistencia.guardarLetrasSobrantes(letrasNoUsadas);

    }
}