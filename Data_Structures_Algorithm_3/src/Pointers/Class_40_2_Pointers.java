package Pointers;

public class Class_40_2_Pointers 
{

	public static void main(String[] args) 
	{
		/* Q1) Given Array[N] Distinct Sorted Elements, Check if there exists a Pait(i,j) Such That ar[i]+ar[j]=k && i!=j
		 * 
		 * Eg : ar[7] = {3,7,8,11,14,19,20}; 
		 * 
		 * k = 25 : return True
		 * 
		 * Idea-1 :
		 * 
		 * a) Check Sum for all Pairs
		 * 
		 * T.C = O(N^2)
		 * S.C = O(1)
		 * 
		 * Idea-2 :
		 * 
		 * b) Using Binary Search
		 * 
		 * T.C = O(N log N)
		 * S.C = O(1)
		 * 
		 * For each a = ar[i] & search for b=K-ar[i] on Right Using BS.
		 * 
		 * Eg : ar[7] = { 3,7,8,11,14,19,20 };
		 * 
		 * 		k=25;
		 * 
		 * a + b = 25
		 * 
		 * 3   b = 22 : Search for 22 : from [1....6]
		 * 7   b = 18 : Search for 18 : from [2....8]
		 * 8   b = 17 : Search for 17 : from [3....6]
		 * 11  b = 14 : Search for 14 : from [4....6]
		 * 
		 * 
		 * 
		 * Idea-3 : Using HashSet / HashMap
		 * 
		 * T.C = O(N)
		 * 
		 * S.C = O(N)
		 * 
		 * 
		 * Idea-4 : 2-Pointer 
		 * 
		 * a) Initilize 
		 * 
		 * b) Update
		 * 
		 */
		int ar[]= {-3,0,1,3,6,8,11,14,18,25};
		int k=17;
		
		boolean ans=checkSum(ar,k);
		System.out.println("Check Sum : "+ans);
		
		/* In 2-Pointer we discard an element, 
		 * 
		 * if we are sure that with element we cannot get ans/better ans.
		 *  
		 */
		
		/* Q2) Given a Sorted Array, Where Elements Repeat Count no:of Pairs (i,j)
		 * 
		 * Such that ar[i] + ar[j] = k (i!=j)
		 *  
		 */
		int arr[]= {3,5,5,5,8,8,8,8,11,11,11,11,17};
		int s=16;
		
		int ans1=CountSum(arr,s);
		System.out.println("Count Pairs Ele Repeats : "+ans1);
		
		/* ar[p1]+ar[p2] > K
		 * 			
		 * 		 P2--;
		 * else if < K
		 * 		 P1++;
		 * 
		 * sum==k
		 * 		 a) Iterate & Count no:of ar[p1] = c1;
		 * 
		 * 		 b) Iterate & Count no:of ar[p2] = c2;
		 * 
		 * ans = ans + c1*c2
		 * 
		 * a) if ar[p1] == ar[p2]
		 * 
		 * b) How Many Values are There : ar[p1]......ar[p2]; p = p2-p1+1
		 * 
		 * c) In How Many Values are There : ar[p1].....ar[p2]; p=p2-p1+1
		 * 
		 * P
		 * 	C = (P)(P-1)
		 * 	 2	--------
		 * 		   2
		 * 
		 * Explanation : Nc2 = N!/(N-2)!*2! = N * (N-1) * (N-2) / (N-2)! * 2! = (N)(N-1)/2;
		 * 
		 * (5,11) → 12 pairs
		   (8,8)  → 6 pairs
		  ------------------
		   Total  → 18 pairs
		  
		 */
		
		/* Q3) Given Array[N] Sorted Elements, Check if there exists a Pair(i,j)
		 * 
		 * 	   Such that ar[j]-ar[i]=k && i!=j && k>=0
		 * 
		 * Eg : ar[] = {1,2,4,5,6,12}, k=10
		 * 
		 * Ans = True
		 * 
		 * Idea-1 :
		 * ------
		 * 
		 * Check for All Pairs 
		 * 
		 * T.C = O(N^2) , S.C = O(1)
		 * 
		 * Idea-2 :
		 * ------
		 * 
		 * Check with Binary Search
		 * 
		 * T.C = O(N*logN) , S.C = O(1)
		 * 
		 * Idea-3 :
		 * ------
		 * 
		 * Check with HashMap/HashSet
		 * 
		 * T.C = O(N) , S.C = O(N)
		 *  
		 * Idea-4 :
		 * ------
		 * 
		 * 2-Pointers
		 *  
		 */
		int a[]= {-3,0,1,3,6,8,11,14,21,25};
		int p=5;
		boolean ans2=Diff(a,p);
		
		/* Case-1 : 0 , n-1
		 * ------
		 * 
		 * p1	p2	: ar[p2]-ar[p1]
		 * 
		 * 0	9	: D > 5 { Dec Diff }
		 * 			
		 * 			If p1++; Inc Diff
		 * 			If p2--: Inc Diff
		 * 
		 * Issue : Ambiguity/Confusion.
		 * 
		 * Above is incorrect way to initialize
		 * 
		 * 
		 * Case-2 : n/2 , n/2+1
		 * ------
		 * P1	p2 : ar[p2]-ar[p1]
		 * 
		 * 4	5  :  	8  -  6	= 2<5 : InC Diff
		 * 
		 * 				If p1--; Inc Diff
		 * 				If p2++; Inc Diff
		 * 
		 * Issue : Ambiguity/Confusion
		 * 
		 * Above is incorrect way to initialize
		 * 
		 * Case-3 : p1=0, p2=1;
		 * 
		 * P1	P2	: ar[p2] - ar[p1]
		 * 
		 * 0	1	:   0 - (-3) = 3 < 5 : Inc Diff : p2++
		 * 
		 * 0	2	:	1 - (-3) = 4 > : Inc Diff : p1++
		 * 
		 * 					if 5==5 : Return True
		 * 
		 * 
		 * If K < 0 :
		 * --------
		 * 
		 * ar[3] = {4,10,13};
		 * 
		 * k=3;
		 * 
		 * Pair k=3 : ar[2]-ar[1] = 3;
		 * 
		 * Pair k=-3 : ar[1]-ar[2] = -3;
		 * 
		 * 
		 * Observation :
		 * 
		 * if ar[i]-ar[j] = k <==> ar[j]-ar[i] = -k
		 * 
		 * Con : If Pair with Diff K exists <==> Pair with -k also Exists
		 * 
		 */
		
	}

