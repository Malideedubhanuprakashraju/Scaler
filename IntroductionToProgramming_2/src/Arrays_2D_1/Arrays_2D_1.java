package Arrays_2D_1;

import java.util.Scanner;

public class Arrays_2D_1 
{

	public static void main(String[] args) 
	{ 
		/* 2D arrays:
		 * A two-dimensional array is an array of arrays 
		 * i.e., it's a collection of arrays in which elements are arranged in rows and columns (tabular format).
		 * Syntax:
		 * datatype name[][]= new datatype[rows][columns].
		 * Here the DataType describes the type of values that the array can store,
		   while the name is the name of the 2D matrix.
		 * new datatype[r][c] statement creates a two dimensional array object that contains
		 * total number of rows and columns.
		 * Example:
		 * Create a 2D matrix of int type with 3 rows and 5 columns.
		 * Code:
		 * int mat[][]=new int[3][5];
		 * 	Index	0	1	2	3	4
				0	0	0	0	0	0
				1	0	0	0	0	0
				2	0	0	0	0	0
		 * Note:
		 * When we create a 2D matrix of int type, by default all the values are 0.
		 * In Java, Indexing starts from 0.
		 * To access ith row and jth column element= name[i][j].
		 * If we pass an index that is greater than the size of the array (out of bounds index), the ArrayIndexOutOfBoundsException error will occur.
		 * For Example,
		 * mat[1][2]=20;
		   mat[2][3]=30;
		 * mat[3][4]-> Error/IndexOutOfBound.
		 * 	Index	0	1	2	3	4
				0	0	0	0	0	0
				1	0	0	20	0	0
				2	0	0	0	30	0
		 * Indexing in a matrix starts from 0.
		 * Properties:
		 * when we create a matrix,
		   name.length-> Total number of rows.
		   name[0].length-> Total number of columns.
		 * Example:
		 * int[][] mat=new int[3][4];
		   System.out.println(mat.length);
		   System.out.print(mat[0].length);

		 * Output:
		 * [Success] Your code was executed successfully
		   3
		   4

		 * How to Read input in a matrix:
		 * for(int i=0;i<2;i++)
		 * {
 				for(int j=0;j<2;j++)
 				{
   					// ith row and jth col elememnt 
   					mat[i][j] = sc.nextInt();
 				}
		   }

		 * Example;
		 *  {12}	{14}
			{20}	{21}	

		 * Dry Run
		 * 	i	j	mat[i][j]
			0	0	12
				1	14
				2	false
			1	0	20
				1	21
				2	false
			2	false	
		 * 
		 */
		
		/* Introduction :
		 * Why do we use excel sheets ?
		 * Data in Structured Manner
		 * eg:
		 * Table= Rows   &  Columns
		 * 		   |		  |
		 *    Horizontal	Vertical
		 *    
		 *  Q) Say we want to store marks of 2-Students in Maths/Science/English/History
		 *  Data :	Maths	Science		English		History	
		 *  
		 *  Stud-1	19		  24		  21		  16
		 *  
		 *  Stud-2	15		  20		  19		  18
		 *  
		 *  Way-1 :
		 *  Array[] for each Student
		 *  
		 *  s1:	19, 24, 21, 16
		 *  s2: 15, 20, 19, 18
		 *  
		 *  Way-2 :
		 *  2D Arrays/Matrix
		 *  
		 *  	0	1	2	3
		 *  s1  19	24	21	16
		 *  
		 *  s2	15	20	19	18
		 *  	
		 */
		
		/* 1D-Arrays : datatype[] name=new int[size];
		 * 
		 * 2D-Arrays : datatype[][] name=new datatype[row][cols];
		 * {Combining multiple 1D Arrays, each row is 1D row}
		 * 
		 * Indirectly in 2D Array each element is a 1D Array.
		 * 
		 * int[][] mat=new int[N][M];--->M-Columns{Vertical}
		 * 					   |
		 * 					   --->N-Rows{Horizontal}
		 * 
		 * 
		 * Indexing Property :
		 * int[][] mat=new int[N][M];
		 * 
		 * 					0	1	2	.	.	j	.	.	.	M-1
		 * 	mat[0][0]	0										mat[0][M-1]
		 * 				1
		 * 				2
		 * 				3
		 * 				.
		 * 				.
		 * 				.
		 * 				i					  (i,j)			   (i,M-1) //In Row : Column Changes[0...M-1]	
		 * 				.
		 * 				.
		 * 	mat[N-1][0]	N-1					(N-1,j)			   mat[N-1][M-1]
		 * 									   |
		 * 									   ---->In Col : Row Changes[0,N-1];	
		 * 
		 */
		
		/* Length :
		 * 
		 * int[][] mat=new int[N][M];
		 * 
		 * mat.length;// It will give us no:of rows-->1D Arrays : N:rows
		 * mat[0].length;// It will give us no:of columns
		 * mat[1].length;
		 * .				}
		 * 						}Any mat[row].length=M Columns
		 * .				}
		 * mat[N-1].length;
		 * 
		 * Taking input from user :
		 * 
		 * 1st-Line : N{row},M{col}
		 * Followed by N Lines,each line contains single row data.
		 * 
		 */
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter No of Rows :");
		int N=sc.nextInt();
		System.out.println("Enter No of Cols :");
		int M=sc.nextInt();
		
		int[][] mat=new int[N][M];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				mat[i][j]=sc.nextInt();
			}
		}
		print2D(mat);
		
		// Q) Given a Matrix[N][M] print-->0th Row
		print0thRow(mat);
		
		// Q) Given a Matrix[N][M] print row by row
		int mat1[][]= {{1,2,3},{4,5,6},{7,8,9}};
		print2D(mat1);
		
		// Q) Given a Matrix[N][M] print row by row in wave :
		// Idea : 
		//Even Row : Columns will go from 0...M-1
		//Odd Row : Columns will go from M-1...0
		printWaveRow(mat1);
		
		// Q) Given a Matrix[N][M] print 0th Column
		print0thCol(mat1);
		
		// Q) Given a Matrix[N][M] print col by col in each line.
		printColbyCol(mat1);
		
		// Q) Given a Matrix[N][M] print col by col in wave.
		// Idea :
		// Even Coloumn : row will go from 0-N-1
		// Odd Coloumn : row will go from N-1-0
		System.out.println();
		printWaveCol(mat1);
		
		// Q) Given a Matrix[N][M] return Max of Matrix[][]
		// Idea : Initialize ans=-infinity, Compare ans with every mat[i][j]
		// if mat[i][j]>ans
		//update ans=mat[i][j];
		int ans=printMaxMatrix(mat1);
		System.out.println("Max Elem : "+ans);
		
		// Q) Given a Matrix[N][M] return an Array[] Containing max of Every Row:
		// Idea :
		// For Every Row iterate & Calculate Max & Store at Row Index.
		int ans1[]=printMaxRow(mat1);
		for(int x:ans1)
		{
			System.out.print(x+" ");
		}
		
		// Q) Given a Matrix[N][M] return an Array[] Containing max of Every Col:
		// Idea :
		// For Every Col iterate & Calculate Max & Store at Col Index.
		System.out.println();
		int ans2[]=printMaxCol(mat1);
		for(int x:ans2)
		{
			System.out.print(x+" ");
		}
	}

	private static int[] printMaxCol(int[][] mat1) 
	{
		 int n=mat1.length;
		 int m=mat1[0].length;
		 int ans[]=new int[m];
		 for(int i=0;i<m;i++)
		 {
			 int max=Integer.MIN_VALUE;
			 for(int j=0;j<n;j++)
			 {
				 if(mat1[i][j]>max)
				 {
					 max=mat1[j][i];
				 }
			 }
			 ans[i]=max;
		 }
		 return ans;
	}

	private static int[] printMaxRow(int[][] mat1) 
	{
		int n=mat1.length;
		int m=mat1[0].length;
		int ans[]=new int[n];
		for(int r=0;r<n;r++)
		{
			int max=Integer.MIN_VALUE;
			for(int c=0;c<m;c++)
			{
				if(mat1[r][c]>max)
				{
					max=mat1[r][c];
				}
			}
			//We got max of Rth-Row:
			ans[r]=max;
		}
		return ans;
		 
	}

	private static int printMaxMatrix(int[][] mat1) 
	{ 
		int ans=Integer.MIN_VALUE;
		int n=mat1.length;
		int m=mat1[0].length;
		for(int r=0;r<n;r++)
		{
			for(int c=0;c<n;c++)
			{
				if(mat1[r][c]>ans)
				{
					ans=mat1[r][c];
				}
			}
		}
		return ans;
	}

	private static void printWaveCol(int[][] mat1) 
	{ 
		int N=mat1.length;
		int M=mat1[0].length;
		for(int c=0;c<M;c++)
		{
			if(c%2==0)
			{
				for(int r=0;r<N;r++)
				{
					System.out.print(mat1[r][c]+" ");
				}
			}
			else
			{
				for(int r=N-1;r>=0;r--)
				{
					System.out.print(mat1[r][c]+" ");
				}
			}
			System.out.println();
		}

	}

	private static void printColbyCol(int[][] mat1) 
	{
		 int N=mat1.length;
		 int M=mat1[0].length;
		 //Print Col by Col
		 
		 for(int c=0;c<M;c++)
		 {
			 for(int r=0;r<N;r++)
			 {
				 System.out.print(mat1[r][c]+" ");
			 }
			 System.out.println();
		 }
	}

	private static void print0thCol(int[][] mat1) 
	{ 
		int n=mat1.length;
		int m=mat1[0].length;
		
		int c=0;
		for(int r=0;r<n;r++)
		{
			System.out.println(mat1[r][c]+" ");
		}
		
	}

	private static void printWaveRow(int[][] ma) 
	{ 
		int n=ma.length;
		int m=ma[0].length;
		for(int r=0;r<n;r++)
		{
			if(r%2==0)// Even Row Number: L-->R
			{
				for(int c=0;c<m;c++)
				{
					System.out.print(ma[r][c]+" ");
				}
			}
			else //Odd row number: R-->L
			{
				for(int c=m-1;c>=0;c--)
				{
					System.out.print(ma[r][c]+" ");
				}
			}
			System.out.println();
		}
	}

	private static void print0thRow(int[][] mat) 
	{ 
		int m=mat[0].length;
		int i=0;
		for(int j=0;j<m;j++)
		{
			System.out.println(mat[i][j]);
		}
	}

	private static void print2D(int[][] mat) 
	{ 
		int n=mat.length;
		int m=mat[0].length;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

}
