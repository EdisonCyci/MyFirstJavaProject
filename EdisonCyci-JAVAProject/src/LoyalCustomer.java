/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edison
 */
public class LoyalCustomer extends Customer
{
    private int points;
    public LoyalCustomer(String Name, String SurName, String UserName, String Password,
            String Type, int ID, String Adress, int PhoneNumber, int Points) 
    {
        super(Name, SurName, UserName, Password, Type, ID, Adress, PhoneNumber);
        setPoints(Points);
    }

    @Override
    public double getPoints() {
        return points;
    }

    
    @Override
    public void setPoints(int p) {
        this.points +=p;
    }
     public int getBonus(){
         int bonus=0;
         while(points>=100){
             bonus+=10;
             points-=100;
         }
         return bonus;    
     }
    
}
