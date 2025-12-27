package Arrays_Prefix_Sum;

public class Class_4_Prefix_Sum_Continue 
{

	public static void main(String[] args) 
	{
		// Equilibriam Index :
		/* 
		 * Given Array[N] elements, count no of equilibriam index.
		 * An index i is said to be equlibriam index if :
		 * 
		 * Sum of All Elements on Left of ith index = Sum of All Elements on right of ith index.
		 * 
		 * Note : i=0:LeftSum=0			i=N-1:RightSum=0
		 * 
		 * 0	1	2	.	.	i-1    i		 i+1	i+2	.	.	. N-1
		 * Left Index i			      = =			Right Index i
		 * 
		 * Constraints :
		 * 
		 * 1 <= N <= 10^5
		 * 					 } Sum of All Elements
		 * 1 <= A[i] <= 10^9
		 * 
		 * eg :
		 * 
		 * Array[4] = {-3,2,4,-1};
		 * 
		 * LeftSum	=  0,-3,-1,3
		 * 						 } Ans=1-Equilibrium
		 * RightSum =  -1,2,-1,0	
		 * 
		 */
		
		/* Idea-1 :
		 * 
		 * For every index check if it's equilibrium ?
		 * 
		 * To Check if i is equilibrium :
		 * a) Iterate on Left of i & get Sum : Lsum;
		 * b) Iterate on Right of i & get Sum : Rsum;
		 * 
		 * if(Lsum==Rsum)
		 * {
		 * 		count++;
		 * }
		 * Edge Case : i=0 & i=N-1;
		 *  
		 */
		int ar[]= {-7,1,5,2,-4,3,0};
		int ans=equilibriumCount(ar);
		System.out.println(ans);
		
		/* Observation :
		 * 
		 * For Every i :
		 * 				 Iterate & Calculate Sum of Left & Right is Taking Time
		 * 
		 * 0	1	2	.	.	i-1		i		i+1		i+2		.	.	N-1
		 * Sum[0............i-1]	   = = Sum[i+1........N-1]
		 * 
		 * Conclusion : It can be optimized with Prefix Sum
		 * 
		 * psum[i]= Sum of all[0...i] 		psum[i]= Sum of all[i+1....N-1]
		 * Lsum	  = Sum[0...i-1]			Rsum	= Sum[i+1....N-1]
		 * 
		 * Lsum	  = psum[i-1];				Rsum	= psum[N-1]-psum[i];
		 * 
		 */
		int ans1=equlibrium(ar);
		System.out.println(ans1);
		
		// Note : Above Question can be done without any extra space ?
		// Using CarryForward Technique
		
		// Q) Given Array[N], Count number of special index in the Array.
		// Note : Special index are those after removing that index.
		// Sum of all even indices = Sum of all odd indices
		//		  0 1 2 3 4  5
		int A[]= {4,3,2,7,6,-2};
		
		// After Removing i^th index next sum will cal 
		
		/* 	i		A[]			Se		So		SpecialIndex
		 * 		 0 1 2 3  4	
		 *  0	{3,2,7,6,-2}	8		8			 c=c+1;
		 * 	1	{4,2,7,6,-2}    9		8					} c=2;
		 *  2	{4,3,7,6,-2}	9		9			 c=c+1;
		 *  3	{4,3,2,6,-2}	4		9
		 *  4	{4,3,2,7,-2}	4		10
		 *  5	{4,3,2,7,6}		12		10
		 */
		
		// eg :		 0 1 2 3 4  5 6  7 8  9
		//      A[]={2,3,1,4,0,-1,2,-2,10,8};
		//Delete :5
		// 			  0 1 2 3 4 5  6  7 8	
		//	   Del[]={2,3,1,4,0,2,-2,10,8};
		
		//	SumE in Del[]=SumE in Del[0 4] + SumE in Del[5 8]
		
		//  SumE in Del[]=SumE in Ar[0 4] + SumO in Ar[6 9]
		//  SumO in Del[]=SumO in Ar[0 4] + SumE in Ar[6 9]
		
		/* Generalize : This Equation
		 * 
		 * 		   0  1  . i-1 i i+1 i+2  .  N-1
		 * A[ ]= { a, b, c, d, *, f, g, h, i, j};
		 * 
		 * Delete i :
		 * 			 0  1  . i-1 i i+1 i+2...N-2 
		 * Del[ ]= { a, b, c, d, f, g, h, i, j }
		 * 
		 * Gen :
		 * 
		 * For i :
		 * 
		 * SumE in Del[ ]= SumE in Ar[0..i-1] + SumO in Ar[i+1 N-1]
		 * SumO in Del[ ]= SumO in Ar[0..i-1] + SumE in Ar[i+1 N-1]
		 * 
		 * if(TotalE==TotalO)
		 * {
		 * 		Special Index;
		 * }
		 * 
		 */
		
		int Ar[]= {4,3,2,7,6,-2};
		int ans2=SpecialIndex(Ar);
		System.out.println(ans2);
		
		/* Optimization : SpecialIndex
		 * 
		 * It can be done using peven[] & podd[];
		 * 
		 * SumE in Del[]=SumE in Ar[0 i-1]+ SumO in Ar[i+1 N-1]
		 * 				 peven[0 i-1]		podd[N-1]-podd[i+1-1]-->podd[i]
		 * 
		 * SumO in Del[]=SumO in Ar[0 i-1]+ SumE in Ar[i+1 N-1]
		 * 				 podd[0 i-1]		 peven[N-1]-peven[i]		
		 * 
		 */
		System.out.println("Optimized Special Index ");
		int ans3=SpecialIndexOpti(Ar);
		System.out.println(ans3);
		
		
	}

