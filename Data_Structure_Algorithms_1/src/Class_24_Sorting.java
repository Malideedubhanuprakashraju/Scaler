import java.util.Arrays;
import java.util.HashMap;

public class Class_24_Sorting 
{

	public static void main(String[] args) 
	{
		// Inbuilt Sort for N Elements = NlogN
		// N Represents : No:of Elements in Array
		
		// Count Sort :
		
		// Q1) Given Array Elements in Range[2-6]---> Sort Array in Increasing Order
		
		int ar[]= {3,2,4,6,4,2,3,4,3,6};
		
		// Idea-1 : Inbuilt Array Sort
		// O(N logN)
		
		Arrays.sort(ar);
		for(int x:ar)
		{
			System.out.print(x+" ");
		}
		
		// Idea-2 :
		// 1) Use HashMap to Store Frequency All Elements
		
		// Issue : There is no order of Keys
		
		// Q2) Given Array from [2.....6] use above information & get in Increasing Order.
		
		// Count Sort : Sorting Elements Using Frequency is Count Sort.
		
		// T.C : O(N+R)
		
		// S.C : O(N)
		
		/* a=Min of Array
		 * 
		 * b=Max of Array
		 * 
		 * R=b-a+1
		 * 
		 * Use if Range R ~ N --> Array Length
		 * 
		 * Count Sort : T.C = O(N+R) = O(N+N) ~ O(N)
		 * 
		 * Inbuilt Sort : T.C = O(N logN) ~ O(N log N)
		 *  
		 */
		System.out.println();
		int ans[]=Sort(ar);
		for(int x:ans)
		{
			System.out.print(x+" ");
		}
		
		// 3) Given an Array Where All Elements in Range : [a	b] Sort Array.
		
		// Note : Because Element [a...b], Range R=b-a+1
		
		// Same Question In Place of for Loop Use a,b
		
		// T.C = O(N+R)
		
		// S.C = O(N)
		
		// Q4) Given 2-Sorted Arrays A[N], B[M] Create C[N+M]--> Which Contains Overall Sorted Data.
		
		int A[]= {7,10,11,14};
		int B[]= {3,8,9};
		
		System.out.println();
		int C[]=merge(A,B);
		for(int x:C)
		{
			System.out.print(x+" ");
		}
		
		// Q5) Count Sort of a Given Array
		
		// "What algorithm is this?"
		
		// "It is a modified version of Counting Sort where I used HashMap to store frequencies instead of a count array."
		
		System.out.println();
		
		System.out.println("Count Sort of a Given Array ");
		
		int cou[]=countSort(ar);
		for(int x:cou)
		{
			System.out.print(x+" ");
		}
		
		// Q6) Given Array Elements & 3-indices s,m,e
		
		/* SubArray [s	m] is Sorted
		 * 
		 * SubArray [m+1 e] is Sorted
		 * 
		 * Sort Entire Array from [s.....e]
		 *  
		 */
		
		int ar1[]= {4,8,-1,2,8,9,11,3,4,7,13,0};
		int s=2,m=6,e=9;
		System.out.println();
		mergeArray(ar1,s,m,e);
		System.out.println("After Sorted Elements are.....");
		
		for(int x:ar1)
		{
			System.out.print(x+" ");
		}
		
		
		// Q6) Merge Sort
		
		// Keep Dividing Array in 2-Half's till it contains 1 Element & Merge Them.
		
		/* 1) Assumption : MergeSort FUnction will Sort Array from index [s...e]
		 * 
		 * 2) Main Logic : Solving Assumption with Subproblems
		 * 
		 * 				   merge Array : S,M,E
		 * 	
		 * 3) Base Condition
		 *  
		 */
		int ans2[]=solve(ar1);
		System.out.println();
		for(int x:ans2)
		{
			System.out.print(x+" ");
		}
		
		// Q7) Stable Sort
		
		/* When 2 Data Points have Same Parameter Value
		 * 
		 * Their Relative Order should be Same, before & after Sorting
		 * 
		 * eg : Sorting Below data on Marks Parameter using Algo1 & Algo2
		 * 
		 * InPlace : If Sorting Algorithm S.C : O(1) -->It is known as InPlace.
		 * 
		 */
		
	}

	private static int[] solve(int[] ar1) 
	{
		 int n=ar1.length;
		 mergeSort(ar1,0,n-1);
		 
		 return ar1;
	}

