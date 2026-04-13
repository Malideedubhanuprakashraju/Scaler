package Heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

class MinHeap
{
	private ArrayList<Integer> arr;
	
	public MinHeap()
	{
		arr=new ArrayList<>();
	}

	public MinHeap(ArrayList<Integer> in) // T.C = O(N), S.C = O(N)
	{
		arr=new ArrayList<>();
		
		//Copy Elements
		
		for(int i=0;i<in.size();i++)
		{
			arr.add(in.get(i));
		}
		
		// Heapify (Bottom-Up)
		
		for(int i=arr.size()/2-1; i>=0;i--)
		{
			int indx=i;
			
			while(2*indx+1 < arr.size())// Child Exists
			{
				int min_ind = 2*indx+1;// Left Child 
				
				// check right child
				
				if(2*indx+2<arr.size())
				{
					if(arr.get(2*indx+2)<arr.get(2*indx+1))
					{
						min_ind=2*indx+2;
					}
				}
				
				// if parent is smaaleer -> Stop
				
				if(arr.get(indx)<=arr.get(min_ind))
				{
					break;
				}
				
				// Swap
				
				int temp=arr.get(indx);
				arr.set(indx,arr.get(min_ind));
				arr.set(min_ind, temp);
				
				indx=min_ind;
			}
			
		}
		
	}
	int getMin() // T.C = O(1), S.C = O(1)
	{
		return arr.get(0);
	}
	
	int size() // T.C = O(1), S.C = O(1)
	{
		return arr.size();
	}

	public void insert(int x) // T.C = O(log N), S.C = O(1)
	{
		arr.add(x);// Insery at Last
		
		int i=arr.size()-1;
		
		while(i>0)// until root
		{
			int p=(i-1)/2;
			
			if(arr.get(p)>arr.get(i))
			{
				// Swap Parent & Child
				
				int temp=arr.get(p);
				arr.set(p,arr.get(i));
				arr.set(i, temp);
				
				i=p;
			}
			else
			{
				break;
			}
		}
		
		
	}
	
	public void deleteMin() // T.C = O(log N), S.C = O(1)
	{
		if(arr.isEmpty())
		{
			return;
		}
		
		// Swap First & Last
		
		int lindex=arr.size()-1;
		int temp=arr.get(0);
		arr.set(0,arr.get(lindex));
		arr.set(lindex, temp);
		
		arr.remove(lindex);
		
		int i=0;
		
		while(2*i+1<arr.size())// Child Exists
		{
			int min_ind=2*i+1;
			
			// check right child
			
			if(2*i+2 < arr.size())
			{
				if(arr.get(2*i+2)<arr.get(min_ind))
				{
					min_ind=2*i+2;
				}
			}
			// if parent is smaller → stop
            if (arr.get(i) <= arr.get(min_ind)) 
            {
                break;
            }

            // swap
            int t = arr.get(i);
            arr.set(i, arr.get(min_ind));
            arr.set(min_ind, t);

            i = min_ind;
		}
	}
	
}

public class Class_50_Heaps_1 
{
	

