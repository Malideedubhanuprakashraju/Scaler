package IntroductionToProgram2;

public class Functions_1 
{

	public static void main(String[] args) 
	{
		//Q) Factorial : Given N, Print factorial of N
		// Factorial of N : 1*2*3....N-1*N
		// 0!=1
		// Factorial   |  Output
		//     4!		  1*2*3*4=24
		//	   3!         1*2*3=6
		//	   5!		  1*2*3*4*5=120
		
		Factorial(4);
		
		//N
		// C
		//  R : Given N and R where (N>=R) Calculate N(C)R
		// NCR=N!/((N-R)!R!
		
		int N=6;
		int R=2;
		NCR(N,R);
		
		/* Function : Create it Once & Use it Multiple Times
		 * Rules :
		 * 1. We Cannot create function inside another function.
		 * 2. We will create function inside class.
		 * 3. We can call a function from another function.
		 * 4. When we call function, values from function call are copied to function variable
		 * 5. Before return_type please keep static to your functions, before static it's also a good practice to keep public, if you don't keep public code works.
		 * 6. When the function return, function call becomes value which we can store or print
		 * 7. When you are not returning anything return_type is void.
		 * 8. When function return_type is nothing{void}, function call is also nothing, we conn't store it or print it.
		 * 
		 * 
		 * Function Syntax :
		 * 				    Static return_type fname(input_type var1, input_type var2,....)
		 * 					{
		 * 						stmt 1
		 * 						stmt 2
		 * 						stmt 3
		 * 
		 * 						return output;
		 * 					}
		 * Ciel(X) : Given a number X, return Smallest Integer >=X
		 * 
		 * X      |  ceil(X)
		 * 3.42			4
		 * 5.67			6
		 * 6			6
		 * -4.5        -4
		 * 6.5			7
		 * -3.4		   -3
		 * 
		 * Floor(X) : Given a number X, return Greatest Integer <=x
		 * 
		 * X     |  floor(X)
		 * 3.42        3
		 * 5.67        5
		 * 6		   6
		 * -3.4		  -4
		 * -4.5       -5
		 * -7         -7
		 * 
		 * Predefined Functions : Functions That are Already Created
		 * 
		 * Rules : 1) Name of Function
		 * 		   2) Check input Parameters
		 * 		   3) Check Return Type of The Function
		 * 
		 * In Math Class : There are Lot of Pre-defined Functions
		 * 				   For a Predefined Function, If It's Static to use That
		 * 				   Function we use--> Classname.function_name(Input)
		 * 
		 * Eg :
		 * 
		 * 1. Math.ceil(x)
		 * 2. Math.floor(x)
		 * 3. Math.pow()
		 * 4. Math.abs()
		 * 5. Math.max()
		 * 6. Math,min()
		 * 	
		 * 
		 */
		
		
	}

	private static void NCR(int n, int r) 
	{
		 int nf=1;
		 for(int i=1;i<=n;i++)
		 {
			 nf=nf*i;
		 }
		 int nrf=1;
		 for(int i=1;i<=n-r;i++)
		 {
			 nrf=nrf*i;
		 }
		 int rf=1;
		 for(int i=1;i<=r;i++)
		 {
			 rf=rf*i;
		 }
		 
		 System.out.println(nf/(nrf*rf));
		 
	}

	private static void Factorial(int n)
	{ 
		int f=1;
		for(int i=1;i<=n;i++)
		{
			f=f*i;
		}
		System.out.println(f);
	}

}
