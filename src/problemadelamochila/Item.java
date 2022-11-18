package problemadelamochila;

import java.lang.*;

public class Item implements Comparable<Item> {

    public String name;
    public double weight;
    public double value;
    public double valuePerWeight;

    public Item(String name,double weight, double value) {
        this.name = name;
        this.weight = weight;
        this.value = value;

        try {
            this.valuePerWeight = this.value / this.weight;
        } catch (Exception e) {
            this.valuePerWeight = -1;
        }
    }

    // Constructor para pruebas
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

    // Definimos el ordenamiento natural de esta clase
    
    @Override
    public int compareTo(Item i) {
        return Double.compare(this.valuePerWeight, i.valuePerWeight);
    }

    @Override
    public String toString() {
        return "Item{" + "name=" + name + ", weight=" + weight + ", value=" + value + ", valuePerWeight=" + valuePerWeight + '}';
    }

   
    
}
