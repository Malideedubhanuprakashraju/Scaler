package Graphs;

import java.util.ArrayList;

public class Class_62_Graphs_4 
{

	public static void main(String[] args) 
	{
		// Q1) Given Undirected Graph find no:of Components
		/*
		 * 	   Component : A part of graph is component, from every node we can visist all nodes in that component.
		 * 
		 * Eg : N = 15
		 * 
		 * 			3
		 * 		
		 *  1		2		4
		 *  
		 *  		6
		 *  
		 *  	  9
		 *  5			8
		 * 		  7
		 * 
		 * 
		 * 
		 * 	10			12
		 * 	
		 * 		   11
		 * 
		 * 			
		 * 		   14
		 * 
		 *  
		 *  15 ------- 13
		 * 
		 * 
		 * Idea-1 :
		 * -------
		 *				DFS				DFS					DFS			DFS		
		 * 			0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15
		 * 
		 * 			F	F	F	F	F	F	F	F	F	F	F	F	F	F	F	F
		 * 
		 * 				T	T	T	T	T	T	T	T	T	T	T	T	T	T	T
		 * 
		 * Conclusion : No.of Components = No: of Time we Appaly DFS
		 *   
		 */
		
		int n=15;
		
		ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
		
		for(int i=0;i<=n;i++)
		{
			graph.add(new ArrayList<>());
		}
		
		// Component-1
		
		graph.get(1).add(3);
		graph.get(3).add(1);
		
		graph.get(3).add(4);
        graph.get(4).add(3);

        graph.get(4).add(6);
        graph.get(6).add(4);

        graph.get(6).add(1);
        graph.get(1).add(6);

        graph.get(3).add(2);
        graph.get(2).add(3);

        graph.get(2).add(6);
        graph.get(6).add(2);
        
        // Component 2
        graph.get(5).add(9);
        graph.get(9).add(5);

        graph.get(9).add(8);
        graph.get(8).add(9);

        graph.get(8).add(7);
        graph.get(7).add(8);

        graph.get(7).add(5);
        graph.get(5).add(7);
        
     // Component 3
        graph.get(10).add(11);
        graph.get(11).add(10);

        graph.get(11).add(12);
        graph.get(12).add(11);

        graph.get(12).add(14);
        graph.get(14).add(12);

        graph.get(14).add(10);
        graph.get(10).add(14);

        // Component 4
        graph.get(13).add(15);
        graph.get(15).add(13);
		
		
		int ans=Components(graph,n);
		System.out.println("Number of Connected Components = " + ans);
		
		System.out.println();
		
		// Q2) No : of Islands
		/*
		 * 	   Given a Matrix of 1's & 0's find no : of Islands are present 
		 * 
		 * 	   Mat[][] -> 1 : Land ,	Island : Water in all 4 directions
		 * 
		 * 	   		   -> 0 : Water
		 * 
		 * 	   Note : Outside Matrix, It's Complexity Water
		 * 
		 * Eg :
		 * 
		 * 	  Mat[5][5] = 1	  1		0	0	1
		 * 			
		 * 				  0	  1		0	1	0
		 * 	
		 * 				  1	  0		0	1	1
		 * 
		 * 				  1	  1		0	0	0
		 * 
		 * 				  1	  0		1	1	1
		 * 
		 * 	  # 5-islands = 5 Components
		 *  
		 */
		
		/* Idea : For given Matrix Calculate no : of Components,
		 * 
		 * 		  Applay DFS, Need ?
		 * 
		 * 		  1) Adjacency List : Connected Nodes
		 * 
		 * 			 From (i,j) : Can Visit (i-1,j) (i+1,j)	(i,j-1) (i,j+1)
		 *  
		 * 		  2) Visisted Array :
		 * 
		 * 			 Mat[i][j] = 1 => 0 Land to Water
		 *  
		 */
		
		int mat[][]= {{1,1,0,0,1},{0,1,0,1,0},{1,0,0,1,1},{1,1,0,0,0},{1,0,1,1,1}};
		
		int ans1 = Number_Of_Islands(mat);

        System.out.println("Number of Islands = " + ans1);
		
        
        // Q3) Minimum Jumps Required to Reach End
        /*
         * 	   You are given Array[N], Initially Positioned at 0^th Index.
         * 
         * 	   Each Element Ar[i] represents the Maximum Length of a Forward Jump from index i.
         * 
         * 	   if( ar[i] = j ) :
         * 
         * 	   		 From i^th Index, We can jump at Max j Steps that Means
         * 
         * 			 We can go away where from { i to i+j } index
         * 
         * 	   Return Minimum number of jumps to reach (N-1)^th index.
         * 
         * 	   Test Cases are generated such that we will reach (N-1)^th Index.
         * 	   
         */
        
        int ar[]= {2,3,1,1,4};
        
        int ans2=MinJumps(ar,0);
        System.out.println("Recursive Jump Code : "+ans2);
        
        System.out.println();
        
        int ans3=MinJumps1(ar);
        System.out.println("Greedy Jump Code : "+ans3);
        
	}

