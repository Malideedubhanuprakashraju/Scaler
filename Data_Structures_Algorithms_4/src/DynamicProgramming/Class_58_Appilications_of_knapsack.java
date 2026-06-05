package DynamicProgramming;

import java.util.Arrays;

public class Class_58_Appilications_of_knapsack 
{	
	static int dp[][];
	
	static int dpp[];

	public static void main(String[] args) 
	{
		// Q1) Given a Rod of Length : L & Array Cost[ ]
		/*
		 * 	   Cost which can be obtained by cutting it from Lengths [1....N]
		 * 	
		 * 	   Find the Max Price that can be obtained by cutting the Rod into Some Pieces & Selling Them.
		 * 
		 * 
		 * Eg : L=10,	N=5 :[1.....N]
		 * 
		 * Rods = 	1	2	3	4	5
		 * 
		 * Cost[] = 1	2	4	5	6
		 * --------------------------
		 * index :	0	1	2	3	4
		 * 
		 * Cases :			Cost			Amount : Ans = 13
		 * 
		 * 5 + 5 			6 + 6			  12
		 * 
		 * 3 + 3 + 4		4 + 4 + 5		  13
		 * 
		 * 3 + 3 + 3 + 1	4 + 4 + 4 + 1	  13
		 * 
		 * 
		 * 
		 * Tracing :		---> [1....N]
		 * -------			|
		 * 					N : 5  =	1	2	3	4	5
		 * L = 10			Cost[] = 	1	2	4	5	6
		 * 
		 * 
		 * 					  N	  Len
		 * 					( 5 , 10 )
		 * 						|
		 * 				------------------
		 * 				|				  |
		 * 			(4 , 10)			(5 , 5) + 6
		 * 			--------			-----------
		 * 			|	   |			|		   |
		 * 		(3 , 10)  (4 , 6)+5	  (4 , 5)	( 5 , 0 )
		 * 
		 * 		
		 * Note :
		 * ----
		 * 
		 * ( 0 , infinite ) : Knapsack
		 * 
		 * Total Weight	------------->	Total Length
		 * 
		 * Item Weight	------------->	Cut's Length
		 * 
		 * Item Value	------------->	Cut's Value
		 * 
		 * Same Item Pick Multiple Times -> Same Rod Cut Multiple Times
		 * 
		 *  | Variable | Remember As           |
			| -------- | --------------------- |
			| `l`      | Length left           |
			| `n`      | Number of cut options |

		 *  Visual Understanding
		 *  
		 *  Rod Length (l) = 10
			--------------------
			
			Available Cut Sizes:
			
			1 2 3 4 5
			        ↑
			        n=5
		 *  | Variable | Meaning                       |
			| -------- | ----------------------------- |
			| `l`      | Total Rod Length              |
			| `n`      | Number of available cut sizes |
			
			
			Each state has 2 choices:
			
			Take
			Don't Take
			

		 */
		
		// Case - 1 : Recursive Code
		
		System.out.println("Rod Cutting using Recursive Approach");
		
		int l=10;
		
		int n=5;// [1....N]
		
		int cost[]= {1, 2, 4, 5, 6};
		
		int ans1=MaxPriceRec(l,n,cost);
		System.out.println("Max Cutting Rod ---> Recusive Code : "+ans1);
		
		
		// Case - 2 : Dp Top Down Approach 
		
		System.out.println();
		
		System.out.println("Rod Cutting Using Top Down DP");
		
		int ans2 = solve2(l,n,cost);
		System.out.println("Max Rod Cutting ---> Top Down : "+ans2);
		
		/* Top Down Approach
		 * 
		 * DP Table : 2D 				   ---> Cuts [1...i] , j : Total Length
		 * 								   |
		 * DP State : dp[i][j] = MaxProfit(i,j) : Max Profit Obtained using [1...i] cuts & Len =j.
		 * 
		 * 			  dp[n][l] = MaxProfit(N,L) : Max Profit Obtained using [1...N] cuts & Len =L.
		 * 
		 * DP Size = dp[N+1][L+1]
		 * 
		 * Dp Initialization = -1; // Invalid
		 * 
		 */
		
		System.out.println();
		System.out.println("Rod Cutting Using Bottom Up Dp");
		
		/* Bottom Up Approach
		 * 
		 * DP State : dp[i][j] = Using Rod Till Length i Create Rod of Len = j
		 * 
		 * 			  dp[N][L] = Using Rod Till Length N Create Rod of Len = l
		 * 
		 * DP Table :
		 * 
		 * 			  dp[N+1][L+1]
		 * 
		 * DP Expression : Get Value of dp[i][j]
		 * 
		 * 
		 * dp[i][j] =	1	2	3	.	.	.	i-1	.	i
		 * 
		 * 				c0	c1	c2	.	.	.	ci-1	ci
		 * 						
		 * 												 |
		 * 										------------------
		 * 										|				 |
		 * 					dp[i][j] = Max	{ dp[i-1][j]		dp[i][j-i]+c[i-1] }
		 * 
		 * 														if(j >= i)
		 * Edge Cases :
		 * -----------
		 * 
		 * 		dp[0][j] = 0, Using Rod Till Length 0, Created Rod Length J :
		 * 
		 * 		dp[i][0] = 0, Using Rod Till Length i, Created Rod Length 0 :
		 * 
		 * 
		 * 
		 */
		
		int ans3=solve3(l,n,cost);
		System.out.println("Max Price using Bottom Up : "+ans3);
		
		/* We can reduce the Bottom-Up DP space from :
		 * 
		 * O(N*L)
		 * 
		 * to:
		 * 
		 * O(L)
		 * 
		 * using 1D DP Array.
		 * 
		 * Why Space Optimization Works
		 * 
		 * Current recurrence:
		 * 
		 * dp[i][j]=max(dp[i−1][j], dp[i][j−i]+cost[i−1])
		 * 
		 * Notice carefully:
		 * 
		 * Suppose We Calculate:

			dp[3][5]
			
			Meaning:
			
			Using cuts [1,2,3]
			to make rod length 5
			
			
			Two Choices:
			
			1) Don't Take Cut Length 3
			
			dp[2][5]
			
			Meaning:
			Use only cuts:
			1 and 2
			
			
			2) Take Cut Length 3
			
			Take one cut of length 3.
			
			Remaining rod length:
			
			5 - 3 = 2
			
			Now solve:
			
			dp[3][2]
			
			Why dp[3][2] and not dp[2][2]?
			
			Because:
			Cut length 3 can be reused multiple times.
			This is Unbounded Knapsack.
			
			Then add value of cut length 3:
			
			cost[2] = 4
			
			
			So:
			
			dp[3][5] = max(dp[2][5], dp[3][2] + 4)
			
			
			Important Observation:
			
			To compute dp[3][5], we need:
			
			1) dp[2][5]  → Previous Row
			2) dp[3][2]  → Same Row Left Side
			
			
			Visual Table:
			
			| i/j | 0 | 1 | 2 | 3 | 4 | 5 |
			|-----|---|---|---|---|---|---|
			| 0   | 0 | 0 | 0 | 0 | 0 | 0 |
			| 1   | 0 | 1 | 2 | 3 | 4 | 5 |
			| 2   | 0 | 1 | 2 | 3 | 4 | 5 |
			| 3   | 0 | 1 | 2 | 4 | 5 | ? |
			
			We are calculating:
			
			dp[3][5]
			
			For this we need:
			
			dp[3][2]
			
			Notice:
			dp[3][2] is already computed earlier in SAME row.
			
			Because we move from LEFT → RIGHT:
			
			j = 0 → 1 → 2 → 3 → 4 → 5
			
			smaller values are already available.
			
			
			Therefore:
			
			We do not need full 2D DP table.
			
			We can store only one row using 1D DP.
			
			
			1D DP:
			
			Instead of:
			
			dp[i][j]
			
			we use:
			
			dp[j]
			
			
			Transition:
			
			dp[j] = max(dp[j], dp[j-i] + cost[i-1])
			
			
			Why does this work?
			
			Because:
			
			dp[j-i]
			
			already contains the current row value computed earlier.
			
			
			Main Idea:
			
			In Rod Cutting / Unbounded Knapsack:
			
			dp[i][j] depends on SAME ROW previous values.
			
			Therefore:
			1D DP optimization is possible.

			Space Complexity reduces from:
			
			O(N × L)
			
			to:
			
			O(L)
		 * 
		 */
		
		int ans3a = MaxPriceBottomOptimized(n, l, cost);
		
		System.out.println("Maximum Profit : " + ans3a);
		
		/*
		 * ```text
			Example:
			
			Rod Length = 5
			
			cost[] = {1, 2, 4}
			
			Meaning:
			
			Length 1 → Profit 1
			Length 2 → Profit 2
			Length 3 → Profit 4
			
			
			So:
			
			n = 3
			l = 5
			
			
			DP Array Meaning:
			
			dp[j]
			
			means:
			
			Maximum profit for rod length j
			
			
			Initially:
			
			dp = [0,0,0,0,0,0]
			       0 1 2 3 4 5
			
			
			--------------------------------------------------
			STEP 1 → i = 1
			--------------------------------------------------
			
			Meaning:
			
			Current cut length = 1
			Profit = cost[0] = 1
			
			
			Loop:
			
			for(j = 1; j <= 5; j++)
			
			
			j = 1
			
			dp[1] = max(dp[1],
			            dp[1-1] + 1)
			
			      = max(0,
			            dp[0] + 1)
			
			      = max(0,1)
			      = 1
			
			
			DP:
			
			[0,1,0,0,0,0]
			
			
			--------------------------------------------------
			
			j = 2
			
			dp[2] = max(0,
			            dp[1] + 1)
			
			      = max(0,2)
			      = 2
			
			
			DP:
			
			[0,1,2,0,0,0]
			
			
			--------------------------------------------------
			
			j = 3
			
			dp[3] = max(0,
			            dp[2] + 1)
			
			      = 3
			
			
			DP:
			
			[0,1,2,3,0,0]
			
			
			--------------------------------------------------
			
			j = 4
			
			dp[4] = dp[3] + 1
			      = 4
			
			
			DP:
			
			[0,1,2,3,4,0]
			
			
			--------------------------------------------------
			
			j = 5
			
			dp[5] = dp[4] + 1
			      = 5
			
			
			DP:
			
			[0,1,2,3,4,5]
			
			
			==================================================
			STEP 2 → i = 2
			==================================================
			
			Meaning:
			
			Current cut length = 2
			Profit = cost[1] = 2
			
			
			Loop:
			
			for(j = 2; j <= 5; j++)
			
			
			--------------------------------------------------
			
			j = 2
			
			dp[2] = max(dp[2],
			            dp[0] + 2)
			
			      = max(2,2)
			      = 2
			
			
			No change.
			
			
			--------------------------------------------------
			
			j = 3
			
			dp[3] = max(3,
			            dp[1] + 2)
			
			      = max(3,3)
			      = 3
			
			
			No change.
			
			
			--------------------------------------------------
			
			j = 4
			
			dp[4] = max(4,
			            dp[2] + 2)
			
			      = max(4,4)
			      = 4
			
			
			--------------------------------------------------
			
			j = 5
			
			dp[5] = max(5,
			            dp[3] + 2)
			
			      = max(5,5)
			      = 5
			
			
			DP remains:
			
			[0,1,2,3,4,5]
			
			
			==================================================
			STEP 3 → i = 3
			==================================================
			
			Meaning:
			
			Current cut length = 3
			Profit = cost[2] = 4
			
			
			Loop:
			
			for(j = 3; j <= 5; j++)
			
			
			--------------------------------------------------
			
			j = 3
			
			dp[3] = max(3,
			            dp[0] + 4)
			
			      = 4
			
			
			DP:
			
			[0,1,2,4,4,5]
			
			
			--------------------------------------------------
			
			j = 4
			
			dp[4] = max(4,
			            dp[1] + 4)
			
			      = max(4,5)
			      = 5
			
			
			DP:
			
			[0,1,2,4,5,5]
			
			
			--------------------------------------------------
			
			j = 5
			
			dp[5] = max(5,
			            dp[2] + 4)
			
			      = max(5,6)
			      = 6
			
			
			DP:
			
			[0,1,2,4,5,6]
			
			
			==================================================
			FINAL ANSWER
			==================================================
			
			dp[5] = 6
			
			
			Maximum profit = 6
			
			
			Using:
			
			3 + 2
			
			Profit:
			
			4 + 2 = 6
			
			
			==================================================
			MOST IMPORTANT UNDERSTANDING
			==================================================
			
			Look carefully at:
			
			dp[j-i]
			
			
			Example:
			
			dp[5] = dp[2] + 4
			
			
			Here:
			
			dp[2]
			
			was already computed earlier.
			
			
			Therefore:
			
			same array can be reused.
			
			
			No need for full 2D DP table.
			
			
			That is why:
			
			Space Complexity reduces from:
			
			O(N × L)
			
			to:
			
			O(L)
			```
			
			Final DP Table :
			
			| i/j | 0 | 1 | 2 | 3 | 4 | 5 |
			| --- | - | - | - | - | - | - |
			| 0   | 0 | 0 | 0 | 0 | 0 | 0 |
			| 1   | 0 | 1 | 2 | 3 | 4 | 5 |
			| 2   | 0 | 1 | 2 | 3 | 4 | 5 |
			| 3   | 0 | 1 | 2 | 4 | 5 | 6 |

			Ans = dp[3][5] = 6
	
		 */
		
		// Q2) Given an Integr A[] representing Coins.
		/*
		 * 	   A[i] = Value of i^th Coin
		 * 
		 * 	   One Coin can be used Multiple Times
		 * 
		 * 	   Find no:of ways to select Coins with Sum = N.
		 * 
		 * 	   Ordered Selection = ( X , Y ) != ( Y , X )
		 * 	   |
		 * 	   ----> Matters : 	   ( 2 , 3 ) != ( 3 , 2 )
		 * 
		 * 	   Eg : N = 5
		 * 
		 * 	   A[3] = { 3 , 1 , 4 };
		 * 
		 * 	   Ans = { 1 , 1 , 3 } , { 1 , 3 , 1 } , { 3 , 1 , 1 }, { 1 , 4 } , { 4 , 1 } , { 1 , 1 , 1 , 1 }
		 * 
		 * 	 Q) Ways to get Sum = 0 ; // By Picking any coins Sum = 0 Possible.
		 * 
		 * 	   Eg : N = 4
		 * 
		 * 	   A[ ] = { 1 , 2 };
		 * 
		 * 						W(4) -> 5
		 * 				-----------------
		 * 				| +3			| +2
		 * 			  W(3)			   W(2)
		 * 		--------------	  ---------------
		 * 		|			 |	  |			+1	|	+1
		 * --------		 --------------		-------------
		 * |	  |		 |			  |		| +1		| +1
		 * 								  W(1)		  W(0)	
		 *  
		 */
		System.out.println();
		
		System.out.println("Select Coins Using Recursive Code ");
		
		int A[]= {3,1,4};
		
		int ans4=CoinsRecursive(A.length-1,A,4);
		System.out.println("Coins Recursive Code : "+ans4);
		
		// Coin Change Combination Count
		
		// Unordered Selection
		
		// (X , Y) == (Y , X)
		
		// 1 + 1 + 1 + 1
		// 1 + 1 + 2
		// 2 + 2
		
		
		//	Coin Change Permutation Count
		//	Ordered Selection
		//	Order Matters
		
		System.out.println();
		System.out.println("Coin Change Permutation Count\r\n"+ "Ordered Selection\r\n"+ "Order Matters");
		
		
		int ans5=CoinsRecursiveOrder(A.length-1,A,4);
		System.out.println("Coin Recursive Code Using Ordered Selection : "+ans5);
		
		System.out.println();
		System.out.println("Coins Change using DP - Top Down Approach ");
		
		int N=10;
		int a[]= {2,4,6};
		int ans6=Solve6(N,a);
		
		/* DP Code :
		 * 
		 * DP Table : 1D
		 * 
		 * DP State : dp[i] = W(i) = Ways to Reach Amount i, Using Given Coins.
		 * 
		 * 			  dp[N] = W(N) = Ways to Reach Amount N, Using Given Coins.
		 * 
		 * DP Size : dp[N+1];
		 * 
		 * DP Initialization = -1;
		 * 
		 * DP Code
		 * 
		 */
		System.out.println("Coins Change using DP - Top Down Approach Ans : "+ans6);
		
		System.out.println();
		
		System.out.println("Coins Change using DP - Bottom Up Approach");
		
		int ans7 = CoinsBottomUp(N, a);

		System.out.println("Coin Change Bottom Up Answer : " + ans7);
		
		System.out.println();
		
		System.out.println("Unordered Selection of Coins + Unbounded ");
		
		/* Given N Coins & Value for Each
		 * 
		 * One Coin can be used Multiple Times
		 * 
		 * Find no:of Ways to Select Coins with Sum = S.
		 * 
		 * Ordered Selection = ( X , Y ) = ( Y , X )
		 * 	  |
		 * 	  -----> Not Matters
		 * 
		 * Eg : S=6
		 * 
		 * 		A[3] = { 3 , 1 , 4 };
		 * 
		 * Ways : { 3 , 3 } { 3 , 1 , 1, 1 } { 1 , 3 , 1 , 1 } { 4 , 1 , 1 } { 1 , 1 , 1 , 1 , 1 , 1 } { 1 , 4 , 1 }
		 * 
		 * Note 1 : Can use a Coin Multiple Times
		 * 
		 * Note 2 : Avoid Repetitions
		 * 
		 * Observation : Once we made decision at an Element , don't come Back
		 * 
		 * Similar : Stair + Unbounded (In Dynamic Programming / Knapsack: One item can be used MULTIPLE TIMES - There is NO limit. )
		 * 
		 * Unbounded = Number of usages is NOT bounded(No restriction).
		 * 
		 * DP :
		 * ---
		 * 
		 * DP State : dp[i][j] = W(i,j) = Using Coins [0...i] Ways to get sum = j
		 * 
		 * 			  dp[N-1][S] = W(N-1, S) = Using Coins [0...N-1] Ways to get sum = s
		 * 
		 * DP Size = dp[N][S+1]
		 * 
		 * DP Initialization = -1;
		 * 
		 * 
		 */
		
		/*
		 *  | Concept       | Meaning                                                |
			| ------------- | ------------------------------------------------------ |
			| **Bounded**   | You can use an item only limited times (usually once). |
			| **Unbounded** | You can use an item unlimited times.                   |
			| **Ordered**   | Different orders are counted separately.               |
			| **Unordered** | Different orders are treated as same.                  |

		 */
		int sum=6;
		int Aa[]= {3,1,4};
		
		int ans8=Solve8(Aa.length-1,Aa,sum);
		System.out.println("Un-Ordered Selection Coin --> DP Top Down : "+ans8);
		
		System.out.println();
		int ans9=Solve9(Aa,sum);
		System.out.println("Un-Ordered Selection Coin --> DP Bottom Up : "+ans9);
		
		/* DP : 2D
		 * ---
		 * 
		 * DP State : dp[i][j] = Using i-Coins find ways to get Sum J
		 * 
		 * 			  dp[N][S] = Using N-Coins find ways ti get Sum S
		 * 
		 * DP Table = dp[N+1][S+1];
		 * 
		 * 					  ------> Using Coins [1....i] Ways to get Sum j :
		 * 					  |
		 * DP Expression = dp[i][j] = 1	 2	3	.	.	.	i-1	 i^th Coin
		 * 				
		 * 					Coins 	= v0 v1	v2	.	.	.	vi-1
		 * 
		 * 											dp[i][j] = (dp[i-1][j] + dp[i][j-v[i-1]);
		 *  
		 * Edge Case :
		 * 
		 * dp[0][j] = 0 // Using 0 Coins ways to get Sum = j
		 * 
		 * dp[i][0] = 1 // Using i Coins ways to get Sum = 0
		 * 
		 * Note : dp[0][0] = 1
		 * 
		 */
		
		// Q) Given N-items with Their Value & Weight
		/*
		 * 	  Find The Maximum Total Value Such That Total Weight <= K
		 * 		
		 * 	  Pick each item Once.
		 * 
		 * 	Idea-1 :
		 *  -------
		 *  
		 *  0/1 Knapsack dp
		 *  
		 *  
		 *  Eg : N = 5
		 *  
		 *  	 K = 8
		 *  
		 *  	 W[] :	3	6	5	2	4
		 *  
		 *  	 V[] :  12	20	15	6	10
		 *  
		 *  Ans = 27
		 *  
		 *  	 1		3
		 *  
		 *  	 3		5
		 *  
		 *  	 12		15
		 *  
		 *  
		 *  0 / 1 : Knapsack
		 *  
		 *  Way-1 : dp[i][j] = Using items [0....i] & Weight Limit <=j Max Value Obtained
		 *  
		 *  
		 *  Way-2 : dp[i][j] = Min Weight needed to get Value = j using items [0...i]
		 *  
		 *  
		 *  DP
		 *  
		 *  1) DP Table : 2D
		 *  
		 *  2) DP State : 
		 *  
		 *     Dp[i][j] = Min Weight needed ? to get = J Using Item [0...i]
		 *     
		 *     Dp[N-1][s] = Min Weight needed ? to get = S : Using Items [0...N-1]
		 *     											 |
		 *     											 ----> Sum of All Item Values.
		 *     
		 *  3) Dp Size : dp[N][s+1] & Initialize = Infinity;
		 *  
		 *  4) Dp Expression :
		 *  
		 *     Dp[i][j] = Min Weight needed ? to get = J using item [0...i]
		 *     
		 *     Value[] :	V0	V1	V2	.	.	.	.Vi-1	Vi
		 *     
		 *     Weigh[] :	w0	w1	w2	.	.	.	.wi-1	wi
		 *     
		 *     
		 *     Dp[i][j] =	Math.min( dp[i-1][j]	dp[i-1][j-v[i]] + W[i]
		 *     
		 * 	
		 * 	   Edge Case : 
		 * 
		 * 	   Dp[0][j] = Math.min( dp[-1][j]   ,	dp[-1][j-v[i]+w[i])
		 * 								|
		 * 								|
		 * 								Using No Items Minimum Weight Req to get value j : Not Possible
		 * 
		 * 	   Handle : i==0 :	dp[0][0] = 0;
		 * 
		 * 
		 * 	   					
		 * package DynamicProgramming;

			import java.util.Arrays;
			
			public class Knapsack_Value_Based_DP
			{
			    public static void main(String[] args)
			    {
			        int weights[] = {3, 6, 5, 2, 4};
			        int values[]  = {12, 20, 15, 6, 10};
			
			        int K = 8;
			        int N = weights.length;
			
			        int totalValue = 0;
			
			        for(int v : values)
			            totalValue += v;
			
			        int INF = (int)1e9;
			
			        int dp[][] = new int[N][totalValue + 1];
			
			        // Initialize with INF
			        for(int i = 0; i < N; i++)
			            Arrays.fill(dp[i], INF);
			
			        // Base Cases
			        dp[0][0] = 0;
			
			        dp[0][values[0]] = weights[0];
			
			        // DP Filling
			        for(int i = 1; i < N; i++)
			        {
			            for(int value = 0; value <= totalValue; value++)
			            {
			                // Not Pick
			                dp[i][value] = dp[i - 1][value];
			
			                // Pick
			                if(value >= values[i] &&
			                   dp[i - 1][value - values[i]] != INF)
			                {
			                    dp[i][value] = Math.min(
			                            dp[i][value],
			                            dp[i - 1][value - values[i]] + weights[i]
			                    );
			                }
			            }
			        }
			
			        // Find Maximum Value within weight K
			        int ans = 0;
			
			        for(int value = 0; value <= totalValue; value++)
			        {
			            if(dp[N - 1][value] <= K)
			                ans = value;
			        }
			
			        System.out.println("Maximum Value = " + ans);
			    }
			}
		 *  
		 */
		
		
		
	}
	
	
	
