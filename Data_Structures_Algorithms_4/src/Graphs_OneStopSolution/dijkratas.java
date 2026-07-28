package Graphs_OneStopSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// Create Pair Class
class Pair
{
	int node;
	int weight;
	
	public Pair(int n,int w)
	{
		this.node=n;
		this.weight=w;
	}
}

public class dijkratas 
{

	public static void main(String[] args) 
	{
		 // What is Dijkstra's Algorithm?
		 /*
		  * Dijkstra's Algorithm is a graph algorithm used to find the shortest path from one source vertex to all other vertices in a weighted graph, provided all edge weights are non-negative.
		  * 
		  * Def : Dijkstra's Algorithm finds the minimum (shortest) distance from a source node to every other node in a weighted graph.
		  * 
		  * Simple Explanation

			Imagine you're standing at one city and want to know the shortest distance to every other city.

			Dijkstra's algorithm starts from your city and always chooses the nearest unvisited city, updating the shortest known distances as it explores the graph.
		  * 
		  */
		
		int A=6;
		
		int[][] B = {
                {0, 4, 9},
                {3, 4, 6},
                {1, 2, 1},
                {2, 5, 1},
                {2, 4, 5},
                {0, 3, 7},
                {0, 1, 1},
                {4, 5, 7},
                {0, 5, 1}
        };
		
		int C = 4;// Source Vertex
		
		int[] ans = Dijkratas(A, B, C);
		
		for(int x:ans)
		{
			System.out.print(x+" ");
		}

		/* T.C
		 *  Graph Creation      : O(V)
			Adding Edges        : O(E)
			Distance Array      : O(V)
			Dijkstra            : O((V + E) log V)
			
			Overall TC = O((V + E) log V)
		 */
		
		/* S.C
		 * 
		 *  Adjacency List : O(V + E)
			Distance Array : O(V)
			Priority Queue : O(E)
			
			Total SC = O(V + E)
		 * 
		 * 
		 *  Why is Dijkstra's Time Complexity O((V + E) log V)?

			It comes from two operations:
			
			Removing a node from the Priority Queue (poll())
			Adding a node to the Priority Queue (offer())
			
			Each poll() and offer() operation on a priority queue takes O(log V) time.
		 */
	}

	private static int[] Dijkratas(int a, int[][] b, int c) 
	{
		 ArrayList<ArrayList<Pair>> graph=new ArrayList<>();
		 
		 // Create Graph
		 for(int i=0;i<a;i++)
		 {
			 graph.add(new ArrayList<>());
		 }
		 
		 // Add Edges
		 for(int i=0;i<b.length;i++)
		 {
			 int u=b[i][0];
			 int v=b[i][1];
			 int w=b[i][2];
			 
			 graph.get(u).add(new Pair(v,w));
			 graph.get(v).add(new Pair(u,w));
		 }
		 
		 // Distance Array
		 
		 int distanace[]=new int[a];
		 
		 Arrays.fill(distanace,Integer.MAX_VALUE);
		 
		 // Priority Queue
		 
		 PriorityQueue<Pair> pq=new PriorityQueue<>((e,d)->e.weight-d.weight);
		 /*
		  * If a.weight < b.weight → a comes first.
			If a.weight > b.weight → b comes first.
			If a.weight == b.weight → both have equal priority.
			
			This makes the PriorityQueue behave as a min-heap, which is exactly what Dijkstra's algorithm needs.
			
			PriorityQueue<Integer> → Already a min heap (natural ordering).
			PriorityQueue<Pair> → Still a min heap, but you must tell Java what "minimum" means by providing a comparator (or by making Pair implement Comparable).
		  */
		 
		 // Source Distance = 0
		 
		 distanace[c]=0;
		 
		 // Create Priority Queue
		 
		 pq.offer(new Pair(c,0));
		 
		 while(!pq.isEmpty())
		 {
			 Pair current=pq.poll();
			 
			 int node=current.node;
			 int dist=current.weight;
			 
			 if(dist>distanace[node])
			 {
				 continue;
			 }
			 
			 for(Pair neigh:graph.get(node))
			 {
				 int adjNode=neigh.node;
				 int edgeWeight=neigh.weight;
				 
				 if(dist+edgeWeight < distanace[adjNode])
				 {
					 distanace[adjNode]=dist+edgeWeight;
					 
					 pq.offer(new Pair(adjNode, distanace[adjNode]));
				 }
			 }
		 }
		 
		 for(int i=0;i<a;i++)
		 {
			 if(distanace[i]==Integer.MAX_VALUE)
			     distanace[i]=-1;
		 }
		 
		return distanace; 
		 
	}

}
