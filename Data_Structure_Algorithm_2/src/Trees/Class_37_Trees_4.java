package Trees;

import java.util.Stack;

public class Class_37_Trees_4 
{

	public static void main(String[] args) 
	{ 
		/* 1) Iterative In-Order
		 * 
		 * Iterative Post-Order
		 * 						}
		 * Iterative Pre-Order
		 * 
		 * 2) Tree Construction from Pre-Order & In-Order
		 * 
		 * 3) sorted Order to BBST { Balanced Binary Search Tree }
		 *  
		 */
		
		/* Binary Tree Traversals
		 * 
		 * a) Pre-Order Traversal
		 * 
		 * b) In-Order Traversal		} Recursive Logic
		 * 
		 * c) Post-Order Traversal
		 * 
		 * d) Level-Order Traversal - Vers-1
		 * 									 } Iterative Logic	
		 * e) Level-Order Traversal - Vers-2
		 * 
		 */
		
		Node2 h=new Node2(3);
		h.left=new Node2(7);
		h.right=new Node2(4);
		h.left.left=new Node2(9);
		h.left.left.right=new Node2(10);
		h.left.left.right.left=new Node2(20);
		h.right.left=new Node2(15);
		h.right.right=new Node2(20);
		h.right.left.left=new Node2(19);
		
		
		// Q1) Iterative In-Order of a given Binary Tree
		
		/* Discussion
		 * 
		 * Case-1 : Curr!=null		st.size()>0
		 * 
		 * 			Curr!=null		st.size()==0 : Enter Loop
		 * 
		 * 			Curr==null		st.size()>0 : Enter Loop
		 * 
		 * Conclusion : Even if 1 of the condition is true, we will enter into Loop.
		 * 
		 * 
		 */
		
		inOrder(h);
		
		// Q2) Iterative Pre-Order of a given Binary Tree
		
		System.out.println();
		PreOrder(h);
		
		// Q3) Post-Order of a given Binary Tree
		
		/*
		 * 1. Go left as much as possible
		   2. Check right:
   					- Not visited → go right
   					- Already visited → print node
   					
   					Left done?
					→ YES
					
					Right done?
					→ NO → go right
					→ YES → print
		 */
		// “Print node only after both left and right are completed.”
		System.out.println();
		System.out.println("Post Order Traversal Way-1");
		PostOrder(h);
		
		System.out.println();
		System.out.println("Post Order Traversal Way-2");
		PostOrder2(h);
		
		
		/* 1 stack → O(h) (height-based)

		   2 stack → O(n) (stores full tree)
		 */
		
		// Q3) Given Pre-Order & In-Order of BT of Distinct Values
		//	   Print Post-Order Traversal
		
		/* Idea-1:
		 * 
		 * a) Given Pre[] & in[], create Binary Tree & Return Root
		 * 
		 * b) Use root node, print Post Order.
		 * 
		 */
		int pre[]= {8,6,2,11,16,10,12,4,14,9,18,15};
		int in[]=  {11,2,16,6,10,12,8,14,4,18,9,15};
		
		// Assumption : Given a Pre[] & Ino[] , Construct BT & Return Root Node.
		
		System.out.println();
		Node2 ans=solve(pre,in);
		
		System.out.println("Final Post Order from PreOrder & InOrder");
		postOrder(ans);
		
		// Q4) Construct Balanced Binary Search Tree from Sorted Array
		/*
		 * BBST : Balanced Binary Search Tree
		 * 
		 * Balanced Means : abs(Height(LST) - Height(RST))<=1
		 * 
		 * Binary Search Tree : For All Nodes (All LST <= Node < All RST)
		 *  
		 */
		
		// Assumption : Given an Array :
		// Convert into BBST & Return Root Node.
		
		int arr[]= {-1,2,3,4,6,7,8,10,13,14};
		Node2 ans1=convert(arr,0,arr.length-1);
		System.out.println();
		System.out.println("Balanced Binary Search Tree");
		
		postOrder(ans1);
		
	}

	private static Node2 convert(int[] arr, int l, int h) // T.C = O(N)
	{													  // S.C = O(log N) // Height = log N
		 if(l>h)										  // Space Complexity = O(log N)
		 {												  // “But we create N nodes → shouldn’t space be O(N)?”
			 return null;
		 }
		 int m=(l+h)/2;
		 Node2 root=new Node2(arr[m]);
		 root.left=convert(arr,l,m-1);
		 root.right=convert(arr,m+1,h);
		 
		 return root;
	}

