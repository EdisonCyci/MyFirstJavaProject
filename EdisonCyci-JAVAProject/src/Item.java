
import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab
 */
public class Item implements Serializable
{
   private static int counter;
   private String Name; 
   private int ID;
   private double Price;
    public Item(String name, double price)
    {
        ID=counter++;
        Name=name;
        if(price<0)
            Price=0.0;
        else
            Price=price;
        
    }

    
    public void setName(String name) {
        Name = name;
    }

    public void setID(int id) {
        ID = id;
    }

    public void setPrice(double price) {
        Price = price;
    }
    
    

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return Price;
    }

    public int getID() {
        return ID;
    }
    
    public String print()
    {
       return getName()+" "+getPrice()+"\n";
    }
    
    
    
}
