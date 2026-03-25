package BackTracking;

import java.util.ArrayList;

public class Class_42_BackTracking_1 
{

	public static void main(String[] args) 
	{
		 /* Balanced Paranthesis
		  * 
		  * Subset Sum
		  * 
		  * All Permutations
		  *  
		  */
		
		/* Back Tracking : Generating All Solutions using Recursion
		 * -------------
		 * 
		 * 1) All Paths.
		 * 
		 * 2) All Combinations/ All Subsets
		 * 
		 * 
		 * Maze : All Ways to exit Maze.
		 * 
		 * 
		 * Idea : While Generating All Solutions, Choose Path
		 * 
		 * 		  1) If Path Blocked : Come Back
		 * 
		 * 		  2) If Solution Reached : Come Back and Complete Other Paths
		 * 
		 * 		  Follow above steps to reach all solutions in BackTracking.
		 * 
		 * Note : When we are back to starting point.
		 * 
		 * 		  We explore all solutions so, Stop.
		 *  
		 */
		
		/* Q1) Given N, Print all N Pairs Balanced Paranthesis formed only by ()
		 * 
		 * 	   N Pair = N open & N closed.
		 * 
		 * Eg-1 : N=2
		 * 
		 * ( ( ) )
		 * ( ) ( )
		 * 
		 * Eg-2 : N=3
		 * 
		 * ( ) ( ) ( )
		 * ( ( ) ) ( )
		 * ( ( ( ) ) )
		 * ( ( ) ( ) )
		 * ( ) ( ( ) )
		 * 
		 * ( ( ) ( ( : 
		 * 
		 * Obs : CO > N : Invalid
		 * 
		 * ( ) )
		 * 
		 * Obs : At any point CC > CO : Invalid
		 * 
		 * 
		 * Conclusion : Need to Know CC & CO
		 * 
		 * 
		 * 
		 * CO CC --> CO	CC --> Like
		 * 0   0	  1 0
		 * 
		 * 
		 * Observation :
		 * 
		 * If CO < N : We can keep (
		 * 
		 * If CO > CC : We Can keep )
		 * 
		 * 
		 * Parameters : What all Parameters we need to Pass
		 * 
		 * 1) String str  2) int CO  3) int CC  4) int N
		 * 
		 * Subproblems : How Many Choices
		 * 
		 * 1) ( : 1^st
		 * 
		 * 2) ) : 2^nd
		 * 
		 * Return Type : Void
		 *   
		 */
		Solve(3);
		
		/*
		 * Final Intuition (VERY IMPORTANT)

			👉 Think like this:
			
			Total possible strings → 2^(2n) = 4^n
			Valid ones → much fewer
			Reduction factor → about √n
			
			So:
			
			👉
			Valid = 4ⁿ / √n
			
			Total possibilities = 4^n  
			Valid ones = 4^n / √n
			
			“Number of valid parentheses is the Catalan number
				Cₙ = (1/(n+1)) * (2n choose n).
				Using approximation of combinations, it becomes ≈ 4ⁿ / n^(3/2),
				which is simplified as O(4ⁿ / √n).”
				
		    S.C = O(n) recursion stack, O(n²) due to string creation
		    
		    TC = O(Cₙ × n)
		    SC = O(n)
		    
		    // T.C = O(Cn * n) ≈ O(4^n * √n)
            // S.C = O(n)
		 */
		
		/* Back Tracking :
		 * 
		 * <	> func(Parameters)
		 * {
		 * 		if(Solution)
		 * 		{
		 * 			doSomething;
		 * 			return;
		 * 		}
		 * 		
		 * 		choice 1:
		 * 		func();
		 * 
		 * 		choice2:
		 * 		func();
		 * 
		 * 		return;
		 * } 
		 */
		
		/* Note :
		 * ----
		 * 
		 * 1) Primitive Data Types Like int/long/double/float/String when passed as parameters in function, In each function call, they will have individual copy.
		 * 
		 * 2) Arrays/Lists/HashMap/Objects when passed as parameter in function, all function calls will share same copy.
		 * 
		 * 3) In BackTracking => If we make any chnages in those parametrs { Function calls share same copy } after function call is made, undo those changes.
		 *  
		 */
		
		/* Subarray : Continuous part of an Array.
		 * 
		 * 			  Single Element, Complete Array.
		 * 
		 * 
		 * Subsequence : Take any Element in Array
		 * 
		 * 				 Arrange them in increasing order of index;
		 * 
		 * Eg-1:
		 * 
		 * 	Subsequnece = 	{ 2, 9, 10, 8 } --> Subsequence
		 * 
		 * 					{ 7, 6, 9, 8 } --> Subsequence
		 * 					
		 * 					{ 2, 7, 10, 8 } --> Not in Increasing Order of Index
		 * 
		 * Subset : Same as sequence No need to Maintain Order 
		 * 
		 * 			We identify purely based on data it has
		 * 
		 * Eg : ar[] = { 7, 2, 6, 9, 10, 8};
		 * 
		 * Subset :
		 * 
		 * 		  { 2,9,10,8 } - { 8,10,9,2 } - { 8,2,9,10 }
		 * 
		 * Note : Ar { } will be considered as Subset/Subsequence.
		 * 
		 */
		
		/* Q2) Given Array Distinct Elements, return all Subsets using Recursion
		 * 
		 * Eg : ar[3] = { 5, 7, 2 };
		 * 
		 * All Subsets :
		 * 
		 * { }
		 * { 5 }
		 * { 7 }
		 * { 2 }
		 * { 5,7 }
		 * { 5,2 }
		 * { 7,2 }
		 * { 5,7,2 }
		 * 
		 * Note-1 : Store Subset in ArrayList<Integer>
		 * 
		 * Note-2 : If each Subset is ArrayList.
		 * 
		 * 			To Store all of them use ArrayList<ArrayList<>>
		 * 
		 * fun() :
		 * ----
		 * 
		 * Parameters :
		 * 
		 * 1) ArrayList : Subset
		 * 
		 * 2) Given Array[]
		 * 
		 * 3) Current index : i
		 * 
		 * 4) Array size = N
		 * 
		 * 5) choices : 2 add 1^st not add 2^nd
		 * 
		 * 6) Return Type : Void
		 * 
		 */
		System.out.println();
		int ar[]= {5,7,2};
		
		ArrayList<ArrayList<Integer>> arr=solve(ar);
		System.out.println(arr);
		
	}
	static ArrayList<ArrayList<Integer>> ans;
	private static ArrayList<ArrayList<Integer>> solve(int[] ar) 
	{
		 ans=new ArrayList<>();
		 ArrayList<Integer> subset=new ArrayList<>();
		 
		 generateSub(subset,ar,0,ar.length);
		 
		 return ans;
		 
	}