	private static int Solve9(int[] coins, int sum) 
	{
		return waysUnorderedMultipleB(coins,sum);
	}



	private static int waysUnorderedMultipleB(int[] coins, int sum) // T.C = O(N*S)
	{																// S.C = O(N*S)
		int n=coins.length;
		
		int dp[][]=new int[n+1][sum+1];
		
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=sum;j++)
			{
				if(j==0)
				{
					dp[i][j]=1;
				}
				else if(i==0)
				{
					dp[i][j]=0;
				}
				else
				{
					int c=dp[i-1][j];
					
					if(j>=coins[i-1])
					{
						c=c+dp[i][j-coins[i-1]];
					}
					dp[i][j]=c;
				}
			}
		}
		return dp[n][sum];
	}



	private static int Solve8(int N, int[] aa, int sum) 
	{
		// N = number of coins
		// S = target sum
		 		
		dp = new int[N+1][sum + 1];

		for(int i = 0; i <= N; i++)
		{
		    Arrays.fill(dp[i], -1);
		}
		
		return waysUnorderedMultipleT(N,aa,sum);
	}



	private static int waysUnorderedMultipleT(int n, int[] aa, int sum) // T.C = O(N × S)
	{																	// S.C = O(N × S)
		 if(sum==0)
		 {
			 return 1;
		 }
		 
		 if(n==-1)
		 {
			 return 0;
		 }
		 
		 if(dp[n][sum]==-1)
		 {
			 int c1=0,c2=0;
			 
			 c1=waysUnorderedMultipleT(n-1,aa,sum);
			 
			 if(sum>=aa[n])
			 {
				 c2=waysUnorderedMultipleT(n,aa,sum-aa[n]);
			 }
			 
			 dp[n][sum]=c1+c2;
		 }
		 
		 return dp[n][sum];
	}



	private static int CoinsBottomUp(int n, int[] a) // T.C = O(N × C)
	{												 // S.C = O(N)											
		
		 // N = Sum
		 // a[] = Assueme Total Coins
		
		 // dpp[i] = Number of Ordered Ways to form Amount i
		 // dpp[N] = Number of Ordered Ways to form Amount N
		
		/* Amount వరకు ప్రతి subproblem answer store చేయడానికి
		   dp array size = amount + 1 తీసుకుంటాం.
		 */
		// Base Case:
	    // One way to form amount 0
	    // Pick nothing
		
		int dp[]=new int[n+1];
		
		dp[0]=1;// If we dont Select That is also possible case right
		
		// Current Amount
		
		for(int i=1;i<=n;i++)
		{
			// Get Dp[i] ? : Ways to get Sum i
			
			int ans=0;
			
			// Try every coin
			
			for(int j=0;j<a.length;j++)
			{
				if(i>=a[j])
				{
					ans=ans+dp[i-a[j]];
				}
			}
			dp[i]=ans;
			
		}
		return dp[n];
			 
	}



	private static int Solve6(int n, int[] a) 
	{
		 dpp=new int[n+1];
		 
		 // Arrays.fill(dpp,-1);
		 for(int i=0;i<=n;i++)
		 {
			 dpp[i]=-1;
		 }
		 
		 return CoinsTopD(n,a);
		 
	}



	private static int CoinsTopD(int i, int[] a) // T.C = O( N * C)
	{											 // S.C = O(N)
		 if(i==0)// i=sum=10 // a[] is Coins Array
		 {
			 return 1;
		 }
		 
		 if(dpp[i]==-1)// Number of ordered ways to form amount i.
		 {
			 int sum=0;
			 
			 for(int j=0;j<a.length;j++)
			 {
				 if(i>=a[j])
				 {
					 sum=sum+CoinsTopD(i-a[j],a);
				 }
			 }
			 dpp[i]=sum;
		 }
		 return dpp[i];
	}



	// Coin Change Permutation Recursive Code
	// (Ordered Selection)
	
	private static int CoinsRecursiveOrder(int n, int[] a, int sum) // T.C = O(N^Sum)
	{																// S.C = O(Sum)
		// Exact Sum Formed
		 if(sum==0)
		 {
			 return 1;
		 }
		 
		// Invalid Case 
		 if(sum<0)
		 {
			 return 0;
		 }
		 
		int ways =0;
		
		for(int i=0;i<a.length;i++)
		{
			ways = ways + CoinsRecursiveOrder(n,a,sum-a[i]);
		}
		
		return ways;
	}




	// Coin Change Combination Count Recursive Code
	// (Unordered Selection)
	
	
	private static int CoinsRecursive(int i, int[] a, int sum) // T.C = O(2^(N + Sum))
	{														   // S.C = O(Sum + N)
		 if(sum==0)
		 {
			 return 1;
		 }
		 
		 if(sum<0)
		 {
			 return 0;
		 }
		 
		 if(i<0)
		 {
			 return 0;
		 }
		 int v1=0,v2=0;
		 
		 v1=CoinsRecursive(i-1,a,sum);
		 
		 if(sum>=a[i])
		 {
			 v2=CoinsRecursive(i,a,sum-a[i]);
		 }
		 
		 return v1+v2;
	}

	private static int MaxPriceBottomOptimized(int n, int l, int[] cost) // T.C = O(N × L)
	{ 																	 // S.C = O(L)
		// 1D DP Array
		
		// dp[j] = Maximum profit for Rod Length J
		
		int dp[]=new int[l+1];
		
		// i = Current Cut Length
		
		for(int i=1;i<=n;i++)
		{
			// J = Current Rod Length
			
			// Start from I because
			
			// Cut Length I  Cannot fit into Rod Smaller Than I
			
			for(int j=i;j<=l;j++)
			{
				dp[j]=Math.max(dp[j],dp[j-i]+cost[i-1]);
			}
		}
		return dp[l];
	}

	private static int solve3(int l, int n, int[] cost) 
	{
		return MaxPriceBottom(n,l,cost);
	}

	private static int MaxPriceBottom(int n, int l, int[] cost) // T.C = O( N * L )
	{															// S.C = O( N * L )
		
		// n is cost.length;// Cost for all Rod Length from 1...N
		
		int dp[][]=new int[n+1][l+1];
		
//		if(dp[0][l]==0)
//		{
//			return 0;
//		}
//		
//		if(dp[n][0]==0)
//		{
//			return 0;
//		}
				
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=l;j++)
			{
				if(i==0 || j==0)
				{
					dp[i][j]=0;
				}
				else
				{
					int ans=dp[i-1][j];
					
					if(j>=i)
					{
						ans=Math.max(ans,dp[i][j-i]+cost[i-1]);
					}
					dp[i][j]=ans;
				}
			}
		}
		return dp[n][l];
		
	}

	private static int solve2(int l, int n, int[] cost) 
	{
		 // Length actually starts from 1, but DP includes 0 index to handle the base case (remaining rod length = 0).
		 // `n` starts from 1, but DP includes `n=0` to represent “no cut sizes available” (base case).
		 dp=new int[n+1][l+1];
		 for(int i=0; i<=n; i++)
		 {
		 	for(int j=0; j<=l; j++)
		 	{
		 		dp[i][j] = -1;
		 	}
		 }
		 
		 return MaxPriceTop(n,l,cost);
	}

	private static int MaxPriceTop(int n, int l, int[] cost) // T.C = O( N * L)
	{														 // S.C = O(N × L) + O(L)
		 if(l==0)// No Rod Length
		 {
			 return 0;
		 }
		 
		 if(n==0)// No cut's can be made, because min len cut == 1
		 {
			 return 0;
		 }
		 
		 if(dp[n][l]==-1)
		 {
			 int v1=0,v2=0;
			 
			 v1=MaxPriceTop(n-1,l,cost);
			 
			 if(l>=n)
			 {
				 v2=MaxPriceTop(n,l-n,cost)+cost[n-1];
			 }
			 dp[n][l]=Math.max(v1, v2);
		 }
		 
		 return dp[n][l];
		 
		 /*
		  * | Part       | Meaning                        |
			| ---------- | ------------------------------ |
			| `n`        | How many cut options available |
			| `l`        | Remaining rod length           |
			| `dp[n][l]` | Best profit for that situation |
			
			Visualization :
			
			| State     | Meaning                |
			| --------- | ---------------------- |
			| dp[0][10] | No cut sizes available |
			| dp[1][10] | Only size 1 available  |
			| dp[2][10] | Sizes 1,2 available    |
			| dp[5][10] | Sizes 1 to 5 available |


		  */
	}

	private static int MaxPriceRec(int l, int n, int[] cost) // T.C = O(2^N+L)
	{														 // S.C = O(L)
		 // Rod fully cut
		 if(l==0)
		 {
			 return 0;
		 }
		 
		 // No sizes left
		 if(n==0)
		 {
			 return 0;
		 }
		 
		 int v1=0,v2=0;
		 
		 v1=MaxPriceRec(l,n-1,cost);
		 
		 if(l>=n)
		 {
			 v2=MaxPriceRec(l-n,n,cost)+cost[n-1];
		 }
		 
		 return Math.max(v1, v2);
	}

}
