package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Pair
{
	int s,e;
	
	public Pair(int a, int b)
	{
		s=a;
		e=b;
	}
}

public class Class_53_DSA_Greedy 
{

	public static void main(String[] args) 
	{ 
		/* Fractional Knapsack
		 * 
		 * Greedy Properties
		 * 
		 * Activity Selection
		 * 
		 * Job Scheduling
		 *  
		 */
		/* Indian Currency : 1	2	5	10	20	50	100	200	500	2000
		 * 
		 * Cash : 5548 : Min Coins/Notes required to get required Cash ?
		 * 
		 * Remaining Amount/Cash
		 * 
		 * 5548		:		2000*2
		 * 
		 * 1548		:		500*3
		 * 
		 * 48		:		20*2
		 * 
		 * 8		:		5*1
		 * 
		 * 3		:		2*1
		 * 
		 * 1		:		1*1
		 * 
		 * Total Coins : 10
		 *  
		 */
		
		/* Greedy : Solving by selecting Best Option Available at each Step.
		 * 
		 * 			So that we can get overall Min or Max is considered as Greedy Way of solving problem.
		 * 
		 * Q) How do we decide, what is best option at each Step
		 * 
		 * Ans : We Select best option available at each step, based on parameter of your choice.
		 * 
		 * 
		 * In above Case : Parameter : Based on Notes/Coins.
		 *  
		 */
		
		/* Note : Parameter should be clear, using parameter we should clearly decide best.
		 * 
		 * Issue : Greedy Doesn't Always Work ?
		 * 
		 * Indonesia Currency :	 1		10		18
		 * 
		 * Cash : 20    Min Coins/Notes required to get required cash ?
		 * 
		 * Remaining  Amount/Cash
		 * 
		 * 		20   :	   18*1
		 * 
		 * 		2	 :	   1*2
		 * ------------------------
		 * Total Coins :   3 by Greedy
		 * 
		 * Actual Answer : 10*2 =2 // Correct Ans
		 * 
		 * 
		 * Note : Check if our Greedy Approach is working or not, based on some examples, if not working look for another Parameter
		 *   
		 */
		
		 /* Activity Selection :
		  * ------------------
		  * 
		  * Gym, Yoga, Problems, Eating, youtube, Afternoon sleep, revise, Netflix & chill, Dinner, Scaler
		  *  
		  */
		
		/* Q) Max Tasks which can be done
		 * 
		 * Note-1 : Once we start we need to finish the Tasks
		 * 
		 * Note-2 : At any point we cannot do overalapping Tasks
		 * 
		 * Ans : 6
		 * 
		 * Note : In a Question, the word Max/Min : Greedy Might be Approach.
		 * 
		 * Idea-1 : Using Greedy : Taking best at each step based on Parameter ?
		 * 
		 * Parameter : Shortest Duration Task = 4 * Wrong
		 * 
		 * Idea-2 : Using Greedy : Taking Best at each Step
		 * 
		 * Parameter : Take task with min Overlapping First
		 * 
		 * Idea-3 : Using Greedy : Taking Best at each Step
		 * 
		 * Parameter : Fastest End Time = 6
		 * 
		 * 
		 * Correctness of Logic : We do task which ends first, becuase it gives us more frequency time, if we have more free time we can perform more Tasks.
		 *   
		 */
		
		int s[]= {4,5,3,9,2};
		int e[]= {7,7,5,10,8};
		
		int ans=MaxJobs(s,e);
		System.out.println(ans+" ");
		
		// Own Sorting Algorithm
		ArrayList<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(2);
		list.add(8);
		Collections.sort(list);

		System.out.println(list); // [2, 5, 8]
		
		// Collections.sort() is a utility method from Java’s Java Collections Framework used to sort elements of a list.
		
		// Collections.sort() sorts a List in ascending order (by default).
		
		Collections.sort(list);
		
		// Works when elements have natural ordering (like integers, strings)
		
		// Custom sorting 
		
		// When you have objects (like Pair), Java doesn’t know how to sort them.
		
		// So you give a Comparator:
		
		// Collections.sort(ar, new Sortow());
		
		// Collections.sort(ar, (a, b) -> a.e - b.e);// “Sort based on end time (e)”
		
		/*
		 * Time Complexity:

			Best: O(n)
			Average/Worst: O(n log n)
			
			Syntax Table :
			
			| Case         | Syntax                                | When to Use                                 |
			| ------------ | ------------------------------------- | ------------------------------------------- |
			| Default Sort | `Collections.sort(list);`             | When elements are naturally comparable      |
			| Custom Sort  | `Collections.sort(list, comparator);` | When sorting objects or custom logic needed |
			
			Example Table :
			
			| Scenario     | Code                                        | Output               |
			| ------------ | ------------------------------------------- | -------------------- |
			| Integer Sort | `Collections.sort(list);`                   | `[2, 5, 8]`          |
			| Object Sort  | `Collections.sort(ar, (a,b) -> a.e - b.e);` | Sorted by `end time` |

			Collections vs Arrays :
			
			| Feature     | `Collections.sort()`    | `Arrays.sort()`    |
			| ----------- | ----------------------- | ------------------ |
			| Works On    | List                    | Array              |
			| Package     | `java.util.Collections` | `java.util.Arrays` |
			| Custom Sort | Comparator              | Comparator         |
			| In-place    | Yes                     | Yes                |

			Comparable vs Comparator :
			
			| Feature               | Comparable                           | Comparator                           |
			| --------------------- | ------------------------------------ | ------------------------------------ |
			| Package               | `java.lang`                          | `java.util`                          |
			| Purpose               | Defines **natural/default ordering** | Defines **custom ordering**          |
			| Method                | `compareTo()`                        | `compare()`                          |
			| Method Signature      | `int compareTo(T obj)`               | `int compare(T o1, T o2)`            |
			| Where Defined         | Inside the **same class**            | In a **separate class / lambda**     |
			| Modification Needed   | Requires modifying the class         | No need to modify original class     |
			| Number of Sort Logics | Only **one** (fixed)                 | Can have **multiple**                |
			| Usage                 | `Collections.sort(list)`             | `Collections.sort(list, comparator)` |
			| Flexibility           | ❌ Less flexible                      | ✅ More flexible                      |
			| Example               | Sort students by ID                  | Sort students by name, marks, etc.   |
			
			
			| Concept    | Think Like                      |
			| ---------- | ------------------------------- |
			| Comparable | “**I know how to sort myself**” |
			| Comparator | “**You tell me how to sort**”   |

		 */
		
		/*
		 * Types of Sorting in Java:
		 * 	
		 * 	1) Based on Technique (How sorting is applied)
		 * 	
		 *  | Type            | Description                                             | Example                        |
			| --------------- | ------------------------------------------------------- | ------------------------------ |
			| Natural Sorting | Default sorting defined inside class using `Comparable` | Sort integers, strings         |
			| Custom Sorting  | User-defined sorting using `Comparator`                 | Sort objects by specific field |
			
			2) Based on Data Structure
			
			| Type               | Method               | Used For                     |
			| ------------------ | -------------------- | ---------------------------- |
			| Array Sorting      | `Arrays.sort()`      | Arrays                       |
			| Collection Sorting | `Collections.sort()` | List (ArrayList, LinkedList) |
			
			
			3) Based on Sorting Algorithms (Internal Working)
			
			| Algorithm                   | Used By Java                                     | Time Complexity | Stable |
			| --------------------------- | ------------------------------------------------ | --------------- | ------ |
			| TimSort                     | `Collections.sort()` / `Arrays.sort()` (Objects) | O(n log n)      | ✅ Yes  |
			| Dual-Pivot QuickSort        | `Arrays.sort()` (primitives)                     | O(n log n) avg  | ❌ No   |
			| Merge Sort (older versions) | Earlier Java versions                            | O(n log n)      | ✅ Yes  |
			
			Eg : Natural Sorting (Comparable)
			
			Collections.sort(list);
			
			Collections.sort(list, (a, b) -> a - b);
			
			Eg : Custom Sorting (Comparator)
			
			Collections.sort(list, (a, b) -> a.e - b.e);
			
			Collections.sort(list, (a, b) -> b - a);
			
			Simple understanding :
			--------------------
			| Expression | Meaning       | Order        |
			| ---------- | ------------- | ------------ |
			| `a - b`    | smaller first | Ascending ✅  |
			| `b - a`    | larger first  | Descending ❌ |

			Using subtraction can cause integer overflow in some cases.
			
			Way : Collections.sort(list, (a, b) -> Integer.compare(a, b));
			
			Already sorts in ascending order by default
			
			Collections.sort(list);
			
			// Comparator.reverseOrder() 👇
			
			/* Collections.sort(list, Comparator.reverseOrder());
			 * 
			 * import java.util.*;

				public class Main 
				{
				    public static void main(String[] args) 
				    {
				        ArrayList<Integer> list = new ArrayList<>();
				
				        list.add(5);
				        list.add(2);
				        list.add(8);
				        list.add(1);
				
				        Collections.sort(list, Comparator.reverseOrder());
				
				        System.out.println(list); // [8, 5, 2, 1]
				    }
				} 
			 * 
			 * Comparator.reverseOrder() gives a default descending comparator
			   It works only when elements have natural ordering (like Integer, String)
			 * 
			 * 
			 *  | Method                                              | Order      |
				| --------------------------------------------------- | ---------- |
				| `Collections.sort(list)`                            | Ascending  |
				| `Collections.sort(list, Comparator.reverseOrder())` | Descending |

			 * 
			 */
		
		// Q) Job Scheduling :
		/*
		 * 	  Given N Tasks & Payment & Deadline, attached to each Task
		 * 
		 * 	  Find Max Payment we can get ?
		 * 
		 * 	  Note : We can finish a Task on or before deadline Day :
		 * 
		 * 	  Note : Each Task Takes 1 Day
		 * 
		 * 	  Note : EveryDay we can only do 1 Task
		 * 
		 * 	  
		 * Eg :		Job	|	Deadline Day	|	Payment		Day :
		 * 													1	2
		 * 			----------------------------------------------
		 * 			  a			  1					3		a	b	: 1503
		 * 			  b			  2					1500	b	*	: 1500
		 * 
		 * Idea-1 : Using Greedy : Taking Best At Each Step
		 * 
		 * 			Parameter	 : Highest Payment // *NP
		 * 
		 * Idea-2 : Using Greedy : Taking Best At Each Step
		 * 
		 * 			Parameter	 : Sort Increasing Dead Line
		 * 			
		 * 			// If 2 items have same dead : Sort in Decresing on Amount
		 * 
		 * Observation : Sort Increasing in Dead Line.
		 * 
		 * 			Obs-1 : If we have N Days : We can perform N-Tasks
		 * 
		 * 			Obs-2 : On Same Day : T1:40, T2:50, if Multiple Tasks Avaialable Consider Greater
		 * 
		 * 			Obs-3 : We can replace a Task with Another Task with >= Bigger Dead Line
		 * 
		 * 		Job		Deadline	Payment
		 * 
		 * 		 a			3		   100
		 * 
		 * 		 b			1			19
		 * 
		 * 		 c			2			27
		 * 
		 * 		 d			1			25
		 * 
		 * 		 e			3			30
		 * 
		 * Note : Sort on DeadLines Increasing Order
		 * 
		 * 		Task     :		b	d	c	e	a
		 * 
		 * 		Deadline :		1	1	2	3	3
		 * 
		 * 		Amount	 :		19	25	27	30	100
		 *   
		 */
		
		int d[]= {3,1,2,1,3};
		int p[]= {100,19,27,25,30};
		
		int ans1=MaxJobs1(d,p);
		System.out.println(ans1+" Max Job-1 ");// “Keep best profitable jobs within deadline using Min Heap”
			
		// Q) Distribute Comedy
		/*
		 * There are N-Students with their Marks,
		 * 
		 * The Teacher has to give them Candies such That
		 * 
		 * a) Every Student should have atleast One Candy
		 * 
		 * b) Students with More Marks than any of his/her Neighbour
		 * 
		 * c) Return Min of Chacolates required to satisfy above condition
		 * 
		 */
		
		/* Eg-1 :
		 * 
		 * Input : { 1 , 5 , 2 , 1 };
		 * 
		 * Chacolate : { 1,	1,	1,	1	};
		 * 
		 * 			   { 1, 2,	1,	1	};
		 * 
		 * 			   { 1,	2,	2,	1	};
		 * 
		 * 			   { 1,	3,	2,	1	}; Ans=7;
		 * 
		 * 
		 * Eg-2 :
		 * 
		 * Input : { 4,	4,	4,	4,	4 };
		 * 
		 * Chacolate : { 1,	1,	1,	1,	1 }; Ans=5;
		 * 
		 * 
		 * Confusing : After assinging chacolates to a Student, if we change assaignment to it's adjacent students,
		 * 
		 * we might have to re-assaign Chacolate.
		 * 
		 * 
		 * Q) a[] = { 1, 6, 3, 1, 10, 12, 20, 5, 2 };
		 * 
		 * Left[] = { 1, 2, 1, 1,  2,  3,  4, 1, 1 };
		 * 
		 * Step-1 : If a Student has more marks > Left Neighbour Student get More Chacolates
		 * 
		 * Q) b[] =  { 1, 6, 3, 1, 10, 12, 20, 5, 2 };
		 * 
		 * Right[] = { 1, 3, 2, 1,  1,  1,  3, 2, 1	};
		 * 
		 * Step-2 : If a Student has more marks > Right Neighbour Student get More Chacolates
		 * 
		 * 
		 * Ans[] = Max{ Left[] & Right[] };
		 * 
		 */
		
		int m[]= {8,10,6,2};
		int ans2=MaxChacoloate(m);
		System.out.println("Max Candies : "+ans2);
		
		/*
		 *  | Problem            | Method            | TC         | SC   | Status                 |
			| ------------------ | ----------------- | ---------- | ---- | ---------------------  |
			| Activity Selection | `MaxJobs()`       | O(N log N) | O(N) | ✅ Correct (minor fix) |
			| Job Scheduling     | `MaxJobs1()`      | O(N log N) | O(N) | ⚠️ Fix sorting field   |
			| Candy Problem      | `MaxChacoloate()` | O(N)       | O(N) | ✅ Perfect             |

		 */
	}

