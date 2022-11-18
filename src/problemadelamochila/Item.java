package problemadelamochila;

import java.lang.*;
import java.util.*;

public class Item implements Comparable<Item> {

    private double weight;
    private double value;
    private double valuePerWeight;

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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getValuePerWeight() {
        return valuePerWeight;
    }

    public void setValuePerWeight(double valuePerWeight) {
        this.valuePerWeight = valuePerWeight;
    }

    public static boolean cmp(Item a, Item b) {
        double r1 = (double) a.value / a.weight;
        double r2 = (double) b.value / b.weight;
        return r1 > r2;
    }

    public int compareTo(Item i) {
        return Double.compare(this.valuePerWeight, i.valuePerWeight);
    }

    static class ColorComparator implements Comparator<Item> {

        public int compare(Item a, Item b) {
            return a.compareTo(b);
        }
    }
}
