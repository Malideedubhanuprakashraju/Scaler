package IntroductiontoProblemSolving;

public class Client 
{

	public static void main(String[] args) 
	{ 
		// Q) Given N>0, Return No:Of Factors of N ?
		// Factor:
		// Quiz : Is 4 a Factor of 24?
		// 		  24%4==0: Yes, It is a Factor
		// Note : Check if i is a Factor of N ?
		//		  N%i==0
		
		// CountFactors :
		// N=24---> Factors= 1,2,3,4,6,8,12,24 : 8 Factors
		// N=10---> Factors= 1,2,5,10 ; 4 Factors
		
		// Note : For Given N, All Factors in Range[1...N]
		
		int n=6;
		int ans=countFactors(n);
		System.out.println("Count Factors "+ans);
		
		/* Assumption :
		 * System can do 10^8 iterations in 1-sec
		 * |
		 * -----> Our : 10^8iterations/sec
		 * 
		 * Unitary Method :
		 * 
		 * 6 Apples = 60 rupees
		 * 1 Apple=60/6=10 rupees
		 * 15 Apples = 15*10= 150 rupees
		 * 
		 * Assumption : 10^8 iterations= 1 sec
		 * 						1-Iteration=1/(10^8)sec {System Capcity}
		 * iterations : For N:i={1...N}=N-Iterations
		 * 
		 */
		
		/* Observations
		 * 
		 * Let's Say i*j=N
		 * 		  i & j are factors of N:
		 * 		  j=N/i {i,N/i are Factors}
		 * 
		 * Conclusion : If i is Factor of N
		 * 				N/i is also Factor of N
		 * 
		 * eg: 	N	i	N/i
		 * 		36	4	36/4
		 * 	    12	3	12/3
		 * 
		 * N=24												|			N=36	
		 * 		
		 * i	<=		N/i												i		<=		N/i
		 * 1	<=		24												1		<=		36
		 * 2	<=		12												2		<=		18
		 * 3	<=		8												3		<=		12
		 * 4	<=		6												4		<=		9
		  					Repeating Below Elements Below--->			6		<=		6
		 * 6	<=		4												9		<=		4
		 * 8	<=		3												12		<=		3
		 * 12	<=		2												18		<=		2
		 * 24	<=		1									|			36		<=		1
		 *  
		 *  
		 * Observation : If iterate only First Half we will get All Factors
		 * 
		 * Start i=1
		 * End   i<=N/i
		 * 
		 * i^2<=N:{Works}
		 * 
		 * Applay sqrt on both sides
		 * 
		 * i<=Root^N
		 * 
		 * So That ==> i:{1.....Sqrt^N}
		 * 
		 * Observation : iterate i=1 to i*i<=N
		 * 
		 * N=15
		 * 
		 * i		i*i<=15		N%i==0		i&N/i	c=0
		 * 
		 * 1		1*1<=15		15%1==0		1&15	c+=2 }Both i & N/i are considered
		 * 2		2*2<=15		15%2==0
		 * 3		3*3<=15		15%3==0		3&5		c+=2
		 * 4		4*4<=15: Stop & return c=4
		 * 				
		 */
		 int ans1=countFactorsOpti(n);
		 System.out.println(ans1);
		 
		 // Prime Check
		 // Prime Number : A number is Prime Number, if it has exactly 2-Factors{1 & iteself}
		 
		 boolean ans2=isPrime(23);
		 System.out.println("Prime Number "+ans2);
		 
		 // Sn=N*(N+1)/2;
		 
		 /* Basic Math Property
		  * [a b] : All numbers from a,b both corners included.
		  * (a b) : All numbers from a,b both corners excluded.
		  * 
		  * eg :
		  * [3,10]={3,4,5,6,7,8,9,10} : 8-numbers
		  * 	  =[10-3+1]=8
		  * 
		  * Count of Numbers from a...b,both corners included.
		  * [a b]=b-a+1
		  * 
		  * eg :
		  * 
		  * Iteration : No.of Times Your Loop Runs.
		  * 
		  * 1) [1....N]= N-1+1=N iterations
		  * 
		  * 2) [0....100]= 100-0+1=101 iterations
		  * 
		  * 3) [1....N]--->N-iterations
		  * 							} Total= N+M iterations
		  *    [1....M]--->M-iterations	
		  * 
		  * Geometric Progression :
		  * 					   Series in which common ratio between 2-Adjacent Elements is same :
		  * 
		  * GP=a*(r^N-1)/r-1
		  * 
		  */
		 // How to Compare two Algorithms
		 // 					   |
		 //						   ----> To Compare 2-Algorithms we use iterations.
		 
		 /* Instructions
		  * 
		  * Estimate 1-iteration= 10-instructions
		  * Limit =	10^9instructions/sec
		  * 	  = 10^8*10instructions/sec
		  * 	  = 10^8iterations/sec
		  * 
		  */
	}

	private static boolean isPrime(int i) 
	{
		 return countFactorsOpti(i)==2;
		 	//						|
		 	//						---> Relation Operator : true/false
		 
	}

	private static int countFactorsOpti(int n) //T.C=O(SR^N)
	{
		 int c=0;
		 for(int i=1;i*i<=n;i++)
		 {
			 // Check if i is Factor N.
			 if(n%i==0)
			 {
				 // Both i & N/i are Factors
				 if(i==n/i)
				 { 
					 c=c+1;
				 }
				 else
				 {
					 c=c+2;
				 }
			 }
		 }
		 return c;
	}

	private static int countFactors(int n) //T.C=O(N)
	{ 
		int c=0;
		for(int i=1;i<=n;i++)
		{
			if(n%i==0)
			{
				c++;
			}
		}
		return c;
	}

}
