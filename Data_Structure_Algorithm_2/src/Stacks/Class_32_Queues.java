package Stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class Class_32_Queues 
{

	public static void main(String[] args) 
	{
		// Queues Basics
		// Dequeue
		
		/* Queue 
		 * 
		 * It is a Data Structure which follows FIFO : First in First Out
		 * 
		 * Both Entry & Exist Happens at Different Side
		 * 
		 * Exist Side : Front Side		Entry Side : Rear Side
		 * 
		 * Functions :
		 * 
		 * 1) Enqueue(X) : X inside Queue --> Rear End
		 * 
		 * 2) Dequeue() : Delete from Front End & Return Deleted Front Element
		 * 
		 * 3) Front() : Return Element at Front End
		 * 
		 * 4) Size() : Return no:of Element in Queue
		 * 
		 * 
		 * We can implement Queue using Linked List
		 * 
		 * Any Single Function Take O(1) Time.
		 * 
		 */
		
		/* Library :
		 * 
		 * Queue<Type> que = new LinkedList<>();
		 * 
		 * Functions :
		 * 
		 * 1) enqueue(X) = que.add(x) : Add Element at Rear/Back End
		 * 
		 * 2) deque()	 = que.poll() : Remove & Return Element at Front End
		 * 
		 * 3) front()	 = que.peek() : Return Element at Front End
		 * 
		 * 4) size()	 = que.size() : Return Size()
		 * 
		 * Note : A Single Queue Operation Takes O(1) Time.
		 */
		
		/* Implement Queue using Stacks
		 * 
		 * Queue Operations 					Stack
		 * 
		 * a) Enqueue() : 						a) push() :
		 * 
		 * b) Dequeue() :						b) pop() :
		 * 
		 * c) Front() :							c) peek() :
		 * 
		 * d) Size() :							d) size() :	
		 * 
		 * Every Queue function should be implemented using Stack Functions Only
		 *  
		 */
		
		 /* Dequeue : Double Ended Queue
		  * 
		  * 
		  * First						Last
		  * -----						-----
		  * addFirst()					addLast()
		  * 
		  * getFirst()					getLast()
		  * 
		  * removeFirst()				removeLast()
		  *   		
		  */
		Deque<Integer> dq=new ArrayDeque<>();
		dq.addFirst(10);
		dq.addFirst(20);
		dq.addFirst(30);
		dq.addFirst(40);
		System.out.println(dq);
		System.out.println(dq.getFirst());
		dq.addLast(50);
		dq.addLast(60);
		dq.addLast(70);
		dq.addLast(80);
		System.out.println(dq.removeFirst());
		System.out.println(dq.removeFirst());
		System.out.println(dq.getFirst());
		System.out.println(dq.getLast());	
		System.out.println(dq);
		System.out.println(dq.removeLast());
		
		// Note : A Dequeue can provide both Stack & Queue Functionalities
		
		// Q1) Given Array & K, Find Max Element in Every Subarray of size = k.
		
		/* Eg : ar[] = {10,1,9,3,7,6,5,11,8};
		 * 
		 * 		 k=4;
		 * 
		 * Output : 10,9,9,7,11,11 : Store it in Array List & Return Ans.
		 * 
		 * 
		 * Idea-1 : For Every Subarray of Len = k : Iterate & get Max
		 * 
		 * 			T.C = (N-k+1) * O(k) = O(N^2)
		 * 					|
		 * 					----> No:of Subarrays of Length = k
		 * 
		 * 			S.C = O(1)
		 * 
		 * Cases :
		 * 
		 * K		:		TC
		 * 
		 * 1		:		O(N-1+1)*O(1) = O(N)
		 * N		:		O(N-N+1)*O(N) = O(N)
		 * 
		 * N/2		:		O(N-N/2+1)*O(N/2)= O(N/2)*O(N/2) = O(N^2)
		 * 
		 * 
		 * Optimization : Using Sliding Window + Dequeue
		 * 
		 * Container : Dequeue
		 * 
		 * 1) front()
		 * 
		 * 2) deletefront()
		 * 
		 * 3) back()
		 * 
		 * 4) deleteback()
		 * 
		 * 5) insertback()
		 * 
		 * Steps :
		 * 
		 * 1) Delete Part :
		 * 
		 * 			if (Ele to Delete == front())
		 * 			{
		 * 				delete from front
		 * 			}
		 * 
		 * 2) New Element Insert
		 * 
		 * 			while(container size > 0 && back() < new_element)
		 * 			{
		 * 				delete from back()
		 * 			}
		 * 			insert back(new_element)
		 * 
		 * 3) Max of Subarray
		 * 
		 * 			Front of Container
		 * 
		 *   
		 */
		
		int ar[]= {15,12,8,4,10,9,7,12,10,7,14,3};
		int k=5;
		
		int ans[]=WindowMax(ar,k);
		
		for(int x:ans)
		{
			System.out.print(x+" ");
		}
		
		
	}

	private static int[] WindowMax(int[] ar, int k) // T.C = O(N)
	{												// S.C = O(k)
		 int n=ar.length;
		 
		 if(k>n)
		 {
			 return new int[0];
		 }
		 
		 int ans[]=new int[n-k+1];
		 
		 Deque<Integer> dq=new ArrayDeque<>();
		 
		 for(int i=0;i<k;i++)
		 {
			 while(dq.size()>0 && dq.getLast()>ar[i])
			 {
				 dq.removeLast();
			 }
			 dq.addLast(ar[i]);
		 }
		 ans[0]=dq.getFirst();
		 
		 // 0	1	2	3	k-1	k	k+1	K+2 ......N-1;
		 //s-1  s---------------e
		 
		 int s=1,e=k;
		 while(e<n)
		 {
			 while(dq.size()>0 && dq.getLast()>ar[e])
			 {
				 dq.removeLast();
			 }
			 dq.addLast(ar[e]);
			 
			 if(ar[s-1]==dq.getFirst())
			 {
				 dq.removeFirst();
			 }
			 
			 ans[s]=dq.getFirst();
			 s++;
			 e++;
		 }
		 return ans;
	}

}
