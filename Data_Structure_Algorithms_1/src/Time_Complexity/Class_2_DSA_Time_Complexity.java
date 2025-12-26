package Time_Complexity;

public class Class_2_DSA_Time_Complexity 
{

	public static void main(String[] args) 
	{
		/* Basics of Logarithm
		 * 
		 * Log : Logarithm is the inverse of exponential functional
		 * 
		 * Log a : To What Value we need to raise b to get a.
		 *    b
		 * 
		 * Log Basics :
		 * 
		 * log a =x : b^x=a {To what power we need to raise b to get a}
		 *    b
		 * eg :
		 * 
		 * log 64 =6 ==>2^6=64
		 * 	  2	
		 * 
		 * log 27 =3 ==>3^3=27
		 * 	  3
		 *  
		 * log 25 =2 ==>5^2=25
		 * 	  5
		 * 			--->2^3=8
		 * log 10 = |		 } 2^3.2 ~~ 3
		 *    2		--->2^4=16
		 *    		
		 *    	   --->2^5
		 * log 40 =|	  } 2^5.8 ~~ 5
		 *    2	   --->2^6
		 *    
		 */
		
		/* Few Formulas
		 * 
		 * 
		 * 1) log a^N=N ==> log 5^3=3 ; ==> log 7^3=3
		 * 		 a			   5			   7
		 * 
		 * 2) N=2^k --> k=log N
		 * 					 2
		 * 
		 * log N =log 2^k=k
		 * 	  2		 2
		 * 	 |				  } ==> N=2^k==> k=log N
		 * 										  2
		 * 	 |
		 * 	 ----->log 2^k=k
		 * 			  2
		 * 
		 */
		
		/* Q) Given a +ve integer N, how many times do we need to divide it by 2
		 * 	  Until it reaches 1.
		 * 
		 * eg:
		 * 
		 * N=100-->50-->25-->12-->6-->3-->1 =>Ans=6.
		 * 
		 * N=9-->4-->2-->1 =>Ans=4.
		 * 
		 * Q) N>0
		 * 	  i=N
		 * 	  While(i>1)
		 * 	  {
		 * 		i=i/2;
		 * 	  }
		 * 
		 *  i= N-->N/2------>N/4------>N/8----->N/16-->.....k....N/
		 *     -	-		  -			-		 -				 -
		 *     N	N/2^1	 N/2^2	   N/2^3	N/2^4			 (2^k)
		 *     
		 *  Assume after k iterations code stops :
		 *  
		 *  Observations :
		 *  
		 *  i=N/2^k=1 ==> N=2^k ==> k=log N
		 * 								 2
		 * 
		 * Conclusion : After log N iterations code stops
		 * 						 2
		 */
		
		/* for(i goes from 1 to N-1 and gets multiplied by 2 in every iteration)
		 * {
		 * 		......
		 * }
		 * 
		 * eg :
		 *  	for(int i=1;i<n;i=i*2)
		 *  	{
		 *  	 
		 *  	}
		 * 
		 * Input :	N=16 <==8 <==4 <==2 <==1 : i=i*2 ==> Ans=4 {Currrent Q, *2}
		 * 																		Generalize	} log N
		 * 																			 			 2
		 * 			N=16 <==8 <==4 <==2 <==1 : i=i/2 ==> Ans=4 {Previous Q, /2}
		 * 
		 * Generalize :
		 * 
		 * i=N ~ .... <-- <-- <--8 <--4 <--2 <--1 ans= log N {N*2}
		 * 												  2
		 * 
		 * i=N ~ N --> N/2 --> N/4 --> N/8 -->..1 ans= log N {N/2}
		 * 												  2	
		 */
		
		/* 1)i{1--->10}
		 * 			  	} 10N-iterations
		 *   j{1--->N}
		 * 
		 * 2)i{1--->N}
		 * 			   } N^2-iterations
		 * 	 j{1--->N}
		 * 
		 * 3)i{1--->N}
		 * 			   } N*log N
		 * 					  2 
		 * 	 j{1--->j*2}
		 * 
		 * 4)i{1--->N}
		 * 			   } Iterations = 1+2+3+.....N= N*(N+1)/2	
		 * 	 j{1--->i}
		 * 
		 * 5)i{1--->N}
		 * 				} Iterations =2^1+2^2+2^3+......2^N =Sum of t terms in GP= 2*[2^N-1]/2-1=2*[2^N-1]
		 * 	 j{1--->2^i}
		 * 
		 */
		
		/* Comparing 2-Algorithms Based on iterations :
		 * 
		 * In Real World :
		 * a) CSK vs RCB : ~~40cr
		 * b) Google Search : ~~10^9results
		 * c) Youtube : 100views
		 * 
		 * Conclusion : For Very Large inputs we prefer..?
		 * 
		 * ==> We use Asymptotic Analysis to estimate perfomance of Algo, when input is huge.
		 * 
		 * Asymptotic or Big O : Perfomance of Algo for very large inputs
		 * 
		 * Steps to Calculate Big O
		 * 
		 * 1) Calculate no:of iterations based on input size.
		 * 2) Consider only higher order terms.
		 * 3) Neglect Constant co-efficients.
		 * 
		 * Calculate Big O :
		 * 
		 * 1) iterations : 4N^2+3N+1 ~~ O(N^2)
		 * 2) Higher Order Terms : 4N^2
		 * 3) Neglect Constant co-efficient : N^2
		 * 
		 * Big O = O(N^2)
		 * 
		 */
		
		/* Comparison Order Terms :
		 * 
		 * log N < 	sqrt(N) < N <  N*logN <	 N*sqrt(N) <  N^2 <	 N^3	 <	 2^N <	 N!  < 	N^N
		 * 	  2	
		 * 	 | N=64   |		  |		|			|			|	  |			  |		 |		 |
		 * log 64	sqrt(64)  64  64log 64	  64Sqrt(64)  64*64  64*64*64	 2^64	64!		64^64
		 * 	  2						   2
		 * 
		 * = 6	  <	   8  <   64  <  64*6		64*8	     	 
		 * 
		 */
		
		/* Why Consider only higher order terms ?
		 * 			   ---->Higher order Terms
		 * 			   |		
		 * Say f(N) = N^2 + 10N/iterations
		 * 					 |
		 * 					 --->Lower order Terms	
		 * 
		 * 														% lower order terms
		 * Input Size :				Total Iterations			Iterations in Total
		 * 
		 * N: 10		=>N^2+10N	 =>10^2+10*10 = 200					100/200*100%= 50%			|
		 * 
		 * 
		 * N: 10^2		=>N^2+10N	 =>(10^2)^2+10*10^2	= 10^4+10^3		10^3/10^4+10^3*100%= 9%		|
		 * 
		 * N: 10^4		=>N^2+10N	 =>(10^4)^2+10*10^4 = 10^8 + 10^5	10^5/10^8+10^5*100%= 0.1%	|
		 * 																							> Decresing
		 * Observation : As input N increases, contribution of lower term decreases.
		 * 						
		 * Observation-2 :
		 * 				  While comparing constant co-efficient won't effect our comparison.
		 * 
		 * Issues in BigO-Notation :
		 * 
		 * 				Algo-1		Algo-2
		 * iterations : 10*N^2		2*N^2+5N
		 * 		BigO  : O(N^2)		O(N^2)
		 * 
		 * issue 	  : As per BigO both are same.
		 * 
		 * iterations : Algo1 > Algo2 : Algo 2 is faster
		 * 
		 * Note : If 2-BigO notations same we compare their iterations.
		 * 			
		 */
		
		// Q) Search for k in given Array
		
		int a[]= {10,30,24,10,9996};
		boolean ans=search(a,24);
		System.out.println(ans);
		
		// iterations : Best  : 1-iteration
		//				worst : N-iteration
		// Note : While calculating Big-O always consider 
		// Worst case scenario
		
		// Q) Given an Array[N] get max of first 4-elements
		
		// Constraints : 4<=N<=10^5
		
		int ans1=max4(a);
		System.out.println(ans1);
		
		// iterations : 4 : Fixed Irrespective Always 4
		// Big O =O(1)
		//
		// Constant iterations : Irrespective of input, iterations will be fixed.
		
		/* TLE : Time Limit Exceed
		 * 	   : Google--> Hiring Challenge - 60mins
		 * 		   |
		 * 		   ------> idea---->check---->code ----->TLE
		 * 		   |
		 * 		   ------> idea---->check---->code ----->TLE
		 * 
		 * Idea : Without writing code how how to decide TLE or Not ?
		 * 
		 * Working of Online Editors
		 * 
		 * code(submit)---->Online Servers : Processing Power =10^8iterations/sec
		 * 			    |				
		 * 				--->Time Limit	: 1sec
		 * 	Observations : Our Codes can run at max = 10^8iterations.
		 *	 	
		 */
		
		/* Question Description : Given Array do....Something
		 * 
		 * Constraints : Limit to our input.
		 * 
		 * 1<=N<=10^5 //N is Array Size
		 * 1<=ar[i]<=10^9 //Each Array Value
		 * 
		 * Conclusion :
		 * 															No TLE
		 * Idea-----> Check Correct------>Psudecode----->EstimateTC------>Code------>Submit
		 *  |												 |
		 *  --------------------------------------------------
		 *  					TLE
		 */
		
		
	}

	private static int max4(int[] a) 
	{
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<4;i++)
		{
			if(a[i]>ans)
			{
				ans=a[i];
			}
		}
		return ans;
	}

	private static boolean search(int[] a, int k) 
	{
		int n=a.length;
		for(int i=0;i<n;i++)
		{
			if(a[i]==k)
			{
				return true;
			}
		}
		return false;
	}

}
