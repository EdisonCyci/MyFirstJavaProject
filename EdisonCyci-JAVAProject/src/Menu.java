/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Lab
 */
public class Menu 
{
    
    
          
    static int i=0;

    static ArrayList <User> list1 = new ArrayList();
    static ArrayList <Item> ItemList= new ArrayList();
    static ArrayList <Basket> blist=new ArrayList();
    static ArrayList <Customer> clist=new ArrayList();
    static ArrayList <User> Logged=new ArrayList();
    static String Adresa="Rruga E kombit, Tirane";
    private static ObjectOutputStream output;
    private static ObjectInputStream Input;
    public static void openfile() throws FileNotFoundException, IOException
    {
       output = new ObjectOutputStream(new FileOutputStream("Store.ser"));
    }
    
    public static void writefile() throws IOException
    {
         output.writeObject(blist);
         output.writeObject(Logged);
         output.writeObject(clist);
    }
    
    public static void closefile() throws IOException
    {
        if(output!=null)
            output.close();
    }
    
    public static void main(String[]args) throws ParseException, FileNotFoundException, IOException, ClassNotFoundException
    {
        Scanner input= new Scanner(System.in);
        fillLists();
        int c;
        login();

        do {
            System.out.println("Enter a choise");
            menu();
            c=input.nextInt();

        switch (c) 
        {
            case 0:
            {
                openfile();
                writefile();
                closefile();
            }
            case 1:  
            {
                newBasket();
                do
                {
                System.out.println("Press 1 to add items, 2 to remove, 3 to print"
                        + "basketinfo and 4 to process points and 5 exit.");
                c=input.nextInt();
                switch(c)
                {                   
                    case 1:
                    {
                     addItem();
                     System.out.println("What do you wish to do now?");
                    
                      
                     break;
                    }
                    case 2:
                    {
                     removeItem();
                     System.out.println("What do you wish to do now?");
                     
                     
                     break;
                    }
                    case 3:
                    {
                    System.out.println(blist.get(blist.size()-1).print());
                    System.out.println("What do you wish to do now?");
                   
                      
                    break;
                    }
                    case 4:
                    {
                    processPoints();
                    System.out.println("What do you wish to do now?");
                    
                      
                    break;
                    }
                    case 5:
                    {
                    break;
                    }
                    default: System.out.println("Incorrect choice :)");
                }
                }while(c!=5);
                     break;
            }
            case 2:{TotalAmountByBasketType();
                    break;}
                
            case 3:{TotalPointsByCustomerType();
                    break;}
                
            case 4:{TotalAmountByItemType();
                    break;}
            
            case 5:
            {
                System.out.println("The total ammount of vat accumulate for today is"+totalVat());
                
                    break;
            }
            
            case 6: { printBasketInfo();
                     break;}
            case 7: { System.out.println("The processed basket total amount is: "
                    +blist.get(blist.size()-1).getTotalAmmount());
                    blist.get(blist.size()-1).ApplyDiscount();
                    System.out.println("After the discount by 10% is applied the new ammount is : "
                    +blist.get(blist.size()-1).getTotalAmmount());
                     break;}         
            case 8: { 
                if(list1.get(i).getType().equals("Manager")){
                    System.out.println("Enter the username: ");
                        String user=input.next();
                        System.out.println("The total number of baskets is: "+numberOfBaskets(user));
                        }
                else System.out.println("Incorrect choice :)");
                break;
            }
            case 9: { 
                if(list1.get(i).getType().equals("Manager")){
                    System.out.println("Enter the username: ");
                        String user=input.next();
                        System.out.println("The total ammount is: "+TotalAmountByUsername(user));
                        }
                else System.out.println("Incorrect choice :)");
                break;
            }
            case 10: { 
                if(list1.get(i).getType().equals("Manager")){
                   System.out.println("The total ammount is: "+theMoneyToday());
                   }
                else System.out.println("Incorrect choice :)");
                break;
            }
            case 11:
            {
                logout();
                login();
                break; 
            }
            case 12:
            { 
                login();
                break; 
            }
            case 13:
            {
                logout();
                login();
                break; 
            }
            case 14:
            { 
                logout();
                login();
                break; 
            }
                
            case 15:
            {
                openFileRead();
                ReadFileData();
                closeFileRead();
                
            }
                
            case 16:
            {
                openfile();
                writefile();
                closefile();
                System.exit(0);
                break;
            }
                
            default: System.out.println("Incorrect choice :)");
        }
        }while (c!=15);
         
       }
    
    
    public static int numberOfBaskets(String Username){
        int n=0;
        for(int j=0;j<blist.size();j++)
        {
            if(blist.get(j).getNameOfCashier().equals(Username))
                n++;
        }
        return n;
    }
    public static double TotalAmountByUsername(String Username){
        double theMoney=0;
        for(int j=0;j<blist.size();j++)
        {
            if(blist.get(j).getNameOfCashier().equals(Username))
                theMoney+=blist.get(j).getTotalAmmount();
        }
        return theMoney;
      }
    
