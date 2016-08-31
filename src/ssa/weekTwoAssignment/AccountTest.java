package ssa.weekTwoAssignment;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountTest {
	Account anAccount = new Account();
	@Test
	public void testAccountId() {
	// account id
	assertEquals(anAccount.getAccountId(), (0));
	}
		public void testDescription(){
	//	account description
		anAccount.setDescription("ChristmasFund");
		assertEquals("ChristmasFund", anAccount.getDescription());
		anAccount.setDescription("VacationFund");
		assertEquals("VacationFund", anAccount.getDescription());
		anAccount.setDescription("IRA");
		assertEquals("IRA", anAccount.getDescription());
	}
		public void testBalances(){
	// account balance	
		anAccount.getBalance();
		assertEquals(0, anAccount.getBalance(),0); 
		assertEquals(100, anAccount.deposit(100),0);
		assertEquals(100, anAccount.getBalance(),0);
		}
		
		public void testDepositWithdrawal(){
		double testDeposit =5.00;		
		anAccount.deposit(5.00);	
		assertEquals(5.00, anAccount.getBalance(), 0.005);
		double testWithdraw =5.00;
		anAccount.withdraw(5);
		assertEquals(0.00, anAccount.getBalance(), 0.005);
		anAccount.deposit(1050.00);	
		assertEquals(1050.00, anAccount.getBalance(), 0.005);
		anAccount.withdraw(500);
		assertEquals(5400.00, anAccount.getBalance(), 0.005);
		}	
		}

