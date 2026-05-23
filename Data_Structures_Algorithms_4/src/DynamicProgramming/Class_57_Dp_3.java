package DynamicProgramming;

public class Class_57_Dp_3 
{	
	static int dp[][];

	public static void main(String[] args) 
	{
		// Q1) Target Sum
		/* 
		 * You are given N+ve Integers and Target K.
		 * 
		 * Check if there exists a Subset with Sum==K.
		 * 
		 * Eg-1 : ar[] = { 3, 4, 5, 7, 2 };
		 * 			
		 * 		  K = 10;
		 *  
		 */
		/* Idea-1 : Solve with Recursion
		 * 
		 * Assumption : Using Elements [0....4], Check if we can get Sum=10.
		 * 
		 * 					Sum(4:10)
		 * 
		 * 		Sum(3:10)//Exclude		Sum(3:8)//Include 4^th Index
		 * 
		 * 
		 */
		/*
		 * A subset is a collection of elements selected from a set or array, where elements may be included or excluded in any combination.

		   If every element of set A is present in set B, then A is called a subset of B.
		   
		   	B = {3, 4, 5, 7}

			Subsets:
			{}
			{3}
			{4,7}
			{3,5,7}
			{3,4,5,7}
		 */
		// Assumption : Using indices from [0...i] , check if we can get Target j.
		
		int ar[] = { 3, 4, 5, 7, 2 };
		System.out.println("Solving with Recursion ");
		boolean ans=SumK(ar,ar.length-1,10);
		
		/* ar[] = 0		1	2	3	.	.	.	i-1		i	Target = j
		 * 
		 * 										Sum(i-1,j)//Exclude i		Sum(i-1, j-ar[i])				
		 * 
		 * 																	if(j>=A[i])																
		 * 
		 */
		System.out.println("Recursion --> "+ans);
		
		System.out.println("Solving Problem with Top-Down Approarch Memoization");
		/*
		 * 1) DP Table : 2D
		 * 
		 * 2) DP State :
		 * 
		 * 				dp[i][k] = Sum(i,k) = Using [0..i] Check if we can get sum = j
		 * 
		 * 				dp[N-1][k] = Sum(N-1,k) = Using [0...N-1] Check if we can get sum = k
		 * 
		 * 3) DP Size 
		 * 
		 * 4) Initialize 
		 * 
		 * 	  dp[N][k+1] = -1; Invalid
		 * 
		 * 5) Code
		 * 
		 * 6) TC & SC
		 * 
		 */
		
		boolean ans1=Solve(ar,10);
		System.out.println("Top Down Answer using DP --> "+ans1);
		System.out.println();
		
		boolean ans2=Solve2(ar,10);
		System.out.println("Bottom Up Approach using DP --> "+ans2);
		
		System.out.println();
		
		// Q2) Knapsack :
		/*
		 * 	   N - items, each item a Weight & Value assaigned.
		 * 	   
		 * 	   Calculate Max Value obtained by picking items such that Overall Weight <= K
		 * 	
		 * 	   
		 *  Fractional Knapsack : I can take a Part / Ration of item
		 *  
		 *  0 / 1 Knapsack : Each item can be picked 0/1 Time => { Take it or Leave it }
		 *  
		 *  Infinite Knapsack : I can Take an Item as Many Times as I want.
		 *  
		 *  
		 *  Problem : 0/1 Knapsack
		 *  
		 *  Eg : N=4	K=50
		 *  
		 *  	items :   0		1	 2		3
		 * 
		 * 		Weight[]: 20	10	 30		40
		 * 
		 * 		Value[]	: 100	60	 120	150
		 * 
		 *  Solution-1 :
		 *  -----------
		 *  C1 : 0		2
		 *  	 20		30
		 *  	 100	120
		 *  
		 *  Ans : Value = 220
		 *  
		 *  Solution-2 :
		 *  -----------
		 *  C2 : 0		1	  2
		 *  	 20		10	  30
		 *  	 100	60	  120
		 *  
		 *  Ans : Weight > 50
		 *    
		 */
		
		// Way-1 : Using Recursive Code
		
		System.out.println("Recursive Code -> Knapsack ");
		
		// Assumption : Using items [0....i] & Weight limit<= j ==> return Max Value
		
		int weight[]= {20,10,30,40};
		int value[]=  {100,60,120,150};
		
		int ans3=maxValue(weight.length-1,weight,value,50);
		System.out.println("Knapsack Problem Answer using Recursive : "+ans3);
		
		/* Take it OR Leave it
		 * 
		 * then it is usually a 0/1 Knapsack problem.
		 * 
		 * Why called "0/1"?
		 * 
		 * For every item:
		 * 
		 * 	| Choice | Meaning         |
			| ------ | --------------- |
			| 0      | Don't take item |
			| 1      | Take item once  |

		 * You cannot take:
		 * 
		 * half item
		 * 
		 * same item multiple times
		 * 
		 * Typical Clues in Question

			If the problem says:
			
			"Pick items"
			"Each item can be used once"
			"Choose subset"
			"Cannot repeat items"
			"Maximize value"
			"Capacity / Weight limit"
			"Take or skip"
			
			then think:
			
			0/1 Knapsack
		 * 
		 */
		
		
		
		
		// Way-2 :  Top Down Approach : Memoization 
		/*
		 * DP Table : 2D
		 * 
		 * DP State : dp[i][j] = Using [0...i] items & weight <= j return Max Value
		 * 
		 * 			  dp[n-1][k] = Using [0....N-1] items & weight <= k return Max Value
		 * 
		 * DP Size & Initialization 
		 * 
		 * 			  dp[n][k+1]=-1;
		 * 
		 * DP Code
		 * 
		 */
		
		int ans4=Solve4(weight,value,50);
		System.out.println("Knapsack Problem Answer using Top Down Approach : "+ans4);
		
		System.out.println();
		int ans5=Solve5(weight,value,50);
		System.out.println("Knapsack Problem Answer using Bottom Up Approach : "+ans4);
		
		System.out.println();
		
		// Unbounded Knapsack : Same item can be reused infinitely
		
		// Q3) Use items within Weight Limit get Max Value
		/*
		 * 	   Inifinite Knapsack : I Can Take an item as Many Times as I want.
		 * 	
		 * 	    | Term             | Meaning                                     |
				| ---------------- | ------------------------------------------- |
				| Arcade           | Place to play coin/token-based games        |
				| Game Shop        | Store that sells games/consoles/accessories |
				| Arcade Game Shop | Combination of both                         |

		 * 	A place for playing and/or buying games and gaming equipment.
		 * 
		 *  Note : My Choices for a Game
		 *  
		 *  	   1) Skip it
		 *  
		 *  	   2) Play once & Stay
		 *  
		 */
		
		/*  | Index | Weight | Value |
			| ----- | ------ | ----- |
			| 0     | 1      | 1     |
			| 1     | 50     | 30    |

		 *  | Variable  | Meaning               |
			| --------- | --------------------- |
			| `N = 2`   | Total number of items |
			| `K = 100` | Maximum bag capacity  |
			
			| Option   | Items Chosen                      | Total Weight    | Total Value     | Valid?     |
			| -------- | --------------------------------- | --------------- | --------------- | ---------- |
			| Option 1 | Item 1 `(50,30)` + Item 0 `(1,1)` | `50 + 1 = 51`   | `30 + 1 = 31`   | Yes        |
			| Option 2 | Item 0 `(1,1)` taken 100 times    | `1 × 100 = 100` | `1 × 100 = 100` | Yes ✅ Best |

			Capacity K = 100;
			
			Generalized : 
			
			items  : 0	1	2	.	.	.	.	i-1		i	Limit : j
			
			weight : w0	w1	w2	.	.	.	.	wi-1 	wi
			
			values : v0	v1	v2	.	.	.	.	vi-1	vi
			
						MaxValue(i,j)
							 |
					------------------
					MV(i-1,j)		MV(i,j-w[i])+val[i]
					
			0/infinity Knapsack
			
			Assumption : Using items [0.....i] & weight limit <=j return Max Value
					
		 */
		
		 int ans6=Solve6(weight,value,50);
		 System.out.println("Unbounded Knapsack Top-Down Max Value :"+ans6);
		 
		
	}
	
	

