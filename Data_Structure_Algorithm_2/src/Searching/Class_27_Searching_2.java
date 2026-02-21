package Searching;

public class Class_27_Searching_2 
{

	public static void main(String[] args) 
	{
		
		/* Binary Search
		 * 
		 * a) Target : What are we Searching
		 * 
		 * b) SearchSpace : Where are we Searching
		 * 
		 * c) Discard : Can we Discard Search Space or not ?
		 * 
		 * 
		 * Pre-Requistes :
		 * 
		 * Q) Sorted Array : { 3,9,14,16,20,28,35,40,49 };
		 * 
		 * Given K, Can K be Present in Array or Not ?
		 * 
		 * k		{ min	max }	chance
		 * 16		   3	49		with in Range : Yes
		 * 25		   3	49		with in Range : Yes
		 * 60		   3	49		Not present in Range
		 * .		   .	 .		.	.	.	.	.	.
		 * K		  min	max		[ min <= K <=max : K can be Present ]
		 * 
		 * 
		 * Revision :
		 * 
		 * Q) Given Array Rotate Array Right to Left by k-Times
		 * 
		 * k=4,
		 * 							   <
		 * A0	A1	A2	A3	.	.	A9	 A10	A11	A12
		 * 
		 * After Rotation
		 * 
		 * A10	 A11	A12 	A13  >	A0	A1	A2	A3	.	.A9
		 * 
		 * 
		 * Observation : If we Rotate Sorted , We Will get 2-Sorted Halfs.
		 *  
		 */
		
		/* Q1) Given an input Array ,formed by Rotating a Distinct Sorted Array Right to Left by Some no: of Times.
		 * 
		 * Search Element & Return index in input Array, If Element is not present return -1.
		 * 
		 * Idea-1 : Iterate an Array & Search 
		 * 
		 * T.C = O(N)
		 * S.C = O(1)
		 * 
		 * 
		 * Idea-2 :
		 * 
		 * Target : Element
		 * 
		 * Search Space : In Array
		 * 
		 * Discard : Half of Array
		 * 
		 */
		
		int ar[]= {16,17,18,20,1,3,5,6,8,9,10,11,13,14};
		int k=18;
		
		int ans=SearchRotated(ar,k);
		System.out.println("Element is present at Position : "+ans);
		
		// Q2) Given +ve Find SQRT(N)
		
		/* Find Greatest i such that i*i<=N
		 * 
		 * SQRT(25) : 5
		 * 
		 * SQRT(37) : 5*5 <= 37
		 * 			  6*6 <= 37	--> Ans=6;
		 * 
		 * 			  7*7 <= 37---> ***Error
		 *  
		 */
		
		// Idea-1 : Iterate an Array and get Answer
		int ans1=sqrt1(30);
		System.out.println("Squre Root of a Given No is : "+ans1);
		
		// Idea-2 : Using Binary Search
		
		/* 1) Target : Find Greatest i such that i*i<=N
		 * 
		 * 2) SearchSapce : Range which guarantee contains our Answer
		 * 	  
		 * 	  AnswerSpace : Note : This Can be Real or Imaginary
		 * Eg : SearchSpace : [1.....N]
		 * 
		 * Constraints  : 1<=N<=10^9
		 * 
		 * 3) Discard ?
		 *  
		 * Note : On how many elements we are Applying BS : N
		 * 
		 * Note :
		 * 
		 * For 2+ve Numbers A,B
		 * 
		 * A*B = GCD(a,b) * LCM(a,b)
		 * 
		 * LCM(a,b) = A*B / GCD(a,b)
		 * 
		 */
		int ans2=sqrt2(30);
		System.out.println("Squre Root of a Given No is : "+ans2);
		
		// Q) A^th Magical Number :
		
		// Number of Multiples of 2 from 1 to 100 = 2	4	6	8	.	.	100 : 100/2 =50
		
		// Number of Multiples of 6 from 1 to 50  = 6	12	18	24			50	: 50/6 =8
		
		// Number of Multiples of 4 or 6 from 1 to 50 = 50/4 + 50/6 = 12+8 = ?
		
		/* 
		 * 4 : 4	8	12	16	20	24	28	32	36	40	44	48
		 * 
		 * 6 : 6	12	18	30	36	42	48
		 * 
		 * 
		 * Issue : If Number is Divisible By Both 4 & 6
		 * 
		 * 		   1^st Number Divisible By 4 & 6
		 * 		
		 * 		   LCM(4,6) = 12 : 12 24 36	48
		 * 
		 * ==> Multiples of LCM are Considered Twice :
		 * 
		 * Final Ans = Multiple of 4 still 50 + Multiple of 6 still 50 - { Multiple of 12 till 50 }
		 * 
		 * 			 = 12	+	8	-	4 = 16.			
		 * 
		 * 
		 * Observation :
		 * 
		 * Number of Multiples of A or B from 1 to C = C/A + C/B - C/LCM(A,B)
		 * 
		 * Cal : Multiples of A till C = C/A
		 * 		 Multiples of B till C = C/B
		 * 	 -	 Multiples of LCM(A,B) till C = C/LCM(A,B)
		 * 
		 */
		
		/* Q3) Given A,B, K find K^th Magical Number
		 * 
		 * Magical Number : It is Divisible by A or B or Both
		 * 
		 * Note : Final Ans % [10^9+7] & Return
		 * 
		 * Eg : 
		 * 
		 * A	B	K	=>	1^st	2^nd	3^rd	4^th	5^th	6^th
		 * 
		 * 4	6	6   =>	 4		 6		 8		 12		 16		 18		Ans=18
		 * 
		 * 
		 * Eg :
		 * 
		 * A	B		K	=>	1	2	3	4	5	A*K
		 * 
		 * 2	100		5	=>  2	4	6	8	10	10
		 * 
		 * Eg :
		 * 
		 * A	B		K	=>	1	2	3	4	B*K
		 * 
		 * 100	3		4	=>	3	6	9	12	12
		 * 
		 * 
		 * Observation : At Worst we need to go till Min(A,B)*K, We Might find Answer Before
		 *  
		 */
		
		/* Idea-1 : Keep iterating on Numbers till we get k^th Magical Number
		 * 
		 */
		
		int ans3=Magical(2,100,5);
		System.out.println(" A^th Magical Number : "+ans3);
		
		/* Idea-2 : Binary Search
		 * 
		 * 1) Target = K^th Magical Number
		 * 
		 * 2) SearchSpace = [1........Min(A,B)*K]
		 * 
		 * 3) Discard ?
		 * 
		 * 	  Calculate Total Magical/Multiple Numbers of A or B till [1....M] = C
		 * 
		 * 	  C = M/A + M/B - M/LCM(A,B)
		 * 
		 * 
		 * Note : Number of Multiples of A or B from 1 to M = M/A + M/B - M/(LCM(A,B));
		 * 
		 * Note : A*B = LCM(A,B) * GCD(A,B);
		 * 
		 * 		 LCM(A,B) = A*B/GCD(A,B);
		 * 
		 */
		int ans4=Magical2(2,100,5);
		System.out.println(" A^th Magical Number Optimization : "+ans4);
		
		
		 
	}

