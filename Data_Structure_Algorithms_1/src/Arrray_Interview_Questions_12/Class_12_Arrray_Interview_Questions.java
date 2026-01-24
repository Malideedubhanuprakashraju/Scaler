package Arrray_Interview_Questions_12;

public class Class_12_Arrray_Interview_Questions 
{

	public static void main(String[] args) 
	{
		/* Analyze Constraints
		 * 
		 * 1 <= N <= 10^5	,	1 <= ar[i] <= 10^9
		 * 
		 * Steps :
		 * 
		 * 1) Basic Logic --> Estimate TC --> Check TLE or Not using Constraints.
		 * 		Logic-1	  --> O(N^2)	  --> (10^5)^2 = 10^10 > 10^8---> TLE
		 * 
		 * Reverse Through Process :
		 * 										------> will O(N) : 10^5 <10^8 : Yes
		 * 										|
		 * 1) Constraints : 1 <= N <= 10^5		|-----> will O(NlogN) : 10^5 * log10^5 <10^8 : 10^5*16~~ 1.6*10^6 : Yes
		 * 										|
		 * 										------> will O(N^2) : 10^10 >10^8 : No
		 * 
		 *  
		 * Idea : We need to Think interms of N or NlogN
		 * 
		 * 2) Constraints : 1 <= N <= 20, Because constarints small, TC is Big.
		 * 
		 * 	  Idea : 2^N,	N!, We need to Think interms
		 * 			  |		|
		 * 			  |		----->All Permutations/Combinations
		 * 			  |
		 * 			  ---> All Subsets/Subsequences
		 * 
		 */	
		
		// Q1) Given a Binary Array, we can atmax Replace a single 0 with 1
		//				|					 |
		//				--> 0/1				 -----> 0 Replace or 1 Replace
		// Find Max Conseutive 1's we can get in your Array
		// Edge Case : If All Values are 1, ans= N.
		// Idea : For Every 0 :
		// 		  			 	Iterate & Calculate Consecutive 1's on Left = l
		//						Iterate & Calculate Consecutive 1's on Right = r
		//						Count = l+r+1 & get Overall Max.
		int ar[]= {1,1,0,1,1,0,1,1,1};
	
		int ans=consecutiveOnes(ar);
		System.out.println(ans);
		
		// Q2) Given a Binary Array, we can atmax Swap a Single 0 with 1.
		//				|						   |
		//				----> 0/1				   ------> Both Elements have to be in Array
		// Find Max Consecutive 1's we can get in your Array
		// ar[] = {1,1,1,0,1,1,0}
		//		   l=3	 | r=2 | r=0
		//				 c=l+r c=l+r+1
		//				 c=5   c=3
		// Q: How do we know Extra1
		// if(Total-ones > l+r)
		// {
		//		c=l+r+1; //Extra 1
		// }
		// else
		// {
		//		c=l+r; // No extra 1
		// }
		int ar1[]= {1,1,1,0,1,1,0};
		int ans1=consectiveOneSwap(ar1);
		System.out.println(ans1);
		
		// Q3) Majority Element :
		// 	   Given Array Elements, Return Majority Element.
		//	   An Element is Said to be Majority --> If Ele Occurence > N/2.
		//	Note : If No Majority Element Return -1
		
		/* Eg-1 : Ar[3] = {2,1,4};
		 * 
		 * Is There any Element Frequency > 3/2 =>1
		 * 
		 * No Such Element : Return -1;
		 * 
		 * Eg-2 : Ar[7] = {3,4,3,2,4,4,4};
		 * 
		 * Is There any Element Frequency > 7/2 =>3
		 * 
		 * Freqency of 4 > 3 : return 4;
		 * 
		 * 
		 * At Max How Many Majority Elements we can Have : 1
		 * 
		 * eg-1 : If an Ele is Majority = Freq of Ele > N/2
		 * 
		 * Idea-1 : For Every Arr[i] --> Iterate on Array & get Frequency > N/2
		 *   
		 */
		int ar2[]= {3,4,3,6,1,3,2,5,3,3,3};
		int ans2=MajorityEle(ar2);
		System.out.println(ans2);
		
		/* Optimization Code
		 * 
		 * Note : When we Removed 2 different, things Majority Element Will Remain
		 * 
		 * Note : When we Removed 2 Same Things Majority Ele we Might Loose Majority
		 * 
		 * Idea :
		 * 		1) Keep Deleting 2-Different Element,til a Same Element Left Out.
		 * 		2) Check if Leftout Ele is Majority or Not ?
		 * 
		 * Note : At any Point Freq =>0, Element is Deleted. 
		 * 
		 */
		int ans22=Majority(ar2);
		System.out.println(ans22);
	}
	
