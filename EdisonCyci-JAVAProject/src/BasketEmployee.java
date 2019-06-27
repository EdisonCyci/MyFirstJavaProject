
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edison
 */
public class BasketEmployee extends Basket 
{
    private int emPoints;
    public BasketEmployee(double vat, Date dateAndTime, String nameOfCashier,
                                                 String adress, int empoints) 
    {
        super(vat, dateAndTime, nameOfCashier, adress);
        setPoints();
        
    }

     
    public int getPoints() {
        return emPoints;
    }

    public void setPoints() {
        int i=(int)super.getTotalAmmount();
        this.emPoints+=i/15;

    }
    @Override
    public String print()
    {
     return "Net worth: "+getNetAmmount()+"\nTotal Ammount: "+getTotalAmmount()
             +"\nEmployee Points"+getPoints()
             +"\nVAT: "+getVat()+"\nCreation Time: "+getDateAndTime()+"\nCasshier Name: "
             +getNameOfCashier()+"\nAddress: "+getAdress()
             +"\nList of items: \n"+getList();
    }
    
    
}
