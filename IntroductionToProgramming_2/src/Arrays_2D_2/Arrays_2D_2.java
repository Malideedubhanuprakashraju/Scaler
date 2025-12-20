package Arrays_2D_2;

public class Arrays_2D_2 
{

	public static void main(String[] args) 
	{
		int[][] mat= {{1,0,0},{0,1,0},{0,0,1}};
		
		/* Identity Matrix
		 * Given a Square Matrix, Check if it's identity Matrix or Not.
		 * An Identity Matrix, All Main Diagonal has only 1 and all other cells 0.
		 * 								|
		 * 								---->mat[r][c], r==c.
		 * eg:
		 *   	 0 1 2 3
		 * I= 0	 1 0 0 0
		 * 	  1  0 1 0 0
		 * 	  2  0 0 1 0
		 * 	  3	 0 0 0 1
		 * Yes : Identity Matrix
		 * 
		 * Idea :
		 * 		 if r==c, A[r][c]=1
		 * 							} For All Cells, If Condition Satisfies It's Identity Matrix, Even for a Single Element, If above condition fails.
		 * 							  Not an Identity Matrix.	
		 * 		 if r!=c, A[r][c]=0
		 * 
		 */
		int ans=IdentityMatrix(mat);
		System.out.println(ans);
		
		// Q) Transpose of a Rectangular Matrix:
		// 	  Transpose : Interchange rows & colums
		
		int mat1[][]= {{1,2,3},{4,5,6},{7,8,9}};
		
		// For a Rectangular Matrix, Transpose has to be in a New Matrix
		// Mat[N][M]----------->Tra[M][N]
		//			 Transpose
		
		// Obs:		A[0][1] copied to T[1][0]
		//			A[1][2] copied to T[2][1]
		//			.		  .			.
		//			A[i][j] copy to   T[j][i]
		
		// Idea : Iterate on Mat[][] & copy A[i][j] to T[j][i]
		
		int ans1[][]=Transpose(mat1);
		for(int[] X: ans1)
		{
			 for(int val:X)
			 {
				 System.out.print(val+" ");
			 }
			 System.out.println();
		}
		// Transpose of Square Matrix : Same Size
		// Transpose in same matrix itself
		
		/*		0 1 2		  0 1 2
		 * 	  0	1,2,3		0 1,4,7
		 * 	  1	4,5,6	--->1 2,5,8 
		 * 	  2	7,8,9		2 3,6,9
		 * 
		 * Idea : mat[1][0] swap mat[0][1]
		 * 		  mat[3][2] swap mat[2][3]
		 * 			  .				 .
		 * 		  mat[i][j] swap mat[j][i]
		 * 
		 * Idea : Iterate on Overall Matrix & Mat[i][j] Swap With Mat[j][i];
		 * Issue
		 */
		System.out.println();
		int[][] ans2=TransposeSquare(mat1);
		for(int[] X: ans2)
		{
			 for(int val:X)
			 {
				 System.out.print(val+" ");
			 }
			 System.out.println();
		}
		// Resolve Issue:
		// mat[5][5]
		// 1 	2	 3	 4	 5
		// 6 	7 	 8	 9	 10
		// 11 	12 	 13  14	 15
		// 16	17	 18	 19	 20
		// 21	22	 23	 24	 25
		
		// Idea : Iterate only on Upper or Only on Lower & Swap Elements.
		// Upper
		// Only Iterate on Upper & Transpose
		// r=0 : c=1,2,3,4
		// r=1 : c=2,3,4
		// r=2 : c=3,4
		// r=3 : c=4
		// For r:c=r+1--->N-1;
		int mat2[][]= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		System.out.println();
		System.out.println("Transpose-2");
		int[][] ans3=TransposeSquare2(mat2);
		for(int[] X: ans3)
		{
			 for(int val:X) 
			 {
				 System.out.print(val+" ");
			 }
			 System.out.println();
		}
		
		// Q) Rotate Square Matrix 90^degrees Clock Wise:
		// eg: mat[3][3]
		//		
		//		0	1	2						0	1	2
		//	0	1	2	3	Rotate 90d		0	7	4	1
		//	1	4	5	6	----------->	1	8	5	2
		//	2	7	8	9					2	9	6	3
		
		// Idea : To Rotate Mat[][] by 90d
		// Transpose	: 1)Row-->Col, First Take Transpose
		//				  2)Reverse each Row
		int nm[][]= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		int anss[][]=Rotate(nm);
		for(int[] X: anss)
		{
			 for(int val:X) 
			 {
				 System.out.print(val+" ");
			 }
			 System.out.println();
		}
		
		// Q) Print Main Diagonal : r==c
		int m[][]= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		mainDiagonal(m);
		
		/* Add 2-Matrices
		 * 
		 * Write a Function takes 2-matrices of same sizes return Result.
		 * Note-1 : We Can obly Add Matrix[][] of Same Sizes
		 * Note-2 : If Matrix[][] are of different sizes, we cannot add Them
		 * 
		 */
		System.out.println("Adding Two Matrices-->");
		int a[][]= {{7,2},{6,3},{1,4}};
		int b[][]= {{3,2},{7,3},{6,4}};
		int ansss[][]=AddMatrix(a,b);
		for(int[] X: ansss)
		{
			 for(int val:X) 
			 {
				 System.out.print(val+" ");
			 }
			 System.out.println();
		}
		
	}

