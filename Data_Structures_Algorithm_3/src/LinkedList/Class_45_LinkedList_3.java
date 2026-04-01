package LinkedList;

class node
{
	int data;// storage box (inside object)
	node next;
	node prev;
	
	node(int x)// x = input box (temporary)
	{
		data=x;// Take value from input box → store in storage box ✔️
		next=null;// It Stores Address of Next Node
		prev=null;// It Stores Address of Prev Node
	}
}

class Nodd {
    int data;
    Nodd next;
    Nodd random;

    Nodd(int x) {
        data = x;
        next = null;
        random = null;
    }
}
public class Class_45_LinkedList_3 
{

	public static void main(String[] args) 
	{
		 /* DLL : Doubly Linked List
		  * ---
		  * 
		  * We can Travel from Left to Right & Right to Left ==> DLL
		  * 
		  * Real Life Application :
		  * 
		  * 1) Viewing Images
		  * 
		  * 2) Spotify :
		  * 
		  * 		   a) Previous Song
		  * 
		  * 		   b) Current Song
		  * 
		  * 		   c) Next Song
		  *  
		  */
		
		// Creating nodes
        node head = new node(10);
        node second = new node(20);
        node third = new node(30);
        node fourth = new node(40);

        // Linking nodes (DLL connection)
        head.next = second;

        second.prev = head;
        second.next = third;

        third.prev = second;
        third.next = fourth;

        fourth.prev = third;
		
		// Q1) Insert a NewNode Just before Tail of a Double Linked List
		/*
		 * Note-1 : Tail Ref is given in Input
		 * 
		 * Note-2 : No : of Nodes >= 2
		 * 
		 * Note-3 : New Node is already created & address is given
		 *   
		 */
		
        print(head);
        System.out.println();
        
        node nn=new node(35);
        node tail=fourth;
        
        inserBeforeTailNode(nn,tail);
        print(head);
        
        // Q2) Delete a Given Node from DLL, Delete that Node.
        /*
         * Note : Node Reference is given
         * 
         * Note : Given Node is not Head/Tail Node.
         * 
         * Note : Linked List is not Null
         * 
         * Note : Just isolate Node : { Detach Links }
         * 
         */
        deleteNode(nn);
        System.out.println();
        print(head);
        
        /* Delete from Middle
         * 
         * 1) Array/ ArrayList : T.C = O(N)
         * 
         * 2) Single Linked List : T.C = O(N)
         * 
         * 3) Double Linked List : T.C = O(1)// If we know Node Address.
         * 
         */
        
        /* Memory Hierarchy :
         * ----------------
         * 
         * Top to Down : Memory Increases			Register			Bottom to Up : Retrival Increases
         * 						|											  |	
         * 						|					 Cache					  |
         * 						|											  |
         * 						|					 RAM					  |
         * 						|											  |
         * 						|					ROM / Hard Disk           |
         * 
         * 
         * Cache : Limit Capacity : Follow  [ LRU : Last/Least Recently Used ] & Perform Operations.
         * 
         * Note : In Cache Duplicates not Allowed ? If a Same Comes, we arrange position to Latest
         * 
         */
        
		System.out.println();
		System.out.println("Palindrome Linked List : ");
		
		// Q3) Given Head Node of LinkedList, Check if Palindrome or Not ?
		
		node h = new node(1);
        node s = new node(2);
        node t = new node(3);
        node f = new node(2);
        node fi = new node(1);

        // Linking nodes
        h.next = s;
        s.next = t;
        t.next = f;
        f.next = fi;

        // head -> 1 -> 2 -> 3 -> 2 -> 1
        
        print(h);
        System.out.println();
        
        /* Step-1 :
         * 
         * Get the Centre & Divide into 2-Parts/Halfs
         * 
         * Node m= mid(h1);
         * Node h2=m.next;
         * m.next=null;
         * 
         * Step-2 :
         * 
         * Reverse 2^nd Part of LinkedList & Return Head Node.
         * 
         * h2 = reverse(h2);
         * 
         * 
         * Step-3 :
         * 
         * Compare both LinkedLists h1 & h2
         *  
         */
        boolean ans=Palindrome(h);
        System.out.println("Palindrome List is : "+ans);
        
        // Q4) Clone LinnkedList 
        /*
         * Next : Holds Address of Next Node of LinkedList
         * 
         * Rand : Holds Address of some Random Node of LinkedList
         * 
         * Create a Exact Copy of given Linked List & Return Head Node of Copy
         * 
         * Copy Means : Data Should be same & Overall Structure should be same
         * 
         * 
         * Create Copy : { New Copy won't come under extra space }
         * 
         * Note : Expected T.C = O(N),	S.C = O(1)
         * 
         * 
         * Note : Have atleast 1 rand to NULL
         * 
         * Step-1 :
         * ------
         * 
         * Between t & t.next, create and insert a new node with t.data
         * 
         * 
         * Step-2 :
         * ------
         * 
         * Arrange Rand Links in Copy Links
         * 
         * 
         * Step-3 :
         * ------
         * 
         * Setting Next in Original & Copy Linked List.
         * 
         * Note : We need to Store Head Node of Copy Linked List.
         *   
         */
        Nodd ch = new Nodd(1);
        Nodd cs = new Nodd(2);
        Nodd ct = new Nodd(3);
        Nodd cf = new Nodd(4);

        // next links
        ch.next = cs;
        cs.next = ct;
        ct.next = cf;

        // random links
        ch.random = ct;   // 1 → 3
        cs.random = ch;   // 2 → 1
        ct.random = cf;   // 3 → 4
        cf.random = cs;   // 4 → 2
		
        Nodd ans1=Clone(ch);
        printt(ans1);
        
        /*
         * | Operation           | Time Complexity | Space Complexity |
		   | ------------------- | --------------- | ---------------- |
		   | Insert before tail  | O(1)            | O(1)             |
		   | Delete node         | O(1)            | O(1)             |
		   | Print               | O(N)            | O(1)             |
		   | Find mid            | O(N)            | O(1)             |
		   | Reverse             | O(N)            | O(1)             |
		   | Palindrome          | O(N)            | O(1)             |
		   | Clone (with random) | O(N)            | O(1)             |

         */
	}