	private static void mergeSort(int[] ar1, int s, int e) // T.C = (N log N)
	{													   // S.C = O(N)
		if(s==e)
		{
			return;
		}
		
		int m=(s+e)/2;
		
		mergeSort(ar1,s,m);
		mergeSort(ar1,m+1,e);
		mergeArray(ar1,s,m,e);
	}

	private static void mergeArray(int[] ar1, int s, int m, int e) // T.C = O(N)
	{															   // S.C = O(N)
		int temp[]=new int[e-s+1];
		
		int p1=s,p2=m+1,p3=0;
		
		while(p1<=m && p2<=e)
		{
			if(ar1[p1]<ar1[p2])
			{	
				temp[p3]=ar1[p1];
				p3++;
				p1++;
			}
			else
			{
				temp[p3]=ar1[p2];
				p3++;
				p2++;
			}
		}
		
		while(p1<=m)
		{
			temp[p3]=ar1[p1];
			p3++;
			p1++;
		}
		
		while(p2<=e)
		{
			temp[p3]=ar1[p2];
			p3++;
			p2++;
		}
		
		// Copy Data from Temp --> Original Data.
		int j=0;
		for(int i=s;i<=e;i++)
		{
			 ar1[i]=temp[j];
			 j++;
		}
		// My Array is sorted from {s....e}
	}

	private static int[] countSort(int[] ar) // T.C = O(N+N+R)= O(N+R)
	{										 // S.C = O( N )
		 int a,b;
		 int n=ar.length;
		 a=Integer.MAX_VALUE;
		 b=Integer.MIN_VALUE;
		 for(int i=0;i<n;i++) // Iterate & get min of Array
		 {
			 if(ar[i]<a)
			 {
				 a=ar[i];
			 }
		 }
		 for(int i=0;i<n;i++) // Iterate & get max of Array
		 {
			 if(ar[i]>b)
			 {
				 b=ar[i];
			 }
		 }
		 
		 
		 // Step-1 : Store Frequency of Array in HashMap
		 
		 HashMap<Integer,Integer> hm=new HashMap<>();
		 
		 for(int i=0;i<n;i++)
		 {
			 if(hm.containsKey(ar[i])==false)
			 {
				 hm.put(ar[i],1);
			 }
			 else
			 {
				 int f=hm.get(ar[i]);
				 hm.put(ar[i],f+1);
			 }
		 }
		 
		 // Step-2 : Sort Array using Frequency
		 
		 int j=0;// Start Filling Data from 0^th index
		 
		 for(int i=a;i<=b;i++) // Range [a...b]
		 {
			 int c=hm.getOrDefault(i,0);// How Many Times i in coming
			 
			 while(c>0)// While Loop Runs C-Times
			 {
				 ar[j]=i;
				 c--;
				 j++;
			 }
		 }
		 return ar;
		 
	}

	private static int[] merge(int[] a, int[] b) // T.C = O(N+M) = O(N+N) = O(N)
	{											 // S.C = O(1)
		int n=a.length;
		int m=b.length;
		
		int c[]=new int[n+m];
		int p1=0,p2=0,p3=0;
		
		while(p1<n && p2<m)
		{
			if(a[p1]<b[p2])
			{
				c[p3]=a[p1];
				p1++;
				p3++;
			}
			else
			{
				c[p3]=b[p2];
				p2++;
				p3++;
			}
		}
		
		while(p1<n)
		{
			c[p3]=a[p1];
			p1++;
			p3++;
		}
		
		while(p2<m)
		{
			c[p3]=b[p2];
			p2++;
			p3++;
		}
		
		return c;
	}

	private static int[] Sort(int[] ar) 
	{
		 // Step-1 : Store Frequency of Array in HashMap
		
		int n=ar.length;
		
		HashMap<Integer,Integer> hm=new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
			if(hm.containsKey(ar[i])==false)
			{
				hm.put(ar[i],1);// Array 1^st Time
			}
			else
			{
				int f=hm.get(ar[i]);
				hm.put(ar[i],f+1);
			}
		}
		
		// Step-2 : Sort Array using Frequency
		
		int j=0;// Start filling data from 0^th index
		
		for(int i=2;i<=6;i++)
		{
			
			int c=hm.getOrDefault(i,0);// How Many Times i in Coming
			
			while(c>0)// While Loop Runs c-times
			{
				c--;
				ar[j]=i;
				j++;
			}
			
		}
		
	  return ar;		
	}

}
