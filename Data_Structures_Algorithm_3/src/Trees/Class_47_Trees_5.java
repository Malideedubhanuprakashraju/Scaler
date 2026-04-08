package Trees;

 

class Node1 {
    int data;
    Node1 left, right,next;

    // Constructor
    Node1(int value) {
        data = value;
        left = right = next=null;
    }
}

public class Class_47_Trees_5 
{
	static Node1 originalRoot;
	static boolean found=false;
	
	static int d;

	public static void main(String[] args) 
	{
		 /* Q1) Equal Tree Partition :
		  * ------------------------
		  * 
		  * Given the Root of a Binary Tree, return True if the Tree can be split into Two Non_Empty Subtrees
		  * 
		  * with equal Sums or False otherwise.
		  * 
		  * Note : Check if there exists a Subtree Sum = Total Tree Sum / 2;
		  * ----
		  * 
		  * Eg-1 :
		  * 
		  * 		5
		  * 	10		10
		  * 
		  * 		 2		3 // Sum = 15 : True
		  * 
		  * Steps :
		  * -----
		  * 
		  * 1) Total = Sum(root);
		  * 
		  * 2) if( Total % 2 == 1)
		  *    {
		  *    		return false; // Not Possible to Devide
		  *    }
		  *    
		  * 3) target = total/2;
		  * 
		  *    Check if there exists a Subtree with Sum = Target ?
		  *    
		  * Note : 
		  *   
		  */
		// Creating root node
        Node1 root = new Node1(1);

        // Creating child nodes
        root.left = new Node1(2);
        root.right = new Node1(3);

        // Level 2 nodes
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);

        root.right.left = new Node1(6);
        root.right.right = new Node1(7);

        System.out.println("Tree created successfully!");
        
        boolean ans=EqualTreePartition(root);
        System.out.println(ans+" Checking Equal Partiotion ");
        
        // Q2) Check if Root to Leaf Path Sum Equals to K.
        /*
         * K=22 : return True
         * 
         * 			5
         *  	4		8
         * 
         * 	 11	    9		4
         * 
         * 7  	2  3		  1
         * 
         */
        
        Node1 rootNode = new Node1(5);

        Node1 r = new Node1(5);

	     // Level 1
	     r.left = new Node1(4);
	     r.right = new Node1(8);
	
	     // Level 2
	     r.left.left = new Node1(11);
	
	     r.right.left = new Node1(9);
	     r.right.right = new Node1(4);
	
	     // Level 3
	     r.left.left.left = new Node1(7);
	     r.left.left.right = new Node1(2);
	
	     r.right.left.left = new Node1(3);
	
	     // Level 4
	     r.right.left.left.right = new Node1(1);
	     
	     boolean ans1=PathSum(r,22);
	     System.out.println("Path Sum "+ans1);
	     
	     // Q3) Diameter of Binary Tree.
	     /*
	      * Given a Binary Tree, Find the Length of Longest Path between any Two Nodes in the Tree.
	      * 
	      * The Path May or Mayn't Pass through the Root.
	      * 
	      * Diameter : The Diameter of a Binary Tree is defined as Number of Nodes along the Longest Path between any two Leaf Nodes in the Tree.
	      * -------
	      * This Path May or Mayn't Pass through the Root.
	      * 
	      * Note : Diameter based on Nodes.
	      * 
	      * Eg-1 :
	      * ----
	      * 
	      * 			1
	      * 
	      * 		2
	      * 	
	      * 	4		5
	      * 
	      * 6		7		9
	      * 		
	      * 			8
	      * 			
	      * 				10
	      * 
	      * Edges = 6;
	      * 
	      * Nodes = 7
	      *  
	      */
	     int ans2=Diameter(r);
	     System.out.println("Longest Diameter is "+ans2);
	     
	     // Q4) Perfect Binary Tree :
	     /*
	      * 						All Leaf Nodes are in same level & every node has 0 or 2 childrens.
	      * 
	      *     For this question, each node has
	      *     
	      *     a) Left Child
	      *     				} In BT Left & Right Filled
	      *     b) Right Child
	      *     
	      *     c) Next Child   } We need to fill it, immediate node in Same Level
	      *      
	      */
	     // Given a Perfect Binary Tree Fill Next to Every Node, No extra Space
	     /*
	      * 		1 -> Null
	      * 
	      * 	2	->	3 -> Null
	      * 
	      * Way-1 : Recursive
	      * -----
	      * 				        1
							      /   \
							     2     3
							    / \   / \
							   4   5 6   7
	      * 
	      * After :
	      * 
	      * 1 → NULL
			2 → 3 → NULL
			4 → 5 → 6 → 7 → NULL
	      * 
	      */
	    // fillRight(root);// Print it by LevelOrder
	     
