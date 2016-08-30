package ssa;

import java.util.Scanner;

public class RPNCalculator {

	private static Scanner scannerObject;

	public static void main(String[] args) {
        double n1, n2;
        String operation;
        scannerObject = new Scanner(System.in);

        System.out.println("First number?");
        n1 = scannerObject. nextDouble();

        System.out.println("Second number?");
        n2 = scannerObject. nextDouble();

        Scanner op = new Scanner(System.in);
        System.out.println("Which operation?");
        operation = op.next();

        String equation = String.valueOf(n1) + "    " + String.valueOf(n2) + "    " + operation;
        
        switch (operation)  {
        case "+":
            System.out.println(" Answer " + (n1 + n2));
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println(equation); 
           break;
            
        case "-":
            System.out.println("Answer " + (n1 - n2));
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println(equation); 
            break;

        case "/":
            System.out.println("Answer  " + (n1 / n2));
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println(equation); 
            break;

        case "*":
            System.out.println("Answer " + (n1 * n2));
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println(equation); 
            break;


        }
    }
}

