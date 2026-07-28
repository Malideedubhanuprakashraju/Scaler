package Graphs_OneStopSolution;

import java.util.LinkedList;
import java.util.Queue;

class Pair1
{
	int row,col;
	
	public Pair1(int a,int b)
	{
		this.row=a;
		this.col=b;
	}
}
public class RottenOranges 
{

	public static void main(String[] args) 
	{
		 /* Rotten Oranges
		  * 
		  * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.

			Each cell can have three values:
			
			The value 0 representing an empty cell.
			
			The value 1 representing a fresh orange.
			
			The value 2 representing a rotten orange.
			
			Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
			
			Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
		  */
		
		/*
		 *  Step 1  : Create Pair Class
			Step 2  : Find n and m
			Step 3  : Create Queue
			Step 4  : fresh = 0
			Step 5  : Traverse Matrix
			Step 6  : Add all Rotten Oranges to Queue
			Step 7  : Count Fresh Oranges
			Step 8  : If fresh == 0 return 0
			Step 9  : Create 4 Direction Arrays
			Step 10 : minutes = 0
			Step 11 : while(queue not empty)
			Step 12 : size = queue.size()
			Step 13 : Process current level
			Step 14 : poll() one orange
			Step 15 : Visit 4 neighbours
			Step 16 : Check valid fresh orange
			Step 17 : Make it rotten
			Step 18 : fresh--
			Step 19 : Add into queue
			Step 20 : minutes++
			Step 21 : Return minutes or -1
		 */
		
		int ar[][]= {{2,1,1},{1,1,0},{0,1,1}};
		
		int minTime=RottenOranges(ar);
		System.out.println("Minimum Time "+minTime);
	}

	private static int RottenOranges(int[][] ar) // T.C = O(N × M)
	{											 // S.C = O(N × M)
		int n=ar.length;
		int m=ar[0].length;
		
		Queue<Pair1> q=new LinkedList<>();
		
		int fresh=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(ar[i][j]==2)
				{
					q.offer(new Pair1(i,j));
				}
				else if(ar[i][j]==1)
				{
					fresh++;
				}
			}
		}
		if(fresh==0)
		{
			return 0;
		}
		
		int rowD[]= {-1,1,0,0};// Top	Down	Left	Right
		int colD[]= {0,0,-1,1};
		
		/*
		 *         Top
			      (-1,0)
			
			Left             Right
			(0,-1)          (0,+1)
			
			      (+1,0)
			      Bottom
		*/
		
		int minutes=0;
		while(!q.isEmpty())
		{
			int size=q.size();
			
			boolean rottenThisMinute=false;
			
			for(int i=0;i<size;i++)
			{
				Pair1 current=q.poll();
				
				for(int k=0;k<4;k++)
				{
					int newRow=current.row+rowD[k];
					int newCol=current.col+colD[k];
					
					if(newRow>=0 && newRow<n && newCol>=0 &&newCol<m && ar[newRow][newCol]==1)
					{
						ar[newRow][newCol]=2;
						
						fresh--;
						
						q.offer(new Pair1(newRow,newCol));
						
						rottenThisMinute=true;
					}
				}
			}
			if(rottenThisMinute)
			{
				minutes++;
			}
			
		}
		
		if(fresh==0)
		{
			return minutes;
		}
		
		return -1;
	}

}
