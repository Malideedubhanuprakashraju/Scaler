package Trees;

class Node2
{
	int data;
	Node2 left;
	Node2 right;
	
	Node2(int x)
	{
		data=x;
		left=null;
		right=null;
	}
	
}

public class Class_35_Trees_3 
{

	public static void main(String[] args) 
	{
		/* Binary Search Tree
		 * 
		 * Def : A BT is BST if for all Nodes ---> Node > All nodes in LST
		 * 									  |
		 * 									  ---> Node < All nodes in RST
		 * 
		 * Note-1 : If a Node or If a Side is Null --> Assume it satisfies condition
		 * 
		 * Note-2 : In BST, Values are Distinct.
		 * 
		 * Note : In case we need to duplicate in BST, we generally avoid keep duplicates in LST
		 * 
		 * 
		 * For all Nodes ==> Node >= All nodes in LST(>= -> Because of Repetition)
		 * 					 Node < All nodes in RST
		 * 
		 *  		
		 */
		
		Node2 h=new Node2(4);
		h.left=new Node2(0);
		h.right=new Node2(10);
		h.left.left=new Node2(1);
		h.left.right=new Node2(3);
		h.right.left=new Node2(7);
		h.right.right=new Node2(15);
		h.right.left.left=new Node2(6);
		h.right.left.right=new Node2(9);
		
		
		// Q1) Search K in BST
		
		boolean ans=SearchK(h,90);
		System.out.println("K is Present in BST : "+ans);
		
		// Q2) Insert in BST : Whenevr we insert a Node in BST, we insert at Leaf Node.
		//	   Insert & Return Root Node
		
		Node2 R=insert(h,8);
		print(R);
		
		// Q3) Find Smallest Element in BST
		
		int ans1=Smallest(h);
		System.out.println("Smallest Element in BST is : "+ans1);
		
		// Q4) Find Largest Element in BST
		
		int ans2=Largest(h);
		System.out.println("Largest Element in BST is : "+ans2);
		
		// Conclusion : Smallest & Largest Nodes in BST has at Max {0,1} 1-Child
		
		/* Note :
		 * 
		 * 1) We Cann't delete Node with 2-Child
		 * 
		 * Q) Can we delete Node with 0 or 1 cChild ? Yes
		 * 
		 * 3) Replace K Node with Node with 0 or 1-Child  & delete replaced Node.
		 * 
		 * Q) Which Node to replace we have Many Options ?
		 * 
		 * Obs : It's BST, means over after replacing --> It Should hold BST Property.
		 * 
		 * 				Node : K
		 * 
		 * All Node < K			 All Node > K
		 * 
		 * Eg-1 :
		 * 
		 * 				30
		 * 15,10,25,20		35,38,32,40
		 * 
		 * Obs : Replace with Max on Left or Min on Right
		 *  
		 */
		
		// Q5) Delete a Node in BST
		
		//	1) Leaf		2) 1-Child	3) 2-Child
		/*
		 *  Note : Return Root Node after Deletion
		 *    
		 */
		// Ass : Delte K in BST & Return Root Node.
		
		System.out.println("Delted Element in Tree");
		Node2 ans3=Delete(h,0);
		print(ans3);
		
		/* Simple Example
		 * 
		 * Before deleting 10:
		 *         10
       			  /  \
      			 7    15
     			/ \
    		   6   9
		 * 
		 * Step 1: Find largest in left subtree
		 * 
		 * Largest = 9
		 * 
		 * Step 2: Replace
		 * 
		 *         9
       			  /  \
      			 7    15
     			/ \
    		   6   9   ← duplicate
		 * 
		 * Step 3: Delete duplicate 9
		 * 
		 *         9
       			  /  \
      			 7    15
     			/
    		   6
		 * 
		 * 
		 */
		
		/* Full Flow Summary

		   Find node k

		   Apply:

		   Leaf → delete

		   One child → replace

		   Two children → replace with max(left)

		   Return updated tree
		 */
		
		// Memory Trick
		// Delete in BST = 3 Cases
		
		/*
		 * | Case       | Action                 |
		   | ---------- | ---------------------- |
	       | Leaf       | return null            |
           | 1 child    | return child           |
           | 2 children | replace with max(left) |

		 */
		
		// “Why not O(N) always?”
		/*
		 * Because BST reduces search space like binary search → depends on height, not total nodes.
		 */
	}

