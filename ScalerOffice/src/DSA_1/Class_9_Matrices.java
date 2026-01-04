package DSA_1;

import java.util.ArrayList;

public class Class_9_Matrices 
{

	public static void main(String[] args) 
	{
		
		/* Matrix :				  -----> Columns : Vertical
		 * 						  |
		 * int mat[][]=new int[4][5];
		 * 					   |
		 * 					   -----> Rows : Horizontal
		 * 
		 * Q) mat[N][M]
		 * 
		 * Observation :
		 * 1) Iterate on Row, Col Changes [0	M-1]
		 * 2) Iterate on Col, Row Changes [0	N-1]
		 * 
		 */
		int mat[][]= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
		
		// Q) Sum of All Elements in ith Row :
		int ans=SumOfIrow(mat);
		System.out.println("Sum of i^th Row Elements :"+ans);
		
		// Q) Print Sum of All MAtrix Elements
		int ans2=SumOfMatrix(mat);
		System.out.println("Sum of All Matrix Elements :"+ans2);
		
		// Q) Given Square Matrix[N][N], print Anti-Diagonal Elements.
		// {Top Right-->Bottom Left}, Rows=Cols
		
		/* N*N---> Anti Diagonal
		 * 
		 * mat[0][3] r++, c--
		 * mat[1][2] r++, c--	
		 * mat[2][1] r++, c--
		 * mat[3][0] r++, c--
		 * 
		 */
		printAntiDiag(mat);
		
		// Q) Given a Matrix[N][M], Print All Diagonals in a Matrix (Right to Left).
																//	(Top to Down).		
		/* Mat[4][5]
		 * 
		 * Total = N+M-1=5+4-1=8
		 * 
		 *   0	1	2	3	4
		 * 0 1	2	3	4	5
		 * 1 6	7	8	9	10
		 * 2 11	12	13	14	15
		 * 3 16	17	18	19	20
		 * 
		 * 
		 * Output:
		 * 1
		 * 2  6
		 * 3  7  11
		 * 4  8  12 16
		 * 5  9  13 17
		 * 10 14 18
		 * 15 19
		 * 20			
		 * 
		 * Observation : All Right to Left Diagonals Start at 0^th-Row and M-1^th Col
		 * 
		 * Function : Given Start of Right to Left Diagonal Print it.
		 * 
		 * Note : Start Points are all Elements in 0^th ROw & M-1^th Col.
		 * 
		 * 1) Take Every Cell in 0^th row as Start Point & Call Function.
		 * 2) Take Every Cell in M-1^th Col as Start Point & Call Function.
		 * 
		 */
		System.out.println();
		pritnAllAnti(mat);
		
		// Q) Given N*N Matrix:
		/*    Return All Right to Left Diagonals in ArrayList<ArrayList<>> --->2D-ArrayList
		 * Note : Each Diagonal Store it in a ArrayList
		 * Note : All ArrayList Should have same no : of Elements.
		 * Note : If a Particular ArrayList has Lesser Elements--->Add Them with 0.
		 * 
		 * N=4
		 * 
		 * 	 0	1	2	3
		 * 0 1	2	3	4	
		 * 1 6	7	8	9
		 * 2 10	11	12	13
		 * 3 14	15	16	17
		 * 
		 * o/p :
		 * 
		 * {
		 * 		{1,0,0,0}
		 * 		{2,6,0,0}
		 * 		{3,7,10,0}
		 * 		{4,8,11,14}
		 * 		{9,12,15,0}
		 * 		{13,16,0,0}
		 * 		{17,0,0,0}
		 * 
		 * }
		 * 
		 * Obs : Max Elements in a Diagonal= N
		 * 
		 */
		int matt[][]= {{1,2,3,4},
				     {6,7,8,9},
				     {11,12,13,14},
				     {16,17,18,19}
					};
	System.out.println("2D-ArrayList");	
	ArrayList<ArrayList<Integer>> a=printAllAnti2D(matt);
	System.out.println(a);
	// Or
	for(ArrayList<Integer> r:a)
	{
		System.out.println(r);
	}
	
	// Q) Row to Column Zero
	
	/* You are given a 2D integer matrix A.
	 * if A[i][j]=0 : Make all the elements in a i^th row & j^th Column Zero
	 * Note :
	 * 		 All Elements are > 0.
	 * 
	 * eg: Input mat[3][4]------------------------>Output
	 * 	 	0	1	2	3							0	1	2	3
	 * 0 |	5	3	2	9 | Rows : 1,2			0	5	3	0	0
	 * 1 |	2	1	2	0 |	Cols : 3,2			1	0	0	0	0
	 * 2 |	9	2	0	4 |						2	0	0	0	0
	 * 
	 */
	 int tr[][]= {{5,2,0,9},{3,2,2,1},{9,2,0,4}};
	 
	 /* Idea-1 : Iterate on Matrix,
	  * 				  if mat[i][j]==0:
	  * 					 Make All Elements of i^th row=0;
	  * 					 Make All Elements of j^th col=0;
	  * This Logic Won't Work
	  * 
	  * Note : Once we modify a Mat[][] Element with 0, We Won't know ,if it's Original 0 or modified 0.
	  * 
	  */
	 
	 /* Idea-2 : Iterate on Matrix,
	  * 					if mat[i][j]==0:
	  * 					   Make All Elements of i^th row=-1;
	  * 					   Make All Elements of j^th Col=-1;
	  * Note : Don't Replace 0 : Let it be, if we replace we might loose data.
	  * 
	  *  
	  *  Array ---> After Modifying -1 --->Replace -1 with o --> Output
	  *  
	  *  T.C= O(N*M[N+M])= O(N^2M+M^2N)
	  */
	 
	 /* Idea-3 : Optimization Code   --- 
	  * 
	  * 1) In a Row Even if single 0 is present entire row=0.
	  * 2) In a Col Even if single 0 is present entire col=0.
	  * 
	  * Row Wise :
	  * 	Iterate Row by Row :
	  * 	In a Row : If a Single Zero Present, Make All Non-Zero=-1,In That Row.
	  * 
	  * Col Wise :
	  * 	Iterate Col by Col
	  * 	In a Col : If a Single Zero Present, Make All Non-Zero=-1,In That Col.
	  *  
	  */
	 int anss[][]=makeZero(tr);
	 for(int a1[]:anss)
	 {
		 for(int x: a1)
		 {
			 System.out.print(x+" ");
		 }
		 System.out.println();
	 }
	 
	}
	
																					
	private static int[][] makeZero(int[][] ar) // T.C = O(N*2M + M*2N + M*N)=O(5NM)~_~=O(N*M)
	{											// S.C = O(1)
		 int n=ar.length;
		 int m=ar[0].length;
		 for(int i=0;i<n;i++)// Row by Row
		 {
			boolean ch=false;
			for(int j=0;j<m;j++)// For i^th row : Check if single 0 : present ?
			{
				if(ar[i][j]==0)
				{
					ch=true;
					break;
				}
			}
			if(ch)// i^th row contains atleast 1-zero : Replace all non zero with -1;
			{
				for(int j=0;j<m;j++)
				{
					if(ar[i][j]!=0)
					{
						ar[i][j]=-1;
					}
				}
			}
		 }
		 for(int j=0;j<m;j++)// Col by Col
		 {
			 boolean ch=false;
				for(int i=0;i<n;i++)// For j^th col : Check if single 0 : present ?
				{
					if(ar[i][j]==0)
					{
						ch=true;
						break;
					}
				}
				if(ch)// j^th col contains atleast 1-zero : Replace all non zero with -1;
				{
					for(int i=0;i<n;i++)
					{
						if(ar[i][j]!=0)
						{
							ar[i][j]=-1;
						}
					}
				}
			 
		  }
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 if(ar[i][j]==-1)
				 {
					 ar[i][j]=0;
				 }
			 }
		 }
		 return ar;
		 
	}


	private static ArrayList<ArrayList<Integer>> printAllAnti2D(int[][] matt) 
	{
		ArrayList<ArrayList<Integer>> ar=new ArrayList<>();
		int n=matt.length;
		
		for(int j=0;j<n;j++)
		{
			ArrayList<Integer> temp=AntiStartt(0,j,matt);// Start Cell (0,j)
			ar.add(temp);
		}
		for(int i=1;i<n;i++)
		{
			ArrayList<Integer> t=AntiStartt(i,n-1,matt);// Start cell (i,M-1)
			ar.add(t);
		}
		return ar;
	}


	private static ArrayList<Integer> AntiStartt(int r, int c, int[][] matt) // T.C=O(N^2)
	{																		 // S.C=O(N^2)
		 ArrayList<Integer> ar=new ArrayList<>();
		 int n=matt.length;
		 while(r<n && c>=0)
		 {
			 ar.add(matt[r][c]);
			 r++;
			 c--;
		 }
		 int z=n-ar.size();// These Many Zeros we need to Add
		 for(int i=0;i<z;i++)
		 {
			 ar.add(0);
		 }
	   return ar;	 
	}


	private static void pritnAllAnti(int[][] mat) //O(N)-->TC & SC
	{ 
		int n=mat.length;
		int m=mat[0].length;
		
		for(int j=0;j<m;j++)//Cols are Changing
		{
			//Start Cell(0,j)
			AntiStart(0,j,mat);
		}
		for(int i=1;i<n;i++)//Rows are Changing
		{
			AntiStart(i,m-1,mat);
		}
	}

	private static void AntiStart(int i, int j, int[][] mat) 
	{ 
		int n=mat.length;
		while(i<n && j>=0)
		{
			System.out.print(mat[i][j]+" ");
			i++;
			j--;
		}
		System.out.println();
	}

	private static void printAntiDiag(int[][] mat) // T.C =O(N)
	{ 											   // S.C =O(1)
		int n=mat.length;
		int r=0,c=n-1;
		while(r<n && c>=0)// Only if both are valid,This is a Valid Cell.
		{
			System.out.println(mat[r][c]);
			r++;
			c--;
		}
	}

	private static int SumOfMatrix(int[][] mat) // T.C =O(M*N)
	{											// S.C =O(1)
		 int n=mat.length;
		 int m=mat[0].length;
		 int sum=0;
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 sum=sum+mat[i][j];
			 }
		 }
		 return sum;
	}

	private static int SumOfIrow(int[][] mat) // T.C = O(M)
	{										  // S.C = O(1)
		int r=mat.length;
		int c=mat[0].length;
		int sum=0;
		int j=0;
		for(int i=0;i<c;i++)
		{
			sum=sum+mat[j][i];
		}
		return sum;
	}

}
