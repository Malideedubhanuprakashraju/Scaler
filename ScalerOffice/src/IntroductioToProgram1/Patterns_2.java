package IntroductioToProgram1;

public class Patterns_2 
{

	public static void main(String[] args) 
	{
		//Q) Triangle Pattern :Reverse
				//N=1 *
				//N=2 * - * -
				//	  - * -
		
		Patterns9(5);
		
		//Q) Diamond Problem
		//N=1 *
		//     *
		//N=2 * *
		//     *
		//N=3 * *
		//	*  *  *
		//  *  *  *
		//    *  *
		//      *
		
		Patterns10(5);
		
		//Q) Hallow Upper Traingle
		//N=3
		//* * * * * *
		//* * - - * *
		//*	- - - -	*
		
		Patterns11(5);
		
		//Q) Hallow Lower Traingle
		
		Patterns12(5);
		
		System.out.println();
		
		//Q) Hallow Diamond Pattern
		
		Patterns13(5);
		
		/* Break Statement : To Stop The Iteration before it Actually Completes, we use break statement
		 * Once we execute break;
		 * In Loop it immediately comes out of Loop
		 * 
		 * Note : Without Loops if we write we will get error
		 */
		/* Continue Keyword : It immediately goes to next iteration, by updating loop Variable
		 * Used to Skip few  Iterations
		 *  
		 */
	}

	private static void Patterns13(int n) 
	{
				//Upper Hallow Diamond
				for(int i=n;i>=1;i--)
				{
					int st=i;
					for(int j=1;j<=st;j++)
					{
						System.out.print("*");
					}
					
					int sp=2*(n-i);
					for(int j=1;j<=sp;j++)
					{
						System.out.print("-");
					}
					int stt=i;
					for(int j=1;j<=stt;j++)
					{
						System.out.print("*");
					}
					
					System.out.println();
				}
		//Lower Hallow Diamond
		for(int i=1;i<=n;i++)
		{
			int st=i;
			for(int j=1;j<=st;j++)
			{
				System.out.print("*");
			}
			
			int sp=2*(n-i);
			for(int j=1;j<=sp;j++)
			{
				System.out.print("-");
			}
			int stt=i;
			for(int j=1;j<=stt;j++)
			{
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		 
	}

	private static void Patterns12(int n) 
	{
		for(int i=1;i<=n;i++)
		{
			int st=i;
			for(int j=1;j<=st;j++)
			{
				System.out.print("*");
			}
			
			int sp=2*(n-i);
			for(int j=1;j<=sp;j++)
			{
				System.out.print("-");
			}
			int stt=i;
			for(int j=1;j<=stt;j++)
			{
				System.out.print("*");
			}
			
			System.out.println();
		}
		 
	}

	private static void Patterns11(int n) 
	{ 
		for(int i=n;i>=1;i--)
		{
			int st=i;
			for(int j=1;j<=st;j++)
			{
				System.out.print("*");
			}
			
			int sp=2*(n-i);
			for(int j=1;j<=sp;j++)
			{
				System.out.print("-");
			}
			int stt=i;
			for(int j=1;j<=stt;j++)
			{
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

	private static void Patterns10(int n) 
	{
		 for(int i=1;i<=n;i++)
		 {
			 int sp=n-i;
			 for(int j=1;j<=sp;j++)
			 {
				 System.out.print(" ");
			 }
			 int st=i;
			 for(int j=1;j<=st;j++)
			 {
				 System.out.print("* ");
			 }
			 System.out.println();
		 }
		 
		 for(int i=n;i>=1;i--)
		 {
			 int sp=n-i;
			 for(int j=1;j<=sp;j++)
			 {
				 System.out.print(" ");
			 }
			 int st=i;
			 for(int j=1;j<=st;j++)
			 {
				 System.out.print("* ");
			 }
			 System.out.println();
		 }
	}

	private static void Patterns9(int n) 
	{
		for(int i=n;i>=1;i--)
		{
			int s=n-i;
			for(int j=1;j<=s;j++)
			{
				System.out.print("-");
			}
			int stars=i;
			for(int j=1;j<=stars;j++)
			{
				System.out.print("*-");
			}
			System.out.println();
		}
		 
	}

}
