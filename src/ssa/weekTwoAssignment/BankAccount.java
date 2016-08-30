package ssa.weekTwoAssignment;

public class BankAccount {

	int accountId; // unique account id
	String description;  // type of account
	double balance;
	
	
public	 String  print() {
	    return "Account: id is " + accountId + ", desc is " + description 
	      + ", balance is " + balance; 
	  }
	  // deposit into the account
public	  double deposit(double amount) {
	    balance += amount;
	    return balance;
	  }
	  // withdraw from the account, but cannot go negative
public double  withdraw(double amount) {
	    if(amount > balance) 
	      System.out.println("Insufficient funds!");
	      
	    else 
	      balance -= amount;
	     
	   
	    return balance;
	}
}