	private static Node2 Delete(Node2 h, int k) // T.C = O(H)
	{											// S.C = O(H)
		if(h==null)
		{
			return null;
		}
		
		if(h.data==k) // We reached Node we want to Delete
		{
			// Case 1: Node is a LEAF (no children)
			if(h.left==null && h.right==null)
			{
				return null;// Just delete it ==> Return null to parent
			}
			
			// Case 2: Node has ONE child
			if(h.left==null && h.right!=null)// Only right child: ==> Replace node with its child
			{
				return h.right;
			}
			
			if(h.left!=null && h.right==null)// Only left child: ==> Replace node with its child
			{
				return h.left;
			}
			
			// Case 3: Node has TWO children (MOST IMPORTANT)
			
			// Find largest value in left subtree
			int max=Largest(h.left); // max from left subtree
						// Why use Largest(h.left)?
						// In BST:

						// Left subtree values are smaller

						// The largest of left subtree is the best replacement
			
			
			//Replace current node with that value
			h.data=max;
			
			// Delete that duplicate from left subtree
			h.left=Delete(h.left,max);// Delete Max in LST & Return Root of LST
			
			return h;
		}
		
		// Remaining Code (Traversal part)
		if(h.data>k)
		{
			h.left=Delete(h.left,k);// Delete K in LST & return root of LST
		}
		else
		{
			h.right=Delete(h.right,k);// Delete K in RST & return root of RST
		}
		// This is just searching for the node like BST search
		
		return h;// Always return the updated root
	}

	private static int Largest(Node2 h) // T.C = O(H)
	{	 							    // S.C = O(1)
		Node2 t=h;
		if(h==null)
		{
			return 0;
		}
		 while(t.right!=null)
		 {
			 t=t.right;
		 }
		 return t.data;
	}

	private static int Smallest(Node2 h) // T.C = O(H)
	{									 // S.C = O(1)
		 Node2 t=h;
		 if(h==null)
		 {
			return 0;
		 }
		 while(t.left!=null)
		 {
			 t=t.left;
		 }
		 return t.data;
	}

	private static void print(Node2 r) // T.C = O(N)
	{								   // S.C = O(1)
		 if(r==null)
		 {
			 return;
		 }
		 System.out.println(r.data);
		 print(r.left);
		 print(r.right);
	}

	private static Node2 insert(Node2 h, int k) // T.C = O(H)
	{											// S.C = O(1)
		Node2 nn=new Node2(k);
		
		if(h==null)
		{
			return nn; // nn is acting as Root Node
		}
		
		Node2 t=h;
		
		while(t!=null)
		{
			if(t.data<k) // Go to Right
			{
				if(t.right==null)
				{
					t.right=nn;
					break;
				}
				t=t.right;
			}
			else // Go to Left
			{
				if(t.left==null)
				{
					t.left=nn;
					break;
				}
				t=t.left;
			}
		}
		
		return h; // After Inserting Node, Return Root Node
		
	}

	private static boolean SearchK(Node2 r, int k) // T.C = O(H) => Root Node to one of Leaf Node ==> Worst Case : Length of Longest Path from Root -> Leaf : Height
	{											   // S.C = O(1)
		Node2 t=r;
		while(t!=null)
		{
			if(t.data==k)
			{
				return true;
			}
			
			if(t.data>k)
			{
				t=t.left;
			}
			else
			{
				t=t.right;
			}
		}
		
		return false;
	}

}
