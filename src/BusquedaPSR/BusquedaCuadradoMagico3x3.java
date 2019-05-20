package BusquedaPSR;

import dominio.CuadradoMagico;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

/**
 *
 * @author ordenador
 */
public class BusquedaCuadradoMagico3x3 {

    protected static final int dimension = 3;
    protected CuadradoMagico cuadrado;
    protected int limite;
    protected int max;

    /**
     * 
     * @param limite 
     */
    public BusquedaCuadradoMagico3x3(int limite) {
        cuadrado = new CuadradoMagico(3);
        this.limite = limite;
        this.max = 0;
    }

    /**
     * Estrategia de búsqueda en acción
     * @return 
     */
    public CuadradoMagico busqueda() {
        int casilla;
        int contador;
        while (!cuadrado.estaCompleto()) {
            contador = this.cuadrado.completitud();
            casilla = this.asignar(contador);
            if (casilla > 0) {
                cuadrado.add(casilla, contador);
                if (contador >= this.max) {
                    this.max = contador;
//                        System.out.println(cuadrado);
                }
            } else {
                this.max = 0;
                cuadrado = new CuadradoMagico(3);
            }
        }

        return cuadrado;
    }

    /**
     * Asignar valores según las restricciones
     * @param contador
     * @return 
     */
    protected int asignar(int contador) {
        int var = 0;
        int var2 = 0;
        switch (contador) {
            case 0:
                var = this.getRandom(1, this.limite);
                break;
            case 1:
                var = this.getRandom(1, limite - this.cuadrado.getCasilla(0, 0));
            case 2:
                var = this.getRandom(1, limite - (this.cuadrado.sumaFila(0) - 1));
                break;
            case 3:
                var = this.getRandom(1, this.cuadrado.sumaFila(0) - this.cuadrado.getCasilla(0, 0));
                break;
            case 4:
                var = this.getRandom(1, this.cuadrado.sumaFila(0)
                        - Math.max(Math.max(this.cuadrado.getCasilla(0, 0),
                                this.cuadrado.getCasilla(1, 0)), this.cuadrado.getCasilla(0, 1)));
                break;
            case 5:
                var = this.cuadrado.sumaFila(0) - this.cuadrado.sumaFila(1);
                break;
            case 6:
                var = this.cuadrado.sumaFila(0) - this.cuadrado.sumaColumna(0);
                var2 = this.cuadrado.sumaFila(0) - this.cuadrado.sumaDiagonal2();
                if (var != var2) {
                    var = -1;
                }
                break;
            case 7:
                var = this.cuadrado.sumaFila(0) - this.cuadrado.sumaColumna(1);
                break;
            case 8:
                var = this.cuadrado.sumaFila(0) - this.cuadrado.sumaColumna(2);
                var2 = this.cuadrado.sumaFila(0) - this.cuadrado.sumaDiagonal1();
                if (var != var2) {
                    var = -1;
                }

                break;
        }
        return var;
    }


    /**
     * Obtiene un número aleatorio entre dos valores dados
     * @param init
     * @param limite
     * @return
     */
    protected int getRandom(int init, int limite) {

        int res = 0;
        if (init < limite) {
            SecureRandom rand = new SecureRandom();
            res = rand.ints(init, limite).findAny().getAsInt();
        } else {
            res = -1;
        }
        return res;
    }

}
