package dominio;

import java.util.Vector;

/**
 *
 * @author ordenador
 */
public class CuadradoMagico {

    private int dimension;
    private int contador;
    private int tablero[][];
    private Vector<Integer> repetidos;

    /**
     * Crear cuadrado vacío
     *
     * @param dimension
     */
    public CuadradoMagico(int dimension) {
        this.dimension = dimension;
        this.tablero = new int[dimension][dimension];
        this.contador = 0;
    }

    /**
     * Crear cuadrado mágico completo
     *
     * @param tablero
     */
    public CuadradoMagico(int tablero[][]) {
        this.dimension = tablero.length;
        this.tablero = tablero;
        this.contador = this.dimension * this.dimension - 1;
    }

    /**
     * Introduce un valor en la última posición
     *
     * @param valor
     */
    public void add(int valor) {
        if (!this.estaCompleto()) {
            this.putCasilla(this.contador / this.dimension, valor % this.dimension, valor);
        }
    }

    /**
     * Comprueba que el cuadrado está o no completo
     *
     * @return
     */
    public boolean estaCompleto() {
        return this.contador >= this.dimension * this.dimension - 1;
    }

    /**
     * @return
     */
    public int getDimension() {
        return dimension;
    }

    /**
     * Devuelve verdadero si el cuadrado es mágico:filas, columnas y diagonales
     * suman igual y no se repiten números
     *
     * @return
     */
    public boolean esCorrecto() {
        this.repetidos = new Vector<Integer>();
        int sum = this.sumaDiagonal1();
        boolean correcto = this.sumaDiagonal2() == sum;
        correcto &= this.estaCompleto();
        for (int i = 0; correcto && i < this.dimension; i++) {
            correcto = this.sumaFila(i) == sum;
            correcto &= this.sumaColumna(i) == sum;
        }
        correcto &= this.repetidos.size() == this.dimension * this.dimension;
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
        int valor;
        for (int i = 0; i < this.dimension; i++) {
            valor = this.tablero[fila][i];
            if (!this.comprobarRepetidos(valor)) {
                sum += valor;
            }
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
     * Comprueba que un valor no está repetido, en cuyo caso lo añade
     *
     * @param valor
     * @return
     */
    public boolean comprobarRepetidos(int valor) {
        boolean repetido = true;
        if (!this.repetidos.contains(valor)) {
            this.repetidos.add(valor);
            repetido = false;
        }
        return repetido;
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
    
    public int[] getFila(int fila){
        return this.tablero[fila];
    }
    
    public int[] getColumna(int col){
        int []columna=new int[this.dimension];
        for(int i=0;i<this.dimension;i++){
            columna[i]=this.tablero[i][col];
        }
        return columna;
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
