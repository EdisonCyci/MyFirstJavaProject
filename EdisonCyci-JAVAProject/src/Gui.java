

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.*;
import javax.swing.Icon;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Gui extends JFrame
{
  
    private JDesktopPane desktop;
    private JMenuBar bar;   
    private JMenu fileMenu;
    private JMenu helpMenu;
    private JMenuItem newBasket;
    private JMenuItem printBasketId;
    private JMenuItem overallNrOfBaskets;
    private JMenuItem totalAmountOfBaskets;
    private JMenuItem changeUser;
    private JMenuItem closeAndSave;
    private JMenuItem about;
    private ImageIcon market;
    private JInternalFrame frame ;
    private JMenu ExitMenu;
    private JMenuItem SimpleBasket;
    private JMenuItem LoyalBasket;
    private JMenuItem GroupBasket;
    private JMenuItem EmployeeBasket;
    private JLabel user;
    private JLabel pass;
    private JTextField username;
    private JLabel enterUsername;
    private JLabel enterPassword;
    private JPasswordField password;
    private JPanel panel,panel2,panelPicture,panelButton;
    private BorderLayout layout;   
    private JButton LoginButton;
    private JButton CancelButton;
    private String username2;
    private String password2;
   
    Menu database = new Menu();
   
    
    public Gui()
    {  
        super("Mega Market");
        panel=new JPanel();
        panelPicture = new JPanel();
        password = new JPasswordField(10);
        panelButton = new JPanel();
        
        

        
       
        LoginButton = new JButton( "Login");       
        CancelButton= new JButton("Quit");            
        add( LoginButton ); 
                  
        enterUsername = new JLabel("Enter Username");        
        panel.add(enterUsername);
               
        username = new JTextField(10);
        panel.add(username);        
        enterPassword = new JLabel("Enter Password");        
        panel.add(enterPassword);        
        panel.add(password);        
        add( panel, BorderLayout.WEST );
  
        panelButton.setLayout(new GridLayout(2,20,20,20));
       
       panelButton.add(LoginButton);
       panelButton.add(CancelButton);
       add(panelButton,BorderLayout.CENTER);
       
       
        super.setLocation(new Point(400, 170));
        database.fillLists();
         
          
        CancelButton.addActionListener
                (
                new ActionListener()
                {
                    public void actionPerformed( ActionEvent event )
                    {
                        System.exit(0);
                    }
                }
                            
                );
        LoginButton.addActionListener
                (
                new ActionListener()
                {
                    public void actionPerformed( ActionEvent event )
                    { 
                        
                        String user="";
                        String pass ="";
                         user=getName();
                         pass = getPass();
                        
                        boolean logged=false;
                     
             int i=0;
           
             do{
    
             database.list1.get(i).print();
            if(database.list1.get(i).getUserName().equals(user)
                && database.list1.get(i).getPassword().equals(pass)
                    )
            {
                logged=true;
                menu();
               Gui.super.dispose();
            
            }
            if(!logged)
                i++;   
            if(database.list1.size()<=i){
                i=0;
                
             JOptionPane.showMessageDialog(null,("Error Password/Username"),"Login Menu",JOptionPane.ERROR_MESSAGE);
                            username.setText("");
                            password.setText("");
                break;
             }
        }  
        while(!logged);
     }
               }
        
                );
        
        username.addActionListener
                (
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent ev)
                    {
                        {
                     
                    username2 = ev.getActionCommand();
                        }
                    }
                }
                
                );
        password.addActionListener
                (
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent eve)
                    {
                        
                        
                        {
                     
                       password2 = eve.getActionCommand();
                    
                        }
                    }
                }
                
                );
        
}
                
    
    
     public String getName() 
   {
      return username.getText();
   }
   
   public String getPass() 
   {
      return new String(password.getPassword()); 
   }
   
   
public class MenuCashier extends JFrame
{
    
    
    