	private static int[][] AddMatrix(int[][] a, int[][] b) 
	{
		int n=a.length;
		int m=a[0].length;
		int an[][]=new int[n][m];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				an[i][j]=a[i][j]+b[i][j];
			}
		}
		return an;
	}

	private static void mainDiagonal(int[][] nm) 
	{
		 int n=nm.length;
		 for(int r=0;r<n;r++)
		 {
			 System.out.println(nm[r][r]);
		 }
	}

	private static int[][] Rotate(int[][] a) 
	{
		 	  
		 int n=a.length;
		 for(int i=0;i<n;i++)
		 {
			 for(int j=i+1;j<n;j++)
			 {
				int t=a[i][j];
				a[i][j]=a[j][i];
				a[j][i]=t;
			 }
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 reverse(a[i]);//mat[i]=ith Row;
		 }
		 return a;
		 
		 
	}

	private static void reverse(int[] a) 
	{ 
		int n=a.length;
		int p1=0,p2=n-1;
		while(p1<p2)
		{
			int temp=a[p1];
			a[p1]=a[p2];
			a[p2]=temp;
			p1++;
			p2--;
		}
		
	}

	private static int[][] TransposeSquare2(int[][] mat1) 
	{
		 int n=mat1.length;
		 for(int r=0;r<n;r++)
		 {
			 for(int c=r+1;c<n;c++)
			 {
				 //Swap mat[r][c] & mat[c][r]
				 int temp=mat1[r][c];
				 mat1[r][c]=mat1[c][r];
				 mat1[c][r]=temp;
			 }
		 }
		 return mat1;
	}

	private static int[][] TransposeSquare(int[][] mat1) 
	{ 
		int n=mat1.length;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(i!=j)
				{
					int temp=mat1[i][j];
					mat1[i][j]=mat1[j][i];
					mat1[j][i]=temp;
				}
			}
		}
		return mat1;
		
		// Same Thing 2 Times : Data wont Changed
		// Matrix will remain Same
		
	}

	private static int[][] Transpose(int[][] mat1) 
	{
		 int n=mat1.length;
		 int m=mat1[0].length;
		 int ans[][]=new int[m][n];
		 
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 ans[j][i]=mat1[i][j];
			 }
		 }
		 return ans;
	}

	private static int IdentityMatrix(int[][] mat) 
	{
		 int n=mat.length;
		 for(int r=0;r<n;r++)
		 {
			 for(int c=0;c<n;c++)
			 {
				 if(r==c && mat[r][c]!=1)
				 {
					 return 0;				//} If this Condition satisfies Means we have incorrect that. Hence not an Identity Matrix.
				 }
				 if(r!=c && mat[r][c]!=0)
				 {
					 return 0;
				 }
			 }
		 }
		 return 1;
	}

}
