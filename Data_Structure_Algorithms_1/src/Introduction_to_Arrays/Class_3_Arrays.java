package Introduction_to_Arrays;

public class Class_3_Arrays 
{

	public static void main(String[] args) 
	{
		/*  				  ----> Time it Takes	
		 * 					  |	
		 * Write an Algorithm -
		 * 					  |
		 * 					  ----> Space it Takes
		 * 
		 * Space Complexity :
		 * 					  S.C is the Max Space, that is utilized at any point in time during running of the Algorithm.
		 * 
		 * Note : We also use Big-O to Analyse Space Complexity.
		 * 
		 * 
		 * 
		 * 
		 * 		Input -------> Algo(Input)----------------->Output				
		 * 				   	   {
		 * 						// Algo will use
		 * 					    // Space other than
		 * 						// input to Solve Problem
		 * 					   }
		 * 
		 * Note : When we Calculate SC for Code, Don't take input memory & output memory
		 * 		  for calculating SC for code.
		 * 		  Consider only extra Memory taken by Algo.
		 * 
		 * 
		 * eg: void Algo(int N)
		 * 	   {
		 * 		 int x=N;		---> 4B
		 * 		 int y=x*x;		---> 4B } Space=16B---> BigO=O(1)
		 * 	     long z=x+y;	---> 8B
		 * 	   }
		 * Note : Constant extra space : It is independent of N.
		 *  	
		 */
		
		// Q) Given an Array, return Max of Array
		
		int a[]= {10,20,3,21,2,0,2,-1};
		int ans=maxArray(a);
		System.out.println(ans);
		
		/* Array Basics
		 * 
		 * int ar[]=new int[5];
		 * 				   |			0	1	2	 3	 4 ---> index
		 * 				   -----> ar : {50, 60, 10, 80, 90}
		 * 
		 * Access : name(index);
		 * 
		 * ar[0]=50;
		 * ar[1]=60;
		 * ar[2]=10;
		 * ar[3]=80;
		 * ar[4]=90;
		 *  
		 */
		// int N=100;			 //			 0 1 2 3 . . . . .  N-2	 N-1
		// int ar[]=new int[N]; //		ar :|-|-|-|-|-|-|-|-|-|----|----|
		// First & Last indices 
		// ar[0] & ar[N-1]
		// Way-2 :
		System.out.println();
		int ar[]={10, 20, 30, 40, 50};
		
		// Q) Print Array Elements 
		printArray(ar);
		System.out.println();
		
		// Q) Given an Array, Reverse entire Array
		reverseEntireArray(ar);
		// Idea : Swap 1st & Last +>Swap 2nd & 2nd Last Elements
		printArray(ar);
		
		// Q) Given an Array, l & r Reverse entire Array from L....R
		int arr[]= {10,20,30,40,50,60,70,80,90,100};
		reverseRange(arr,2,7);
		System.out.println();
		System.out.println("Array Ele in Range ----> ");
		printArray(arr);
		
		// Q) Given an Array rotate it by k-times by Right->Left
		// eg: ar[7]={10,20,30,40,50,60,70};
		// 	   k=3
		//	  Rotate 1: {70,10,20,30,40,50,60};
		//	  Rotate 2: {60,70,10,20,30,40,50};
		//	  Rotate 3: {50,60,70,10,20,30,40};
		// Idea-1:
		//		 Take Last Ele to Start & Shift All Ele : Rotate 1 Time
		//		 Repeat above process k-Times.
		
		// Bruit Force
		System.out.println();
		int aa[]={10,20,30,40,50,60,70};
		rotate1(aa,3);
		printArray(aa);
		// Optimized Approach
		// Rotate-1:
		// Rotate-2:
		// Rotate-3:
		// Obs : In Array[N] rotate k-times:
		//	    a) Last k-elements= Goes to Start.
		//		b) Remaining elements= Goes to Last.
		// After Rotation :
		// Steps :
		//		  1) Reverse entire Array
		//		  2) Reverse first k  Elements
		//		  3) Reverse last N-K Elements
		int aaa[]={10,20,30,40,50,60,70};
		rotate2(aaa,3);
		System.out.println();
		printArray(aaa);
		
		//			   0  1  2  3	
		// ar[4] =    10,20,30,40
		
		// Rotate-0 : 10,20,30,40
		// Rotate-1 : 40,10,20,30
		// Rotate-2 : 30,40,10,20
		// Rotate-3 : 20,30,40,10
		// Rotate-4 : 10,20,30,40 Repeated
		// Rotate-5 : 40,10,20,30
		// Rotate-6 : 30,40,10,20
		// Rotate-7 : 20,30,40,10
		// Rotate-8 : 10,20,30,40 Repeated
		
		// Observation :
		// After 4-iterations :
		// [0]-->4-->8-->12-->16-->20
		// [1]-->5-->9-->13-->17
		// [2]-->6-->10-->14-->18
		// [3]-->7-->11-->15
		
		// K	N=4		K%N  :  Same as Rotation
		//20	20%4	 0   :  Same as Rotation
		//17 	17%4	 1	 :  Same as Rotation
		//26	26%4	 2	 :  Same as Rotation
		
		// Conclusion : Rotating K is same as Rotating K%N
		
		/* Dynamic Arrays :
		 * 
		 * ArrayList<Integer> al=new ArrayList<>();
		 * 
		 * Inbuilt-Functions :
		 * 
		 * 1) add(Ele) : Adding an Ele to end of ArrayList al:{ }
		 * al.add(30);
		 * al.add(40);
		 * 
		 * 2) size() : It will return Total no of Elements
		 * int n=al.size();
		 * 
		 * 3) get(index) : To Access i^th index element of ArrayList
		 * int ele=al.get(2);
		 * print(al.get(1));
		 * 
		 * 4) set(index,value) : Update value to a Particular index.
		 * al.set(2,5);
		 * al.set(3,70);
		 * 
		 * 5) remove(index) : we can remove that index Ele.
		 * al.remove();
		 * 
		 * 6) Collections.sort(ArrayList) : It will sort ArrayList in increasing Order.
		 * Collections.sort(al);//Increasing Order
		 * 
		 * For Decreasing Order : Comparator
		 *  
		 */
		
	}

