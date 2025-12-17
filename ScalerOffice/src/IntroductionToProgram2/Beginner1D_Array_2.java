package IntroductionToProgram2;

public class Beginner1D_Array_2 
{

	public static void main(String[] args) 
	{
	  /* 1D Arrays_2
	   * Inserting at an index in Array
	   * Given an array and element X. We have to update our array at index Y with value X.
	   * Example: arr of size 4 given. Insert 89 at 2nd index.
	   * Code :
	   * int ar[] = {33,3,4,5};
		 ar[2] = 89;
		 System.out.println(ar[2]);

	   * Output :
	   * 89
	   * Explanation :
	   * Value at index 2 has been updated with 89. Updated array: {33, 3, 89, 5}
	   * 
	   * Swapping elements in an array
	   * Given an array and two indexes x, y. Swap elements of index X and Y.
	     Example: Array = {33,3,4,5}. Swap element at index 2 with index 1 element. Final array = {33, 4, 3, 5}.

	   * Code :
	   * int ar[] = {33,3,4,5};
		 int temp = ar[2];
		 ar[2] = ar[1];
		 ar[1] = temp;

	   * Final Array:
	   * {33, 4, 3, 5}
	   * Explanation:
	   * Index 1 element swapped with index 2 element.
	   * Printing elements of a given range of indices in an array
	   * Given an array. Print all the elements in given range of indices from x to y both inclusive.
	   * Example: 
	   * ar = {33,3,4,5,6,7}. 
	   * Print elements between index 2 to 4 both inclusive.
	   * Code :
	   * int ar[] = {33,3,4,5,6,7};
		 for (int i = 2; i <= 4; i++) 
		 {
    		System.out.println(ar[i]);
		 }
	   * Output :
	   * 4
         5
		 6
	   * Explanation :
	   * Here all the elements between index 2 to index 4 are printed.
	   * 
	   */
		
	   /* Q) Given an Array and a Value K, Write a Function that returns frequency of K in the given Array.
	    * 
	    */
		int ar[]= {3,6,7,6,11,6,6};
		int k=6;
		int ans=frequency(ar,k);
		System.out.println(ans);
		
	   /* Array_Implement_Function
	    * Given N, Create an Array[N], WHich should contain all Elements in Incresing Order from 1...N
	    * eg;
	    * N=3 :{1,2,3};
	    * N=5 :{1,2,3,4,5};{i+1}
	    * 		0,1,2,3,4 {i}
	    * Generalize : ar[i]=i+1	
	    * 
	    */
		int arr[]=implement(6);
		for(int x:arr)
		{
			System.out.print(x+" ");
		}
		/* Increasing or Strictly Increasing
		 * 
		 * 1) Increasing Order : {either increasing or same}
		 * 	  a<=b<=c : {6<7<10=10 14 18 18}
		 * 2) Strictly Increasing Order : {Only Increasing}
		 * 	  a<b<c : {1<3<5<9...}
		 * Idea : For Every Element > Previous Element
		 * 
		 */
		int ar1[]= {3,6,9,9,11,14};
		int ans1=StrictlyIncreasing(ar1);
		System.out.println();
		System.out.println(ans1);
		
		/* Right Shift of an Array.
		 * 
		 * Q) Given an Array[N] SHift all elements to the right by 1.
		 * 	  Move the last element to the beginning of Array.
		 * eg :
		 * ar[10]={7,4,9,11,2,24,-5,17,1,8};
		 * Output :
		 * ar[10]={8,7,4,9,11,2,24,-5,17,1};
		 * 
		 *  Idea :
		 *  Put Last Ele in Temp Variable
		 *  Shift all elements to Right
		 *  Update first Ele with Temp Var
		 *  
		 */
		int ar2[]= {10,20,30,40,50,60};
		int ans2[]=rightShift(ar2);
		for(int x: ans2)
		{
			System.out.print(x+" ");
		}
		
		/* Count Pairs
		 * Q) Given an Array[N], K find the count of pairs(i,j) such that
		 * 	  arr[i]+arr[j]==k.Where(i!=j)
		 * Note-1: i&j are index of Array
		 * Note-2: (i,j) is same as (j,i)
		 * eg:
		 * ar[6]={2,4,2,5,3,1},k=6;
		 * Output: 3
		 * 
		 * Idea-1: For All Pairs (i,j) :check if ar[i]+ar[j]==k
		 * Total Pairs=6--->Expected=3
		 * For Every (i,j) we are also checking (j,i), So every pair we are counting twice.
		 * Final Ans=Total Pairs/2;
		 *  
		 * Idea-2:
		 * We can Check  (i,j) only
		 * We can ignore (j,i)
		 * So, Either get PairSum in Top or Bottom
		 * Now Go With Top
		 *  
		 */
		int ar3[]= {5,3,2,3,6};
		int ans3=countPairs1(ar3,8);
		System.out.println();
		System.out.println("Pairs :"+ans3);
		
		/* Count Pairs
		 * Idea-2: (i,j)
		 */
		int ans4=countPairs2(ar3,8);
		System.out.println(ans4);
		
		/* Count Pairs
		 * Idea-3: (j,i) 
		 */
		int ans5=countPairs3(ar3,8);
		System.out.println(ans5);
		
	}

	private static int countPairs3(int[] ar, int k)//O(N)
	{
		int n=ar.length;
		int c=0;
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(ar[i]+ar[j]==k)
				{
					c++;
				}
			}
		}
		return c;
	}

	private static int countPairs2(int[] ar3, int k) 
	{
		 int n=ar3.length,c=0;
		 for(int i=0;i<n;i++)
		 {
			 for(int j=i+1;j<n;j++)
			 {
				 if(ar3[i]+ar3[j]==k)
				 {
					 c++;
				 }
			 }
		 }
		 return c;
	}

	private static int countPairs1(int[] ar, int k) 
	{
		 int n=ar.length,c=0;
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<n;j++)
			 {
				 if(i!=j && (ar[i]+ar[j]==k))
				 {
					 c++;
				 }
			 }
		 }
		 return c/2;
	}

	private static int[] rightShift(int[] ar2) 
	{
		 int n=ar2.length;
		 int t=ar2[n-1];
		 for(int i=n-1;i>=1;i--)
		 {
			 ar2[i]=ar2[i-1];
		 }
		 ar2[0]=t;
		 return ar2;
	}

	private static int StrictlyIncreasing(int[] ar1) 
	{ 
		int n=ar1.length;
		for(int i=1;i<n;i++)
		{
			if(ar1[i]<=ar1[i-1])
			{
				return 0;
			}
		}
		return 1;
	}

	private static int[] implement(int n) 
	{
		 int ar[]=new int[n];
		 for(int i=0;i<n;i++)
		 {
			 ar[i]=i+1;
		 }
		 return ar;
	}

	private static int frequency(int[] ar, int k) 
	{
		 int c=0,n=ar.length;
		 for(int i=0;i<n;i++)
		 {
			 if(ar[i]==k)
			 {
				 c++;
			 }
		 }
		 return c;
	}

}
