package Trees;

import java.util.LinkedList;
import java.util.Queue;


public class Class_34_Trees_2 
{
	static boolean flag;
	public static void main(String[] args) 
	{
		// Level Order Traversal : Left -> Right
		/*
		 * 			3
		 * 	   7		  4
		 * 9	  12   15	20
		 *    10     19  26
		 *    
		 * Idea : Traverse Level by Level : Queue
		 * 
		 * Trace : 3  7	 4	9	12	15	20	10	19	26
		 * 
		 * 
		 * PseudoCode :
		 * 
		 * 1) Take a Queue & Insert Root Node
		 * 
		 * 2) Repeat until queue is Empty :
		 * 
		 * 					Pop front Element in queue, print it, Push it's not Null children in Queue.
		 *  
		 */
		 
		Node h=new Node(3);
		h.left=new Node(7);
		h.right=new Node(4);
		h.left.left=new Node(9);
		h.left.right=new Node(12);
		h.left.left.right=new Node(10);
		h.right.left=new Node(15);
		h.right.right=new Node(20);
		h.right.left.left=new Node(19);
		h.right.left.right=new Node(26);
		
		// Q1) Print Level Order Traversal
		// O/P = 3  7	4	9	12	15	20	10	19	26
		
		
		LevelOrder(h);
		// Note-1 : At Last Level Every Node has to be a Leaf Node.
		// Note-2 : Printing Nodes Top to Bottom : Level Order Traversal
		
		// Q2) Level Order Traversal 
		/*
		 * 3
		 * 7	4
		 * 9	12	15	20
		 * 10	19	26
		 * 
		 * Idea-1 :If we Pop & Push Children, for all Nodes in one Level, We Will get All Nodes of Next Level.
		 * 
		 * 1^st Level Node
		 * 2^nd Level Node
		 * 3^rd Level Node
		 * 4^th Level Node
		 * 
		 * Issue : We need to diffrence between Levels
		 *  
		 */
		System.out.println();
		LevelOrder2(h);
		
		// Q3) Left View : Level by Level
		/*
		 * Observation : Print 1^st Node of Each Level
		 * 
		 * Output : 
		 * 
		 * 3
		 * 7
		 * 9
		 * 10
		 * 
		 */
		LeftView(h);
		System.out.println();
		
		// Q4) Right View 
		/*
		 * Observation : Print Last Nod of Each level
		 * 
		 * 3
		 * 4
		 * 20
		 * 26
		 * 
		 */
		System.out.println("Right View");
		RightView(h);
		
		/* Types of Binary Tree
		 * --------------------
		 * 
		 * 1) Proper Binary Tree : Every Node has 0 or 2(Child) L->R
		 * 
		 * Eg-1 : PBT
		 * 
		 * 			20
		 * 		30		40
		 * 50		60 
		 * 
		 * 
		 * 2) Complete Binary Tree : All Levels are Filled Except May be Last Level which is filled Left to Right Continously
		 * 	  					
		 * 							 Last Level Can be Filled or If Last Level not filled : L->R
		 * 
		 * Eg-1: CBT
		 * 		   	A
		 * 	  B			 C
		 * 
		 * D	E	F		 G
		 * 
		 * Eg-2: CBT
		 * 
		 * 			A
		 * 		B		C
		 * 
		 * D
		 * 
		 * 
		 * 3) Perfect Binary Tree : Every Node has 0 or 2 childs
		 * 
		 * 							All Leaf Nodes are at Same Level
		 * 
		 * Eg-1: PBT
		 * 
		 * 				A
		 * 		 B				C
		 * D		 E 		D		E
		 * 
		 * 
		 * Note : If a Tree is Perfect Binary Tree
		 * 
		 * 					Also    -> Proper Binary Tree
		 * 
		 * 							-> Complete Binary Tree
		 * 
		 */
		
		// Q5) Height : Based on Nodes : Length of Longest Path from Node to any of it's Leaf Node.
		
		// Assumption : Given Root Node : Calculate & Return Height of Tree
		
		int ans=Height(h);
		System.out.println("Height of Binary Tree "+ans);
		//“To calculate height in terms of edges, we return -1 for null so that leaf nodes return height 0, 
		//and the recursion correctly counts edges instead of nodes.”
		
		// Each Node is Root Node for it's Subtree. Value returned by Node is Height about that Subtree.
		
		// Q6) Given a Binary Tree, Check if it's Balanced or Not.
		/*
		 * Note : A Binary Tree is Said to Balanced if for Every Node : abs|Height(LST) - Height(RST)|<=1.
		 * 
		 *  
		 * Idea-1 : To get Balanced or Not
		 * 			
		 * 			For Every Node get hLST & hRST & abs|hLST - hRST| <= 1
		 * 
		 * Hint : When we calculate Height of Tree For Evry Node get hLST & hRST
		 *   			 
		 */
		
		boolean ans1=isBST(h);
		System.out.println("Is BST "+ans1);
		
	}