    public static String TotalAmountByBasketType(){
        double theMoney=0;
        double theMoneyLoyal=0;
        double theMoneyEmployeec=0;
        double theMoneyGroup=0;
        for(int j=0;j<blist.size();j++)
        {
            if(blist.get(j)instanceof BasketLoyal)
                theMoneyLoyal+=blist.get(j).getTotalAmmount();
            else if(blist.get(j)instanceof BasketEmployee)
                theMoneyEmployeec+=blist.get(j).getTotalAmmount();
            else if(blist.get(j)instanceof BasketGroup)
                theMoneyGroup+=blist.get(j).getTotalAmmount();
            else 
                theMoney+=blist.get(j).getTotalAmmount();
        }
        return "Total ammount loyalbaskets:"+theMoneyLoyal+"\n"
                +"Total ammount Employeebaskets:"+theMoneyEmployeec+"\n"
                +"Total ammount Groupbaskets:"+theMoneyGroup+"\n"
                +"Total ammount simplebaskets:"+theMoney+"\n";
      }
    
    public static String TotalAmountByItemType(){
        int normalItem=0;
        int itemTakeItall=0;
        int itemDiscount=0;
        int itemOffer=0;
        int itemPartyindependance=0;
        for(int j=0;j<blist.size();j++)
        {
            ArrayList <Item> iteml = new ArrayList();
            iteml=blist.get(j).GetItemList();
            for(int h=0;h<iteml.size();h++)
            {                
            if(iteml.get(h) instanceof ItemWithDiscount)
                itemDiscount++;
            else if(iteml.get(h) instanceof ItemTakeItAll)
                itemTakeItall++;
            else if(iteml.get(h) instanceof ItemPartyIdependence)
               itemPartyindependance++;
            else if(iteml.get(h) instanceof ItemsInOffer)
               itemOffer++;
            else 
               normalItem++;
            }
        }
        return "Total ammount ItemWithDiscounta:"+itemDiscount+"\n"
                +"Total ammount itemTakeItall:"+itemTakeItall+"\n"
                +"Total ammount itemOffer:"+itemOffer+"\n"
                +"Total ammount itemPartyindependance:"+itemPartyindependance+"\n"
                +"Total ammount normalItem:"+normalItem+"\n";
      }
    
    public static String TotalPointsByCustomerType(){
        double thePointsLoyal=0;
        double thePointsEmployeec=0;
        double thePointsGroup=0;
        for(int j=0;j<clist.size();j++)
        {
            if(clist.get(j)instanceof LoyalCustomer)
                thePointsLoyal+=clist.get(j).getPoints();
            else if(clist.get(j)instanceof CustomerEmployee)
                thePointsEmployeec+=clist.get(j).getPoints();
            else if(clist.get(j)instanceof GroupCustomer)
                thePointsGroup+=clist.get(j).getPoints();
            
        }
        return "Total ammount loyalpoints:"+thePointsLoyal+"\n"
                +"Total ammount Employeepoints:"+thePointsEmployeec+"\n"
                +"Total ammount Grouppoints:"+thePointsGroup+"\n";
                
      }
    
