package Searching;

import java.util.Arrays;

public class Class_28_Searching_3 
{

	public static void main(String[] args) 
	{
		/* Binary Search ?
		 * 
		 * A) Target
		 * 
		 * B) Search Space
		 * 
		 * C) Discard or Not ?
		 * 
		 * 
		 * Revision :
		 * 					  m-2   m-1	m
		 * 1) 1^st Occurance : x	x	x	Ans=mid, h=m-1
		 * 
		 * 
		 * 2) SQRT	: mid * mid < N
		 *  						
		 *  					mid		: 	Ans=mid, l=m+1
		 *  	
		 */
		
		/* Q1) We have to Paint N Boards of Length { C0 C1 C2......Cn-1} {1 Unit Length= 1 Unit Time}
		 * 		
		 * 	   There are W painters available and each of them takes 1 Unit of Time to Paint 1 Unit of Board
		 * 
		 * 	   Calculate & Return The Minimum Time Required to Paint All Boards.
		 * 
		 * Note :
		 * 
		 * 		1) Two Painters cannot share a board to paint ,A Board cannot be Painted Partially by 1 Painter & Partially by Another
		 * 
		 *  	2) A Painter can only Paint Contiguous Boards : We Cann't Change Order of Boards.
		 * 
		 * 		3) All Painters Start work at Same Time.
		 * 	
		 * 
		 * Eg : ar[6] = { 1,1,1,1,1,101 };
		 * 
		 * 		w=2	  => w1=3   w2=103	:	103 mins
		 * 		w1=5  => w1=5	w2=101	:	101 mins
		 * 
		 * Idea-1 : Calculate Total Time & Average Time
		 * 
		 * 			Total Time = 106, k=2, Average Time = 53
		 * 
		 * Note : It's not a guarantee we can solve problem in Average Time.
		 * 
		 * 
		 * Idea-2 : Binary Search
		 * 
		 * Target : Min Time required to finish all Tasks
		 * 
		 * Search Space : [Based on Time] ? Time Taken to Paint All Boards.
		 * 				  {l...........h}
		 * 
		 * { Best Time to Paint All Boards }  l: Max of Boards Length []
		 * 
		 * { Worst Time to Paint All Boards } h: Sum of Boards Length []
		 * 
		 * Search Space : { 10 71 }// On Total Time Taken to Finish All Tasks
		 * 
		 * Eg : Say Mid Lands at = 40----> Can we finish All Tasks by 40mins ?
		 * 
		 * Note : If we can do a Task in 40mins we can do it 41,42,43......
		 * 
		 * 		  <------40, 41, 42, 43......
		 * 				Ans=40; // It Might be Ans, Update & Look for Better
		 * 				
		 * 				Go to Left;
		 * 				
		 * 				h=m-1;
		 * 
		 * Assume :
		 * 
		 * Eg : Say mid Lands at = 16----> Can we finish All Tasks by 16mins?
		 * 
		 * 		12,13,14,15,16------>
		 * 
		 * Note : If we Cannot do it in 16mins, We Cannot do it in 16,15,14......
		 * 
		 * 
		 * Discard :
		 * 
		 * 		    if( Finish Task in mid Time )
		 * 			{
		 * 				ans=m;
		 * 				h=m-1;
		 * 			}
		 * 			
		 * 			if( Cannot Finish Task in mid Time )
		 * 			{
		 * 	
		 * 				l=m+1;
		 * 			}
		 *  
		 */
		
		int ar[]= {3,5,1,7,8,2,5,3,10,1,4,7,5,4,6};
		int w=4,n=15;
		int ans=minTime(n,w,ar);
		System.out.println("Minimum Time To Paint All Boards : "+ans);
		
		/* Q2) To Paint 1-Unit Length it Takes B-Time & Final Answer % 1000000007
		 * 
		 * Ans :
		 * 
		 * Same as Q1--> But 
		 * 
		 * return (int) ((ans*B)%1000000007))
		 * 
		 * Same TC & SC
		 */
		
		/* Q3) Given N-Cows & M-Stalls, All Stalls are on X-axis[] at Different Locations
		 * 	   
		 * 	   Place all N-Cows in Such a Way That Minimum Distance between any 2-Cows is Maximized { Maximize Min Distance }
		 * 
		 * Note-1 : In a Stall only 1-Cow can be present
		 * 
		 * Note-2 : All Cows have to placed, Stalls N>M
		 * 
		 * Note-3 : All Stalls Positions are Sorted, if not sorted we can sort
		 * 
		 * Eg :
		 * 
		 * Stalls = 5  x-axis[]={ 1,	2,	 4, 	8,	9 }; // Increase Min Distance Between Cows
		 * 							  1	   2			    : 1
		 * Cows = 3				  c1----c2---c3
		 * 								3			5		: 3	} Ans=3// Maximize Min Distance between any 2 cows
		 * 						  c1---------c2---------c3
		 * 								    7		   1	: 1
		 * 						  c1----------------c2--c3
		 * 
		 * Idea :
		 * 
		 * Target : Maximize Min DIstance Between 2 Cows.
		 * 
		 * Search Space : [l......h]
		 * 
		 * Lowest Possible Distance we can Separate l: Minimum Adjacent Distance between 2 Stalls
		 * 
		 * Highest Possible Distance we can Separate h: Last Position - Start Position
		 * 
		 * Discard ?
		 * 
		 * Eg : 
		 * 
		 * Stalls = 9 ==> Dist[] = { 2,6,11,14,19,25,30,39,43 };
		 * 
		 * Cows = 4		  M=22		 C<----------->C			: Cows-Placed = 2 <4*Error
		 * 				  M=12		 C<---->C<---->C<-------->C : Cows-Placed = 4
		 * 
		 */
		int N=9,B=4;//stalls
		int xaxis[]= {2,6,11,14,19,25,30,39,43};
		
		int ans2=maxDistnace(N,B,xaxis);
		System.out.println(ans2);
		//Sorting = O(N log N)

		//Binary Search = log(max-min)

		//Each check = O(N)
		
		/*
		 * | Problem         | Goal     | Move Left         | Move Right        |
		   | --------------- | -------- | ----------------- | ----------------- |
		   | Aggressive Cows | Maximize | when NOT possible | when possible     |
		   | Painter         | Minimize | when possible     | when NOT possible |

		 */
		
		/*
		 * 👍 — only **two lines** for Distance (Aggressive Cows):

		 * We binary search on the **minimum distance** between cows in the range **[1, lastStall − firstStall]**.
		 * If cows can be placed at distance `mid`, we move right (`l = mid + 1`) to maximize the distance; otherwise move left (`h = mid - 1`).

		 */
		
		/*
		 * 👍 — **Painter’s Partition in 2 lines (logic):**

		 * We binary search on the **maximum time** in the range **[max(board), sum(board)]**.
		 * If all boards can be painted within `mid` time, move left (`h = mid - 1`) to minimize time; otherwise move right (`l = mid + 1`).

		 * 
		 */
		 
	}