	private static int Magical2(int A, int B, int k) // T.C = O(log^min(A,B)*k)
	{												 // S.C = O(1)
		int l=1,h=Math.min(A,B)*k;
		
		int LCMAB=(A*B)/GCD(A,B);
		
		int ans=h;
		
		while(l<=h)
		{
			int m=(l+h)/2;
			
			// Calculate no:of Magical/Multiple of A or B till [1....M]
			
			int c=m/A+m/B-m/LCMAB;
			
			if(c<k)
			{
				l=m+1;
			}
			else if(c>k)
			{
				h=m-1;
			}
			else
			{
				ans=m;
				h=m-1;
			}
			
		}
		return ans;
		
	}

	private static int GCD(int a, int b) // T.C = O(log(min(a,b))
	{									 // S.C = O(log(min(a,b))
		if(b==0)
		{
			return a;
		}
	  return GCD(b,a%b);
	}

	private static int Magical(int A, int B, int k) // T.C = O(Min(A,B)*k);
	{												// S.C = O(1)
		 int c=0;
		 
		 for(int i=1;i<=Math.min(A, B)*k;i++)
		 {
			 if(i%A==0 || i%B==0)
			 {
				 c++;
			 }
			 
			 if(c==k)
			 {
				 return i;
			 }
		 }
		 return -1;// Just to Avoid Error
	}

	private static int sqrt2(int n) // T.C = O(log N)
	{								// S.C = O(1)
		int l=1,h=n,ans=1;
		
		while(l<=h)
		{
			int m=(l+h)/2;
			
			if((m*m)<=n)
			{
				ans=m;
				l=m+1;
			}
			else
			{
				h=m-1;
			}
		}
		return ans;
		 
	}

	private static int sqrt1(int n) // T.C = O(SQRT(N))
	{								// S.C = O(1)
		int i=1,ans=1;
		while(i*i<=n)
		{
			ans=i;
			i++;
		}
		return ans;
		 
	}

	private static int SearchRotated(int[] ar, int k) // T.C = O(log N)
	{												  // S.C = O(1)
		 int l=0;
		 int h=ar.length-1;
		 
		 while(l<=h)
		 {
			 int m=(l+h)/2;
			 
			 if(ar[m]==k)
			 {
				 return m;
			 }
			 
			 if(ar[m]>=ar[l])// 1^st Half [l...m] is Sorted
			 {
				 if(k>=ar[l] && k<=ar[m])
				 {
					 h=m-1;// In Range
				 }
				 else
				 {
					 l=m+1;// Not In Range
				 }
			 }
			 else// 2^nd Half [m...h] is Sorted
			 {
				 if(k>=ar[m] && k<=ar[h])// ar[m] ...Ele..ar[h]
				 {
					 l=m+1;// In Range
				 }
				 else
				 {
					 h=m-1;// Not In Range
				 }
			 }
		 }
		 return -1;
	}

}
