package Arrays_2D_3;

import java.util.ArrayList;
import java.util.Arrays;

public class Arrays_2D_3 
{

	public static void main(String[] args) 
	{
		/* 2D ArrayList:
		 * 2D arraylist is a dynamic version of 2D arrays.
		 * We don't have to specify size at the time of creation.
		 * Syntax:
		 * ArrayList<ArrayList<Type>> ar= new ArrayList<>();
		 * Type can be Integer, Long, Float, Double, String.
		 * Each element inside Arraylist is ArrayList<Type>
		 * Example:
		 * ArrayList<ArrayList<Integer>> ar= new ArrayList<>();
		 * Each element inside Arraylist is ArrayList<Integer>
		 * Code:
		 * ArrayList<ArrayList<Integer>> arr = new ArrayList<Integer>();
		   System.out.println(arr);
		 * Output:
		 * []
		 * Explanation:
		 * A new empty 2D arraylist of Integer is created.
		 * Methods of 2D ArrayList:
		 * 1) Adding new elements to our Arraylist:
		 * Code:
		 *  ArrayList<ArrayList<Integer>> mat=new ArrayList<>();
			ArrayList<Integer> a1=new ArrayList<>();
			 a1.add(10);
			 a1.add(20);
			 a1.add(30);
			 a1.add(40);
			 mat.add(a1);
			ArrayList<Integer> a2=new ArrayList<>();
			 a2.add(50);
			 a2.add(60);
			 a2.add(70);	
			 mat.add(a2);
			System.out.print(mat);  
		 * 
		 * Output:
		 * [Success] Your code was executed successfully
		   [[10, 20, 30, 40], [50, 60, 70]]
		 * Explanation:
		 * Here we are creating two 1D arraylist and then adding these arraylist to 2D arraylist.
		 * 
		 * 2) Finding size of arraylist:
		 * Syntax : arraylist.size()
		 * Returns the number of 1D arraylist present.
		 * Code:
		 *  ArrayList<ArrayList<Integer>> mat=new ArrayList<>();
			ArrayList<Integer> a1=new ArrayList<>();
			 a1.add(10);
			 a1.add(20);
			 a1.add(30);
			 a1.add(40);
			 mat.add(a1);
			ArrayList<Integer> a2=new ArrayList<>();
			 a2.add(50);
			 a2.add(60);
			 a2.add(70);	
			 mat.add(a2);
			System.out.print(mat.size());
		 * Output:
		 * [Success] Your code was executed successfully
		   2
		 * Explanation:
		 * Since we added 2 1D arraylist hence size is 2.
		 * 
		 * 3) Accessing element at an index
		 * arraylist.get(index)
		 * Note: arraylist.get(index): It gives element at ith index and here each element is ArrayList<Integer>
		 * To access a particular element we use, arraylist.get(ith arraylist).get(jth element)
		 * Code:
		 * 	ArrayList<ArrayList<Integer>> mat=new ArrayList<>();
			ArrayList<Integer> a1=new ArrayList<>();
			 a1.add(10);
			 a1.add(20);
			 a1.add(30);
			 a1.add(40);
			 mat.add(a1);
			ArrayList<Integer> a2=new ArrayList<>();
			 a2.add(50);
			 a2.add(60);
			 a2.add(70);	
			 mat.add(a2);	
			System.out.println(mat.get(1));
			System.out.println(mat.get(1).get(0));

		 * Output:
		 * [Success] Your code was executed successfully
		   [50, 60, 70]
		   50
		 * 
		 * Explanation:
		 * Here System.out.println(mat.get(1)) gives the arraylist stored at 1st index. 
    
		   Then System.out.println(mat.get(1).get(0)) first gives arraylist stored at 1st index and then element stored at 0th index.  

		 * Note : If Index is not present in Arraylist then it will give index out of bound error.
		 * 
		 * 4) Change Existing element:
		 * Syntax : arraylist.set(int index, new element)
		 * This method is used to replace the element at the specified index in the ArrayList with the specified element.
		 * Code:
		 * 	ArrayList<ArrayList<Integer>> mat=new ArrayList<>();
			ArrayList<Integer> a1=new ArrayList<>();
			 a1.add(10);
			 a1.add(20);
			 a1.add(30);
			 a1.add(40);
			 mat.add(a1);
			ArrayList<Integer> a2=new ArrayList<>();
			 a2.add(50);
			 a2.add(60);
			 a2.add(70);	
			 mat.add(a2);
			 mat.get(1).set(0, 30);
			System.out.println(mat);

		 * Output:
		 * [Success] Your code was executed successfully
		   [[10, 20, 30, 40], [30, 60, 70]]
		 * 
		 * 5) Remove elements:
		 * Syntax : arraylist.remove(int index)
		 * Removes the element present at specified index from the ArrayList.
		 * Code:
		 *  ArrayList<ArrayList<Integer>> mat=new ArrayList<>();
			ArrayList<Integer> a1=new ArrayList<>();
			 a1.add(10);
			 a1.add(20);
			 a1.add(30);
			 a1.add(40);
			 mat.add(a1);
			ArrayList<Integer> a2=new ArrayList<>();
			 a2.add(50);
			 a2.add(60);
			 a2.add(70);	
			 mat.add(a2);
			 mat.get(1).remove(0);
			System.out.println(mat);

		 * Output:
		 * [Success] Your code was executed successfully
		   [[10, 20, 30, 40], [60, 70]]
		 * 
		 * 
		 * How to Print 2D ArrayList:
		 * 
		 * void print(ArrayList<ArrayList<Integer>> ar)
		 * {
 				int N=ar.size(); //Number of each element-> ArrayList<Integer> 
 				for(int i=0;i<N;i++)
 				{
 					//print ith arraylist: ar.get(i)
 					int M=ar.get(i).size(); //It gives ith list. 
 					for(int j=0;j<M;j++)
 					{
 						//In ith list print jth index. 
 						System.out.print(ar.get(i).get(j));
 					}
					System.out.println();
 				}      
			}    

		 * 
		 */
		/* ArrayList<Integer> al=new ArrayList<>();
		 * 				|
		 * 				--->Each Element in ArrayList is Integer Type.
		 * Inbuilt_Functions :
		 * 1) add(ele)
		 * 2) size()
		 * 3) get(index)
		 * 4) set(index,value)
		 * 5) remove(index)
		 * 
		 * 2D ArrayList :
		 * 
		 * ArrayList<ArrayList<DataType>> Ar=new arrayList<>();
		 * |
		 * --->Each Element in A is of ArrayList<DataType> type.
		 *  
		 * eg:
		 * 	  ArrayList<ArrayList<Integer>> Ar=new ArrayList<>();
		 * 					|
		 * 					----> Type : Each Element is ArrayList<Integer>
		 * 	  Each Element in A is of ArrayList<Integer> type.
		 * 
		 */
		
		/* Add Elements in 2D-ArrayList:
		 * 
		 * Each Element in A: ArrayList<Integer>
		 * 
		 */
		ArrayList<ArrayList<Integer>> Ar=new ArrayList<>();
		ArrayList<Integer> d1=new ArrayList<>();
		d1.add(10);
		d1.add(20);
		d1.add(30);
		d1.add(40);
		d1.add(50);
		ArrayList<Integer> d2=new ArrayList<>();
		d2.add(-1);
		d2.add(4);
		d2.add(8);
		ArrayList<Integer> d3=new ArrayList<>();
		d3.add(50);
		d3.add(60);
		
		// A : { Each Element in A is an ArrayList<Integer> }
		Ar.add(d1);
		Ar.add(d2);
		Ar.add(d3);
		
		System.out.println(Ar);
		
		/* Get Elements :
		 * 
		 */
		System.out.println(Ar.get(0));
		System.out.println(Ar.get(2));
		
		/* Access individual Element in A
		 * 
		 * A.get(i).get(j);
		 * |
		 * --->i^th index ArrayList in A, in That get j^th index.
		 * 
		 */
		System.out.println(Ar.get(0).get(0));
		System.out.println(Ar.get(1).get(2));
		System.out.println(Ar.get(2).get(1));
		
		/* Size :
		 * A.size()
		 * 
		 */
		System.out.println("Size of 2D-ArrayList -"+Ar.size());
		System.out.println(Ar.get(0).size());
		System.out.println(Ar.get(1).size());
		System.out.println(Ar.get(2).size());
		
		/* Modify :
		 * A.get(index).set(indx,val);
		 * 
		 */
		Ar.get(0).set(2,100);
		Ar.get(1).set(2,-9);
		Ar.get(2).set(0,20);
		System.out.println(Ar);
		
		// Q) Write a Function, which takes ArrayList<arrayList<Integer>> & Print it.
		
		print2DArrayList(Ar);
		
		// Q) Write a 2D-ArrayList, return a 2D ArrayList with only even elements
		
		ArrayList<ArrayList<Integer>> ans=printEven2DArrayList(Ar);
		System.out.println(ans);
		
		// Q) Given an ArrayList, return all unique elements.
		// Unique : An Element with occurrence=1, is said to be unique.
		// eg :
		//	  ar :{6,10,8,2,8,10,11};
		// Output:{6,2,11};
		
		// Idea : Iterate on Every ELement :
		//		1) Check if it's unique element or not
		//		2) Iterate on arrayList->get freq of ele if==1 : Unique Element.
		
		ArrayList<Integer> ar=new ArrayList<>(Arrays.asList(10,7,32,10,32,10,32,48,56,12,48,19,11,32));
		
		ArrayList<Integer> ans1=UniqueElement(ar);
		System.out.println(ans1);
		
		// Q) Given a 2D ArrayList
		// Return a 2D ArrayList Which Contains Unique Number from Every Row.
		/* eg:
		 * A={
		 * 		0{1,2,3,4,1},
		 * 		1{5,8,7,8,8},
		 * 		
		 * 
		 */
		
		ArrayList<ArrayList<Integer>> ali=new ArrayList<>(
				Arrays.asList(
				new ArrayList(Arrays.asList(1,2,3,4,1)),
				new ArrayList<>(Arrays.asList(5,8,7,8,8)),
				new ArrayList<>(Arrays.asList(9,4,4,9))
							 )
				);
		System.out.println();
		System.out.println(ali);
		
		ArrayList<ArrayList<Integer>> ans2=Unique2D(ali);
		System.out.println(ans2);
		
		/* Predefined Functions For ArrayList in Collections
		 * ArrayList<Integer> ar=new ArrayList<>();
		 * ar={10,20,5,6,14};
		 * 
		 * min :Collections.min(ar);// It will return min of ArrayList
		 * max	:Collections.max(ar);// It will return max of arrayList
		 * 
		 * Add Multiple Elements in ArrayList Once :
		 * Collections.addAll(list,data1,data2,data3...);
		 * Collections.addAll(a,50,14,20,24,16,30);
		 * 
		 * Use full Pre-defined Function in ArrayList:
		 * listname.contains(data);
		 * 			if data present in list : return True;
		 * 			if data not present in list : return false;
		 * eg :
		 * 		Sysout(a.contains(50));//true
		 * 		Sysout(a.contains(100));//false
		 * 
		 * Pattern Returning :
		 * Which Takes n as input and returns a 2D ArrayList of strings
		 * Each row of arrayList should represent a Level of StairCase.
		 * For each row, Initial columns filled with '#' & remaining " "
		 * Stairs should have n-steps & It should width with "#"
		 * 
		 * eg : N=4
		 * 
		 * {							Hashes=i+1		Spaces=N-i-1
		 * 		0{"#"," "," "," "},			1				  3
		 * 		1{"#","#"," "," "},			2				  2
		 * 		2{"#","#","#"," "},			3				  1	
		 * 		3{"#","#","#","#"}			4				  0
		 * }
		 * 
		 * 
		 */
		
		int n=4;
		ArrayList<ArrayList<String>> ans3=StairCase(n);
		for (ArrayList<String> row : ans3) {
		    for (String ch : row) {
		        System.out.print(ch);
		    }
		    System.out.println();
		}

				
					
		
		
	}

