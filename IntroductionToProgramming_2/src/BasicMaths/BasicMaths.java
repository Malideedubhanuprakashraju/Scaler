package BasicMaths;

public class BasicMaths 
{

	public static void main(String[] args) 
	{
		// delete(Start,end):
		//		|
		//		----> Removes Character from Start to end-1
		// StringBuilder to String
		//		|
		//		----> toString();
		
		/* Math Basics
		 * 
		 * 1) Sum of first N Natural Numbers=(N*(N+1))/2;
		 * 	  1+2+3+........N
		 * 
		 * How Many Numbers in Range[3,10] : {3,4,5,6,7,8,9,10}=Numbers=8.
		 * 
		 * 2) How Many Numbers in Range [a,b]=b-a+1
		 * Note : It Means that Corner is included.
		 * eg:
		 * [4,7]=7-4+1=4
		 * {4,5,6,7}=4-Numbers
		 * 
		 * 3) Geometric Progression :
		 * 							 Series, where ratio of 2-consecutive terms is Same.
		 * Series : 2 6 18 54 162
		 * 			6/2=18/6=54/18=162/54=3
		 * Observation : Ratio between 2-Adjacent elements is always same
		 * 
		 * Sum of First T-Terms in GP= a*[r^T-1/r-1
		 * a=1^st Term of GP
		 * r=common ratio
		 * 
		 * 4) GCD(A,B) : The Greatest Common Divisor/Factor that divide both A&B.
		 * eg:
		 * GCD(24,36):
		 * 24 : 1,2,3,4,6,8,12,24
		 * 						  } GCD is 12
		 * 36 : 1,2,3,4,6,9,12,36
		 * 
		 * eg:
		 * GCD(12,18):
		 * 12 : 1,2,3,4,6,12
		 * 					} GCD is 6
		 * 18 : 1,2,3,6,9,18
		 * 
		 * Observation : 		 Min	  Max
		 * 				GCD(A,B): 1		min(A,B):If m ele divides other
		 * 				
		 * Obs :
		 * 
		 * GCD(A,B) : {mingcd(A,B)=1,	maxgcd(A,B)=min(A,B)}
		 * 
		 * Con : Given 2 numbers A,B The GCD between Them has to be between [1......min(A,B)]
		 * 
		 * Dry Run :
		 * 
		 * GCD(8,12) : GCD has to be in range {1...8}
		 * 		 
		 */
		int ans=GCD(8,12);
		System.out.println("GCD of 8 & 12 is : "+ans);
		System.out.println("2-nd Way to Solve GCD");
		int ans1=gcd(5,10);
		System.out.println(ans1);
		
		/* Least/Lowest Common Multiple 
		 * LCM(A,B) : Lowest Common Multiple between A & B.
		 * 
		 * LCM(A,B)=(A*B)/GCD(A,B);
		 * 
		 * eg:
		 * LCM(4,5) :
		 * 4 : 4,8,12,16,20
		 * 					} LCM is 20
		 * 5 : 5,10,15,20,25
		 *  
		 */
		int ans2=LCM(4,5);
		System.out.println("LCM "+ans2);
		
		// Relation between GCD & LCM
		// Between 2 numbers A,B
		// GCD(A,B)
		// LCM(A,B)
		// A*B=GCD(A,B)*LCM(A,B);
		// LCM(A,B)=A*B/GCD(A,B);
		
		// Iterations : Number of Times Loop Runs
		
		
	}

	private static int LCM(int A, int B) 
	{
		 return (A*B)/gcd1(A,B);
	}

	private static int gcd1(int A, int B) 
	{
		//We keep replacing the bigger number with the smaller one,
		//and the smaller one with the remainder, until nothing is left to divide.
		//A % B  →  remainder is always smaller than B
		while(B!=0)
		{
			int temp=B;
			B=A%B;
			A=temp;
			
		}
		return A;
	}

	private static int gcd(int A, int B) 
	{ 
		int ans=1;
		int max=Math.min(A, B);
		for(int i=max;i>=1;i--)
		{
			if(A%i==0 && B%i==0)
			{
				ans=i;
				break;
			}
		}
		return ans;
	}

	private static int GCD(int A, int B) 
	{
		int ans=0;
		int min=Math.min(A, B);
		for(int i=1;i<=min;i++)
		{	
			// i is common factor of A,B;
			if(A%i==0 && B%i==0)
			{
				ans=i;//Update;
			}
		}
		return ans;
	}

}