    public MenuCashier()
    {
        super("Mega Market");
        
         
         bar = new JMenuBar(); 
         fileMenu = new JMenu( "File"); 
         helpMenu = new JMenu( "Help" );
         ExitMenu = new JMenu( "Exit" );
        
         desktop = new JDesktopPane();       
         newBasket = new JMenu("New Basket");
         SimpleBasket = new JMenuItem("Simple Basket");
         LoyalBasket = new JMenuItem("Loyal Basket");
         GroupBasket = new JMenuItem("Group Basket");
         EmployeeBasket = new JMenuItem("Customer Basket");
         printBasketId = new JMenuItem("Print basket ID");
         overallNrOfBaskets = new JMenuItem("Overall Basket");
         totalAmountOfBaskets = new JMenuItem("Total amount of Baskets");
         closeAndSave = new JMenuItem("Close and save");
         changeUser = new JMenuItem("changeUser");
         about = new JMenuItem("About");
         add(desktop);
         setJMenuBar( bar );
         
        
         
        
         fileMenu.setHorizontalTextPosition(SwingConstants.CENTER);
         fileMenu.setVerticalTextPosition(SwingConstants.BOTTOM);
         
         
         helpMenu.setHorizontalTextPosition(SwingConstants.CENTER);
         helpMenu.setVerticalTextPosition(SwingConstants.BOTTOM);
         
         ExitMenu.setHorizontalTextPosition(SwingConstants.CENTER);
         ExitMenu.setVerticalTextPosition(SwingConstants.BOTTOM);
      
        
       
         bar.add(fileMenu);
         bar.add(helpMenu );
         bar.add(ExitMenu );
         
         fileMenu.add(newBasket);
         newBasket.add(SimpleBasket);
         newBasket.add(LoyalBasket);
         newBasket.add(GroupBasket);
         newBasket.add(EmployeeBasket);
         fileMenu.add(overallNrOfBaskets);
         fileMenu.add(printBasketId);
         fileMenu.add(totalAmountOfBaskets);
         helpMenu.add(about);
         ExitMenu.add(closeAndSave);
         
         
         
         closeAndSave.addActionListener
                 (new ActionListener()
                {
                    public void actionPerformed( ActionEvent event )
                    {
                        
                            try {
                                database.openfile();
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                database.writefile();
                            } catch (IOException ex) {
                                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                database.closefile();
                            } catch (IOException ex) {
                                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.exit(0);
                    }
                    }
                 );
         
         
         SimpleBasket.addActionListener
                (
                new ActionListener()
                {
                    public void actionPerformed( ActionEvent event )
                    {
                      int type=4;
                      int i=0;
                    try {
                            database.newGuiBasket(type);
                        } catch (ParseException ex) 
                        {
                            Logger.getLogger(MenuCashier.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  
                   frame = new JInternalFrame("Basket nr "+database.getBasket(database.blist.size()-1).getId(), true, true, true, true );
                  MenuCashier.newBasket panel = new MenuCashier.newBasket();                  
                   frame.add( panel, BorderLayout.NORTH);
                       frame.setSize(600,500);
                       desktop.add( frame ); 
                       frame.setVisible( true );
                                         
                    }
                }
                            
                );
         
         LoyalBasket.addActionListener
                (
                new ActionListener()
                {
                    public void actionPerformed( ActionEvent event )
                    {
                      int type=1;
                      int i=0;
                    try {
                            database.newGuiBasket(type);
                        } catch (ParseException ex) {
                            Logger.getLogger(MenuCashier.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  
                   frame = new JInternalFrame("Basket nr "+database.getBasket(database.blist.size()-1).getId(), true, true, true, true );
                  MenuCashier.newBasket panel = new MenuCashier.newBasket();
                   frame.add( panel, BorderLayout.NORTH);
                       frame.setSize(600,500);
                       desktop.add( frame ); 
                       frame.setVisible( true );
                                         
                    }
                }
                            
                );
         
         GroupBasket.addActionListener
                (
                new ActionListener()
                {
                    public void actionPerformed( ActionEvent event )
                    {
                      int type=3;
                      int i=0;
                    try {
                            database.newGuiBasket(type);
                        } catch (ParseException ex) {
                            Logger.getLogger(MenuCashier.class.getName()).log(Level.SEVERE, null, ex);
                        }

                   frame = new JInternalFrame("Basket nr "+database.getBasket(database.blist.size()-1).getId(), true, true, true, true );
                  MenuCashier.newBasket panel = new MenuCashier.newBasket();
                   frame.add( panel, BorderLayout.NORTH);
                       frame.setSize(600,500);
                       desktop.add( frame ); 
                       frame.setVisible( true );
                                         
                    }
                }
                            
                );
         
         EmployeeBasket.addActionListener
                (
                new ActionListener()
                {
                    public void actionPerformed( ActionEvent event )
                    {
                      int type=2;
                      int i=0;
                    try {
                            database.newGuiBasket(type);
                        } catch (ParseException ex) {
                            Logger.getLogger(MenuCashier.class.getName()).log(Level.SEVERE, null, ex);
                        }
                  
                   frame = new JInternalFrame("Basket nr "+database.getBasket(database.blist.size()-1).getId(), true, true, true, true );
                  MenuCashier.newBasket panel = new MenuCashier.newBasket();
                   frame.add( panel, BorderLayout.NORTH);
                       frame.setSize(600,500);
                       desktop.add( frame ); 
                       frame.setVisible( true );
                                         
                    }
                }
                            
                );
        
          
          
         
          printBasketId.addActionListener(
                   new ActionListener()
                  {
                      public void actionPerformed(ActionEvent event)
                      { 
        
        String firstN= JOptionPane.showInputDialog("enter id");
        
          
                         
                          int id=Integer.parseInt(firstN);
         
               int count=0;
                         // JOptionPane.showMessageDialog(null, "equal"+id);
               
                    
                      
                      if(count ==0)
                      {
                          JOptionPane.showMessageDialog(null, ("ID Basket not found"),"Printing ID",JOptionPane.ERROR_MESSAGE);
                      }
                      }
                      
                       
                  }
                      
                  
                  );
}
    
    class newBasket extends JPanel
  {
      private JButton[] button;
      public newBasket()
      {
         
       BorderLayout layout = new BorderLayout( 1, 1 ); 
       setLayout( layout );
          
       JTabbedPane panes = new JTabbedPane();
       panes.setPreferredSize(new Dimension(600,470));
       JPanel  panel1 = new JPanel();
            
          
       button = new JButton[database.ItemList.size()];
  
           for(int k=0;k<database.ItemList.size();k++)
           {
               panel1.add(button[k]=new JButton(database.ItemList.get(k).getName()),BorderLayout.WEST);  
           }
   
         
         panes.add("Add Items",panel1);

           JPanel  panel2 = new JPanel();
           panes.add("Remove Items",panel2);
           
           JPanel  panel3 = new JPanel();
           panes.add("Points",panel3);
           
           JPanel  panel4 = new JPanel();
           panes.add("Clients type",panel4);
           
            add(panes,BorderLayout.LINE_START);     
      }
      
             public void actionPerformed( ActionEvent event )
      {
          for ( JButton buttons : button )
              if ( event.getSource() == button )
              {
                 database.blist.get(database.blist.size()-1).addItem(database.ItemList.get(event.getID()));
              }    
      }    
  }
    
}


  
   
 public void menu()
 {


        MenuCashier menuCashier = new MenuCashier();
        menuCashier.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuCashier.setSize(800,600);
         
        menuCashier.setLocation(340, 100);
        menuCashier.setVisible(true);
        
      
     
         
      
 }
 
 public JTextField getUsername() {
        return username;
    }

    public void setUsername(JTextField username) {
        this.username = username;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }



}
