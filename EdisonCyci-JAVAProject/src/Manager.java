
import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edison
 */
public class Manager extends User implements Payable , Serializable
{
private int pin;
private int internalPhoneNumber;
    public Manager(String Name, String SurName, String UserName, String Password,
     String Type, int ID, String Adress, int PhoneNumber, int InternalPhoneNumber
                 ,int PIN) 
    {
        super(Name, SurName, UserName, Password, Type, ID, Adress, PhoneNumber);
        setPin(PIN);
        setInternalPhoneNumber(InternalPhoneNumber);
    }

    public int getInternalPhoneNumber() {
        return internalPhoneNumber;
    }

    public void setInternalPhoneNumber(int internalPhoneNumber) {
        if(internalPhoneNumber>0)
        this.internalPhoneNumber = internalPhoneNumber;
    }
    
    

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        if(pin>0)
        this.pin = pin;
        else
        this.pin = 0001;    
    }

    @Override
    public double payment() {
        return 5000;
    }
    
    
}
