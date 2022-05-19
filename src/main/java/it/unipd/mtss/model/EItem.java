////////////////////////////////////////////////////////////////////
// Davide Baggio 2009989
// Sanson Sebastiano 2011880
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

public class EItem {
    public enum item{Processor, Motherboard, Mouse, Keyboard};

    private item itemType;
    private String name;
    private double price;

    public EItem(item itemType, String name, double price){
        this.itemType = itemType;
        this.name = name;

        // check if price is positive
        if(price < 0) {
            throw new IllegalArgumentException("Price must be a positive number");
        }
        this.price = price;
    }

    public item getItemType(){
        return itemType;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }
}