import java.util.HashMap;
import java.util.HashSet;

public class Class_23_Hashing_2 
{

	public static void main(String[] args) 
	{
		// Q1) First Non-Repeating Element
		
		int ar[]= {1,2,3,1,2,5};// Ans=3;
		
		/* Idea-1 : Iterate on Every Element and check if it's repeating or not
		 * 
		 * For That Calculate frequency == 1 : Non - Repeating
		 * 
		 */
		nonRepeating1(ar);
		
		/* Idea-2 : 1) Insert All Elements in HashMap.
		 * 
		 * Note : Map Order not Maintained.
		 * 
		 * 2) Iterate on Array & Return First with Freqency==1
		 *  
		 */
		int ans2=nonRepeating2(ar);
		System.out.println("Non-Repeating 2 : "+ans2);
		
		// Q2) Count PairSum
		
		/* Given an Array, Count no:of pairs such that
		 * 
		 * ar[i]+ar[j]=k && i!=j && (i,j)=(j,i) are same pairs.
		 *  
		 */
		int ar1[]= {7,3,2,3,7,8};// Ans=5
		
		/* Idea-1 : Generate All Pairs SUms & Check if their Sum==k & Increment C 
		 * 
		 * T.C = O(N^2)
		 * S.C = O(1)
		 */
		int ans3=pairCount1(ar1,10);
		System.out.println("Pairs Count : "+ans3);
		
		
		
		/* Idea-2 :
		 * 
		 * Observation : For Every Array
		 * 				 Calculate Count of K-ar[i] on left side.
		 * 
		 * Idea : Use HashMap
		 * 
		 * Catch : Count of particular element only on left side.
		 * 
		 * Con : HashMap Should contain only left elements.
		 *   
		 */
		int ans4=pairCount2(ar1,10);
		System.out.println("Pairs Count : "+ans4);
		
		// Q3) Given Array Elements check if there exists a Subarray with Sum=0
		
		// Subarray --> Continuous Part of an Array(PrefixSum is good to Start)
		
		// Eg : Ar[]={2,-1,0,2,3}; return True.
		
		/* Idea-1 : For All Subarrays Check if their Sum == 0.
		 * 
		 * T.C = O(N^2 * N)= O(N^3)
		 * S.C = O(1)
		 *  
		 * Idea-2 : Optimize with Prefix Sum 
		 *  
		 * T.C = O(N^2)
		 * S.C = O(N)
		 * 
		 * Idea-3 : Psum[i] 
		 * 
		 * Observation 1 : Psum[] Elements are Repeating => There is Subarray with Sum=0;
		 * 
		 * Observation 2 : Issue => No Repeatation, still have a Subarray With sum=0.
		 * 
		 * Resolve 1: Check if there is a '0' in prefixSum[]
		 * 
		 * Resolve 2: Initialize HashSet with '0'
		 * 			  If next Time '0' comes, It Gives Repetition
		 * 
		 */
		int ar2[]= {2,-5,3,6};
		boolean ans=isSubarrayZero(ar2);
		System.out.println("SubArraySum=0 : "+ans);
		
		// Q4) Check if There Exists a Subarray with Sum = k
		
		int ar3[]= {2,3,9,-4,1,5,6,2,5};
		int k=10;
		
		/* Idea-1 : Genearte All Subarrays & Iterate and get SUm==k
		 * 
		 * T.C = O(N^3)
		 * S.C = O(1)
		 * 
		 * Idea-2 : Genearte All Subarrays Sums
		 * 
		 * a) Using pfSum[] -->T.C=O(N^2)
		 * 					-->S.C=O(1)
		 * 
		 * b) Using Carryforward --> O(N^2)
		 * 						 --> O(1)
		 * 
		 * Idea-3 : For a given Element, we need to Search target on left : HashSet
		 * 
		 * Catch : In HashSet will we store All ELements --> No
		 * 		   I am only Searching on Left, HashSet should only contain leftside elements.
		 *  
		 *  Note : Initialize hashset with 0, because during subarray sum we start with 0.
		 *  
		 */
		boolean ans5=isSubK(ar3,k);
		
		
	}

	private static boolean isSubK(int[] ar, int k) // T.C = O(N)
	{											   // S.C = O(N)
		int n=ar.length;
		int pf[]=new int[n];
		int sum=0;
		
		for(int i=0;i<n;i++)
		{
			sum=sum+ar[i];
			pf[i]=sum;
		}
		
		HashSet<Integer> hs=new HashSet<>();
		hs.add(0);
		for(int i=0;i<n;i++)
		{
			int tar=pf[i]-k;
			if(hs.contains(tar)==true)
			{
				return true;
			}
			hs.add(pf[i]);
		}
		
		// No Subarray with Sum=k
		return false;
	}

	private static boolean isSubarrayZero(int[] ar) // T.C = O(N)
	{												// S.C = O(N)
		int n=ar.length;
		
		int pf[]=new int[n];
		int sum=0;
		
		for(int i=0;i<n;i++)
		{
			sum=sum+ar[i];
			pf[i]=sum;
		}
		
		HashSet<Integer> hs=new HashSet<>();
		hs.add(0);
		for(int i=0;i<n;i++) // Insert psum[] in HashSet
		{
			if(hs.contains(pf[i])==false)
			{
				hs.add(pf[i]);
			}
			else // Repetion => Subarray with sum=0;
			{
				return true;
			}
		}
		
		// No Repeatition => No Subarray with Sum=0
		return false;
	}

	private static int pairCount2(int[] ar, int k) // T.C = O(N)
	{											   // S.C = O(N)
		int c=0,n=ar.length;
		
		HashMap<Integer,Integer> hm=new HashMap<>();
		
		for(int i=0;i<n;i++)
		{
								
			if(hm.containsKey(ar[i])==false)// Insert Array in HashMap
			{
				hm.put(ar[i],1);
			}
			else //Increment Frequency by 1
			{
				int f=hm.get(ar[i]);
				hm.put(ar[i],f+1);
			}
			int tar=k-ar[i];// Get Frequency of Target Element
			if(hm.containsKey(tar))
			{
				c=c+hm.get(tar);
			}
		}
		return c;
	}

	private static int pairCount1(int[] ar1, int k) // T.C = O(N^2)
	{												// S.C = O(1)
	   int n=ar1.length,c=0;
	   
	   for(int i=0;i<n;i++)
	   {
		   int target=k-ar1[i];
		   
		   // Search for Target on Left of i : { 0,1,2....i-2,i-1};
		   
		   for(int j=0;j<i;j++)
		   {
			   if(ar1[j]==target)
			   {
				  c++; 
			   }
		   }
	   }
	   return c;
	}

	private static int nonRepeating2(int[] ar) // T.C = O(N+N)
	{										   // S.C = O(N)
		 int n=ar.length;
		 
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
		 
		 for(int i=0;i<n;i++)
		 {
			 if(hm.get(ar[i])==1)
			 {
				 return ar[i];
			 }
		 }
		 return -1;// If No Non-Repeating Integers.
	}

	private static void nonRepeating1(int[] ar) // T.C = O(N^2)
	{											// S.C = O(1)
		int n=ar.length;
		
		for(int i=0;i<n;i++)
		{
			int c=0;
			for(int j=0;j<n;j++)
			{
				if(ar[i]==ar[j])
				{
					c++;
				}
			}
			if(c==1)// Array[i] is non-repeating
			{
				System.out.println(ar[i]);
				break;
			}
		}
	}

}
