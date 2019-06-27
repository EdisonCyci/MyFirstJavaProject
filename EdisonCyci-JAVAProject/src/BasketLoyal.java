
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edison
 */
public class BasketLoyal extends Basket 
{
    private int points;

    public BasketLoyal(double vat, Date dateAndTime, String nameOfCashier, String adress, int points) 
    {
        super(vat, dateAndTime, nameOfCashier, adress);
        setPoints();
    }

    public int getPoints() {
        return points;
    }

    public void setPoints() 
    {
        int i=(int)super.getTotalAmmount();
        this.points=i/5;
      
    }
    
    @Override
    public String print()
    {
     return "Net worth: "+getNetAmmount()+"\nTotal Ammount: "+getTotalAmmount()
             +"\nCustomer Points"+getPoints()
             +"\nVAT: "+getVat()+"\nCreation Time: "+getDateAndTime()+"\nCasshier Name: "
             +getNameOfCashier()+"\nAddress: "+getAdress()
             +"\nList of items: \n"+getList();
    }
    
    
    
    
}
