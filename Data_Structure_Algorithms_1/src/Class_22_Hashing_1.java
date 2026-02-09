import java.util.HashMap;
import java.util.HashSet;

public class Class_22_Hashing_1 
{

	public static void main(String[] args) 
	{
		/* Given N-Students id & marks for each student & Q-Queries
		 * 
		 * 3-Types of Queries are present.
		 * 
		 * 1) Given id, check if id exist or not
		 * 
		 * 2) Given id, return marks of that student
		 * 
		 * 3) Given id, increment marks of student by 10
		 * 
		 * Note : Every Student will have a different id.
		 * 
		 * 
		 * Idea -1 : Total TC : O(Q*N)
		 * 				   SC : O(1)
		 * 
		 * Type-1 : Iterate on id[] check present or not.
		 * 			TC : O(N),	SC : O(1)
		 * 
		 * Type-2 : Iterate on id[]
		 * 				If present return it's marks
		 * 			TC : O(N), SC : O(1)
		 * 
		 * Type-3 : Itearte on id[]
		 * 				If present increment marks by 10
		 * 			TC : O(N), SC : O(1)
		 * 
		 * To Overcome this problems---> New Data Structure --> HashMap
		 * 
		 * Single			DataStructure
		 * Operations :			Arrays			HashMap
		 * 
		 * 		Insert			 O(1)
		 * 		Search			 O(N)
		 * 									}	 O(1)Time
		 * 		Update			 O(N)
		 * 		Delete			 O(N)
		 * 		Access			 O(N)				
		 *  
		 */
		
		/* HashMap :
		 * 
		 * 1) We Insert in <Key , Value) Pairs
		 * 
		 * 2) Keys are distinct/different
		 * 
		 * 3) Insert/Search/Access/Update/Delete = O(1)
		 * 
		 * 
		 * HashMap in Other Languages
		 * 
		 * 	Java		c++					Python
		 * HashMap		Unordered-Map		Dictionary
		 * 
		 * 
		 * Creation in Java :
		 * 
		 * HashMap < Key-Type, Value-Type > hm = new HashMap <>();
		 * 
		 * Note :	if we want
		 * 
		 * 			int ---> Integer	float ---> Float	char ----->	Character
		 * 			long --> Long		double --> Double	String --->	String
		 * 
		 * Key-Type : It can be from Above Types
		 * 
		 * Value-Type : It can be Anything
		 * 
		 * 
		 * Note : HashMap in Java
		 * 		  import java.util.HashMap;
		 *  
		 */
		
		/* Methods in HashMap
		 * 
		 * 1) Create ---> HashMap<Integer,Integer>
		 * 
		 * 	  HashMap<Integer,Integer> hm=new HashMap<>();
		 * 
		 * Operations :
		 * 
		 * 2) Insert : hm.put(Key,Value);
		 * 
		 * 	  10,20	   hm.put(10,20);
		 * 			   hm.put(20,40);
		 * 
		 * Note : In HashMap order of insertion is not maintained, can be any order
		 * 
		 * 3) Access : hm.get(Key); It will return Value of Key
		 * 			   print(hm.get(30));// 50
		 * 
		 * Note : If Key doesn't exist & we are trying to access we will get error.
		 * 
		 * 4) Search : hm.containsKey(key); If Key present True else False.
		 * 
		 * 			   print(hm.contains(30);// True
		 * 
		 * 5) Remove : hm.remove(Key); It will remove Key & Pair from HashMap
		 * 
		 * 			   hm.remove(10);
		 * 
		 * Note : If key doesn't exist & we are trying to remove it doe's nothing.
		 * 
		 * 6) Update : If we insert same key with different value, It will Update
		 * 
		 * 			   hm.put(20,60);
		 * 
		 * 7) Size : hm.size(); It will return no:of Key Value Pairs
		 * 
		 *    		 print(hm.size());
		 *    
		 * Note : Here Duplicates are Allowed To Overcome these ---> New DataStructures Came --> HashSet -> Allows only Non-Duplicates
		 *  
		 */
		
		HashMap<Integer,Integer> hm=new HashMap<>();
		hm.put(10,20);
		hm.put(20,40);
		System.out.println(hm);
		System.out.println(hm.get(20));
		System.out.println(hm.containsKey(10));
		hm.remove(20);
		System.out.println(hm);	
		hm.put(20,60);
		hm.put(20,50);
		System.out.println(hm);
		System.out.println("Size : "+hm.size());	
		
		/* HashSet : If we want to store only keys & key have to be distinct
		 * 
		 * Syntax : HashSet<Key-Type> hs=new HashSet<>();
		 * 
		 * If we want 
		 * 		int --> Integer		float --> Float		char --> Character
		 * 		long -> Long		double -> Double	String -> String
		 * 
		 * Key-Type : It can be from above types.
		 *  
		 */
		HashSet<Integer> hs=new HashSet<>();
		
		/* Operations :
		 * 
		 * 1) Insert : hs.add(Key);
		 * 
		 * Note : If Key already there, It does nothing.
		 * Note : Order is not maintained.
		 * 
		 * 
		 * 2) Search : hs.contains(key)
		 * 
		 * Note : If key present True else False.
		 * 
		 * 3) Delete : hs.remove(Key)
		 * 
		 * Note : If key not there, It does nothing.
		 * 
		 * 4) Size : hs.size()
		 * 
		 * Note : It will return no:of Keys
		 *  
		 */
		
		// Q1) Find Frequency of Numbers
		// 	   Given Array Elements & Q-Queries, for each query find frequency of each element in Array.
		
		int ar[]= {2,6,3,2,8,7,2,3,8,7};
		int Q[]= {2,8,3,5};
		
		// Idea-1 : For every Query Iterate on Array & print Frequency
		//			T.C = O(Q*N)
		//			S.C = O(1)
		
		// Idea-2 : Store in HashMap
		//			Key : Array Elements 
		//			Value : Frequency of Element.
		
		PrintFreq(ar,Q);
		
		// Q2) Given Array, Return Count of Distinct ELements.
		// Note : If an Element Repeating Multiple Time, we consider only once.
		
		int ar1[]= {6,8,3,2,7,14,14};
		
		int ans=Distinct(ar1);
		System.out.println("Distinct Elements in Array : "+ans);
		
		// Q3) Length of Longest Substring without Repetition.
		//							|
		//							----->Continuous part of String/ Complete String/ Single Length
		/*  S1="abcabcdd";
		 * 
		 *  ans=4
		 * 
		 * 	S2="aaaaa";
		 * 
		 *  ans=1
		 *  
		 *  
		 *  Idea-1 : For Every Substring :
		 *  
		 *  				if Substring contains all distinct characters :
		 *  
		 *  Note : To check if Substring is Distinct or Not insert in HashSet.
		 *  Update Length & get overall Max.
		 *  
		 *  T.C : O(N^2*N) = O(N^3)
		 *  			|
		 *  			-----> Insert in HashSet			
		 *  
		 *  S.C : O(N)
		 *  
		 *  
		 *  Idea-2 : For Every index i :
		 *  			 Calculate length of Longest Substring
		 *  			 With all Distinct Charactes Starting at i.
		 *    
		 */
		
		String s="abaceafe";
		int ans1=longDist(s);
		System.out.println("Longest Substring--> Optimised : "+ans1);
		
		// Idea-3 :
		
		int ans2=LongDistOp(s);
		System.out.println("Longest Substring--> Most Optimised : "+ans2);
		
		// Iterating HashMap
		
		HashMap<String,Integer> hmm=new HashMap<>();
		
		hmm.put("Bhanu",1);
		hmm.put("Raju",2);
		hmm.put("Raju",3);
		
			
		// To get All Keys of HashMap
		
		
		for(String  ss:hmm.keySet())
		{
			System.out.println(ss);// To get All Keys
			System.out.println(hmm.get(ss));// To get Values of HashMap
		}
		
		// Iterate HashSet :
		
		HashSet<Integer> hss=new HashSet<>();
		hs.add(10);
		hs.add(20);
		for(Integer key: hss)
		{
			System.out.println(key);
		}
		 
	}

