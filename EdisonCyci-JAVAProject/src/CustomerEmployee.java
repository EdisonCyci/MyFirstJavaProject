/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edison
 */
public class CustomerEmployee extends Customer
{
    private int emPoints;
    public CustomerEmployee(String Name, String SurName, String UserName,
        String Password, String Type, int ID, String Adress, int PhoneNumber)
    {
        super(Name, SurName, UserName, Password, Type, ID, Adress, PhoneNumber);
    }

    public int getEmPoints() {
        return emPoints;
    }

    public void setEmPoints(int emPoints) {
        this.emPoints+=emPoints;
        
    }
    
    
    
}
