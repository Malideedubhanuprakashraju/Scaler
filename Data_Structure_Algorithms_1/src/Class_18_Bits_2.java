import java.util.ArrayList;

public class Class_18_Bits_2 
{

	public static void main(String[] args) 
	{
		// Recap : Bit Manipulations
		
		/*	Check i^th Bit Set in N : (N>>i) & 1 ==1 : i^th Bit in N is Set.
		 * 
		 * 	Set i^th Bit in N : N = N | (1<<i)
		 * 	
		 * 	Flip i^th Bit in N : N= N ^ (1<<i)
		 * 
		 *  a ^ a = 0 // Same Same Puppy Shame = 0
		 * 
		 */
		
		// Q1) Given Array Every Elements Repeats Twice except 1, Return Unique Element.
		
		int a[]= {2,3,5,6,3,6,2};
		
		// Idea-1 : For Every Array & iterate & get it's Frequency == 1.
		
		int ans1=Repeats1(a);
		System.out.println("Single Element Among Twice :"+ ans1);
		
		// Idea-2 : Calculate XOR for All Elements.
		
		int ans2=Repeats1Opt(a);
		System.out.println("Single Element Among Twice Optimized Code :"+ans2);
		
		// Idea-3 : Every Element Repeat Some Number of Times Except 1-Element.
		
		/* Bit Wise Problems work on Bits
		 * 
		 * Let's write Binary Representation of Every Number.
		 * 
		 * Observation : Count no:of Set Bit's at Each Bit Position.
		 * 
		 * 
		 * Eg : ar[] = {2,3,5,6,3,6,2};
		 * 
		 * 2	:	0	1	0
		 * 3	:	0	1	1
		 * 5	:	1	0	1
		 * 6	:	1	1	0
		 * 3	:	0	1	1
		 * 6	:	1	1	0
		 * 2	:	0	1	0
		 * -------------------
		 * cnt  :	3	6	3
		 * 			O	E	O-->0^th Bit of Unique is Set.
		 * 			|	|------>1^st Bit of Unique is UnSet.
		 * 			|---------->2^nd Bit of Unique is Set.
		 * 
		 * Observation-1 : Without Unique Element, no:of Set Bits at each bit position is Even.
		 *   
		 */
		int ans3=SingleNumber(a);
		System.out.println("Single Number :"+ans3);
		
		// Q2) Given an Array, All The Elements will occurs Thrice Except 1-Element.
		// Find The Unique Element.
		
		int a1[]= {4,5,5,4,1,6,6,4,5,6};
		
		/* Idea-1 :
		 * 
		 * For Every Array[i] :
		 * 					Iterate on Array & get Frequency == 1
		 * T.C = O(N^2)
		 * S.C = O(1)
		 * 
		 * Idea-2 :
		 * 
		 * Take XOR of All Elements :
		 * 
		 * Issue : We are Calculating XOR of Each Individual Ele.
		 * 
		 * 4^5^5^4^1^6^6^4^5^6 = 4^5^6^1 = Not Correct Answer
		 * 
		 * 
		 * Idea-3 :
		 * 
		 * Observation : For each Bit : Count no:of Set Bits
		 *  
		 */
		int ans4=Singlenumber3(a1);
		System.out.println("Single Ele in Thrice Number :"+ans4);
		
		// Q3) Given an Array Ele, All The Elements will occurs Twice but  Two Ele Return Two Unique Elements.
		
		int ar2[]= {4,9,9,8};
		
		/* Idea-1 : For Every Array
		 * 				Iterate on All Array Ele get Frequency ==1.
		 * 
		 * T.C : O(N^2)
		 * S.C : O(1)
		 * 
		 * Idea-2 : Calculate XOR of All Elements :
		 * 
		 * Issue : We Cann't extract 2-Unique Numbers from Them.
		 * 
		 * 
		 * Idea-3 : XOR of All Elements := XOR of Both Unique Elements.
		 * 
		 * eg : ar[]={10,8,8,9,12,9,6,11,10,6,12,17};
		 * 
		 * 11	: 0	 1	0	1	1
		 * 17	: 1	 0	0	0	1
		 * -----------------------
		 * val	: 1	 1	0	1	0
		 * 
		 * Observation :
		 * 
		 * In Val 1^st Bit : Set ==> At 1^st Bit Both Unique Elements are Diff
		 * 
		 * Divide Array into 2-Parts
		 * Based on Value at 1^st Bit Position
		 * 					|
		 * -------------------------------
		 * |->i^th Bit : Set			|->i^th Bit : Unset
		 * a=0^10^6^11^10^6			   a=0^8^8^9^12^9^12^17
		 * => XOR of All Ele		   => XOR of All Ele
		 * => a=11					   => b=17
		 * 
		 * 
		 * Similarly for All Set : we need to Divide
		 * 
		 * Conclusion-1 : We Separate array Based on Bit Position in which both unique Ele are Different.
		 * 
		 * Conclusion-2 : After Calculating XOR values :
		 * 				  1) For That Values, get it's set bit position, at that position Both Unique Ele are Different.
		 *  
		 */
		int ar[]={10,8,8,9,12,9,6,11,10,6,12,17};
		ArrayList<Integer> arr=SingleNumber2N(ar);
		System.out.println(arr);
		
	}