	private static boolean Diff(int[] a, int k) // T.C = O(N)
	{											// S.C = O(1)
		k=Math.abs(k);
		
		int n=a.length;
		int p1=0;
		int p2=1;
		
		while(p2<n)
		{
			int diff=a[p2]-a[p1];
			
			if(diff > k)
			{
				p1++;
				
				if(p1==p2)
				{
					p2++;
				}
			}
			else if(diff<k)
			{
				p2++;
			}
			else
			{
				return true;
			}
		}
		return false;
	}

	private static int CountSum(int[] ar, int k) // T.C = O(N)
	{											 // S.C = O(1)
		int ans=0;
		int p1=0;
		int n=ar.length;
		int p2=n-1;
		
		while(p1<p2)
		{
			int sum=ar[p1]+ar[p2];
			
			if(sum>k) // Dec Sum
			{
				p2--;
			}
			else if (sum<k) // Inc Sum
			{
				p1++;
			}
			else //Sum==K
			{
				if(ar[p1]!=ar[p2])
				{
					int c1=0;
					
					for(int i=p1;i<n;i++)
					{
						if(ar[i]==ar[p1])
						{
							c1++;
						}
						else
						{
							break;
						}
					}
					
					int c2=0;
					
					for(int i=p2;i>=0;i--)
					{
						if(ar[i]==ar[p2])
						{
							c2++;
						}
						else
						{
							break;
						}
					}
					
					ans=ans+c1*c2;// Different elements
					p1=p1+c1;
					p2=p2-c2;
				}
				else
				{
					int p=p2-p1+1;
					ans=ans+(((p)*(p-1))/2);// Same elements
					break;
				}
			}
		}
		return ans;
	}

	private static boolean checkSum(int[] ar, int k) // T.C = O(N)
	{												 // S.C = O(1)
		 int p1=0,p2=ar.length-1;
		 
		 while(p1<p2)
		 {
			 int s=ar[p1]+ar[p2];
			 
			 if(s==k)
			 {
				 return true;
			 }
			 
			 if(s>k) // Dec Sum
			 {
				 p2--;
			 }
			 else // Inc Sum
			 {
				 p1++;
			 }
		 }
		 return false;
	}

}
