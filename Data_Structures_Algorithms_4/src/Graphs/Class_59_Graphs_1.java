package Graphs;

import java.util.ArrayList;

public class Class_59_Graphs_1 
{	
	public static ArrayList<ArrayList<Integer>> grh=new ArrayList<>();
	
	public static boolean[] visited; 

	public static void main(String[] args) 
	{
		// Graphs
		/*
		 * Introduction :
		 * 
		 * Graph : Collection of Nodes O & Edges - : { Tree }
		 * 
		 * Eg : Trees 
		 * 
		 * N=8 , E=7
		 * 
		 * 			1
		 * 		2		3
		 * 4		5		6
		 * 
		 * 		7		8
		 * 
		 * Eg : Graph
		 * 
		 * N=8 , E=9
		 * 
		 * 			1				2
		 * 
		 * 	  6			7		8		3
		 * 
		 * 			5				4
		 * 
		 * Main Difference Between Trees & Graphs
		 * 
		 * 1) Tree is a Hierarchial Data Structure
		 * 
		 * 2) In Tree : Edges = N-1, N - no of Nodes
		 * 
		 * 3) In Graph : No Restriction of Edges in Grapgh.
		 *  
		 */
		
		/* Classification of Graphs 
		 * 
		 * 1) Directed		VS		Undirected
		 * 
		 * 		B						A				B
		 * 
		 * A		C
		 * 									D				C
		 * 		D
		 * 
		 * 
		 * Eg : LinkedIn / Instagram		Eg : Facebook 
		 * 
		 * 		A follows B : A -> B			 A is Friend of B
		 * 
		 * 
		 * 2) Weighted		VS		Unweighted
		 * 
		 * 	  A	   40	B			A			B
		 * 	  30		20
		 * 
		 * 	  C			D			C			D
		 * 
		 * Note : Weight id Assaigned to an Edge
		 * 
		 * 		  1) Distance / Time / Money / Profit
		 * 
		 * 		  At time of Creation we define Weight.
		 * 
		 * 3) Cyclic 		VS			Acyclic
		 * 
		 * 	  A			B				A		B
		 * 	 
		 * 	  D			C				C		D
		 * 
		 * 							F
		 * 
		 * Cycle : We Start Traversal from Any Node & We Reach Same Start Node by Visiting Any Edges at Most 1.
		 * 
		 * Note : Both Directional & Un-Directional
		 * 
		 * 
		 * 4) Below Classification exists only in Undirected Graph.
		 * 
		 * 	  Connected Graph : Has Path between Every Pair of Vertices.
		 * 
		 * 	  a) 	A	  -		B
		 * 
		 * 	  		|			|
		 * 
		 * 			D	  -		C
		 * 
		 * 	  Disconnected Graph : There Exists a Pair of Vertices without a Path
		 * 
		 * 	  b)	A ----- B      E ----- F
					|              |
					D              G
		 * 	  
		 * 
		 * 5) Degree of Vertex / Node in Undirected Graph
		 * 
		 * 	  Degree of Vertex is number of Edges incident to a Node
		 * 
		 * 	  Eg : 			D:1
		 * 	  				|
		 * 			A:1	-	B:3	-	C:1
		 * 
		 * 
		 * 6) In Degree / Out Degree of Vertex / Node in Directed Gragh
		 * 
		 * 	  -> InDegree : Count of Edges coming towards Node. O<-
		 * 
		 * 	  <- OutDegree : Count of Edges going from that Node. O->
		 * 
		 * 	  Eg : 
		 * 
		 * 	  A		->		B
		 * 
		 * 	  |		 ->		|
		 * 
		 * 	  D		->		C
		 * 
		 * 	  Nodes :		A		B		C		D
		 * 
		 * 	InDegree :		0		2		2		1
		 * OutDegree :		2		1		0		2
		 * 
		 * 
		 * Note : Information given for Finding
		 * 
		 * Classification : Undirected / Directed, Weighted / Unweighted 
		 *   
		 */
		
		/* 
		 * 1) What are the ways to store a graph?

			  Expected Answer:
				
			  There are mainly two ways:
				
			  1) Adjacency Matrix
			  2) Adjacency List
						
		 * Eg : Graph
		 * 
		 *  1 ----- 2
			|       |
			|       |
			4 ----- 3
		 * 
		 * Edges :
		 * 
		 *  1 - 2
			2 - 3
			3 - 4
			4 - 1
			
			Connection works in both directions.
		 * 
		 * 1) Adjacency Matrix : Connected Matrix
		 * 
		 * 	  Idea : Store grapgh using a 2D Array.
		 * 
		 * 	  If an edge exists:
		 * 
		 * 				mat[u][v] = 1;
		 * 	  Else :
		 * 
		 * 				mat[u][v] = 0;
		 * 					
		 * Matrix Representation
		 * 
		 *      1 2 3 4
			1   0 1 0 1
			2   1 0 1 0
			3   0 1 0 1
			4   1 0 1 0
			
		 *   
		 */
		int N = 4;

        int[][] mat = new int[N + 1][N + 1];

        // Add edges
        mat[1][2] = 1;
        mat[2][1] = 1;

        mat[2][3] = 1;
        mat[3][2] = 1;

        mat[3][4] = 1;
        mat[4][3] = 1;

        mat[4][1] = 1;
        mat[1][4] = 1;

        // Print matrix
        for(int i = 1; i <= N; i++)
        {
            for(int j = 1; j <= N; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        
        // Undirected Graph // U - V
        
        /*
           mat[u][v] = 1;
		   mat[v][u] = 1;
		   
         */
        
        // Directed Graph // U -> V
        
        /*
         
           mat[u][v] = 1;
           
           Only one direction
         
         */
        
        // T.C = O(E) , S.C = O(N^2)// Because every pair of nodes gets memory.
        
        /* Example
         * 
         * Graph:
         * 
         * 		 1 ----- 2

				 3 ----- 4
         * 
         * Only 2 edges exist.
         * 
         * But matrix still stores:
         * 
         *      1 2 3 4
			1   0 1 0 0
			2   1 0 0 0
			3   0 0 0 1
			4   0 0 1 0
         * 
         * Many unnecessary 0’s stored.
         * 
         * Matrix Space Complexity : O(N^2)
         * 
         * Because every pair of nodes gets memory.
         * 
         * Possible pairs: N × N
         *  
         */
        
        /*
         *  Advantages :
         *  
			Fast edge checking
			Simple implementation
			
			Disadvantages :
			
			Wastes memory for sparse graphs
         */
        
        // 2) Adjacency List : Connect List
        		
        /*	Idea : Each node stores a list of its neighbors.
         * 
         * 		   For Every Node, Store Information of Connected Nodes in a List.
         * 
         * 
         * 	Representation :
         * 
         * 	1 -> 2,4	// Node 1 connected to 2 and 4
			2 -> 1,3
			3 -> 2,4
			4 -> 1,3
         * 	
         *  
         */
        
        System.out.println();
        
        System.out.println("Adjacency List --> ");
        System.out.println();
        int n=4;
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        // Create empty lists
        for(int i=0;i<=n;i++)
        {
        	graph.add(new ArrayList<>());
        }
        
        graph.get(1).add(2);
        graph.get(1).add(4);
        graph.get(2).add(1);

        graph.get(2).add(3);
        graph.get(3).add(2);

        graph.get(3).add(4);
        graph.get(4).add(3);

        graph.get(4).add(1);
        
        // Print graph
        for(int i = 1; i <= N; i++)
        {
            System.out.print(i + " -> ");

            for(int neigh : graph.get(i))
            {
                System.out.print(neigh + " ");
            }

            System.out.println();
        }
        
        /*	Case-1 :
         * 
         *	// U - V
         *
         *	graph.get(U).add(V)
         *
         *	graph.get(V).add(U)
         *
         *	
         *	Case-2 :
         *
         *	// U -> V
         *
         *	graph.get(U).add(V)
         *	
         *	T.C = O(N + E)
         *
         *	S.C = O(N + E{O(1)}) = O(N+E)
         * 
         *	Note : Space Complexity gets reduced in Adjacency List because:
         *
         *		   We store only existing edges, not all possible connections. 
         * 
         * “Why does adjacency list reduce space complexity?”
         * 
         * 						Because adjacency list stores only existing edges, 
         * 						whereas adjacency matrix stores all possible node pairs including unnecessary empty connections. 
         * 						Therefore memory usage reduces from:
         * 
         * 						O(N^2)→O(V+E) // Vertices → V // Existing edges only → E
         * 
         */
        
        /* DFS : Depth First Search
         * 
         * 		 1) Start at a Vertex & Mark it as Visited.
         * 
         * 		 2) From Current Vertex, choose an Unvisited Adjacent Node & Applay DFS
         * 
         * DFS Means :
         * 
         * 			 Explore deeply First, Then Backtrack
         * 
         * It Visits :
         * 
         * 			 A) One Node
         * 
         * 			 B) Then it's Neighbour
         * 
         * 			 C) Then Neighbour's Neighbour
         * 
         * Eg :
         * 
         * 	  	1 ----- 2
				|       |
				|       |
				4 ----- 3
         * 		
         * DFS Travesal :
         * 
         * 		Start from node 1 : 1 → 2 → 3 → 4
         * 
         * 		DFS goes deep first.
         * 
         * 
         * 		Storage Used
         * 
         * DFS is usually implemented using :
         * 
         * 	Adjacency List
         * 
		 *	Recursion (stack internally)
         *  	 
         */
        
        // Q) Create a graph with N vertices and given edges.
        /* 
         * 	  	N = 4
         * 
         * Eg :
         * 		1 ---- 2
				|      |
				|      |
				4 ---- 3
				
		   Adjacency List Representation :
		   
		    1 -> 2,4
			2 -> 1,3
			3 -> 2,4
			4 -> 1,3
		   	
         *  
         */
        
        int nn=6;//4;
        
        System.out.println();
        
        visited = new boolean[nn+1];
        
        // Create a Graph
        
        for(int i=0;i<=nn;i++)
        {
        	grh.add(new ArrayList<>());
        }
        
        // Add Edges
        
        // Eg-1 :
        
//        grh.get(1).add(2);
//        grh.get(1).add(4);
//        grh.get(2).add(1);
//        grh.get(2).add(3);
//        grh.get(3).add(4);
//        grh.get(3).add(2);
//        grh.get(4).add(1);
//        grh.get(4).add(3);
        
        // Eg-2 :
        
        grh.get(1).add(2);
        grh.get(1).add(3);

        grh.get(2).add(1);
        grh.get(2).add(4);
        grh.get(2).add(5);

        grh.get(3).add(1);
        grh.get(3).add(6);

        grh.get(4).add(2);

        grh.get(5).add(2);

        grh.get(6).add(3);
        
        // DFS Traversal
        
        dfs(1);

	}

	private static void dfs(int node) 
	{  
		visited[node] = true;
		
		System.out.print(node+ " ");
		
		for(int n:grh.get(node))
		{
			if(!visited[n])
			{
				dfs(n);
			}
		}
	}

}
