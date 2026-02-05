
public class Class_19_Recursion_1 
{

	public static void main(String[] args) 
	{
		 /* 
		  * Recursion :
		  * a) Sorting
		  * b) Trees
		  * c) BackTracking
		  * d) Dynamic Programming
		  * e) Graphs
		  *  
		  */
		/* Function Calls :
		 * 
		 * main()
		 * {
		 * 	 int x=10,y=20;
		 * 	 print(fun(x,y));
		 * }
		 * 
		 * int fun(int x,int y)
		 * {
		 * 	x=add(x,10);
		 * 	y=mul(y,20);
		 * 	
		 * 	return x+y;
		 * }
		 * 
		 * int add(int a,int b)
		 * {
		 * 	 return a+b;
		 * }
		 * 
		 * int mul(int a,int b)
		 * {
		 * 	 return a*b;
		 * }
		 * 
		 * Note : 1) Every Time a Function Call is Made, it is stored on Top Of Stack.
		 * 		  2) When Function retuns or it completes execution, it will exist stack.
		 *  
		 */
		
		/* Recursion : Function Calling itself.
		 * 			   Solving Problem WIth Subproblems is Called Recursion.
		 * 
		 * Sum(5) = 1+2+3+4+5
		 * Sum(5) = Sum(4)+5 //Subproblem=Sum(4);
		 * 		  = 1+2+3+4+5
		 * 
		 * Sum(N) = 1+2+3+...+N-1+N
		 * 		  = Sum(N-1)+N //Subproblem=Sum(N-1);
		 * 
		 * Steps to Recursive Code :
		 * 
		 * 1) Assumption : Decide what your function & Assume it Works
		 * 				   Hint : Question itself Assumption.
		 * 
		 * 2) MainLogic	 : Solving Assumption by Break Problem in Subproblem & Solve it Using SubProblems.
		 * 				   Note : While Write Recursive Code, Have Trust That your Subproblem will work as per your Assumption.
		 * 
		 * 3) BaseConditions : Input for which we want to Stop Recursion.
		 * 
		 * 	  Note : Don't Use Post increment operators, while Writing Recursion.
		 * 
		 */
		
		// Q1) Calculate & Return Sum of N-Natural Numbers.
		int n=10;
		int ans=Sum(n);
		System.out.println("Sum Of n Natural Numbers--> "+ans);
		
		/* Importance of Base Conditions :
		 * 
		 * 1) Recursion Won't Stop :
		 * 	  a) Infinite Calls:
		 * 	  b) TLE,at max iterations ~~ 10^8iterations
		 * 								 : Each function call is 1-iteration
		 * 								 : We can make 10^8 function Calls
		 * 	  c) Every Function is Stored in Stack
		 * 		 Note : Limit of a Stack ~~ 1MB = 10^6B.
		 * 			  : Each Function call ~~ 10B
		 * 			  : At Max we can store ~~ 10^5-10^6
		 * 			  : If we Store more than > 10^5-10^6
		 * 			  : At Some Time Exceed Limit : Stack Overflow Error.
		 * 
		 * 2) Base Always at Top
		 * 	  a) If we write at Bottom, They are never Called.
		 * 	  
		 * 	  int sum(int N)
		 * 	  {
		 * 		1.return sum(N-1)+N
		 * 		2.if(N==1){return 1}
		 *    }
		 *    
		 *    Error : We can never come 2^nd Line---> Unreachable Code.
		 * 		
		 */
		
		/* Fact(N) = Product of All Numbers from 1....N
		 * Fact(5) = 1*2*3*4*5 = 120
		 * Fact(5) = Fact(4)*5 // SubProblem = Fact(4)
		 * 
		 * Fact(N) = 1*2*3*4*.....N-1*N
		 * Fact(N) = Fact(N-1)*N //SubProblem=fact(N-1)
		 * 
		 * 0!=1
		 *  
		 */
		// Q2) Given N, Calculate & Return factorial of N.
		
		int n1=5;
		int ans1=fact(n1);
		System.out.println("Factorial of Given No :"+ans1);
		
		// Q3) Given N, Print All Numbers From 1 to N in Increasing Order.
		
		/* Increasing(5) = 1 2 3 4 5
		 * Increasing(5) = increasing(4)--> SubProblem
		 * 				   print(5);
		 * 
		 * Increasing(N) = 1 2 3 ...N-1 N
		 * 				 = Increasing(N-1)--> SubProblem
		 * 				   print(N);
		 */
		int n2=5;
		int ans2=IncNumber(n2);
		
		// Q4) Given N, Print All Numbers from N to 1 in Decreasing Order.
		
		/* Decreasing(5) = 5 4 3 2 1
		 * Decreasing(5) = Print(5);
		 * 				   Decreasing(4);// SubProblem 
		 * 
		 * Decreasing(N) = N N-1 N-2 ....2 1
		 * Decreasing(N) = Print(N);
		 * 				   Decreasing(N-1);// SubProblem
		 */
		DecNumber(n2);
		
		/* TC of Recursion :
		 * 					#(No.of Total Function Calls in Recursion) * (Time Taken for Each Function Call)
		 * 
		 * SC of Recursion :
		 * 					#(Max Stack Size)
		 * 					Max no:of Function Calls Present in a Stack at a given Point.
		 */
		
		// Q5) Given N, Return Sum of N to 1.
		int ans3=SumOfN(n2);
		System.out.println();
		System.out.println("Sum from N to 1: "+ans3);
		
		
		/* Fibanacci :
		 * 		  	0	1	2	3	4	5	6	7	8	9
		 * Series = 0	1	1	2	3	5	8	13	21	34
		 * 
		 * Fib(10) = Fib(9) + Fib(8)
		 * 
		 * Fib(N) = Fib(N-1) + Fib(N-2)
		 * 			SubProblems : Fib(N-1),Fib(N-2)
		 *  
		 */
		
		// Q6) Given N, Calculate & Return Fibanacci Series.
		int nn=10;
		int ans4=Fibanacci(nn);
		System.out.println("Fibanacci No : "+ans4);
		
		// How to get Base Conditions ?
		// Inputs for which Main Logic Fails, for Those inputs write Condition.
		// At each Level increased by 2^0-> 2^1-> 2^2-> 2^3......2^N ==> G.P => a*[r^t-1]/r-2
		//															 ==> a=1, t=N=1, r=2
		//															 ==> 1*[2^N+1 - 1]/2-1
		//															 ==> 2^N+1-1
		//															 ==> 2*2^N
		
		char ar[]= {'m','a','d','a','m'};
		int s=0,e=4;
		boolean ans5=isPal(ar,s,e);
		System.out.println("Given Array is Palindrome : "+ans5);
		
		/*
		 * 	| Case     | Meaning                       |
			| -------- | ----------------------------- |
			| `s == e` | Middle character (odd length) |
			| `s > e`  | Crossed middle (even length)  |

		 */
		
		/*
		 * “When s >= e, all character pairs have already been compared successfully, so the string is a palindrome.”
		 */
		
	}

