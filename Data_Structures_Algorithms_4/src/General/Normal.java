package General;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Normal 
{

	public static void main(String[] args) 
	{
		// Construction of a Undirected Graph
		
		/*
		 * 			3
		 * 	1				4
		 * 
		 * 			2
		 * 
		 * 			5
		 *   
		 */
		
		int n=5;
		
		ArrayList<ArrayList<Integer>> gr=new ArrayList<>();
		
		for(int i=0;i<=n;i++)
		{
			gr.add(new ArrayList<>());
		}
		
		gr.get(1).add(3);
		gr.get(3).add(1);
		
		gr.get(1).add(2);
		gr.get(2).add(1);
		
		gr.get(1).add(5);
		gr.get(5).add(1);
		
		gr.get(3).add(4);
		gr.get(4).add(3);
		
		gr.get(4).add(5);
		gr.get(5).add(4);
		
		for(ArrayList<Integer> x:gr)
		{
			for(int y:x)
			{
				System.out.print(y+" ");
			}
		}
		
		System.out.println("Another Version : ");
		
		System.out.println();
		
		for(int i=1;i<=n;i++) 
		{
			System.out.print(i+" -> ");
			
			for(int y:gr.get(i))
			{
				System.out.print(y+" ");
			}
			
			System.out.println();
		}
		
		// Depth First Search
		
		boolean vis[]=new boolean[n+1];
		
		System.out.println("DFS Traversal : ");
		
		dfs(1,gr,vis);// DFS is a recursive function, so you must tell it the starting node explicitly.
		
		System.out.println();
		
		System.out.println("BFS Traversal : ");
		
		bfs(gr);// In BFS, the starting node is inserted into the queue:
		
		System.out.println();
		
		/*
		 * 	| DFS                                                              | BFS                                         |
			| ---------------------------------------------------------------- | ------------------------------------------- |
			| Depth First Search                                               | Breadth First Search                        |
			| Goes deep first                                                  | Goes level by level                         |
			| Uses Stack / Recursion                                           | Uses Queue                                  |
			| Output: `1 3 4 5 2`                                              | Output: `1 3 2 5 4`                         |
			| Good for cycle detection, connected components, topological sort | Good for shortest path in unweighted graphs |
 
		 */
		
		/*
		 * Yes. **Adjacency List** is not the only way to represent a graph.

The two most common representations are:

## 1. Adjacency List ✅ (Most Common)

For your graph:

```text
1 - 3
1 - 2
1 - 5
3 - 4
4 - 5
```

Representation:

```text
1 -> 3 2 5
2 -> 1
3 -> 1 4
4 -> 3 5
5 -> 1 4
```

Java:

```java
ArrayList<ArrayList<Integer>> gr = new ArrayList<>();
```

### Complexity

| Operation                | Complexity   |
| ------------------------ | ------------ |
| Store Graph              | O(V + E)     |
| Check if edge u-v exists | O(degree(u)) |
| Traverse neighbors       | O(degree(u)) |

---

## 2. Adjacency Matrix

Store graph in a 2D array.

### Matrix

```text
    1 2 3 4 5
1   0 1 1 0 1
2   1 0 0 0 0
3   1 0 0 1 0
4   0 0 1 0 1
5   1 0 0 1 0
```

Java:

```java
int[][] gr = new int[n+1][n+1];

gr[1][3] = 1;
gr[3][1] = 1;

gr[1][2] = 1;
gr[2][1] = 1;

gr[1][5] = 1;
gr[5][1] = 1;

gr[3][4] = 1;
gr[4][3] = 1;

gr[4][5] = 1;
gr[5][4] = 1;
```

### Complexity

| Operation          | Complexity |
| ------------------ | ---------- |
| Store Graph        | O(V²)      |
| Check edge u-v     | O(1)       |
| Traverse neighbors | O(V)       |

---

## 3. Edge List

Store only edges.

```text
(1,3)
(1,2)
(1,5)
(3,4)
(4,5)
```

Java:

```java
ArrayList<int[]> edges = new ArrayList<>();

edges.add(new int[]{1,3});
edges.add(new int[]{1,2});
edges.add(new int[]{1,5});
edges.add(new int[]{3,4});
edges.add(new int[]{4,5});
```

### Complexity

| Operation          | Complexity |
| ------------------ | ---------- |
| Store Graph        | O(E)       |
| Check edge u-v     | O(E)       |
| Traverse neighbors | O(E)       |

Used in algorithms like **Kruskal's MST**.

---

## 4. Weighted Adjacency List

If edges have weights:

```text
1 --5--> 3
1 --2--> 2
```

Java:

```java
class Pair {
    int v, w;

    Pair(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

ArrayList<ArrayList<Pair>> gr = new ArrayList<>();
```

Used in:

* Dijkstra
* Prim's MST
* Bellman-Ford

---

## Which One is Used Most?

For interviews and competitive programming:

```text
Adjacency List  → 95% of graph problems
Adjacency Matrix → Dense graphs, quick edge lookup
Edge List → MST algorithms
```

For DFS and BFS, **Adjacency List is usually the best choice** because:

* Space: `O(V + E)`
* DFS: `O(V + E)`
* BFS: `O(V + E)`

whereas an adjacency matrix would make DFS/BFS effectively scan entire rows and take `O(V²)` in the worst case. Hence most graph traversal implementations use an **Adjacency List**. ✅

		 */
	}

	private static void bfs(ArrayList<ArrayList<Integer>> gr) 
	{
		 boolean vis[]=new boolean[gr.size()];
		 
		 Queue<Integer> q=new LinkedList<>();
		 
		 q.add(1);
		 vis[1]=true;
		 
		 while(q.size()>0)
		 {
			 int u=q.poll();
			 
			 System.out.print(u+" ");
			 
			 for(int v:gr.get(u))
			 {
				 if(vis[v]==false)
				 {
					 vis[v]=true;
					 q.add(v);
				 }
			 }
		 }
	}

	// u -> Current Node
	
	// v -> Adjacent Vertex
	
	private static void dfs(int u, ArrayList<ArrayList<Integer>> gr, boolean[] vis) 
	{
		vis[u]=true;
		
		System.out.print(u+" ");
		
		for(int v:gr.get(u))
		{
			if(vis[v]==false)
			{
				dfs(v,gr,vis);
			}
		}
	}

}
