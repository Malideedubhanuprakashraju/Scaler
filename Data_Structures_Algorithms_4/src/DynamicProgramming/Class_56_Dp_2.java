package DynamicProgramming;

public class Class_56_Dp_2 
{	
	static int dp[];
	
	static int dp1[][];
	

	public static void main(String[] args) 
	{
		/* Revision :
		 * 
		 * 1) DP : Store Already solved problem and avoid repetition.
		 * 
		 * 2) DP on Fibanacci :
		 * 
		 * 	  a) Initial T.C : O(2^N) ------> Optimize ------> O(N)
		 * 
		 * 3) Bottom Up Approach :
		 * 
		 * 	  a) Fill Smallest Subproblem & we will continue fill remaining.
		 * 
		 * 
		 * DP when ?
		 * 
		 * a) Overlapping Subproblems -----> Solve First Recursion
		 * 
		 * DP Steps :
		 * 
		 * a) Recursion Based					b) Iterative Based
		 * 
		 * 	  1) DP Table						   1) DP Table
		 * 
		 * 	  2) DP State						   2) DP State
		 * 
		 * 	  3) DP Size						   3) DP Size
		 * 
		 * 	  4) Initialization					   4) DP Expression
		 * 
		 * 	  5) DP Code						   5) DP Code
		 * 
		 * 	  6) T.C / S.C						   6) T.C / S.C
		 * 
		 * 
		 * When to Appalay DP ?
		 * 
		 * When we can Solve a Problem with Recursion & Overlapping Subproblems.
		 * 
		 * Ways to Appaly DP ?
		 * 
		 * a) Recursion : Memoization
		 * 
		 * b) Iterative : Tabulation
		 * 
		 * Steps to Appaly Recursive DP ?
		 * -----------------------------
		 * 
		 * -> DP Table : Where we store our subproblems in Array.
		 * 
		 * -> DP State : What we are storing => Which Subproblem information are we Storing ?
		 * 
		 * -> Table Size 
		 * 
		 * -> Initialization
		 * 
		 * -> DP Code : 1^st Time = Solve & Store it 	, 	2^nd Time : Reuse it
		 * 
		 * -> T.C / S.C
		 * 
		 * Steps to Appaly Iterative DP ?
		 * ------------------------------
		 * 
		 * -> DP Table : Where we store our subproblems in Array.
		 * 
		 * -> DP State : What we are Storing => Which Subproblem info are we Storing ?
		 * 
		 * -> Table Size 
		 * 
		 * -> DP Expression : Solving problem with Subproblem { DP State }
		 * 
		 * -> DP Code : Take care of Edge Cases.
		 * 
		 * -> T.C / S.C
		 *   
		 */
		
		// Q1) Given Array[N], Calculate Max Sum, We can get
		/*
		 * Note-1 : 2-Adjacent Elements Cannot be picked
		 * 
		 * Note-2 : We can avoid picking any Element : Sum = 0
		 * 
		 * Eg-1 :
		 * 
		 * ar[3] = { 9, 14, 3 };
		 * 
		 * Ans = 14
		 * 
		 * Eg-2 :
		 * 
		 * ar[4] = { 10, 20, 30, 40 };
		 * 
		 * Ans = 33
		 * 
		 * Eg-3 :
		 * 
		 * ar[4] = { -4, -3, -2, -3 };
		 * 
		 * Ans = 0 // Not Picking a Single Element
		 * 
		 */
		
		/* Idea-1 :
		 * 
		 * Odd index sum & Even index sum & Compare
		 * 
		 * Above Logic Won't Work
		 * 
		 * 
		 * Idea-2 :
		 * 
		 * 
		 * ar[8] = { 2, -1, -4, 5, 3, -1, 4, 2 };// In Recursion : DP -> We generally go from R -> L
		 * 
		 * 						MS(7)
		 * 
		 * 		MS(6)//Not Pick MS(7)			MS(5) + ar[7]// Pick MS(7)
		 * 
		 * 
		 * MS(5)		MS(4)+ar[6]		   MS(4)	MS(3)+ar[5]
		 *   
		 */
		
		// Solve with Recursion
		/*
		 * Ass : MS(i) = Max Sum from [0...i] without Adjacent Elements.
		 *  
		 */
		int ar[] = {9,14,3};
		
		int ans1=Solve(ar);
		System.out.println("Max Sum Recursive Code : "+ans1);
		
		// How to Applay DP ?
		
		// DP with Recursive => Memoization //“Remembering past results and reusing them instead of calculating again.”
		
		/* 1) DP Table : Where we store our Subproblems in Array : 1D
		 * 
		 * 2) DP State : What are we Storing => Which Subproblem info are we Storing ?
		 * 
		 * 	  DP[i] = MS(i) = Max Sum from [0....i] Without Adjacent Element
		 * 
		 * 	  DP[N-1] = MS(N-1) = Max Sum from [0.....N-1] Without Adjacent Element
		 * 
		 * 3) Table Size DP[N]
		 * 
		 * 4) Initialization : If Subproblem => 1^st : Solve & Store  , => 2^nd : Reuse
		 * 
		 * 	  dp[] = -1; // Invalid
		 * 
		 * 5) DP Code
		 * 
		 * 6) TC & SC
		 *  
		 */
		int n=ar.length;
		int ans2=Solve1(ar,n);
		System.out.println("Max Sum with Top Down Approach : "+ans2);
		
		
		// DP with Iterative Code => Tabulation
		
		//int n=ar.length;
		int ans3=Solve2(ar,n);
		System.out.println("Max Sum with Bottom Up Approach : "+ans3);
		
		/*
		 *  | Meaning             | Condition  |
			| ------------------- | ---------- |
			| At least 1 element  | `n >= 0`   |
			| At least 2 elements | `n >= 1` ✅ |
			| At least 3 elements | `n >= 2`   |
		 * 
		 */
		
		/*
		 *  | Approach        | Type      | Space      |
			| --------------- | --------- | ---------- |
			| Recursion       | —         | O(N) stack |
			| Memoization     | Top-Down  | O(N)       |
			| Tabulation      | Bottom-Up | O(N)       |
			| Space Optimized | Bottom-Up | O(1) ✅    |

		 */
		
		System.out.println("Space Optimization in Bottom Up Approach O(N) -> O(1) ");
		int ans4=MaxSumBopt(ar);
		System.out.println("Max Sum with Bottom Up Approach Space Optimization : "+ans4);
		
		/*
		 *  | Approach          | Time   | Space      |
			| ----------------- | ------ | ---------- |
			| Recursion         | O(2^N) | O(N) stack |
			| Memoization       | O(N)   | O(N)       |
			| Tabulation        | O(N)   | O(N)       |
			| Optimized (Yours) | O(N)   | **O(1)**   |

		 */
		
		
		// Q5) Number of Ways to go from (0,0) --> BR Cells in Mat[N][M]
		/*
		 * Note : From Cell we can go to right -> or down |
		 * 
		 * Eg :
		 * 
		 * 		0	1	2
		 *   0	-	-	|
		 * 	 1	-	-	.
		 * 
		 *  Ans = 3
		 *  
		 *  
		 * Idea-1 :
		 * -------
		 * 
		 * Mat[N][M] 
		 * 
		 * 					Ways(N-1,M-1)
		 * 
		 * 			Ways(N-2,M-1)		Ways(N-1,M-2)
		 * 
		 *    Ways(N-3,M-1)		   Ways(N-2,M-2)***		Ways(N-1,M-3)
		 *    
		 *    				 Ways(N-2,M-2)***		
		 * 
		 * Assumption : Ways to Reach (i,j) from (0,0)
		 *   
		 */
		System.out.println();
		System.out.println("Ways to Reach Recursive Code (i,j) from (0,0)");
		
		// Declare and initialize 2D matrix
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Print matrix
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
		
        int k=mat.length;
        int m=mat[0].length;
		int ans5=waysToReach(k-1,m-1);
		
		 
		System.out.println("Ways to Reach Recursive Code : "+ans5);
		
		System.out.println();
		
		System.out.println("Ways to Reach => DP TopDown Memoization Code ");
		
		
		dp1 = new int[k][m];  // ✅ important

		for (int i = 0; i < k; i++) {
		    for (int j = 0; j < m; j++) {
		        dp1[i][j] = -1;
		    }
		}
		int ans6=WaystoTop(k-1,m-1,dp1);
		System.out.println("Ways to Reach TopDown Approach : "+ans6);
		
		System.out.println();
		
		
		// DP Iterative Code - No of Ways to Reach 
		int[][] dp2 = new int[k][m];  // fresh DP table
		int ans7 = WaystoBottom(mat, dp2);
		System.out.println("Ways to Reach BottomUp Approach : "+ans7);
		
		System.out.println();
		
		System.out.println("Space Optimization Bottom Up => Approach");
		
		/* Your original DP:
		 * 
		 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
		 * 
		 * To compute current cell, you only need:
		 * 
		 * i-1	|	|	|
		 * 
		 * i	|	|	|
		 * 
		 * Obs-1 : To fill i^th Row, we only need i-1^th Row Information.
		 * 
		 * 
		 * Obs-2 : At any given we use 2-rows { i , i-1 }, Hence we only need 2-rows.
		 * 
		 * 
		 * How to Code with 2-rows :
		 * 
		 * Conclusion : i^th row information : we will store in i%2 row number
		 * 
		 *  			i-1^th row information : we will store in (i-1)%2 row number
		 *  
		 * 
		 *  
		 */
		
		int ans8=Ways1D(k,m);
		System.out.println("Ways to Reach Space Optimize Code "+ans8);
		
		// Catalan Numbers :
		/*
		 * The Catalan form a Sequence of Natural Numbers that have numerous applications in combinatorial mathematics, each number in the sequence to variety 
		 * 
		 * of counting problems.
		 * 
		 * The N^th Catalan number, denoted as Cn, can be used to determine.
		 * 
		 * a) The number of correct combinations of N-pairs of Parathesis.
		 * 
		 * b) The number of distinct search tree with N Nodes.
		 * 
		 * 
		 * Eg: N : 1	2	3
		 * 
		 * C0 = 1
		 * 
		 * C1 = 1
		 * 
		 * C2 = C0 * C1 + C1 * C0 = 2
		 * 
		 * C3 = C0 * C2 + C1 * C1 + C2 * C0 = 5
		 * 
		 * C4 = C0 * C3 + C1 * C2 + C2 * C1 + C3 * C1 + C4 * C0 = 14
		 * .
		 * .
		 * .
		 * 
		 * Cn = C0 * Cn-1 + C1 * Cn-2 + .	.	.	.	+ Cn-1 * C0
		 *  
		 */
		int a=Catalon(5);
		System.out.println("Catalong N Value : "+a);
		
		// Q) Given N Distinct Numbers, How Many Different BST Can be Formed.
		/*
		 * Eg :
		 * 
		 * 10, 20, 30 : 5-BST's are present
		 * 
		 * 10				10			20					30			30
		 * 		20				30	 10		30			20			10
		 * 			30		 20						 10					20
		 * 
		 * Idea :
		 * 
		 * Say with i distinct numbers : we can have ci no of BST
		 * 
		 * We can use Catalon Formuala
		 * 
		 */
		
		int b=BST(3);
		System.out.println("N Different BST can be formed : "+b);
				
	}

