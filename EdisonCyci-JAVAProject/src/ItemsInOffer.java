/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edison
 */
public class ItemsInOffer extends Item 
{
    private int first;
    private int seccond;
    private int ratio;
    
    public ItemsInOffer(String name, double price,int first,int seccond,int ratio)
    {
    super(name,price);
    setFirst(first);
    setSeccond(seccond);
    setRatio(ratio);
    
    } 

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSeccond() {
        return seccond;
    }

    public void setSeccond(int seccond) {
        this.seccond = (int) Math.floor((getFirst()/getRatio()));
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(int ratio) {
        if(ratio>0)
        this.ratio = ratio;
        else
            this.ratio=0;
    }
    
    @Override
    public String print()
    {
       return getName()+" "+getPrice()+ " you bought "+getFirst()+ " and you pay " +getSeccond() + "\n";
    }
    
}
