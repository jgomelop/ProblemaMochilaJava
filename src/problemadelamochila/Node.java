/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problemadelamochila;

import java.util.*;
import java.lang.*;
/**
 *
 * @author jpgl2
 */
public class Node {

    public int level;
    public double profit, bound,weight;

    public Node(int level, double profit, double bound, double weight) {
        this.level = level;
        this.profit = profit;
        this.bound = bound;
        this.weight = weight;
    }
    
    public Node() {
    }

    // Returns bound of profit in subtree rooted with u.
    // This function mainly uses Greedy solution to find
    // an upper bound on maximum profit.
    public static double calculateBound(Node u, int n, int W, List<Item> arr) {
        // if weight overcomes the knapsack capacity, return
        // 0 as expected bound
        if (u.weight >= W) {
            return 0;
        }
        
        // initialize bound on profit by current profit
        double profit_bound = u.profit;
        

        // Start including items from index 1 more to current
        // item index
        int j = u.level + 1;
        double total_weight = u.weight;
        
        // checking index condition and knapsack capacity
        // condition
        while( (j<n) && (total_weight + arr.get(j).weight <= W)){
            total_weight += arr.get(j).weight;
            profit_bound += arr.get(j).value;
            j++;
        }
        
        // If k is not n, include last item partially for 
        // upper bound on profit
        
        if (j < n){
            profit_bound += (W - total_weight)* arr.get(j).valuePerWeight;
        }
        
        return profit_bound;
        
    }
    
}