	private static int BST(int n) // T.C = O(N^2)
	{							  // S.C = O(1)
		// Given N Store All Numbers from C0....Cn
		
				int[] c=new int[n+1];
				
				c[0]=c[1]=1;
				
				for(int i=2;i<=n;i++)
				{
					// Calculate Ci = C0 * Ci-1 + C1 * Ci-2 + .	.	.	.	+ Ci-1 * C0
					
					int sum=0,p1=0,p2=i-1;
					
					while(p1<i)
					{
						sum=sum+c[p1]*c[p2];
						p1++;
						p2--;
					}
					c[i]=sum;
				}
				
				return c[n];
		 
	}

	private static int Catalon(int n) // T.C = O(N^2)
	{								  // S.C = O(1)
		
		// Given N Store All Numbers from C0....Cn
		
		int[] c=new int[n+1];
		
		c[0]=c[1]=1;
		
		for(int i=2;i<=n;i++)
		{
			// Calculate Ci = C0 * Ci-1 + C1 * Ci-2 + .	.	.	.	+ Ci-1 * C0
			
			int sum=0,p1=0,p2=i-1;
			
			while(p1<i)
			{
				sum=sum+c[p1]*c[p2];
				p1++;
				p2--;
			}
			c[i]=sum;
		}
		
		return c[n];
		
	}

