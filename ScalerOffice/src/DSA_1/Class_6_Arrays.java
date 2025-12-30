package DSA_1;

public class Class_6_Arrays 

{



	public static void main(String[] args) 

	{

		/* Revision :

		 * 

		 * 1) Subarray : Continuous part of an Array.

		 * 

		 * 2) Valid Subarray : A[]={2,4,1,6,-3,7,8,4};

		 * 

		 * 3) Total Subarrays : N*(N+1)/2

		 *  

		 */

		

		// Q) Calculate & Return Total of All Subarray Sums.

		//				0 1 2

		/* eg : Ar[3]= {3,4,2}; 

		 * 

		 * Subarrays :

		 * 					  Sums	

		 * [0,0]	{3}------>[3]

		 * [0,1]	{3,4}---->[7]

		 * [0,2]	{3,4,2}-->[9]

		 * [1,1]	{4}------>[4]

		 * [1,2]	{4,2}---->[6]

		 * [2,2]	{2}------>[2]

		 * 

		 * 			Total =	  31

		 *   

		 */

		

		// Idea-1 :

		//		   For Every Subarray iterate & get sum & add it in Total.

		int ar[]= {3,4,2};

		int ans=SubSum(ar);

		System.out.println(ans);

		

		// Idea-2 :

		//		   Construct PrefixSum[] & get Sum of each Subarray from [s...e] using pf[]

		int ans2=SubSum2(ar);

		System.out.println(ans2);

		

		// Idea-3 : Optimization Idea :

		// In Question, if we see words like Sum of All

		// Technique : Contribution Technique = Adding Contribution of individual element in Final Ans.

				/* 

				 * [0,0]	{3}------>		Q: Sum of all Subarray Sums.

				 * [0,1]	{3,4}---->		

				 * [0,2]	{3,4,2}-->		Contribution :

				 * [1,1]	{4}------>		Ele		Occurance		Contribution

				 * [1,2]	{4,2}---->		 3	 *		3		=		9

				 * [2,2]	{2}------>		 4	 *		4		=		16

				 *							 2   *		3		=		6

				 * 							-------------------------------

				 * 							 Total Sum			=		31

				 */	

		

		/* Catch : To Calculate Contribution for an Ele

		 * 

		 * We need to calculate it's Occurences : no: of times element considered

		 * 

		 * In This Question : Occurences : In no:of Subarrays an Ele is Present.

		 * 

		 * Q) In how many subarrays a particular index will be present

		 * 

		 * eg : Ar[6]={3,-2,4,-1,2,6}

		 * 		Start= /  / x  x x x	

		 * 		End	 = x  / /  / / /

		 * 

		 * In how many subarrays index-1 is Present

		 * 

		 * StartIndex & EndIndex		TotalSubarrays

		 * 									

		 * 			0	 	 1			s=2, e=5 ==> Total Subarrays with index 1= 10

		 * 			1	*	 2			{0 1},{0 2},{0 3},{0 4},{0 5}

		 * 					 3			{1 1},{1 2},{1 3},{1 4},{1 5}

		 * 					 4		

		 * 					 5			Total = 2*5= 10-Subarrays

		 * 

		 * Final Observation :

		 * 					  In Array[N] in how many subarrays index i is present.

		 * 

		 * 			0	1	2	3			i-1	   i   i+1 	   i+2			n-2	   n-1

		 * Ar[N] : {a0, a1, a2, a3 . . . .a(i-1) a(i) a(i+1) a(i+2). . . .a(n-2) a(n-1)}

		 * 

		 * Start =  /	/	/	/	/	/	/	  /		x		x			x		x

		 * end	 =  x	x	x	x	x	x	x	  /		/		/			/		/

		 * 

		 * 

		 * Start =[0	i]= i-0+1 = i+1

		 * End	 =[i   N-1]=N-1-i+1	= N-i

		 * 

		 * In how many subarrays index i is present = (i+1)(N-i)

		 * 

		 * Trace :

		 * 					0	1	 2	 3	

		 * N=4		Ar[4]={ 2	8	-1	 4 }

		 * 

		 * (i+1)(N-i)	  { 4	6	 6	 5

		 * 

		 */

		int ans3=SubSum3(ar);

		System.out.println(ans3);

		

		/* Note :

		 * 

		 * In any Question Sum of All-------?

		 * 

		 * We prefer Contribution

		 * 

		 * Contribution = Sum of Contribution of each Element

		 * 						  |

		 * 						  ------> Ele * Occurences

		 * 

		 * for(int i=0;i<n;i++)

		 * {

		 * 		total=total+ar[i]*Occurences -------> Depends on Problem Statement

		 * }

		 * 

		 */

		

		// Q) Given Array[N] ,return no:of Subarrays of Len=k

		//	  Total number of Subarrays of len=k

				

		/*  eg :

		 * 

		 * ar[6]= {a0, a1, a2, a3, a4, a5}

		 * k=3

		 * 

		 * {a0 a1 a2} {a1 a2 a3} {a2 a3 a4} {a3 a4 a5}

		 * 

		 * For Array[N] Elemenst, How Many Subarrays of Len=k, ---> N-K+1

		 *  

		 */

		

		// Q) Given Array[N] elements K, return MaxSubarraySums of Len=k

		// Constraints :							 |

		//											 -----> Consider Subarray of Len=k

		// 1<=N<=10^5

		

		int arr[]= {-3,4,-2,5,3,-2,8,2,-1,4};

		int k=5;

		

		/* S		E		Sum

		 * 0		4		 7

		 * 1		5		 8

		 * 2		6		 12

		 * 						} Ans=16

		 * 3		7		 16

		 * 4		8		 10

		 * 5		9		 11

		 * 6		10---*Error

		 * 

		 */

		

		/* Idea-1 :

		 * 

		 * For all Subarrays of len=k, Calculate Sum & get overall Max.

		 *  

		 */

		int ans4=MaxSub(arr,k);

		System.out.println("MaxSubArray : "+ans4);

		

		// Optimization : It can be done with psum[]
		
		int ans5=MaxSub2(arr,k);
		System.out.println("MaxSubArray-2: "+ans5);

		// Optimization Idea :
		/* In Any Question whenever we see fixed subarray size term
		 * 
		 * Technique : Sliding Window
		 * 
		 * k=6		  0	 1	 2  3  4   5  6  7  8  9 
		 * ar[10] = { 3, 4, -2, 5, 3, -2, 8, 2, 1, 4};
		 * 
		 * s	e
		 * 0	5 Sum=11 : {iterate & get 1st SUbarray Sum}
		 *
		 * Apply Sliding 
		 * 
		 * 1	6	sum=sum-ar[0]+ar[6] = 11-3+8 = 16
		 * 2	7	sum=sum-ar[1]+ar[7] = 16-4+2 = 14
		 * 3	8	sum=sum-ar[2]+ar[8] = 14-(-2)+1 = 17 } Max=17
		 * 4	9	sum=sum-ar[3]+ar[9] = 17-5+4 = 16
		 * 
		 * s	e	sum=sum-ar[s-1]+ar[e]
		 * 
		 */
		int ans6=MaxSubSlidingW(arr,k);
		System.out.println("MaxSubArray-Sliding Window: "+ans6);

	}



