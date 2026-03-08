package Classes;

class Node1
{
	int data;
	Node1 next; // Pointing to Next Node
	Node1 rand; // Pointing to Any Node in LinkedList
	
	Node1(int x)
	{
		data=x;
		next=null;
		rand=null;
	}
}

public class Class_30_Linked_List_2 
{

	public static void main(String[] args) 
	{
		/* Clone LinkedList
		 * 
		 * Q1) Given a LinkedList, Where every Node has next and rand
		 * 
		 * 	Next : Holds address of next Node of Linked List
		 * 	
		 * 	Rand : Holds address of Some Random Node of Linked List
		 * 
		 * 	Create a Exact Copy of given Linked List & Return Head Node of Copy
		 * 
		 * 	Copy Means : Data Should be Same & Overall Structure Should be Same.
		 *  
		 */
		Node1 h=new Node1(8);
		
		// Creating the List
		
		Node1 t=h;
		t.next=new Node1(9);
		t=t.next;
		
		t.next=new Node1(12);
		t=t.next;
		
		t.next=new Node1(10);
		t=t.next;
		
		t.next=new Node1(20);
		t=t.next;
		
		// Assign Random Pointers -> we need References to Nodes, Store Them.
		
		Node1 n1=h;
		Node1 n2=n1.next;
		Node1 n3=n2.next;
		Node1 n4=n3.next;
		Node1 n5=n4.next;
		
		n1.rand=n5;
		n2.rand=n2;
		n3.rand=n1;
		n4.rand=n3;
		n5.rand=n3;
			
		// Note : Create Copy : New Copy Won't Comes under Extra Space
		
		// Note : Expected TC : O(N)	SC : O(1)
		
		// Step-1 : Between H,t & t.next, create and insert a New Node with t.data
		
		/* Node T=H;
		 * 
		 * While(T!=null)
		 * {
		 * 		Between T & T.next : insert T.data;
		 * 
		 * 		Node nn=new Node(T.data);
		 * 		nn.next=T.next;
		 * 		T.next=nn;
		 * 		T=nn.next;
		 * }
		 *  
		 */
		
		// Step-2 : Arrange Rand Links in Copy Links with T1, T2.
		
		/* Node T1=H, T2=H.next;
		 * 
		 * while(T1!=null)
		 * {
		 * 		if(T1.rand != null)
		 * 		{
		 * 			T2.rand=T1.rand.next;
		 * 		}
		 * 
		 * 		T1=T2.next;
		 * 		
		 * 	   if(T1! = null)
		 * 	   {
		 * 		T2=T1.next;
		 * 	   }
		 * 	}
		 */
		
		// Step-3 : Setting next in Original & Copy Linked List
		
		/* T1=H, T2=H.next;
		 * 
		 * Node CH=T2;
		 * 
		 * While( T1!=null)
		 * {
		 * 		T1.next = T2.next;
		 * 		T1=T1.next;
		 * 		if(T1!=null)
		 * 		{
		 * 			T2.next=T1.next;
		 * 		}
		 * 		T2=T2.next;
		 * }
		 * 
		 * return CH;
		 * 
		 */
		
		Node1 ans=Clone(h);
		print(ans);
		
		// Q2) Median of 2 - Sorted Arrays
		
		/* Median : Point can be divided into 2 equal parts { All 1^st Half <= All 2^nd Half }
		 * 
		 * Eg-1 :
		 * 
		 * 		Array[5] = { 2,9,6,4,5 };
		 * 	
		 * 		Median = 5;
		 * 
		 * Eg-2 :
		 * 
		 * 		Array[4] = { 1,2,4,3 };
		 * 
		 * 		Median = 2+3/2 = 2.5
		 * 
		 * 
		 * Observation :
		 * 
		 * If Even Elements : Median is Average of Both Medians
		 * 
		 * 					Median = Max of Left Part + Min of Right Part / 2;
		 * 
		 * If Odd Elements : Give Extra Element to Left Side.
		 * 
		 * 					Median = Max of Left Part
		 * 
		 * 
		 * Idea-1 : Merge Both Sorted Arrays & Return Median
		 * 
		 * 			T.C = O(N+M)
		 * 
		 * Idea-2 : If Even Elements : Median Average of Both Medians
		 * 
		 * 			If Odd Elements : Give Extra Element to Left Side.
		 * 
		 *  
		 */
		int a[]= {3,5,8,11,15,18};
		int b[]= {2,7,10,13,19,23,25};
		
		/* Property of Median :
		 * 
		 * if Total Elements = 16
		 * 
		 * Left Part : 8 <= Right Part : 8
		 * 
		 * Median =( Max of Left + Min of Right )/2;
		 * 
		 * if Total Elements = 15
		 * 
		 * Left Part : 8 <= Right Part : 7
		 * 
		 * Median = Max of Left 
		 * 
		 * 
		 * Left Part = (TotalElements + 1)/2;
		 * 
		 * Total Ele		Left Part
		 * 
		 * 		16				[16+1]/2 = 8
		 * 		15				[15+1]/2 = 8
		 * 
		 * 
		 * Eg : Total Elements = 13
		 * 		
		 * 		Left Part = 13+1/2 =7
		 * 
		 * 		Right Part = 6
		 * 
		 * Observation-1 : In your Left Part
		 * 
		 * 				 : It can Contain Few Elements of A
		 * 				 : It can Contain Few Elements of B
		 * 
		 * Total Left = 7
		 * 
		 * Assum-1 : if noA = 1 <==> noB = 6
		 * 
		 * Q : All Ele of Left <= All Ele of Right ?
		 * 
		 * Default : LeftA <= RightA, LeftB <= RightB
		 * 
		 * Note : To Compare Last Ele in LeftA,LeftB & Start Ele in Right A & Right B
		 * 
		 * if(leftA <= RightB) && LeftB <=RightA : Error
		 * 
		 * In above case : LeftB > RightA : Increment no:of Left A.
		 * 
		 * Assum-2 : if noA = 5 <==> noB = 2
		 * 
		 * In above case : LeftA > RightB : Decrease no:of LeftA
		 * 
		 * 
		 * Target : Calculate no:of Elements in LeftA
		 * 
		 * Search : No:of LeftA Elements
		 * 
		 * 			{0............A.length}
		 * 
		 * Discard : Yes we can discard
		 * 
		 *  
		 */
		int ans1=median(a,b);
		System.out.println("Median of Given Arrays : "+ans1);
		
	}

