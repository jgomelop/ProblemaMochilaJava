package problemadelamochila;

import java.lang.*;
import java.util.Collections;
import java.util.*;

/**
 *
 * @author jpgl2
 */
public class ProblemaDeLaMochila {

    public static double knapsack (int W, List<Item> arr, int n){
        // Sorting Item on basis of value per unit
        // weight
        Collections.sort(arr, Comparator.reverseOrder());
        // Printing values to check arr sorting.
        for (Item i : arr) {
            System.out.println(i.toString());
        }
        
        // Make a queue for traversing the node
        Queue<Node> Q = new LinkedList<>();
        Node u = new Node();
        Node v = new Node();
        
        // Dummy node at starting
        u.level = -1;
        u.profit = 0;
        u.weight = 0;
        Q.offer(u); // push u
        
        // One by one extract an item from decision tree
        // compute profit of all children of extracted item
        // and keep saving maxProfit
        double maxProfit = 0;
        while (!Q.isEmpty()){
            // Dequeue a node
            u = Q.peek();
            Q.poll();
            
            // If it is strating node, assign level 0
            if ( u.level == -1){
                v.level = 0;
            }
            
            // If there is nothing on next level
            if (u.level == n-1){
                continue;
            }
            
            // Else if not last node, then increment level
            // and compute profit of children nodes.
            v.level = u.level + 1;
            
            // Taking current level's item add current
            // level's weight and value to node u's
            // weight and value
            v.weight = u.weight + arr.get(v.level).weight;
            v.profit = u.profit + arr.get(v.level).value;
            
            // IF cumulated weight is less than W and
            // profit is greater than previous profit,
            // update maxProfit
            if (v.weight <= W && v.profit > maxProfit){
                maxProfit = v.profit;
                System.out.println(arr.get(v.level).value);
            }
            
            // Get the upper bound  on profit to decide
            // whether to add v to Q or not.
            v.bound = Node.calculateBound(u, n, W, arr);
            if (v.bound > maxProfit){
                Q.offer(v);
            }
            
        }

        return maxProfit;
    }
            
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int W = 10; // Capacidad mochila

        List<Item> arr = new ArrayList<>();
        arr.add(new Item(0.5, 5));
        arr.add(new Item(2, 12));
        arr.add(new Item(0.3, 4));
        arr.add(new Item(1,6));
        arr.add(new Item(1,5));
        arr.add(new Item(1.5,6.5));
        arr.add(new Item(1.8,8));
        arr.add(new Item(3,15));
        arr.add(new Item(0.5,5));
        arr.add(new Item(0.3,2));
        arr.add(new Item(1,4));
        arr.add(new Item(2,7));
        
        // Recorriendo la lista para verificar elementos
        for (Item i : arr) {
            System.out.println(i.toString());
        }
        System.out.println("");
        
        int n = arr.size();

        double value = knapsack(W, arr, n);
        System.out.printf("\nValor máximo: %f\n ",value);

        // Array for testing purposes. Valor máximo es 254
        List<Item> arr2 = new ArrayList<>();
        arr2.add(new Item(2,40));
        arr2.add(new Item(3.14,50));
        arr2.add(new Item(1.98,100));
        arr2.add(new Item(5,95));
        arr2.add(new Item(3,30));

        //double value2 = knapsack(10, arr2, 5);
        //System.out.println(value2);
    }

}
