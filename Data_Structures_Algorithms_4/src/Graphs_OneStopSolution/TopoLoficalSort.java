package Graphs_OneStopSolution;

public class TopoLoficalSort 
{

	public static void main(String[] args) 
	{
		 /*
		  * Shortest Route?
			      ↓
			  Dijkstra 🚗
			
			Connect Everything Cheaply?
			      ↓
			     Prim 🔌
			
			Task Order?
			      ↓
			     Kahn 📚
		  */
		
		/*
		 * Topological Sorting
		        │
		        ├── DFS-based Topological Sort
		        │
		        └── Kahn's Algorithm (BFS-based Topological Sort)
		 */
		
		/*
		 * Topological Sort = Destination

			        ▲
			        │
			 ┌──────┴──────┐
			 │             │
			DFS Method   Kahn's Algorithm
			
		 */
		
		/*
		 * 	| Topological Sort using DFS        | Kahn's Algorithm                            |
			| --------------------------------- | ------------------------------------------- |
			| Uses DFS + Stack                  | Uses BFS + Queue/PriorityQueue              |
			| Doesn't calculate indegree        | Uses indegree array                         |
			| Cycle detection needs extra logic | Easy cycle detection (`result.size() != V`) |
			| O(V + E)                          | O(V + E)                                    |

		 */
		
		/*
		 *  | Algorithm            | Think of it as                            | Data Structure                                                |
			| -------------------- | ----------------------------------------- | ------------------------------------------------------------- |
			| **BFS**              | Explore **level by level**                | Queue                                                         |
			| **DFS**              | Go **deep first**, then backtrack         | Stack / Recursion                                             |
			| **Kahn's Algorithm** | BFS on a DAG using **indegree = 0** nodes | Queue (or PriorityQueue for lexicographically smallest order) |

		 */
	}

}
