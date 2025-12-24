package IntroductionToProgram2;

import java.util.Scanner;

public class Arrays2D_1 
{

	public static void main(String[] args) 
	{ 
		/* 2D arrays:
		 * A two-dimensional array is an array of arrays i.e., it's a collection of arrays in which elements are arranged in rows and columns (tabular format).
		 * Syntax:
		 * datatype name[][]= new datatype[rows][columns].
		 * Here the DataType describes the type of values that the array can store, 
		 * while the name is the name of the 2D matrix.
		 * new datatype[r][c] statement creates a two dimensional array object that contains
		 * total number of rows and columns.
		 * Example:
		 * Create a 2D matrix of int type with 3 rows and 5 columns.
		 * Code:
		 * int mat[][]=new int[3][5];
		 * 	 Index	0	1	2	3	4
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
		 * 	 Index	0	1	2	3	4
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
		 * {12}	{14}
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
		
		/* Introduction
		 * Why do we use Excel Sheets ?
		 * Ans : Data in Structured Manner
		 * eg : Table= Rows & Columns
		 * 				|		 |
		 * 			Horizontal Vertical
		 * Q) Say we want to store marks of 4 students in Maths/Science/English/History
		 * Data :	  Maths Science English History
		 * 		Stud1	19	  24	  21	   16
		 *		Stud2	15	  20	  19	   18
		 *		Stud3	24	  22	  25	   20
		 * Way-1 :
		 * 		 Array[] for Each Student
		 * 
		 * 		 S1 : 19,24,21,16
		 * 		 S2 : 15,20,19,18
		 * Way-2 :
		 * 		 2D Arrays/Matrix
		 * 			0	1	2	3
		 *       S1 19	24	21	16
		 * 		 S2 15	20	19	18
		 * 		 rows=4	columns=4
		 * 
		 * 1D-Arrays : datatype[] name=new int[size];
		 * 
		 * 2D-Arrays : datatype[][] name=new datatype[rows][cols];
		 * 	  |		  		
		 * 	  ---> Combining multiple 1D Arrays, each row is 1D row 
		 * Indirectly in 2D-Array each element is a 1D Array
		 * 										  -->N Rows: Horizontal	
		 * Indexing Property :					  |
		 * 					  int[][] mat=new int[N][M];
		 * 											 |
		 * 											 --->M Columns: Vertical
		 * 
		 * 	
		 * Mat[0][0]											mat[0][M-1]
		 * 			 	0	1	2	3	4	j	.	.	.	M-1
		 * 				1
		 * 				2
		 * 				3
		 * 				.
		 * 				i					i,j				i,M-1
		 * 				.
		 * 				.
		 * Mat[N-1][0]	N-1					N-1,j			-------> Mat[N-1][M-1]
		 * 
		 */
		
		/* Length:
		 * int[][] mat=new int[N][M];
		 * mat.length;//It will give us no:of rows->1D Arrays : N:rows
		 * mat[0].length;//It will give us no:of columns
		 * mat[1].length;//
		 * 					} Any mat[row].length= M Columns
		 * mat[N-1].length;//
		 * 
		 * Taking input from user:
		 * 1st Line : N{row}, M{col}
		 * Followed by N lines, each line contains single row data.
		 * 
		 */
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter No Of Rows");
		int N=sc.nextInt();
		System.out.println("Enter No Of Cols");
		int M=sc.nextInt();
		int mat[][]=new int[N][M];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				mat[i][j]=sc.nextInt();
			}
		}
		print2D(mat);
	}

	private static void print2D(int[][] mat) 
	{
		int N=mat.length;
		int M=mat[0].length;
		System.out.println("Array Elements are :");
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}

}
