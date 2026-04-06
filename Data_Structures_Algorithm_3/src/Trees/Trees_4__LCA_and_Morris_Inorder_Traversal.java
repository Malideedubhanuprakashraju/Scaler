package Trees;

import java.util.ArrayList;

class Node //Class
{
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

public class Trees_4__LCA_and_Morris_Inorder_Traversal 
{
	static ArrayList<Integer> ar=new ArrayList<>();
	public static void main(String[] args) 
	{
		// In-Order Traversal --> S.C = O(1)
		/*
		 * Q1) Can we Applay Recursion ? Yes
		 * 
		 * 	No
		 * 
		 * Opti : Morries 
		 * 		  -------
		 * 
		 * In a Binary Tree, Any Node that has a Left Child, the inorder precedeceesor of that node will not have a Right Child.
		 * 
		 * Eg-1 :
		 * 
		 * 			(1)		
		 * 	
		 * 	(2)				(4)
		 * 
		 * 
		 * 				(5)		 (6)
		 * 
		 * Output : 2,1,5,4,6
		 * 
		 * Inorder Predecessor : In the inorder traversal of a Binary Tree, the node that comes immediately before a given node is called its inorder predecessor.		 * ------------------
		 * 
		 * Since Every Node is Traverse at Max 3-Times 
		 * 
		 * T.C = O(N)
		 *   
		 */
		// Creating nodes
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Tree created successfully!");
        
        inOrder(root);
        
        // Q2) Given a Binary Tree.
        // Find the LCA of 2 given Nodes u & v
        /*
         * Approach :
         * 
         * a) Start at the Root of the Binary Tree.
         * 
         * b) If the Root is null or matches either of the target nodes, return the Root as the LCA.
         * 
         * c) Recursively search for the Target Nodes in the Left and Right Subtrees of the Current Root.
         * 
         * d) If both Traget Nodes are found in different Subtrees, the Current Root is the LCA.
         * 
         * e) If only one target node is found, return that Node as the LCA.
         * 
         * f) If Both Target Nodes are Found in the same Subtree, continue the search in that Subtree.
         *   
         */
        
        /* Q) When will Root be the LCA of u & v.
         * 
         * Ans : 
         * 
         * 1) When one of (u or v) is Present in LST & Other is in RST
         * 
         * 2) When Root is one of the 2-Nodes (u or v) & the other Node is present in either LST or RST of Root.
         * 
         */
        
        System.out.println();
        Node ans1=findLCA(root,root.left.left,root.left.right);
        System.out.println(ans1.data);
        
        // Q3) LCA in BST
        /*
         * Approach :
         * 
         * For Every Node, Compare it's value with the 2-Nodes you are looking the LCA of.
         * 
         * a) Both Nodes greater than current ==> curr=curr.right;
         * 
         * b) Both Nodes smaller than current ==> curr=curr.left;
         * 
         * c) Return Curr;
         * 
         */
        
        System.out.println();
        Node rootNode = new Node(5);

        rootNode.left = new Node(3);
        rootNode.right = new Node(7);

        rootNode.left.left = new Node(2);
        rootNode.left.right = new Node(4);

        rootNode.right.left = new Node(6);
        rootNode.right.right = new Node(8);

        System.out.println("BST Created!");
        
        Node ans2=findlcaBST(rootNode,rootNode.left.right,rootNode.left.left);
        System.out.println(ans2.data+" ");
        
        System.out.println();
        
        // Q4) K^th Smallest Element in BST
        /*
         * Given a BST with N-Nodes & an Integer K (k<N).
         * 
         * Find the K^th Smallest Element in BST.
         * 
         * Ans :
         * ----
         * Inorder Traversal of BST is Sorted.
         * 		0	1	2	3	4	5	 6	 7	  8   9
         * Eg : 1,	4,	6,	8,	9,	10,	17,	19,	 22,  25
         * 
         * return inorder[k-1];
         * 
         * Idea :
         * 
         * Use the Property of a BST that it's inorder traversal gives the Sorted Array.
         * 
         * Idea-1 :
         * 
         * Create a Dynamic Array & Populate it using inorder traversal of BST.
         * 
         * Return the K^th Element (K-1) inorder of that Inorder Array
         * 
         * T.C = O(N)
         * S.C = O(N)
         * 
         * 
         * Idea-2 :
         * 
         * Keep a Counter in the Morries Inorder Traversal at the time of priority. When it reaches k, Update the Ans.
         *  
         */
        
        
        int k=3;
        ar.clear();
        inOrder1(rootNode);
        System.out.println("K^th Smallest: "+ar.get(k-1));
        
        /*
         *  | Operation                | Time Complexity | Space Complexity |
			| ------------------------ | --------------- | ---------------- |
			| Morris Inorder           | O(N)            | O(1)             |
			| LCA (Binary Tree)        | O(N)            | O(H)             |
			| LCA (BST)                | O(H)            | O(1)             |
			| Kth Smallest (ArrayList) | O(N)            | O(N)             |

         */
        ar.clear();
        MorriesInorder(rootNode);
	}
	
	 



	private static void MorriesInorder(Node rootNode) 
	{
		// TODO Auto-generated method stub
		
	}





	private static void inOrder1(Node rootNode) 
	{ 
		if(rootNode==null)
		{
			return;
		}
		inOrder1(rootNode.left);
		ar.add(rootNode.data);
		inOrder1(rootNode.right);
	}




	private static Node findlcaBST(Node rN, Node n, Node m) // T.C = O(H)
	{														// S.C = O(1)
		if(rN==null)
		{
			return null;
		}
		
		while(rN!=null)
		{
			if(n.data<rN.data && m.data<rN.data)
			{
				rN=rN.left;
			}
			else if (n.data>rN.data && m.data>rN.data)
			{
				rN=rN.right;
			}
			else
			{
				return rN;
			}
		}
		return null;
	}

	private static Node findLCA(Node root, Node left, Node right) // T.C = O(N)
	{															  // S.C = O(H)// Height of Tree
		if(root==null || root==left || root==right)
		{
			return root;
		}
		
		Node ll=findLCA(root.left,left,right);
		Node rr=findLCA(root.right,left,right);
		
		if(ll!=null && rr!=null)
		{
			return root;
		}
		
		if(ll!=null)
		{
			return ll;
		}
		
		return rr;
	}

	private static void inOrder(Node root) // T.C = O(3*N) = O(N)
	{ 									   // S.C = O(1)
		Node curr=root;
		
		while(curr!=null)
		{
			if(curr.left==null)
			{
				System.out.print(curr.data+" ");
				curr=curr.right;
			}
			else
			{
				Node temp=curr.left;
				while(temp.right!=null && temp.right!=curr)
				{
					temp=temp.right;
				}
				
				if(temp.right==null) // 1^st Time No Back Edge Exists
				{
					temp.right=curr;
					curr=curr.left;
				}
				else
				{
					temp.right=null;
					System.out.print(curr.data+" ");
					curr=curr.right;
				}
			}
		}
		
		
		
		
		
	}

}