	private static void rotate2(int[] aa, int k) 
	{
		int n=aa.length;
		k=k%n;  // To Remove Edge Cases		iterations		:		Total Iterations = O(N)
		reverseRange(aa,0,aa.length-1); //      N/2
		reverseRange(aa,0,k-1);			//	    K/2			}		N/2+K/2+N/2-K/2=N
		reverseRange(aa,k,aa.length-1); //	    [N-K]/2
	}

	private static void rotate1(int[] aa,int k) // T.C= O(N*K) // Single Rotate=N
	{ 										   // S.C= O(1)
		for(int j=1;j<=k;j++)
		{
			// Rotate 1-time :
			int n=aa.length;
			int temp=aa[n-1];
			for(int i=n-1;i>=1;i--)
			{
				aa[i]=aa[i-1];
			}
			aa[0]=temp;
		}
	}

	private static void reverseRange(int[] a, int l, int r) // Total elements we reverse = r-l+1
	{ 														// Total iterations =(r-l+1)/2
		int n=a.length;
		
		int p1=l,p2=r;
		
		while(p1<p2)
		{
			int t=a[p1];
			a[p1]=a[p2];
			a[p2]=t;
			
			p1++;
			p2--;
		}
		
	}

	private static void reverseEntireArray(int[] ar) // T.C= O(N)
	{ 												 // S.C= O(1)
		int n=ar.length;
		int p1=0,p2=n-1;
		
		while(p1<p2)
		{
			int t=ar[p1];
			ar[p1]=ar[p2];
			ar[p2]=t;
			
			p1++;
			p2--;
		}
	}

	private static void printArray(int[] ar) // T.C=O(N)
	{										 // S.C=O(1)
		int n=ar.length;
		
		for(int i=0;i<n;i++)
		{
			System.out.print(ar[i]+" ");
		}
	}

	private static int maxArray(int[] a) // Space Complexity = O(1)
								//	  |	 // Time Complexity = O(N)
	{							//	  |
								//	  -----> Input Array
		 int n=a.length;		// 4B
		 int max=Integer.MIN_VALUE;
		 
		 for(int i=0;i<n;i++)	// 4B
		 {
			 if(a[i]>max)		// Total =8B
			 {
				 max=a[i];
			 }
		 }
		 return max;
		 
		// Note : While Calculating Space Complexity ---> Neglect Input & Output Space & Calculate remaining Space. 
	}

}
