
import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab
 */
public  class User implements Serializable
{
   private  String name;
   private  String surName; 
   private  String userName;
   private  String password;
   private  String type;
   private int id;
   private  String adress;
   private int phoneNumber;

    public User(String Name, String SurName, String UserName, String Password,
            String Type,int ID,String Adress,int PhoneNumber) {
        name = Name;
        surName = SurName;
        userName = UserName;
        password = Password;
        type=Type;
        id=ID;
        adress=Adress;
        phoneNumber=PhoneNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public  void setName(String Name) {
        name= Name;
    }

    public void setSurName(String SurName) {
        surName = SurName;
    }

    public void setUserName(String UserName) {
        userName = UserName;
    }

    public void setPassword(String Password) {
        password = Password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    
    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public  String getUserName() {
        return userName;
    }

    public  String getPassword() {
        return password;
    }
    public String print(){
        return getUserName()+" "+getPassword();
    }

}
