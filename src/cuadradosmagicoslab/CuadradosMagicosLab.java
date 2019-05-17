package cuadradosmagicoslab;

import dominio.CuadradoMagico;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author ordenador
 */
public class CuadradosMagicosLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int datos[][] = {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}};

        CuadradoMagico cuadrado = new CuadradoMagico(3);
//        System.out.println(rellenarCuadrado(cuadrado));
        System.out.println(generarCuadrado(cuadrado));

    }

    public static CuadradoMagico generarCuadrado(CuadradoMagico cuadrado) {
        do {

            for (int i = 0; i < cuadrado.getDimension(); i++) {
                for (int j = 0; j < cuadrado.getDimension(); j++) {
                    cuadrado.putCasilla(i, j, enteroAleatorio());
                }
            }
            
        } while (!cuadrado.esCorrecto());
        return cuadrado;
    }

    public static int r=1;
    public static int s=1;
    public static int enteroAleatorio() {
        Random aleatorio = new Random(System.currentTimeMillis()*r*s);
        r=aleatorio.nextInt(100);
        s=r*r;
        
        return r;
    }

}
