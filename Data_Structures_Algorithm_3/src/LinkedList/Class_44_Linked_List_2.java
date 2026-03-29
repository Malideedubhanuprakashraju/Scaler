package LinkedList;

class Node
{
	int data;
	Node next;
	
	Node(int x)
	{
		data=x;
		next=null;
	}
}

public class Class_44_Linked_List_2 
{

	public static void main(String[] args) 
	{
		/* Revision Linked List
		 * --------------------
		 * 
		 * 1) Advantage of Linked List : It has better Space Optimization
		 * 
		 * 2) T.C to Search in LinkedList : Iterate on LinkedList T.C = O(N)
		 * 
		 * 3) Check Palindrome or Not :
		 * 
		 * 			a) 10 -> 20 -> 30 -> 40 |-> 30 -> 20 -> 10 ->NULL
		 * 			   h1						h2
		 * 
		 * 			b) Reverse h2 : 10 -> 20 -> 30 -> NULL
		 * 
		 * 			c) Now Compare H1 & H2
		 * 
		 * 4) Delete Node : Itearte & Search for Node & Delete it.
		 * 
		 */
		Node h=new Node(10);
		Node t=h;
		t.next=new Node(2);
		t=t.next;
		t.next=new Node(33);
		t=t.next;
		t.next=new Node(14);
		t=t.next;
		t.next=new Node(5);
		t=t.next;
		
		System.out.println(h);
		System.out.println(h.data);
		System.out.println(h.next);
		//h=h.next;
		System.out.println(h);
		
		// Q1) Given Head Node find Mid of LinkedList
		//     Note : If Even Length return 1^st Mid.
		
		/* Idea-1 :
		 * ------
		 * 
		 * 1) Iterate on Linked List & get Length ==> 1: Individual Loop
		 *  
		 * 2) Iterate till Half Length & Return Mid => 2: Individual Loop
		 * 
		 * T.C = O(N + N/2 ) = O(N)
		 * 
		 * S.C = O(1)
		 * 
		 * Target : Only using 1 Loop
		 * 
		 * Idea-2 :
		 * ------
		 * 
		 * P1 : 100km-------------------------> P1 
		 * 
		 * P2 : 50km------------>P2
		 * 
		 * Observation : Beacuse P2 Speed is Half of P1, When P1 Reached end P2 is at Center.
		 * 
		 * Steps : Take S=h & f=h; F goes twice speed of S.
		 * 
		 * 		   S = S.next
		 * 
		 * 		   F = F.next.next
		 * 
		 * Observation : When F reaches end S has to reach mid.
		 * 
		 * Eg-1 : Odd Length
		 * 
		 * 		  1		2	3	4	5	6	7	Null
		 * 						S			F
		 * 
		 * Obs-1 : Iterate Till f.next!=null;
		 * 
		 * 
		 * Eg-2 : Even Length
		 * 
		 * 		  1		2	3	4	5	6	7	8	Null
		 * 						S			F
		 * 
		 * Obs-2 : Itearte Till f.next.next != null
		 * 
		 * 
		 * Conclusion : Since we are not sure, if it's Odd or Even Length use Both Conditions.
		 *  
		 */
		
		Node m=Mid(h);
		System.out.println("Mid element is : "+m.data);
		
		// Q2) Given 2 Sorted LinkedList, Merge & get Final Sorted List
		/*
		 * 	   Note : Re-arrange Links & return Head Node.
		 * 
		 * Eg-1 : 
		 * 
		 * 			h(2) -> (5) -> (9) -> (14) -> (19) -> (24) -> Null
		 * 
		 * 			h2(3) -> (6) -> (10) -> (11) -> (12) -> Null
		 * 
		 * Final Ans = h(2) -> (3) -> (5) -> (6) -> (9) -> (10) -> (11) -> (12) -> (14) -> (19) -> (24) -> Null
		 * 
		 * 
		 * Pseudocode :
		 * ---------
		 * 
		 * Repeat h1!=null && h2!=null
		 * 
		 * 		  1) Attach Smaller to Tail
		 * 
		 * 		  2) Update Tail & Smaller
		 * 
		 * Attach Left Out Linked List to Tail.next
		 * 
		 * return Head Node;
		 *  
		 */
		Node h1=new Node(2);
		Node t1=h1;
		t1.next=new Node(10);
		t1=t1.next;
		t1.next=new Node(11);
		t1=t1.next;
		
		Node h2=new Node(1);
		Node t2=h2;
		t2.next=new Node(5);
		t2=t2.next;
		t2.next=new Node(12);
		t2=t2.next;
		t2.next=new Node(15);
		t2=t2.next;
		
		//Node smerge=mergeLinkedList(h1,h2);
		System.out.println("Print Linked List after Sorting-Way-1 : ");
		//print(smerge);
		System.out.println();
		System.out.println("Dummy Node Approach (Easier & Safer) Way-2 : ");
		Node sm=Merge(h1,h2);
		print(sm);
		
		// “The dummy node acts as a starting anchor, and the tail pointer builds the list by attaching nodes to dummy.next.”
		
		/*
		 * 👉 **Without Dummy:** You must handle the first node separately, making the code slightly complex.

		   👉 **With Dummy:** No special handling is needed; the code is simpler and safer.
		 */
		
		// Given Head Node of Linked List, Sort & Return Head Node of Linked List.
		/*
		 * Eg-1 :
		 * 
		 * 			h(14) -> (6) -> (12) -> (10) -> (2) -> (4) -> Null
		 * 
		 * 			h(2) -> (4) -> (6) -> (10) -> (12) -> (14) -> Null
		 *  
		 * MergeSort : Divide Data into 2 equal parts.
		 * 
		 * 			   Recursively Sort both Parts & Merge them.
		 * 
		 * Assumption : Given Linked List Sort & Return Head Node of Linked List
		 * 
		 * 
		 * Main Logic : Solving with Subproblem { Subproblem will work according assumption }
		 * 
		 * T.C : O( N * logN)
		 * 
		 */
		System.out.println();
		Node ans=Sort(h);
		print(ans);
		
		/*
		 * 👉 Linked list has no random access → accessing any node takes O(N)
		   👉 Merge Sort works using only pointers → no indexing needed
		   👉 Hence efficient → O(N log N)
		   
		   👉 “Linked lists lack random access, so merge sort is preferred as it works sequentially using pointers and achieves O(N log N) efficiency.”
		   Total Levels : N → N/2 → N/4 → ... → log N levels
		   So => O(N × log N)
		 */
		
	}