	private static int Ways1D(int n, int m) // T.C = O(N*M)
	{										// S.C = O(M)
		 int dp[][]=new int[2][m];
		 
		 // dp[i][j] = Ways to reach cell (i,j)
		 
		 // dp[i][j] = dp[i-1][j] + dp[i][j-1] // From top + from left
		 
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 if(i==0 || j==0)
				 {
					 dp[i%2][j]=1; // % 2 → tells which row (0 or 1)
				 }
				 else
				 {
					 dp[i%2][j]=dp[(i-1)%2][j]+dp[i%2][j-1];
				 }
			 }
		 }
		 
		 return dp[(n-1)%2][m-1];// m-1 → last column // dp[(n-1)%2][m-1] = value of last cell stored in reused 2-row DP
	}

	private static int WaystoBottom(int[][] mat, int[][] dp2) // T.C = O(N×M)
	{														  // S.C = O(N×M)
		
		 // DP Expression : Solving Problem with Subproblems => State Values
		 /*
		  * Edge Cases : dp[i][j] = dp[i-1][j] + dp[i][j-1]
		  * 
		  * 			 dp[0][j] = dp[-1][j] + dp[0][j-1]
		  * 
		  * 			 dp[i][0] = dp[i-1][0] + dp[i][-1]
		  * 
		  * 			 dp[0][0] = dp[-1][0]  + dp[0][-1]
		  * 
		  */
		
//		for(int i=0;i<mat.length;i++)
//		{
//			for(int j=0;j<mat[0].length;j++)
//			{
//				if(i==0 && j==0)
//				{
//					dp2[i][j]=1;
//				}
//				else if(i==0)
//				{
//					dp2[i][j]=dp2[i][j-1];
//				}
//				else if(j==0)
//				{
//					dp2[i][j]=dp2[i-1][j];
//				}
//				else
//				{
//					dp2[i][j]=dp2[i][j-1]+dp2[i-1][j];
//				}
//			}
//		}
		for(int i=0;i<mat.length;i++)
		{
			for(int j=0;j<mat[0].length;j++)
			{
				if(i==0 || j==0)
				{
					dp2[i][j]=1;
				}
				else
				{
					dp2[i][j]=dp2[i][j-1]+dp2[i-1][j];
				}
			}
		}

		
		return dp2[mat.length-1][mat[0].length-1];
		 
	}

	private static int WaystoTop(int i, int j, int[][] dp1) // T.C = O(N×M)
	{														// S.C = O(N×M)
		 if(i<0 || j<0)
		 {
			 return 0;
		 }
		 
		 if(i==0 && j==0)
		 {
			 return 1;
		 }
		 
		 if(dp1[i][j]==-1)
		 {
			 dp1[i][j]=WaystoTop(i-1,j,dp1)+WaystoTop(i,j-1,dp1);
		 }
		 
		 return dp1[i][j];
	}

	private static int waysToReach(int i, int j) // T.C = O(2^(N+M))
	{											 // S.C = O(N+M)
		 if(i<0 || j<0)
		 {
			 return 0;
		 }
		 
		 if(i==0 && j==0)
		 {
			 return 1;
		 }
		 
		 return waysToReach(i-1,j)+waysToReach(i,j-1);
	}

	private static int MaxSumBopt(int[] ar) // T.C = O(N)
	{										// S.C = O(1)*************
		 int n=ar.length;
		 
		 if(n == 0) return 0;
		 if(n == 1) return Math.max(0, ar[0]);
		 
		 int prev2=Math.max(0, ar[0]);
		 int prev1=Math.max(prev2,ar[1]);
		 
		 for(int i=2;i<n;i++)
		 {
			 int curr=Math.max(prev1, prev2+ar[i]);
			 
			 prev2=prev1;
			 prev1=curr;
		 }
		 
		 return prev1;
	}

	private static int Solve2(int[] ar, int n) 
	{
		dp=new int[n];
				
		// return MaxSumBottom(ar,n-1);// n -> Last index in Array (Not Array Size)
		
		return MaxSumBottom1(ar);
	}

	private static int MaxSumBottom1(int[] ar) // Without N Value // T.C = O(N)
	{															  // S.C = O(N)
		 int n=ar.length;
		 
		 // Edge cases
		 if (n == 0) 
			 return 0;
		 if (n == 1) 
			 return Math.max(0, ar[0]);

		 int[] dp = new int[n];
		 
		 dp[0]=Math.max(0, ar[0]);
		 
		 if(n>1)
		 {
			 dp[1]=Math.max(dp[0],ar[1]);
		 }
		 
		 for(int i=2;i<n;i++)
		 {
			 dp[i]=Math.max(dp[i-1],dp[i-2]+ar[i]);
		 }
		 
		 return dp[n-1];
	}

	private static int MaxSumBottom(int[] ar,int n) // T.C = O(N)
	{												// S.C = O(N)
		dp[0]=Math.max(0,ar[0]);
		
		System.out.println(dp[0]);
		
		if(n>=1)// Here n -> index not Array Length *
		{
			dp[1]=Math.max(dp[0],ar[1]);
		}
		
		System.out.println(dp[1]);
		
		for(int i=2;i<=n;i++)
		{
			dp[i]=Math.max(dp[i-1],dp[i-2]+ar[i]);
		}
		System.out.println(dp[2]);
		
		return dp[n-1];
		
	}

	private static int Solve1(int[] ar, int n) 
	{
		dp=new int[n];
		
		for(int i=0;i<n;i++)
		{
			dp[i]=-1;
		}
		
		return MaxSumTopD(ar,n-1);
	}

	private static int MaxSumTopD(int[] ar, int i)// T.C = O(N) 
	{											  // S.C = O(N)
		 if(i<0)
		 {
			 return 0;
		 }
		 
		 if(dp[i]==-1)
		 {
			 dp[i]=Math.max(MaxSumTopD(ar,i-1),MaxSumTopD(ar,i-2)+ar[i]);
		 }
		 
		 return dp[i];
	}

	private static int Solve(int[] ar) 
	{
		 return MaxSum(ar,ar.length-1);
	}

	private static int MaxSum(int[] ar, int i) // T.C = O(2^N)
	{										   // S.C = O(N)
		 if(i<0)
		 {
			 return 0;
		 }
		 
		 return Math.max(MaxSum(ar,i-1),MaxSum(ar,i-2)+ar[i]);
	}

}