	private static ArrayList<Integer> SingleNumber2N(int[] ar) // T.C = O(N+32+N)= O(N)
	{														   // S.C = O(1)
		 int xor=0;
		 for(int i=0;i<ar.length;i++)
		 {
			 xor=xor^ar[i];
		 }
		 
		 int p=-1;
		 for(int i=0;i<32;i++)
		 {
			 if(((xor>>i)&1)==1)
			 {
				 p=i; // At This bit, Both Unique Ele are Different.
			 }
		 }
		 
		 // Separate Array Based on P^th Bit Position
		 int a=0,b=0;
		 for(int i=0;i<ar.length;i++)
		 {
			 if(((ar[i]>>p)&1)==1)
			 {
				 a=a^ar[i];// Adding Set Side
			 }
			 else
			 {
				 b=b^ar[i];// Adding Unset Side
			 }
		 }
		 
		 ArrayList<Integer> arr=new ArrayList<>();
		 if(a<b)//Ascending Order
		 {
			 arr.add(a);
			 arr.add(b);
		 }
		 else
		 {
			 arr.add(b);
			 arr.add(a);
		 }
		 
		 return arr;
		 
	}

	private static int Singlenumber3(int[] a1) // T.C = O(32*N)
	{										   // S.C = O(1)
		 int n=a1.length;
		 int ans=0;
		 
		 // For each bit pos : Count how many elements have that bit set
		 
		 for(int i=0;i<32;i++)
		 {
			 int c=0; // Count no : of Array Ele With i^th Bit : Set
			 
			 for(int j=0;j<n;j++)
			 {
				 if(((a1[j]>>i)&1)==1)
				 {
					 c++;
				 }
			 }
			 
			 if(c%3!=0)// i^th Bit in Unique Number is Set.
			 {
				ans=ans|(1<<i); 
			 }
			 
		 }
		 return ans;
	}

	private static int SingleNumber(int[] a) // T.C = O(32*N) 
	{										 // S.C = O(1)
		 int n=a.length;
		 int ans=0;
		 // For Each Bit Pos : Count how many Elements have that Bit Set
		 
		 for(int i=0;i<32;i++)
		 {
			 int c=0; // Count no:of Array Ele with i^th Bit : Set
			 
			 for(int j=0;j<n;j++)
			 {
				 if(((a[j]>>i)&1)==1)
				 {
					 c++;
				 }
			 }
			 if(c%2!=0)// or(c%2==1) // i^th Bit in Unique Number is Set.
			 {
				ans= ans | (1<<i); 
			 }
			 
		 }
		 return ans;
		 /* I iterate through each bit position and count how many numbers 
		  * have that bit set. Since duplicate numbers contribute even counts, 
		  * only the unique number produces an odd count. 
		  * By setting those odd-count bits, I reconstruct the unique number, which is 5.”
		  * 
		  */
	}

	private static int Repeats1Opt(int[] a) // T.C= O(N)
	{										// S.C= O(1)
		 int n=a.length;
		 int ans=0; // A^0 = A => Won't Effect your XOR Values.
		 for(int i=0;i<n;i++)
		 {
			 ans=ans^a[i];
		 }
		 return ans;
	}

	private static int Repeats1(int[] a) // T.C= O(N^2)
	{									 // S.C= O(1)
		int n=a.length;
		
		for(int i=0;i<n;i++)
		{
			int c=0;
			for(int j=0;j<n;j++)
			{
				if(a[i]==a[j])
				{
					c++;
				}
			}
			if(c==1)
			{
				return a[i];
			}
		}
		return 0;
	}

}
