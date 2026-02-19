package Searching;

public class Class_26_Searching_1 
{

	public static void main(String[] args) 
	{
		 /* Searching Basics
		  * 								   ---------> Who : Whom to Search : Target	
		  * Bro/Sis Missing ---> PoliceStation |
		  * 								   ---------> Where : Where to Search : Search Space
		  * 
		  * Eg : 
		  * 
		  * Target --> Search Space
		  * 
		  * Word   --> { Dictionary / Books / News Paper }
		  * 
		  * PhoneNo -> { Contact / PhoneBook }
		  * 
		  * Observation : If Search Space is Ordered, Searching becomes easier
		  * 
		  * Where to Land ?
		  * 
		  * Why Mid ?
		  * 
		  * 	-------------------------
		  * N	|	N/2		|		N/2 | : Always Discard = N/2 = N/2 Discard
		  * 	-------------------------
		  * 
		  * 	--------------------------
		  * N	|	N/3		|	  2*N/3  | : Discard Left : N/3-------> N/3 : Worst Case
		  * 	--------------------------	 Discard Right :2*N/3
		  * 
		  * When to Apply BS :
		  * 
		  * 				  After Dividing Search Space in to 2-parts, if we can discard 1^st Half of Search Space using some conditions, then we can apply Binary Search
		  * 
		  * 	   -----------------------
		  * Note : |	N/2		|	N/2	 | ====> If We Cannot discard, we cannot Apply BS
		  * 	   -----------------------
		  *  
		  */
		
		// Q1) Given a Sorted Array Search if K is present or not ?
		
		int ar[]= {3,6,9,12,14,19,20,23,25,27};
		int k=27;
		
		/* Idea-1 : Iterate on All Elements & Search for K 
		 * 
		 * T.C : O(N)
		 * S.C : O(1)
		 * 
		 * Idea-2 : Target=k , SearchSpace = ar[]
		 * 
		 * 	0	1	2	3	mid-1	mid		mid+1	.	. N-1
		 * 
		 * 							if(ar[mid]==k) : return True
		 * 							
		 * 							else if(ar[mid]>k) : Go to Left <-------
		 * 						
		 * 							else (ar[mid]<k) : Go to Right --------->
		 * 
		 * Note : We can use low(l) & high(h) to indicate SearchSpace.
		 *  
		 */
		boolean ans1=searchK(ar,k);
		System.out.println("Element in Array ? "+ans1);
		
		/* 																 log N
		 * T.C : Initially Search Space = N	-> N/2 -> N/4 -> N/8 -> N/16 ------>1
		 * 
		 * Best Case : Element at Mid ==> O(1)
		 * 
		 * Worst Case : O(log N)
		 * 
		 * Average Case : O(log N)
		 * 
		 * Final T.C = O(log N)
		 * 
		 * Final S.C = O(1)
		 * 
		 * Whenever search space reduces by half → Think log N
		 * 
		 */
		
		// Q2) Given an Sorted Array, Find The First Occurrence index of given Element ?
		
		int ar2[]= {-5,-5,-3,0,0,1,1,5,5,5,5,5,5,8,10,10,15};
		int k2=5;
		
		int ans2=firstOccurenceIndex(ar2,k2);
		System.out.println("First Index in Array : "+ans2);
		
		/* 
		 * Idea-1 : Iterate on Array & get 1^st Occurance Index
		 * 
		 * T.C = O(N)
		 * S.C = O(1)
		 * 
		 * 
		 * Idea-2 : Target = 1^st Occurence Index : K
		 * 
		 * Search Space = Array
		 * 
		 * Ans=-1; // If Element Doesn't Exists
		 *   
		 */
		
		// Q3) Given an Sorted Array, Find The Last Occurrence index of given Element ?
		
		int ans3=LastOccur(ar2,k2);
		System.out.println("Last Occurence/index in Array : "+ans3);
		
		// Q4) Given a Unsorted Array with All Distinct Elements return Anyone Local Maxima
		
		// Local Maxima : An Element is Said to be Local Maxima, if > Than it's Adjacent Elements {immediate left & right}
		//																						ar[i] > ar[i-1] && ar[i] > ar[i+1]
		// if i==0 : Array[0] is Local Maxima => ar[0] > ar[1]
		// if i==n-1 : Array[n-1] is Local Maxima => ar[n-1] > ar[n-2]
		
		
		
		/* Return Any one of Local Maxima
		 * 
		 * What to return, if no Local Maxima?
		 * 
		 * Ans : We will get Max of Array
		 * 		 
		 * Max Will > It's Adjacent Element
		 * |
		 * -----> It will be Local Maxima.
		 * 
		 * Idea-1 : Iterate & Return Max of Array
		 * 
		 * T.C = O(N)
		 * S.C = O(1)
		 * 
		 * 
		 * Idea-2 : Target = Anyone Local Maxima
		 * 
		 * Search Space = In Array
		 * 
		 * Discard = ?
		 * 
		 * Case-1 : ar[m-1] < ar[m] > ar[m+1]
		 * 
		 * Local Maxima = return ar[m]
		 * 
		 * 
		 * Case-2 : ar[m-1] < ar[m] <ar[m+1] 
		 * 
		 * Local Maxima = Go to Right , L= m+1;
		 * 				  Because it's Increment on Right 
		 * 
		 * Case-3 : ar[m-1] > ar[m] > ar[m+1]
		 * 
		 * Local Maxima = Go to Left , h= m-1;
		 * 				  Because it's Increment on Left
		 * 
		 * Case-4 : Go to Any Side
		 * 
		 * 			ar[m-1] > ar[m] < ar[m+1]
		 * 			
		 * 			if(ar[m+1] > ar[m]) : On Right it's guarantee that we have local maxima --> Go to Right
		 * 
		 * Observation : Go to Side which Data a Increment, It will give us Any one Local Maxima
		 * 
		 */
		int ar4[]= {9,8,7,3,6,4,1,5,2,10,-4};// Ans=9,6,5,10
		int ans4=LocalMaxima(ar4);
		System.out.println("Local Maxima : "+ans4);
		
		// Q5) Every Element Occurs twice except for 1, find Unique Element
		//	   Note : Duplicates are Adjacent to Each Other.
		
		
		
		/* Idea-1 : Iterate on Array, Check Adjacnet Elements & find Unique
		 * 
		 * T.C = O(N)
		 * S.C = O(1)
		 * 
		 * Idea-2 : Iterate on Array, Calculate XOR of All Elements
		 * 
		 * T.C = O(N)
		 * S.C = O(1)
		 * 
		 * Idea-3 : Target : Unique Element
		 * 			SearchSpace : In Array
		 * 			Discard : ?
		 *  
		 */
		int ar5[]= {6,6,2,2,7,9,9,4,4,10,10};
		
		int ans5=Unique(ar5);
		System.out.println("Uniqe Element : "+ans5);
		
		
	}

