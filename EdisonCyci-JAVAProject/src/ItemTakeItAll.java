/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edison
 */
public class ItemTakeItAll extends ItemWithDiscount 
{
    private int Number;
    public ItemTakeItAll(String name, double price, double discount,int number) 
    {
        super(name, price, discount);
        setNumber(number);
        
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        if(Number>0)
        this.Number = Number;
    }
    
    @Override 
    public String print()
    {
       return getName()+" "+getPrice()+" "+ getNumber() +"\n";
    }
    
    
    
}