	private static int SpecialIndexOpti(int[] ar) // T.C = O(N+N+N)= O(N)
	{											  // S.C = O(N+N)  = O(N)
		 int n=ar.length;
		 int c=0;
		 int peven[]=new int[n]; // Step-1 : Create peven[]
		 int sum=0;
		 for(int i=0;i<n;i++)
		 {
			 if(i%2==0)
			 {
				 sum=sum+ar[i];
			 }
			 peven[i]=sum;
		 }
		 
		 int podd[]=new int[n]; // Step-2 : Create podd[]
		 int sum1=0;
		 for(int i=0;i<n;i++)
		 {
			 if(i%2==1)
			 {
				 sum1=sum1+ar[i];
			 }
			 podd[i]=sum1;
		 }
		 
		 for(int i=0;i<n;i++)// Step-3 : Check if it's Special
		 {
			 int leven=0,lodd=0,reven=0,rodd=0;
			 if(i!=0)
			 {
				 leven=peven[i-1];
			 }
			 reven=peven[n-1]-peven[i];
			 
			 if(i!=0)
			 {
				 lodd=podd[i-1];
			 }
			 rodd=podd[n-1]-podd[i];
			 
			 if(leven+rodd==reven+lodd)
			 {
				 c++;
			 }
		 }
		 return c;
	}

	private static int SpecialIndex(int[] ar) // T.C=O(N^2)
	{										  // S.C=O(1)	
		 int n=ar.length;
		 int c=0;
		 
		 for(int i=0;i<n;i++)
		 {
			 int leven=0,lodd=0,reven=0,rodd=0;
			 
			 for(int j=0;j<i;j++)
			 {
				 if(j%2==0)
				 {
					 leven=leven+ar[j];
				 }
				 else
				 {
					 lodd=lodd+ar[j];
				 }
			 }
			 
			 for(int j=i+1;j<n;j++)
			 {
				 if(j%2==0)
				 {
					 reven=reven+ar[j];
				 }
				 else
				 {
					 rodd=rodd+ar[j];
				 }
			 }
			 // Total Even= Leven+Rodd
			 // Total Odd= Lodd+Reven
			 if(leven+rodd==reven+lodd)
			 {
				 c++;
			 }
		 }
		 return c;
	}

	private static int equlibrium(int[] ar) // T.C=O(N+N)~O(N)
	{										// S.C=O(N)
		 int n=ar.length,c=0,sum=0;
		 int psum[]=new int[n];
		 for(int i=0;i<n;i++)
		 {
			 sum=sum+ar[i];
			 psum[i]=sum;
		 }
		 
		 for(int i=0;i<n;i++)
		 {
			 int lsum=0,rsum=0;
			 if(i!=0)
			 {
				 lsum=psum[i-1]; // if i==0 : psum[-1]**Error
			 }
			 rsum=psum[n-1]-psum[i];
			 if(lsum==rsum)
			 {
				 c++;
			 }
		 }
		 return c;
	}

	private static int equilibriumCount(int[] ar) // T.C= O(N*N)--> O(10^10) > 10^8-->TLE
	{											  // S.C= O(1)
		 int n=ar.length;						  
		 int c=0;
		 
		 for(int i=0;i<n;i++)
		 {
			 int lsum=0,rsum=0;
			 for(int j=0;j<i;j++)
			 {
				 lsum=lsum+ar[j];
			 }
			 for(int j=i+1;j<n;j++)
			 {
				 rsum=rsum+ar[j];
			 }
			 if(lsum==rsum)
			 {
				 c++;
			 }
		 }
		 return c;
	}

}
