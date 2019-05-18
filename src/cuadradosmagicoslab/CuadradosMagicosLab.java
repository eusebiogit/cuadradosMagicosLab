package cuadradosmagicoslab;

import dominio.BusquedaCuadradoMagico3x3;
import dominio.CuadradoMagico;

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

        BusquedaCuadradoMagico3x3 busqueda=new BusquedaCuadradoMagico3x3(10000000);
        CuadradoMagico cuadrado=busqueda.busqueda();
        int cuadrados=cuadrado.CuadradoDeCuadrados();
        if(cuadrados==9){
            System.out.println("Es cuadrado de cuadrados");
        }
        System.out.println(cuadrado);
        System.out.println("Cuadrados: "+cuadrados);
    }

}
