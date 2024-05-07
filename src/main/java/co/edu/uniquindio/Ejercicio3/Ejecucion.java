package co.edu.uniquindio.Ejercicio3;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ejecucion extends Thread {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Queue<Character> caracteresObjetivo = new LinkedList<>();
        String palabraObjetivo = "uniquindio2023";
        for (char c : palabraObjetivo.toCharArray()) {
            caracteresObjetivo.add(c);
        }

        List<Character> letrasNoUsadas = new ArrayList<>();
        ProductorVocales productorVocales = new ProductorVocales(buffer, caracteresObjetivo);
        ProductorConsonantes productorConsonantes = new ProductorConsonantes(buffer, caracteresObjetivo);
        ProductorNumeros productorNumeros = new ProductorNumeros(buffer, caracteresObjetivo);
        Consumidor consumidor = new Consumidor(buffer, letrasNoUsadas, palabraObjetivo);
        productorVocales.start();
        productorConsonantes.start();
        productorNumeros.start();
        consumidor.start();

        try {
            consumidor.join();
            productorVocales.join();
            productorConsonantes.join();
            productorNumeros.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        consumidor.detenerProduccion();


        System.out.println("Palabra formada: " + consumidor.getPalabraFormada());
        System.out.println("Letras no utilizadas: " + letrasNoUsadas);
    }
}
