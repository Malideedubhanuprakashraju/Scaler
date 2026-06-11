package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Class_60_Graphs_2 
{

	public static void main(String[] args) 
	{ 
		// Revise 
		/*
		 * Q) How To Store a Graph
		 * 
		 * 	  Using Adjacency List to Store Graph
		 * 	  |
		 * 	  ----> ArrayList<ArrayList<Integer>> ar;
		 *  		
		 */
		
		/* BFS : Breadth First Search : { Level Order Traversal }
		 * 
		 * 		 Visit a Node :
		 * 
		 * 		 1) Mark it Visited
		 * 
		 * 		 2) Got all Unvisited Adjacent Nodes & Push in Queue
		 * 
		 * 		 3) Repeat Until queue is Empty
		 *   
		 */
		
		// Q1) Given a Undirected Grapgh & Source Node & Destination Node. 
		
		//	   Check if Node can be Visited from Source Node
		
		/* N = 6 , E = 7
		 * 
		 * 
		 * Graph :
		 * 
		 * 		2
		 * 	-	   -3	
		 * 1	|	|	6
		 * 	   -4-	5-
		 * 
		 * BFS Traversal :
		 * --------------
		 * 
		 * From a Node Consider All Unvisited Adjacency Nodes & Visit Them
		 * 
		 * 				1
		 * 			2		4
		 * 			|		|
		 * 			3		5
		 * 					|
		 * 					6
		 * 
		 * Create Adjaceny List : S=1, D=6 Check Path ?
		 * 
		 * Adjacency List :
		 * 
		 *  1 -> 2, 4
			2 -> 1, 3
			3 -> 2
			4 -> 1, 5
			5 -> 4, 6
			6 -> 5
		 * 
		 * Implementation :
		 * ---------------
		 * 
		 * 1) Adjacency List
		 * 
		 * 2) Queue (Level)
		 * 
		 * 3) Visited []
		 * 
		 * Interview Approach (Remember) :
		 * -----------------------------
		 * 
		 *  BFS = Queue + Visited[]

			1. Put Source in Queue
			2. Mark Source Visited
			3. Remove Front Node
			4. Visit all Unvisited Neighbours
			5. Add them into Queue
			6. Repeat until Queue becomes Empty
		 * 
		 */
		
		// BFS Code
		
		int N=6;
		
		int E=7;
		
		int[] u = {1,1,2,2,3,5,4};
        int[] v = {2,4,4,3,5,6,5};
        
        int S = 1;
        int D = 6;
        
        boolean ans = BFS(N,E,u,v,S,D);

        if(ans)
            System.out.println("YES, Path Exists");
        else
            System.out.println("NO, Path Does Not Exist");
        
        
        // Multi Source BFS :
        
        // Q) Given N Number & MultiSource S1 , S2 , S3 -> Find Length of Shortest Path for Every Node to One of the Source Node { S1, S2, S3 }
        
        // Idea :
        /*
         * 1) Take Every Hospital as Source Node, Applay BFS & Get Length of Shortest Path to all Nodes 
         * 
         * 	  T.C = O( 3*(N+E))
         * 
         * 2) Take all 3-Hospitals as Source nodes & Push in Queue & Applay BFS
         * 
         * 	  T.C = O( N+E )
         * 
         * Idea : Multisource BFS : Shortest Path to One of The Source Node.
         *  
         */
        
        /* Rotten Oranges :
         * 
         * 							---> 0: Empty Cell
         * 							|
         * 				  Mat[N][M] ---> 1: Fresh Orange Present
         * 							|
         * 							---> 2: Rotten Ornages Present
         * 
         * Every Minute Any Fresh Orange, Adjacent to a Rotten Ornage becomes Rotten, Find Time When All Fresh Ornages Become Rotten
         * 
         * Note : If not Possible Return -1;
         * 
         * Eg : 
         * 
         * 		0	1	2
         * 
         *  0	1	2	1
         *  
         *  1	1	1	0
         *  
         *  2	1	0	1
         *  
         * Ans = -1;
         *
         * 
         * Hint : It Becomes Rotten
         * 
         * Time = Length of Shortest Path to Any one of the Rotten Orange.
         * 
         * 
         * Final Step : Iterate on Entire Matrix & get Max Time at Which a Cell is becoming Rotten
         * 
         * Check : Also need to check if All Oranges become Rotten or Not.
         *  
         */
        
        /* MultiSource BFS
         * ---------------
         * 
         * 1) Source : All Rotten cells are Source
         * 
         * 2) Queue < Pair <int,int> > :
         * 
         * 			a) Create a Pair Clss & Create a Queue on That
         * 
         * 3) Adjacency List :
         * 
         * 			a) It will give you Adjacent Nodes Information
         * 
         * 			b) In above question 
         * 
         * 
         * 					    (i-1,j)
         * 						   |
         * 				(i,j-1)<-(i,j) -> (i,j+1)
         * 						   |
         * 						 (i+1,j)
         * 	 Con : We can Calculate Adjacent Nodes info on the Fly, There is no reason to store the Above Information.
         * 
         * 4) Vis : Can we use given matrix itself, it indicate visited or Not
         * 
         * 		0 : Empty
         * 
         * 		1 : Fresh, When Fresh Becomes Rotten 1->2
         * 	
         * 		2 : Rotten
         * 
         * 5) Time[N][M] :
         * 	
         * 				  Time[i][j] : At what Time Cell [i,j] become Rotten.
         * 			
         * 				  Track , No : of Levels in Queue, No need of Time[][]
         * 
         * 6) T.C = O(N+E) = N*M + N*M*4 = 5*N*M = O(N*M)
         *  
         */
        
        // Rotten Oranges Code
        
        int[][] grid =
            {
                {2,1,1},
                {1,1,0},
                {0,1,1}
            };

            System.out.println(orangesRotting(grid));
		
	}

	private static int orangesRotting(int[][] grid) // TC = O(N * M)
	{												// SC = O(N * M)
		int n=grid.length;
		int m=grid[0].length;
		
		int time[][]=new int[n][m];
		
		Queue<pair> q=new LinkedList<>();
		
		// Put All Rotten Oranges into Queue
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(grid[i][j]==2)
				{
					q.add(new pair(i,j));
					time[i][j]=0;
				}
			}
		}
		
		/* Direction Arrays
		 * 
		 * int[] xp = {-1, 1, 0, 0};
		   int[] yp = { 0, 0,-1, 1};
		 * 
		 * Think of them as pairs:
		 * 
		 *  xp[0], yp[0] = (-1, 0)  Up

			xp[1], yp[1] = ( 1, 0)  Down
			
			xp[2], yp[2] = ( 0,-1)  Left
			
			xp[3], yp[3] = ( 0, 1)  Right
		 * 
		 * 
		 * Visual :
		 * 
		 *          Up
			      (-1,0)
			
			Left    X    Right
			(0,-1)     (0,1)
			
			      (1,0)
			       Down
		 */
		int xp[]= {-1,1,0,0};
		int yp[]= {0,0,-1,1};
		
		while(q.size()>0)
		{
			pair p=q.poll(); // It will return and delete front Element in Queue
			
			int x= p.i, y= p.j;
			
			
			// Visit all Unvited Adjacent Nodes and Push in Queue
			
			// From Current Cell
			
			// (2,3)
			
			// we automatically get:
			/*
			 *      Up    -> (1,3)

					Down  -> (3,3)
					
					Left  -> (2,2)
					
					Right -> (2,4)
			 */
			
			// Why x + xp[j]?
			
			// Current Cell = (x,y)

//				Move Up    => Row - 1
//				Move Down  => Row + 1
//				Move Left  => Col - 1
//				Move Right => Col + 1
			
			// The arrays store these changes:
			
			/*
			 * Direction    Row Change   Col Change

				Up              -1            0
				Down             1            0
				Left             0           -1
				Right            0            1
				
				which is exactly:
				
				xp = {-1, 1, 0, 0};
				yp = { 0, 0,-1, 1};
				
				So
				
				nx = x + xp[j];
				ny = y + yp[j];
				
				Means :
				
				Start from current cell (x,y) and move in one direction.
				
			 */
			
			for(int j=0;j<4;j++)
			{
				int nx=x+xp[j];
				int ny=y+yp[j];
				
				if((nx>=0) && (nx<n) && (ny>=0) && (ny<m) && (grid[nx][ny]==1))
				{
					q.add(new pair(nx,ny));
					time[nx][ny]=time[x][y]+1;
					grid[nx][ny]=2; // Making it as Rotten
				}
			}
			
		}
		
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(grid[i][j]==1)
				{
					return -1;
				}
				ans=Math.max(ans, time[i][j]);
			}
		}
		return ans;
	}

	private static boolean BFS(int n, int e, int[] u, int[] v, int s, int d) // T.C = O(N + E)
	{																		 // S.C = O(N + E)
		 // Craete Adjacency List
		
		ArrayList<ArrayList<Integer>> g= new ArrayList<>();
		
		for(int i=0;i<=n;i++)
		{
			g.add(new ArrayList<>());
		}
		
		/* Note : for(int i = 0; i <= N; i++) // 0..6  => 7 adjacency lists // because node numbering starts from 1 and we keep index 0 unused.
		 * 
				  for(int i = 0; i < E; i++)  // 0..6  => 7 edges // because arrays use 0-based indexing and contain exactly E elements.
		 * 
		 */
		
		// Create Graph
		
		for(int i=0;i<e;i++)
		{
			g.get(u[i]).add(v[i]);
			g.get(v[i]).add(u[i]); // Undirected Graph
        
		}
		
		// Queue + Visited
		
		Queue<Integer> q=new LinkedList<>();
		
		boolean[] vis=new boolean[n+1];
		
		// Source Node
		
		q.add(s);
		vis[s]=true;
		
		while(!q.isEmpty())
		{
			int curr=q.poll();
			
			// Destination Found
			if(curr==d)
			{
				return true;
			}
			
			// Visit all Unvisited Adjacent Nodes
			
			for(int neigh : g.get(curr))
			{
				if(!vis[neigh])
				{
					vis[neigh]=true;
					q.add(neigh);
				}
			}
			
		}
		return false;
		
	}

}
