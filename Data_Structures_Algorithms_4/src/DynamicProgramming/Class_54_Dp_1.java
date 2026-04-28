package DynamicProgramming;

public class Class_54_Dp_1 
{
	static int[] dp;
	static int[] dp1;

	public static void main(String[] args) 
	{
		 // Dynamic Programming ===> Recursion
		
		 // Q1) Find N^th Fibanacci Number ?
		 /*
		  * 		0	1	2	3	4	5	6	7	8	9	10	.	.	.
		  * Fib :   0	1	1	2	3	5	8	13	21	34	55	.	.	.
		  */
		 
		 int n=6;
		 
		 int ans1=Fibanaci(n);
		 System.out.println("Fibanacci Recursive Code : "+ans1);
		 
		 /* What is DP ?
		  * 
		  * Obs : Solving Same Subproblem again & again : Overlapping Subproblems
		  * 
		  * Optimize Idea : Dynamic Programming
		  * 
		  * 1) Solving Subproblem 1^st Time = Solve it & Store it
		  * 
		  * 2) Solving Same Problem > 1 Time = Reuse The Stored Value
		  *  
		  */
		 
		 // Q2) Given N, Calculate & Return Factorial of N
		 
		 int n2=4;
		 int ans2=Factorial(n2);
		 System.out.println("Factorial Recursive Code : "+ans2);
		 
		 /* When to Applay DP ?
		  * 
		  * Note : In Above, There is no Overlapping Subproblems, No need to Applay any DP.
		  * 
		  */
		 
		 /* How to Applay DP ?
		  * 
		  * 1) DP Table : Where we Store our Subproblems in Array.
		  * 
		  * 2) DP State : What we are Storing ==> Which Subproblem information are we Storing ?
		  * 
		  * 			dp[i] = fib(i) = i^th Fibanacci Number
		  * 
		  * 			dp[N] = fib(N) = N^th Fibanacci Number
		  * 
		  * 3) Table Size dp[N+1]; 
		  * 
		  * 4) Initialization : If Subproblem 1^st : Solve & Store , 2^nd : Reuse
		  * 
		  *    dp[N+1]=-1; //Invalid Value
		  *    
		  * 5) Dp Code
		  * 
		  * 6) TC : No : of dp states * TC for each state 
		  *    
		  *    SC : Table Size
		  * 
		  */
		 
		 /* DP Code with Recursion : Memoization or Top Down
		  * 
		  * DP Code in Iterative : Tabulation or Bottom Up
		  * 
		  */
		 
		  // Q3) Fibanacci Code with DP-Recursive
		  
		 int ans3=Solve(n);
		 System.out.println("Fibanacci with DP Recursive: Memoization or Top Down Approach : "+ans3);
		 
		 // DP Iterative 
		 /*
		  * 1) DP Table : Where we Store Our Subproblems in Array
		  * 
		  * 2) DP State : What are we Storing => Which Subproblem information are we storing ?
		  * 
		  * 			  dp[i] = fib(i) => i^th Fibanacci Number
		  * 
		  * 			  dp[N] = fib(N) => N^th Fibanacci Number
		  * 
		  * 3) Table Size dp[N+1];
		  * 
		  * 4) DP Expression : Solving Problem with [ Subproblems => State Values ]
		  * 
		  * 				   dp[i] = dp[i-1] + dp[i-2];
		  * 
		  * 5) Dp Code :
		  * 
		  * 		   int dp[]=new int[N+1];
		  * 
		  * 		   // Edge Case : Input for which dp expression fails
		  * 		   //    |
		  * 		   //	 ---> Base Condition for Recursive Code.
		  * 
		  * 6) TC : No : of dp states * TC for each state
		  *    SC : Table Size
		  * 
		  */
		 
		// Q3) Fibanacci Code with Iterative - Bottom Up
		
		int ans4=Solve1(n);
		System.out.println("Fibanacci with DP Iterative : Tabulation or Bottom Up Approach : "+ans4);
	}

	private static int Solve1(int n) 
	{
		 dp1=new int[n+1]; // Initialize dp Table
		 	 
		 return fib1(n);
	}

	private static int fib1(int n) // T.C = O(N)
	{							   // S.C = O(N)
		 if(n<=1)
		 {
			 return n;
		 }
		 
		 dp1[0]=0;
		 dp1[1]=1;
		 
		 for(int i=2;i<=n;i++)
		 {
			 dp1[i]=dp1[i-1]+dp1[i-2];
		 }
		 
		 return dp1[n];
	}

	private static int Solve(int n) 
	{
		 dp=new int[n+1]; // Initialize dp Table
		 
		 for(int i=0;i<=n;i++)
		 {
			 dp[i]=-1;
		 }
		 
		 return fib(n);
	}

	private static int fib(int i) // T.C = O(N) * O(1) = O(N)
	{							  // S.C = O(N)
		if(i<=1)
		{
			return i;// Note : We don't need to save base condition, because, it's execution time = O(1), Even if Store & Reuse it or directly return it T>C = O(1)
		}
		
		if(dp[i]==-1)// 1^st Time
		{
			dp[i]=fib(i-1)+fib(i-2);// Solve with Subproblems & Store it.
		}
		
		return dp[i];
	}

	private static int Factorial(int n) // T.C = O(N)
	{									// S.C = O(N)
		if(n<=1)
		{
			return 1;
		}
		
		return Factorial(n-1)*n;
	}

	private static int Fibanaci(int n) // T.C = O(2^N)
	{								   // S.C = O(N)
		 if(n<=1)
		 {
			 return n;
		 }
		 
		 return Fibanaci(n-1)+Fibanaci(n-2);
	}

}
