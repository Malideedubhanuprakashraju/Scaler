package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class Class_51_Heaps_2 
{

	public static void main(String[] args) 
	{
	  // Heap Sort
	  /*
	   * a) Min Heap
	   * 
	   * b) Max Heap
	   * 
	   * c) Own Heap
	   * 
	   * 
	   * Priority Queue :
	   * --------------
	   * 
	   * Arranges Data Based on their Priority { Min / Max / Userdefined }
	   * 
	   * Functions :
	   * ---------
	   * 
	   * 1) add() : Add Element in Priority Queue : O(log N) = No:of Elements
	   * 
	   * 2) peek() : Return Peek Element : O(1) : Peek : Heighest Priority
	   * 
	   * 3) remove() : Remove Peek Element : O(log N) = No:of Elements
	   * 
	   * 4) size() : Return Size : O(1)
	   * 
	   * MinPQ : Priority Based on MinValues : { Min Value at Top -> MinHeap }
	   * 
	   * Syntax :
	   * ------
	   * 
	   * PriorityQueue<Integer> pq = new PriorityQueue<>();
	   * 
	   * By Default Priority Queue is MinHeap.
	   * 
	   * Note : If we want own ordering, override Comparator.
	   *   	
	   */
		
	   PriorityQueue<Integer> pq=new PriorityQueue<>();
	   
	   pq.add(10);
	   pq.add(19);
	   pq.add(15);
	   pq.add(15);
	   pq.add(18);
	   System.out.println(pq.peek());
	   pq.remove();
	   System.out.println(pq.peek());
	   System.out.println(pq.peek());
	   
	   // Q1) Given ArrayList Sort Data.
	   /*
	    * Idea :
	    * ----
	    * 
	    * a) Selection Sort : T.C = O(N^2)
	    * 
	    * b) MergeSort/QuickSort : T.C = O(N * logN), S.C = O(N)
	    * 
	    * c) Inbuilt Function : T.C = O(N * logN), S.C = O(1)
	    * 
	    * d) HeapSort :
	    * 
	    * 	 1) ArrayList Input ==> MinHeap // Heapify() T.C = O(N)
	    * 
	    * 	 2) Delete Every Element , Keep deleted in List, Only Reduce it's size variable // T.C = O(N * logN)
	    * 
	    * 	 3) Reverse Array : T.C = O(N)
	    * 
	    * Final T.C : O( N + N * logN + N ) = O( N * logN)
	    * 
	    * 		S.C : O(1)
	    *  
	    */
	   System.out.println();
	   ArrayList<Integer> ar=new ArrayList<>();
	   
	   ar.add(10);
	   ar.add(2);
	   ar.add(1);
	   ar.add(30);
	   ar.add(22);
	   System.out.println(ar);
	   
	   System.out.println();
	   ArrayList<Integer> ans=Heapify(ar);
	   System.out.println(ans);
	   ArrayList<Integer> ans1=HeapSort(ar);
	   System.out.println(ans1+" Heap Sort");
	   
	   /* Heap Sort :
	    * ---------
	    * 
	    * Final T.C = O( N + N * log N + N) = O( N * log N)
	    * 
	    * S.C = O(1)
	    * 
	    */
	   
	   /* Q2) Given Array[N] distinct elements, return k^th Largest Element in Array
	    * 
	    * Eg : ar[10] = { 8, -3, 10, 5, 11, 2, 7, 9, 14, -1 };
	    *   
	    * k=4;
	    * 
	    * Ans = 9
	    * 
	    * Eg : ar[5] = { 1, 2, 3, 4, 5 };
	    * 
	    * k=5;
	    * 
	    * Ans = 1
	    * 
	    *  
	    * Idea-1 : Sort Array in Decreasing Order & Return ar[k-1];
	    * 
	    * T.C = O( N * logN)
	    * 
	    * S.C = O(1)
	    * 
	    * 
	    * Idea-2 : Given Array ==> MaxHeap : Heapify
	    * 
	    * 		   Delete k-1 times & return peek() element
	    * 
	    * T.C = O( N + k * log N)
	    * 
	    * 
	    * Idea-3 : K^th Largest ==> Min Heap
	    * 
	    * 		   ar[10] = { 8, -3, 10, 5, 11, 2, 7, 9, 14, -1 };
	    * 
	    * Obs : If an Element is K^th Largest,
	    * 
	    * 		1	2	3	.	.	k-1	k^th
	    * 
	    * Elements bigger than that is K-1(Element)
	    * 
	    * Steps :
	    * 
	    * 1) Take a MinHeap
	    * 
	    * 2) Iterate on Array :
	    * 
	    * 				Insert Array[i] in MinHeap
	    * 
	    * 				if MinHeapSize > K : Delete Min Ele from MinHeap
	    * 
	    * 3) Return Min Ele from Min Heap
	    * 
	    * T.C = O( N * [logK + logL] ) = O(N * logK)
	    *  
	    */
	   
	   int arr[]= {8,-3,10,5,11,2,7,9,14,-1};
	   int k=4;
	   
	   int ans2=kthLargest(arr,k);
	   System.out.println("Kth Largest Element in Array "+ans2);
	   
	   /*
	    * N iterations × log k work each
										 = O(N log k)
										 
		*   | Concept | Answer         |
			| ------- | -------------- |
			| Time    | O(N * log k)   |
			| Space   | O(k)           |

		*								 
	    */
	   
	   /* Q4) Find the K^th Largest Element for All The Subarrays of an Array
	    * 
	    * 	  Starting at 0^th index & Length of Subarrays [K....N]
	    * 
	    * Eg-1 : ar[] = { 10, 18, 7, 5, 16, 19,3 };
	    * 
	    * K = 3;						 K^th : 3^rd Largest
	    * 
	    * 3^rd Largest in { 10, 18, 7 } = 7
	    * 
	    * 3^rd Largest in { 10, 18, 7, 5 } = 7
	    * 
	    * 3^rd Largest in { 10, 18, 7, 5, 16 } = 10
	    * 
	    * 3^rd Largest in { 10, 18, 7, 5, 16, 19 } = 16
	    * 
	    * 3^rd Largest in { 10, 18, 7, 5, 16, 19, 3 } = 16
	    *  
	    */
	   int a[]= {5,4,1,6,7};
	   
	   int t=2;
	   
	   KthLargestSubarray(a,t);// 2^nd Largest Element in SubArray
	   
	   /* Steps :
	    * -----
	    * 
	    * 1) Take a MinHeap
	    * 
	    * 2) Iterate on Array
	    * 
	    * 			Insert Array[i] in Min Heap
	    * 
	    * 			if MinHeap Size > k : Delete Min Element from MinHeap
	    * 
	    * 			if MinHeap Size == k : Print MinElement from MinHeap // Peek()
	    * 
	    * T.C = O( N * [log*K + log*K] = O(N * logK)
	    * 
	    * 
	    */
	   
	   /* Median : A Point Can Devide into 2-equal parts { 1^st Half All <= 2^nd Half All }
	    * 
	    * 
	    * Eg-1 : ODD
	    * 
	    * array[5] = { 2, 9, 6, 4, 5 };
	    * 
	    * 			 { 2, 4, 5, 6, 9 }; // Median = 5;
	    * 
	    * Eg-2 : EVEN
	    * 
	    * array[4] = { 1, 2, 4, 3 };
	    * 
	    * 			 { 1, 2, 3, 4 }; // Median = Average of Both Median = 2+3/2 = 2.5
	    *  
	    */
	   
	   /*  Q5) Given an Array Return Median of All Prefix Subarrays :
	    * 									
	    * 												  {Subarray Starting index =0}
	    * 
	    *  Eg : array[5] = { 9, 6, 3, 10, 4 };
	    *  
	    *  		Note : Return Median of All Prefix Subarrays in an Ans[N]
	    *  
	    *  		Note : N Prefix Subarays
	    *  
	    *  Subarrays :							Median :
	    *  
	    *  [0	0]	=	{ 9 };						9
	    *  [0	1]	=	{ 9, 6 };			 15/2 = 7
	    *  [0	2]  =	{ 9, 6, 3};					6
	    *  [0	3]	=	{ 9, 6, 3, 10 };	 15/2 = 7	
	    *  [0	4]  =	{ 9, 6, 3, 10, 4};	 		6
	    *  
	    *  
	    *  Idea-1 : For Every Prefix Subarray Sort & Find Median
	    *  
	    *  T.C  = O( N * NlogN ) = O (N^2 * logN)
	    *  			 |	   |
	    * 			 |	   |-----> Sorting a Single Array
	    * 			 |
	    * 			 Prefix Subarrays
	    * 
	    * Case : Odd
	    * 
	    * Array[9] = { 3, 1, 6, 10, 14, 2, 17, 12, 9 };
	    * 
	    * 			 { 1, 2, 3, 6, 9, 10, 12, 14, 17 };
	    * 
	    * 				1^st Half <= 2^nd Half
	    * 
	    * Obs : All Elements in 1^st Half <= 2^nd Half
	    * 
	    * 		1) Max of 1^st Half <= Min of 2^nd Half
	    * 
	    * 		2) 1^st Half size - 2^nd Half Size = 1
	    * 
	    * 		3) Median = Max Element of 1^st Half
	    * 
	    * 
	    * Case : Even
	    * 
	    * Array[10] = { 3, 4, 16, 12, 10, 14, 8, 9, 2, 1 };
	    * 
	    * 			  { 1, 2, 3, 4, 8, 9, 10, 12, 14, 16 };
	    * 
	    * Obs : All Elements in 1^st Half <= 2^nd Half
	    * 
	    * 		1) Max of 1^st Half <= Min of 2^nd Half
	    * 
	    * 		2) 1^st Half Size - 2^nd Half Size =0
	    * 
	    * 		3) Median = (Max Element of 1^st Half + Min Element of 2^nd Half)/2;
	    * 
	    * Combine Obseravtions :
	    * 
	    * 1) Max of 1^st Half <= Min of 2^nd Half
	    * 
	    * 2) 1^st Half Size - 2^nd Half Size = 1, 0
	    * 
	    * Odd :
	    * 
	    * 	  Median = Max Element of 1^st Half
	    * 
	    * Even :
	    * 
	    * 	  Median =( Max Element of 1^st Half + Min Element of 2^nd Half )/2;
	    * 
	    * 
	    * Solution :
	    * --------
	    * 
	    * 1^st Half Box : B1								2^nd Half Box : B2
	    * 
	    * Operations : Max Heap								Operations : Min Heap
	    * 
	    * 1) Insert( )										1) Insert( )
	    * 
	    * 2) getMax( )										2) getMin( )
	    * 
	    * 3) delMax( )										3) delMin( )
	    * 
	    * 
	    * Max of 1^st <= Min of 2^nd Half
	    * 
	    * 1^st Half Size( ) - 2^nd Half Size ( ) = 1, 0
	    *   
	    */
	   int aray[]= {4,6,9,2,1,10,14,7,3,5};
	   
	   int ans3[]=Median(aray);
	   for(int x:ans3)
	   {
		   System.out.print(x+" ");
	   }
	   
	   /*   | Problem              | Time Complexity | Space Complexity |
			| -------------------- | --------------- | ---------------- |
			| Heapify              | `O(N)`          | `O(1)`           |
			| Heap Sort            | `O(N log N)`    | `O(1)`           |
			| Kth Largest          | `O(N log K)`    | `O(K)`           |
			| Kth Largest Subarray | `O(N log K)`    | `O(K)`           |
			| Median (Prefix)      | `O(N log N)`    | `O(N)`           |

	    */
	   
	}

	private static int[] Median(int[] a) // T.C = O(N * (logN + logN) ) = O(N * logN)
	{									 // S.C = O(N)
		int n=a.length;
		
		int[] ans=new int[n];
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		
		maxHeap.add(a[0]);
		ans[0]=a[0];
		
		for(int i=1; i<n;i++)// Insert Array[i]
		{
			if(a[i]>maxHeap.peek())
			{
				minHeap.add(a[i]);
			}
			else 
			{
				maxHeap.add(a[i]);
			}
			
			// Balancing Sizes |maxHeap size - minHeap size| ≤ 1
			
			if(maxHeap.size()-minHeap.size()==2)// maxHeap has extra val =>Transfer maxHeap => minHeap
			{
					 int max = maxHeap.peek();
					 maxHeap.remove();
					 minHeap.add(max);
			}
				
			if(maxHeap.size()-minHeap.size()==-1)// minHeap has extra val =>Transfer minHeap => maxHeap
			{
					int min = minHeap.peek();
					minHeap.remove();
					maxHeap.add(min);
			}
				
				// Calculating Median
				
			int N=maxHeap.size()+minHeap.size();
				
			if(N%2==1) //Odd
			{
				ans[i]=maxHeap.peek();
			}
			else //Even
			{
				ans[i]=(maxHeap.peek()+minHeap.peek())/2;
			}
				
			
		}
		return ans;
	}

	private static void KthLargestSubarray(int[] a, int t) // T.C = O( N * log K )
	{													   // S.C = O( k )
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		
		for(int i=0;i<a.length;i++)
		{
			pq.add(a[i]);
			
			if(pq.size()>t)
			{
				pq.remove();
			}
			if(pq.size()==t)
			{
				System.out.print(pq.peek()+" ");
			}
		}
	}

	private static int kthLargest(int[] arr, int k) // T.C = O( N * log K )
	{												// S.C = O( K )
		
		  PriorityQueue<Integer> pq=new PriorityQueue<>();
		   
		  for(int i=0;i<arr.length;i++)
		  {
			  pq.add(arr[i]); // ALWAYS ADD FIRST
			  
			  if(pq.size()>k) // // THEN CHECK
			  {
				  pq.remove();  // remove smallest
			  }
			  			  		  
		  }
		  
		  return pq.peek();
	}

	private static ArrayList<Integer> HeapSort(ArrayList<Integer> ar) 
	{
		// Build Heap --> Bottom-up heap Construction // T.C = O(N)
		for(int l=ar.size()/2-1;l>=0;l--)
		{
			int i=l;
			
			while(2*i+1<ar.size())
			{
				int minindex=2*i+1;
				
				if(2*i+2<ar.size())
				{
					if(ar.get(2*i+2)<ar.get(2*i+1))
					{
						minindex=2*i+2;
					}
				}
				if(ar.get(i)<=ar.get(minindex))
				{
					break;
				}
				
				int temp=ar.get(i);
				ar.set(i,ar.get(minindex));
				ar.set(minindex, temp);
				
				i=minindex;
			}
		}
		
		// Delete every Element, keep deleted in List, only reduce it's size variable // T.C = O(N * logN)
		int n=ar.size();
		
		while(n>1)
		{
			int t=ar.get(0);
			ar.set(0,ar.get(n-1));
			ar.set(n-1,t);
			
			n=n-1;
			int i=0;
			while(2*i+1<n)
			{
				int minindex=2*i+1;
				
				if(2*i+2 < n)
				{
					if(ar.get(2*i+2)<ar.get(2*i+1))
					{
						minindex=2*i+2;
					}
				}
				
				if(ar.get(i)<=ar.get(minindex))
				{
					break;
				}
				
				int temp=ar.get(i);
				ar.set(i,ar.get(minindex));
				ar.set(minindex,temp);
				
				i=minindex;
			}
		}
		
		// Reverse array // T.C = O(N)
		Collections.reverse(ar);
		
		return ar;
	}

	private static ArrayList<Integer> Heapify(ArrayList<Integer> ar) // T.C = O(N)
	{																 // S.C = O(1)
		 for(int l=ar.size()/2-1;l>=0;l--)
		 {	
			 int i=l;
			 while(2*i+1<ar.size())
			 {
				 int mi=2*i+1;
				 
				 if(2*i+2<ar.size())
				 {
					 if(ar.get(2*i+2)<ar.get(2*i+1))
					 {
						 mi=2*i+2;
					 }
				 }
				 if(ar.get(i)<=ar.get(mi))
				 {
					 break;
				 }
				 
				 //ar.set(index, value); // index → position in list // value → new value to replace old one
				 int temp=ar.get(i);//a
				 ar.set(i,ar.get(mi));//Index-->Value
				 ar.set(mi, temp);// 
				 
				 i=mi;//You fix only one level // But we need to fix all leveles
				 //set() replaces the element at a given index with a new value.
			 }
		 }
		 return ar;
	}

}
