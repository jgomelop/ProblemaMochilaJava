package problemadelamochila;

import java.lang.*;
import java.util.Collections;
import java.util.*;

/**
 *
 * @author jpgl2
 */
public class ProblemaDeLaMochila {

    // Comparison function to sort Item according to
    // val/weight ratio
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
        
        List<Item> arr = new ArrayList<>();
        arr.add(new Item(0.5,5));
        arr.add(new Item(2,13));
        arr.add(new Item(0.3,4));
        
        Collections.sort(arr, new Item.ColorComparator());
        

    }

}
