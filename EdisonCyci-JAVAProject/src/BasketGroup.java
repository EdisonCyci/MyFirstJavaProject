
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edison
 */
public class BasketGroup extends Basket
{
    private int Points;
    public BasketGroup(double vat, Date dateAndTime, String nameOfCashier,
                                String adress,int grouppoints) 
    {
        super(vat, dateAndTime, nameOfCashier, adress);
        setGroupPoints();
    }

    public int getGroupPoints() {
        return Points;
    }

    public void setGroupPoints() {
        int j=(int) super.getTotalAmmount();
        this.Points=j/10;
    }
    @Override
    public String print()
    {
     return "Net worth: "+getNetAmmount()+"\nTotal Ammount: "+getTotalAmmount()
             +"\nGroup Points"+getGroupPoints()
             +"\nVAT: "+getVat()+"\nCreation Time: "+getDateAndTime()+"\nCasshier Name: "
             +getNameOfCashier()+"\nAddress: "+getAdress()
             +"\nList of items: \n"+getList();
    }
    
}
    
    

