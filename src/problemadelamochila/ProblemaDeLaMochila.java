package problemadelamochila;

import java.lang.*;

/**
 *
 * @author jpgl2
 */
public class ProblemaDeLaMochila {

    public static void cargaMochila(int capacidad, int m, double peso[], double beneficio[], int solucion[]) {
        int n, i, j, aux;
        double tabla[][];
        n = capacidad + 1;
        tabla = new double[m][n];
        for (i = 1; i < n; i++) {
            tabla[0][i] = 0;
        }
        for (i = 1; i < n; i++) {
            tabla[i][0] = 0;
        }
        for (i = 1; i < m; i++) {
            for (j = 1; j < n; j++) {
                if (peso[i] > j) {
                    tabla[i][j] = tabla[i - 1][j];
                    System.out.printf("i: %d, j: %d, tabla: %.2f\n", i, j, tabla[i][j]);
                } else {
                    aux = j - (int) Math.ceil(peso[i]);
                    tabla[i][j] = Math.max(tabla[i - 1][j], tabla[i - 1][aux] + beneficio[i]);
                    System.out.printf("i: %d, j: %d, tabla: %.2f\n", i, j, tabla[i][j]);

                }
            }
        }
        j = n - 1;
        for (i = m - 1; i > 0; i--) {
            if (tabla[i][j] != tabla[i - 1][j]) {
                solucion[i] = 1;
                aux = j - (int) Math.ceil(peso[i]);
                j = j - aux;
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int capacidad = 10;
        int m = 13; // 12 elementos + 1

        // Tabulación de vector de pesos
        double peso[] = new double[m];
        peso[0] = 0;
        peso[1] = 0.5;
        peso[2] = 2;
        peso[3] = 0.3;
        peso[4] = 1;
        peso[5] = 1;
        peso[6] = 1.5;
        peso[7] = 1.8;
        peso[8] = 3;
        peso[9] = 0.5;
        peso[10] = 0.3;
        peso[11] = 1;
        peso[12] = 2;

        double beneficio[] = new double[m];
        beneficio[0] = 0;
        beneficio[1] = 5;
        beneficio[2] = 12;
        beneficio[3] = 4;
        beneficio[4] = 6;
        beneficio[5] = 5;
        beneficio[6] = 6.5;
        beneficio[7] = 8;
        beneficio[8] = 15;
        beneficio[9] = 5;
        beneficio[10] = 2;
        beneficio[11] = 4;
        beneficio[12] = 7;

        int solucion[] = new int[m];
        for (int i = 0; i < m; i++) {
            solucion[i] = 0;
        }

        cargaMochila(capacidad, m, peso, beneficio, solucion);

        // Imprimo solución
        for (int i = 1; i < m; i++) {
            if (solucion[i] == 1) {
                System.out.println(i);
            }

        }

    }

}