	private static boolean isPal(char[] ar, int s, int e) // T.C = O(N)
	{													  // S.C = O(N)
		 if(s>=e)
		 {
			 return true;
		 }
		 if(ar[s]==ar[e] && isPal(ar,s+1,e-1))
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	}

	private static int Fibanacci(int nn) // T.C = O(2*2^N) = O(2^N)
	{									 // S.C = O(N)
		 if(nn<=1)
		 {
			 return nn; // if(N==0){ return 0;}
		 }				// if(N==1){ return 1;}
		 
		 return Fibanacci(nn-1)+Fibanacci(nn-2);
	}

	private static int SumOfN(int n2) 
	{
		if(n2==0)
		{
			return 0;
		}
		
		return SumOfN(n2-1)+n2;
	}

	private static void DecNumber(int n2) // T.C = O(N)
	{									  // S.C = O(N)
		if(n2==0)
		{
			return;
		}
		System.out.print(n2+" ");
		DecNumber(n2-1);
		// Note : Even if Function return type is void we can still return.
	}

	private static int IncNumber(int n2) // T.C = O(N)
	{									 // S.C = O(N)
		 if(n2==0)
		 {
			 return 1;
		 }
		 IncNumber(n2-1);
		System.out.println(n2);
		
		return 0;
		
	}

	private static int fact(int n) // T.C = O(N+1*1) = O(N)
	{							   // S.C = O(N+1) = O(N)
		 if(n==0)
		 {
			 return 1;
		 }
		 return fact(n-1)*n;
	}

	private static int Sum(int n) // T.C = O(N+1*1) = O(N)
	{							  // S.C = O(N+1) = O(N)
		if(n==0)
		{
			return 0;
		}
		 return Sum(n-1)+n;
	}

}