    public static double theMoneyToday() throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");      
        Date today = format.parse(format.format(new Date()));
        double theMoney=0;
        for(int j=0;j<blist.size();j++)
        {
            if(blist.get(j).getDateAndTime().compareTo(today)==0)
                theMoney+=blist.get(j).getTotalAmmount();
        }
        return theMoney;
    }
    
    public static void newBasket() throws ParseException
    {
    Scanner in = new Scanner(System.in);
    int type;
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
    Date dt=format.parse(format.format(new Date()));
    try
    {
    do
    {
    System.out.println("What type of basket is it?");
    System.out.println("Type 1 for Loyal,2 for Employee"
            + "3 for group,4 for simple ");
    
    type=in.nextInt();
    if(type==1)
    blist.add(new BasketLoyal(1.2,dt,list1.get(i).getName(),Adresa,0));
    else if(type==2)
    blist.add(new BasketEmployee(1.2,dt,list1.get(i).getName(),Adresa,0));
    else if(type==3)
    blist.add(new BasketGroup(1.2,dt,list1.get(i).getName(),Adresa,0));
    else if(type==4)
    blist.add(new Basket(1.2,dt,list1.get(i).getName(),Adresa));
    else
        System.out.println("Incorrect choice, please try again.");
    }while(type<0&&type>5);
    }
    catch(InputMismatchException e)
    {
    System.err.println("Exception?!"+e);
    in.nextLine();
    System.out.println("Incorrect choice, please try to enter numbers this time.");
    }
    }
    
    public Basket getBasket(int i)
    {
        return blist.get(i);
    }
    
    public static void newGuiBasket(int type) throws ParseException
    {
    Scanner in = new Scanner(System.in);
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
    Date dt=format.parse(format.format(new Date()));
    try
    {
    do
    {
    if(type==1)
    blist.add(new BasketLoyal(1.2,dt,list1.get(i).getName(),Adresa,0));
    else if(type==2)
    blist.add(new BasketEmployee(1.2,dt,list1.get(i).getName(),Adresa,0));
    else if(type==3)
    blist.add(new BasketGroup(1.2,dt,list1.get(i).getName(),Adresa,0));
    else if(type==4)
    blist.add(new Basket(1.2,dt,list1.get(i).getName(),Adresa));
    else
        continue;
    }while(type<0&&type>5);
    }
    catch(InputMismatchException e)
    {
    System.err.println("Exception?!"+e);
    in.nextLine();
    System.out.println("Incorrect choice, please try to enter numbers this time.");
    }
    }
    
    public static double totalVat() throws ParseException
    {
        double totalvat=0;
         
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");      
        Date today = format.parse(format.format(new Date()));
        double theMoney=0;
        for(int j=0;j<blist.size();j++)
        {
            if(blist.get(j).getDateAndTime().compareTo(today)==0)
                theMoney+=blist.get(j).getTotalAmmount();           
        }
        totalvat=theMoney*0.2;
        return totalvat;
    }
    
    
    
    public static void addItem(){
        int id;
        Scanner input= new Scanner(System.in);
        System.out.print("Enter ID of the item to be added or -1 to exit; \n");
        for(int j=0;j<ItemList.size();j++)
        {
            System.out.print(j+" "+ItemList.get(j).print());
        }
        try
        {            
        id=input.nextInt();
        if(id>0&&id<ItemList.size())
        {
          blist.get(blist.size()-1).addItem(ItemList.get(id));      
        }
        else
        System.out.println("Incorrect choice please try again.");
        
        
        }
        catch(InputMismatchException e)
        {
        System.err.println("Exception?!"+e);
        input.nextLine();
        System.out.println("Incorrect choice, please try to enter numbers this time.");
        }
        
    }
    
    public static void removeItem(){
        int id;
        Scanner input= new Scanner(System.in);
        System.out.print("Enter ID of the item to be removed; \n");
        
            System.out.print(blist.get(blist.size()-1).getList());
        
        id=input.nextInt();
        blist.get(blist.size()-1).GetItemList().remove(id);
    }
    public static void printBasketInfo()
    {
        int id;
        Scanner input= new Scanner(System.in);
        System.out.print("Enter ID of basket to be displayed. \n");
        for(int j=0; j<blist.size();j++)
        {
            System.out.println(blist.get(j).getId()+" "+blist.get(j).getNameOfCashier());
        }
        id=input.nextInt();
        System.out.println(blist.get(id).print()); 
    }

    public static void menu(){
        System.out.println("0. Save data");
        System.out.println("1. Create new basket");
        if(list1.get(i).getType().equals("Manager"))
        {
        System.out.println("2. Compute the overall amount for each of the types of baskets.");
        System.out.println("3. Compute the overall amount of bonus accumulated for each of the types of customers.");
        System.out.println("4. Compute the overall number of each type of item purchased.");
        System.out.println("5. Compute the overall amount of VAT accumulated on that day.");
        }
        System.out.println("6. Print information for basket with a certain ID");
        System.out.println("7. Apply discount to basket with 10% for Christmas promotion");
        if(list1.get(i).getType().equals("Manager"))
        {
        System.out.println("8. Overall number of baskets for the cashier with a certain username");
        System.out.println("9. Total amount of all baskets processed by the cashier with a certain username");
        System.out.println("10. Total amount of all baskets of the current day");
        }
        System.out.println("11. Change cashier from one to another");
        System.out.println("12. Pass from Cashier to Manager");
        System.out.println("13. Pass from Manager to Cashier");
        System.out.println("14. Logout.");
        System.out.println("15. Load previous data.");
        System.out.println("16. Save and Exit");
        
    }
    
    public static int logout() throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        Date dt=format.parse(format.format(new Date()));
        for(User c:list1){
        if(c instanceof Cashier){
            Cashier b = (Cashier) c;
            b.setHoursOfWork(dt.getHours()-b.logintime.getHours());
            }
        }

        return i;
    }
    
    public static void processPoints()
    {
        int id;
        Scanner input = new Scanner(System.in);
        int loop=0;
        do{
        try{
                
        System.out.println("Please enter customer Id or -1 to exit.");
        if(blist.get(blist.size()-1)instanceof BasketLoyal)
            for(int i=0 ;i<blist.size()-1;i++)
            {
            if(clist.get(i).getType().equalsIgnoreCase("LoyalCustomer"))
                System.out.println(clist.get(i).getId()+" "+ clist.get(i).getName());                    
            }
        else if(blist.get(blist.size()-1)instanceof BasketEmployee)
            for(int i=0 ;i<blist.size()-1;i++)
            {
            if(clist.get(i).getType().equalsIgnoreCase("CustomerEmployee"))
                System.out.println(clist.get(i).getId()+" "+ clist.get(i).getName());                    
            }
        else if(blist.get(blist.size()-1)instanceof BasketGroup)
            for(int i=0 ;i<blist.size()-1;i++)
            {
            if(clist.get(i).getType().equalsIgnoreCase("GroupCustomer"))
                System.out.println(clist.get(i).getId()+" "+ clist.get(i).getName());                    
            }
        id=input.nextInt();
        for(Customer currentCustomer : clist)
        {
        if(currentCustomer.getId()==id)
            currentCustomer.setPoints(blist.get(blist.size()-1).getPoints());
        }
        
        
        }
        catch(Exception e)
        {
        e.getMessage();
        }
        }while(loop!=-1);
    }
            
            
            
    
    public static int login(){
        String userName=null;
        String password=null;
        Scanner input= new Scanner(System.in);
        boolean logged=false;

        System.out.println("Please enter username and Password");
        userName=input.next();
        password=input.next();
        do{
    
            //list1.get(i).print();
            if(list1.get(i).getUserName().equals(userName)
                && list1.get(i).getPassword().equals(password))
            {
                logged=true;
                System.out.print("Welcome "+list1.get(i).getName());
                Logged.add(list1.get(i));
            
            }
            if(!logged)
                i++;   
             if(list1.size()<=i){
                i=0;
                System.out.print("Username/Password incorrect!\n");
                System.out.println("Please enter username and Passowrd");
                userName=input.next();
                password=input.next();
                break;
             }
        }
        while(!logged);
       return i;
    }
    
    public static void fillLists()
    {
        list1.add(new Cashier("Etilion","Danoci","Etto","123456","Cashier",001,
                             " Selite ",425438,001,8,8.0));
        list1.add(new Cashier("Elidon","Nevruzi","Qorri","125548","Cashier",002,
                             " Kombinat ",425439,002,8,8.0));
        list1.add(new Cashier("Eduart","Shkalla","Proffesori","1911969","Cashier"
                              ,003," Kombinat ",425440,003,8,8.0));
        list1.add(new Cashier("Maria","Dono","Maria","54b682","Cashier",004,
                              " Kombinat ",425441,004,8,8.0));
        list1.add(new Manager("Edison","Cyci","Cuci","159753","Manager",01,
                              " Blloku ",222555,01,123456));
        
        ItemList.add(new Item("Hammer",10.99));
        ItemList.add(new Item("Yellow Hammer",12.99));
        ItemList.add(new Item("Electric ScrewDriver",45.89));
        ItemList.add(new Item("Portable Driller",85.99));
        ItemList.add(new Item("Nailbox",8.25));
        ItemList.add(new Item("Long Screws(x)100",14.45));
        ItemList.add(new Item("Electric Saw",99.99));
        ItemList.add(new Item("Protective Glasses",14.99));
        ItemList.add(new Item("Welding Mask",25.55));
        ItemList.add(new Item("Protective Gloves",16.66));
        
        clist.add(new CustomerEmployee("Etilion","Danoci","Etto","123456","CustomerEmployee",001,
                             " Selite ",425438));
        clist.add(new CustomerEmployee("Elidon","Nevruzi","Qorri","125548","CustomerEmployee",002,
                             " Kombinat ",425439));
        clist.add(new CustomerEmployee("Eduart","Shkalla","Proffesori","1911969","CustomerEmployee"
                              ,003," Kombinat ",425440));
        clist.add(new CustomerEmployee("Maria","Dono","Maria","54b682","CustomerEmployee",004,
                              " Kombinat ",425441));
        clist.add(new CustomerEmployee("Edison","Cyci","Cuci","159753","CustomerEmployee",005,
                              " Blloku ",222555));
        clist.add(new LoyalCustomer("Artan","Loku","Loku","1597458","LoyalCustomer",010,
                              " Blloku ",222566,0));
        clist.add(new LoyalCustomer("Barjam","Haxhiu","Haxhi","15456213","LoyalCustomer",011,
                              " Blloku ",222577,0));
        clist.add(new LoyalCustomer("Ilirian","Hoxha","Liri","1597458","LoyalCustomer",012,
                              " Blloku ",222588,0));
        clist.add(new LoyalCustomer("Gonxhe","Tartaraj","Gonxhe","1597458","LoyalCustomer",013,
                              " Blloku ",222599,0));
        clist.add(new GroupCustomer("Arian","Lala","Lala","1597458","GroupCustomer",020,
                              " Blloku ",222599,0));
        clist.add(new GroupCustomer("Peter","Rosman","Rosman","1597458","GroupCustomer",021,
                              " Blloku ",222599,0));
        clist.add(new GroupCustomer("Amc","Amc","Amc","1597458","GroupCustomer",022,
                              " Blloku ",222599,0));
        clist.add(new GroupCustomer("Eagle","Eagle","Eagle","1597458","GroupCustomer",023,
                              " Blloku ",222599,0));
    
    }
    
    public static void openFileRead() throws FileNotFoundException, IOException
    {
        Input = new ObjectInputStream(new FileInputStream("Store.ser"));;
    }
    
    
    public static void ReadFileData() throws FileNotFoundException, IOException, ClassNotFoundException
    {
        
        while(true)
        {
         blist = (ArrayList <Basket>) Input.readObject();
         Logged = (ArrayList <User>) Input.readObject();
         clist = (ArrayList <Customer>) Input.readObject();
        }
    }
    
    public static void closeFileRead() throws FileNotFoundException, IOException
    {
        if(Input!=null)
            Input.close();
    }
    
    
    
}     