package Stacks;

import java.util.Stack;

public class Class_32_Stacks_2 
{

	public static void main(String[] args) 
	{
		// 1^Smaller on Left 		// 1^Smaller on Right
		// 1^Larger on Left			// 1^Larger on Right
		
		/* Stacks : Insert / Delete Same Side.
		 * 
		 * Push(X)
		 * 
		 * Pop()
		 * 
		 * Peek()
		 * 
		 * Size()
		 * 
		 * Note : A Single Operation takes O(1)
		 * 
		 */
		
		// Q1) First Smaller Element on Left Side
		/*
		 * Given Array for Every Element in Array[i] find Nearest Smaller Element on LeftSide.
		 * 															|
		 * 															-----> Nearest Element  < Array[i], Distance Between Indices.
		 * Eg-1:
		 * 
		 * Ar[6]  = 4	5	2	10	3	12
		 * 		   
		 * Ans[6] =-1	4	-1	2	2	3
		 * 
		 *  
		 */
		int ar[]= {4,6,2,10,8,2};
		
		/* Idea-1 : For Every Array[i] : Iterate on Left & get Nearest Smaller on Left.
		 *  
		 */
		int ans[]=smallerLeft(ar);
		
		for(int x:ans)
		{
			System.out.print(x+" ");
		}
		
		/* Idea-2 : Use Stack DS
		 * 
		 * Operations : Stack
		 * 
		 * 1) Push() / Pop() from Same Side
		 * 
		 * 2) Peek()
		 * 
		 * Observation : In Stack we Store Possible Ans
		 * 
		 */
		System.out.println();
		System.out.println("Nearest Smallest Element on Left Side");
		int ans1[]=smallerLeft1(ar);
		
		for(int x:ans1)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		
		// Q2) Nearest Smaller Element on Right
		// Obs : Iterate from Right to Left
		System.out.println("Nearest Smallest Element on Right Side");
		int ans2[]=smallerRight(ar);
		
		for(int x:ans2)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		
		// Q3) Nearest Smaller index on Left
		// Obs : Iterate from Left to Right
		System.out.println("Nearest Smallest Element on Left Side index");
		int ans3[]=smallerLeftIndex(ar);
		
		for(int x:ans3)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		
		// Q4) Nearest Smaller Right index
		System.out.println("Nearest Smallest Element on Right Side index");
		int ans4[]=smallerRightIndex(ar);
		
		for(int x:ans4)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		
		
		// Q5) Nearest Greater Element on Left Side
		
		int ar1[]= {11,10,6,2,10,7,4,8};
		
		for(int x:ar1)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		System.out.println("Nearest Greater Element on Left Side ");
		
		int a1[]=NearestGreaterElementLeft(ar1);
		for(int x:a1)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		
		System.out.println("Nearest Greater Element on Right Side ");
		
		int a2[]=NearestGreaterElementRight(ar1);
		for(int x:a2)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		
		System.out.println("Nearest Greater Element Left Side index");
		
		int a3[]=NearestGreaterElementLeftIndex(ar1);
		for(int x:a3)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		System.out.println("Nearest Greater Element Right Side index");
		int a4[]=NearestGreaterElementRightIndex(ar1);
		for(int x:a4)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		
		// Histogram Area 
		/*
		 * Given Continuous Block of Histogram Find MAx Rectangular Area.
		 * 
		 * Rectangular Area, Should be With in Histograms :
		 * 
		 * Note : Width of Each Histogram is 1
		 * 
		 * Note : Every Square is Rectangle --> Every Rectangle is Not Square
		 * 
		 * 
		 * Idea-1:
		 *  
		 * Consider each each Histogram as Rectangular Height T.C = O(N*N) = O(N^2)
		 * 
		 * a) Iterate on Left & Calculate P1 = 1^st Smaller Index on Left = Initialize =-1;
		 * 
		 * b) Iterate on Right & Calculate p2 = 1^st Smaller Index on Right = Initialize =N;
		 * 
		 * c) Width = p2-p2-1 (p1,p2-->Excluded)
		 * 
		 * d) Area = Width * Height
		 * 
		 * 
		 * Optimization :
		 * 
		 * p1 : 1^st Smaller Index Left : Initialize p1=-1 ==> T.C = O(N)
		 * 
		 * p2 : 1^st Smaller Index Right : Initialize p2=N ==> T.C = O(N)
		 * 
		 * Calculate p1,p2 values for all Histogram at Start Itself.
		 * 
		 * Calculate Area for each Histogram as Hight of Rectangle
		 * 
		 * 
		 * Eg-1 :
		 * 									   0	1	2	3	4	5
		 * ar[6] = Height of each Histogram = {2	4	3	4	5	1} ==> Area= ?
		 * 
		 * Nearest Smaller index Left p1[6] = {-1	0	0	2	3	-1} ==> T.C = O(N)
		 * 
		 * Nearest Smaller index Right p2[6]= { 5	2	5	5	5	 6} ==> T.C = O(N)
		 * 
		 * 							  Width = { 5	1	4	2	1	 6} ==> T.C = O(N)
		 * 
		 * 							  Area	= { 10	4	12	8	5	 6} ==> Ans = 12
		 * 
		 */
		int a[]= {2,4,3,4,5,1};
		
		int anss=Rectangular(a);
		System.out.println("Max Rectangular Area in Histogram : "+anss);
		
		
	}

	 
	private static int Rectangular(int[] a) // T.C = O(N)
	{										// S.C = O(N)
		int n=a.length;
		
		int p1[]=new int[n];
		
		Stack<Integer> st1=new Stack<>();
		
		for(int i=0;i<n;i++)
		{
			p1[i]=-1;
			
			while(st1.size()>0 && a[st1.peek()]>=a[i])
			{
				st1.pop();
			}
			if(!st1.isEmpty())
			{
				p1[i]=st1.peek();
			}
			st1.push(i);
		}
		
		int p2[]=new int[n];
		
		Stack<Integer> st2=new Stack<>();
		
		for(int i=0;i<n;i++)
		{
			p2[i]=n;
			
			while(st2.size()>0 && a[st2.peek()]>=a[i])
			{
				st2.pop();
			}
			if(st2.size()>0)
			{
				p2[i]=st2.peek();
			}
			st2.push(i);
		}
		
		int ans=0;
		for(int i=0;i<n;i++)
		{
			int w=p2[i]-p1[i]-1;
			ans=Math.max(ans,w*a[i]);
		}
		return ans;
	}


