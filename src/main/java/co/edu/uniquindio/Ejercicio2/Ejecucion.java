package co.edu.uniquindio.Ejercicio2;


public class Ejecucion {

    public static void main( String args[] ) {
        Tuberia t = new Tuberia();
        Productor p = new Productor( t );
        Productor2 p2 = new Productor2( t );
        Consumidor c = new Consumidor( t );
        p.start();
        p2.start();
        c.start();
    }
}
