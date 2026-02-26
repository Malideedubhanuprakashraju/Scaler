package Classes;

public class Class_30_Linked_List_1 
{

	public static void main(String[] args) 
	{
		 Node h=new Node(10);
		 Node t=h;
		 
		 t.next=new Node(20);
		 t=t.next;
		 
		 t.next=new Node(30);
		 t=t.next;
		 
		 t.next=new Node(40);
		 t=t.next;
		 
		 t.next=new Node(50);
		 t=t.next;
		 
		 t.next=new Node(60);
		 t=t.next;
		 
		 t.next=new Node(70);
		 t=t.next;
		 
		 // Q1) Search for X in LinkedList
		 
		 boolean ans1=Search(h,40);
		 System.out.println("K is Present in Linked List : "+ans1);
		 
		 // Q2) Insert in a Linked List
		 /*
		  * Given a Head Node of Linked List & B,C
		  * Create a Node with Value of B and insert at index C
		  * 
		  * Return Head Node of Linked List After Insertion
		  * 
		  * Note 1: Assume index is Starts with 0 in Linked List.
		  * 
		  * Note 2: If C >= Length of Linked List, Insert at Back.
		  *   
		  */
		 int B=100; // Value
		 int C=6; // Position
		 
		 Node h1=Insert(h,B,C);
		 System.out.println(h);
		 print(h1);
		 
		 // Q3) Delete a Given Node 
		 /*
		  * Given Head Node at index B in the given Linked List.
		  * 
		  * Return Head Node of Linked List
		  * 
		  * Constraints : 0 <= B < Size of LinkedList ==> if h==null : Size of Linked List = 0
		  * 
		  */
		 
		 int b=6;
		 
		 Node h2=Delete(h,b);
		 System.out.println();
		 System.out.println("Deleted Ele in Linked List is : "+b+" Position");
		 print(h2);
		 
		 // Q4) Reverse of a Linked List
		 /*
		  * Given a LinkedList, Reverse Entire LinkedList & Return Head Node
		  * 
		  * We can only change next of a Node.
		  * 
		  * Note : No Extra Space & we Cannot Change value of a Node.
		  * 
		  * 
		  * Idea-1 : If we add Data at Start : We Will get Reverse Order
		  * 
		  * 		 Isolate 1^st Node from Head & insert before RH.
		  * 
		  */
		 Node h3=Reverse(h2);
		 System.out.println();
		 System.out.println("After Reversing Linked List : ");
		 print(h3);
		 
		 // Q5) Delete All Occurrences of X
		 
		 Node hh=new Node(20);
		 Node tt=hh;
		 
		 tt.next=new Node(10);
		 tt=tt.next;
		 
		 tt.next=new Node(19);
		 tt=tt.next;
		 
		 tt.next=new Node(10);
		 tt=tt.next;
		 
		 tt.next=new Node(16);
		 tt=tt.next;
		 
		 tt.next=new Node(15);
		 tt=tt.next;
		 
		 tt.next=new Node(70);
		 tt=tt.next;
		 
		 // Multiple Ways
		 /*
		  * 1) Recursive Way => Now
		  * 
		  * Assumption : Delete All Nodes with Value = k & Return New Head Node
		  *  
		  */
		 int k=10;
		 Node h4=deleteAll(hh,k);
		 System.out.println();
		 System.out.println("Recursive Code : ");
		 print(h4);
		 
		 /*
		  * 2) Iterative Way
		  * 
		  */
		  Node h5=deleteAllIterative(hh,k);
		  System.out.println();
		  System.out.println("Iterative Code : ");
		  print(h5);
		 
		 
		 
	}

	private static Node deleteAllIterative(Node head, int k)
	{
	    // Remove matching nodes from beginning
	    while(head != null && head.data == k)
	    {
	        head = head.next;
	    }

	    Node curr = head;

	    while(curr != null && curr.next != null)
	    {
	        if(curr.next.data == k)
	        {
	            curr.next = curr.next.next;   // Skip the node
	        }
	        else
	        {
	            curr = curr.next;
	        }
	    }

	    return head;
	}

	private static Node deleteAll(Node hh, int k) // T.C = O(N)
	{											  // S.C = O(N)//Recursive Stack Space
		if(hh==null)
		{
			return hh;
		}
		
		Node t=deleteAll(hh.next,k);
		
		if(hh.data==k)
		{
			return t;
		}
		else
		{
			hh.next=t;
			return hh;
		}
	}

	private static Node Reverse(Node h2) // T.C = O(N)
	{									 // S.C = O(1)
		Node rh=null;
		
		while(h2!=null)
		{
			Node t=h2; 
			h2=h2.next; // Isolating Head Node
			// t.next=null;
			t.next=rh; // Inserting before RH
			rh=t;// Updating rh
			
		}
		return rh;
	}

	private static Node Delete(Node h, int b) // T.C = O(N)
	{										  // S.C = O(1)
		if(h==null)
		{
			return h;
		}
		
		if(b==0)
		{
			h=h.next;
			return h;
		}
		
		Node t=h;
		
		for(int i=0;i<b-1;i++)
		{
			t=t.next;
		}
		t.next=t.next.next;
		
		return h;
	}

	private static void print(Node h1)
	{
		Node t=h1;
		
		while(t!=null)
		{
			System.out.print(t.data+" ");
			t=t.next;
		}
	}

	private static Node Insert(Node h, int b, int c) // T.C = O(N)
	{ 												 // S.C = O(1)
		// if h==null
		Node nn=new Node(b);
		
		if(h==null)
		{
			nn.next=h;
			h=nn;
			
			return h;
		}
		
		// if Position c=0 
		
		if(c==0)
		{
			nn.next=h;
			h=nn;
			
			return h;
		}
		
		// If we insert at C^th Position
		/*
		 * Take t to C-1^th Index Node
		 * 
		 * nn.next = t.next;
		 * t.next=nn;
		 * 
		 * Note : If we don't Store Address of an Object.
		 * 
		 * 		  Java will free Memory Allocated to Object using Garbage Collector
		 * 
		 */
		
		// If we insert at Last Position
		/*
		 * Need to check ==> While Updating Temp :
		 * 
		 * 					 if(temp.next == null)
		 * 					 {
		 * 						break;
		 * 					 }
		 * 
		 */
		
		Node t=h; // Move t = c-1^index : [ if( t==c-1 : Index Stop) ]
		
		for(int i=0;i<c-1;i++)
		{
			if(t.next == null)// For Last Position
			{
				break;
			}
			t=t.next;
		}
		nn.next=t.next;
		t.next=nn;
		
		
		return h;
		
	}

	private static boolean Search(Node h, int k) // T.C = O(N)
	{
		 Node t=h;
		 
		 /* if(t.next!=null)
		  * {
		  * 	1) We won't Compare Last Node
		  * 	2) If t==null, we will get Null Pointer
		  * 	
		  * }
		  * 
		  * if(t.data!=X)
		  * {
		  * 	1) when t is Null : Null Pointer Exception
		  * }
		  * 
		  * Time Complexity to Access K^th Element in Linked List : O(K)
		  */
		 
		 while(t!=null)
		 {
			 if(t.data==k)
			 {
				 return true;
			 }
			 t=t.next;
		 }
		 return false;
	}

}