	private static int[] NearestGreaterElementRightIndex(int[] ar1) // T.C = O(N)
	{																// S.C = O(N)
		 int n=ar1.length;
		 
		 int ans[]=new int[n];
		 
		 Stack<Integer> st=new Stack<>();
		 
		 for(int i=n-1;i>=0;i--)
		 {
			 ans[i]=-1;
			 
			 while(st.size()>0 && ar1[st.peek()]<=ar1[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 ans[i]=st.peek();
			 }
			 st.push(i);
		 }
		 return ans;
	}


	private static int[] NearestGreaterElementLeftIndex(int[] ar1) // T.C = O(N)
	{															   // S.C = O(N)
		 int n=ar1.length;
		 
		 int ans[]=new int[n];
		 
		 Stack<Integer> st=new Stack<>();
		 
		 for(int i=0;i<n;i++)
		 {
			 ans[i]=-1;
			 
			 while(st.size()>0 && ar1[st.peek()]<=ar1[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 ans[i]=st.peek();
			 }
			 st.push(i);
		 }
		 return ans;
	}

	private static int[] NearestGreaterElementRight(int[] ar1) // T.C = O(N)
	{														   // S.C = O(N)
		 int n=ar1.length;
		 
		 int ans[]=new int[n];
		 Stack<Integer> st=new Stack<>();
		 
		 for(int i=n-1;i>=0;i--)
		 {
			 ans[i]=-1;
			 while(st.size()>0 && st.peek()<=ar1[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 ans[i]=st.peek();
			 }
			 st.push(ar1[i]);
		 }
		 return ans;
	}

	private static int[] NearestGreaterElementLeft(int[] ar1) // T.C = O(N)
	{														  // S.C = O(N)
		  int n= ar1.length;
		  
		  int ans[]=new int[n];
		  
		  Stack<Integer> st=new Stack<>();
		  
		  for(int i=0;i<n;i++)
		  {
			  ans[i]=-1;
			  
			  while(st.size()>0 && st.peek()<=ar1[i])
			  {
				  st.pop();
			  }
			  
			  if(st.size()>0)
			  {
				  ans[i]=st.peek();
			  }
			  st.push(ar1[i]);
		  }
		  return ans;
	}

	private static int[] smallerRightIndex(int[] ar) // T.C = O(N)
	{												 // S.C = O(N)
		 int n=ar.length;
		 
		 int ans[]=new int[n];
		 
		 Stack<Integer> st=new Stack<>();
		 
		 for(int i=n-1;i>=0;i--)
		 {
			 ans[i]=-1;
			 
			 while(st.size()>0 && ar[st.peek()]>=ar[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 ans[i]=st.peek();
			 }
			 st.push(i);
		 }
		 return ans;
	}

	private static int[] smallerLeftIndex(int[] ar) // T.C = O(N)
	{												// S.C = O(N)
		 int n=ar.length;
		 
		 int ans[]=new int[n];
		 
		 Stack<Integer> st=new Stack<>();
		 
		 for(int i=0;i<n;i++)
		 {
			 ans[i]=-1;
			 
			 while(st.size()>0 && ar[st.peek()]>=ar[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 ans[i]=st.peek();
			 }
			 st.push(i);
		 }
		 return ans;
	}

	private static int[] smallerRight(int[] ar) // T.C = O(N)
	{											// S.C = O(N)
		 int n=ar.length;
		 
		 int ans[]=new int[n];
		 
		 Stack<Integer> st=new Stack<>();
		 
		 for(int i=n-1;i>=0;i--)
		 {
			 ans[i]=-1;
			 
			 while(st.size()>0 && st.peek()>=ar[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 ans[i]=st.peek();
			 }
			 st.push(ar[i]);
			 
		 }
		 return ans;
	}

	private static int[] smallerLeft1(int[] ar) // T.C = O(N)
	{											// S.C = O(N)
		 int n=ar.length;
		 
		 int ans[]=new int[n];
		 
		 Stack<Integer> st=new Stack<>();
		 
		 for(int i=0;i<n;i++)
		 {
			 ans[i]=-1;
			 while(st.size()>0 && st.peek()>=ar[i])
			 {
				 st.pop();
			 }
			 if(st.size()>0)
			 {
				 ans[i]=st.peek();
			 }
			 st.push(ar[i]);
		 }
		 return ans;
	}

	private static int[] smallerLeft(int[] ar) // T.C = O(N^2)
	{										   // S.C = O(1)
	  int n=ar.length;
	  int ans[]=new int[n];
	  
	  for(int i=0;i<n;i++)
	  {
		  // For Array[i] : Calculate Nearest Smaller on Left
		  
		  ans[i]=-1;
		  
		  for(int j=i-1;j>=0;j--) 
			  
		  {
			  if(ar[j]<ar[i])
			  {
				  ans[i]=ar[j];
				  break;
			  }
		  }
		  
	  }
	  return ans;
	  
	}

}
