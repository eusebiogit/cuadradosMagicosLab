package cuadradosmagicoslab;

import BusquedaPSR.BusquedaCuadradoMagico3x3;
import BusquedaPSR.BusquedaCuadradoMagico3x3Cuadrados;
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

        int init,limite;
         if (args.length == 0) {
             init=100;
             limite=8000;
        } else {
                init = Integer.parseInt(args[0]);
                limite = Integer.parseInt(args[1]);
        }
         
        BusquedaCuadradoMagico3x3Cuadrados busqueda=new BusquedaCuadradoMagico3x3Cuadrados(init,limite);
        CuadradoMagico cuadrado=busqueda.busqueda();
        int cuadrados=cuadrado.CuadradoDeCuadrados();
        if(cuadrados==9){
            System.out.println("Es cuadrado de cuadrados");
        }
        System.out.println(cuadrado);
        System.out.println("Cuadrados: "+cuadrados);
    }

}