	private static int Unique(int[] ar) // T.C = O(log N)
	{									// S.C = O(1)
		 int n=ar.length;
		 
		 int l=0;
		 int h=n-1;
		 
		 if(n==1)
		 {
			 return ar[0];
		 }
		 
		 if(ar[0]!=ar[1])
		 {
			 return ar[0];
		 }
		 
		 if(ar[n-1]!=ar[n-2])
		 {
			 return ar[n-1];
		 }
		 
		 
		 while(l<=h)
		 {
			 int m=(l+h)/2;
			 
			 if(ar[m-1]!=ar[m] && ar[m]!=ar[m+1])
			 {
				 return ar[m];
			 }
			 
			 if(ar[m]==ar[m-1])
			 {
				 m=m-1;
			 }
			 
			 // After Bringing in to 1^st Occurence
			 
			 if(m%2==0)//Left
			 {
				 l=m+2;// Go to Right
			 }
			 else
			 {
				 h=m-1;// Go to Left
			 }
		 }
		 return -1;
	}

	private static int LocalMaxima(int[] ar) // T.C = O(log N)
	{										 // S.C = O(1)
		 int n=ar.length;
		 
		 if(n==1)
		 {
			 return ar[0];
		 }
		 
		 if(ar[0]>ar[1])
		 {
			 return ar[0];
		 }
		 
		 if(ar[n-1]>ar[n-2])
		 {
			 return ar[n-1];
		 }
		 
		 int l=0;
		 int h=n-1;
		 
		 while(l<=h)
		 {
			 int m=(l+h)/2;
			 if(ar[m-1] < ar[m] && ar[m] >ar[m+1])
			 {
				 return ar[m];
			 }
			 
			 if(ar[m-1]>ar[m])
			 {
				 h=m-1;
			 }
			 else
			 {
				 l=m+1;
			 }
		 }
		 return -1;
	}

	private static int LastOccur(int[] ar2, int k2) // T.C = O(log N)
	{												// S.C = O(1)
		int n=ar2.length;
		
		int l=0;
		int h=n-1;
		int ans=-1;
		while(l<=h)
		{
			int m=(l+h)/2;
			
			if(ar2[m]==k2)
			{
				ans=m;
				l=m+1;
			}
			else if(ar2[m]>k2)
			{
				h=m-1;
			}
			else
			{
				l=m+1;
			}
		}
		
		return ans;
	}

	private static int firstOccurenceIndex(int[] ar2, int k2) // T.C = O(log N)
	{														  // S.C = O(1)
		int n=ar2.length;
		
		int l=0;
		int h=n-1;
		int ans=-1;
		while(l<=h)
		{
			int m=(l+h)/2;
			
			if(ar2[m]==k2)
			{
				ans=m;
				h=m-1;
			}
			else if(ar2[m]>k2)
			{
				h=m-1;
			}
			else
			{
				l=m+1;
			}
		}
		
		return ans;
	}

	private static boolean searchK(int[] ar, int k) 
	{
		 int n=ar.length;
		 int low=0;
		 int high=n-1;
		 
		 while(low<=high)
		 {
			 int mid=(low+high)/2;
			 
			 if(ar[mid]==k)
			 {
				 return true;
			 }
			 else if(ar[mid]>k)
			 {
				 high=mid-1;
			 }
			 else
			 {
				 low=mid+1;
			 }
		 }
		 return false;
	}

}