	private static void postOrder(Node2 ans) 
	{
		 Node2 c=ans;
		 
		 Stack<Node2> st1=new Stack<>();
		 Stack<Node2> st2=new Stack<>();
		 st1.push(c);
		 
		 while(st1.size()>0)
		 {
			 Node2 curr=st1.pop();
			 st2.push(curr);
			 
			 if(curr.left!=null)
			 {
				 st1.push(curr.left);
			 }
			 if(curr.right!=null)
			 {
				 st1.push(curr.right);
			 }
		 }
		 
		 while(st2.size()>0)
		 {
			 System.out.print(st2.pop().data+" ");
		 }
	}

	private static Node2 solve(int[] pre, int[] in) 
	{
		 int n=pre.length;
		 return constructPostOrder(pre,0,n-1,in,0,n-1);
	}																						 //			Creating N->Nodes	
																							 // 		|---->Searching in Inorder		
	private static Node2 constructPostOrder(int[] pre, int i, int j, int[] in, int k, int l) // T.C = O(N * N) = O(N^2)
	{																						 // S.C = 	
		if(i>j)
		{
			return null;
		}
		// Step-1 : Root is 1^st Element of PreOrder in given Range.
		
		Node2 root=new Node2(pre[i]);
		
		// Step-2 : Search Root Node in InOrder in given Range.
		
		int ri=-1; // Root Index
		
		for(int a=k;a<=l;a++)
		{
			if(root.data==in[a])
			{
				ri=a;
				break;
			}
		}
		
		// Step-3 : Dividing into Subproblems
		
		int cl=ri-k; // Count of Element in LST
		
		root.left=constructPostOrder(pre,i+1,i+cl,in,k,ri-1); // Create LST & Return Root of LST
		root.right=constructPostOrder(pre,i+cl+1,j,in,ri+1,l);// Create RST & Return Root of RST
		
		return root;
	}

	private static void PostOrder2(Node2 h) // T.C = O(N)
	{ 										// S.C = O(N) // In 2-stack method, second stack stores entire tree → so space becomes O(n)
		if(h==null)
		{
			return ;
		}
		
		Stack<Node2> st1=new Stack<>();
		Stack<Node2> st2=new Stack<>();
		
		st1.push(h);
		
		while(st1.size()>0)
		{
			Node2 c=st1.pop();
			st2.push(c);
			
			if(c.left != null)
				st1.push(c.left);
			if(c.right!=null)
				st1.push(c.right);			
		}
		while(st2.size()>0)
		{
			Node2 cc=st2.pop();
			System.out.print(cc.data+" ");
		}
	}

	private static void PostOrder(Node2 h) // T.C = O(N)
	{									   // S.C = O(H)
		Stack<Node2> st=new Stack<>();
		
		Node2 curr=h;// used to traverse the tree
		Node2 lv=null;// (lastVisited) → remembers last printed node
		
		while(curr!=null || st.size()>0) // We still have nodes to visit (curr)
		{								 // OR stack has nodes to process
			
			//“Left subtree is processed first”
			if(curr!=null)// Go Left
			{
				st.push(curr);// Push it into stack
				curr=curr.left;// Move to left child
			}
			else// When curr == null: // We reached leftmost node 
			{
				Node2 peek=st.peek();// Now check top of stack (peek)
				
				
				// Check Right Subtree
				if(peek.right!=null && lv!=peek.right)// Right child exists ✔// AND it is NOT already visited ❌
				{
					// Go Right
					curr=peek.right;// Move to right subtree
				}
				else// Print Node // No right child OR Right child already visited
				{
					System.out.print(peek.data+" ");
					lv=st.pop();// Remove node from stack // Mark it as last visited
				}
			}
		}
	}

	private static void PreOrder(Node2 h) // T.C = O(N)
	{									  // S.C = O(H)
		 
		Stack<Node2> st=new Stack<>();
		
		st.push(h);
		
		while(st.size()>0)
		{
			 Node2 c=st.pop();
			 System.out.print(c.data+" ");
			 
			 if(c.right!=null)
			 {
				st.push(c.right);
			 }
			
			 if(c.left!=null)
			 {
				 st.push(c.left);
			 }
			
		}
	}

	private static void inOrder(Node2 h) // T.C = O(N)
	{									 // S.C = O(H)
		Node2 c=h;
		
		Stack<Node2> st=new Stack<>();
		
		while(c!=null || st.size()>0)
		{
			if(c!=null)
			{
				st.push(c);
				c=c.left;
			}
			else
			{
				c=st.peek();
				st.pop();
				System.out.print(c.data+" ");
				c=c.right;
			}
		}
		
	}

}
