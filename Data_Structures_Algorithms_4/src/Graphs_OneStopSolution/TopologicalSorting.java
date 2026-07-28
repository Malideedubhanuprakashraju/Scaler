package Graphs_OneStopSolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopologicalSorting 
{

	public static void main(String[] args) 
	{
		// Def : Topological Sort is a linear ordering of the vertices of a Directed Acyclic Graph (DAG) such that for every edge u → v, vertex u appears before vertex v.
		
		// No DAG ⇒ No Topological Sort.
		
		/*
		 *  A → B → D
			↓
			C → D 
		 */
		
		/*
		 * Topological Sort requires every directed edge u → v to have u appear before v. 
		 * 
		 * If the graph contains a cycle, such an ordering is impossible because each vertex in the cycle depends on another vertex in the same cycle. Therefore, Topological Sort is possible only for Directed Acyclic Graphs (DAGs).
		 */
		
		// Q1) Topological Sort
		/*
		 * Given an directed acyclic graph having A nodes. 
		 * 
		 * A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
		 * 
		 * Return the topological ordering of the graph and if it doesn't exist then return an empty array.
		 * 
		 * If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.

			Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
		 * 
		 * 
		 *  The key idea of Kahn's Algorithm

			At every iteration:
			
			Pick a vertex with In-Degree = 0 (it has no remaining dependencies).
			Add it to the answer.
			Delete all outgoing edges from that vertex.
			Some neighboring vertices may now have In-Degree = 0.
			Add those vertices to the queue.
			Repeat until the queue is empty.
			
			Think of it like removing tasks that are ready to execute. 
			Once a task is completed, its dependent tasks may become ready next. 
			This is exactly why Kahn's algorithm naturally produces a valid topological ordering.
		 * 
		 * 
		 */
		
		int A=6;
		
		int B[][]= {{6,3},{6,1},{5,1},{5,2},{3,4},{4,2}};
		
		
		degrees(A,B);
		
		int ans[]=Topological(A,B);
		for(int x:ans)
		{
			System.out.print(x+" ");
		}
		
		/*
		 * If the problem simply asks "Return any topological ordering" → use Queue.
		 * 
		   If the problem says "Return the lexicographically smallest topological ordering" (like Scaler) → use PriorityQueue.
		 */
		
	}

	private static int[] Topological(int a, int[][] b) // Time Complexity — O(V + E + V log V) (because of PriorityQueue)
	{												   // Space Complexity — O(V + E)
		ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
		
		for(int i=0;i<=a;i++)
		{
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<b.length;i++)
		{
			int u=b[i][0];
			int v=b[i][1];
			
			graph.get(u).add(v);
		}
		
		// Calculating Indegree
		
		int ind[]=new int[a+1];
		
		for(int i=0;i<b.length;i++)
		{
			int u=b[i][0];
			int v=b[i][1];
			
			ind[v]++; // Indegree  count arrows entering a vertex.
		}
		
		// Put all Indegree-0 vertices into the Queue
		
	//	Queue<Integer> q=new LinkedList<>();// Normal Topological 
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int i=1;i<=a;i++)
		{
			if(ind[i]==0)
			{
				q.add(i);
			}
		}
		 
		// Create Answer Array
		
		int ans[]=new int[a];
		
		int index=0;
		
		// BFS (Kahn's Algorithm)
		
		while(!q.isEmpty())
		{
			int current=q.poll();
			
			ans[index++]=current;
			
			for(int nei:graph.get(current))
			{
				ind[nei]--;
				
				if(ind[nei]==0)
				{
					q.add(nei);
				}
			}
		}
		
		// index stores the number of vertices processed. If index != A, some vertices could not be processed because they are part of a cycle, so a valid topological ordering does not exist, and we return an empty array.
		
		if(index!=a)
		{
			return new int[0];
		}
		
		return ans;
	}

	private static void degrees(int a, int[][] b) 
	{
		ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
		
		for(int i=0;i<=a;i++)
		{
			graph.add(new ArrayList<>());
		}
		
		for(int i=0;i<b.length;i++)
		{
			int u=b[i][0];
			int v=b[i][1];
			
			graph.get(u).add(v);
		}
		
		// Calculating incoming Edges
		
		int indegre[]=new int[a+1];
		int[] outDegree = new int[a + 1];
		
		for(int i=0;i<b.length;i++)
		{
			int u=b[i][0];
			int v=b[i][1];
			
			indegre[v]++;
			outDegree[u]++;
		}
		
		// Printing Degrees
		
		for(int i=1;i<indegre.length;i++)
		{
			System.out.println(indegre[i]+" "+outDegree[i]);
		}
	}

}
