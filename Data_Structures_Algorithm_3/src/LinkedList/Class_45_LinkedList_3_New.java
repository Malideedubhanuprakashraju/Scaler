package LinkedList;

import java.util.HashMap;

class Nod
{
	int key;
	int value;
	
	Nod prev,next;
	
	Nod(int k,int v)
	{
		key=k;
		value=v;
		
		prev=null;
		next=null;
	}
}

public class Class_45_LinkedList_3_New 
{
	Nod head=new Nod(-1,-1);
	Nod tail=new Nod(-1,-1);
	
	HashMap<Integer,Nod> hm=new HashMap<>();
	
	int cap=0;// Global Variable
	
	public Class_45_LinkedList_3_New(int capacity)
	{
		cap=capacity;// Initialize Global with Local
		head.next=tail;
		tail.prev=head;
	}
	
	public int get(int k)// T.C = O(1)
	{
		if(hm.containsKey(k)==true)
		{
			// K is present , we access it's Address from HashMap
			// Where ever k is present delete it and add it at back { before tail }.
			
			Nod t=hm.get(k);// Current address
			delete(t);// Delete Current t
			addBeforeTail(t);// Adding t node before Tail
		    return t.value;
		}
		else
		{
			return -1;
		}
	}
	
	public void set(int k,int v)// T.C = O(1)
	{
		if(hm.containsKey(k)==true)
		{
			// K is present , we access it's Address from HashMap
			// Where ever k is present delete it and add it at back { before tail }.
						
			Nod t=hm.get(k);// Current address
			delete(t);// Delete Current t
			addBeforeTail(t);// Adding t node before Tail
			t.value=v; // We are updating value
		}
		else // K is not present
		{
			if(hm.size()==cap)// We need to delte from Front
			{
				Nod t=head.next;
				delete(t);// Delete t from LinkedList
				hm.remove(t.key);// Delete k and value from HashMap
			}
			
			Nod nn=new Nod(k,v);// New Nod we are Creating
			addBeforeTail(nn);
			hm.put(k, nn);// Insert Key and Address in the HashMap
		}
	}

	private void addBeforeTail(Nod nn) // Adding Node before Tail // T.C = O(1)
	{
		 Nod temp=tail.prev;
		 
		 temp.next=nn;
		 nn.prev=temp;
		 
		 nn.next=tail;
		 tail.prev=nn;		
		
	}

	private void delete(Nod nn) // Delete the given temp Node // T.C = O(1)
	{
		Nod t1=nn.prev;
		Nod t2=nn.next;
		
		t1.next=t2;
		t2.prev=t1;
		
		nn.next=null;
		nn.prev=null;
	}

	public static void main(String[] args) 
	{
		/*
		 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

			get(key) – Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
			set(key, value) – Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
			
			The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
			
			Definition of "least recently used":
			An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
			
			NOTE: If you are using any global variables, make sure to clear them in the constructor.
		 */
		
		/* Eg : Limit : 5{Ele}
		 * 
		 * 	    Data : 7	3	9	2	6	10	14	2	10	 14	  8	  14	8	14	 15	 20	  14  17
		 * 
		 * 		Old {front}																	New {Back}
		 * 		--------------------------------------------------------------------------------------
		 * 		Cache	: 7	 3	9	2	6	 
		 * 		--------------------------------------------------------------------------------------
		 * 		Note : In Cache Duplicates not Allowed ? If a same comes, we arrange position to Latest.
		 * 
		 * 
		 * Flow Chart :
		 * ----------
		 * 
		 * 						Insert(X)
		 * 							|
		 * 			|-----------------------------|
		 * 		X- Present					 X-Not Present
		 * 			|							   |
		 * 			|							   |
		 * 		Delete(X)					 if(cache==limit)
		 * 		insertBack(X)				 {
		 * 										Delete LRU Ele, from Front
		 * 									 }
		 * 									 insertBack(X)
		 * 
		 * Suitable DataStructure :
		 * 
		 * 1) DLL : We can Delete in O(1), If we know Address
		 * 
		 * 2) HashMap< Key, Node Address > hm :
		 * 		
		 * 	  a) Given Key get Address from HashMap
		 * 
		 * 	  b) Using Node Address, we can now Delete
		 * 
		 * LRU Cache using DLL + HashMap
		 * -----------------------------
		 * 
		 * Note : To avoid edge cases, we create 2 dummy nodes head & last
		 * 
		 * 1) Any insertions we perform between head & last.
		 * 
		 * 2) Head & Last will not change.
		 * 
		 * 👉 “We use a HashMap for O(1) access and a Doubly Linked List for O(1) insertion/deletion, 
		 *     giving both get and set operations constant time with O(capacity) space.”
		 *  Time Complexity:
			get()  -> O(1)
			set()  -> O(1)
			✅ Total TC: O(1)
			
			Space Complexity:
			O(C)   (where C = capacity)
			
			Space Complexity (SC)

			Let capacity = C
			✅ Space Complexity: O(C)
			HashMap stores at most C key-node pairs → O(C)
			Doubly Linked List stores at most C nodes → O(C)
		 *  
		 */
		Class_45_LinkedList_3_New c=new Class_45_LinkedList_3_New(4);
		 
		c.set(2,6);
		c.set(1,9);
		c.set(3,10);
		c.set(4,10);
		c.set(5,11);
		c.set(3,12);
		System.out.println(c.get(10));
		System.out.println(c.get(5));
		
	}

}
