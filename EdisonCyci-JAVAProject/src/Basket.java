
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lab
 */
public class Basket implements Serializable ,Payable
{
    private static int counter;
    private int id;
    private double netAmmount;
    private double totalAmmount;
    private double vat;
    private ArrayList <Item> list;
    private Date dateAndTime;
    private String nameOfCashier;
    private String adress;

    public Basket(double vat, Date dateAndTime, String nameOfCashier, 
            String adress) {
        this.id = counter++;
        this.netAmmount = 0;
        this.totalAmmount = 0;
        this.list=new ArrayList();
        this.vat = vat;
        this.dateAndTime = dateAndTime;
        this.nameOfCashier = nameOfCashier;
        this.adress = adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setList(ArrayList<Item> list) {
        this.list = list;
    }

    public ArrayList <Item> GetItemList(){
    return this.list;
    }
    
    public void setNameOfCashier(String nameOfCashier) {
        this.nameOfCashier = nameOfCashier;
    }

    public void setNetAmmount(double netAmmount) {
        this.netAmmount = netAmmount;
    }

    public void setTotalAmmount(double totalAmmount) {
        this.totalAmmount = totalAmmount;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }
    
   public String getAdress() {
        return adress;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public int getId() {
        return id;
    }
    
    public String getList() {
        String thelist="";
        for(int i=0; i<list.size();i++){
            thelist+=i+" "+list.get(i).print();
        }
        return thelist;
    }

    public String getNameOfCashier() {
        return nameOfCashier;
    }

    public double getNetAmmount() {
        return netAmmount;
    }

    public double getTotalAmmount() {
        return totalAmmount;
    }

    public double getVat() {
        return vat;
    }
    
    public void addItem(Item j){
    
    Item test=j;
    list.add(test);
    setNetAmmount(getNetAmmount()+j.getPrice());
    setTotalAmmount(getTotalAmmount()+j.getPrice()*getVat());
    }
    
    public void removeItem(Item i){
    list.remove(i);
    setNetAmmount(getNetAmmount()-i.getPrice());
    setTotalAmmount(getTotalAmmount()-i.getPrice()*getVat());
    }
    
    public void ApplyDiscount(){
    setTotalAmmount(getTotalAmmount()*0.9);
    }
    
    public String print()
    {
     return "Net worth: "+getNetAmmount()+"\nTotal Ammount: "+getTotalAmmount()
             +"\nVAT: "+getVat()+"\nCreation Time: "+getDateAndTime()+"\nCasshier Name: "
             +getNameOfCashier()+"\nAddress: "+getAdress()
             +"\nList of items: \n"+getList();
    }

    @Override
    public double payment() {
        return getTotalAmmount();
    }

    public int getPoints() {
        return 0;
    }
    
}
