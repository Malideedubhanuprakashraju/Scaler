package IntroductioToProgram1;

public class Class_9 
{

	public static void main(String[] args) 
	{
	  /* For Loops:
	   * Every for loop question can be done using a while loop. The difference lies in the syntax.
	   * For Loop provides a concise way of writing initialization, test condition, and increment/decrement statements in one line.
	   * Syntax:
				for(Initialization ; Condition ; Updation)
				{
    				// Body of the Loop
				}
		 Flow:
	   * https://i.imgur.com/Gkc8mlt.png
	   * Working of For Loop:
	   * 1. Initialization expression is executed.
	   * 2. Condition is checked.
	   * 2.1 If it is true then control goes inside body of the loop.
	   * 2.2. If the condition is false, Loop will be terminated.
	   * 3. After execution update expression is carried out.
	   * 4. Again flow go back to Step 2 and check the condition.
			If the condition evaluates to false, the loop is terminated else the body of the loop is again executed.
	   * 5. This process continues until the condition becomes false. If the condition never becomes false, it is the case of an infinite loop.
	   * Code1:
		 Print all numbers from 1 to 5.
	   * for(int i = 1; i <= 5; i++) 
	   * {
    		System.out.println(i);
		 }
	   *O/P : 1, 2, 3, 4, 5 
	   *Code2 :
	   * Print all the numbers from N to 1.
	   * Input: 10
					Scanner scn=new Scanner(System.in);	
					
					int N=scn.nextInt();
					
					for(int i= N;i>=1;i=i-1)
					{
						System.out.print(i+" ");
					}

	   * [Success] Your code was executed successfully
		 10 9 8 7 6 5 4 3 2 1 
	   * Infinite Loop:
	   * Code:
	   * for(int i=1;i <= 5;i--)
	   * {
    		System.out.print(i + " ");
		 }
	   * Since the condition is always true -> we will be stuck in an infinite for loop.
	   * Handling Multiple Test Cases:
	   * int T = scn.nextInt();		
			for(int i = 1; i <= T; i++)
			{
			    int n = scn.nextInt();
			    //Do the task
			}

	   * Explanation :
	   * Take "T" test cases from the user, start loop from 1 
		 and iterate till "i" value is <=T. 
		 Every value of "i" take a input from the user and perform the required task. 
	   * Example:
		 Read T numbers and for every number print the last digit.
	   * Input Format:
						1st Line: Contains T
						Followed by T lines containing the T numbers
						int T = scn.nextInt();
						for(int i = 0; i < T; i++) 
						{
						    int n = scn.nextInt();
						    System.out.println(n%10);
						}

	   * 
	   * 
	   */
	   //Q) Given N, Print it's Last Digit
		int n=243;
		System.out.println(n%10);
		RemoveL(n);
		
		//Q) Given N, Print All Digits of N in Reverse Order
		int n1=6397;
		Reverse(n1);
		System.out.println();
		//Q) Given N,Print Count of Digits of N
		int n2=6397;
		CountDigits(n2);
		
		SumDigits(n2);
	}

	private static void SumDigits(int n) 
	{
		 int sum=0;
		 
		 if(n<0)
		 {
			 n=n*-1;
		 }
		
		 while(n>0)
		 {
			 sum=sum+n%10;
			 n=n/10;
		 }
		 System.out.println(sum);
	}

	private static void CountDigits(int n) 
	{
		 int count=0;
		 while(n>0)
		 {
			 count++;
			 n=n/10;
		 }
		 System.out.println("count-->"+count);
	}

	private static void Reverse(int n1) 
	{
		if(n1==0)
		{
			System.out.println(0);
		}
		else if(n1<0)
		{
			n1=n1*-1;
		}
		
		while(n1>0)
		{
		 int d=n1%10;
		 System.out.print(d+" ");
		 n1=n1/10;
		}
	}

	private static void RemoveL(int n) 
	{
		 n=n/10;
		 System.out.println(n);
	}

}
