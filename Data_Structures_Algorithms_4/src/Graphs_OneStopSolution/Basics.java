package Graphs_OneStopSolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

 

public class Basics 
{

	public static void main(String[] args) 
	{
		 // Graph : A Graph is a collection of Vertices (Nodes) and Edges (Connections).
		
		 // Types of Graph :
		
			/*
			 * 	Directed Graph → Edges have direction (u → v).
				Undirected Graph → Edges have no direction (u — v).
				Weighted Graph → Edges have weights/costs.
				Unweighted Graph → Edges have no weights.
			 */
		
		 // Ways to Represent a Graph
		
			/* A. Adjacency Matrix
			 * 
			 * B. Adjacency List ⭐ (Most Used)
			 *  
			 */
		// Adjacency Matrix
		
			/*  Uses a 2D array.
				matrix[u][v] = 1 (or weight) means an edge exists.
				Space Complexity: O(V²)
				Edge lookup: O(1)
				Best for dense graphs.
			 * 
			 */
		// Adjacency List ⭐ (Most Used)
		
			/*  Uses ArrayList<ArrayList<Integer>>.
				Each vertex stores its neighbors.
				Space Complexity: O(V + E)
				Best for sparse graphs.
				Used in almost all interview problems.
			 * 
			 */
		// Q1) Given an undirected graph with 5 vertices and the following edges:
		/*
		 * 	    V = 5

				Edges:
				1 - 2
				1 - 3
				2 - 4
				3 - 4
				4 - 5
				
			   Construct the Adjacency Matrix.
		 */
		
		/*	Step 1: Draw the Graph
		 * 
		 * 	       1
			      / \
			     2   3
			      \ /
			       4
			       |
			       5
		 * 
		 * Step 2: Create an Empty Matrix
		 * 
		 * 		   Since there are 5 vertices, create a 5 × 5 matrix.
		 * 
		 *      1 2 3 4 5
			   -----------
			1 | 0 0 0 0 0
			2 | 0 0 0 0 0
			3 | 0 0 0 0 0
			4 | 0 0 0 0 0
			5 | 0 0 0 0 0
		 * 
		 * Step 3: Fill the Matrix
		 * 
		 * 		   For every edge (u, v):
		 * 
		 * 		   Since it is an undirected graph,
		 * 		
		 * 		   matrix[u][v] = 1;
				   matrix[v][u] = 1;
		 * 
		 */
		
		int Vertices=5;
		
		int Edges[][]= { {1,2},{1,3},{2,4},{3,4},{4,5}};
		
		int mat[][]=new int[Vertices+1][Vertices+1];
		
		// Build Adjacency Matrix
		
		for(int i=0;i<Edges.length;i++)
		{
			int u=Edges[i][0];
			int v=Edges[i][1];
			
			mat[u][v]=1;
			mat[v][u]=1; // Remove this line for a directed graph
		}
		
		System.out.println("Graph Representation : Adjacency Matrix ");
		for(int i=1;i<=Vertices;i++)
		{
			for(int j=1;j<=Vertices;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		System.out.println("Graph Representation : Adjacency List ");
		
		// Create Adjacency List
		ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
		
		for(int i=0;i<=Vertices;i++)
		{
			graph.add(new ArrayList<>());
		}
		
		// Build Adjacency List
		
		for(int i=0;i<Edges.length;i++)
		{
			int u=Edges[i][0];
			int v=Edges[i][1];
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for(ArrayList<Integer> x:graph)
		{
			for(int y:x)
			{
				System.out.print(y+" ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=1;i<=Vertices;i++)
		{
			System.out.print(i+" -> ");
			
			for(int neighbour :graph.get(i))
			{
				System.out.print(neighbour+" ");
			}
			System.out.println();
		}
		
		/* TC & SC
		 * 
		 *  | Representation       | Build TC | Print TC     | Overall Space |
			| -------------------- | -------- | ------------ | ------------- |
			| **Adjacency Matrix** | **O(E)** | **O(V²)**    | **O(V²)**     |
			| **Adjacency List**   | **O(E)** | **O(V + E)** | **O(V + E)**  |

		 */
		/*
		 *  ## **3. BFS (Breadth-First Search)** ⭐

			### Definition
			
			* **BFS (Breadth-First Search)** is a graph traversal algorithm that visits all vertices **level by level** using a **Queue (FIFO)**.
			
			**Interview One-Liner:**
			
			> **BFS traverses a graph level by level using a Queue (FIFO).**
			
			---
			
			## Why is it called Breadth-First?
			
			It visits all neighboring vertices first before moving to the next level.
			
			### Example Graph
			
			```text
			        1
			      /   \
			     2     3
			    / \     \
			   4   5     6
			```
			
			### Levels
			
			```text
			Level 0 : 1
			
			Level 1 : 2 3
			
			Level 2 : 4 5 6
			```
			
			### BFS Traversal
			
			```text
			1 → 2 → 3 → 4 → 5 → 6
			```
			
			---
			
			# Queue (FIFO)
			
			**FIFO = First In First Out**
			
			Queue Operations
			
			```java
			offer()   // Insert
			poll()    // Remove
			peek()    // Front Element
			```
			
			### Example
			
			```java
			Queue<Integer> queue = new LinkedList<>();
			
			queue.offer(10);
			queue.offer(20);
			queue.offer(30);
			```
			
			Queue
			
			```text
			Front
			
			10 20 30
			
			Rear
			```
			
			```java
			queue.poll();
			```
			
			Queue becomes
			
			```text
			20 30
			```
			
			---
			
			# Why Queue?
			
			BFS always processes the **oldest inserted vertex first**, which is exactly how a Queue works.
			
			---

			# BFS Algorithm
			
			1. Start from the source vertex.
			2. Mark it as visited.
			3. Insert it into the Queue.
			4. While the Queue is not empty:
			
			   * Remove the front vertex.
			   * Visit the vertex.
			   * Add all **unvisited** neighbors into the Queue.
			5. Repeat until the Queue becomes empty.
			
			---
			
			# Dry Run
			
			Graph
			
			```text
			        1
			      /   \
			     2     3
			    / \     \
			   4   5     6
			```
			
			### Step 1
			
			Visit **1**
			
			Queue
			
			```text
			1
			```
			
			Visited
			
			```text
			1
			```
			
			---
			
			### Step 2
			
			Remove **1**
			
			Add **2, 3**
			
			Queue
			
			```text
			2 3
			```
			
			Visited
			
			```text
			1 2 3
			```
			
			---
			
			### Step 3
			
			Remove **2**
			
			Add **4, 5**
			
			Queue
			
			```text
			3 4 5
			```
			
			Visited
			
			```text
			1 2 3 4 5
			```
			
			---
			
			### Step 4
			
			Remove **3**
			
			Add **6**
			
			Queue
			
			```text
			4 5 6
			```
			
			Visited
			
			```text
			1 2 3 4 5 6
			```
			
			---
			
			### Step 5
			
			Remove **4**
			
			Queue
			
			```text
			5 6
			```
			
			---
			
			### Step 6
			
			Remove **5**
			
			Queue
			
			```text
			6
			```
			
			---
			
			### Step 7
			
			Remove **6**
			
			Queue
			
			```text
			Empty
			```
			
			---
			
			## Final BFS Traversal
			
			```text
			1 → 2 → 3 → 4 → 5 → 6
			```
			
			---
			
			# Why do we use a Visited Array?
			
			Consider the graph:
			
			```text
			1 ----- 2
			|       |
			|       |
			3-------
			```
			
			Without a visited array:
			
			```text
			1 → 2 → 3 → 1 → 2 → 3 → ...
			```
			
			The traversal will continue forever because of the cycle.
			
			Use:
			
			```java
			boolean[] visited = new boolean[V + 1];
			```
			
			Whenever a vertex is visited:
			
			```java
			visited[node] = true;
			```
			
			This ensures every vertex is processed only once.
			
			---
			
			# Data Structures Used
			
			```java
			Queue<Integer> queue = new LinkedList<>();
			
			boolean[] visited = new boolean[V + 1];
			```
			
			---
			
			# Time Complexity (TC)
			
			### BFS Traversal
			
			```text
			O(V + E)
			```
			
			**Reason:**
			
			* Every vertex is visited exactly once → **O(V)**
			* Every edge is explored once (or twice in an undirected graph, still **O(E)**)
			
			Overall:
			
			```text
			O(V + E)
			```
			
			---
			
			# Space Complexity (SC)
			
			```text
			O(V)
			```
			
			**Reason:**
			
			* Queue → O(V)
			* Visited Array → O(V)
			
			Overall Auxiliary Space:
			
			```text
			O(V)
			```
			
			---
			
			# Applications of BFS
			
			* Shortest Path in an Unweighted Graph
			* Level Order Traversal in Trees
			* Connected Components
			* Number of Islands
			* Flood Fill Algorithm
			* Bipartite Graph Checking
			* Kahn's Algorithm (Topological Sort)
			
			---
			
			# BFS vs DFS
			
			| BFS                                    | DFS                              |
			| -------------------------------------- | -------------------------------- |
			| Uses Queue                             | Uses Stack / Recursion           |
			| Level-by-Level Traversal               | Goes Deep First                  |
			| Finds Shortest Path (Unweighted Graph) | Does Not Guarantee Shortest Path |
			| FIFO                                   | LIFO                             |
			| Time: O(V + E)                         | Time: O(V + E)                   |
			
			---
			
			# Interview Questions
			
			### Q1. What is BFS?
			
			**Answer:** BFS is a graph traversal algorithm that visits vertices level by level using a Queue.
			
			### Q2. Which data structure is used in BFS?
			
			**Answer:** Queue (FIFO).
			
			### Q3. Why do we use a visited array?
			
			**Answer:** To avoid revisiting vertices and prevent infinite loops in cyclic graphs.
			
			### Q4. Time Complexity of BFS?
			
			**Answer:** **O(V + E)**
			
			### Q5. Space Complexity of BFS?
			
			**Answer:** **O(V)**
			
			### Q6. Where is BFS used?
			
			**Answer:** Shortest path (unweighted graphs), level-order traversal, flood fill, connected components, number of islands, bipartite graph checking, and Kahn's algorithm.
			
			---
			
			# One-Line Interview Revision
			
			* **BFS = Breadth-First Search**
			* **Uses Queue (FIFO)**
			* **Traverses Level by Level**
			* **Requires a Visited Array**
			* **Time Complexity = O(V + E)**
			* **Space Complexity = O(V)**
			* **Used for Shortest Path in Unweighted Graphs**

		 */
		
		 	BreadthFirstSearch(graph,Vertices,1);
		 	
		 /*
		  * 4.  DFS (Depth-First Search) ⭐
				Definition
				
				DFS (Depth-First Search) is a graph traversal algorithm that visits a node and goes as deep as possible before backtracking.
				
				Interview One-Liner:
				
				DFS traverses a graph depth-wise using Recursion (or Stack).
				
				Data Structure Used
				Recursion (Call Stack) ⭐
				Stack (Iterative DFS)
				
				Eg :
				
				        1
				      /   \
				     2     3
				    / \     \
				   4   5     6
				   
				DFS Traversal :
				
				1 → 2 → 4 → 5 → 3 → 6
				
				DFS Algorithm :
				
				Visit the current node.
				Mark it as visited.
				Visit all unvisited neighbours recursively.
				Backtrack when no unvisited neighbour exists.
		  */
		 	System.out.println();
		 	System.out.print("DFS Traversal : ");
		 	boolean[] visited=new boolean[Vertices+1];
		 	DepthFirstSearch(graph,visited,1);
		 	
		 	
		 // Connected Components : Q1. Count the Number of Connected Components using DFS ?
		 	
		 /*	Problem :
		  * 
		  * Given an undirected graph:

			V = 6
			
			Edges:
			1 - 2
			2 - 3
			4 - 5
			
			Find the number of connected components.
		  * 
		  * 
		  * Ans :
		  * 
		  * Connected Components = 3
		  * 
		  */
		 	
		 int v=6;
		 
		 ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
		 
		 for(int i=0;i<=v;i++)
		 {
			 ar.add(new ArrayList<>());
		 }
		 
		 ar.get(1).add(2);
		 ar.get(2).add(1);
		 
		 ar.get(2).add(3);
		 ar.get(3).add(2);
		 
		 ar.get(4).add(5);
		 ar.get(5).add(4);
		 
		 boolean b[]=new boolean[v+1];
		 
		 int c=0;
		 
		 for(int i=1;i<=v;i++)
		 {
			 if(!b[i])
			 {
				 dfs(i,b,ar);
				 c++;
				 
			 }
		 }
		 
		 System.out.println();
		 System.out.println("Connected Components Using DFS : "+c);// T.C = O(V + E)
		 
		 System.out.println();
		 
		 
		 
		 for(int i=1;i<=v;i++)
		 {
			 if(!b[i])
			 {
	
				 bfs(i,b,ar);
				 c++;
				 
			 }
		 }
		 System.out.println();
		 System.out.println("Connected Components Using BFS : "+c);// T.C = O(V + E)
		 
		 System.out.println("Connected Components Printing Using DFS");
		 
		 boolean[] visitedPrint = new boolean[v + 1];

	     int component = 1;
		 
		 for(int i=1;i<=v;i++)
		 {
			 if(!visitedPrint[i])
			 {
				 System.out.print("Componet : "+component+" : ");
				 dfsPrint(i,visitedPrint,ar);
				 System.out.println();
				 component++;
			 }
		 }
		 
		 System.out.println();
		 System.out.println("Connected Components Printing Using BFS");
		 
		 boolean[] vPrint=new boolean[v+1];
		 
		 int cmp=1;
		 
		 for(int i=1;i<=v;i++)
		 {
			 if(!vPrint[i])
			 {
				 System.out.print("Component : "+cmp+" : ");
				 bfsPrint(i,vPrint,ar);
				 System.out.println();
				 cmp++;				 
			 }
		 }
		 
		 
		 
		 
	}
	

	private static void bfsPrint(int i, boolean[] vPrint, ArrayList<ArrayList<Integer>> ar) 
	{
		 Queue<Integer> q=new LinkedList<>();
		 
		 q.offer(i);
		 
		 vPrint[i]=true;
		 
		 while(!q.isEmpty())
		 {
			 int current=q.poll();
			 
			 System.out.print(current+" ");
			 for(int x:ar.get(current))
			 {
				 if(!vPrint[x])
				 {
					 vPrint[x]=true;
					 q.offer(x);
				 }
			 }
		 }
	}


	private static void dfsPrint(int i, boolean[] b, ArrayList<ArrayList<Integer>> ar) 
	{
		 b[i]=true;
		 
		 System.out.print(i+" ");
		 for(int neigh:ar.get(i))
		 {
			 if(!b[neigh])
			 {
				 dfsPrint(neigh,b,ar);
			 }
		 }
	}


	private static void bfs(int i, boolean[] b, ArrayList<ArrayList<Integer>> ar) 
	{
		 Queue<Integer> q=new LinkedList<>();
		 
		 q.offer(i);
		 b[i]=true;
		 
		 while(!q.isEmpty())
		 {
			int current =q.poll();
			
			for(int neig:ar.get(current))
			{
				if(!b[neig])
				{
					b[neig]=true;
					q.offer(neig);
				}
			}
		 }
	}


	private static void dfs(int i, boolean[] b, ArrayList<ArrayList<Integer>> ar)// T.C , S.C = O(V + E)
	{ 
		b[i]=true;
		
		for(int neighbour:ar.get(i))
		{
			if(!b[neighbour])
			{
				dfs(neighbour,b,ar);
			}
		}
	}






	private static void DepthFirstSearch(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int current) 
	{
		
		
		visited[current]=true;
		
		System.out.print(current+" ");
		
		for(int neighbour:graph.get(current))
		{
			if(!visited[neighbour])
			{
				DepthFirstSearch(graph,visited,neighbour);
			}
		}
	}

	private static void BreadthFirstSearch(ArrayList<ArrayList<Integer>> graph, int vertices, int start) 
	{
		boolean[] visited=new boolean[vertices+1];
		
		Queue<Integer> q=new LinkedList<>();
		
		
		// Start the Vertex
		
		q.offer(start);
		
		visited[start]=true;
		
		System.out.println("BFS Traversal : ");
		
		while(!q.isEmpty())
		{
			int current=q.poll();
			
			System.out.print(current+" ");
			
			// Visit All Neighbours
			
			for(int neighbour: graph.get(current))
			{
				if(!visited[neighbour])
				{
					visited[neighbour]=true;
					q.offer(neighbour);
				}
			}
		}
	}

}