	public static void main(String[] args) 
	{
	  // Heaps Intro
		
	  /* Binary Tree : A Tree is a Binary Tree it should has Atmost 2-Childs => { 0,1,2 }
	   * 
	   * 			   Multiple Types of Binary Tree
	   * 
	   * 			   a) Balanaced Binary Tree { BBT }
	   * 
	   * 			   b) Perfect Binary Tree { PBT }
	   * 
	   * 			   c) Complete Binaray Tree { CBT }
	   * 
	   * 
	   * CBT : Complete Binary Tree
	   * 
	   * 	   All Levels are completely filled {Except Possibly} the Last Level,
	   * 
	   * 	   If Last Level not filled : It is filled Left -> Right (Node by Node)
	   * 
	   * Eg-1 : CBT
	   * 
	   * 			  (A)
	   * 		(B)		    (C)
	   * 	(D)		(E) (D)		(E)
	   * 
	   * Eg-2 : Not CBT
	   * 
	   * 			  (A)
	   * 		(B)			(C)
	   * 
	   * 	(D)		(E)    N-F	(D)
	   * 
	   * 
	   * Height of CBT : log N, N = No:of Nodes
	   * 
	   * 
	   * Implementation of CBT using Arrays/LimkedLists
	   * 
	   * Insert : 3	  2	  9	  6	  8	 7	2	14	16
	   *   |
	   *   |
	   *  List  : 3	  2	  9	  6   8  7  2   14   16 
	   *  
	   * ==> Implement a CBT :
	   * 
	   * Assume : Node i : D
	   * 		  children 2i+1 : L
	   * 		  children 2i+2 : R
	   * 
	   * Note-1 : This is an imaginary of Tree, comes based on the Assumption in Array List.
	   * 
	   * Node i : Left Child = 2*i + 1
	   * 
	   * 		  Right Child = 2*i + 2
	   * 
	   * Node i : Parent = (i-1)/2
	   * 
	   * It Allows both Top Down & Down Top
	   * 
	   * 
	   * Heaps :
	   * -----
	   * 
	   * a) Min Heap
	   * 
	   * b) Max Heap
	   * 
	   * 					Binary Tree should be a CBT first
	   * 
	   * Every Node <= Child Nodes							Every Node >= Child Nodes
	   * 
	   * 		Min Heap											Max Heap
	   * 
	   * Eg-1 : Min Heap
	   * 
	   * 				3
	   * 			7		6
	   * 		14	  10 6		15
	   * 
	   * 	20
	   * 
	   * CBT : Every Node <= Child Nodes
	   * 
	   * 
	   * Eg-2 : Max Heap
	   * 
	   * 				10
	   * 			8		 7
	   * 		6	   5 5		6
	   * 	4
	   * 
	   * CBT : Every Node >= Child Nodes
	   *   	
	   */
		
	  /* Heap Operations :
	   * 
	   * 	Min Heap			Max Heap		Time Complexity for Single Operation
	   * 
	   * 	insert( )			insert( )				O(log N) // N: No of Nodes
	   * 
	   * 	getMin( )			getMax( )				O(1)
	   * 
	   * 	deleteMin( )		deleteMax( )			O(log N) // N: No of Nodes
	   * 
	   * 	size( )				size( )					O(1)
	   *  
	   * 	Heapify( )			Heapify( )				O(N) // N: No of Nodes
	   *   
	   */
		
	   /* Heapify : Using given data create MinHeap/MaxHeap
	    * 
	    * Heapify( ) : Given an Array[N] of Elements, convert them into MinHeap/MaxHeap
	    * 
	    * Eg : Array[12] = { 6, 2, 8, 10, 14, 3, 9, 2, 7, 20, 1, -3};
	    * 
	    * 
	    * Idea-1 : Sort Data,It will become a Min Heap
	    * ------
	    * 
	    * T.C = O(N*logN)
	    * 
	    * Idea-2 : Heapify : Convert All Data Elements into Heap
	    * ------
	    * 
	    * T.C = O(N)// For N Elements
	    * 
	    * ==> Iterate on Right to Left, at every index, make that entire subtree a min_heap by comparing Elements with it's children
	    *   	
	    */
		
		// Heap Implementation
		
		ArrayList<Integer> li=new ArrayList<>();
		li.add(10);
		li.add(5);
		li.add(20);
		li.add(20);
		li.add(2);
		
		MinHeap heap=new MinHeap(li);
		System.out.println(heap.getMin());// Min Heap
		
		heap.insert(1);
		
		System.out.println(heap.getMin());
		heap.deleteMin();
		System.out.println(heap.getMin());// Min Heap
		
		/* Priority Queue :
		 * --------------
		 * 
		 * Arranges data based on their Priority Values
		 * 
		 * Functions :
		 * ---------
		 * 
		 * 1) add() : Add Element in Prority Queue : log(N) : N= No of Elements
		 * 
		 * 2) peek() : Return peek element : O(1) : Peek : Highest Priority
		 * 
		 * 3) remove() : Removes peek Element : log(N) : N= No of Elements
		 * 
		 * 4) size() : Returns Size : O(1)
		 * 
		 * MinPQ : Priority Based on min values : { Min Value at Top => MinHeap }
		 *   
		 */
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		
		pq.add(9);
		pq.add(10);
		pq.add(15);
		pq.add(18);
		pq.add(1);
		System.out.println("Peek Element "+pq.peek());
		pq.remove();
		System.out.println("Peek Eleemnt "+pq.peek());
		
	} 

}
