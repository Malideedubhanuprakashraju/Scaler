package Basics2;

public class Program1 
{

	public static void main(String[] args) 
	{
		// Basic Operators and Operands:
		/*
		Numbers
		There are two types of numbers:

		Decimal : The numbers having decimal point.
		Ex : 12.54 , -20.0, 6.97, 0.0
		
		Integers : The numbers without decimal point.
		Ex : 12, -17, 54, 0, -5
		*/
		
		// Some syntax to keep in mind:
		
		// Syntax 1: When we divide ( / ) integers in Java, we only get quotient.
		// In calculator, 15/4 = 3.75
		// But in Java, we only get 3
		// Syntax 2 : Dividing integers by 0 is not allowed, we get error.
		
		/* Syntax 3 : Priority in Basic Operators
						1.Rank 1 : ()
						2.Rank 2 : * , /
						3.Rank 3 : + , -
		*/
		/*
		 * Few important rules of doing operations
		 * Rule 1 : If we have same priority operators, whichever comes first from left to right that will be evaluated first.
		 * Here, * and / both have same priority. 
		   Because / comes first from left to right we will evaluate 15/5 first.
    	   15/5*4 
		  =>  3 * 4
		  =>  12
		 Rule 2 : If we have different priority operators, whichever has highest priority that will be evaluated first.
		 Here, * has higher priority. 
		 2*3 will be evaluated first.
    	 5 + 2 * 3 
		 =>  5 + 6
		 =>  11
		 Rule 3 : With '+' operator, If one Operand is text then we concatenate both Operands.
		 Line 1: System.out.println("Hello" + 2);
		 Hello2
		 Since, there is a + operator with text, we are concatenating both operands.
		 
		 Rule 4 : With text operand, only '+' operator can be used.
		 Line 1: System.out.println("Hello" * 3);
		 Error : bad operand types
		 With text operand, *,- cannot be used
		 */
		
		/*Creating a variable
		 * Line 1 :    type name;
		   Line 2 :    name = value;
                            OR
		   Line 3 :    type name = value;

		 * Line 1 is the declaration step and Line 2 is initialisation.
  		   In Line 3, we are doing both declaration adn initialisation step together.

		 * Syntax 1: If we want to store a integer number, type is int
		 * Line 1:    int y;
		   Line 2:    y = 30;
            			OR
		   Line 3:    int x = 20;

		 * Syntax 2: When we write variable name the value of the variable is used.
		 * Line 1:    int y = 30;
		   Line 2:    System.out.println(y);
            
		   Line 3:    int x = y+10;
		   Line 4:    System.out.println(x);

		 * In Line 1, a variable is created :
    	   type  : int
    	   name  : y
    	   value : 30
		   In Line 2, we are printing y, so the value of this variable will be printed which is 30.

		  In Line 3, a variable is created:
    	  type  : int
    	  name  : x
    	  value : y + 10  
          => 30 + 10 = 40
		  In Line 4, we are printing x, so the value of this variable will be printed which is 40.

		  https://hackmd.io/@52GBOkPIS4W7-65xO73PMw/HJe5_g7M2?utm_source=preview-mode&utm_medium=rec&stext=7768%3A36%3A0%3A1765014322%3AOcIjA9
		 */

	}

}
