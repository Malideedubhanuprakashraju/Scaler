package Basic_Maths;

public class Class_39_Maths_2 
{

	public static void main(String[] args) 
	{
		/* Prime Numbers :
		 * --------------
		 * 
		 * Numbers Having Only = 2 Factors { 1 & itself }
		 * 
		 * Eg : 2	3	5	7	11	13
		 * 
		 * Note : 1 is not prime : It has Only 1-Factor
		 * 
		 * 
		 * Q1) Check Number Prime or Not ?
		 * 
		 * Eg : 10 : No
		 * 		11 : Yes
		 * 		16 : No
		 * 
		 * Count no:of Factors == 2.
		 * 
		 * 	a) Iterate from 1....N & Count Factors, T.C = O(N)
		 * 
		 * 	b) If i is a Factor of N , N/i is also a Factor.
		 * 
		 * 	   Iterate from 1....Sqrt(N)
		 *   
		 */
		boolean ans=isPrime(11);
		System.out.println("Given Element is Prime ? : "+ans);
		
		// Q2) Given N, we need to print all Primes from 1...N
		/*
		 * N = 10 : 2	3	5	7
		 * 
		 * N = 16 : 2	3	5	7	11	13
		 * 
		 * Idea-1 : For Every Number from 1...N, call above isPrime() function.
		 * 
		 */
		printPrime(16);
		System.out.println();
		
		System.out.println();
		
		/* Idea-2 : Seive of Eratosthenes : The Sieve of Eratosthenes is an efficient algorithm used to find all prime numbers up to a given number N.
		 * 			---------------------
		 * 
		 * Idea : Instead of checking each number individually, we eliminate multiples of primes step by step.
		 * 
		 * Optimisation : N=50 : All Primes from 1....50
		 * 
		 * Iterate 2 : Cancle Mutilples of 2
		 * 		   3 : Cancle Multiples of 3
		 * 		   4 : Cancle Multiples of 4
		 *   
		 */
		printAllPrimes(16);
		
		/* i		j= Multiples of i till N
		 * ---------------------------------
		 * 2		Multiples of 2 till N = N/2
		 * 3		Multiples of 3 till N = N/3
		 * 4		No iterations
		 * 5		Multiples of 5 till N = N/5
		 * 6		No iterations
		 * .
		 * .
		 * .
		 * p		Multiples of P till N = N/P
		 * 
		 * 
		 * Total Iterations = N/2 + N/3 + N/5+.......N/P
		 * 				
		 * 				  S = N/2 + N/3 + N/5+.......N/P
		 * 
		 * 				  S = N(1/2 + 1/3 + 1/5 + .....1/P)
		 * 
		 * Note : Sum of Reciprocals of Prime till N = log(logN)
		 * 
		 * S = N * log(log N)
		 * 
		 * T.C = O(N*log(logN)+N)
		 * 
		 * S.C = O(N)
		 * 
		 */
		
		// Q3) Given N, return the Count of Factors all Numbers from 1....N
		/*
		 * Note : Return Cnt[N+1] because Cnt[i] should contain no:of Factors for i^th Element
		 * 
		 * Eg :
		 * 
		 * N=10 :	0	1	2	3	4	5	6	7	8	9	10
		 * 
		 * Cnt[11] :0	1	2	2	3	2	4	2	4	3	4
		 * 
		 * 
		 * Idea-1 : For Event Number Calculate Count of Factors.
		 * 
		 * T.C = O( N * sqrt(N) )
		 * 
		 * S.C = O(1)
		 * 
		 * 
		 * Idea-2 : N = 10 { For all Numbers 1....10 neeneed count of Factors }
		 *   
		 */
		int ans1[]=printAllCountFactors(10);
		
		/* The sum:
		 * 
		 * 1/2 + 1/3 + 1/4 + ... + 1/n ==> is called a harmonic series
		 * 
		 * ≈ log n
		 * 
		 * Total Iterations : N/2 + N/3 + N/4 +......N/N
		 * 
		 * 					Sn = N[1/2 + 1/3 + 1/4+... 1/N]
		 * 
		 * Note : Sum of Reciprocals till N = log N
		 * 
		 * TC = n × log n = O(n log n)
		 * 
		 * SC = Array of size n → O(n)
		 * 
		 * | Case                                 | Space Complexity |
		   | ------------------------------------ | ---------------- |
		   | Normal (interview)                   | **O(n)** ✅      |
		   | Ignoring output (if explicitly said) | **O(1)**         |

		 * 
		 */
		
		// Q4) Sorted Permutation Rank.
		/*
		 * Formula : Ways to Arrange N different  things = N!
		 * 
		 * 
		 * Given a String Containing Distinct Characters.
		 * 
		 * The Task is to Find Rank of this String among all of it's Permutations
		 * 
		 * When Sorted in Alphabetical Order { Dictonary Order }
		 * 
		 * Eg : BCA 
		 * 
		 * Q : Rank of BCA among it's Permutation, when they are sorted in Dictionary Order
		 * 
		 * Permutations : ABC	ACB	  BAC	BCA	 CAB	CBA
		 * 
		 * 				   1	2	   3	 4	  5		 6
		 * 
		 * Ans = 4
		 *   
		 */
		int ans2=Rank("BCA");
		System.out.println();
		System.out.println("Rank : "+ans2);
		
		/* All permutations in sorted order:
		 * 
		 * ABC
		   ACB
		   BAC
           BCA   ← your string
           CAB
		   CBA
		 * 
		 * 👉 Rank = 4
		 * 
		 * | i | ch | smaller on right | c | (n-i-1)! | contribution |
		   | - | -- | ---------------- | - | -------- | ------------ |
		   | 0 | B  | A                | 1 | 2! = 2   | 2            |
           | 1 | C  | A                | 1 | 1! = 1   | 1            |
           | 2 | A  | -                | 0 | 0! = 1   | 0            |
           
           👉 Total = 2 + 1 = 3
           👉 Return = 3 + 1 = 4 ✅

		 */
	}

