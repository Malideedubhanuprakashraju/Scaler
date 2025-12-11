package Functions_1;

public class Program_1 
{

	public static void main(String[] args) 
	{ 
		/* Functions 1:
		 * Structure of Function
		 * https://i.imgur.com/tsg7Dfz.png
		 * Syntax
		 * https://i.imgur.com/qxQwUGu.png
		 * 
		 * For eg: Write a function that returns the factorial of given number.
		 * Code :
		 * int factorial (int N)
		 * {
    		int ans = 1;
    		for(int i = 1; i <= N; i++)
    		{
        		ans = ans*i;
    		}
    		return ans;
			}
		 * In order to get some result just creating the function is not enough, we need to use the function.
		 * Syntax 1: In order to use the function, we need to call it.
		 * Code:
		 * function_name(input);
		 * Syntax 2: When function is returning something, we need to either print or store the function call to see the output.
		 * Code:
		 * static int factorial (int N)
		 * {
    			int ans = 1;
    			for(int i = 1; i <= N; i++)
    			{
        			ans = ans*i;
    			}
    			return ans;
			}

			public static void main(String args[]) 
			{
    			factorial(5);
			}
		 * Output : Nothing
		 * Explanation:
		 * We are not getting any output because even though we are receiving 120 from our factorial function, we are not printing it.
		 * Code:
		 * static int factorial (int N)
		 * {
    			int ans = 1;
    			for(int i = 1; i <= N; i++)
    			{
        			ans = ans*i;
    			}
    			return ans;
			}

		  public static void main(String args[]) 
		  {
    		int x = factorial(5);
    		System.out.println(x);
		  }
		 * Output: 120
		 * Explanation:
		 * We are receiving 120 from our factorial function in out function call and then we are assigning this value to variable x and printing the value of x.
		 * Code:
		 * static int factorial (int N)
		 * {
    			int ans = 1;
    			for(int i = 1; i <= N; i++)
    			{
        			ans = ans*i;
    			}
    			return ans;
			}

			public static void main(String args[]) 
			{
    			System.out.println(factorial(5));
			}
		 * Output: 120
		 * We are receiving 120 from our factorial function in our function call and we are printing it.
		 * 
		 * Syntax 3: When we have more than one input parameter we seprate them by comma ( , )
		 * For eg: Write a function that returns the sum of two numbers.
		 * Code :
		 * int addition(int x, int y)
		 * {
    			int ans = x + y;
    			return ans;
			}
		 * 
		 * Syntax 4: When the function is not returning anything, the return type is void
		 * For eg: Write a function that prints the max of two numbers.
		 * Code :
		 * void maxOfTwo(int a, int b)
		 * {
    			if(a > b)
    			{
        			System.out.println(a);
    			}
    			else
    			{
        			System.out.println(b);        
    			}
			}
		 * Syntax 5: When the return type is void, We can neither print the function call nor store it
		 * Code 1:
		 * static void maxOfTwo(int a, int b)
		 * {
    			if(a > b)
    			{
        			System.out.println(a);
    			}
    			else
    			{
        			System.out.println(b);        
    			}
			}
			public static void main(String[] args)
			{
    			System.out.println(maxOfTwo(19, 36));
			}
		 * Output:
		 *  Error: 'void' type not allowed here
	    	System.out.println(maxOfTwo(19,36));
		                           ^
			1 error                                   
		 * 
		 * Code 2:
		 * static void maxOfTwo(int a, int b)
		 * {
    			if(a > b)
    			{
        			System.out.println(a);
    			}
    			else
    			{
        			System.out.println(b);        
    			}
			}
			public static void main(String[] args)
			{
    			int ans = maxOfTwo(19, 36);
    			System.out.println(ans);
			}
		 * Output :
		 * Error: incompatible types: void cannot be converted to int
		   int ans = maxOfTwo(19, 36);
		                  ^
           1 error
		 * Predefined functions
		 * These are built – in functions in Java, which are instantly available to use in your program.
		 * Things to keep in mind while using predefined functions:
		 * 1.Check number of parameters required in the function
		 * 2.Check the return type of the function
		 * Java Math functions List : https://www.w3schools.com/java/java_ref_math.asp
		 * Code:
		 * public static void main(String[] args)
		 * {
			    int x1 = Math.max(51, 90);
			    System.out.println(x1);
			    int x2 = Math.min(51, 90);
			    System.out.println(x2);
			    double x3 = Math.pow(3, 4);
			    System.out.println(x3);
		   }
		 * Output:
		 * 90
		   51
		   81
		 * Explanation:
		 * Math.max(a,b) gives the bigger value between a and b
		   Math.min(a,b) gives the smaller value between a and b
		   Math.pow(a,b) gives a^b as output
		 * 
		 * 
		 * 
		 */
	}

}
