package BusquedaPSR;

import BusquedaPSR.BusquedaCuadradoMagico3x3;
import java.security.SecureRandom;
import java.util.ArrayList;

/**
 *
 * @author ordenador
 */
public class BusquedaCuadradoMagico3x3Cuadrados extends BusquedaCuadradoMagico3x3 {

    protected ArrayList<Integer> numerosCuadrados;
    protected int init;

    /**
     * 
     * @param init
     * @param limite 
     */
    public BusquedaCuadradoMagico3x3Cuadrados(int init, int limite) {
        super(limite);
        this.init = init;
        this.numerosCuadrados = new ArrayList<Integer>();
        this.crearNumerosCuadrados();
    }

    /**
     * 
     * @param limite 
     */
    public BusquedaCuadradoMagico3x3Cuadrados(int limite) {
        this(1, limite);
    }

    /**
     * Inicializa el array con todos los números que tienen raíces cuadradas
     * exactas
     */
    private void crearNumerosCuadrados() {
        for (int i = this.init; i < super.limite; i++) {
            this.numerosCuadrados.add(i * i);
        }
    }

    /**
     * Obtiene del array números con raíces cuadradas exactas de forma aleatoria
     * @param init
     * @param limite
     * @return 
     */
    @Override
    protected int getRandom(int init, int limite) {
        SecureRandom rand = new SecureRandom();
        int res = -1;
        res = rand.ints(0, this.numerosCuadrados.size()).findAny().getAsInt();
        res = this.numerosCuadrados.get(res);
        return res;
    }

}
