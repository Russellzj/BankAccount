import java.util.*;

//Test driver for Comparing Account

public class TestCompareAccounts {

  public static void main(String[] args) {

	// Heterogeneous list of Accounts using the super-type Account
    ArrayList<Account> mixedAccounts = new ArrayList<>();
    mixedAccounts.add(new Account(1234, 1000));
    mixedAccounts.add(new CheckingAccount(1235, 10000, 1000));
    mixedAccounts.add(new SavingsAccount(1236, 12000));
    mixedAccounts.add(new CertificateOfDeposit(1237, 11000));
    
    // Requires that Account implements Comparable and provides a compareTo method
    Collections.sort(mixedAccounts);
    
    // Iterate over mixedAccounts using a for-each loop
    System.out.println("Mixed Accounts in natural sort order based on balance:");
    for (Account a : mixedAccounts) {
        System.out.println(a.toString());  
       }
       
    System.out.println();  // blank line for readability
    
    
    // Create a homogeneous List (all of one sub-type)
    ArrayList<CheckingAccount> checkingAccounts = new ArrayList<>();
    checkingAccounts.add(new CheckingAccount(2345, 10000, 1000));
    checkingAccounts.add(new CheckingAccount(2346, 9000, 1000));
    checkingAccounts.add(new CheckingAccount(2347, 8000, 1000));
    checkingAccounts.add(new CheckingAccount(2348, 7000, 1000));
    
    // Sort checkingAccounts using the default compareTo implementation 
    Collections.sort(checkingAccounts);
    
    // Displays all elements of checkingAccounts
    System.out.println("checkingAccounts in natural sort order based on balance:");
    
    //Iterator to traverse and display the elements of checkingAccounts  
    Iterator<CheckingAccount> iterator1 = checkingAccounts.iterator();
    while (iterator1.hasNext()){
    	System.out.print(iterator1.next());
    	System.out.println();
    }
    
    
    System.out.println();
    
    // Proves that the compareTo method is amenable to other collections static methods
    Collections.reverse(checkingAccounts);

    System.out.println("checkingAccounts in reverse sort order based on balance:");
    
     // Iterator to traverse and display the elements of checkingAccounts 
    Iterator<CheckingAccount> iterator11 = checkingAccounts.iterator();
    while (iterator11.hasNext()){
    	System.out.print(iterator11.next());
    	System.out.println();
    }


    System.out.println();  // Line for readability 
    
    // Return list to its natural order
    Collections.sort(checkingAccounts);
    
    System.out.println("checkingAccounts in natural sort order based on balance:");
    //Iterator to traverse and display the elements of checkingAccounts 
    Iterator<CheckingAccount> iterator111 = checkingAccounts.iterator();
    while (iterator111.hasNext()){
    	System.out.print(iterator111.next());
    	System.out.println();
    }
    
	System.out.println();// Line for readability
 
    // Use custom comparator class to sort by balance high to low
    Collections.sort(checkingAccounts, new AccountComparator());    
    
    // Iterator to visit and display all elements of checkingAccounts
    System.out.println("checkingAccounts in Comparator class sort order:");

    // Iterator to traverse and display the elements of checkingAccounts 
    Iterator<CheckingAccount> iterator1111 = checkingAccounts.iterator();
    while (iterator1111.hasNext()){
    	System.out.print(iterator1111.next());
    	System.out.println();
    }
   
    System.out.println();
    
    // Creates a homogeneous list of SavingsAccounts
    ArrayList<SavingsAccount> savingsAccounts = new ArrayList<>();
    savingsAccounts.add(new SavingsAccount(3459, 10000));
    savingsAccounts.add(new SavingsAccount(3458, 9000));
    savingsAccounts.add(new SavingsAccount(3457, 8000));
    savingsAccounts.add(new SavingsAccount(3456, 7000));
 
 
    // Call Collections.sort with savingsAccounts plus a Lambda expression 
    savingsAccounts.sort((o1, o2)->o1.getId()-o2.getId());
    
    System.out.println("savingsAccounts in Lambda sort order:");
    
    //Iterator to traverse and display the elements of savingsAccounts  
    Iterator<SavingsAccount> iterator2 = savingsAccounts.iterator();
    while (iterator2.hasNext()){
    	System.out.print(iterator2.next());
    	System.out.println();
    }
    
    System.out.println();
    
  }  // end of main

} // end of class TestComparaeAccounts


