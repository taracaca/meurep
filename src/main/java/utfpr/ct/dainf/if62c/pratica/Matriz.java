package utfpr.ct.dainf.if62c.pratica;

/**
 * Representa uma matriz de valores {@code double}.
 *
 * @author Wilson Horstmeyer Bogadao <wilson@utfpr.edu.br>
 */
public class Matriz {

    // a matriz representada por esta classe
    private final double[][] mat;

    /**
     * Construtor que aloca a matriz.
     *
     * @param m O número de linhas da matriz.
     * @param n O número de colunas da matriz.
     */
    public Matriz(int m, int n) {
        mat = new double[m][n];
    }

    /**
     * Retorna a matriz representada por esta classe.
     *
     * @return A matriz representada por esta classe
     */
    public double[][] getMatriz() {
        return mat;
    }

    /**
     * Retorna a matriz transposta.
     *
     * @return A matriz transposta.
     */
    public Matriz getTransposta() {
        Matriz t = new Matriz(mat[0].length, mat.length);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                t.mat[j][i] = mat[i][j];
            }
        }
        return t;
    }

    /**
     * Retorna a soma desta matriz com a matriz recebida como argumento.
     *
     * @param m A matriz a ser somada
     * @return A soma das matrizes
     */
    public Matriz soma(Matriz m) {

        Matriz resultado = new Matriz(mat.length, mat[0].length);
        //Varrer todas as linhas
        for (int x = 0; x < mat.length; x++) {
            //Varrer todas as colunas
            for (int y = 0; y < mat[0].length; y++) {
                resultado.mat[x][y] = m.mat[x][y] + mat[x][y];
            }
        }
        return resultado;
    }

    /**
     * Retorna o produto desta matriz com a matriz recebida como argumento.
     *
     * @param m A matriz a ser multiplicada
     * @return O produto das matrizes
     */
    public Matriz prod(Matriz m) {

        Matriz resultado = new Matriz(mat.length, mat[0].length);

        for (int i = 0; i < m.mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                for (int k = 0; k < m.mat[0].length; k++) {
                    resultado.mat[i][j] += (m.mat[i][k] * mat[k][j]);
                }
            }
        }
        return resultado;
    }

    /**
     * Retorna uma representação textual da matriz. Este método não deve ser
     * usado com matrizes muito grandes pois não gerencia adequadamente o
     * tamanho do string e poderia provocar um uso excessivo de recursos.
     *
     * @return Uma representação textual da matriz.
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (double[] linha : mat) {
            s.append("[ ");
            for (double x : linha) {
                s.append(x).append(" ");
            }
            s.append("]");
        }
        return s.toString();
    }

}
