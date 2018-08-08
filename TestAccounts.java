import java.util.ArrayList;

//Test driver for Account


public class TestAccounts {

  public static void main(String[] args) {

    ArrayList<Account> accounts = new ArrayList<>();
    accounts.add(new Account(1234, 1));
    accounts.add(new CheckingAccount(2345, 10000, 1000));
    accounts.add(new SavingsAccount(3456, 12000));
    accounts.add(new CertificateOfDeposit(4567, 10000));
   
    System.out.println("Basic tests :");
    for (Account a : accounts) {
      System.out.println(a.toString() + " starting balance: " + a.getBalance());  
      System.out.println("Deposit 500");
      a.deposit(500);
      System.out.println("Withdraw 250");
      a.withdraw(250);
      System.out.println(a.toString() + " ending balance: " + a.getBalance());  
     }
    System.out.println(); 

    System.out.println("Set and get interest rates and amounts");
    Account.setAnnualInterestRate(0.0);
    CheckingAccount.setAnnualInterestRate(1.0);
    SavingsAccount.setAnnualInterestRate(2.0);
    CertificateOfDeposit.setAnnualInterestRate(3.0);
    System.out.println(); 
    
    System.out.println("Interest test:");
    for (Account a : accounts) {
    	//Add rounder for interest values to be 2 decimal places
      System.out.println(a.toString() + " annual interest rate: " + a.getAnnualInterestRate());
      System.out.println(a.toString() + " monthly interest amount: " + a.getMonthlyInterest());      
    }

    System.out.println("\nDate created tests:");
    for (int i = 0; i < accounts.size(); i++)
      System.out.println(accounts.get(i).toString() + " created on: " + accounts.get(i).getDateCreated() );
    System.out.println(); 
    
    System.out.println("Type-specific tests:");
    for (int i = 0; i < accounts.size(); i++)  {
    	
      if (accounts.get(i) instanceof CheckingAccount) 
        System.out.println(accounts.get(i).toString()
            + " overdraft limit is "
            + ((CheckingAccount)accounts.get(i)).getOverdraftLimit());     
   
      if (accounts.get(i) instanceof CertificateOfDeposit)  {
    	((CertificateOfDeposit)accounts.get(i)).setEarlyWithdraw(); 
    	accounts.get(i).withdraw(10.00);
        System.out.println(accounts.get(i).toString()
            + " Interest rate is now set to "
            + ((CertificateOfDeposit)accounts.get(i)).getAnnualInterestRate());    
      }
      System.out.println();      
    }
    
    for (int i = 0; i < accounts.size(); i++) {
      System.out.println(accounts.get(i).toString() + " starting balance is :" + accounts.get(i).getBalance());
      accounts.get(i).withdraw(100);
      
      if (! (accounts.get(i) instanceof SavingsAccount || accounts.get(i) instanceof CertificateOfDeposit) ) 
    	System.out.println("Note: " + accounts.get(i).toString() 
    			           + " may have a negative balance due to the class implementation");
      
      System.out.println(accounts.get(i).toString() + " ending balance is :" + accounts.get(i).getBalance());
      System.out.println();
    }
    
  }  // end of main

} // end of class TestAccounts
