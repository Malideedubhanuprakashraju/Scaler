package Arrays_Prefix_Sum;

public class Class_4_Prefix_Sum 
{

	public static void main(String[] args) 
	{ 
		// Q) Given Array & s,e Calculate sum of all elements from S-->E
		int a[]= {3,4,6,8,9,10,2,7,4,10};
		int s=2,e=7;
		int ans=SumOfEle(a,s,e);
		System.out.println(ans);
		
		// Q) Given Array Elements & Q-queries :
		// Each Queries ci=ontain s&e
		// For every query calculate sum of all elements from [s...e]
		
		int ar1[]= {-3,6,2,4,5,2,8,-9,3,1};
		int Q[][]= {
					 {4,8},{3,7},{1,3},{7,7},{3,6},{0,4}
				   };
		
		int ans1[]=RangeSum(ar1,Q);
		// Constraints : 1<=N,Q<=10^5
		for(int x:ans1)
		{
			System.out.print(x+" ");
		}
		
		// Q) Given Indian Cricket Team Score, for First 10 Overs of Batting.
		// After every over, total score is given as :
		
		// Overs 	   : 1	2	3	4	5	6	7	8	9	10 
		// Total Score : 2	8	14	29	31	49	65	79	88	97
		
		// Total Runs Scored in 10^th Over : Total[10]-Total[9] = 97-88= 9
		// Total Runs Scored in 7^th Over  : Total[7]-Total[6] = 65-49= 16
		// Total Runs Scored in 6^th-10^th Over : Total[10]-Total[5]=97-31 = 66
		// Total Runs Scored in 4^th-9^th Over : Total[9]-Total[3]=88-14=74
		
		// Total Runs Scored in i^th-j^th Over : Total[j]=Total[i-1];
		
		// Idea : Cumulative : Data from Start = Prefix Data {From 0^th index}
		//		  Cumulative : Data from End   = Suffix Data {From N-1^th index}
		
		// eg : Ar[6] : { 10, 32, 6, 12, 20, 1};
		//    Psum[6] : { 10, 42, 48, 60, 80,81};
		//	  Psum[i] : Sum of all elements {0....i}
		
		// Construct Psum[] ? For Given Array
		// Way-1 :
		//		  Calculate Sum from Start,Update Sum & Store in PSum[].
		System.out.println();
		int arr[]= {3,-2,4,5,6};
		int way1[]=prefixWay1(arr);
		
		for(int x: way1)
		{
			System.out.print(x+" ");
		}
		System.out.println();
		// Psum[]
		// Way-2 : Based on psum[i]=psum[i-1]+A[i];
		// psum[0]=	A[0];
		// psum[1]=	psum[0]+A[1]
		// psum[2]=	psum[1]+A[2]
		// psum[3]=	psum[2]+A[3]
		// psum[4]=	psum[3]+A[4]
		
		// psum[i]= psum[i-1]+A[i]
		int way2[]=prefixWay2(arr);
		
		for(int x: way2)
		{
			System.out.print(x+" ");
		}
		
		// Q) Let Us Suppose Query Z=6
		// Input = mat[6][2];		Ans Using Psum[]
		
		/*  	0:s		1:e		=>	Psum[e]-Psum[s-1]
		 * 0	4		8			Psum[8]-Psum[3]
		 * 1	3		7			Psum[7]-Psum[2]
		 * 2	1		3			Psum[3]-Psum[0]
		 * 3	7		7			Psum[7]-Psum[6]
		 * 4	3		6			Psum[6]-Psum[2]
		 * 5	0		4			Psum[4]-Psum[0-1]=-1 : Error : Array Index Out of Bounds.
		 * 				|
		 * 				-----> Sum of All Elements from [0...4]=Psum[4]
		 */
		
		/*  Q:[S  E]= if(s==0) //[0...e]
		 * 			  {
		 * 				psum[e];
		 * 			  }
		 * 			  else [S.....E]
		 * 			  {
		 * 				psum[e]-psum[s-1];
		 * 			  }
		 * 
		 *  	
		 */
		
		// For The Range Sum Question ---> Applay ---> Prefix_Sum Method 
		System.out.println("RangeSum-->Optimized Code ");
		int ans2[]=RangeSum2(ar1,Q);
		// Constraints : 1<=N,Q<=10^5
		for(int x:ans2)
		{
			System.out.print(x+" ");
		}
		
		// Q) Given Array Ele & Q- Queries
		// Each Queries Contain S & E
		// For Every Query Calculate Sum of even index elements from range[s....e]
		// Constains :
		// 1<=N,Q<=10^5
		
		// Idea-1 :
		// For Every Query from {s...e}
		// Iterate & Calculate Sum of All Even Index Ele
		// T.C=O(Q*N)
		// S.C=O(1)
		
		// Idea-2 :
		// Way1:Psum[i]=Sum of Alla Elements from [0..i]
		// Way2:Create Psum[N/2]
		// Way3:if index Ele is Odd : Assume Value=0;
		//		Now Construct psum[];
		//		Psum[i]=Sum of All Even index Ele from[0...i]
		System.out.println();
		int ar2[]= {2,4,3,7,9,8,6,3,4,9};
		int Q1[][]= { {4,8},{3,9},{2,7},{0,4}};
		System.out.println("Even index RangeSum ");
		int ans3[]=EvenIndexRangeSum2(ar2,Q1);
		// Constraints : 1<=N,Q<=10^5
		for(int x:ans3)
		{
			System.out.print(x+" ");
		}
		
		// For Odd index Question
		System.out.println();
		int ans4[]= OddIndexRangeSum(ar2,Q1);
		for(int x:ans4)
		{
			System.out.print(x+" ");
		}
		
		// 
		
	}

