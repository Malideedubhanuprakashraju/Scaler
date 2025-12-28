package Carry_Forward_Subarrays;

public class Class_5_Carry_Forward 
{

	public static void main(String[] args) 
	{
		/* Revision
		 * 
		 * 1) PrefixSum
		 * 
		 * 2) Sum of Elements from {L....R} : psum[R]-psum[L-1]
		 * 
		 * 3) T.C for a Single Query using psum[] : T.C=O(1)
		 * 
		 */
		
		/* CarryForward Idea :
		 * 
		 * If we have to calculate a same data from L-R or R-L multiple times, Use carryforward & calculate data in 1-short from direction we are calculating.
		 *  
		 */
		
		/* 1Q) Count Pairs 'ag'
		 * 
		 * Given a char ch[N], calculate no of pairs indices= i,j such that 
		 * i<j && ch[i]=='a' && ch[j]=='g' All Characters are Lower Case
		 * 
		 * Constraints :
		 * 
		 * 1 <= N <= 10^5
		 * 
		 */
		
		//			0	1	2	3	4	5	6	7
		/* ch[8]=	b	a	a	g	d	c	a	g
		 * 
		 * Pairs : (i,j)
		 * 
		 * (1,3) (1,7) (2,3) (2,7) (6,7) 
		 * 
		 * Ans=5
		 * 
		 */
		
		/* Idea : i<j && ch[i]=='a' && ch[j]=='g'
		 * 
		 * 			0	1	2	3	4	5	6	7	8
		 * ch[9] =	a	d	g	a	g	a	g	f	g
		 * 			i	-	-	-	-	-	-	-	-	-> 4
		 * 				i	i	i	-	-	-	-	-	-> 3
		 * 							i	i	-	-	-	-> 2
		 * 									i	i	i	-> Total =9
		 * 
		 * For Every ch[i]=='a'
		 * 				|
		 * 				-----> Iterating on Right Side & Counting no of g's
	 	 *
		 */
		char ar[]= {'a','d','g','a','g','a','g','f','g'};
		int ans=pairs1(ar);
		System.out.println("Count Pairs Bruit Force "+ans);
		
		// Optimisation Idea :
		// 1) Calculate no of g's from right in 1-shot
		// 2) ans=0,	cg=0
		
		/* 		   0	1	 2		3		4		5		6		7		8	
		 * ch[9]={ a,	d,	 g,		a,		g,		a,		g,		f,		g };
		 * 		 ans+=cg   cg++   ans+=cg  cg++  ans+=cg	cg++		   cg++
		 * 		 ans=9	   cg=4	  ans=5	   ch=3	 ans=2		cg=2		   cg=1
		 * 
		 * Final Ans=9
		 * 	
		 */
		 int ans1=pairs2(ar);
		 System.out.println(ans1);
		 
		 /*
		  *  Sub Array Concept :
		  *  
		  *  Contnuous part of an Array is considered as Subarray
		  *  
		  *  Note-1 : Single Ele is also considered as Subarray.
		  *  Note-2 : Complete Array is considered as Subarray.
		  *  Note-3 : Subarray is considered from Left-->Right.
		  *  
		  *  Represent a Subarray :
		  *  
		  *  1) Start-index & end-index :
		  *  
		  *  eg : ar[ ] = { 4, 1, 2, 3, -1, 6, 9, 8, 12 };
		  *  
		  *  s		e		subarray
		  *  3		6   :	3,-1,6,9
		  *  2		7   :   2,3,-1,6,9,8
		  *  
		  *  2) Start-index & Length
		  *  
		  *  eg : ar[ ] = { 4, 1, 2, 3, -1, 6, 9, 8, 12 };
		  *  
		  *  s		l		subarray
		  *  3		5	:	3,-1,6,9,8
		  *  2		3	:	2,3,-1
		  *  
		  *  			  0	 1	2   3   4    5	6	
		  *  Q) ar[ ] = { 4, 2,	10,	3,	12,	-2,	15};
		  *  
		  *  Subarrays : 7
		  *  [S		e] :
		  *  
		  *  {0		0}=	4
		  *  {0		1}=	4,2
		  *  {0		2}=	4,2,10
		  *  {0		3}=	4,2,10,3
		  *  {0		4}=	4,2,10,3,12
		  *  {0		5}=	4,2,10,3,12,-2
		  *  {0		6}=	4,2,10,3,12,-2,15
		  *  
		  */
		 
		 /* Total Count of Subarrays ?
		  * 		 0	1	2	3
		  * ar[4]= { 4,	2,	10,	3};
		  * 
		  * All Subarrays :
		  * 
		  * [0,0]={4}			[1,1]={2}		 [2,2]={10}		[3,3]={3}
		  * [0,1]={4,2}			[1,2]={2,10}	 [2,3]={10,3}
		  * [0,2]={4,2,10}		[1,3]={2,10,3}
		  * [0,3]={4,2,10,3}
		  * 
		  * Total Count of Subarrays= 4+3+2+1=10
		  * 
		  * If Array[N] :
		  * 			Total Subarrays= N+N-1+N-2+....1
		  * 						   = N*(N-1)/2;
		  *  
		  */
		 
		 // Q) Given Start index & end Print Subarray :
		 
		 int arr[]= {4,1,2,3,-1,6,9,8,12};
		 
		 // Idea : Iterating from S to E print it.
		 
		 printSub(arr,2,4);
		 
		 // Q) Given Array[N] elements print All Subarrays.
		 // Note : Print each Subarray in New Line.
		 
		 int a[]= {2,8,-1,4};
		 
		 // Idea : Generate All [S & E] of Subarray & print each Subarray.
		 System.out.println();
		 System.out.println("All Sub");
		 printSubAll(a);
		/*
		 * For each subarray, you’re printing up to O(N) elements.

		   👉 Total work = O(N² × N) = O(N³)

		   So any solution that prints every element of every subarray must be O(N³). No algorithm can beat that.
		 * 
		 */
		 
		 // Q) Given an Array[N]
		 // Return length of smallest subarray which contains both min & max of Array.
		 
		 /* eg : Ar[]={ 1,2,3,1,3,4,6,4,6,3};
		  * 				  <----->
		  * min=1 , max=6
		  * 
		  * 
		  * Idea-1: 
		  * 
		  * 1) Iterate & get Min & Max :
		  * 2) In Subarray :
		  * 			    Iterate & check if both Min & Max are present.
		  * If bith are present get length of subarray & get overall min.
		  * 
		  * T.C= O(N^2)*N= O(N^3)
		  * S.C= O(1)
		  * 
		  * Idea-2:
		  * 
		  * Let's say we iterated on Array & got min & max
		  * 
		  * Observation-1: Max & Min should be at opposite corners of subarray.
		  * 
		  * Con : Calculate min & max of Array
		  * 	  Iterate on Array
		  * 			if ar[i]==max : iterate on right & search min & index
		  * 			if ar[i]==min : iterate on right & search max & index
		  * 	  Now get subarray length & get overall min.
		  * 
		  * T.C= O(N^2)
		  * S.C= O(1)
		  * 
		  * Idea-3:
		  * 
		  * Carry Forward min Value index & Max Value index from right & update length to get overall min.
		  * 
		  * 				  0	 	1	 2  	 3  	 4  	 5  	 6  	 7  	 8  	 9 		10
		  * Dry Run : A[ ]= { 2,	1,	 6,		 4,		 5,		 1,		 5,		 2,		 6,		 4,		 1};  minI=1, maxI=6;
		  * 					 minI=1 maxI=2 			 	    minI=5					maxI=8		  minI=10
		  * 					 len=2  len=4					len=4					 len=3			No max right
		  * 
		  * Ans=2;
		  * 
		  */
		 int br[]= {2,1,6,4,5,1,5,2,6,4,1};
		 int anss=minSub(br);
		 System.out.println();
		 System.out.println(anss);
		 
	}