	private static boolean isBST(Node h) // T.C = O(N)
	{									 // S.C = O(H)
		 flag=true;
		 int ans=Height2(h);
		 return flag;
		 
	}

	private static int Height2(Node h) // T.C = O(N)
	{								   // S.C = O(H)
		if(h==null)
		{
			return 0;
		}
		
		int hl=Height2(h.left);
		int hr=Height2(h.right);
		
		if(Math.abs(hl-hr)>1)
		{
			flag=false;
		}
		return Math.max(hl, hr)+1;
	}

	private static int Height(Node h) // T.C = O(N)
	{								  // S.C = O(H)
		 if(h==null)
		 {
			 return 1; // Leaf Node Height =1
			 		   // Use -1 ==> for Based on Edges
		 }
		 int l=Height(h.left); // Height of LST
		 int r=Height(h.right); // Height of RST
		 
		 return Math.max(l, r)+1;
	}

	private static void RightView(Node h)// T.C = O(N)
	{									 // S.C = O(N)
		 Queue<Node> q=new LinkedList<>();
		 
		 q.add(h);
		 
		 
		 
		 while(q.size()>0)
		 {	
			 int n=q.size();
			 for(int i=0;i<n;i++)
			 {
				 Node t=q.poll();
				 if(i==n-1)
				 {
					 System.out.print(t.data+" ");					 
				 }
				 
				 if(t.left!=null)
				 {
					 q.add(t.left);
				 }
				 
				 if(t.right!=null)
				 {
					 q.add(t.right);
				 }
			 }
			 System.out.println();
		 }
	}

	private static void LeftView(Node h) // T.C = O(N)
	{									 // S.C = O(N)
		Queue<Node> q=new LinkedList<>();
		
		q.add(h);
		
		while(q.size()>0)
		{
			int n=q.size();
			
			for(int i=0;i<n;i++)
			{
				Node  t=q.poll();
				if(i==0)
				{
					System.out.print(t.data+" ");
				}
				
				if(t.left!=null)
				{
					q.add(t.left);
				}
				
				if(t.right!=null)
				{
					q.add(t.right);
				}
			}
			System.out.println();
		}
	}

	private static void LevelOrder2(Node h) // T.C = O(N)
	{										// S.C = O(N)
		Queue<Node> q=new LinkedList<>();
		q.add(h);
		
		while(q.size()>0)
		{
			int n=q.size();
			for(int i=0;i<n;i++)
			{
				Node t=q.poll();
				System.out.print(t.data+" ");
				
				if(t.left!=null)
				{
					q.add(t.left);
				}
				
				if(t.right!=null)
				{
					q.add(t.right);
				}
			}
			System.out.println();
		}
	}

	private static void LevelOrder(Node h) // T.C = O(N)
	{									   // S.C = O(N)
		 Queue<Node> q=new LinkedList<>();
		 q.add(h);
		 
		 while(q.size()>0)
		 {
			 Node t=q.poll();
			 System.out.print(t.data+" ");
			 
			 if(t.left!=null)// Insert Not Null Children
			 {
				 q.add(t.left);
			 }
			 
			 if(t.right!=null)
			 {
				 q.add(t.right);
			 }
			 
		 }
	}

}