	private static Node Sort(Node h) // T.C = O(N * log N) 
	{								 // S.C = O(log N) (due to recursion)
		if(h==null)
		{
			return h;
		}
		
		if(h.next==null)
		{
			return h;
		}
		
		Node m=Mid(h);
		Node h1=m.next;
		m.next=null;
		
		h=Sort(h);
		h1=Sort(h1);
		
		return Merge(h,h1);
		
	}

	private static Node Merge(Node h1, Node h2) // T.C = O(N+M)
	{											// S.C = O(1)
		 Node dummy=new Node(-1);
		 Node t=dummy;
		 
		 while(h1!=null && h2!=null)
		 {
			 if(h1.data < h2.data) 
			 {
				t.next=h1;
				h1=h1.next;
			 }
			 else
			 {
				 t.next=h2;
				 h2=h2.next;
			 }
			 t=t.next;
		 }
		 
		 if(h1!=null)
		 {
			 t.next=h1;
		 }
		 else
		 {
			 t.next=h2;
		 }
		 return dummy.next;
	}

	private static void print(Node smerge) // T.C = O(N)
	{									   // S.c = O(1)
		Node t=smerge;
		
		while(t!=null)
		{
			System.out.print(t.data+" ");
			t=t.next;
		}
	}

	private static Node mergeLinkedList(Node h1, Node h2) // T.C = O(N+M)
	{													  // S.C = O(1)
		if(h1==null)
		{
			return h2;
		}
		
		if(h2==null)
		{
			return h1;
		}
		
		Node h=null; // h → final merged list head
		Node t=null; // t → last node (tail)
		
		if(h1.data < h2.data) // h1 come first
		{
			h=h1;
			t=h1;
			h1=h1.next; // We might forget
		}
		else
		{
			h=h2;
			t=h2;
			h2=h2.next; // We might forget
		}
		
		while(h1!=null && h2!=null)
		{
		   if(h1.data <h2.data)
		   {
			   t.next=h1;
			   t=h1;// Yes, both move t to the next node, but t = t.next is a generic way, while t = h1 is a direct assignment.
			   h1=h1.next;
		   }
		   else
		   {
			   t.next=h2;
			   t=h2;
			   h2=h2.next;
		   }
		}
		
		if(h1!=null)
		{
			t.next=h1;
		}
		if(h2!=null)
		{
			t.next=h2;
		}
		
		return h;
	}

	private static Node Mid(Node h) // T.C = O(N)
	{								// S.C = O(1)
		if(h==null)
		{
			return h;
		}
		
		Node s=h;
		Node f=h;
		
		while(f.next!=null && f.next.next!=null)
		{
			s=s.next; // 1-Step
			f=f.next.next; // 2-Steps
		}
		return s;// Reached Mid.
	}

}