	private static int minSub(int[] br) // T.C= O(N+N)
	{ 									// S.C= O(1)
		int n=br.length;
		int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			if(br[i]>max)
			{
				max=br[i];
			}
			if(br[i]<min)
			{
				min=br[i];
			}
		}
		if(max==min)
		{
			return 1; // Not needed, code works
		}
		int minI=-1,maxI=-1,ans=n;
		
		for(int i=n-1;i>=0;i--)
		{
			if(br[i]==max)
			{
				maxI=i;
				if(minI!=-1)
				{
					ans=Math.min(ans,minI-maxI+1);
				}
			}
			
			if(br[i]==min)
			{
				minI=i;
				if(maxI!=-1)
				{
					ans=Math.min(ans,maxI-minI+1);
				}
			}
		}
		return ans;
	}

	private static void printSubAll(int[] a) // T.C =O(N^2)*(N) = O(N^3)
	{										 // S.C =O(1)
		 int n=a.length;
		 for(int s=0;s<n;s++)
		 {
			 //Subarray Start at index=s
			 
			 for(int e=s;e<n;e++)
			 {
				 //Subarray [s...e]
				 for(int i=s;i<=e;i++)
				 {
					 System.out.print(a[i]+" ");
				 }
				 System.out.println();
			 }
		 }
	}

	private static void printSub(int[] arr, int s, int e) 
	{ 
		for(int i=s;i<=e;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

	private static int pairs2(char[] ar) // T.C =O(N)
	{ 									 // S.C	=O(1)
		int n=ar.length;
		int ans=0,cg=0,c=0;
		for(int i=n-1;i>=0;i--)
		{
			if(ar[i]=='g')
			{
				cg++;
			}
			else if(ar[i]=='a')
			{
				ans=ans+cg;
			}
		}
		return ans;
	}

	private static int pairs1(char[] ar) // T.C =O(N^2)--->TLE
	{ 									 // S.C	=O(1)
		int n=ar.length;
		int ans=0;
		for(int i=0;i<n;i++)
		{
			if(ar[i]=='a') // Iterate on Right side of i & Count no og g's
			{
				int c=0;
				for(int j=i+1;j<n;j++)
				{
					if(ar[j]=='g')
					{
						c++;
					}
				}
				ans=ans+c;
			}
		}
		return ans;
	}

}
