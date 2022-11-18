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
        arr.add(new Item(0.5, 5));
        arr.add(new Item(2, 13));
        arr.add(new Item(0.3, 4));
        
        // Using enhanced for loop(for-each) for iteration
        for (Item i : arr) {
            System.out.println(i.toString());
        }
        System.out.println("");
        Collections.sort(arr, Comparator.reverseOrder());
        
        
        // Using enhanced for loop(for-each) for iteration
        for (Item i : arr) {
            System.out.println(i.toString());
        }
        
        List<Item> arr2 = new ArrayList<>();
        arr2.add(new Item(2,40));
        arr2.add(new Item(3.14,50));
        arr2.add(new Item(1.98,100));
        arr2.add(new Item(5,95));
        arr2.add(new Item(3,30));


        double value = knapsack(10, arr2, 5);
        System.out.println(value);
    }

}
