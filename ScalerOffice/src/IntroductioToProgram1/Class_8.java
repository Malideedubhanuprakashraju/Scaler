package IntroductioToProgram1;

public class Class_8 
{

	public static void main(String[] args) 
	{
		 /* Loops:
		  * Test case
			Inputs for which we already know the correct output.
			We use them to check whether our code is correct or not.
			Dry run:
		  * When we take help of a test case and run our code on pen and paper.
		  * While Loop:
		  * What is the usecase of Loops?
		  * Loops in Java is a feature used to execute a particular piece of the program repeatedly if a given condition evaluates to be true.
		  * A very obvious example of loops can be daily routine of programmers i.e. Eat -> Sleep -> Code -> Repeat
		  * https://i.imgur.com/uFa6uRN.png
		  * Structure of While loop:
			Step 1: Initialization of a loop variable.
			Step 2: Write while with condition.
			Step 3: Write the task you want to repeat.
			Step 4: Updation of loop variable. 
		  * initialize
			while(condition)
			{
    			// task to be repeated
     			updation
			}
		  * https://i.imgur.com/B2fRVuT.png
		  * Working of While Loop:
		  * According to the above flowchart, the working of the while loop is as follows:
		  * 1. Initialization of Loop variable.
		  * 2. The flow jumps to the Test condition of the while loop which is a boolean expression.
			Test condition is checked.
		  * 2.1 If the test condition is True, then the body of the while loop is executed.
		  * 2.2 If the test condition is False, then the execution of the loop is terminated.
		  * When the Test condition is true, the body of the while loop is executed.
		  * 3. Update condition is executed.
		  * 4. Again flow go back to Step 2 and check the condition.
			When the Test condition is false, the execution of the while loop is terminated.
		  * Code1:

			Print all numbers from 1 to 5.
		  *     int i = 1;
    			while(i <= 5)
    			{
    				System.out.println(i);
    				i = i + 1; // i++ , ++i , i += 1 
    			}
   		  * 1
			2
			3
			4
			5

   		  * Code2:

			Infinite While Loop in Java:
   		  * int i = 1;
			while(i <= 10)
			{
    			System.out.println(i);
			}

   		  * Since the condition is always true -> we will be stuck in an infinite loop.
   		  * Code3:
					int i = 1;
					while(i <= 5)
					{
    					System.out.println(i);
    					i = i - 1;
					}
   		  * Since the condition is always true -> we will be stuck in an infinite loop.
   		  * Number of iterations:
   		  * Iteration means executing the same block of code again and again.
			The number of times we go inside the loop, gives the total numbers of iterations for that code.
   		  * Code 1:
   		  * int i = 1;
			while(i <= 20)
			{
     			System.out.println(i);
    			i = i + 1;
			}
			
			-- Ans = 20
   		  * The loop starts from 1 and go till i<=20, 
			and everytime we are taking a jump of 1. 
			Therefore the number of times loop will iterate is 20 times. 
   		  * Code 2:
   		  * int i = 2;
			while(i <= n)
			{
	    		SOPln(i);
	    		i = i + 2;
			}
			-- Ans = n/2
   		  * Explanation
   		  * Since the loop is starting from 2 going till i<=20 
			and everytime we are taking a jump of 2. 
			Therefore total iterations would be n/2. 
   		  * Code 3:
   		  * int i = 3;
			while(i <= n)
			{
	    		SOPln(i);
	    		i = i + 3;
			}
			-- Ans = n/3
   		  * Similarly in this case, we are starting the loop from 3 to i<=n, 
			but everytime taking a jump of 3. 
			Therefore total iterations would be n/3. 
   		  * 
		  */
	}

}
