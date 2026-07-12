package Graphs_OneStopSolution;

public class NumberOfislands 
{

	public static void main(String[] args) 
	{
		 /*
		  * Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.

			More formally, from any cell (i, j) if A[i][j] = 1 you can visit:
			
			(i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
			(i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
			(i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
			(i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
			(i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
			(i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
			(i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
			(i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
			Return the number of islands.
			
			NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
			
		  */
		
		 int A[][]= {{0,1,0},{0,0,1},{1,0,0}}; // O/P = 3 (for 4-direction)
		 
		 int ans1=islands1(A);
		 System.out.println("Islands with 4-Sides : "+ans1);
		 
		 int B[][]= {{0,1,0},{0,0,1},{1,0,0}}; // O/P = 2 (for 8-direction)
		 
		 int ans2=islands2(B);
		 System.out.println("Islands with 8-Sides : "+ans2);
		 
		 /*
		  *           Up
			      (i-1, j)
			          ↑
			          |
			Left ←   (i, j)   → Right
			(i, j-1)          (i, j+1)
			          |
			          ↓
			      (i+1, j)
			         Down
			         
			         
			 
			 
			 Yes. In the direction arrays:

			   -1 → Move one step backward (decrease by 1).
				0 → No change.
				1 → Move one step forward (increase by 1).
			         
		  */
		 System.out.println();
		 
		 int C[][]= {{0,1,0},{0,0,1},{1,0,0}}; // O/P = 3 (for 4-direction)
		 
		 int ans3=islands3(C);
		 System.out.println("Islands with 4-Sides : "+ans3);
		 
		 int D[][]= {{0,1,0},{0,0,1},{1,0,0}}; // O/P = 3 (for 4-direction)
		 
		 int ans4=islands4(D);
		 System.out.println("Islands with 8-Sides 8 : "+ans4);
		 
		 /*
		  * Interview Answer

			If an interviewer asks "What's the time and space complexity?", you can confidently answer:
			
			Time Complexity: O(N × M), because every cell in the matrix is visited at most once. Although DFS explores neighbors, each land cell is marked as visited and never processed again.
			
			Space Complexity: O(N × M) in the worst case due to the recursion stack, such as when the entire matrix is one large island.
		  */
		 
		 /*
		  * | Method                                  | Time Complexity | Space Complexity                          |
			| --------------------------------------- | --------------- | ----------------------------------------- |
			| `islands1()` (4-direction DFS)          | **O(N × M)**    | **O(N × M)** (worst-case recursion stack) |
			| `islands2()` (8-direction DFS)          | **O(N × M)**    | **O(N × M)** (worst-case recursion stack) |
			| `islands3()` (4-direction using arrays) | **O(N × M)**    | **O(N × M)** (worst-case recursion stack) |
			| `islands4()` (8-direction using arrays) | **O(N × M)**    | **O(N × M)** (worst-case recursion stack) |

		  */
	}

	private static int islands4(int[][] c) 
	{
		 int n=c.length;
		 int m=c[0].length;
		 
		 int a=0;
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 if(c[i][j]==1)
				 {
					 dfs4(i,j,c);
					 a++;
				 }
			 }
		 }
		 
		 return a;
	}

	private static void dfs4(int i, int j, int[][] c) 
	{
		c[i][j]=0;
		
		int x[]= {-1,-1,-1,0,0,1,1,1};
		int y[]= {-1,0,1,-1,1,-1,0,1};
		
		int n=c.length;
		int m=c[0].length;
		
		for(int l=0;l<8;l++)
		{
			int dr=i+x[l];
			int dc=j+y[l];
			
			if(dr>=0 && dr<n && dc>=0 && dc<m && c[dr][dc]==1) 
			{
				dfs4(dr,dc,c);
			}
		}
		return;
				
	}

	private static int islands3(int[][] a) 
	{
		 int n=a.length;
		 int m=a[0].length;
		 
		 int c=0;
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 if(a[i][j]==1)
				 {
					 dfs3(i,j,a);
					 c++;
				 }
			 }
		 }
		 
		 return c;
	}

	private static void dfs3(int i, int j, int[][] a) 
	{
		 a[i][j]=0;
		 
		 int x[]= {-1,1,0,0};
		 int y[]= {0,0,-1,1};
		 
		 int n=a.length;
		 int m=a[0].length;
		 
		 for(int l=0;l<4;l++)
		 {
			 int ni=i+x[l];
			 int nj=j+y[l];
			 
			 if(ni>=0 && ni<n && nj>=0 && nj<m && a[ni][nj]==1)
			 {
				 dfs3(ni,nj,a);
			 }
		 }
		 return;
	}

	private static int islands2(int[][] a) 
	{
		 int r=a.length;
		 int c=a[0].length;
		 
		 int islands=0;
		 
		 for(int i=0;i<r;i++)
		 {
			 for(int j=0;j<c;j++)
			 {
				 if(a[i][j]==1)
				 {
					 islands++;
					 DFS2(a,i,j,r,c);
				 }
			 }
		 }
		 return islands; 
	}

	private static void DFS2(int[][] a, int i, int j, int r, int c) 
	{
		 if(i<0 || i>=r || j<0 || j>=c)
		 {
			 return; // Water or already visited
		 }
		 
		 if(a[i][j]==0)// DFS stops there instead of visiting it again.
		 {
			 return; // Mark current land as visited
		 }
		 
		 a[i][j]=0;
		 
		// 4 directions
		 
		 DFS2(a,i-1,j,r,c);
		 DFS2(a,i+1,j,r,c);
		 DFS2(a,i,j-1,r,c);
		 DFS2(a,i,j+1,r,c);
		
		// 4 diagonals
		 
		 DFS2(a,i-1,j-1,r,c);
		 DFS2(a,i+1,j-1,r,c);
		 DFS2(a,i-1,j+1,r,c);
		 DFS2(a,i+1,j+1,r,c);
	}

	private static int islands1(int[][] a) 
	{
		 int r=a.length;
		 int c=a[0].length;
		 
		 int islands=0;
		 
		 for(int i=0;i<r;i++)
		 {
			 for(int j=0;j<c;j++)
			 {
				 if(a[i][j]==1)
				 {
					 islands++;
					 DFS(a,i,j,r,c);
				 }
			 }
		 }
		 return islands;
	}

	private static void DFS(int[][] a, int i, int j, int r, int c) 
	{
		 if(i<0 || i>=r || j<0 || j>=c)
		 {
			 return;
		 }
		 
		 if(a[i][j]==0)
		 {
			 return;
		 }
		 
		 a[i][j]=0;
		 
		 DFS(a,i-1,j,r,c);
		 DFS(a,i+1,j,r,c);
		 DFS(a,i,j-1,r,c);
		 DFS(a,i,j+1,r,c);
	}

}