	     /* Way-2 : Itertaive
	      * -----
	      * 
	      * From a Node we can mark, next for it's children
	      * 
	      */
	     fillNext(root);
	     printLevels(root);
	     
	     
	}

	private static void printLevels(Node1 root)// T.C = O(N)
	{										   // S.C = O(1)
	    Node1 levelStart = root;

	    while(levelStart != null)
	    {
	        Node1 curr = levelStart;

	        while(curr != null)
	        {
	            System.out.print(curr.data + " -> ");
	            curr = curr.next;
	        }

	        System.out.println("NULL");

	        levelStart = levelStart.left;
	    }
	}
	private static void fillNext(Node1 root) // T.C = O(N)
	{										 // S.C = O(1)
		 Node1 t=root;
		 
		 while(t.left!=null)
		 {
			 Node1 s=t; // s=start node of level
			 
			 while(t!=null)
			 {
				 t.left.next=t.right;
				 if(t.next!=null)
				 {
					 t.right.next=t.next.left;
				 }
				 t=t.next;
			 }
			 t=s.left;
		 }
	}

	private static void fillRight(Node1 root) // T.C = O(N)
	{										  // S.C = O(H)
		if(root==null)
		{
			return;
		}
		
		// Connect Left -> Right
		
		if(root.left !=null)
		{
			root.left.next=root.right;
		}
		
		// Connect Right -> Next Node's Left
		
		if(root.right!=null && root.next!=null)
		{
			root.right.next=root.next.left;
		}
		
		// Recursive
		
		fillRight(root.left);
		fillRight(root.right);
	}

	private static int Diameter(Node1 r) // T.C = O(N)
	{									 // S.C = O(H)
		d=0;
		Height(r);
		
		return d;
	}

	private static int Height(Node1 r) // T.C = O(N)
	{								   // S.C = O(H)
		if(r==null)
		{
			return 0;
		}
		int hl=Height(r.left);
		int hr=Height(r.right);
		
		// Diameter of Node = l+r+1
		
		d=Math.max(d,hl+hr+1);
		
		return Math.max(hl, hr)+1;
	}

	private static boolean PathSum(Node1 r, int k) // T.C = O(N)
	{											   // S.C = O(H)
		if(r==null)
		{
			return false;
		}
		
		if(r.data==k && r.left==null && r.right==null)
		{
			return true;
		}
		
		return PathSum(r.left,k-r.data) || PathSum(r.right,k-r.data);
	}

	private static boolean EqualTreePartition(Node1 root) // T.C = O(N)
	{													  // S.C = O(H)
		 originalRoot=root;
		 int total=sum(root);
		 
		 if(total%2!=0)// If total is odd → cannot divide into 2 equal parts
		 {
			 return false;// ✔️ So return false immediately
		 }
		 
		 found=false;// Reset flag before checking
		 
		 check(root,total/2);// 👉 Start traversal to find subtree with target sum
		 
		 return found;
		 
		 // “Use postorder traversal to compute subtree sums and check if any subtree equals half of total sum while excluding the root.”
		 // 👉 “Why postorder?”
		 // 👉 “Because we need left and right subtree sums before computing the current node sum.”
	}

	private static int check(Node1 root, int target) // T.C = O(N)
	{												 // S.C = O(H)
		if(root == null || found)// If node is null → sum = 0
		{						 // If already found → stop recursion early (optimization)
			return 0;
		}
		
		int left=check(root.left,target);// 👉 Recursively calculate left subtree sum
		int right=check(root.right,target);// 👉 Recursively calculate right subtree sum
		
		int csum=left+right+root.data;// 👉 Compute current subtree sum
		
		if(csum==target && root!=originalRoot)// csum == target → valid subtree found
		{									  // root != originalRoot → exclude full tree
			found=true;// ✔️ If both true → mark found = true
		}
		
		return csum; // Return subtree sum to parent
	}

	private static int sum(Node1 root) // T.C = O(N)
	{								   // S.C = O(H)
		if(root==null)
		{
			return 0;
		}
		int l=sum(root.left);
		int r=sum(root.right);
		
		return l+r+root.data;
	}

}
