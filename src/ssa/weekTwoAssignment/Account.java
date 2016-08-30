package ssa.weekTwoAssignment;

public class Account {

	public String description;
	private int accountId; // unique account id
	private double balance = 0.0;

	public Account(){}
	public Account(String description){
		this.description= description;
	}
	
	public Account(int accountID, String description){
		this.accountId = accountID;
		this.description =description;
	}
	public int getAccountId() {
		return accountId;
	}
	private void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getBalance() {
		return balance;
	}
	private void setBalance(double balance) {
		this.balance = balance;
	}
	
		public String getDescription() {
		return description;
	}
	
		public void setDescription(String description) {
		this.description = description;
	}
	// deposit into the account
	public	double deposit(double amount) {
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

public void transferFrom(Account account, double amount){
	if (account.getBalance()> amount )
	{
		account.withdraw(amount);
		this.deposit(amount);
	}else
		System.out.println(" Insufficient Funds ");
	
	
}
public String  print( ) {
   return "Account " + this.getAccountId() + "  balance is $"  + this.getBalance();
  
     
}

}


