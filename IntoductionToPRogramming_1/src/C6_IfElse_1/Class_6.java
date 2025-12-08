package C6_IfElse_1;

public class Class_6 
{

	public static void main(String[] args) 
	{
		/* If-Else : 1
		 * What is the usecase of if-else?
		 * If else is used in case of boolean conditions where we want to execute a piece of code if a condition is true or false.
		   The condition should be boolean i.e output of the condition should be either true or false.
		   For example: Let's say We are making a system for senior citizens wherein a person can get pension if that person is 65 or older otherwise he/she can't. Here the condition is age of the person.
		 * if (age >= 65)
		 * If block :
		 *         When we only want to do something when condition is true
		 *  int a = 9;
			if( a >= 10 )
			{
    			System.out.println("inside if b block");
			}
			System.out.println("outside if block");
		 * outside if block
		 * Next Phase-2
		 * Condition: a >= 10 gives false therefore code inside if block does not gets executed.
		 * Using multiple if conditions
		 * int a=18,b=16;
		   if ( a >= 18 )
		    { 
		    	System.out.println("a is major");
			}
		   if ( b >= 18 ) 
		   { 
    			System.out.println("b is major");
		   }
		   System.out.println("Blab");
		 * a is major
		   Blab
		 * Using multiple if conditions
		 * int a = 50, b=50;
		   if ( a >= 50 ) 
		   {
    			System.out.println("a scored half");
    			a = a+1;
		   }
		   if ( b >= 50 ) 
		   {
    			System.out.println("b scored half");
    			b = b+1;
		   }
		   System.out.print(a+b);
		 * a scored half
		   b scored half
		   102
		 * If - else block :
		 * In case if we want to do some work when condition is true we use only if block, but when we want to do work when condition is false → Use If - Else
		 * When condition is true if block is executed. When condition is false else block is executed.
		 * if ( 9 > 5 )
		 * {
    		System.out.println("If block");
		   } 
		   else 
		   {
    		System.out.println("Else block");
		   } 
		   System.out.println(("Outside if else"));
    	 * If block
		   Outside if else
		 *  if ( false ) 
		 *  {
     			System.out.println("if block");
			} 
			else 
			{
     			System.out.println("else block");
			}
		 * else block
		 * If else-if block:
		 * This block is used when we have multiple conditions to check.
		 * Syntax :
		 * if (condition1) 
		 * {
  				// block of code to be executed if condition1 is true
		   } 
		   else if (condition2) 
		   {
  				// block of code to be executed if the condition1 is false and condition2 is true
		   } 
		   else 
		   {
  				// block of code to be executed if the condition1 is false and condition2 is false
		   }
		 * -> If block : Will be executed if condition1 is true
		   -> else if block : Will be executed if the condition1 is false and condition2 is true
		   -> else block : Will be executed if both Condition1 and Condition2 are false.
		 * int time = 22;
		   if (time < 10) 
		   {
  				System.out.println("Good morning.");
		   } 
		   else if (time == 22) 
		   {
  				System.out.println("Good day.");
		   } else 
		   {
  				System.out.println("Good evening.");
		   }
		   System.out.println("Outside all blocks");

		 * Good day.
		   Outside all blocks
		   -> Since our condition i.e time == 22 is true hence else if block is executed.
	       -> Last print statement will be executed by default as it is outside if-else blocks
   		 * Note:
   		 * Always use brackets in pairs.
   		 * Be careful when writing conditions inside if-else blocks.
   		 * Keep in mind that java is case sensitive while writing if and else words.
   		 * Note :
   		 * 1) There Can be Multiple else if blocks
   		 * 2) else block is optional
   		 * 3) Without if,else,else if cannot exist
   		 */
	}

}