	private static int MaxChacoloate(int[] m) // T.C = O(N)
	{										  // S.C = O(N)
		int n=m.length;
		
		int left[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			left[i]=1;
		}
		
		int right[]=new int[n];
		
		for(int i=0;i<n;i++)
		{
			right[i]=1;
		}
		
		// Fill for Left []
		
		for(int i=1;i<n;i++)
		{
			if(m[i]>m[i-1])
			    left[i]=left[i-1]+1;
		}
		
		// Fill for Right []
		
		for(int i=n-2;i>=0;i--)
		{
			if(m[i]>m[i+1])
				right[i]=right[i+1]+1;
		}
		
		int ans=0;
		
		for(int i=0;i<n;i++)
		{
			ans=ans+Math.max(left[i],right[i]);
		}
		
		return ans;
	}

	private static int MaxJobs1(int[] s, int[] e) // s → deadline // T.C = O( N*logN + N)
	{											  // e → profit	  // S.C = O( N )
		 ArrayList<Pair> ar=new ArrayList<>();
		 
		 for(int i=0;i<s.length;i++)
		 {
			 ar.add(new Pair(s[i],e[i]));
		 }
		 
		 Collections.sort(ar,(a,b)->a.e-b.e);// Sort Increasing of Dead Line
		 
		 
		 PriorityQueue<Integer> mh=new PriorityQueue<>();
		 
		 int ans=0;
		 
		 for(int i=0;i<s.length;i++)
		 {
			 if(ar.get(i).s>mh.size())// If deadline > number of jobs done → we can take job
			 {
				mh.add(ar.get(i).e);
				ans=ans+ar.get(i).e;
			 }
			 else// No Empty Slot, Replace
			 {
				 if(ar.get(i).e>mh.peek()) //Replace
				 {
					 ans=ans-mh.peek();
					 
					 mh.poll();// Removing Current Min
					 
					 mh.add(ar.get(i).e);
					 
					 ans=ans+ar.get(i).e;
				 }
			 }
		 }
		 return ans;
	}

	private static int MaxJobs(int[] s, int[] e) // T.C = O(NlogN + N)
	{											 // S.C = O(N)
		ArrayList<Pair> ar=new ArrayList<>();
		
		for(int i=0;i<s.length;i++)
		{
			ar.add(new Pair(s[i],e[i]));
		}
		
		Collections.sort(ar,new Sortow());
		// Collections.sort(ar, (a, b) -> a.e - b.e);
		// Collections.sort(ar, (a, b) -> Integer.compare(a.e, b.e));// Convert to Lambda (Modern Java)
		
		int c=1,end=ar.get(0).e;
		
		for(int i=1;i<s.length;i++)
		{
			if(ar.get(i).s >= end)
			{
				c++;
				end=ar.get(i).e;
			}
		}
		return c;
	}

}