	private static Nodd Clone(Nodd ch) // T.C = O(N)
	{								   // S.C = O(1)
		// To Create Nodes
		
		Nodd t=ch;
		while(t!=null)
		{
			Nodd nn=new Nodd(t.data);
			nn.next=t.next;
			t.next=nn;
			t=nn.next;
		}
		
		// To Copy Random Links
		
		t=ch;
		while(t!=null)
		{
			if(t.random!=null)
			{
				t.next.random=t.random.next;
			}
			t=t.next.next;
		}
		
		// To Copy Next Links & Return Clone Head
		
		Nodd t1=ch;
		Nodd t2=ch.next;
		
		Nodd CH=t2;
		
		while(t1!=null)
		{
			t1.next=t2.next;
			t1=t1.next;
			
			if(t1!=null)
			{
				t2.next=t1.next;
			}
			t2=t2.next;
		}
		
		return CH;
	}

	private static boolean Palindrome(node h) // T.C = O(N+N+N)= O(N)
	{										  // S.C = O(1)
		node m=mid(h);
		node h2=m.next;
		m.next=null;// Detach 1^st & 2^nd Halfs
		
		h2=reverse(h2);
		
		while(h!=null && h2!=null)
		{
			if(h.data==h2.data)
			{
				h=h.next;
				h2=h2.next;
			}
			else
			{
				return false;
			}
		}
		
		return true;
	}

	private static node reverse(node h2) // T.C = O(N)
	{									 // S.C = O(1)
		
		 node prev=null; // Initially, previous node is null (end of reversed list)
		 node current=h2; // Start from head of given list

		 
		 while(current!=null) // Traverse until end of list
		 {
			 node next=current.next; // Store next node (backup), so we don’t lose remaining list
			 
			 current.next=prev; // Reverse link: make current node point to previous node
			 prev=current; // Move prev forward (prev becomes current node)
			 
			 current=next; // Move curr forward (go to next node)
			 
		 }
		 return prev; // prev becomes new head of reversed list
		 
		 /*
		  * | Step | Code               | Meaning        |
			| ---- | ------------------ | -------------- |
			| 1    | `next = curr.next` | Save next node |
			| 2    | `curr.next = prev` | Reverse link   |
			| 3    | `prev = curr`      | Move prev      |
			| 4    | `curr = next`      | Move curr      |

		  */
	}

	private static node mid(node h) 
	{
		node s=h;
		node f=h;
		
		while(f!=null && f.next!=null)
		{
			s=s.next;
			f=f.next.next;
		}
		return s;
	}

	private static void deleteNode(node nn) 
	{
		node t1=nn.prev;
		node t2=nn.next;
		
		t1.next=t2;
		t2.prev=t1;
		
		nn.next=null;
		nn.prev=null;
	}

	private static void inserBeforeTailNode(node nn, node tail) // T.C = O(1)
	{															// S.C = O(1)
		 node temp=tail.prev;
		 
		 temp.next=nn;
		 nn.prev=temp;
		 
		 nn.next=tail;
		 tail.prev=nn;		 
	}

	private static void print(node head) 
	{
		node t=head;
		
		while(t!=null)
		{
			System.out.print(t.data+" ");
			t=t.next;
		}
	}
	private static void printt(Nodd head) 
	{
		Nodd t=head;
		
		while(t!=null)
		{
			System.out.print(t.data+" ");
			t=t.next;
		}
	}

}