	// Algorithm : Moor's Voting Algorithm 
	/* 
	 * Every non-majority element cancels with a majority element

	   Majority element count is > n/2, so it survives

	   Final candidate must be the majority (if one exists)
	 * “Moore’s Voting Algorithm finds a potential majority element by cancelling different elements. 
	 * If a majority exists, it will survive. Then we verify it in a second pass.”
	 */
	private static int Majority(int[] ar2) // T.C = O(N)
	{									   // S.C = O(1)
		 int n=ar2.length;
		 int ele=ar2[0],freq=1;
		 for(int i=1;i<n;i++)
		 {
			 if(freq==0)
			 {
				 ele=ar2[i];
				 freq=1;
			 }
			 else if(ele==ar2[i])
			 {
				 freq++;
			 }
			 else //ele !=ar[i]
			 {
				 freq--;
			 }
		 }
		 int c=0;
		 for(int i=0;i<n;i++)
		 {
			 if(ar2[i]==ele)
			 {
				 c++;
			 }
		 }
		 if(c>n/2)
		 {
			 return ele;
		 }
		 else
		 {
			 return -1;
		 }
		 
	}

	private static int MajorityEle(int[] ar2) // T.C = O(N^2)
	{										  // S.C = O(1)
		 int n=ar2.length;
		 for(int i=0;i<n;i++)
		 {
			 int c=0;
			 for(int j=0;j<n;j++)
			 {
				 if(ar2[i]==ar2[j])
				 {
					 c++;
				 }
			 }
			 if(c>n/2)
			 {
				 return ar2[i];
			 }
		 }
		 return -1;
	}

	private static int consectiveOneSwap(int[] ar1)// T.C=O(N), S.C=O(1)
	{
		int n=ar1.length;
		int ans=0;
		int ones=0;
		for(int i=0;i<n;i++)
		{
			if(ar1[i]==1)
			{
				ones++;
			}
		}  
		if(ones==n)
		{
			return n;
		}
		
		for(int i=0;i<n;i++)
		{
			if(ar1[i]==0)
			{
				int l=0;
				for(int j=i-1;j>=0;j--)
				{
					if(ar1[j]==1)
					{
						l++;
					}
					else
					{
						break;
					}
				}
				int r=0;
				for(int j=i+1;j<n;j++)
				{
					if(ar1[j]==1)
					{
						r++;
					}
					else
					{
						break;
					}
				}
				int c=l+r;
				if(ones>l+r)// Extra 1-Possible
				{
					c=c+1;
				}
				ans=Math.max(ans, c);
			}
		}
		return ans;
	}

	private static int consecutiveOnes(int[] ar) // T.C= O(N) , //But people Think it's O(N^2) But Not
	{											 //	S.C= O(1) , Note : If we have break in inner loops calculate iterations carefully & estimate Big O.
		 int n=ar.length;
		 int ans=0;
		 int ones=0;
		 for(int i=0;i<n;i++)
		 {
			 if(ar[i]==1)
			 {
				 ones++;
			 }
		 }
		 if(ones==n)//Edge Case
		 {
			 return n;
		 }
		 for(int i=0;i<n;i++)
		 {
			 if(ar[i]==0)// Get Consecutive 1's count on Left & Right
			 {
				 int l=0;
				 for(int j=i-1;j>=0;j--)
				 {
					 if(ar[j]==1)
					 {
						 l++;
					 }
					 else
					 {
						 break;
					 }
				 }
				 
				 int r=0;
				 for(int j=i+1;j<n;j++)
				 {
					 if(ar[j]==1)
					 {
						 r++;
					 }
					 else
					 {
						 break;
					 }
				 }
				 int c=l+r+1;
				// System.out.println(c+" ans");
				 ans=Math.max(ans, c);
			 }
		 }
		 return ans;
	}

}
