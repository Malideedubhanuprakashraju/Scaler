import java.util.Stack;


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
public class Traversal 
{

	public static void main(String[] args) 
	{
		Node r=new Node(14);
		r.left=new Node(18);
		r.right=new Node(19);
		r.left.left=new Node(7);
		r.left.right=new Node(3);
		r.right.left=new Node(10);
		r.right.right=new Node(8);
		r.right.left.right=new Node(4);
		
		System.out.println("Post Order Traversal- Iterative Code 1");
		postOrder1(r);
		System.out.println();
		
		System.out.println("Post Order Traversal- Iterative Code 2");
		postOrder2(r);
		System.out.println();
		
		System.out.println("Post Order Traversal- Recursive Code 3");
		postOrder(r);
		 
	}

	private static void postOrder(Node r) // T.C = O(N)
	{									  // S.C = O(H)
		 if(r==null)
		 {
			 return;
		 }
		 postOrder(r.left);
		 postOrder(r.right);
		 System.out.print(r.data+" ");
	}

	private static void postOrder2(Node r) // T.C = O(N)
	{									   // S.C = O(H)
		 Stack<Node> st=new Stack<>();
		 		 
		 Node c=r;
		 Node lv=null;
		 
		 while(c!=null || st.size()>0)
		 {
			 if(c!=null)
			 {
				 st.push(c);
				 c=c.left;
			 }
			 else
			 {
				 Node temp=st.peek();
				 
				 if(temp.right!=null && lv!=temp.right)
				 {
					 c=temp.right;
				 }
				 else
				 {
					 System.out.print(temp.data+" ");
					 lv=st.pop();
				 }
				 
			 }
		 }
	}

	private static void postOrder1(Node r) // T.C = O(N)
	{									   // S.C = O(N) // Your 2-stack approach → O(N) space (explicit storage of nodes)	
		 Stack<Node> st1=new Stack<>();	   // N (st1) + N (st2) = 2N // So total memory used:
		 Stack<Node> st2=new Stack<>();
		 
		 st1.push(r);
		 
		 while(st1.size()>0)
		 {
			 Node current=st1.pop();
			 st2.push(current);
			 
			 if(current.left!=null)
			 {
				 st1.push(current.left);
			 }
			 if(current.right!=null)
			 {
				  st1.push(current.right);
			 }
		 }
		 
		 while(st2.size()>0)
		 {
			 System.out.print(st2.pop().data+" ");
		 }
	}

}
