/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problemadelamochila;

/**
 *
 * @author jpgl2
 */
public class Item implements Comparable{
    public double weight;
    public double value;

    public Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }

    public Item() {
    }

    public static boolean cmp(Item a, Item b) {
        double r1 = (double) a.value / a.weight;
        double r2 = (double) b.value / b.weight;
        return r1 > r2;
    }
    @Override
    public int compareTo(Object o) {
        Item b = (Item) o;
        double r1 = (double) this.value / this.weight;
        double r2 = (double) b.value / b.weight;
        
        if (r1 > r2){
            return 0;
        } else{
            return 1;
        }
        
    }
    
}
