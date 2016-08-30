package ssa.weekTwoAssignment;


public class Savings extends Account {
	
	private double interestRate;
	private double deposit;
	
		public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate){
		this.interestRate = interestRate;
	}
	public void calcDepositInterest(int months){
		double InterestPaid = this.getInterestRate() / 12 * months * this.getBalance();
		this.deposit(InterestPaid);
		this.getBalance();
	System.out.println(this.getBalance());

	}
		

	
}
	

