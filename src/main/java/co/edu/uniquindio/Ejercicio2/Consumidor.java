package co.edu.uniquindio.Ejercicio2;

public class Consumidor extends Thread {
    private Tuberia tuberia;

    public Consumidor( Tuberia t )
    {
        // Mantiene una copia propia del objeto compartido
        tuberia = t;
    }

    public void run() {
        char c1;
        char c2;

        // Consume 10 letras de la tuber�a
        for( int i=0; i < 10; i++ )
        {
            c1 = tuberia.recoger();
            c2 = tuberia.recoger();
            // Imprime las letras retiradas
            System.out.println( "Recogido el caracter "+c1+" y el caracter " +c2);
            // Espera un poco antes de coger m�s letras
            try
            {
                sleep( (int)(Math.random() * 3000 ) );
            }
            catch( InterruptedException e )
            {
                ;
            }
        }
    }
}
