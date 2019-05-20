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

    public BusquedaCuadradoMagico3x3Cuadrados(int init, int limite) {
        super(limite);
        this.init = init;
        this.numerosCuadrados = new ArrayList<Integer>();
        this.crearNumerosCuadrados();
    }

    public BusquedaCuadradoMagico3x3Cuadrados(int limite) {
        this(1, limite);
    }

    private void crearNumerosCuadrados() {
        for (int i = this.init; i < super.limite; i++) {
            this.numerosCuadrados.add(i * i);
        }
    }

    @Override
    protected int getRandom(int init, int limite) {
        SecureRandom rand = new SecureRandom();
        int res = -1;
        res = rand.ints(init, this.numerosCuadrados.size()).findAny().getAsInt();
        res = this.numerosCuadrados.get(res);
        return res;
    }

}
