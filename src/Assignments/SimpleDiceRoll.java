package Assignments;

public class SimpleDiceRoll {
	
	public void run() { 
	int dieValue = 0;
	int totalDie =0;
	long seed = (new java.util.Date()).getTime();
	java.util.Random rnd = new java.util.Random(seed);
			
	while(dieValue != 1){
		totalDie = totalDie + dieValue;
		dieValue = rnd.nextInt(6)+1;
		System.out.println(dieValue);
		
		
	}	
	System.out.println("total: " + totalDie);	
			
	}

	public static void main(String[] args){
		SimpleDiceRoll roll= new SimpleDiceRoll();
		roll.run();
		
		
	}
}

	
	
	
	
	
	
	