	private static int Solve6(int[] weight, int[] value, int k) 
	{
		int n=weight.length;
		
		dp=new int[n][k+1];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<=k;j++)
			{
				dp[i][j]=-1;
			}
		}
		
		return MaxValInfinity(n-1,weight,value,k);
	}


	private static int MaxValInfinity(int i, int[] weight, int[] value, int k)// O(N * K) 
	{																		  // O(N * K)
		if(i<0)
		 {
			 return 0;
		 }
		 
		 	if(dp[i][k]!=-1)
		 		return dp[i][k];
		 	
			 int v1=0,v2=0;
			 
			 v1=MaxValInfinity(i-1,weight,value,k);
			 
			 if(k>=weight[i])
			 {
				 v2=MaxValInfinity(i,weight,value,k-weight[i])+value[i];
			 }
			 
			 dp[i][k]=Math.max(v1, v2);
		 
		 
		 return dp[i][k];
		 
	}



	private static int Solve5(int[] weight, int[] value, int k) 
	{
		 int n=weight.length;
		 
		 return MaxSumBottom(weight,value,k);
	}






	private static int MaxSumBottom(int[] weight, int[] value, int k) // T.C = O(N * K) // N = Number of items
	{																  // S.C = O(N * K) // K = Capacity of bag
		
		 int n=weight.length;
		 dp=new int[n][k+1];
		  
		 // We are filling the first row.
		 // If first item fits in bag,
		 // take it and store its value.
		 
		 for(int j=weight[0];j<=k;j++)
		 {
			 dp[0][j]=value[0];
		 }
		 
		 
		 for(int i=1;i<n;i++)
		 {
			 for(int j=0;j<=k;j++)
			 {
				 // Exclude Current item
				 
				 int v1=dp[i-1][j];
				 
				 // Include Current item
				 
				 int v2=0;
				 
				 if(j>=weight[i])
				 {
					 v2=dp[i-1][j-weight[i]]+value[i];
				 }
				 
				 dp[i][j]= Math.max(v1, v2);
			 }
		 }
		 return dp[n-1][k];
	}






	private static int Solve4(int[] weight, int[] value, int k) 
	{
		int n=weight.length;
		
		dp=new int[n][k+1];
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<=k;j++)
			{
				dp[i][j]=-1;
			}
		}
		
		return MaxValTop(n-1,weight,value,k);
	}






	private static int MaxValTop(int i, int[] weight, int[] value, int k) // T.C = O( N * K )
	{																	  // S.C = O( N * K )
		 if(i<0)
		 {
			 return 0;
		 }
		 
		 if(dp[i][k]==-1)
		 {
			 int v1=0,v2=0;
			 
			 v1=MaxValTop(i-1,weight,value,k);
			 
			 if(k>=weight[i])
			 {
				 v2=MaxValTop(i-1,weight,value,k-weight[i])+value[i];
			 }
			 
			 dp[i][k]=Math.max(v1, v2);
		 }
		 
		 return dp[i][k];
	}






	private static int maxValue(int i, int[] weight, int[] value, int j) // T.C = O(2^N)
	{																	 // S.C = O(N)
		 // i = n-1
		 /*
		  * j = Weight
		  *   
		  */
		
		if(i<0)
		{
			return 0;
		}
		
		int v1=0,v2=0;
		
		v1=maxValue(i-1,weight,value,j);
		
		if(j>=weight[i])
		{
			v2=maxValue(i-1,weight,value,j-weight[i])+value[i];
		}
		
		return Math.max(v1, v2);
	}






	private static boolean Solve2(int[] ar, int k) 
	{
		/*
	     * Bottom Up DP Approach
	     * 
	     * Call BottomSum Method
	     */
		
		return BottomSum(ar,k)==1;
	}
	private static int BottomSum(int[] ar, int sum) // T.C = O( N * K)
	{												// S.C = O( N * K)
		
		
		// Create DP table with :
		/*
		 * n rows
		 * 
		 * k+1 columns
		 * 
		 * Why k + 1 Columns?
		 * 
		 * Because target sums start from:
		 * 
		 * 0 -> k (inclusive)
		 * 
		 * k = 10
		 * 
		 * Possible sums are:
		 * 
		 * 0 1 2 3 4 5 6 7 8 9 10
		 * 
		 * Total Values are  k + 1 = 11
		 * 
		 * DP table size becomes: 5 * 11
		 *  
		 */
		
		/*
	     * DP State :
	     * 
	     * dp[i][j]
	     * 
	     * Using elements from [0...i],
	     * can we make Target Sum = j ?
	     * 
	     * 1 -> Possible
	     * 0 -> Not Possible
	     */
		
		// Size of array
		int n=ar.length; 
		
		// Create DP Table
	    // Rows    -> Elements (0 to n-1)
	    // Columns -> Target Sum (0 to k)
		
		dp=new int[n][sum+1];
		
		/*
	     * Base Case-1
	     * 
	     * Sum = 0 is always possible
	     * using Empty Subset {}
	     */
		for(int i=0;i<n;i++)
		{	 
			dp[i][0]=1;
		}
		
		/*
         * Base Case-2
         * 
         * Using first element alone,
         * we can make sum = ar[0]
         */
		
		if(ar[0]<=sum)
		{
			dp[0][ar[0]]=1;
		}
		 /*
         * Traverse remaining elements
         */
		
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<=sum;j++)//Traverse all target sums
			{
				int f1=dp[i-1][j];// Exclude Current Element
				
				int f2=0;
				
				if(j>=ar[i])
				{
					/*
                     * Remaining Sum:
                     * 
                     * j - ar[i]
                     */
					f2=dp[i-1][j-ar[i]];					
				}
				dp[i][j]=f1 | f2;
			}
			
		}
		
		return dp[n-1][sum];
		 
	}
	private static boolean Solve(int[] ar, int k) 
	{
		int n=ar.length;
		dp=new int[n][k+1];
		
		 for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<=k;j++)
		        {
		            dp[i][j] =-1;// Invalid
		        }
		    }
		
		return SumTop(ar,n-1,k)==1;
		
	}

	private static int SumTop(int[] ar, int last, int sum)// T.C = O( N * K) 
	{													  // S.C = O( N * K)
		 if(last<0)
		 {
			 if(sum==0)
			 {
				 return 1;
			 }
			 else
			 {
				 return 0;
			 }
		 }
		 
		 
		 if(dp[last][sum]==-1)
		 {
			 int f1=0,f2=0;
			 
			 f1=SumTop(ar,last-1,sum);//Excluding Current Element
			 
			 if(sum>=ar[last])
			 {
				 f2=SumTop(ar,last-1,sum-ar[last]);
			 }
			 dp[last][sum]=f1 | f2;// 
			 /*
			  * | is Bitwise OR Operator in Java.

				Since f1 and f2 are integers (0 or 1):

				0 → False
				1 → True
			  */
		 }
		 return dp[last][sum];
	}

	// Recursive Code 
	private static boolean SumK(int[] ar, int i, int k) // T.C = O(2^N) // k = Target
	{													// S.C = O(N)
		if(i<0)// i==-1 : No Elements can still achive target : 0 // Items reached to 0, Cannot pick anything.
		{
			return k==0;// return True in This Case
		}
		
		boolean f1=false,f2=false;
		
		f1=SumK(ar,i-1,k);
		
		if(k>=ar[i])
		{
			f2=SumK(ar,i-1,k-ar[i]);
		}
		
		return f1||f2;// It works with boolean values (true / false).
	}

}
