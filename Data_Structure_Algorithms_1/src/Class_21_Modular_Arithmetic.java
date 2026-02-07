
public class Class_21_Modular_Arithmetic 
{

	public static void main(String[] args) 
	{
		 /* Modular Arithmetic Introduction
		  * 
		  * A%M = Remainder when A is divided by B
		  * 
		  * x%4 = {0 1 2 3};
		  * 
		  * x%5 = {0 1 2 3 4};
		  * 
		  * Range = [0....M-1]
		  * 
		  * Why do we need % : It can limit your output.
		  * 
		  * -infinity
		  * 	.
		  * 	.				  Min  Max
		  * 	.		}--->%M = [0 , M-1]
		  * 	.
		  * 	.
		  * +infinity
		  * 
		  * Rules for % Arithmetic : {+,-,*,/}
		  * 
		  * 1) (a+b)%m = (a%m + b%m)% m
		  *    [0,m-1]	 [0 m-1]+[0 m-1]= [0,2m-2]%m=[0,m-1]
		  *    
		  * eg: a=9,b=8,m=5
		  * 
		  * 	(9+8)%5 = (9%5 + 8%5)%5
		  * 	(17)%5	= ( 4  +  3 )%5 
		  * 	  17%5	=	  7%5	
		  * 		2		   2	
		  * 2) (a*b)%m = (a%m + b%m)%m
		  * 
		  * 3) (a+m)%m = (a%m + m%m)%m
		  * 		   = (a%m +  0)%m
		  * 		   = (a%m)%m --> a%m  (a%m)%m = {0...m-1}%m = {0....m-1}
		  *    (a+m)%m = a%m
		  * 
		  * Note : When There is %m outside, adding m inside brackets
		  * 	   won't effect your final computation.
		  * 
		  * 4) (a-b)%m = (a%m - b%m + m)%m
		  *    [0 m-1]	 [0 m-1] - [0 m-1] = [ -(m-1)m-1]+m = [1...2m-1]%m = [0...m-1]
		  *    
		  * 5) (a^2)%m = (a*a)%m
		  * 		   = (a%m * a%m)%m
		  * 		   = (a%m)^2%m
		  *    (a^b)%m = (a%m)^b % m
		  *  Note : We can take % to base.
		  *  
		  * Properties :
		  * -----------
		  * 1) (a+b)%m = (a%m + b%m)%m
		  * 
		  * 2) (a*b)%m = (a%m * b%m)%m
		  * 
		  * 3) (a+m)%m = a%m
		  * 
		  * 4) (a%m)%m = a%m
		  * 
		  * 5) (a-b)%m = (a%m - b%m + m)%m
		  * 
		  * 6) (a^b)%m = (a%m)^b % m
		  *  
		  */
		
		// 1Q) Given Array Ele FInd COunt of Pairs such That
		// 	   (arri[i]+arr[j])%m=0
		// Note : i!=j and pair(i,j) same as pair(j,i)
		
		/* Eg : ar[] = { 4,3,6,3,8,12 };
		 * 
		 * M = 6 	   ( ar[i]+ar[j] )%M = 0
		 * 			   ( ar[1]+ar[3] )%6 = 0	6%6=0
		 * 			   ( ar[0]+ar[4] )%6 = 0	12%6=0
		 * 			   ( ar[2]+ar[5] )%6 = 0	18%6=0 
		 */
		
		// Idea-1 : For Every Pair(i,j) calculate & check
		
		/* if((ar[i]+ar[j])%m==0){c++ ;}
		 * {
		 * 		i=0--->N-1;
		 * 						} Generate All Pairs
		 * 			j=i+1--->N-1;
		 * 
		 */
		
		// Idea-2 : (ar[i]+ar[j])%m=0
		/*
		 * 			{
		 * 					(ar[i]%m +ar[j]%m)%m=0
					}
		 * 
		 * eg : A[] = { 2,3,4,8,6,13,5,12,24,16,18 };
		 * 
		 * A[i]=A[i]%m = [0  M-1] = [0...5]
		 * 
		 * A[] = { 2,3,4,2,0,1,5,0,0,4,0 };
		 * 
		 * eg : M=6		obs : ( ar[i]%m + ar[j]%m )%m
		 * 					  ( 	2	+	 4	  )%6 = 0
		 * 					  (		1	+	 5	  )%6 = 0
		 * 					  (		3	+	 3	  )%6 = 0
		 * 
		 * Note :
		 * 
		 * This express 	  (		k	+	 M-K  )%M = 0
		 * fails k=0		  (		0	+	  0	  )%M = 0
		 * 
		 * case-1 : ar[i]%m = 0 --> ar[j]%m = 0
		 * 
		 * case-2 : ar[i]%m = k --> ar[j]%m = m-k
		 * 
		 * A[i] = A[i]%M
		 * 
		 */
		// Frequency Array
		int ar[]={2,3,4,2,0,1,5,0,0,4,0};
		
		int ans=pairs(ar,6);
		System.out.println("Pairs : "+ans);
		
		/* GCD Basics 
		 * 
		 * GCD(A,B) = HCF(A,B)
		 * 
		 * GCD(A,B) = Greatest Common Divisor of A,B
		 * 
		 * Eg :
		 * 
		 * GCD(15,25)
		 * 		|  |
		 * 		1  1
		 * 		3  5-->GCD
		 * 		5  25
		 * 		15
		 * Eg :
		 * 
		 * GCD(0,4)
		 * 	   | |
		 * 	   1 1
		 * 	   2 2
		 * 	   3 4
		 * 	   4 .
		 * 	   . .
		 * 	   .
		 * 	   .
		 *   infinity
		 *   
		 * Eg :
		 * 
		 * GCD(0,0) =infinity
		 * 
		 * Eg :
		 * 
		 * GCD(4,7) = 1
		 * 	   | |
		 * 	   1 1
		 * 	   2 7
		 * 	   4
		 * 
		 * 
		 * Properties :
		 * 
		 * 1) GCD(A,B) = GCD(B,A)
		 * 
		 * 2) GCD(0,A) = A
		 * 
		 * 3) GCD(A,B,C) = GCD( GCD(A,B),C)
		 * 				 = GCD( GCD(B,C),A)
		 * 				 = GCD( GCD(A,C),B)
		 * 
		 * Note : When More than 2 numbers are there, take gcd for 2-numbers at Once.
		 * 
		 * 4) GCD(A,B) = GCD(A-B,B)
		 * 
		 * 5) GCD(A,B) = GCD(A%B,B)--> We Can do it with Recursion
		 * 		|
		 * 		----> Issue with above relation :
		 * 
		 * Eg : GCD(24,10)-----> GCD(4,10)---> Recursion Stops : A<B.
		 * 
		 * 5a) GCD(A,B) = GCD(B,A%B)
		 * 
		 */
		
		// Q2) Given A,B calculate GCD(A,B)
		// Ass : Function GCD(A,B) will calculate & return GCD.
		
		int ans1=gcd(24,10);
		System.out.println("GCD : "+ans1);
		
		// Q3) Given an Array Calculate GCD of Array
		
		// Eg : ar[] = {12,24,6,15};
		/*		ans	 =  12
		 * 				   12
		 * 					  6
		 * 						3 : Ans	
		 */
		int ar1[]= {12,24,6,15};
		
		int ans2=gcdArray(ar1);
		System.out.println("Array GCD : "+ans2);
		
	}

	private static int gcdArray(int[] ar1) 
	{
		 int n=ar1.length;
		 int ans=ar1[0];
		 for(int i=1;i<n;i++)
		 {
			ans=gcd(ans,ar1[i]); 
		 }
		 return ans;
	}

	private static int gcd(int A, int B) // T.C = O(log^max(A,B)
	{									 // S.C = O(log^max(A,B)
		if(B==0)// Note Even if A<B code works
		{
			return A;
		}
		return gcd(B,A%B);
	}

	private static int pairs(int[] ar, int m) // T.C = O(N+N) = O(N)
	{										  // S.C = O(M)
		int n=ar.length;
		
		for(int i=0;i<n;i++)
		{
			ar[i]=ar[i]%m;
		}
		
		int cnt[]=new int[m];
		int ans=0;
		
		for(int i=0;i<n;i++)
		{
			int k=ar[i];
			int target=m-k;
			if(k==0)//k==3
			{
				target=0;
			}
			ans=ans+cnt[target];
			cnt[ar[i]]++;
		}
		return ans;
		
	}

}
