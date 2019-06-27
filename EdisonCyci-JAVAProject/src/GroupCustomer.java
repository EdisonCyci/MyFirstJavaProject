/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edison
 */
public class GroupCustomer extends Customer
{
    private int groupPoints;
    public GroupCustomer(String Name, String SurName, String UserName, 
    String Password, String Type, int ID, String Adress, int PhoneNumber, int GroupPoints)
    {
        super(Name, SurName, UserName, Password, Type, ID, Adress, PhoneNumber);
        setGroupPoints(GroupPoints);
        
    }

    public int getGroupPoints() {
        return groupPoints;
    }

    public void setGroupPoints(int gp) {
        this.groupPoints+=gp;
        
    }
    
    
}
