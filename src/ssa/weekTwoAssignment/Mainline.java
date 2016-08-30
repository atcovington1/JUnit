package ssa.weekTwoAssignment;

import ssa.weekTwoAssignment.Savings;


public class Mainline {
	
	public static void main(String[] args) {

		Savings savings1 = new Savings();
		savings1.setInterestRate(0.20);
		savings1.deposit(1000.00);
		System.out.println(savings1.getBalance());
		savings1.calcDepositInterest(10);
		System.out.println(savings1.getBalance());

		
		
		Account checking = new Account(100, "");
		System.out.println(checking.print());
		checking.getAccountId();
		checking.setDescription("My personal checking account  ");
		checking.deposit(800.00);
		checking.print();
		checking.deposit(300.00);
		checking.print();
		checking.withdraw(699.99);
		checking.print();
		checking.deposit(149.99);
		checking.print();
		checking.withdraw(950.00);
		checking.print();
		checking.withdraw(200.00);
		checking.print();//balance should be 350
		System.out.println(checking.print());
		
		Account savings =new Account(200,"");
		System.out.println(savings.print());
		savings.getAccountId();
		savings.setDescription("My personal savings account");
		savings.deposit(1000.00);
		savings.print();
		savings.deposit(400.00);
		savings.print();
		savings.withdraw(750.00);
		savings.print();
		savings.withdraw(250.00);
		savings.print();
		savings.deposit(650.00);
		savings.print();
		System.out.println(savings.print());
		
		Account checking2 =new Account(300,"");
		System.out.println(checking2.print());
		checking2.getAccountId();
		checking2.setDescription("My slush fund checking account  ");
		checking2.deposit(300.00);
		checking2.print();
		checking2.withdraw(150.00);
		checking2.print();
		checking2.deposit(250.00);
		checking2.print();
		System.out.println(checking2.print());
	
	checking.print();
	checking2.print();
	savings.print();
	
	
	}
	
	
}
 
