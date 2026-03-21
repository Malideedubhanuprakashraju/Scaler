package Basic_Maths;

// First Class --> DSA: Maths: Combinatorics Basics
public class Class_38_Maths_1 
{

	public static void main(String[] args) 
	{ 
		/* Addition Rule : OR
		 * 
		 * Eg-1 : Given 4 Boys & 3 Girls, How many ways we can pick a Single Person
		 * 
		 * 		  : Boys or Girl
		 * 		  :  4	 or  3	 = 7ways.
		 * 
		 * Multiplication Rule : AND
		 * 
		 * Eg-1 : Given 4 Boys & 3 Girls, How many different Pairs can be informed
		 * 
		 * 		  : Boys		Girls		Boy AND Girl
		 * 
		 * 			 B1			 G1			 4   *	 3	 = 12ways.
		 * 			 B2			 G2
		 * 			 B3			 G3
		 * 			 B4
		 * 
		 * Eg-2 : No of Ways to reach Agra  from Pune via Delhi
		 * 
		 * 
		 * 		  Pune------>Delhi------>Agra
		 * 
		 * 		  Pune--->Delhi AND Delhi--->Agra
		 * 
		 * 		  		3		 *		  2		 = 6ways.
		 * 
		 * 
		 * Permutation : Ways to Arrange { Order Matter }
		 * 
		 * 				 Pair(i,j) != Pair(j,i) : Different
		 * 
		 * 
		 * Ways to Arrange : P1	 P2  P3
		 * 
		 * P1	P2	 P3
		 * 
		 * 3  *  2  * 1 = 3! = 6ways
		 * 
		 * 
		 * Ways to Arrange : P1 P2 P3 P4
		 * 
		 * P1	 P2		P3	 P4
		 * 
		 * 4  *  3   *  2  *  1 = 4! = 24ways
		 * 
		 * Q) Ways to arrange : N People
		 * 
		 * 	  N * N-1 * N-2 * .......*1 = N!
		 * 
		 * Ways to Arrange 2 from 4 People : P1		P2	  P3	P4 : 4 * 3 = 12ways
		 * 
		 * 
		 * Ways to Arrange 3 from 5 People :
		 * 
		 * 		5	*	4	 *	  3 = 60ways.
		 *  
		 */
		
		/* N
		 * 	P	: Permutation : Arrangement
		 * 	 R
		 * 
		 * 
		 * Ways to Arrange R from N People.
		 * 
		 * N	 N-1	N-2		N-3		N-4.......... N-r+1
		 * 
		 * 1	  2		 3		 4		 5				r^th
		 * 
		 * 
		 * 
		 * Ways = N * N-1 * N-2 * N-3 *.....N-r+1 * N-r * N-r-1 * N-r-2 *.....1
		 * 		 ---------------------------------------------------------------
		 * 						N-r * N-r-1 * N-r-2 *......1
		 * 
		 * 
		 * N
		 * 	P	= N!/(N-R)! { Ways to Arrange : R from N Persons
		 * 	 R
		 * 
		 * P : Permutation / arrangement / Order-> Yes
		 *   
		 */
		
		/* Combination : Ways to Select { Order won't Matter }
		 * 
		 * 				 { (i,j)--->(j,i) } Both are Same
		 * 
		 * Say 4 People how many ways we can select 2 people
		 * 
		 * P1	 P2		P3	 P4 : 4-Selections
		 * 
		 * 2-People
		 * --------
		 * 
		 * P1	P2
		 * 
		 * P1	P3
		 * 
		 * P1	P4
		 * 				} Order doesn't matter only Selection Matters.
		 * P2	P3
		 * 
		 * P2	P4
		 * 
		 * P3	P4
		 * 
		 * 
		 * Correlation		Arrangement		Selection
		 * 
		 * 3-People				3!				1
		 * 								 *
		 * 3 from 4 peple :4P3 	4!/1!			x : ? = 4
		 * 
		 * 
		 * ==> x * 3! = 4!
		 * 												 |		
		 * ==> x = 4!/3! = 4 <----------------------------
		 * 
		 *   
		 */
		
		/* N
		 * 	C  : Number of ways to select { order * } r from N.
		 * 	 R
		 * 
		 * 						Arrangement			Selection
		 * 
		 * R-People	:			     R!					1
		 * 
		 * R from N-People :		 NpR				X
		 * 
		 * 
		 * X * R! = NpR
		 * 
		 * X = NpR/R!	= N!/(N-R)!*R!
		 * 
		 * 
		 * N
		 * 	C	: { Ways to Select R from N } = NpR/R! =  N! / (N-R)! * R!
		 * 	 R
		 * 
		 */
		
		/* Properties :
		 * 
		 * 1) Ways to select 0 from N : Nc0	= N!/N!*0! = N!/N! =1
		 * 	    |
		 * 		-----> Not Selcting anything is a Way.
		 * 
		 * 2) Ways to select N from N : NcN = N!/(N-N)!*N! = N!/N! =1
		 * 		|
		 * 		-----> Selecting all People is a way
		 * 
		 * 3) Ways to select N-R from N :
		 * 
		 * 		N
		 * 		 C	= NcN-R
		 * 		  R
		 * 
		 * 		N
		 * 		 C	 = N! / R! * (N-R)!
		 * 		  N-R
		 *  
		 */
		
		/* Observations :
		 * 
		 * 1) N! = N * (N-1)!
		 * 
		 * 2) R! = R * (R-1)!
		 * 
		 * 3) (N-R)! = (N-R)(N-R-1)!
		 * 
		 */
		
		/* Special Property :
		 * 
		 * Ways to select R from N		p1	p2	p3	.	.	.pn-1	pn : N-people.
		 * 										 |
		 * 									|---------|
		 * 								 Present	Not Present
		 * 
		 * Select R from N = Select = R-1 from N-1 + Select = R from N-1
		 * 
		 * N	  N-1	  N-1
		 * 	C	= 	C	+ 	C
		 * 	 R		R-1		 R
		 * 
		 * Eg : N=6, R=4
		 * 
		 * N	  6		5	  5
		 * 	C	=  C ==> C  +  C
		 * 	 R		4	  3		4
		 * 
		 * 
		 * 
		 * 
		 */
		
		/* Pascal Triangle
		 * 
		 * Given 5, Generate Pascal Triangle ( N Rows)
		 * 					 ----------------
		 * 							|
		 * 							----> N*N Matrix filled with NcR Values.
		 * 
		 * N=5,
		 * 
		 * 		0	1	2	3	4
		 * 0	1	0	0	0	0
		 * 1	1	1	0	0	0
		 * 2	1	2	1	0	0
		 * 3	1	3	3	1	0
		 * 4	1	4	6	4	1
		 *  
		 */
		
		// Q1) Given N, Return N * N Matrix filled with NcR Values.
		
		/* Idea-1 : Given N create Mat[N][N]
		 * 
		 * Iterate on Matrix :
		 * 
		 * 			for rows :
		 * 				for columns :
		 * 					if(j>i)
		 * 						{
		 * 							mat[i][j]=0;
		 * 						}
		 * 					else
		 * 						{
		 * 							mat[i][j]= icj;// Not Possible // Overflow will come
		 * 						}
		 * 			return mat;
		 * 
		 * 
		 * Idea-2 : NcR = N-1cR + N-1cR-1
		 * 
		 * Let us => N = i (row) && R = j (col)
		 * 
		 * icj	= i-1cj	+ i-1cj-1
		 * 
		 * |---> I store which cell in 2D-Matrix ==> mat[i][j]
		 * 
		 * mat[i][j] = mat[i-1][j] + mat[i-1][j-1];[ top & topLeft ]
		 * 
		 * if i==0 || j==0 it won't work
		 *   
		 */
		System.out.println("Pascal Traingle Print : N");
		int ans[][]=pascal(5);
		for(int[] X:ans)
		{
			for(int a:X)
			{
				System.out.print(a+" ");
			}
			System.out.println();
		}
		System.out.println("Pascal Traingle Print : NcR");
		int ans1=pascalncr(4,2);
		System.out.println("NcR Value is : "+ans1);
	}

	private static int pascalncr(int A, int B) // T.C = O(A*B)
	{										   // S.C = O(A*B)
		 int ans[][]=new int[A+1][B+1];
		 
		 for(int i=0;i<=A;i++)
		 {
			 for(int j=0;j<=B;j++)
			 {
				 if(j>i)
				 {
					 ans[i][j]=0;
				 }
				 else if(i==0 || j==0)
				 {
					 ans[i][j]=1;
				 }
				 else
				 {
					 ans[i][j]=ans[i-1][j-1]+ans[i-1][j];
				 }
			 }
		 }
		 return ans[A][B];
	}

	private static int[][] pascal(int N) // T.C = O(N^2)
	{									 // S.C =  Including output → O(N²)
										 // Auxiliary space → O(1)
		int mat[][]=new int[N][N];
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(j>i)
				{
					mat[i][j]=0;
				}
				else if(i==0 || j==0)
				{
					mat[i][j]=1;
				}
				else
				{
					mat[i][j]=mat[i-1][j-1]+mat[i-1][j];
				}
			}
		}
		return mat;
	}

}
