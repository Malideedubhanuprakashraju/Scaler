package BackTracking;

import java.util.ArrayList;

public class Class_43_BackTracking_2 
{

	public static void main(String[] args) 
	{ 
		/* BackTracking :
		 * ------------
		 * 
		 * When BackTracking ? : All Possiblities / All Solutions / All Paths
		 * 
		 * BackTrack ? : 1) Reach Solution 2) Dead End
		 * 
		 * 3-Steps ? : 1) Parameters 2) Choices 3) Return Type
		 *   
		 */
		
		/* Q1) Print All Ways to Reach N^th Step.
		 * 
		 * 	   We Start at 0^th Step.
		 * 
		 * 	   From i^th Step we either reach (i+1)^th Step or (i+2)^nd Step.
		 * 
		 * Eg-1 : N = 2	=> 1	1
		 * 				   2
		 * 
		 * Eg-2 : N = 3 => 1	1	1
		 * 				   1	2
		 * 				   2	1
		 * 
		 * Steps :
		 * 
		 * Parameters : int i : Current Step
		 * 
		 * int N : Destination
		 * 
		 * ArrayList<Integer> li;
		 * 
		 * Choices : 2-Choices
		 * 
		 * Return Type : Void
		 *   
		 */
		
		Solve(4);
		
		// 👉 Total number of recursive calls ≈ O(2ⁿ)
		
		/* Q2) Given Dimensions of a Rectangular Board of Size : A*B
		 * 
		 * 	   Print All Paths from Top-Left to Bottom Right Corner
		 * 
		 * Note : From a Cell we can only go Down : D & Right : R
		 * 
		 * Eg-1: A=3 B=2
		 * 
		 * 	 0	1
		 * 0 S	.
		 * 1 .	.
		 * 2 .	E
		 * 
		 * Possible Paths : Start : (0,0) , End : (2,1)
		 * 
		 * 1) D	D R
		 * 2) R D D } Each Path is a String.
		 * 3) D R D
		 * 
		 * Eg-1: A=3 B=2 : Start : (0,0) End : (2,1)
		 * 
		 * Ingeneral : Start : (0,0) End : (A-1,B-1)
		 * 
		 * Parameters : int r, int c, String path, int A, int B
		 * 										   Dest : (A-1,B-1)
		 * Choices : 2
		 * 
		 * Return Type : Void
		 *    
		 */
		System.out.println();
		Solve1(3,2);
		
		/* Count of Subsequence / Subset
		 * 
		 * Arrya[N] = { A0,	A1,	A2,			An-1 };
		 * 
		 * Sub =	   |  | | | | |			|	|
		 * 			  {2ch*2ch*2ch*............2ch} = 2^N Subsequence / Subset
		 * 
		 */
		
		/* Q3) Count no:of Subsequence with Sum == Target
		 * 							 |
		 * 	   Ar[3] = { 3, 0, 3 };	 --------> Any Element : Order of index Matters
		 * 
		 * 	   K=3;
		 * 
		 *  Subsequence : { 3, 0 },{ 0, 3 }, { 3 }, { 3 }
		 *  
		 *  
		 *  Idea-1 : Generate All Subsequence Sum & Compare == Target & Increment Count.
		 *  
		 *  
		 *  Parameters : int i : index, int s : sum, int t : target, int[] ar, int N
		 *  
		 *  Choices : 2 Choices
		 *  
		 *  Return Type : int
		 *  
		 */
		
		int ar[]= {3,0,3};
		
		int ans=Solve2(ar,3);
		
		System.out.println("No : of Subsequence : "+ans);
		
		// Whenever “All possibilities / subsets / paths” → TC = O(2ⁿ)
		// Whenever grid paths → Combinatorics (nCr)
		// Whenever include/exclude → 2ⁿ pattern
	}

	private static int Solve2(int[] ar, int k) 
	{
		int ans=SubSum(0,0,k,ar,ar.length);
		return ans;
	}

	private static int SubSum(int i, int s, int t, int[] ar, int length) // T.C = O(2ⁿ)
	{																	 // S.C = O(n)
		if(i==length)
		{
			if(s==t)
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
		
		// Choices 
		
		int cl=SubSum(i+1,s+ar[i],t,ar,length);
		int cr=SubSum(i+1,s,t,ar,length);
		
		return cl+cr;
	}

	private static void Solve1(int A, int B) 
	{ 
		String path="";
		PrintPaths(0,0,path,A,B);
	}

	private static void PrintPaths(int r, int c, String path, int a, int b) // T.C = O(C(A+B, A)) ≈ O(2^(A+B)) 
	{																		// S.C = O(A+B)
		 if(r==a-1 && c==b-1)
		 {
			 System.out.println(path);
			 return;
		 }
		 
		 if(r+1<a)
		 {
			 PrintPaths(r+1,c,path+"D ",a,b);// 1) Go Down
		 }
		 
		 if(c+1<b)
		 {
			 PrintPaths(r,c+1,path+"R ",a,b);// 2) Go Right
		 }
		 return;
	}

	private static void Solve(int n) 
	{
		ArrayList<Integer> li = new ArrayList<>();
		
		AllPaths(0,n,li);
	}

	private static void AllPaths(int i, int n, ArrayList<Integer> li) // T.C = O(2ⁿ)
	{																  // S.C = O(N)
		if(i==n)
		{
			System.out.println(li+" ");
			return;
		}
		li.add(1);
		AllPaths(i+1,n,li);
		int s=li.size(); // li.remove(li.size() - 1);
		li.remove(s-1);
		
		if(i+2 <= n)
		{
			li.add(2);
			AllPaths(i+2,n,li);
			s=li.size();
			li.remove(s-1); // li.remove(li.size() - 1);
		}
		return;
	}

}
