package Array_1D;

public class Array_1D 
{

	public static void main(String[] args) 
	{
		/* 1D Arrays_1
		 * What are arrays?
		 * Array is a collection of same DataType values/variables.
		 * By default a new integer array is created with all elements as 0.
		 * How to create an array?
		 * 1) datatype name[] = new datatype[size];
		 * Code1 :
		 * int ar[] = new int[5];
		 * Explanation :
		 * Integer array of size 5 in name of ar created
		 * 2) datatype []name = new datatype[size];
		 * Code2 :
		 * int []ar = new int[5];
		 * Explanation :
		 * integer array of size 5 in name of ar created
		 * 3) datatype[] name = new datatype[size];
		 * Code3 :
		 * int[] ar = new int[5];
		 * Explanation :
		 * integer array of size 5 in name of ar created
		 * 4) We can directly create an array by giving values.
		 * Code4 :
		 * int ar[] = {33,3,4,5,6,7};
		 * Explanation :
		 * A new array of size 6 is created with elements: {33,3,4,5,6,7}
		 * Note: We can create array using any of the above methods.
		 *  
		 */
		/* Indexing in an array
		 * Indexing in an array starts from 0 and goes till N - 1 (N being length of array). It means index of first element is 0 and index of last element is N - 1.
		 * 1) We access these indexes by following syntax: array_name[index number];
		 * Code1 :
		 * int ar[] = new int[5];
		   System.out.println(ar[0]);
		 * Output : 0
		 * Explanation :
		 * By default all elements in a new array are 0.
		 * 2) Index out of Bound :
		 * Code2 :
		 * int ar[] = new int[5];
		   System.out.println(ar[6]);
		 * Output :
		 * Error: ArrayIndexOutOfBoundsException
		 * Explanation :
		 * In above array it does not have index 6.
		 * 3) Finding length of an array (array_name.length):
		 * Code3 :
		 * int ar[] = new int[5];
		   System.out.println(ar.length);
		 * Output :
		 * 5
		 * Explanation :
		 * We have total 5 elements in this array.
		 * 4) We can store values using indexes:
		 * Code4 :
		 * int ar[] = new int[4];
			ar[0] = 12;
			ar[1] = 34;
			ar[2] = 2;
			ar[3] = 21;

		 * Output :
		 * Final array: {12, 34, 2, 21} having size 4.
		 * 
		 * Iterating over an array to access/print values:
		 * 1) Lets say we have an array of size 3: ar[3] = {4, 3, 5}. Then we can acces these values using index:
		 * Code :
		 * System.out.print(arr[i])  
		 * Output :
		 * It will print value at ith index
		 * 2) We are printing values of an array one by one using indices.
		   Code :
		 * System.out.print(arr[0]) // It will print -> 4
		   System.out.print(arr[1]) // It will print -> 3
		   System.out.print(arr[2]) // It will print -> 5

		 * 3) Let us write a function that prints all the elements of a given array.
		   Code :
		 * static void printArray(int[] a)
		 * {
    			for(int i = 0; i < a.length; i++)
    			{
        			System.out.println(a[i]);
    			}
			}
		   public static void main(String args[])
		   {
    			int[] arr = {33, 3, 4, 5};
    			printArray(arr);

		   }

		 * Output :
		 * 33
			3
			4
			5

		 * Explanation :
		 * In above code we are passing our array to a function to iterate in the given array.
		 * 4) We can create array by taking values as input from user.
		 * Code :
		 * Scanner sc = new Scanner(System.in);

			int ar[] = new int[5];
			for (int i = 0; i < 5; i++) 
			{
    				ar[i] = sc.nextInt();
			}
		 * Input:
		 * 1, 2, 3, 4, 5
		 * Explanation :
		 * ar = {1, 2, 3, 4, 5} is created.
		 * 
		 * Creating a new array using an old array name :
		 * Code :
		 * int ar[] = new int[3];
		   ar[0] = 10;
		   ar[1] = 20;
		   ar[2] = 30;
		   ar = new int[4];
		   System.out.print(ar[0]);
		 * Output :
		 * 0
		 * Explanation :
		 * If we use existing array's name to create new array then that name will be allocated to new array only.
		 *  
		 */
		
		/* Arrays : Fixed Number of Values of same datatype.
		 * Variable : datatype name=value;
		 * 
		 * Array Syntax :
		 * datatype[] name=new datatype[size];
		 * eg :
		 * int[] ar=new int[5];
		 * 
		 * Properties of Arrays : name.length; //We will get Size of Array
		 * Note : length is not a function
		 * 
		 * 1) int[] ar=new int[5];
		 * 	  Sysout(ar.length);//5
		 * 
		 */
		int[] ar=new int[5];
		System.out.println(ar);//[I@5ca881b5
		
		ar=new int[3];
		System.out.println(ar);
		
		//Note : In Array Variable Address is Stored in Them
		// Array Variables are like any other variable
		// a)Update b)Passthem in Functions c)return d)scope
		
		//Q) Given an Array, return Max Value of Array.
		int arr[]= {3,1,7,6,9,11};
		int ans=maxArray(arr);
		System.out.println(ans);
		int ans1=minArray(arr);
		System.out.println(ans1);
		
		/* Note 1: To Find Max, What Should we initialize?
		 * ans= - Infinity
		 * 	   1.Max Between -infinity & 10 =10;
		 * 	   2.Max Between -infinity & -5 =-5;
		 * ans=Integer.MIN_VALUE;---->Smaller int value we can store ~~-2*10(9)	
		 * 
		 * Note 2: To Find Min, What Should we initialize?
		 * ans= + Infinity
		 * 		1.Min Between +infinity & 10 =10;
		 * 		2.Max Between +infinity & -5 =-5;
		 * ans=Integer.MAX_VALUE;---->Largest int Value we can store ~~ 2*10(9)
		 * 
		 */
	}

	private static int minArray(int[] arr) 
	{
		 int n=arr.length;
		 int min=Integer.MAX_VALUE;
		 for(int i=0;i<n;i++)
		 {
			 if(arr[i]<min)
			 {
				 min=arr[i];
			 }
		 }
		 return min;
	}

	private static int maxArray(int[] arr) 
	{
		 int n=arr.length;
		 int max=Integer.MIN_VALUE;//Not 0 
		 for(int i=0;i<n;i++)	   //Note : Issue is Value Initialized is greater than all Array[] values, hence Value is never getting updated.
			 					   //arr[]={-4,-2,-7,-9}
			 					   //max=0,0->0->0->0 =>return Max:0
		 {
			 if(arr[i]>max)
			 {
				 max=arr[i];
			 }
		 }
		 return max;
	}

}