	private static int LongDistOp(String s) // T.C = O(N+N) = O(N)
	{										// S.C = O(N)
		 int n=s.length();
		 int ans=0,i=0,j=0;
		 
		 HashSet<Character> hs=new HashSet<>();
		 while(j<n)
		 {
			 char ch=s.charAt(j); // [i...j] is valid substring or not.
			 if(hs.contains(ch)==false) // [i...j] --> [i....j+1] Valid.
			 {
				 hs.add(ch);
				 ans=Math.max(ans,hs.size());
				 j++;
			 }
			 else // [i..j] --> [i+1....j]
			 {
				 ch=s.charAt(i);
				 hs.remove(ch);
				 i++;
			 }
		 }
		 return ans;
		 
	}

	private static int longDist(String s) // T.C = O(N^2)
	{									  // S.C = O(N)
		 int n=s.length();
		 int ans=0;
		 
		 for(int i=0;i<n;i++)
		 {
			 // Start Substring from index : i
			 // Calculate Length of Longest Substring without Repetition.
			 
			 HashSet<Character> hs=new HashSet<>();
			 
			 for(int j=i;j<n;j++)
			 {
				 char ch=s.charAt(j);
				 if(hs.contains(ch)==false)
				 {
					 hs.add(ch);
				 }
				 else
				 {
					 break;
				 }
			 }
			 ans=Math.max(ans,hs.size());
		 }
		 return ans;
	}

	private static int Distinct(int[] ar1) // T.C = O(N)
	{									   // S.C = O(N)
		int n=ar1.length;
		HashSet<Integer> hs=new HashSet<>();
		for(int i=0;i<n;i++)
		{
			hs.add(ar1[i]);
		}
		return hs.size();
	}

	private static void PrintFreq(int[] ar, int[] q) // T.C = O(N+Q)
	{												 // S.C = O(N)
		int n=ar.length;
		
		HashMap<Integer,Integer> hm=new HashMap<>();
		for(int i=0;i<n;i++)
		{
			if(hm.containsKey(ar[i])==false)
			{
				hm.put(ar[i],1);// Ar[i]-->1^st Time
			}
			else //Increment frequency by 1
			{
				int f=hm.get(ar[i]);
				hm.put(ar[i],f+1);
			}
		}
		int q1=q.length;
		for(int i=0;i<q1;i++)
		{
			if(hm.containsKey(q[i])==true)
			{
				System.out.println(hm.get(q[i]));
			}
			else
			{
				System.out.println(0);
			}
		}
		
	}

}