	private static int median(int[] a, int[] b)// T.C = O(log(min(n,m))) 
	{										   // S.C = O(1)
		 int c[];
		 if(a.length >b.length)
		 {
			 c=a;
			 a=b;
			 b=c;
		 }
		 int ans=0;
		 
		 int n=a.length;
		 int m=b.length;
		 
		 int nL=(n+m+1)/2; // Min Length Array will Always be on A.
		 				   // We are trying binary search on Min Length Array, to Avoid Edge Case
		 
		 int l=0,h=n;
		 
		 while(l<=h)
		 {
			 int m1=(l+h)/2;
			 
			 int nLA=m1;
			 int nLB=nL-nLA;
			 
			  			 
			 int dLA= Integer.MIN_VALUE;
			 int dLB= Integer.MIN_VALUE;
			 int dRA= Integer.MAX_VALUE;
			 int dRB= Integer.MAX_VALUE;
			 
			 if(nLA>0)
			 {
				 dLA=a[nLA-1];
			 }
			 if(nLB>0)
			 {
				 dLB=b[nLB-1];
			 }
			 if(nLA<n)
			 {
				 dRA=a[nLA];
			 }
			 if(nLB<m)
			 {
				 dRB=b[nLB];
			 }
			 
			 if(dLA > dRB) // Decrease Elements in nLA
			 {
				 h=m1-1;
			 }
			 else if(dLB > dRA)// Increase Elements in nLA
			 {
				 l=m1+1;
			 }
			 else
			 {
				 if((n+m)%2==1)
				 {
					 ans=Math.max(dLA, dLB);
				 }
				 else
				 {
					 ans=(Math.max(dLA, dLB)+Math.min(dRA, dRB))/2;
				 }
				 break;
			 }
			 
		 }
		 return ans;
	}

	private static void print(Node1 ans) 
	{
		Node1 t=ans;
		
		while(t!=null)
		{
			System.out.println(t.data);
			t=t.next;
		}
	}

	private static Node1 Clone(Node1 h) // T.C = O(N)
	{									// S.C = O(1)
		
		if(h==null)
		{
			return null;
		}
		 Node1 t=h;
		 
		 while(t!=null)
		 {
			 Node1 nn=new Node1(t.data);
			 nn.next=t.next;
			 t.next=nn;
			 t=nn.next;
		 }
		 
//		 Node1 T1=h,T2=h.next;
		 
//		 while(T1!=null)
//		 {
//			 if(T1.rand!=null)
//			 {
//				 T2.rand=T1.rand.next;
//			 }
//			 T1=T2.next;
//			 
//			 if(T1!=null)
//			 {
//				 T2=T1.next;
//			 }
//		 }
		 
		 Node1 T1=h;
		 
		 while(T1!=null)
		 {
			 if(T1.rand!=null)
			 {
				 T1.next.rand=T1.rand.next;
			 }
			 T1=T1.next.next;
		 }
		 
		 
		 Node1 c1=h,c2=h.next;
		 Node1 ch=c2;
		 
		 while(c1!=null)
		 {
			 c1.next=c2.next;
			 c1=c1.next;
			 			 
			 if(c1!=null)
			 {
				 c2.next=c1.next;
			 }
			 c2=c2.next;
		 }
		 
		 return ch;
	}

}