	private static int maxDistnace(int N, int B, int[] xaxis) // T.C = O(N log N + N log(max-min))
	{														  // S.C = O(1)							
		Arrays.sort(xaxis);
		
		int ans=0;
		int l=1;
		int h=xaxis[N-1]-xaxis[0];
		
		while(l<=h)
		{
			int m=(l+h)/2;
			
			if(check2(B,N,xaxis,m))// We can Place B-Cows at M-Distance Apart
			{
				ans=m;
				l=m+1;
			}
			else // Cannot Place B-Cows at M-Distance Apart
			{
				h=m-1;
			}
		}
		
		return ans;
	}

	private static boolean check2(int b, int n, int[] xaxis, int m) // T.C = O(N)
	{																// S.C = O(1)
		int pc=xaxis[0],c=1;
		
		for(int i=0;i<n;i++)
		{
			if(xaxis[i]-pc>=m)
			{
				c++;
				pc=xaxis[i];
			}
			if(c==b)
			{
				return true;
			}
		}
		return false;
	}

	private static int minTime(int n, int w, int[] ar) // T.C = O(log(sum) * N)
	{												   // S.C = O(1)
		 int l=0;// Max of an Array
		 int h=0;// Sum of an Array
		 // Calculate max element and sum
		    for(int i = 0; i < n; i++)
		    {
		        l = Math.max(l, ar[i]);  // Best case (largest board)// m < largest board
		        h += ar[i];              // Worst case (single painter paints all)// Total work = sum of all boards.
		    }
		 
		 int ans=h;
		 
		 while(l<=h)
		 {
			 int m=(l+h)/2;
			 
			 if(check(n,w,ar,m))
			 {
				 ans=m;
				 h=m-1;
			 }
			 else
			 {
				 l=m+1;
			 }
		 }
		 return ans;
	}

	private static boolean check(int n, int w, int[] ar, int m) // T.C = O(N)
	{															// S.C = O(1)
		 int s=0; // current painter's work
		 int p=1; // number of painters used
		 
		 for(int i=0;i<n;i++)
		 {
			 s=s+ar[i];
			 if(s>m)
			 {
				 p++; // need new painter
				 s=ar[i];// assign board to new painter
			 }
			 if(p>w)// Cannot Paint All Boards in M Time.
			 {
				 return false;// too many painters needed
			 }
		 }
		
		 return true;
	}

}