	private static int MinJumps1(int[] ar)// T.C = O(N) 
	{									  // S.C = O(1)
		 int n=ar.length;
		 
		 int l=0,jumps=0;
		 
		 int i=0;
		 
		 while(l<n-1)
		 {
			 int max=0;
			 
			 for(;i<=l;i++)// The for loop runs for every index in the current reachable range to find the farthest index that can be reached with the next jump.
			 {
				max=Math.max(max, ar[i]+i); 
			 }
			 l=max;
			 jumps++;
		 }
		 
		 return jumps;
	}

	private static int MinJumps(int[] ar, int i)// T.C = O(2^N) 
	{											// S.C = O(N)
		// Reached the Last Index
		
		if(i>=ar.length-1)
		{
			return 0;
		}
		
		// Cannot Move Further
		
		if(ar[i]==0)
		{
			return Integer.MAX_VALUE;
		}
		
		// Stores the best (minimum) answer from this index
		int bestAnswer=Integer.MAX_VALUE;
		
		// Try all possible jumps
		
		for(int jump=1;jump<=ar[i];jump++)//jump = 1 starts from the smallest valid jump (1 step) and tries every possible jump up to the maximum allowed (arr[index]).
		{
			
			// Remaining jumps from the next index
			int remaingJumps=MinJumps(ar,i+jump);
			
			// If this path can reach the destination
			if(remaingJumps !=Integer.MAX_VALUE)
			{
				// Total jumps = Current Jump + Remaining Jumps
	            // int totalJumps = remainingJumps + 1;
				
				bestAnswer=Math.min(bestAnswer, remaingJumps+1);// 1+next -> Current Jump + Remaining Jumps = Total jumps from the current index.
			}
				
		}
		
		return bestAnswer;
		
		/*
		 *  | Variable         | Meaning                                     |
			| ---------------- | ------------------------------------------- |
			| `index`          | Current position in the array               |
			| `jump`           | Current jump length being tried             |
			| `remainingJumps` | Jumps needed from the next index to the end |
			| `totalJumps`     | Current jump + Remaining jumps              |
			| `bestAnswer`     | Minimum jumps among all possible paths      |

		 */
	}

	private static int Number_Of_Islands(int[][] mat) // TC : O(R × C)
	{												  // SC : O(R × C)
		int r=mat.length;
		int c=mat[0].length;
		
		int islands=0;
		
		for(int i=0;i<r;i++)
		{
			for(int j=0;j<c;j++)
			{
				if(mat[i][j]==1)
				{
					islands++;
					dfs(mat,i,j,r,c);
				}
			}
		}
		
		return islands;
	}

	private static void dfs(int[][] mat, int i, int j, int r, int c) // TC : O(R × C)
	{																 // SC : O(R × C)
		// Ouside Matrix
		
		if(i<0 || i>=r || j<0 || j>=c)
		{
			return;
		}
		
		// Water Cell
		
		if(mat[i][j]==0)
		{
			return;
		}
		
		// Mark Land as Visited
		
		mat[i][j]=0;
		
		// Up
		
		dfs(mat,i-1,j,r,c);
		
		// Down
		
		dfs(mat,i+1,j,r,c);
		
		// Left
		
		dfs(mat,i,j-1,r,c);
		
		// Right
		
		dfs(mat,i,j+1,r,c);
		
	}

	private static int Components(ArrayList<ArrayList<Integer>> graph, int n) // T.C = O(V + E)
	{																		  // S.C = O(V)
		
		boolean vis[]=new boolean[n+1];		
		int c=0;
		for(int i=1;i<=n;i++)
		{
			if(vis[i]==false)
			{
				c++;
				DFS(graph,vis,i);// Appaly DFS from i
			}
			
		}
		
		return c;
	}

	private static void DFS(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int u) // T.C = O(V + E)
	{																				   // S.C = O( V )
		vis[u]=true;
		
		for(int i=0;i<graph.get(u).size();i++)
		{
			int v=graph.get(u).get(i);
			
			if(vis[v]==false)
			{
				DFS(graph,vis,v);
			}
		}
		return;
	}

}
