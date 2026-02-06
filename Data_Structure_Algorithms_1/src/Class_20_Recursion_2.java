public class Class_20_Recursion_2 

{



	public static void main(String[] args) 

	{

		/* Recursion-2

		 * 

		 * Recursion => Solving Problems using SubProblems.

		 * Data Structure => Stack

		 * 

		 * Steps :

		 * 

		 * 1) Assumption :

		 * 2) Main Logic :

		 * 3) Base Condition :

		 * 4) T.C : Total Function Calls * Time Taken for each Function Call

		 * 5) S.C : Max Stack Size at Any given Point.

		 *  

		 */

		

		// Q1) Given Power(a,n) return a^n using Recursion.

		// Way-1 :

		

		/* Pow(3,4) = 3*3*3*3

		 * Pow(3,5) = 3*3*3*3*3

		 * Pow(3,5) = Pow(3,4)*3

		 * 

		 * 							  ---> n-times

		 * Pow(a,n) = a*a*a*a*.......a*a

		 * Pow(a,n) = Pow(a,n-1)*a;

		 * 				 |

		 * 				 ------> SubProblem

		 */

		int a=3,n=4;

		int ans=Pow(a,n);

		System.out.println("Power if a in n-times : "+ans);

		

		// Way-2 :

		

		/* Pow(3,8) = Pow(3,7)*3

		 * 			= Pow(3,4)*Pow(3,4) // Another Way to Solve Same Problem

		 * 

		 * Pow(4,10)= Pow(4,5)*Pow(4,5)

		 * 

		 * Pow(4,11) = Pow(4,5)*Pow(4,5)*4

		 * Pow(5,13) = Pow(5,6)*Pow(5,6)*5

		 * 

		 * Observation :

		 * 

		 * Pow(a,n) = if n is even :

		 * 					Pow(a,n/2)*Pow(a,n/2);

		 * 			  else

		 * 					Pow(a,n/2)*Pow(a,n/2)*a;

		 * 

		 * Optimization : Same SubProblem Twice, Solve once Store it & Re-Use.

		 * 

		 * Pow(a,n) : P=Pow(a,n/2);

		 * 			  if n is even :

		 * 					return p*p;

		 * 			  else

		 * 					return p*p*a;

		 */

		int ans1=Pow1(a,n);

		System.out.println("Power Optimized Code 1 : "+ans1);

		

		// Q2) Print Array Ele Using Recursion

		

		int ar[]= {3,7,8,2,9};

		

		/* Show (0 ar) = ar[0] ar[1] ar[2] ar[3] ar[4]

		 * 

		 * Actual Problem  Print(ar[0]) //ar[0]

		 * 				   Show(1,ar)   //ar[1],ar[2],ar[3],ar[4]

		 * 

		 * Show(i,ar) = ar[i],ar[i+1],ar[i+2]....ar[n-2]ar[n-1]

		 * 			  = print(ar[i]);

		 * 			  = Show(i+1,ar);

		 */

		// Ass: Given Array A,i : Print All Array Elements from ar[i]...ar[N-1]

		solve(ar);

		

		// Q3) Sum of Elements using Recursion

		// Ass : Given Array A,i : Return Sum of All Array Elements rom Ar[i]....Ar[N-1]

		

		int s=SovleSum(ar);

		System.out.println();

		System.out.println("Sum of ArrayElements : "+s);

		

		// Q4) Given an Array and Target = B

		/* 	   The Task is count all indices at which B occurs in the Array

		 * 	   It is guranteed that the Target B,exists only once in Array .

		 * 

		 * eg: A[]={4,5,3,1,5,4,5};

		 * 	   B=5;

		 * ans=3.

		 * 

		 * Count(A,B 0): Count of Occurences of B from A[0],A[1],A[2]...A[N-1]

		 * 				

		 * 				 if(A[0]==B) // Occurrence of B : A[1]A[2]...A[N-1]

		 * 				 {

		 * 					c=c+1; 		c=c+count(A,B,1);

		 * 				 } 

		 */

		// Assumption : Given A,B,i : Count & Return no:of Occurrence of B from A[i] A[i+1]...A[N-1]

		int A[]={4,5,3,1,5,4,5};

		int ans2=solve(A,5);

		System.out.println("Search Element Occurs in : "+ans2);

		

		// Q5) Given a SubString, check if it's Palindrome or Not

		//				   |

		//				   ------> Continuous part of String -->SubString.

		

		/* Palindrome : L->R or R->L It is Same.

		 * 

		 * eg : MOM, MADAM, MALAYALAM

		 * 

		 * Ass: Given String[], Check & Return, if from [s,s+1......e-1,e]--> is Palindrome or Not.

		 */

		String ss="gooedabadedf";

		char aa[]=ss.toCharArray();

		String ab=aa.toString();

		boolean anss=isPal(aa,3,9);

		System.out.println("Given SubString is : "+anss);

		

		// Q6) Given N, Return Reverse of N.

		

		int rev=Reverse(1234);

		System.out.println("Reverse of Given Number : "+rev);

		

	}



	private static int Reverse(int N) // T.C = O(N)

	{								  // S.C = O(N)

		if(N==0)

		{

			return 0;

		}

		int d=N%10;

		int r=Reverse(N/10);

		int c=digits(r);

		return d*pow(10,c)+r;

	}



	private static int pow(int a, int n) 

	{

		// p(2,3) = 2*2*2

		//          p(a-1)*a

		// p(2,4) = 2*2*2*2

		//			p(n-1)+a

		

		 if(n==0)

		 {

			 return 1;

		 }

		 return pow(a,n-1)*a;

	}



	private static int digits(int r) 

	{

		int c=0;

		if(r==0)

		{

			return 0;

		}

		while(r>0)

		{

			c++;

			r=r/10;

		}

		return c;

	}



	private static boolean isPal(char[] aa, int s, int e) // T.C = O(N)

	{													  // S.C = O(N)

		if(s>e)

		{

			return true;// No String

		}

		

		if(aa[s]==aa[e] && isPal(aa,s+1,e-1))

		{

			return true;

		}

		else

		{

			return false;

		}

		

	}



	private static int solve(int[] a, int b) 

	{

		 return search(a,b,0);

	}



	private static int search(int[] a, int b, int i) // T.C = O(N)

	{												 // S.C = O(N)

		if(i==a.length)

		{

			return 0;

		}

		

		int c=search(a,b,i+1);

		

		if(a[i]==b)

		{

			c=c+1;

		}

		

		return c;

	}



	private static int SovleSum(int[] ar) 

	{

		return SumA(ar,0);// Print A[] from )^th index-->N-1.

	}



	private static int SumA(int[] ar, int i) // T.C = O(N) 

	{ 										 // S.C = O(N)

		if(i==ar.length)

		{

			return 0;

		}

		return SumA(ar,i+1)+ar[i];// A[i]+A[i+1]+A[i+2]....A[N-1];

		

	}



	private static void solve(int[] ar) 

	{

		 Show(ar,0);// Print ar[] from o^th index-->N-1.

	}



	private static void Show(int[] ar, int i) // T.C = O(N)

	{ 										  // S.C = O(N)

		if(i==ar.length)

		{

			return;

		}

		System.out.print(ar[i]+" ");

		Show(ar,i+1);

	}



	private static int Pow1(int a, int n) // O(log N)

	{									  // O(log N)

		if(n==0)

		{

			return 1;

		}

		int p=Pow1(a,n/2);

		if(n%2==0)

		{

			return p*p;

		}

		else

		{

			return p*p*a;

		}

	}



	private static int Pow(int a, int n) // T.C = O(N+1*1)= O(N)

	{									 // S.C = O(N+1*1)= O(N)

		if(n==0)

		{

			return 1;

		}

		

		return Pow(a,n-1)*a;

	}



}

