package co.edu.uniquindio;


public class Ejecucion {

    public static void main( String args[] ) {
        Tuberia t = new Tuberia();
        Productor p = new Productor( t );
        Consumidor c = new Consumidor( t );
        p.start();
        c.start();
    }
}
