package Trees;

class Node
{
	int data;
	Node left,right; // Object References = Stores Address of Class Object
	
	Node(int x)
	{
		data=x;
		left=null;
		right=null;
	}
}
public class Class_33_Trees_1 
{

	public static void main(String[] args) 
	{ 
		// Trees
		/*
		 * Introduction to Trees
		 * 
		 * Terminologies
		 * 
		 * Tree Traversals
		 * 
		 * Tree Constructions
		 * 
		 * Recursive Code :
		 * 
		 * 1) Assumption = Question/Decide What your function does
		 * 
		 * 2) Main Logic = Solving Problem, with Subproblems
		 * 
		 * 3) Base Condition = Code Stop
		 * 
		 */
		
		/* Linear Data Structures
		 * ---------------------
		 * 
		 * 1) Arrays
		 * 
		 * 2) LinkedList
		 * 
		 * 3) Stacks/Queues
		 * 
		 * Heirarchial Data Structures
		 * --------------------------
		 * 
		 * 1) Trees
		 * 
		 * 2) Graphs
		 * 
		 * Eg : a) Company Organisation
		 * 		
		 * 		b) Family Tree
		 * 
		 * 		c) File System / File Directory
		 *  
		 */
		
		/* Trees
		 * -----
		 * 
		 * 	O: Nodes
		 * 
		 *  -: Edges ==> To Connect 2-Nodes
		 *  
		 *  Root : Node without Parent
		 *  
		 *  Parent : A Node with Child Nodes
		 *  
		 *  Child : A Node with Parent Node
		 *  
		 *  Leaf : A Node without Child Nodes
		 *  
		 *  Depth : Level at which Node Resides in Tree
		 *  
		 *  Height(Node) : Length of Longest Path from given Node to any of it's Leaf Node.
		 *  
		 *  Height of Tree = Height(root)
		 *  
		 *  Obs : Height(Leaf) = Edges : 0, Nodes : 1
		 *  
		 *  Obs : Height with Nodes = 1+Height with Edges
		 *  
		 *  
		 *  Siblings : Node which share same Parent Node
		 *  
		 *  Ancestors : All Nodes from Parent to Root Node Upward are Ancestors of Nodes.
		 *  
		 *  
		 *  Note : For any Node in a Tree, We can only have 1-Parent
		 *  
		 *  SubTree : Tree Structure That is part of Larger Tree, which is rooted at a Particular Node 
		 *  
		 *  		  { Consider all decendents of that Node }
		 *  
		 *  Note : It can be Single Leaf Node also.
		 *  
		 *  Note : Whole Tree can also be a Subtree.
		 *   
		 */
		
		// Binary Tree : A Tree in which Every Node can at Max have 2 - Childrens {0,1,2}
		
		// Note : Lot of Tree Problems can be solved using Recursion.
		
		
		Node r=new Node(14);
		r.left=new Node(18);
		r.right=new Node(19);
		r.left.left=new Node(7);
		r.left.right=new Node(3);
		r.right.left=new Node(10);
		r.right.right=new Node(8);
		r.right.left.right=new Node(4);
		
		/* Tree Traversal
		 * -------------
		 * 
		 * 1) Pre-Order
		 * 
		 * 2) In-Order
		 * 
		 * 3) Post-Order
		 * 
		 *  
		 */
		
		/* Pre-Order : Data Left Right ( DLR )
		 * ---------
		 * 
		 * Step-1 : Print(Root.Data)
		 * 
		 * Step-2 : Go to Left SubTree & Print Entire Left SubTree in Pre-Order
		 * 
		 * Step-3 : Go to Right Subtree & Print Entire Right SubTree in Pre-Order
		 *   
		 */
		
		// Assumption : Given a Root Node of BT, Print Entire BT in Pre-Order
		
		preOrder(r);
		
		/* In-Order : Left data Right ( LDR )
		 * --------
		 * 
		 * Step-1 : Go to Left SubTree & Print Entire Left SubTree in In-Order
		 * 
		 * Step-2 : Print (Root.Data)
		 * 
		 * Step-3 : Go to Right SubTree & Print Entire Right Subtree in In-Order
		 *  
		 */
		System.out.println("In-Order : ");
		inOrder(r);
		
		/* Post-Order : Left Right Data
		 * 
		 * Step-1: Go to Left SubTree & Print Entire Left SubTree in Post-Order
		 * 
		 * Step-2: Go to Left SubTree & Print Entire Left SubTree in Post-Order
		 * 
		 * Step-3: Print(root.data)
		 *  
		 */
		System.out.println("Post-Order : ");
		
		postOrder(r);
		
		System.out.println("Given a Root Node : Return Size of Binary Tree ");
		
		int n=size(r);
		System.out.println(n+" Size ");
		
		// Observation : Each Node is  Root Node for it's SubTree. Value Returned by Node is Information about That SubTree.
		
		// Q) Sum of All Nodes
		int ans=sumNodes(r);
		System.out.println("Sum Nodes : "+ans);
		
		// Q) Given a BT & Target
		//	  Check if there exists a SubTree with Sum == Target
		
		// Idea-1 : Generate all Subtree Sums == Target
		
		boolean ans1=solve(r,14);
		System.out.println("Subtree Exist : "+ans1);
	}
	static boolean isPossible=false;
	private static boolean solve(Node r, int t) 
	{
		isPossible=false;
		sumNodes(r,t);
		return isPossible;
	}

	private static int sumNodes(Node r, int k) // T.C = O(N)
	{										   // S.C = O(H)	
		if(r==null)
		{
			return 0;
		}
		
		int l=sumNodes(r.left,k);
		int rs=sumNodes(r.right,k);
		if(l+rs+r.data==k)
		{
			isPossible=true;
		}
		
		return l+rs+r.data;
	}

	private static int sumNodes(Node r) // T.C = O(N)
	{									// S.C = O(H)
		 if(r==null)
		 {
			 return 0;
		 }
		 
		 int l=sumNodes(r.left);
		 int rs=sumNodes(r.right);
		 
		 return l+rs+r.data;
	}

	private static int size(Node r) // T.C = O(N)
	{								// S.C = O(H)
		if(r==null)
		{
			return 0;
		}
		
		int l=size(r.left);
		int rs=size(r.right);
		
		return l+rs+1;
	}

	private static void postOrder(Node r) // T.C = O(N)
	{									  // S.C = O(Height of Tree)
		 if(r==null)
		 {
			 return;
		 }
		 
		 postOrder(r.left);
		 postOrder(r.right);
		 System.out.println(r.data);
	}

	private static void inOrder(Node r) // T.C = O(N)
	{									// S.C = O(Height of Tree)
		 if(r==null)
		 {
			 return;
		 }
		 
		 inOrder(r.left);
		 System.out.println(r.data);
		 inOrder(r.right);
	}

	private static void preOrder(Node r) // T.C = O(N)
	{									 // S.C = O(Height of Tree/Root)
		if(r==null)
		{
			return;//Go Back
		}
		System.out.println(r.data);
		preOrder(r.left);// LST in PreOrder
		preOrder(r.right);// RST in PreOrder
		
	}

}
