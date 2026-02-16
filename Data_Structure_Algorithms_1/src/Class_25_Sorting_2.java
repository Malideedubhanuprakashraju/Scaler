import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Class_25_Sorting_2 
{

	public static void main(String[] args) 
	{
		 /*
		  * 1) Count Sort 
		  * 
		  * T.C = O(N+R) if R~N => T.C = O(N)
		  * 
		  * 2) Merge Sort
		  * 
		  * T.C = O(N log N)
		  * 
		  * a) Recursion
		  * b) Divide into Halfs
		  * 
		  * 3) Stable Sorting
		  * 
		  * a) Relative Order Not Changed
		  *  
		  */
		
		// Q1) Given an Array : Re-arrange it such that
		
		/* Bring Last Element to it's Correct Sorted Position
		 * 
		 * All Values < Last Elements are continuously on LeftSide of Last Element
		 * 
		 * All Values >= Last Elements are continuously on RightSide of Last Element
		 * 
		 * Note : Without Extra Space
		 * 
		 */
		
		
		/* Ans1 => ar[8] => 1,6,5,4,	7	,9,8,11};
		 * 
		 * Ans2 => ar[8] => 5,6,1,4,	7	,11,9,8};
		 * 
		 * Ans3 => ar[8] => 1,4,5,6,	7	,11,8,9};
		 * 
		 * Note : Multiple Correct Answers, return any one Correct Answer
		 * 
		 */
		
		/* Idea-1 :
		 * 
		 * 1) Sort Entire Array => MergeSort
		 * 
		 * T.C = O(N logN)
		 * S.C = O(N)
		 * 
		 * 
		 * Idea-2 :
		 * 
		 * Take 2 indices i & j
		 * 
		 * i : Used to iterate on Array
		 * 
		 * j : Move your j : if data < x
		 * 
		 * Once Loop Done => Swap(ar[j] & ar[last_ele])
		 * 
		 */
		int ar[]= {9,8,1,6,5,11,4,7};
		
		int ans[]=ReArrange(ar);
		for(int x:ans)
		{
			System.out.print(x+" ");
		}
		
		/* Quick Sort Idea :
		 * 
		 * Take Pivot Element into its Correct Position
		 * 
		 * Again Take P-1 as Pivot Element and Sort
		 * 
		 * Repeat the same until all Pivots into Correct Position
		 * 
		 * Note : In each Level Time Taken for Each Level = N.
		 * 														} T.C = (N log N), S.C = O(N)
		 * Note : In Total we will have => log N
		 * 
		 */
		
		int A[]= {3,6,14,11,8,20,27,31,23,18};
		
		System.out.println();
		
		int ans1[]=QuickSort(A);
		for(int x:ans1)
		{
			System.out.print(x+" ");
		}
		
		/* [s	s+1	 s+2	-------e-1	e]
		 * 								|
		 * 					  -----------
		 * 					  |
		 * [s	s+1.......j-1 j j+1.....e]
		 * 
		 *  [ Sort Left	]		[Sort Right]
		 * 
		 */
		
		/* In Worst Case : For Array[N]
		 * 
		 * 1 + 2 + 3+ .....N
		 * 
		 * ~ O(N^2)
		 * 
		 * When ? ==> If Element we pick is either largest or Smallest Above Case Occurs.
		 * 
		 */
		
		
		/* Comparator : To define required order for 2-Elements & it will sort all Elements in Given Order.
		 * 
		 * Note : We Cann't Use on arrays, we need ArrayList.
		 * 
		 * Syntax :
		 * 			-----> Own Class
		 * 			|
		 * class SortOwn implements Comparator<ClassType>
		 * {										|										
		 * 											------>Type of Data Sorting
		 * 		public int compare(classType s1,classType s2)
		 * 		{
		 * 			when you want s1 Before s2 : return -1;
		 * 			when you want s2 Before s1 : return 1;
		 * 			If Both same : return 0;
		 * 		}
		 * }
		 * 
		 * class main()
		 * {
		 * 		public static void main()
		 * 		{
		 * 			ArrayList< ClassType > ar=new ArrayList<>();
		 * 
		 * 			Store Data in ar
		 * 	
		 * 			Collections.sort(ar,new SortOwn()); // Object of Sort Class
		 * 								 |
		 * 								 -----> Use This order to sort ArrayList
		 * 		}
		 * }
		 * 
		 * T.C = ( N log N) * Time Taken for Compare function.
		 *  
		 */
		
		// Q3) Given Array Sort Them Based on Their Factors.
		
		// Note : If 2-Elements have Same Factors, Sort based on Values
		
		ArrayList<Integer> arr=new ArrayList<>();
		arr.add(10);
		arr.add(4);
		arr.add(5);
		arr.add(13);
		arr.add(1);
		
		
		ArrayList<Integer> ar1=solves(arr);
		System.out.println();
		System.out.println(ar1);
	}
	
	private static ArrayList<Integer> solves(ArrayList<Integer> arr) // T.C = O(N log N * sqrt(M) )
	{																 // S.C = O(1)
		Collections.sort(arr,new factorsort());
		return arr;
	}
											// 		  Best			  Avg		    Worst
	private static int[] QuickSort(int[] a) // T.C = O(N logN) 		O(N logN)		O(N^2)
	{										// S.C = O(N)
		int n=a.length;
		solve(a,0,n-1);
		return a;
		 
	}

	private static void solve(int[] a, int s, int e) 
	{
		 if(s>e)
		 {
			 return;
		 }
		 // Sub Problem : [ s, s+1, .....e-1, e], Re-arrange ar[e]
		 
		 int x=a[e];
		 int j=s;
		 
		 for(int i=s;i<e;i++)
		 {
			 if(a[i]<x)
			 {
				 Swap(i,j,a);
				 j++;
			 }
		 }
		 Swap(j,e,a);
		 solve(a,s,j-1);
		 solve(a,j+1,e);
	}

	private static int[] ReArrange(int[] ar) // T.C = O(N)
	{										 // S.C = O(1)
		 int n=ar.length;
		 int x=ar[n-1]; // Pivot Value
		 int j=0;
		 
		 for(int i=0;i<n-1;i++)
		 {
			 if(ar[i]<x) // Bring Array[i] on Left
			 {
				 Swap(i,j,ar);
				 j++;
			 }
		 }
		 Swap(j,n-1,ar);// Bring Last Element to it's Correct Position // Final Pivot Swap
		 return ar;
	}

	private static void Swap(int i, int j, int[] ar) 
	{
		int t=ar[i];
		ar[i]=ar[j];
		ar[j]=t;
		
	}

	 

}
