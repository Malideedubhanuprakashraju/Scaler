package IntroductioToProgram1;

public class Class_7 
{

	public static void main(String[] args) 
	{
		 /* If else-2
		  * 1. Conditional statements without braces
		  * If we have only 1 statement to execute for if or else if or else then we can write it without braces.
		  * int time = 22;
			if (time < 10) 
			{
    			System.out.println("Good morning");
			}
 			else 
 			{
     			System.out.println("Good day");
			}
		  * Good day
		  * This same code can be written without braces :
		  * int time = 22;
			if (time < 10) 
    			System.out.println("Good morning"); 
			else 
    			System.out.println("Good day");
    	  * Good day
    	  * 2. Scope of a variable
    	  * The scope/life of a variable is restricted to the block {} where it is created.
    	  * We can't access a variable outside it's block i.e {}.
    	  * Code 1:
    	  * public static void main(String[] args) 
    	  * {
    		int x = 10;
    		{
        		int y = 20;
        		System.out.println(x + " " + y);
    		}
    		{
				System.out.println(x + " " + y); // y is out of scope here
    		}
    		System.out.println(x + " " + y);
			}
    	  * Error : cannot find symbol
        	symbol:   variable y
    	  * Variable y is out of scope as it is created inside different block.
    	  * 1. public static void main(String[] args) 
    	  * 	{
			2.    int x = 10, y = 20;
			3.    {
			4.        System.out.println(x + " " + y); //10 20
			5.    }
			6.    {
			7.        x = 15; // x = 15, y = 20
			8.        System.out.println(x + " " + y);// 15 20
			9.    }
			10.    System.out.println(x + " " + y); // 15 20
			11. }

    	  * Output :
    	  * 10 20
			15 20
			15 20
    	  * Here both x and y are created in line 1 block so they can be accessed here i.e till line 11.
    	  *
    	  *
		  */
	}

}
