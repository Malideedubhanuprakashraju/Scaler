package One1D_Arrays;

public class Class_13_1D_Arrays 
{

	public static void main(String[] args) 
	{
		/* Q1)Max Subarray Sum
		 * 
		 * Given Array Return Max Subarray Sum.
		 * 
		 * eg-1 : ar[]= {-2,3,4,-1,5,-10,7};
		 * 
		 * ans = {1:4}=11
		 * 
		 * eg-2 : ar[]= {4,5,2,1,6};
		 * 
		 * ans = {0:4}= 18
		 * 
		 * 
		 * Idea-1 : For all Subarrays iterate & calculate Sum & get Overall Max.
		 * 
		 */
		int ar[]= {4,5,2,1,6};
		int ans=maxSub1(ar);
		System.out.println(ans);
		
		/* Optimization : Kadane's Algorithm : Max Subarray Sum.
		 * 
		 * Case-1 : If all the Elements in the Array are Positive.
		 * Ans	  : Sum of All Elements
		 * 
		 * Case-2 : If all the elements in the Array are Negative.
		 * Ans	  : Max One
		 * 
		 * Case-3 : If Positives are present in between.
		 * Ans	  : Sum All Positive No's
		 * 
		 * Idea : +ve Sum Take it Forward, -ve Sum reset to 0.
		 * 
		 * eg :
		 * 
		 * ar[] = {-2,3,4,-1,5,-10,7};
		 * sum=0   -2 3 7  6 11	 1 8		
		 * 			0
		 * max=-in -2 3 7  7  11 11 11
		 * 
		 * Definition (Kadane’s Algorithm):

			Kadane’s Algorithm is an O(N) dynamic programming algorithm 
			used to find the maximum sum of a contiguous subarray in a given array of integers.
		 * 
		 */
		int ar1[]= {-2,3,4,-1,5,-10,7};
		int ans1=maxSubKadanes(ar1);
		System.out.println(ans1);
		
		/* Q2)Zero Queries
		 * 
		 * Given Array[N]=0, All Zeros & Q-Queries
		 * For each Query : Given(S,V)--> Add V to all index elements from index {s....n-1}
		 * Once all queries are done return final Array
		 * 
		 * eg :
		 * 
		 * N=7		0	1	2	3	4	5	6
		 * ar[7]=	0	0	0	0	0	0	0
		 * 
		 * Q[3][2]= 
		 * 
		 * S	V
		 * 1	3	0	3	3	3	3	3	3
		 * 4   -2					-2	-2	-2
		 * 3	1				1	1	1	 1
		 * ---------------------------------------
		 * 			0	3	3	4	2	2	2
		 * 
		 * Idea-1:
		 * 		 For Every Query (S,V)
		 * 		 Add Value V from index S...N-1
		 * T.C : O(Q*N)
		 * S.C : O(1)
		 * 
		 * Idea-2:
		 * 		 For Every Query (S,V) : Update Array : ar[s]+=v;
		 * 		 Calculate Cumulative Sum or Psum[]
		 * 
		 */
		int q[][]= {{1,3},{4,-2},{3,1}};
		int n=7;
		int ans2[]=ZeroQueries(n,q);
		for(int x:ans2)
		{
			System.out.print(x+" ");
		}
		
		// Q3) Zero Queries-2
		// Given an Array[N], Initially all Ele=0, and Q-queries.
		// For each Query : Given (s,e,v) add element v to all indices from {s...e}
		// Once all queries are done return final Array.
		
		/* Idea-1 :
		 * 		  For every query from (s,e,v)
		 * 		  Add V to all elements from [s...e]
		 * T.C : O(Q*N)
		 * S.C : O(1)
		 * 
		 * In previous Q : We add v from s to N-1
		 * In current  Q : we add v from s to e
		 * 
		 * Idea :
		 * 
		 * Query :
		 * 
		 * s	e	v
		 * 
		 * Adding v from s to n-1 : PrevQuestion	: ar[s]+=v
		 * 														} Perform 2 updates
		 * Adding -v from e+1 to n-1 : prevQuestion : ar[e+1]+=-v
		 * 
		 */
		int qq[][]= {{1,4,3},{0,5,-1},{2,2,4},{4,6,3}};
		int nn=7;
		int ans22[]=ZeroQueries2(nn,qq);
		System.out.println();
		for(int x:ans22)
		{
			System.out.print(x+" ");
		}
		
		
	}

	private static int[] ZeroQueries2(int nn, int[][] qq) // T.C = O(Q*1 +N)
	{													  // S.C = O(1)
		int ans[]=new int[nn];// Initilized to 0
		int q=qq.length;// rows=>no.of queries
		
		for(int i=0;i<q;i++)//------->Q
		{
			//For each Q: we have (s,e,v)
			int s=qq[i][0],e=qq[i][1],v=qq[i][2];
			ans[s]=ans[s]+v;//update
			if(e+1<nn)
			{
				ans[e+1]=ans[e+1]-v;
			}
			
		}
		
		int sum=0;
		int psum[]=new int[nn];
		for(int i=0;i<nn;i++)
		{
			sum=sum+ans[i];
			psum[i]=sum;
		}
		return psum;
	}

	private static int[] ZeroQueries(int n, int[][] q)// T.C =O(Q*1+N) =O(Q+N), S.C=O(1) 
	{
		int ans[]=new int[n];// Initialized to 0
		int l=q.length;// Rows =>No.of Queries
		for(int i=0;i<l;i++)//---------->Q
		{
			int s=q[i][0],v=q[i][1];
			ans[s]=ans[s]+v;
		}
		int sum=0;// Appaly Pfsum------->N
		int psum[]=new int[n];
		for(int i=0;i<n;i++)
		{
			sum=sum+ans[i];
			psum[i]=sum;
		}
		return psum;
	}

	private static int maxSubKadanes(int[] ar) // T.C = O(N)
	{										   // S.C = O(1)
		 int n=ar.length;
		 int ans=Integer.MIN_VALUE;
		 int sum=0;
		 for(int i=0;i<n;i++)
		 {
			 sum=sum+ar[i];
			 if(sum>ans)
			 {
				 ans=sum;
			 }
			 if(sum<0)
			 {
				 sum=0;// don't take it forward
			 }
		 }
		 return ans;
	}

	private static int maxSub1(int[] ar) // T.C = O(N^2)*O(N) = O(N^3), S.C = O(1)
	{
		int n=ar.length;
		int ans=Integer.MIN_VALUE;
		
		for(int s=0;s<n;s++)
		{
			for(int e=s;e<n;e++)
			{										// T.C= O(N+N^2*1)= O(N^2), S.C=O(N)
				//Subarray[s....e]		-------------> Create Psum[]
				int sum=0;							// int sum=0;
				for(int i=s;i<=e;i++)			    // if(s==0)
				{									// {sum=psum[e];}
					sum=sum+ar[i];					// else{ sum=psum[e]-psum[s-1]}
				}									// if(sum>ans){ ans=sum;}
				if(sum>ans)
				{
					ans=sum;
				}
			}
			
		}
		return ans;
	}

}
