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
