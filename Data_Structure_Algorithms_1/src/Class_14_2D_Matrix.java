public class Class_14_2D_Matrix 
{

	public static void main(String[] args) 

	{

		// Previous Revision

		// Max Subarray Sum : Kadane's Algorithm

		// Kadane's : Carry Sum and Keep Calculating Max in between.

		

		// Today's Content

		

		/* Q1) Given Matrix[N][N], print boundary in clockwise direction

		 * 

		 * eg : 

		 * 		0	1	2

		 * 0	1	2	3

		 * 1	4	5	6

		 * 2	7	8	9

		 * 

		 * Output : 1 2 3 6 9 8 7 4

		 * 

		 * Steps : If N*N Matrix

		 * 					  N-1	

		 * 1) 0^th Row : Print 2-Ele : L->R

		 * 2) n-1 Col  : Print 2-Ele : T->D

		 * 3) n-1^th Row : Print 2-Ele : R->L

		 * 4) 0^th Col : Print 2-Ele : D->T

		 * 

		 */

		int mat[][]= {{1,2,3},{4,5,6},{7,8,9}};

		printBoundary(mat);

		

		/* Q2) Spiral Printing

		 * 

		 * eg-1:

		 * 

		 * Mat[6][6]	=	i	j	N	iterations	n-1	 i	j	i++	 j++

		 * 					0	0	6	iterations	 5	 0	0

		 * 				    1	1	4	iterations	 3	 1	1

		 * 					2	2	2	iterations	 1	 2	2

		 * 					3	3	0	iterations	 

		 * Note : After 1-Full Boundary

		 * 

		 * i++,	j++, N=N-2

		 * 

		 * Edge Case :

		 * 

		 * if(N==1){ Print(mat[i][j])};

		 * 

		 * eg-2:

		 * 

		 * Mat[5][5]	= i		j	N	iterations:    i 	j	i++	 	j++

		 * 				  0		0	5	   "      :	4  0	0

		 * 				  1		1	3	   "	  : 2  1	1

		 * 				  2		2	1	   "	  : 0 : We won't print center element

		 * Edge Case :

		 * 

		 * if(N==1)

		 * {

		 * 	print(mat[i][j]);

		 * }

		 * 

		 * 

		 */

		System.out.println();

		System.out.println("Printing Spiral Model ");

		int mat1[][]= {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};

		SpiralPrinting(mat1);

		

		/* SubMatrix : Part of Matrix is a SubMatrix.

		 * 

		 * --------------

		 * |			| Note : a) Single Ele is Also SubMatrix

		 * |  -------	|

		 * |  |		|	|		 b) Complete matrix is also SubMatrix

		 * |  -------	|

		 * |			|

		 * --------------

		 * 

		 * 

		 * Identity Matrix : Any SubMatrix has 4-Corners

		 * 

		 * TL			TR

		 * ---------------   

		 * |			 |

		 * |			 |

		 * |			 |

		 * ---------------

		 * BL			 BR

		 * 

		 * We Just need Opposite Corners to get SubMatrix ?

		 * 

		 * a) Given TL & BR can give us SubMatrix.

		 * b) Given TR & BL can give us SubMatrix.

		 * 

		 * TL   	BR	    	TR	    	BL

		 * (1,2)	(2,5)------>(1,5)		(2,2)

		 * (2,4)	(4,6)------>(2,6)		(4,4)

		 * 

		 * (1,6)	(3,6)------>(1,6)		(3,6)

		 * (2,3)	(4,5)------>(2,4)		(4,4)

		 * 

		 * Conclusion : Given [TR & BL] Submatrix can be identified.

		 * 				In General we use TL & BR to identify a Submatrix.

		 *  

		 */

		

		/* Sum of All Submatrices Sum.

		 * 

		 * eg: {3	1}

		 * 	   {-1	2}	= 1*1 :[3][1][-1][-2][2][4] => 7

		 * 	   {2	4}		

		 * 				  1*2 :[3 1][-1 -2][2 4] => 7

		 * 

		 * 				  2*1 :[ 3] [ 1]  [-1] [-2] => 4

		 * 					   [-1] [-2]  [ 2] [ 4]

		 * 

		 * 				  2*2 :[ 3	 1]  [-1 -2] => 4

		 * 					   [-1	-2]	 [ 2  4] 

		 * 

		 * 				  3*1 :[ 3] [ 1]

		 * 					   [-1]	[-2] => 7

		 * 					   [ 2] [ 4]

		 * 

		 * 				  3*2 :[ 3	 1]

		 * 					   [-1	-2] => 7

		 * 					   [ 2	 4]

		 * 

		 * Sum of All SubMarix Sums= 36

		 * 

		 * Idea-1 : Contribution Technique = Add Contribution of individual Ele in Final

		 * 						|

		 * 						----> For Every Element Contribution = Ele * Occurences

		 * 			Occurences = Count no:of times Ele is present in Submatrix

		 * 

		 * In Above : 3*6 + 1*6 + -1*8 + -2*8 + 2*6 + 4*6 = 36.

		 * 

		 * 

		 * Eg-1: In How Many Submatrices(1,2) is present ?

		 * 

		 * 		0		1		2		3		4			

		 * 0    TL		TL  	TL	

		 * 1	TL		TL		TL/BR	BR		BR  

		 * 2					BR  	BR  	BR

		 * 3					BR		BR		BR

		 * 

		 * 

		 * 	TL		 BR		==> SubMatrix TL & BR = TL*BR

		 * [0 0]	[1 2]						  = 6 * 9 = 54

		 * [0 1]	[1 3]

		 * [0 2]	[1 4]

		 * [1 0]	[2 2]

		 * [1 1]	[2 3]

		 * [1 2]	[2 4]

		 * 			[3 2]

		 * 			[3 3]

		 * 			[3 4]

		 * 

		 * 

		 * Con : In How Many Submatrices cell (i,j) is present in mat[N][M]

		 * 
						j+1
		 * 			0------->j		M-1

		 * 		0	TL		TL
				|
		 * 		|
			i+1	|
		 * 		|
				|
		 * 		|
				
		 * 		i	TL		TL/BR	 BR i

		 * 

		 * 								 |N-i	

		 * 

		 * 		N-1			  BR	 BR	N-1

		 * 					  j	---- M-1	
								 M-j
		 * 
		 * 
		 * TL = (i+1)(j+1)
		 * BR = (N-i)(M-j)
		 * 
		 * Submatrices with cell (i,j) = TL*BR
		 * 
		 * => (i+1)(j+1)(N-i)(M-j)
		 * 
		 */
		
		//Q3) Given M[N][M] find Sum of All Submatrices Sum.
		System.out.println();
		int mat2[][]= {{3,1},{-1,-2},{2,4}};
		int ans1=SumOfSubmatrices(mat2);
		System.out.println("Submatrices Sum :"+ans1);
		// A brute-force approach to sum all submatrices would take O(n²*m²).
		
		/* Q4) Given RowWise Columnwise Sorted Matrix[N][M], find k ?
		 * 
		 * Eg : Mat[6][6]	, k=12
		 * 
		 * 		  0	 1	 2	3	4	5
		 * 0	-10 -5	-2	2	4	7
		 * 1	-7	-4	-1	3	6	9
		 * 2	-2	 3	 5	7	11	14
		 * 3	 3	 6	 8	11	14	17		
		 * 4	 7	11	12	15	19	20
		 * 5	10	14	18	20	24	29
		 * 
		 * Idea-1 : Iterate on All Elements & Search
		 * 
		 * T.C = O(N*M)
		 * S.C = O(1)
		 * 
		 * Idea-2 : Start our search at Top Right
		 * 			if mat[i][j] < k => down i++ (Row Increase)
		 * 			if mat[i][j] > k => left j-- (Col Decrease)
		 * Note : During our search if we go out of matrix, that means no element found.
		 * 
		 */
		
		int mat3[][]= {{1,2,3},{4,5,6},{7,8,9}};
		boolean ans3=matSearch(mat3,8);
		System.out.println(ans3);
		
		// Note : We can start search from TR*BL

	}



	private static boolean matSearch(int[][] mat3, int k)// T.C=O(N+M)
	{													 // S.C=O(1)
		 int n=mat3.length;
		 int m=mat3[0].length;
		 
		 int i=0,j=m-1;
		 
		 while(i<n && j>=0)
		 {
			 if(mat3[i][j]==k)
			 {
				 return true;
			 }
			 else if(mat3[i][j]<k)
			 {
				 i++; //Skip Row & Go Down
			 }
			 else //mat[i][j]>k => Skip Col : Go to Left
			 {
				 j--; //Skip Col: Go to Left
			 }
		 }
		 return false;
		 
		 /* At each iteration : Skip row or Skip Col
		  *  Total Rows= N
		  *  Total Cols= M
		  *  
		  *  Total Iterations = N+M
		  * 
		  */
	}



	private static int SumOfSubmatrices(int[][] mat2) // T.C = O(N*M)
	{												  // S.C = O(1)
		 int n=mat2.length;
		 int m=mat2[0].length;
		 int ans=0;
		 
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<m;j++)
			 {
				 int TL=(i+1)*(j+1);
				 int BR=(n-i)*(m-j);
				 ans=ans+mat2[i][j]*(TL*BR);
			 }
		 }
		 return ans;
	}



	private static void SpiralPrinting(int[][] mat) // T.C= O(N^2)
													// S.C= O(1)
	{

	  int n=mat.length;

	  int i=0,j=0;

	  

	  while(n>1)

	  {

		  //Step-1 : Print N-1 Ele in 0^th Row->L->R

		  for(int l=1;l<n;l++)

		  {

			  System.out.print(mat[i][j]+" ");

			  j++;

		  }

		  

		  //Step-2 : Print N-1 Ele in L'Col ->T->D

		  for(int l=1;l<n;l++)

		  {

			  System.out.print(mat[i][j]+" ");

			  i++;

		  }

		  

		  //Step-3 : Print N-1 Ele in L'Row ->R->L

		  for(int l=1;l<n;l++)

		  {

			  System.out.print(mat[i][j]+" ");

			  j--;

		  }

		  

		  //Step-4 : Print N-1 Ele in 0^th Col ->D->T

		  for(int l=1;l<n;l++)

		  {

			  System.out.print(mat[i][j]+" ");

			  i--;

		  }

		  i++;

		  j++;

		  n=n-2;

	  }

	  if(n==1)

	  {

		  System.out.print(mat[i][j]+" ");// i,j is at Center.

	  }
	  /* Time Complexity (TC) of SpiralPrinting code

			Let the matrix be n × n.
			
			Key Observation
			
			The while (n > 1) loop prints one complete boundary (ring) of the matrix in each iteration.
			
			For a given value of n:
			
			Step-1 prints n − 1 elements
			
			Step-2 prints n − 1 elements
			
			Step-3 prints n − 1 elements
			
			Step-4 prints n − 1 elements
			
			➡️ Total per layer = 4(n − 1) elements
			
			After one layer:
			n = n - 2;
			So the matrix size reduces by 2 (next inner ring).
		Total Work Done :

	    The total number of printed elements over all layers is: 4(n−1)+4(n−3)+4(n−5)+…
		This series covers every element of the matrix exactly once.
		⇒n2 elements printed	
	   * 
	   * Why not O(n)?

			Even though each layer looks linear, multiple layers are processed, and the total work equals the number of matrix elements.
			
			✔️ Spiral traversal always takes O(n²) for an n × n matrix.
	   */

	}



	private static void printBoundary(int[][] mat) // Single For Loop Runs =>(n-1)times
												   // 4*(n-1) = O(n)
	{											   // T.C= O(N)
												   // S.C= O(1)
		int n=mat.length;						   // Note : This is efficient because the code prints only the boundary elements of the matrix, not all n² elements.

		int i=0,j=0;

		

		// Edge Case :

		if(n==1)

		{

			System.out.print(mat[i][j]);

		}

		

		//Step-1 : Print N-1 Ele in 0^th Row L-R

		for(int l=1;l<n;l++)

		{

			System.out.print(mat[i][j]+" ");

			j++;

		}

		

		//Step-2 : Print N-1 Ele in Last Col : T-D

		for(int l=1;l<n;l++)

		{

			System.out.print(mat[i][j]+" ");

			i++;

		}

		

		//Step-3 : Print N-1 Ele in Last Row : R-L

		for(int l=1;l<n;l++)

		{

			System.out.print(mat[i][j]+" ");

			j--;

		}

		

		//Step-4 : Print N-1 Ele in 0^th Col : D-T

		for(int l=1;l<n;l++)

		{

			System.out.print(mat[i][j]+" ");

			i--;

		}

		

				

	}



}