	private static void generateSub(ArrayList<Integer> subset, int[] ar, int i, int n) // Total subsets×work per subset=2n×n = O(2ⁿ × n)
	{																				   // S.C = O(2ⁿ × n)
		if(i==n)
		{
			// Create new ArrayList with Same Data as Subset
			ArrayList<Integer> cp=new ArrayList<>(subset);
			ans.add(cp);
			return;
		}
		
		// Choices 
		
		subset.add(ar[i]);
		
		generateSub(subset,ar,i+1,n);
		
		int s=subset.size();
		
		subset.remove(s-1);// Removing Last Added Element
		
		generateSub(subset,ar,i+1,n);
		return;
	}

	private static void Solve(int N) 
	{
		String s="";
		printAll(s,0,0,N);
	}

	private static void printAll(String s, int CO, int CC, int n)// T.C = O(4ⁿ / √n)
	{															 // S.C = O(N)
		if(CO+CC==2*n)
		{
			System.out.print(s+" ");
			return;// The function still executes extra lines
		}
		
		// Choices 
		
		if(CO<n)
		{
			printAll(s+"(",CO+1,CC,n);
		}
		
		if(CO>CC)
		{
			printAll(s+")",CO,CC+1,n);
		}
		return;// You reach exit and immediately go back ✅
	}

}
