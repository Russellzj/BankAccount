import java.util.*;

// Base class for all Account subtypes  
 
public class Account implements Comparable<Account>{
	
  Integer id;
  public double balance;
  public String accountType;
  private static double annualInterestRate;
  private java.util.Date dateCreated;

  // Default constructor
  public Account() {
    dateCreated = new java.util.Date();
  }  
  
    // Two-arg constructor
  public Account(int newId, double newBalance) {
    id = newId;
    balance = newBalance;
    dateCreated = new java.util.Date();
    accountType = "Account";
  }
  @Override
  public int compareTo(Account o){
	  if (balance > o.balance)
		  return 1;
		  else if (balance < o.balance)
		  return -1;
		  else
			  return 0;
  }

  // Accessor for private data member id
  public int getId() {
    return this.id;
  }

  // Accessor for private data member balance
  public double getBalance() {
    return balance;
  }

  // Accessor for private data member annualInterestRate
  public double getAnnualInterestRate() {
    return annualInterestRate;
  }

  // Mutator for private data member id
  public void setId(int newId) {
    id = newId;
  }

  // Mutator for private data member balance
  public void setBalance(double newBalance) {
    balance = newBalance;
  }


  // Mutator for private static data member annualInterestRate
  public static void setAnnualInterestRate(double newAnnualInterestRate) {
    annualInterestRate = newAnnualInterestRate;
  }

  // Accessor for the calculated monthly interest earned
  public double getMonthlyInterest() {
    return balance * (annualInterestRate / 1200);
  }

  // Accessor for private data member dateCreated 
  public java.util.Date getDateCreated() {
    return dateCreated;
  }

  // Mutator to change balance via a withdrawal
  public void withdraw(double amount) {
    balance -= amount;
  }

  // Mutator to change balance via a deposit
  public void deposit(double amount) {
    balance += amount;
  }
  
  public String getType(){
	  return accountType;
  }
  
  @ Override
  public String toString() {
    return getType() + ": " + getId() + ", balance: " + getBalance();
  }
}

// This creates the checking account sub-class
class CheckingAccount extends Account{
	private double overdraftLimit;
	private  static double annualInterestRate;
	
	// Three-arg constructor. Uses its parents two arg constructor
	public CheckingAccount(int newID, double newBalance, double setoverdraftLimit){
		super(newID, newBalance);
		overdraftLimit = setoverdraftLimit;
		accountType = "CheckingAccount";
	}

	// Mutator for private data member annualInterestRate
	public static void setAnnualInterestRate(double rate){
		annualInterestRate=rate;
	}
	
	// Overrides accessor for getting annualInterestRate
	@ Override
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	
	// Mutator for the private data member overdraftLimit
	public void setoverdraftLimit(double newoverdraftLimit){
		overdraftLimit = newoverdraftLimit;  
	}
	
	
	  // Accessor for the calculated monthly interest earned
	  public double getMonthlyInterest() {
	    return balance * (annualInterestRate / 1200);
	  }
	  
	// Getter for overdrafLimit
	public double getOverdraftLimit(){
		return overdraftLimit;
	}
	
	// Checks to see if the account is overdrawn
	public boolean isOverDrawn(){
		return balance<0;
	}
	
	// Overrides Account's withdraw method
@ Override
	public void withdraw(double amount) {
		if (amount>(balance+overdraftLimit)){
			System.out.println("The requested amount exceeds your current balance + overdraft limit.");
		}
		else{
			balance -= amount;
		}
	}
}


// This creates the Savings Account sub-class
class SavingsAccount extends Account{
	private  static double annualInterestRate;
	
	// Constructor for Savings Account
	public SavingsAccount(int ID, double Balance){
		super(ID, Balance);
		accountType = "SavingsAccount";
	}
	
	// Sets the Annual Interest Rate
	public static void setAnnualInterestRate(double rate){
		annualInterestRate=rate;
	}
	
	  // Accessor for the calculated monthly interest earned
	@ Override  
	public double getMonthlyInterest() {
	    return balance * (annualInterestRate / 1200);
	  }
	  
	// Accessor for the annual Interest Rate variable
	@ Override
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	
	// Overrides the Account withdraw Method
	@ Override
	public void withdraw(double amount) {
		if (amount>(balance)){
			System.out.println("The requested amount exceeds your current balance.");
		}
		else{
			balance -= amount;
		}
	}
}
	
	// CertificateOfDeposit class, subclass to SavingsAccount
class CertificateOfDeposit extends SavingsAccount{
	private boolean isWithdrawnEarly=false;
	private  static double annualInterestRate;
	
	// Constructor for the CertificateOfDeposit Class
	public CertificateOfDeposit(int ID, double Balance){
		super(ID, Balance);
		accountType = "CD";
	}
	
	// Sets Annual Interest Rate
	public static void setAnnualInterestRate(double rate){
		annualInterestRate=rate;
	}
	
	// Overrides Account getAnnualInterestRate
	@ Override
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	
	  // Accessor for the calculated monthly interest earned
	  public double getMonthlyInterest() {
	    return balance * (annualInterestRate / 1200);
	  }
	  
	// Getter for isWithdrawn Early boolean
	public boolean checkEarlyWithdraw(){
		return isWithdrawnEarly;
	}
	
	// Setter for isWithdrwnEarly Boolean
	public void setEarlyWithdraw(){
		isWithdrawnEarly=true;
	}
	
	// Overrides Account withdraw method
	@ Override
	public void withdraw(double amount) {
		isWithdrawnEarly=true;
		if (amount>balance){
			System.out.println("The requested amount exceeds your current balance.");
		}
		else{
		balance -= amount;
		annualInterestRate=0;
		}
	}
	
	// Overrides Account deposit method
	@ Override
	public void deposit(double amount) {
		System.out.println("Additiomnal deposits are not permitted for this type of Account.");
	}
}

class AccountComparator implements Comparator<Account>{

	@Override
	public int compare(Account o1, Account o2) {
		double balance1 = o1.getBalance();
		double balance2 = o2.getBalance();
		
		if (balance1 < balance2)
			return 1;
		else if (balance1 > balance2)
			return -1;
		else 
			return 0;
	}
	
}
