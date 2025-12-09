package C11_Patterns_1;

public class Patterns 
{

	public static void main(String[] args) 
	{
		//Q) Given N, Print Stars(*) in a Single Row
		Print(5);
		
		//Q) Given N, Print N*N dimensional square
		pDimen(5);
		
		//Q) Given N, Print Staircase Problem
		StairCase(5);
		
		//Q) Given N, Print ReverseStairCase Problem
		RevStairCase(5);
		
		//Q) Given N, Print The Following Pattern
		//N=2
		//1
		//1 2
		printt(5);
		
		//Q) Given N, Print The Following Pattern
		//N=3
		//1
		//2 3
		//3 4 5
		
		Print2(5);
		
		//Q) Given N, Print The Following Pattern
		//N=3
		//1
		//2 3
		//4 5 6
		print3(5);
		
		//Q) Pattern With Spaces
		//N=1 : **
		//N=2 : * *
		//		* *
		//N=3 : *--*
		//		*--*
		//      *--*
		
		print4(5);
		
		
		//Q) Pattern With Spaces
		//N=1 : **
		//N=2 : *-*
		//		**
		//N=3 : *--*
		//		*-*
		//      **	
		
		//Note : In Pattern Printing involving *,- Find Pattern Between row number & Spaces,We can Solve Logic
		print5(5);
		
		//Q) Triangle Pattern
		//N=1 *
		//N=2 - *
		//	  * *
		pattern6(5);
		
		//Q) Pyramid Program
		// Extend to Triangle Program
		pattern7(5);
		
		//Q) Triangle Pattern :Reverse
		//N=1 *
		//N=2 * *
		//	  - *
		pattern8(5);
		
	}

	private static void pattern8(int n) 
	{
		for(int i=n;i>=1;i--)
		  {
			  int s=n-i;
			  for(int j=1;j<=s;j++)
			  {
				  System.out.print("- ");
			  }
			  int Stars=i;
			  for(int j=1;j<=Stars;j++)
			  {
				  System.out.print("* ");
			  }
			  System.out.println();
		  }
	}

	private static void pattern7(int n) 
	{
		for(int i=1;i<=n;i++)
		  {
			  int s=n-i;
			  for(int j=1;j<=s;j++)
			  {
				  System.out.print(" ");
			  }
			  int Stars=i;
			  for(int j=1;j<=Stars;j++)
			  {
				  System.out.print("* ");
			  }
			  System.out.println();
		  }
		 
	}

	private static void pattern6(int n) 
	{
	  for(int i=1;i<=n;i++)
	  {
		  int s=n-i;
		  for(int j=1;j<=s;j++)
		  {
			  System.out.print("-");
		  }
		  int Stars=i;
		  for(int j=1;j<=Stars;j++)
		  {
			  System.out.print(" *");
		  }
		  System.out.println();
	  }
	}

	private static void print5(int n) 
	{
		for(int i=1;i<=n;i++)
		{
			System.out.print("* ");
			int s=n-i;
			for(int j=1;j<=s;j++)
			{
				System.out.print("-");
			}
			System.out.println(" *");
		}
		
	}

	private static void print4(int n) 
	{
		for(int i=1;i<=n;i++)
		{
			System.out.print("*");
			int space=n-1;
			for(int j=1;j<=space;j++)
			{
				System.out.print("-");
			}
			System.out.println("*");
		}
		 
	}

	private static void print3(int n) 
	{
		 int k=1;
		 for(int i=1;i<=n;i++)
		 {
			 for(int j=1;j<=i;j++)
			 {
				 System.out.print(k+" ");
				 k++;
			 }
			 System.out.println();
		 }
	}

	private static void Print2(int n) 
	{	
		 
		 for(int i=1;i<=n;i++)
		 {
			 int k=i;
			 for(int j=1;j<=i;j++)
			 {
				 System.out.print(k+" ");
				 k++;
			 }
			 System.out.println();
		 }
	}

	private static void printt(int n) 
	{
		for(int i=1;i<=n;i++)
		{
			int num=1;
			for(int j=1;j<=i;j++)
			{
				System.out.print(num+" ");
				num=num+1;
			}
			System.out.println();
		}
	}

	private static void RevStairCase(int n) 
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=i;j<=n;j++)
			{
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	private static void StairCase(int n) 
	{
		 for(int i=1;i<=n;i++)
		 {
			 for(int j=1;j<=i;j++)
			 {
				 System.out.print("* ");
			 }
			 System.out.println();
		 }
	}

	private static void pDimen(int n) 
	{
		 for(int i=0;i<n;i++)
		 {
			 for(int j=0;j<n;j++)
			 {
				 System.out.print("* ");
			 }
			 System.out.println();
		 }
	}

	private static void Print(int n) 
	{
		 for(int i=1;i<=n;i++)
		 {
			 System.out.print("* ");
		 }
	}

}