	private static ArrayList<ArrayList<String>> StairCase(int n) 
	{
		 ArrayList<ArrayList<String>> ans=new ArrayList<>();
		 for(int i=0;i<n;i++)
		 {
			 // Create a Level & add it in ArrayList<String>
			 ArrayList<String> level=new ArrayList<>();
			 for(int j=1;j<=i+1;j++)
			 {
				 level.add("#");
			 }
			 int spaces=n-i-1;
			 for(int j=1;j<=spaces;j++)
			 {
				 level.add(" ");
			 }
			 ans.add(level);
		 }
		 return ans;
	}

	private static ArrayList<ArrayList<Integer>> Unique2D(ArrayList<ArrayList<Integer>> ali) 
	{ 
		ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
		int n=ali.size();
		for(int i=0;i<n;i++)
		{
			ArrayList<Integer> temp=UniqueElement(ali.get(i));
			ans.add(temp);
		}
		return ans;
	}

	private static ArrayList<Integer> UniqueElement(ArrayList<Integer> ar) 
	{ 
		ArrayList<Integer> ans=new ArrayList<>();
		int n=ar.size();
		for(int i=0;i<n;i++)
		{
			// Get Count of A.get(i);
			int temp=ar.get(i); //Storing Integer in a int variable and compare int with Integer.
			int c=0;
			for(int j=0;j<n;j++)
			{
				/*
				 if(ar.get(j0==ar.get(i)
				 {
				 	c++;
				 }
				 */
				if(ar.get(j)==temp)
				{
					c++;
				}
			}
			if(c==1)
			{
				ans.add(ar.get(i));
			}
		}
		return ans;
	}

	private static ArrayList<ArrayList<Integer>> printEven2DArrayList(ArrayList<ArrayList<Integer>> ar) 
	{ 
		ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
		int n=ar.size();
		for(int i=0;i<n;i++)
		{
			ArrayList<Integer> temp=new ArrayList<>();
			int m=ar.get(i).size();
			for(int j=0;j<m;j++)
			{
				if(ar.get(i).get(j)%2==0)
				{
					temp.add(ar.get(i).get(j));
				}
			}
			ans.add(temp);
		}
		return ans;
	}

	private static void print2DArrayList(ArrayList<ArrayList<Integer>> ar) 
	{
		 int n=ar.size();
		 for(int i=0;i<n;i++)
		 {
			 //Access i^th index arrayList<Integer> from A.
			 //A.get(i)->i^th ArrayList<Integer. & we need to print it
			 int m=ar.get(i).size();// In i^th ArrayList : M-Elements
			 for(int j=0;j<m;j++)
			 {
				 System.out.print(ar.get(i).get(j)+" ");
			 }
			 System.out.println();
		 }
	}

}
