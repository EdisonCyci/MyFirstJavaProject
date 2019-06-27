
import java.io.Serializable;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Edison
 */
public class Cashier extends User implements Payable , Serializable
{
   private int internalPhoneNumber;
   private int hoursOfWork;
   private double baseHourlySalary;
   public Date logintime;
   private double bonus;
   public Cashier(String Name, String SurName, String UserName, String Password,
     String Type, int ID, String Adress, int PhoneNumber, int InternalPhoneNumber,
           int HoursOfWork,double BaseHourlySalary) 
   {
        super(Name, SurName, UserName, Password, Type, ID, Adress, PhoneNumber);
        setInternalPhoneNumber(InternalPhoneNumber);
        setBaseHourlySalary(BaseHourlySalary);
   }

    public int getHoursOfWork() {
        return hoursOfWork;
    }

    public void setHoursOfWork(int hoursOfWork) {
        this.hoursOfWork = hoursOfWork;
    }

    public double getBaseHourlySalary() {
        return baseHourlySalary;
    }

    public void setBaseHourlySalary(double baseHourlySalary) {
        if(baseHourlySalary>8.0)
        this.baseHourlySalary = baseHourlySalary;
    }
   
    public void calculateBonus(){
    double bonus=0;
    if(hoursOfWork>8)
        bonus=(hoursOfWork-8)*10;
    this.bonus+= bonus;
    
    }

    public int getInternalPhoneNumber() {
        return internalPhoneNumber;
    }

    public void setInternalPhoneNumber(int internalPhoneNumber) {
        if(internalPhoneNumber>0)
        this.internalPhoneNumber = internalPhoneNumber;
    }
   @Override
   public String print(){
        return getUserName()+" "+getPassword();
    }

    @Override
    public double payment() {
     return getHoursOfWork()*getBaseHourlySalary()+bonus;
    }
    
    
}
