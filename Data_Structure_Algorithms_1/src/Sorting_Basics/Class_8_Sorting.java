package Sorting_Basics;

import java.util.Arrays;

public class Class_8_Sorting 
{

	public static void main(String[] args) 
	{
		 /* Sorting :
		  * 		 It is an arrangement of data in Increasing/Decreasing order based of some parameter of our choice.
		  * 
		  * eg:
		  * 	A[]={2,3,9,12,17,19};// Increasing order based on Array Value.
		  * eg:
		  * 	A[]={19,6,5,2,-1,-19};// Decresing order based on Array Value.
		  * 
		  * Why Sorting ?
		  * 		Sorting is essential for organizing, analyzing, searching and presenting data efficiently in various applications.
		  * 
		  * Searching Library ?
		  * 
		  * T.C : O(N log N)--> To Sort Arrays.
		  * 		     2
		  * 
		  * 1) Arrays.sort(arr);// To Sort Arrays.
		  * 2) Collections.sort(arr);// To Sort ArrayList.
		  * 
		  * Note : In Both above we will get in Increasing Order(Value of element).
		  *  
		  */
		
		/* Q1) Minimize cost to empty Array.
		 * 	   Given Array integers, objective is to minimize the total cost of emptying Array.
		 * 	   The cost of removing an element is defined as sum of all remaining elements in the array at the time of removal.
		 * 
		 * 			  0	 1  2
		 * eg1: ar[]={2, 1, 4};
		 * 
		 * Remove		cost
		 * 	 2		:	 7
		 * 	 4		:	 5
		 * 	 1		:	 1
		 * 
		 * Cost = 13.
		 * 
		 * 			  0	 1	2	3
		 * eg2: ar[]={3, 5, 1, -3};
		 * 
		 * Remove			Cost
		 * 	 5		  :		  6
		 * 	 3		  :		  1
		 * 	 1		  :		 -2
		 * 	 3		  :		 -3
		 * 
		 * Cost = 2.
		 * 
		 * 
		 * Idea :
		 * 
		 * ar[]={b, a, d, c};
		 * 
		 * Remove		:		Cost
		 * 	  a			:		 a+b+c+d
		 * 	  b			:		 b+c+d
		 * 	  c			:		 c+d
		 * 	  d			:		 d
		 * --------------------------------
		 * Cost			=	a+2b+3c+4d
		 *   |
		 *  Min : We need a>b>c>d So-----> Delete elements in Decreasing Order.
		 *  
		 *    
		 */
		int ar[]= {4,2,1};
		int ans=calculateCost(ar);
		System.out.println();
		System.out.println("Min-Cost : "+ans);
		int ans1=calculateCost1(ar);
		System.out.println("Min-Cost-2: "+ans1);
		
		// Q2) Noble Integers :
		// Given an Array of Distinct Elements, Find count of Nobel Integers.
		// An Array is Noble if Count of Elements smaller than Array is equal to Array
		// eg:
		// ar[]		= {1,-5,3,5,-10,4}
		// countLess= {2, 1,3,5,  0,4}
		// Ans=3.
		
		int a[]= {-3,0,2,5};
		
		/* Idea-1 : For Every Element :
		 * 			Iterate & Count no : of elements < arr[i] &==ar[i]: c=c+1;
		 *   
		 */
		int ans2=NobelInteger1(a);
		System.out.println("Nobel Integer 1 : "+ans2);
		
		/* Idea-2 : Sort in Increasing Order
		 * 
		 * int ar[]  = {1,-5,3,5,-10,4};
		 * 
		 * 				  0	 1 2 3 4 5
		 * Sort ar[] = {-10,-5,1,3,4,5};
		 * CountLess :	  0  1 2 3 4 5
		 * 
		 *  Obs : No of Elements < ar[i] =i - iteself.
		 *  
		 *  Reason : 0	1	2	3	.	.	i-1	<	i	i+1	.	. N-1
		 * 			a0< a1< a2< a3	.	. <ai-1 <  ai	ai+1 .  . an-1	
		 * 
		 * 			All Elements						  a  b	   b-a+1	
		 * 			from [0	i-1] <---> How many elements [0 i-1] : i-1-0+1 = i
		 * 			< ar[i]
		 * 
		 */
		
		int ans3=NobleInteger2(a);
		System.out.println("Nobel Integer 2 : "+ans3);
		
		// Q) Noble Integers {Elements can repeat}
		// An arr[i] is noble if count of elements smaller than arr[i] is equal to arr[i]
		
		/* eg:
		 * 		   		   0  1  2  3   4		
		 * ar[]	 	 =	{-10, 1, 1, 3, 100};
		 * CountLess =  {  0, 1, 1, 3,  4};
		 * 
		 * Obs : No : of elements < ar[i] =i ? {It is not matching in few cases}
		 * 									   {Because of repetition}
		 * 
		 * Obs-2 : For which all indices Count of elements < ar[i] =i?
		 * 		   
		 * 		 Con1 : For 1st Occurrence of each Element
		 * 			    Count of Elements < ar[i] = i ==> C=i
		 * 		 Con2 : When elements repeat :
		 * 				Count of Elements < ar[i], No Changes
		 * 
		 */
		int arr[]= {-3, 0, 2, 2, 5, 5, 5, 5, 8, 8, 10, 10, 10, 14};
		// Code for Repetition as well.
		int ans4=NobleInteger3(arr);
		System.out.println("Noble Integer 3 : "+ans4);
		
		/* Sorting Algorithm
		 * 
		 * Selection Sort : Iterate on Array & Bring elements to it's correct position.
		 * 					For Every index from 0.....N-1 : Get Correct Element to it's position.
		 * 
		 * i	0	1	2	3	4	 5	Iterate		MinVal	MinInd	Swap
		 * 0 :  7  12	6	4	9	10  [0	5]		   4	   3	Swap ar[min_ind] & ar[0]
		 * 1 :  4  12	6	7	9	10	[1	5]		   6	   2	Swap ar[min_ind] & ar[1]
		 * 2 :	4	6  12	7	9	10	[2	5]		   7	   3	Swap ar[min_ind] & ar[2]
		 * 3 :  4	6	7  12	9	10	[3	5]		   9	   4	Swap ar[min_ind] & ar[3]
		 * 4 :  4	6	7	9  12 	10	[4  5]		  10	   5	Swap ar[min_ind] & ar[4]
		 * 5 :  4	6	7	9  10	12----> Stop It
		 * 
		 */
		int sel[]= {7,12,6,4,9,10};
		selectionSort(sel);
		System.out.println("Selection Sort Ascending Order :");
		for(int x:sel)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		System.out.println("Selection Sort Decending Order :");
		selectionSortDesc(sel);
		for(int x:sel)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		
		/* Triplet Product
		 * 
		 * Given Array of +ve Elements(Distinct)
		 * Return min Ele of --> ar[i]*ar[j]*ar[k] & (i!=j!=k)
		 * 
		 * eg : ar[]={2, 7, 4, 3, 1, 1, 6};
		 * 
		 * Ans= 1*2*3
		 * 
		 * Obs : 3-Smallest +ve Numbers will give Smallest Triplet Product.
		 * 
		 * Idea-1 : Sort ar[] & Multiply first 3-elements
		 * 			
		 * 			T.C = O(NlogN+1)= O(NlogN)
		 * Idea-2 : In Selection Sort, iterate 3-Times & get 3 Smallest Elements
		 * 			
		 * 			TC : O(3*N) = O(N)
		 *  
		 */
		System.out.println();
		int tr[]= {8,5,3,9,2,6};
		int trip=TripletSmaller(tr);
		System.out.println("Min Tripplets : "+trip);
	}

