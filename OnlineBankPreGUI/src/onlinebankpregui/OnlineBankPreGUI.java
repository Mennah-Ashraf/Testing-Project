package onlinebankpregui;

import java.awt.Desktop;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author floss
 */
public class OnlineBankPreGUI {

    /**
     * @param args the command line arguments
     */
    
    Random r = new Random();
    
    
    static ArrayList <CustomerAccount> Customers;
    static ArrayList <Applications> Applications;
    static ArrayList <CustomerState> CustomerState;
    
    public static void populateArrayList1()
    {
        try
        {
        
            FileInputStream file = new FileInputStream("src\\DataBase\\Cutomers.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
        boolean endOfFile = false;
        
        while (!endOfFile){
            
            try 
            {
              Customers.add((CustomerAccount) inputFile.readObject());
                
            }
            catch (EOFException e)
            {
                endOfFile = true;
            }
            catch (Exception f)
            {
             //JOptionPane.showMessageDialog(null, f.getMessage());
            }
        }
        
        inputFile.close();
        }
        catch (IOException e){
            
            //JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        
    }
    
    public void saveCustomersToFile(){
         
            try 
            {
              FileOutputStream file = new FileOutputStream("src\\DataBase\\Cutomers.dat");
              ObjectOutputStream outputFile = new ObjectOutputStream(file);
                
              
              for (int i=0; i<Customers.size(); i++){
                  
                  outputFile.writeObject(Customers.get(i));
                  
              }
              
              outputFile.close();
              System.out.println( "The Application was succefully submited to one of our Employees");
              System.out.println( "please use the following Application number to check your application status later when employee reviews it");
             
             
              
  
             
            }
        
         catch (IOException e){
            
            //JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
    
    
    public void saveCustomerStateToFile(){
         
            try 
            {
              FileOutputStream file = new FileOutputStream("src\\DataBase\\CustomerState.dat");
              ObjectOutputStream outputFile = new ObjectOutputStream(file);
                
              
              
                  
              outputFile.writeObject(CustomerState.get(0));
              
              
              FileWriter fw=new FileWriter("src\\DataBase\\CutomerState.txt"); 
              
             try 
            {
              
                   fw.write(CustomerState.get(0).CurrentCustomerState);
                   
                  
            }
            catch (Exception f)
            {
             //JOptionPane.showMessageDialog(null, f.getMessage());
            }
                  
              
              fw.close();
              outputFile.close();
              
              
             
            
             
            }
        
         catch (IOException e){
            
            //JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
    public void saveApplicationsToFile(){
         
            try 
            {
              FileOutputStream file = new FileOutputStream("src\\DataBase\\Applications.dat");
              ObjectOutputStream outputFile = new ObjectOutputStream(file);
                
              
              for (int i=0; i<Applications.size(); i++){
                  
                  outputFile.writeObject(Applications.get(i));
                  
              }
              
              
             FileWriter fw =new FileWriter("src\\DataBase\\Applications.txt"); 
              
             try 
            {
                
              for (int i=0; i<Applications.size(); i++){
                   fw.write("\n" + Applications.get(i).ApplicationNumber + "\n" + Applications.get(i).Applicationstatus);
              }
                   
                  
            }
            catch (Exception f)
            {
            // JOptionPane.showMessageDialog(null, f.getMessage());
            }
                  
              
              fw.close();
              
              
              
              outputFile.close();
              System.out.println( "The Application status was succefully saved");
             
            
             
            }
        
         catch (IOException e){
            
            //JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
    }
    
    
    
   
    
    
    
    
    
    ////////////////////// functions related to buttons ////////////////////////// where testing shall be done //////////
    
    void ApplyForAnAccount(String UserNameText, String PasswordText, String EmailText, String PhoneText, String AddressText  ){
        
        
        
        
        int ApplicationNumber = r.nextInt(9999); 
        String Name = UserNameText;
        String Password = PasswordText;
        String Email = EmailText;
        String phoneNumber = PhoneText;
        String PlaceAddress = AddressText;
        
        int accNumberpart1 = r.nextInt(9999); 
        int accNumberpart2 = r.nextInt(9999);
        int accNumberpart3 = r.nextInt(9999);
        int accNumberpart4 = r.nextInt(9999);
        
        int ccNumberpart1 = r.nextInt(9999); 
        int ccNumberpart2 = r.nextInt(9999);
        int ccNumberpart3 = r.nextInt(9999);
        int ccNumberpart4 = r.nextInt(9999);
        
        String AccountNumber = (String.valueOf(accNumberpart1) + "-" + String.valueOf(accNumberpart2) +  "-"  + String.valueOf(accNumberpart3) +  "-"  + String.valueOf(accNumberpart4));
        
        String CreditCardNumber = (String.valueOf(ccNumberpart1) + "-" + String.valueOf(ccNumberpart2) +  "-"  + String.valueOf(ccNumberpart3) +  "-"  + String.valueOf(ccNumberpart4));
        
        String pin = "0000";
        
                                                              // checks if empty 
        
  //      if (UploadText.getText().isEmpty() ||AddressText.getText().isEmpty() ||UserNameText.getText().isEmpty()||PhoneText.getText().isEmpty()||
                
          //      EmailText.getText().isEmpty() ||PasswordText.getText().isEmpty()){
            
       //      JOptionPane.showMessageDialog(null, "One of the Required fields is empty please fill it");
            
   //     }else{
        
            
        
       
        CustomerAccount Customer = new CustomerAccount(ApplicationNumber,Name, Password,Email,phoneNumber,PlaceAddress);
        
        Customer.setAccountNumber(AccountNumber);
        Customer.setCreditCardNumber(CreditCardNumber);
        Customer.setPinNumber(pin);
        
        
        
        Customers.add(Customer);
        saveCustomersToFile();
        System.out.println( "Apllication# " + ApplicationNumber);
        
     //   }         // checks if empty 
       
    
        try
        {
        
            FileInputStream file = new FileInputStream("src\\DataBase\\Cutomers.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
        
        FileWriter fw=new FileWriter("src\\DataBase\\CutomersData.txt");  
        FileWriter fw2 = new FileWriter("src\\DataBase\\ManageApplicantsRequests.txt");
        
       for (int i=0;i<Customers.size();i++){
           
            try 
            {
              
                   fw.write("\n" + Customers.get(i).getName() + "\n" + Customers.get(i).getEmail()+ "\n" + Customers.get(i).getPhoneNumber()+ "\n" + Customers.get(i).getPlaceAddress()+"\n" + Customers.get(i).getPassword() + "\n" + Customers.get(i).getAccountNumber() + "\n" + Customers.get(i).getCreditCardNumber() + "\n" + Customers.get(i).Balance );
                   fw2.write("\n" + Customers.get(i).getApplicationNumber() + "\n" + Customers.get(i).getName() + "\n" + Customers.get(i).getEmail()+ "\n" + Customers.get(i).getPhoneNumber()+ "\n" + Customers.get(i).getPlaceAddress()+"\n" + Customers.get(i).getPassword() + "\n");
                  
            }
            catch (Exception f)
            {
             //JOptionPane.showMessageDialog(null, f.getMessage());
            }
          
        }
        fw.close();  
        fw2.close();
        inputFile.close();
   
        }                             
        catch (IOException e){
            
           // JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    
        
       
    }
    
    
    ///////////////////////////////////// login admin after customer has applied //////////
    
    
    
    void LoginAdmin(String MainUserName, String MainPassword){
        
        
         if (MainUserName.equals("Admin")  && MainPassword.equals("Admin") ){
            
          System.out.println(" administrator has been successfully loged into the system");
         
         }else {
               System.out.println("Failed login attempt, make sure you are inserting the proper credintials");
         }
        
        
    }
    
    
    ///////////////////////////////////// manage the applications request function (manage request button equivalent) ////////// 
    
    
    void checkApplicationRequests(){
        
         try  
{  

File f = new File("src\\DataBase\\ManageApplicantsRequests.txt");   
if(!Desktop.isDesktopSupported())
{  
System.out.println("aint working");  
return;  
}  
Desktop desktop = Desktop.getDesktop();  
if(f.exists())        
desktop.open(f);              
}  
catch(Exception e)  
{  
e.printStackTrace();  
}  
        
        
        
    }
    
    
 void ManageApplicationRequests(String InsertText, boolean Approved){
     
     
     
     
     if (Approved == true){
     
        
            String Applicationstatus = "Approved";
            String ApplicationNumber =  InsertText;
        
     
      
            
       
        
       
        Applications application =new Applications(ApplicationNumber,Applicationstatus);
        
        Applications.add(application);
        saveApplicationsToFile();
         
        
        try
        {
        
            FileInputStream file = new FileInputStream("src\\DataBase\\Applications.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
        
      FileWriter fw3= new FileWriter("src\\DataBase\\ApplicationStatus.txt",true);  
        
       for (int i=0;i<Applications.size();i++){
           
            try 
            {
              
                    fw3.write( "\n" + Applications.get(i).ApplicationNumber + " " + Applications.get(i).Applicationstatus+ "\n");
                  
            }
            catch (Exception f)
            {
            // JOptionPane.showMessageDialog(null, f.getMessage());
            }
          
        }
        fw3.close();
        inputFile.close();
        }
        catch (IOException e){
            
           // JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
    
        
     } else if (Approved == false){
         
         
         
            String Applicationstatus = "DisApproved";
            String ApplicationNumber =  InsertText;
        
     
      
            
       
        
       
        Applications application =new Applications(ApplicationNumber,Applicationstatus);
        
        Applications.add(application);
        saveApplicationsToFile();
        
          try
        {
        
            FileInputStream file = new FileInputStream("src\\DataBase\\Applications.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
        
      FileWriter fw3= new FileWriter("src\\DataBase\\ApplicationStatus.txt",true);  
        
       for (int i=0;i<Applications.size();i++){
           
            try 
            {
              
                    fw3.write( "\n" + Applications.get(i).ApplicationNumber + " " + Applications.get(i).Applicationstatus+ "\n");
                  
            }
            catch (Exception f)
            {
            // JOptionPane.showMessageDialog(null, f.getMessage());
            }
          
        }
        fw3.close();
        inputFile.close();
        }
        catch (IOException e){
            
            //JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
         
         
         
     }
     
     
     
     
     
    
    }
    
    ///////////////////////////////////// customer login button after his/her request was approved ////////// 
    
    void LoginCustomer(String MainUserName, String MainPassword ){
        
        try
        {
        
        FileInputStream file = new FileInputStream("src\\DataBase\\Cutomers.dat");
        ObjectInputStream inputFile = new ObjectInputStream(file);
        boolean endOfFile = false;
        
        while (!endOfFile){
            
            try 
            {
              Customers.add((CustomerAccount) inputFile.readObject());
                
            }
            catch (EOFException e)
            {
                endOfFile = true;
            }
            catch (Exception f)
            {
             //JOptionPane.showMessageDialog(null, f.getMessage());
            }
        }
        
        inputFile.close();
        }
        
        catch (IOException e){
            
            //JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
        
        
        
         try{
        
       
       FileInputStream file = new FileInputStream("src\\DataBase\\Applications.dat");
        ObjectInputStream inputFile = new ObjectInputStream(file);
        boolean endOfFile = false;
        
        while (!endOfFile){
            
            try 
            {
           Applications.add ((Applications) inputFile.readObject());
                
            }
            catch (EOFException e)
            {
                endOfFile = true;
            }
            catch (Exception f)
            {
            // JOptionPane.showMessageDialog(null, f.getMessage());
            }
        }
        
        inputFile.close();
        }
        catch (IOException e){
            
           // JOptionPane.showMessageDialog(null, e.getMessage());
            
        }
             
             
        
        
        
        
  if(MainUserName.isEmpty() ||MainPassword.isEmpty() ){
            
                         System.out.println( "One of the Required fields is empty please fill it");

 }else{
            
           
      
   boolean abort = false;    
   
   boolean Match = false;
           
           
   for (int i=0;i<Customers.size() && !abort ;i++) {
           
          
     
      if (MainUserName.equals(Customers.get(i).getName().trim())  && MainPassword.equals(Customers.get(i).getPassword()) ){
              
          String x = Integer.toString(Customers.get(i).ApplicationNumber);
          
          for (int j=0; j<Applications.size(); j++){
             
         
                if(x.equals(Applications.get(j).ApplicationNumber) && Applications.get(j).Applicationstatus.equals("Approved")) {
                    
                    
                    
                    
                    CustomerState currentCustomerState = new CustomerState(MainUserName + " " + MainPassword); // state is a combination of pass and username
        
        
        
        
        
                    CustomerState.add(0, currentCustomerState);
                            
                            
       
                    saveCustomerStateToFile();
                    
                    
                    
                    
                     Match = true;
                     System.out.println( "you have been logged in successfuly");
                     abort = true;
                     break;
                     
                     
                     
                     
                     
                     
                      
                }else if(x.equals(Applications.get(j).ApplicationNumber) && Applications.get(j).Applicationstatus.equals("DisApproved")){
                    
                   System.out.println( "Unfortunaely your application has been denied");
                    
                    abort = true;
                    break;
                    
                } 
          }
                     
                
      }
   
     }
   
   
    if (Match == false) {
                      
        
        System.out.println("Failed login attempt, make sure you are inserting the proper credintials");
                       
                     }
        
        
        
        
        
        
  }
        
        
    }
    
    
    
    
    //////////////////////////////////////////////////////// main function feha instructions for testing ///////////////////
    
    
    
    public static void main(String[] args) {
        
        
        Customers = new ArrayList<CustomerAccount>();
        Applications = new ArrayList<Applications>();
        CustomerState = new ArrayList<CustomerState>();
        populateArrayList1();
        
        
        ////////////////// test here ya mennah /////////////// 
        
        // first test the apply for an account unit which is responsible for the customers creation of account process using the following function below
        
        ///// ApplyForAnAccount(String UserNameText, String PasswordText, String EmailText, String PhoneText, String AddressText  );
        
        //  next independently test the admin login function using the function below this     
        
        ///// LoginAdmin(String MainUserName, String MainPassword);       
        
        // next test the mange request module which shows application requests and then approve / disapprove the function below
        
        //// ManageApplicationRequests(String InsertText);   // the first parameter is the String of the application number, the second parameter mimics approve/disapprove, 1 and 0 respectivly 
        
        // you can use the checkApplicationRequests function to check application numbers (this function doesnt need testing)
        
        //// checkApplicationRequests();   // returns you a test file containing information about the applicant including application number
        
        // then test if after the customer has had his/her application been approved, by trying to login to the system using customer user name and pass
        
        ////  use this function --> LoginCustomer(String MainUserName, String MainPassword );
        
        // after testing each of these independently you can test them altogether as in integration testing for those 
        
        
        
        
        
        
        
    }
    
}












// classes down there 


class CustomerState implements Serializable{
    
    String CurrentCustomerState;
    
    
    
    CustomerState(String CustomerUserName){
        
        this.CurrentCustomerState = CustomerUserName;
        
    }
    
    
      
    
}

class Applications implements Serializable{
    
    String ApplicationNumber;
    String Applicationstatus;
    
    
    Applications(String A, String B){
        
        this.ApplicationNumber = A;
        this.Applicationstatus = B;
    }
      
    
}
class UserAccount implements Serializable {


    String Name;
    String Password;
    String Email;
    String phoneNumber;
    String City;
    String Town;
    String District;
    String StreetAddress;
    String PlaceAddress;
    String CreditCard;
    
     static int Accountscounter = 0;
    
    String arrayofUsersAccounts[][] = new String[1][10];
    
    UserAccount(){
        
        
    }
   
    
    
   
   

}


class CustomerAccount extends UserAccount {
    
  
    int ApplicationNumber;
    int Balance = 0;
    String AccountNumber;
    String pin;
           
            
     CustomerAccount(int A, String B, String C, String D, String E,String F){
        
        this.ApplicationNumber = A;
        this.Name = B;
        this.Password = C;
        this.Email = D;
        this.phoneNumber =E;
        this.PlaceAddress = F;
        
        
      
        
        Accountscounter++;
        
    } 

    public int getApplicationNumber() {
        return ApplicationNumber;
    }
     
     

    public String getName() {
        return Name;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

   

    public String getPlaceAddress() {
        return PlaceAddress;
    }

 
    public static int getAccountscounter() {
        return Accountscounter;
    }

    public String[][] getArrayofUsersAccounts() {
        return arrayofUsersAccounts;
    }

    
   
    
    
    
    public String getAccountNumber() {
        
        return AccountNumber;
        
    }
    
    public void setAccountNumber(String accNumber) {
        
        AccountNumber = accNumber;  
        
    }
    
    public String getCreditCardNumber() {
        
        return CreditCard;
        
    }
    
    public void setCreditCardNumber(String ccNumber) {
        
        CreditCard = ccNumber;  
        
    }
    
    public String getPinNumber() {
        
        return pin;
        
    }
    
    public void setPinNumber(String pinNumber) {
        
        pin = pinNumber ;  
        
    }
    
    
    public int getBalance() {
        
        return Balance;
        
    }
    
    
    
    int CheckBalance(){
        
        return Balance;
    }
    
    void DepositAmount(int Deposited_amount){
        
        Balance += Deposited_amount;
        
    }
    
}