	private static int[] OddIndexRangeSum(int[] ar1, int[][] qr) // T.C= O(N+Q)
	{													 		 // Total Iterations= N+Q	
		int n=ar1.length;								  		 // S.C= O(N)	
		 int q=qr.length;
		 // Step-1 : Create Psum[]----> N-iterations
		 int psum[]=new int[n];
		 int sum=0;
		 for(int i=0;i<n;i++)
		 {	 if(i%2==1) // Only Odd Index Ele Sum will Update For even index sum will remain same.
		     {
			  sum=sum+ar1[i];
		     }
			 psum[i]=sum;
		 }
		 // Step-2 : Ans each Query using psum[]-->Q-iterations
		 int ans[]=new int[q];
		 for(int i=0;i<q;i++)
		 {
			 int s=qr[i][0];
			 int e=qr[i][1];
			 
			 if(s==0) // [0...e]
			 {
				 ans[i]=psum[e];
			 }
			 else // [s...e]
			 {
				 ans[i]=psum[e]-psum[s-1];
			 }
		 }
		 
		 return ans; 
		 
	}

	private static int[] EvenIndexRangeSum2(int[] ar1, int[][] qr) // T.C= O(N+Q)
	{ 															   // Total Iterations= N+Q
		 int n=ar1.length;								  		   // S.C= O(N)	
		 int q=qr.length;
		 // Step-1 : Create Psum[]----> N-iterations
		 int psum[]=new int[n];
		 int sum=0;
		 for(int i=0;i<n;i++)
		 {	 if(i%2==0) // Only Even Index Ele Sum will updated For odd index sum will remain same.
		     {
			  sum=sum+ar1[i];
		     }
			 psum[i]=sum;
		 }
		 // Step-2 : Ans each Query using psum[]-->Q-iterations
		 int ans[]=new int[q];
		 for(int i=0;i<q;i++)
		 {
			 int s=qr[i][0];
			 int e=qr[i][1];
			 
			 if(s==0) // [0...e]
			 {
				 ans[i]=psum[e];
			 }
			 else // [s...e]
			 {
				 ans[i]=psum[e]-psum[s-1];
			 }
		 }
		 
		 return ans; 
	}

	private static int[] RangeSum2(int[] ar1, int[][] qr) // Total Iterations= N+Q
	{													  // T.C= O(N+Q)	
		 int n=ar1.length;								  // S.C= O(N)	
		 int q=qr.length;
		 // Step-1 : Create Psum[]----> N-iterations
		 int psum[]=new int[n];
		 int sum=0;
		 for(int i=0;i<n;i++)
		 {
			 sum=sum+ar1[i];
			 psum[i]=sum;
		 }
		 // Step-2 : Ans each Query using psum[]-->Q-iterations
		 int ans[]=new int[q];
		 for(int i=0;i<q;i++)
		 {
			 int s=qr[i][0];
			 int e=qr[i][1];
			 
			 if(s==0) // [0...e]
			 {
				 ans[i]=psum[e];
			 }
			 else // [s...e]
			 {
				 ans[i]=psum[e]+psum[s-1];
			 }
		 }
		 
		 return ans;
	}

	private static int[] prefixWay2(int[] arr) 
	{
		 int n=arr.length;
		 int psum[]=new int[n];
		 psum[0]=arr[0];// mandatory
		 
		 for(int i=1;i<n;i++)
		 {
			 psum[i]=psum[i-1]+arr[i];
		 }
		 return psum;
	}

	private static int[] prefixWay1(int[] arr) 
	{ 
		int n=arr.length;
		int sum=0;
		int pf[]=new int[n];
		for(int i=0;i<n;i++)
		{
			sum=sum+arr[i];
			pf[i]=sum;
		}
		return pf;
	}

	private static int[] RangeSum(int[] ar1, int[][] q) // T.C= O(Q*N)
	{ 													// S.C= O(1)
		int n=q.length;									// According to Constraints :
		int ans[]=new int[n];							// T.C = 10^5 * 10^5 =10^10> 10^8-->TLE 
		
		for(int i=0;i<n;i++)
		{
			// For ith Query :get S & E
			int s=q[i][0],e=q[i][1];
			int sum=0;
			for(int j=s;j<=e;j++)
			{
				sum=sum+ar1[j];
			}
			ans[i]=sum;
		}
		return ans;
	}

	private static int SumOfEle(int[] a, int s, int e) // Worst Case Iterations = N-Iterations
	{												   // T.C=O(N)	
		 int n=a.length;							   // S.C=O(1)
		 int sum=0;
		 for(int i=s;i<=e;i++)
		 {
			 sum=sum+a[i];
		 }
		 return sum;
	}

}