	private static int Rank(String s) // T.C = O(N^2)
	{								  // S.C = O(1)
		 int n=s.length();
		 
		 int rank=0;
		 
		 for(int i=0;i<n;i++)
		 {
			 char ch=s.charAt(i);
			 int c=0;
			 
			 for(int j=i+1;j<n;j++)
			 {
				 if(s.charAt(j)<ch)
				 {
					 c++;
				 }
			 }
			 
			 int per=fact(n-i-1)*c;
			 
			 rank=(rank+per);
		 }
		 
		 return rank+1;
	}

	private static int fact(int n) 
	{
		 int ans=1;
		 for(int i=1;i<=n;i++)
		 {
			 ans=ans*i;
		 }
		 return ans;
	}

	private static int[] printAllCountFactors(int n) // T.C = O(n * logn)
	{												 // S.C = O(n)// If your code allocates memory based on n → SC is O(n), not O(1).
		int p[]=new int[n+1];
		
		for(int i=1;i<=n;i++)
		{
			p[i]=1;// For all Numbers 1 is a Factor
		}
		
		for(int i=2;i<=n;i++)
		{
			int j=1;
			
			while(j*i<=n)// j*i <= n  ⇒  j <= n/i ==> For i=n → n/n
			{
				p[j*i]++;// Increasing factor Count
				j++;
			}
		}
		return p;
 	}

	private static void printAllPrimes(int n) 
	{ 
		boolean[] p=new boolean[n+1];
		
		for(int i=1;i<=n;i++)
		{
			p[i]=true; // Assume all numbers are Prime
		}
		
		p[1]=false;
		
		for(int i=2;i<=n;i++)
		{
			if(p[i]==true)
			{
				System.out.print(i+" ");
				
				int j=2;
				
				while(j*i<=n)
				{
					p[j*i]=false;// Iterate on i multiples and Making false
					j++;
				}
			}
		}
	}

	private static void printPrime(int n) // T.C = O(N * sqrt(N) )
	{ 									  // S.C = O(1)
		for(int i=1;i<=n;i++)
		{
			if(isPrime(i))
			{
				System.out.print(i+" ");
			}
		}
		
	}

	private static boolean isPrime(int N) // T.C = O(sqrt(N))
	{									  // S.C = O(1)
		 int c=0;
		 for(int i=1;i*i<=N;i++)// 1....Sqrt(N)
		 {
			if(N%i==0)// i & N/i are Factors
			{
				 if(i==N/i)
				 {
					 c=c+1;
				 }
				 else
				 {
					 c=c+2;
				 }

			}
		 }
		 return c==2;
	}

}
