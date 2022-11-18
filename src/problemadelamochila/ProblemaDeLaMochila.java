package problemadelamochila;

import java.util.Collections;
import java.util.*;

/**
 * Para la solución al problema de la mochila (0/1 Kanpsack) usando ramificación
 * y poda, y teniendo en cuenta que los pesos y beneficios no son números
 * enteros, se toma como base de solución el código fuente del siguiente enlace:
 * https://www.geeksforgeeks.org/implementation-of-0-1-knapsack-using-branch-and-bound/?ref=rp
 *
 * Se supone que los objetos a añadir a la mochila NO SON DIVISIBLES y sólo hay
 * un objeto disponible por cada tipo para insertar.
 */
public class ProblemaDeLaMochila {

    public static double knapsack(int W, List<Item> arr, int n) {

        // Ordenamos la listade items descendientemente basado en
        // el beneficio por unidad de peso
        Collections.sort(arr, Comparator.reverseOrder());

        // Impresión de la lista ordenada
//        for (Item i : arr) {
//            System.out.println(i.toString());
//        }
        // Cola para pasar por los  nodos
        Queue<Node> Q = new LinkedList<>();
        Node u = new Node();
        Node v = new Node();

        // Se comienza con un Nodo arbitrario para iniciar el algoritmo
        u.level = -1;
        u.profit = 0;
        u.weight = 0;
        Q.offer(u); // Push u

        // Extracción de un item del arbol de decisión implícito
        // Calcculamos el beneficio de todos los hijos del Item extraído
        // ademas de mantener actualizando maxProfit
        double maxProfit = 0;
        while (!Q.isEmpty()) {

            u = Q.peek();
            Q.poll();

            // Si es el nodo inicial, asignamos el nivel 0.
            if (u.level == -1) {
                v.level = 0;
            }

            // Si no hay nada en el próximo nivel
            if (u.level == n - 1) {
                continue;
            }

            // Si no es el ultimo nodo, incrementar un nivel y 
            // calcular el beneficio de los nodos hijos.
            v.level = u.level + 1;

            // Tomamos el valor actual del Item, agregamos el valor del peso del nivel
            // actual y el valor al peso y beneficio del nodo u.
            v.weight = u.weight + arr.get(v.level).weight;
            v.profit = u.profit + arr.get(v.level).value;

            // Si el peso acumulado es menor que W y el beneficio es 
            // mayor que los valores de beneficio previos, actualizamos maxProfit
            if (v.weight <= W && v.profit > maxProfit) {
                maxProfit = v.profit;
                Item aux = arr.get(v.level);
                System.out.printf("\n Item: %s; Valor: %.2f; Peso %.2f\n", aux.name, aux.value, aux.weight);
            }

            // Obtenemos la cota superior sobre el beneficio para decidir si 
            // encolamos v a Q o no.
            v.bound = Node.calculateBound(u, n, W, arr);
            if (v.bound > maxProfit) {
                Q.offer(v);
            }

        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int W = 10; // Capacidad mochila

        List<Item> arr = new ArrayList<>();
        arr.add(new Item("Lápiz", 0.5, 5));
        arr.add(new Item("Paraguas", 2, 12));
        arr.add(new Item("Chocolatina", 0.3, 4));
        arr.add(new Item("Cuadernos", 1, 6));
        arr.add(new Item("Aguardiente", 1, 5));
        arr.add(new Item("Vodka", 1.5, 6.5));
        arr.add(new Item("Tequila", 1.8, 8));
        arr.add(new Item("Computador", 3, 15));
        arr.add(new Item("Desodorante", 0.5, 5));
        arr.add(new Item("Cepillo", 0.3, 2));
        arr.add(new Item("Manzanas", 1, 4));
        arr.add(new Item("Bananos", 2, 7));

        // Recorriendo la lista para verificar elementos
//        for (Item i : arr) {
//            System.out.println(i.toString());
//        }
//        System.out.println("");
        int n = arr.size();

        double value = knapsack(W, arr, n);
        System.out.printf("\nValor máximo de beneficio posible: %.2f\n ", value);

        // Ejemplo de array de items para pruebas. Valor máximo es 235
        // https://www.geeksforgeeks.org/implementation-of-0-1-knapsack-using-branch-and-bound/?ref=rp
        List<Item> arr2 = new ArrayList<>();
        arr2.add(new Item(2, 40));
        arr2.add(new Item(3.14, 50));
        arr2.add(new Item(1.98, 100));
        arr2.add(new Item(5, 95));
        arr2.add(new Item(3, 30));

        //double value2 = knapsack(10, arr2, 5);
        //System.out.println(value2);
    }

}
