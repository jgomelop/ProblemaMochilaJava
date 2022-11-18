package problemadelamochila;

import java.util.*;

public class Node {

    public int level;
    public double profit, bound, weight;

    public Node(int level, double profit, double bound, double weight) {
        this.level = level;
        this.profit = profit;
        this.bound = bound;
        this.weight = weight;
    }

    public Node() {
    }

    // Retorna la cota de beneficio en el subárbol con raíz u
    // Esta función utiliza una solución ávida(Greedy) para encontrar
    // la cota superior sobre el beneficio máximo
    public static double calculateBound(Node u, int n, int W, List<Item> arr) {

        // Si el peso sobrepasa la capacidad de la mochila, retorna 0
        // como cota esperada
        if (u.weight >= W) {
            return 0;
        }

        // inicializa la cota sobre el beneficio usando el beneficio actual
        double profit_bound = u.profit;

        // Empezamos incluyendo Items desde el índice en una unidad más al índice 
        // del item actual
        int j = u.level + 1;
        double total_weight = u.weight;

        // Verificamos la condición para los índices y la condición para 
        // la capacidad de la mochila
        while ((j < n) && (total_weight + arr.get(j).weight <= W)) {
            total_weight += arr.get(j).weight;
            profit_bound += arr.get(j).value;
            j++;
        }

        // Si j no es n, incluye el último item parcialmente para 
        // la cota superior sobre el beneficio
        if (j < n) {
            profit_bound += (W - total_weight) * arr.get(j).valuePerWeight;
        }

        return profit_bound;

    }

}