	private static int MaxSubSlidingW(int[] arr, int k) // T.C = O(N)
	{													// S.C = O(1)
		 int n=arr.length;
		 int ans=Integer.MIN_VALUE;
		 int sum=0;
		 // Step-1 : Calculate 1st Subarray Sum ---> {0 k-1}
		 for(int i=0;i<k;i++)							
		 {									
			 sum=sum+arr[i];
		 }
		 if(sum>ans)
		 {
			 ans=sum;
		 }
		 // Step-2 : For remaining subarrays using previous sum :{1 k} Sliding Window
		 
		 int s=1,e=k-1;
		 while(e<n)
		 {
			 sum=sum-arr[s-1]+arr[e];
			 if(sum>ans)
			 {
				 ans=sum;
			 }
			 s++;
			 e++;
		 }
			 
		return ans;	 
	}



	private static int MaxSub2(int[] arr, int k) // T.C= O(N+N)= O(N)
	{											 // S.C= O(N)
		 int n=arr.length;
		 
		 int psum[]=new int[n];
		 int sum=0;
		 for(int i=0;i<n;i++)
		 {
			 sum=sum+arr[i];
			 psum[i]=sum;
		 }
		 
		 int s=0,e=k-1;
		 int max=Integer.MIN_VALUE;
		 
		 while(e<n)
		 {
			 int su=0;
			 if(s==0)
			 {
				 su=su+psum[e];
			 }
			 else
			 {
				 su=su+psum[e]-psum[s-1];
			 }
			 if(su>max)
			 {
				 max=su;
			 }
			 s++;e++; // Go to next Subarray
		 }
		 return max;
	}



	private static int MaxSub(int[] arr, int k) // T.C = O(N-k+1)*O(K)

	{ 								// SubArray Length : k=1 ---> O(N-1+1)*O(1)= O(N)

		int max=Integer.MIN_VALUE;  // 					 k=N ---> O(N-N+1)*O(N)= O(N)

		int s=0,e=k-1;				// 					 k=N/2--> O(N-N/2+1)*(O(N/2)= O(N/2)*O(N/2)= O(N^2)

		int n=arr.length;			// S.C = O(1)

		while(e<n)					// Note : To get Worst case scenario, try k with smallest, largest,center value.

		{

			int sum=0;

			for(int i=s;i<=e;i++)

			{

				sum=sum+arr[i];

			}

			if(sum>max)

			{

				max=sum;

			}

			s++; // Go to next Subarray

			e++;

		}

		return max;

	}



	private static int SubSum3(int[] ar) // T.C = O(N)

	{ 									 // S.C = O(1)

		int n=ar.length;

		int sum=0;

		for(int i=0;i<n;i++)

		{

			int s=i+1,e=n-i;

			int Con=s*e;// ar[i] comes in C-Times

			sum=sum+ar[i]*Con;			

		}

		return sum;

	}



	private static int SubSum2(int[] ar) // T.C = O(N)+O(N^2)*O(1)= O(N^2)

	{ 									 // S.C = O(N)

		int n=ar.length;

		int psum[]=new int[n];

		int sum=0;

		int ans=0;

		for(int i=0;i<n;i++)

		{

			sum=sum+ar[i];

			psum[i]=sum;

		}

		for(int s=0;s<n;s++)

		{

			for(int e=s;e<n;e++)

			{

				if(s==0)

				{

					ans=ans+psum[e];

				}

				else

				{

					ans=ans+psum[e]-psum[s-1];

				}

			}

		}

		return ans;

	}



	private static int SubSum(int[] ar) // T.C= O(N^2)*O(N)= O(N^3)

	{									// S.C= O(1)

		 int n=ar.length;

		 int sum=0;

		 for(int s=0;s<n;s++)

		 {

			 for(int e=s;e<n;e++)

			 {

				 // Subarray [s...e]

				 int ans=0;

				 for(int i=s;i<=e;i++)

				 {

					 ans=ans+ar[i];

				 }

				 sum=sum+ans;

			 }

			 

		 }

		 return sum;

	}



}
