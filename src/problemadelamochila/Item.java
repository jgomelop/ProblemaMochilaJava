package problemadelamochila;

import java.lang.*;
import java.util.*;

public class Item implements Comparable<Item> {

    public double weight;
    public double value;
    public double valuePerWeight;

    public Item(double weight, double value) {
        this.weight = weight;
        this.value = value;

        try {
            this.valuePerWeight = this.value / this.weight;
        } catch (Exception e) {
            this.valuePerWeight = -1;
        }
    }

    public Item() {
    }


    public static boolean cmp(Item a, Item b) {
        double r1 = (double) a.value / a.weight;
        double r2 = (double) b.value / b.weight;
        return r1 > r2;
    }

    public int compareTo(Item i) {
        return Double.compare(this.valuePerWeight, i.valuePerWeight);
    }

    static class valuePerWeightComparator implements Comparator<Item> {

        public int compare(Item a, Item b) {
            return a.compareTo(b);
        }
    }

    @Override
    public String toString() {
        return "Item{" + "weight=" + weight + ", value=" + value + ", valuePerWeight=" + valuePerWeight + '}';
    }
   
    
}
