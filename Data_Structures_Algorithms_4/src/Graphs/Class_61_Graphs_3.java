package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Class_61_Graphs_3 
{

	public static void main(String[] args) 
	{
		/* 1) Dijktras Algorithims
		 * 
		 * 2) Topological Sort
		 *  
		 */
		
		/* 1) BFS : Queue
		 * 
		 * 2) MultiSource BFS : Push all Source Nodes into Queue.
		 * 
		 * 3) BFS Shortest : It Acess All Nodes at Present Level before going to Next Level.
		 * 
		 */
		
		// Q1) Fire : Petrol Bunk
		
		/* O -> Representing Petrol Bunk
		 * 
		 * a) -- -> Line Indicates Lengths of Petrol Pipe between 2-Bunks
		 * 
		 * b) Initially Say Bunk-1 is Blasted
		 * 
		 * c) Petrol Burns at 1km/min
		 * 
		 * d) Calculate Time at which each Bunk is Blasted
		 * 
		 * 					  10
		 * 			 5		 ----> B3
		 * Eg-1 : B1 -> B2 --|
		 * 					 ----> B4
		 * 					  15
		 * 
		 * 		  Bunks : B1	B2	 B3	  B4
		 * 
		 * 		  Time 	: 0		5	 15	  20
		 * 
		 * 
		 * Note-1 : We Blast Bunk with Minimal Time.
		 * 
		 * 			Bunks : B1	B2	B3	B4
		 * 
		 * 			Time  : 0	10	35	30
		 * 
		 * Note : When Multiple Fires Reach Bunk consider Minimum
		 * 
		 * 
		 * At Every Step :
		 * -------------
		 * 
		 * 1) We Blast Bunk with Min Time
		 * 
		 * 2) Blasted Bunk : Fire Propagates to it's Adjacent Bunks & Blast Time Updated.
		 *  
		 */
		
		/* Dijktra's Algorithm : Single Source --> Shortest Paths 
		 * -------------------
		 * |		|
		 * |		-----> It Will Calculate Length of Shortest Path from Source to All Other Nodes
		 * |
		 * |
		 * ----> Used in : Google Maps....
		 * 
		 * 
		 * Note : Dijkstra's Algorithm is used to find the shortest path from one source node to all other nodes in a weighted graph where all edge weights are non-negative.
		 * 
		 *  Real-Life Example :

			Think of Google Maps :
			
			Source = Your current location
			Nodes = Cities/Junctions
			Edge Weight = Distance or Time
			Goal = Find the shortest route to every destination
			
			This is exactly what Dijkstra's Algorithm does.
		 * 
		 * 	Q1) When can Dijkstra be used ?
		 * 	
		 * 	   ✅ Weighted Graph
			   ✅ Non-negative weights
		 * 
		 * Q2) When should Dijkstra NOT be used?
		 * 
		 * 	   ❌ Negative edge weights
		 * 
		 * 		For negative weights, use:

				Bellman-Ford Algorithm
		 * 
		 * 
		 * /*
		 *  Interview Answer

			Why does Dijkstra have log V?
			
			Because Dijkstra uses a Priority Queue (Min Heap). Both add() and poll() operations take O(log V) time, and these operations are performed for vertices and edge relaxations. Therefore, the overall complexity becomes:
			
			TC = O((V + E) log V)
			
			This is the standard complexity for Dijkstra's Algorithm using a Binary Heap (Java PriorityQueue).
		 *
		 * 
		 * 
		 * Difference :
		 * 
		 *  | Algorithm      | Use                                       |
			| -------------- | ----------------------------------------- |
			| BFS            | Unweighted Graph                          |
			| Dijkstra       | Weighted Graph (Positive Weights)         |
			| Bellman Ford   | Weighted Graph (Negative Weights Allowed) |
			| Floyd Warshall | All-Pairs Shortest Paths                  |

		 *  For interviews, remember this one-line definition :
		 * 	
		 * 	Dijkstra's Algorithm finds the shortest distance from a single source node to all other nodes in a weighted graph with non-negative edge weights.
		 * 
		 */
		
		// Graph Creation
		
		/*  There are N cities connected by roads.

			Each road has a travel cost.
			
			Find the minimum cost required to travel from city A to city B.
		 * 
		 * Eg :
		 * 
		 * Input:
			N = 6
			
			Roads:
			1 2 7
			1 3 9
			1 6 14
			2 3 10
			2 4 15
			3 4 11
			3 6 2
			4 5 6
			5 6 9
			
			Source = 1
			Destination = 5
			
			Output:
			20
		 * 
		 */
		 
		// Undirected Graph Creation
		
		// Since roads are usually bidirectional :
		
		int n=6;
		int e=9;
		
		int[] u = {1, 1, 1, 2, 2, 3, 3, 4, 5};
		
		int[] v = {2, 3, 6, 3, 4, 4, 6, 5, 6};
		
		int[] w = {7, 9, 14, 10, 15, 11, 2, 6, 9};
		
		int[] ans=Dijktras(n,e,u,v,w,1);
		
		for(int x:ans)
		{
			System.out.print(x+ " ");
		}
		for(int i = 1; i <= n; i++)
		{
		    System.out.println("Distance from 1 to " + i + " = " + ans[i]);
		}
		
		
		// Topological Sort
		/*
		 * 1) Recursion --> Dynamic Programming
		 * 
		 * 	  Ta -------> Tb : Tb depends on Ta
		 * 
		 * 					   Finish Ta & go to Tb
		 * 
		 * Eg-1 :
		 * 
		 * 		Ta ---> Tb
		 * 		 |		 |
		 * 		Td ---> Tc
		 * 
		 * Order of Execution of Tasks
		 * 
		 * Note : Before we execute a Task, Resolve all it's Dependencies
		 * 
		 * Order : Ta	Td	  Tc	Tb
		 * 
		 * 	Dijkstra  → Shortest Path
		 * 
			BFS       → Shortest Path in Unweighted Graph
			
			Topological Sort → Ordering Tasks with Dependencies
		 * 
		 * 	You must complete prerequisites before dependent tasks.
		 * 
		 * 	When Can We Use Topological Sort?

			✅ Directed Graph

			✅ No Cycles (DAG)
			
			Def : Topological Sort is a linear ordering of vertices in a Directed Acyclic Graph (DAG) such that for every directed edge u → v, vertex u appears before vertex v in the ordering.
						
		 */
		
		/*  There are N courses.

			To take course B,
			you must first complete course A.

			Find an order in which all courses can be completed.
			
			Ans-1 : 1 2 3 4
			
			or
			
			Ans-2 : 1 3 2 4
			
			A quick way to recognize a Topological Sort question in an interview:

			Course prerequisites
			Task scheduling
			Build order of software modules
			Dependency resolution
			Job scheduling
			
			These almost always indicate Topological Sort.
			
		 * 
		 * Graph Representation 
		 * 
		 *          1
			       / \
			      v   v
			      2   3
			       \ /
			        v
			        4
			       / \
			      v   v
			      5   6
			      
		 * Adjacency List
		 * 
		 *  1 → 2, 3
			2 → 4
			3 → 4
			4 → 5, 6
			5 → -
			6 → -
		 * 
		 * Edge List 
		 * 
		 *  1 → 2
			1 → 3
			2 → 4
			3 → 4
			4 → 5
			4 → 6
			
		 *
		 * Indegree Table
		 * 
		 *  | Node | Indegree |
			| ---- | -------- |
			| 1    | 0        |
			| 2    | 1        |
			| 3    | 1        |
			| 4    | 2        |
			| 5    | 1        |
			| 6    | 1        |

		 *
		 *	Topological Sort (Kahn's Algorithm)
		 *	
		 *	Start with nodes having Indegree = 0:
		 *
		 *	Queue = [1]
		 *
		 *	Process :
		 *
		 *	| Step | Remove | Topological Order |
			| ---- | ------ | ----------------- |
			| 1    | 1      | 1                 |
			| 2    | 2      | 1 2               |
			| 3    | 3      | 1 2 3             |
			| 4    | 4      | 1 2 3 4           |
			| 5    | 5      | 1 2 3 4 5         |
			| 6    | 6      | 1 2 3 4 5 6       |

		 *	One valid answer:
		 *
		 *	1 2 3 4 5 6
		 *
		 *	Another valid answer:
		 *
		 *	1 3 2 4 6 5
		 *
		 *	Both are correct because:

			1 comes before 2 and 3
			2 and 3 come before 4
			4 comes before 5 and 6
			
			This is a Directed Acyclic Graph (DAG), so Topological Sort is possible.
				
		 */
		
		// Topological Sort
		int n1=6;
		
		int u1[]= {1,1,2,3,4,4};
		int v1[]= {2,3,4,4,5,6};
		
		ArrayList<Integer> ans1=Topological(n1,u1,v1);
		System.out.println();
		System.out.println("Topological Order: "); // TC = O(V + E)
												   // SC = O(V + E)
		for(int x:ans1)
		{
			System.out.print(x+" ");
		}
		
		// Khan's Algorithm
		
		/* Kahn's Algorithm is a BFS-based algorithm used to perform Topological Sorting on a Directed Acyclic Graph (DAG). 
		 * 
		 * It is also used to detect cycles in a directed graph by checking whether all vertices can be processed.
		 * 
		 * Eg : Topological Sort 
		 * 
		 * 1	->		3	->	 4	 ->		6
		 * 				|		 |	
		 * 				2		 5
		 * 
		 * 
		 * In Degree :	1	2	3	4	5	6
		 * 
		 * 				0	1	3	1	1	1
		 * 
		 * 					0	2
		 * 
		 * 						1
		 * 
		 * Tasks to Execute :	Issue : Code Stops, Only 2-Tasks Executed, because there is cycle among remaining Tasks. // Dead Lock //
		 *  
		 * --------
		 * 1	2
		 * --------
		 * 
		 * Obervation : Use above hint we can do Cycle Detection in Graph.
		 * 
		 * 				if all Tasks are not executed = Cycle Exists.
		 * 
		 * 
		 * 
		 */
		
		int n2=6;
		int e2=7;
		
		int u2[]= {1,1,2,3,4,4,5};
		int v2[]= {2,3,3,4,5,6,3};
		
		boolean ans3=KhansAlgo(n2,e2,u2,v2);
		System.out.println();
		System.out.println("Khan's Algorithm : "+ans3);
		
	}

	private static boolean KhansAlgo(int n2, int e2, int[] u2, int[] v2) 
	{
		ArrayList<ArrayList<Integer>> g=new ArrayList<>();
		
		for(int i=0;i<=n2;i++)
		{
			g.add(new ArrayList<>());
		}
		
		int ind[]=new int[n2+1];
		
		for(int i=0;i<e2;i++)
		{
			// u[i] ---> v[i]
			
			g.get(u2[i]).add(v2[i]);
			
			ind[v2[i]]++;
		}
		
		Queue<Integer> q=new LinkedList<>();
		
		for(int i=1;i<=n2;i++)
		{
			if(ind[i]==0)
			{
				q.add(i);
			}
		}
		
		int tasks=0;
		
		while(q.size()>0)
		{
			int u=q.poll();
			
			tasks++;
			
			for(int i=0;i<g.get(u).size();i++)
			{
				int v=g.get(u).get(i);
				ind[v]--;
				
				if(ind[v]==0)
				{
					q.add(v);
				}
			}
		}
		return tasks!=n2;
	}

	private static ArrayList<Integer> Topological(int n1, int[] u1, int[] v1) 
	{
		
		ArrayList<ArrayList<Integer>> gr=new ArrayList<>();
		
		for(int i=0;i<=n1;i++)
		{
			gr.add(new ArrayList<>());
		}
		
		// Graph Creation
		
		for(int i=0;i<u1.length;i++)
		{
			gr.get(u1[i]).add(v1[i]);
		}
		
		// Indegree Array
		
		int indegree[]=new int[n1+1];
		
		for(int i=1;i<=n1;i++)
		{
			for(int nbr:gr.get(i))
			{
				indegree[nbr]++;
			}
		}
		
		Queue<Integer> q = new LinkedList<>();
		
		// Push all nodes having indegree 0
		
		for(int i=1;i<=n1;i++)
		{
			if(indegree[i]==0)
			{
				q.add(i);
			}
		}
		
		ArrayList<Integer> topo=new ArrayList<>();
		
		while(q.size()>0)
		{
			int current=q.poll();
			
			topo.add(current);
			
			for(int nbr:gr.get(current))
			{
				indegree[nbr]--;
				
				if(indegree[nbr]==0)
				{
					q.add(nbr);
				}
			}
		}
		
		return topo; 
	}

	private static int[] Dijktras(int n, int e, int[] u, int[] v, int[] w, int s) // TC = O((V + E) log V)
	{																			  // SC = O(V + E)
		ArrayList<ArrayList<pair>> g=new ArrayList<>();
		
		for(int i=0;i<=n;i++)
		{
			g.add(new ArrayList<>());
		}
		
		for(int i=0;i<e;i++)
		{
			g.get(u[i]).add(new pair(v[i],w[i]));
			g.get(v[i]).add(new pair(u[i],w[i]));
		}
		
		int dist[]=new int[n+1];
		
		// Initially, we assume every node is unreachable.
		
		for(int i=0;i<=n;i++)
		{
			dist[i]=Integer.MAX_VALUE;// Integer.MAX_VALUE acts like ∞ (infinity).
		}
		
		dist[s]=0;// The shortest distance from the source to itself is 0.
		
		PriorityQueue<pair> pq=new PriorityQueue<>(new SortOwn());
		
		
		/*  The priority queue always gives the node with the smallest distance first.

			pair stores (node, distance).

			SortOwn compares pairs by distance.
			
			“Pick the closest unexplored node next.”
			
		 */
		
		pq.add(new pair(s,0));
		
		while(pq.size()>0)
		{
			pair p=pq.poll();
			
			int current=p.i;
			
			if(p.i>dist[current])// "If this queue entry is not the best known distance anymore, ignore it."
			{
				continue;// This single line prevents processing the same node repeatedly with worse distances and keeps Dijkstra efficient.
			}
			
			for(int i=0;i<g.get(current).size();i++)// Visit all neighbors of node 1.
			{
				pair t=g.get(current).get(i);
				
				int Neighbour=t.i,edgeweight=t.i;
				
				if(dist[current]+edgeweight<dist[Neighbour])
				{
					dist[Neighbour]=dist[current]+edgeweight;
					pq.add(new pair(Neighbour,dist[Neighbour]));
				}
			}
		}
		
		return dist;
	}

}