	private static int TripletSmaller(int[] tr) 
	{
		 int n=tr.length;
		 for(int i=0;i<3;i++)
		 {
			 //Bring Ele to Correct Pos : ar[i]
			 //Itearte from {i....N-1} & get MinVal & MinInd
			 
			 int min_val=Integer.MAX_VALUE,min_ind=i;
			 for(int j=i;j<n;j++)
			 {
				 if(tr[j]<min_val)
				 {
					 min_val=tr[j];
					 min_ind=j;
				 }
			 }
			 // Swap tr[min_ind] with tr[i]
			 int t=tr[min_ind];
			 tr[min_ind]=tr[i];
			 tr[i]=t;
		 }
		 return tr[0]*tr[1]*tr[2];
	}

	private static void selectionSortDesc(int[] sel) // T.C = O(N^2)
	{												 // S.C = O(1)
		int n=sel.length;
		
		for(int i=0;i<n;i++)
		{
			// Bring Ele to Correct Pos : ar[i]
			// Iterate from {i...N-1} & get MinVal & MinInd
			int max_val=Integer.MIN_VALUE,max_ind=i;
			for(int j=i;j<n;j++)
			{
				if(sel[j]>max_val)
				{
					max_val=sel[j];
					max_ind=j;
				}
			}
			// Swap ar[max_ind] with ar[i]
			int temp=sel[max_ind];
			sel[max_ind]=sel[i];
			sel[i]=temp;
			
		}
	}

