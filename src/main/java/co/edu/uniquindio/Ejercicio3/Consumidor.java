package co.edu.uniquindio.Ejercicio3;

import java.util.Arrays;
import java.util.List;
public class Consumidor extends Thread {
    private Buffer buffer;
    private List<Character> letrasNoUsadas;
    private String palabraFormada = "";
    private String palabraObjetivo;
    private boolean detenerProduccion = false;

    public Consumidor(Buffer buffer, List<Character> letrasNoUsadas, String palabraObjetivo) {
        this.buffer = buffer;
        this.letrasNoUsadas = letrasNoUsadas;
        this.palabraObjetivo = palabraObjetivo;
    }

    public void detenerProduccion() {
        detenerProduccion = true;
    }


    @Override
    public void run() {
        while (!palabraCompleta() && !detenerProduccion) {
            char[] letras = buffer.recoger();
            System.out.println("Consumidor recogio: " + Arrays.toString(letras));
            for (char letra : letras) {
                if (palabraFormada.length() < palabraObjetivo.length()) {
                    if (esParteDeLaPalabra(letra)) {
                        palabraFormada += letra;
                    } else {
                        letrasNoUsadas.add(letra);
                    }
                }
            }
            System.out.println("Palabra formada hasta ahora: " + palabraFormada);
        }

        System.out.println("Palabra formada final: " + palabraFormada);
        System.out.println("Letras no utilizadas final: " + letrasNoUsadas);
    }

    private boolean palabraCompleta() {
        return palabraFormada.equals(palabraObjetivo);
    }

    private boolean esParteDeLaPalabra(char letra) {
        int indice = palabraFormada.length();
        return indice < palabraObjetivo.length() && palabraObjetivo.charAt(indice) == letra;
    }

    public String getPalabraFormada() {
        return palabraFormada;
    }
}