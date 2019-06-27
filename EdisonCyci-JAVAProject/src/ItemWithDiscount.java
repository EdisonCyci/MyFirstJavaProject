/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mira
 */
public class ItemWithDiscount extends Item
{
    private double discount;
    
    public ItemWithDiscount(String name, double price,double discount)
    {
        super(name,price);
        
        setDiscount(discount);
    
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if(discount>0&&discount<0.5)
        this.discount = discount;
        else
            this.discount = 0.1;
    }
    
    @Override 
    public String print()
    {
       return getName()+" "+getPrice()+ " "+getDiscount()+"\n";
    }
    
}