	private static void selectionSort(int[] ar) // T.C = O(N^2)
	{ 											// S.C = O(1)
		int n=ar.length;
		
		for(int i=0;i<n;i++)
		{
			// Bring Ele to Correct Pos : ar[i]
			// Iterate from {i...N-1} & get MinVal & MinInd
			
			int MV=Integer.MAX_VALUE,MI=i;
			for(int j=i;j<n;j++)
			{
				if(ar[j]<MV)
				{
					MV=ar[j];
					MI=j;
				}
			}
			// Swap ar[min_ind] with ar[i]
			int temp=ar[MI];
			ar[MI]=ar[i];
			ar[i]=temp;
		}
	}

	private static int NobleInteger3(int[] arr) // T.C = O(NlogN+N)=O(NlogN)
	{											// S.C = O(1)
		 int n=arr.length;
		 int c=0,ans=0;
		 
		 // Check if ar[0] is Noble ?
		 if(arr[0]==0)
		 {
			 ans++;
		 }
		 Arrays.sort(arr);
		 for(int i=1;i<n;i++)
		 {
			 if(arr[i]!=arr[i-1])// ar[i] is 1'st Occurence
			 {
				 c=i;
			 }
			 if(arr[i]==c)
			 {
				 ans++;
			 }
		 }
		 return ans;
	}

	private static int NobleInteger2(int[] a) // T.C = O(NlogN +N) = O(NlogN)
	{										  // S.C = O(1)
		 int n=a.length;
		 int c=0;
		 Arrays.sort(a);
		 
		 for(int i=0;i<n;i++)
		 {
			 // Count of Elements < ar[i]=i;
			 if(a[i]==i)
			 {
				 c++;
			 }
		 }
		 return c;
	}

	private static int NobelInteger1(int[] a) // T.C = O(N^2)
	{										  // S.C = O(1)
		 int n=a.length;
		 int c=0;
		 
		 for(int i=0;i<n;i++)
		 {
			 int less=0;
			 for(int j=0;j<n;j++)	// To Count no : of elements less than a[i] : Sorting in Increasing Order will help to Optimize.
			 {
				 if(a[j]<a[i])
				 {
					 less++;
				 }
			 }
			 if(less==a[i])
			 {
				 c++;
			 }
		 }
		 return c;
	}

	private static int calculateCost1(int[] ar) // T.C = O(NlogN)
	{											// S.C = O(1)
		
		    int n = ar.length;
		    int c = 0;

		    // Step 1: Sort in ascending order (O(n log n))
		    Arrays.sort(ar);

		    // Step 2: Traverse from end to get decreasing order effect (O(n))
		    for (int i = 0; i < n; i++) {
		        c += ar[n - 1 - i] * (i + 1);
		    }

		    return c;
		    
		    /* After Sorting
		     * | i | Element | Calculation |
			   | - | ------- | ----------- |
			   | 0 | 6       | 6 × 1       |
			   | 1 | 4       | 4 × 2       |
			   | 2 | 1       | 1 × 3       |

		     */
		
	}

	private static int calculateCost(int[] ar) // T.C = O(N^2)
	{										   // S.C = O(1)
		 int n=ar.length;
		 int c=0;
		 decresingOrder(ar);
		 for(int i=0;i<n;i++)
		 {
			 c=c+ar[i]*(i+1);// Position (i+1)==> 1,2,3...
		 }
		 for(int x: ar)
		 {
			 System.out.print(x+" ");
		 }
		 return c;
		 
	}

	private static void decresingOrder(int[] a) // T.C = O(N^2)
	{ 											// S.C = O(1)
		 int n=a.length;
		 
		 for(int i=0;i<n-1;i++)
		 {
			 for(int j=i+1;j<n;j++)
			 {
				 if(a[i]<a[j])
				 {
					 int t=a[i];
					 a[i]=a[j];
					 a[j]=t;
				 }
			 }
		 }
		 
	}

}
