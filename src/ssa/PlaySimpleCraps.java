package ssa;

public class PlaySimpleCraps {
	
	public static void main(String[] args) {
		
	long seed = (new java.util.Date()).getTime();
		java.util.Random rnd = new java.util.Random(seed);
		
		int dice1 = rnd.nextInt(6)+1;
		int dice2 = rnd.nextInt(6)+1;
		int roll = dice1 + dice2;
		int thePoint = roll;
		
		System.out.println();
		
		System.out.println("You rolled "+ 
				
				roll +". ");

		if(roll == 2 || roll == 3 || roll == 12){
			System.out.println("First Time Loser!");
		
		}else if(roll == 7){
			System.out.println("All You Do Is Win, Win,Win !");
		
			
		}else{
			System.out.println("Point Roll is "+roll+"\n");
			dice1 = rnd.nextInt(6)+1;
			dice2 = rnd.nextInt(6)+1;
			roll = dice1 + dice2;
			
			System.out.println("You rolled "+ roll +". ");
			while(thePoint != roll && 7!= roll){

				
				dice1 = rnd.nextInt(6)+1;
				dice2 = rnd.nextInt(6)+1;
				roll = dice1 + dice2;
				System.out.println("You rolled "+ roll +". ");
			
			if(roll == 7){
				System.out.println("You Lose, Try Again!");
			} if (thePoint == roll){
				System.out.println("Winner, Winner, Chicken Dinner");
			}
		}
		}
	}
}


