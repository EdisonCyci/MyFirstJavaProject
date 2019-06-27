/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mira
 */
public class ItemPartyIdependence extends ItemWithDiscount
{
    private double DiscountIndependence;
    
    public ItemPartyIdependence(String name, double price,double discount,
            double discountIndependence)
    {
        super(name,price,discount);
        
        setDiscountIndependence(discountIndependence);
    
    }

    public double getDiscountIndependence() {
        return DiscountIndependence;
    }

    public void setDiscountIndependence(double DiscountIndependence) {
        if(DiscountIndependence>0&&DiscountIndependence<0.4)
        this.DiscountIndependence = DiscountIndependence;
    }
    
    @Override 
    public String print()
    {
       return getName()+" "+getPrice()+ " "+getDiscount()+ " " +getDiscountIndependence() +"\n";
    }
    
}
