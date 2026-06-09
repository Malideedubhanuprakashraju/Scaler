package Graphs;

import java.util.ArrayList;

public class dfsTraditionalCode 
{
	
	static ArrayList<ArrayList<Integer>> g;
	static boolean[] vis,path;
	static boolean cycle=false;

	public static void main(String[] args) 
	{
		// Number of Nodes
        int N = 4;
        
        // Edge Arrays
        int[] u = {1, 2, 3, 4};
        int[] v = {2, 3, 4, 1};
        
        
        
		boolean ans=Solve(N,u,v,1,4);
		System.out.println("DFS : "+ans);
		
		/*
		 * DFS using adjacency list visits every node and edge once, so time complexity is O(V + E).
		   Space complexity is O(V + E) because of adjacency list storage and recursion stack. 
		 */
		
		// Q) Detect Cycle in a Directed Graph.
		/*
		 * 	Eg-1 : 
		 * 
		 * 	1 ->	2	->	5
		 * 			|	|
		 * 			3	4
		 * 
		 * 	Return : True
		 * 
		 * 
		 * 	Note : From a Node U, Say we Applay DFS(u)
		 * 
		 * 		   if one of the Adjacent Nodes of U is Already Visited, Cycle Exist.
		 * 
		 * 	
		 * 	Hint : DFS Looks Like a Tree
		 * 
		 * 	Obs-1 : In a Tree When is Cycle Formed ?
		 * 
		 * 			1) If a Node is any Edge to it's Ancestor Cycle Formed
		 * 
		 * 			2) If a Node is any Edge to a Node in Path Cycle Formed
		 * 
		 * 
		 * 	Conclusion : Keep Track of Ancestor or Keep Track of Path, to Check for Cyclye Detection
		 * 
		 * 	Obs-1 : When we enter Node : Add in Path
		 * 
		 * 			If we Come back from a Node, it's no longer in Path : We Resume it
		 * 
		 * 	Obs-2 : If a Adjacent Node in Path : Cycle Exists
		 * 
		 * 	
		 * 	Suitable Data Structure for Path :
		 * 
		 * 	1) Stack : Canno't Search
		 * 
		 * 	2) HashSet : It Work's
		 * 
		 * 	3) boolean[] : In Path = True	,	Not in Path = False
		 *   
		 */
		boolean ans1=Solve1(N,u,v);
		
		System.out.println();
		
		System.out.println("Is Cycle in Graph : "+ans1);
		
	
	}

	private static boolean Solve1(int n, int[] u, int[] v) // T.C = O(V+E)
	{													   // S.C = O(V+E)
		 g=new ArrayList<>();
		 
		 for(int i=0;i<=n;i++)
		 {
			 ArrayList<Integer> temp=new ArrayList<>();
			 g.add(temp);
		 }
		 
		 for(int i=0;i<u.length;i++)
		 {
			 // u[i] - v[i]
			 
			 g.get(u[i]).add(v[i]);
			 //g.get(v[i]).add(u[i]); Undirected Graph
			 			 	 
		 }
		 vis=new boolean[n+1];
		 path=new boolean[n+1];
		 
		 cycle=false;
		 
		 for(int i=1;i<=n;i++)
		 {
			 if(vis[i]==false)
			 {
				 DFS1(i);// Called DFS with S.
			 }
		 }
		 return cycle;
	}

	private static void DFS1(int u) // T.C = O(V+E)
	{								// S.C = O(V+E)
		 vis[u]=true;
		 path[u]=true;
		 
		 // Get Adjacent Unvisited Node of U & Applay DFS
		 
		 for(int i=0;i<g.get(u).size();i++)
		 {
			 int v=g.get(u).get(i);
			 
			 if(path[v]==true)
			 {
				 cycle=true;
			 }
			 
			 if(vis[v]==false)
			 {
				 DFS1(v);
			 }
		 }
		 
		 path[u]=false;
		 return;
		
	}

	private static boolean Solve(int n, int[] u, int[] v, int s, int d) // T.C = O(V+E)
	{																	// S.C = O(V+E)
		g=new ArrayList<>();
		
		for(int i=0;i<=n;i++)
		{
			 g.add(new ArrayList<>());
		}
		
		for(int i=0;i<u.length;i++)
		{
			// u[i] -> v[i]
			
			g.get(u[i]).add(v[i]);
			
			g.get(v[i]).add(u[i]);
		}
		
		vis=new boolean[n+1];
		
		dfs(s);
		
		return vis[d];
	}

	private static void dfs(int u) // T.C = O(V+E)
	{							   // S.C = O(V+E)
		 vis[u]=true;
		 
		 // Get Adjacent Unvisited Node of U & Appaly DFS
		 
		 for(int i=0;i<g.get(u).size();i++)
		 {
			 int v=g.get(u).get(i);
			 
			 if(vis[v]==false)
			 {
				 dfs(v);
			 }
		 }
		 
		 return;
	}

}
