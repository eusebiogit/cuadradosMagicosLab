package dominio;

import java.util.ArrayList;

/**
 *
 * @author ordenador
 */
public class CuadradoMagico {

    private int dimension;
    private int tablero[][];

    /**
     * Crear cuadrado vacío
     *
     * @param dimension
     */
    public CuadradoMagico(int dimension) {
        this.dimension = dimension;
        this.tablero = new int[dimension][dimension];
    }

    /**
     * Crear cuadrado mágico completo
     *
     * @param tablero
     */
    public CuadradoMagico(int tablero[][]) {
        this.dimension = tablero.length;
        this.tablero = tablero;
    }

    /**
     * Comprueba que el cuadrado está o no completo
     *
     * @return
     */
    public boolean estaCompleto() {
        boolean completo = true;
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension && completo; j++) {
                completo &= this.tablero[i][j] != 0;
            }
        }
        return completo;
    }

    public int getLimite() {
        int limite = 0;
        int fila[] = this.getFila(0);
        for (int i = 0; i < this.dimension && fila[this.dimension - 1] != 0; i++) {
            limite += fila[i];
        }
        return limite;
    }

    /**
     * @return
     */
    public int getDimension() {
        return dimension;
    }

    public int CuadradoDeCuadrados() {
        int cuadrados = 0;
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                if (this.cuadradoEntero(this.tablero[i][j])) {
                    cuadrados++;
                }
            }
        }
        return cuadrados;
    }

    private boolean cuadradoEntero(int n) {
        int raiz = (int) Math.sqrt(n);
        return raiz * raiz == n;
    }

    /**
     * Devuelve verdadero si el cuadrado es mágico:filas, columnas y diagonales
     * suman igual y no se repiten números
     *
     * @return
     */
    public boolean esCorrecto() {
        boolean correcto = false;
        if (this.estaCompleto()) {
            int sum = this.sumaDiagonal1();
            correcto = this.sumaDiagonal2() == sum;
            correcto &= this.estaCompleto();
            for (int i = 0; correcto && i < this.dimension; i++) {
                correcto = this.sumaFila(i) == sum;
                correcto &= this.sumaColumna(i) == sum;
            }
        }
        return correcto;
    }

    /**
     * Suma la fila seleccionada
     *
     * @param fila
     * @return
     */
    public int sumaFila(int fila) {
        int sum = 0;
        int valor = 0;
        for (int i = 0; i < this.dimension; i++) {
            valor = this.tablero[fila][i];
            sum = sum + valor;
        }

        return sum;
    }

    /**
     * Suma la columna seleccionada
     *
     * @param columna
     * @return
     */
    public int sumaColumna(int columna) {
        int sum = 0;
        for (int i = 0; i < this.dimension; i++) {
            sum += this.tablero[i][columna];
        }
        return sum;
    }

    /**
     * Suma la diagonal empezando arriba derecha
     *
     * @return
     */
    public int sumaDiagonal1() {
        int sum = 0;
        int indice;
        for (int i = 0; i < this.dimension; i++) {
            indice = this.tablero[i][i];
            sum += indice;

        }
        return sum;
    }

    /**
     * Suma la diagonal de empezando abajo izquierda
     *
     * @return
     */
    public int sumaDiagonal2() {
        int sum = 0;
        for (int i = 0, j = this.dimension - 1; i < this.dimension; i++, j--) {
            sum += this.tablero[i][j];
        }
        return sum;
    }

    /**
     * Coloca un valor en las coordenadas indicadas
     *
     * @param i
     * @param j
     * @param valor
     */
    public void putCasilla(int i, int j, int valor) {
        this.tablero[i][j] = valor;
    }

    /**
     * Devuelve el valor de las coordenadas indicadas
     *
     * @param i
     * @param j
     * @return
     */
    public int getCasilla(int i, int j) {
        return this.tablero[i][j];
    }

    /**
     * Devuelve una fila
     *
     * @param fila
     * @return
     */
    public int[] getFila(int fila) {
        return this.tablero[fila];
    }

    public boolean esVacio() {
        return this.tablero[0][0] == 0;
    }

    /**
     * Devuelve una columna
     *
     * @param col
     * @return
     */
    public int[] getColumna(int col) {
        int[] columna = new int[this.dimension];
        for (int i = 0; i < this.dimension; i++) {
            columna[i] = this.tablero[i][col];
        }
        return columna;
    }

    /**
     * Introduce un valor en la última posición
     *
     * @param valor
     */
    public void add(int valor, int contador) {
        if (!this.estaCompleto()) {
            this.putCasilla(contador / this.dimension, contador % this.dimension, valor);
        }
    }

    public void quitar(int contador) {
        for (int i = this.dimension * this.dimension - 1; i >= contador; i--) {
            this.putCasilla(i / this.dimension, i % this.dimension, 0);
        }
    }

    /**
     *
     * @return
     */
    public int completitud() {
        int contador = 0;
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                if (this.tablero[i][j] != 0) {
                    contador++;
                }
            }
        }
        return contador;
    }

    @Override
    public int hashCode() {
        String res = "";
        for (int i = 0; i < this.tablero.length; i++) {
            for (int j = 0; j < this.tablero.length; j++) {
                res += this.tablero[i][j];
            }
        }
        return (int) res.hashCode();
    }

    /**
     * Devuelve un texto con una representación del cuadrado mágico
     *
     * @return
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                s += this.tablero[i][j] + "  ";
            }
            s += "\n\n";
        }
        return s;
    }

}
