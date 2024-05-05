package co.edu.uniquindio.Ejercicio2;

import java.util.ArrayList;
import java.util.List;

class Productor extends Thread {
    private Tuberia tuberia;
    private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private List<Character> letrasLanzadas;

    public Productor( Tuberia t )
    {
        // Mantiene una copia propia del objeto compartido
        tuberia = t;
        letrasLanzadas=new ArrayList<>();
    }

    public void run() {
        char c;

        // Mete 10 letras en la tuber�a
        for( int i=0; i < 15; i++ )
        {
            if (letrasLanzadas.size()>=26){
                break;
            }

            do{
                c = alfabeto.charAt( (int)(Math.random()*26 ) );
            }while (tuberia.contieneLetra(c));

            letrasLanzadas.add(c);

            tuberia.lanzar( c );
            // Imprime un registro con lo a�adido
            System.out.println( "Productor 1 lanzado "+c+" a la tuberia." );
            // Espera un poco antes de a�adir m�s letras
            try
            {
                sleep( (int)(Math.random() * 100 ) );
            }
            catch( InterruptedException e )
            {
                System.out.println(e);;
            }
        }
    }
}