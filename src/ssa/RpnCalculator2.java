package ssa;

import java.util.Stack;

public class RpnCalculator2 {

	public static void main(String[] args) {
	
		char[] problem = new char[] {'1','2','+','3','-'};

		
		Stack<Integer> stk = new Stack<Integer>(); 
		for(char ch : problem){
			System.out.println(ch);
		int nbr= Character.getNumericValue(ch);
		if (nbr !=-1){
			stk.push(nbr);
			
		} else{
			if (ch == '+'){
				int num2= stk.pop();
				int num1= stk.pop();
				int tot = num1 + num2;
				stk.push(tot);
				
			} else if (ch== '-'){
				int num2= stk.pop();
				int num1= stk.pop();
				int tot = num1 - num2;
				stk.push(tot);
				
			} else if (ch== '*'){
				int num1= stk.pop();
				int num2= stk.pop();
				int tot = num1 * num2;
				stk.push(tot);
				
			}else if (ch== '/'){
				int num2= stk.pop();
				int num1= stk.pop();
				int tot = num1 / num2;
				stk.push(tot);
			}
			
			
		} // if
		} // for
		int ans= stk.pop();
		System.out.printf("The answer is %d", ans);
		
	}

}
