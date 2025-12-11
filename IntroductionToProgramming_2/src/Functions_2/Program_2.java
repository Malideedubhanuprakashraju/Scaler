package Functions_2;

public class Program_2 
{

	public static void main(String[] args) 
	{ 
		/* Functions 2
		 * Few things to know about functions
		 * When will a function end?
		 * When all the statements of that function are executed
		 * When we execute the return statement
		 * What happens when the function ends?
		 * We go back to where it was called from [the function call]
		 * Code1:
		 *  			Line1:    static boolean IsEven(int N)
		 *  					  {
						Line2:        if(N % 2 == 0)
									  {
						Line3:            return true;
						Line4:        }
						Line5:        System.out.println("Hey");
						Line6:        return false;
						Line7:    }
						Line8:    public static void main(String[] args)
								  {
						Line9:        System.out.println(IsEven(8);)
						Line10:   }

		 * Output : true
		 * 
		 * Code2:
		 *			 	Line1:    static void printHello()
		 *						  {
						Line2:        System.out.println("Hello Everyone");
						Line3:        System.out.println("Good Morning");
						Line4:    }
						Line5:    public static void main(String[] args)
								  {
						Line6:        printHello();
						Line7:        System.out.println("Bye");        
						Line8:    }

		 * Output :
		 * Hello Everyone
		   Good Morning
		   Bye
		 * 
		 * Rule 1 : When we create a function which has some mistake in it, we will get error irrespective of whether that function is being called or not.
		 * Code :
		 * 			static int check(int N)
		 * 			{ 
    				System.out.println(N+10); 
					}		
					public static void main(String[] args)
					{
    					int a = 10; 
    					System.out.println(a+10);
					}
		 * Output : error: missing return statement
		 * Explanation : In the check function, the return type is int. 
						 But we are not returning an integer value from that function.
		 * 
		 * Rule 2 : We can use return keyword when the return type is void without returning anything
		 * Code 1:
		 * 			Line1:    static void test2()
		 * 					  {
					Line2:        System.out.println("Hi");
					Line3:        return;
					Line4:    }
					Line5:    public static void main(String args[]) 
							  {
					Line6:        test2();
					Line7:    }

		 * Output : Hi
		 * Explanation: Here, we are not returning anything with return keyword.
						Hence it can be used with void type as well.

		 * Code 2:
		 *          Line1:    static void evenodd(int N)
		 *          		  {
					Line2:        if(N%2==0)
								  {
					Line3:            System.out.println("Even");
					Line4:            return;
					Line5:        }
					Line6:        System.out.println("Odd");
					Line7:    }
					Line8:    public static void main(String args[]) 
							  {
					Line9:        evenodd(14);
					Line10:       System.out.println("Done");
					Line11:   }

		 * Output : Even
		 * 			Done
		 * 
		 * Rule 3 : If function has a return type which is not void, then we need to return a value in all the cases.
		 * Protip : Assume all the conditions are false and check whether we have a return statement or not.
		 * Code :
		 * static int even(int N)
		 * { 
    			if(N%2==0)
    			{
        			return 2;
    			}
			}	
			public static void main(String args[]) 
			{
    			System.out.println(even(27));
			}
		 * Output :
		 * error: missing return statement
		 * Explanation :
		 * Here, we are returning a value in the case when condition is true
		   So, we are missing a return statement when condition is false
		 * Rule 4 : Having unreachable statements in the code gives us error
		 * The statements which never get executed are called unreachable statements.
		 * Code :
		 *          Line1:    static int sum(int a,int b)
		 *          		  {
					Line2:        return a+b;  
					Line3:        System.out.println("Hey"); 
					Line4:    }	
					Line5:    public static void main(String args[]) 
							  {
					Line6:        System.out.println(sum(10, 5));
					Line7:    }

		 * Output :
		 * error: unreachable statement
           System.out.println("Hey"); 
           ^
		 * Explanation :
		 * With the help of Line 2, we exit the sum function
		   Hence, Line 3 never gets executed making it a unreachable statement
		 * 
		 * 
		 */
		//Q) Given N, return Sum of All Even Numbers Till N ?
		//eg :N=10= Return {2+4+6+8+10}=30
		//Note : N>0
		int N=10;
		int ans=evenSum(N);
		System.out.println(ans);
		
		//Q) Given R, Find Area of Circle
		// 1. Calculate Area Using Formula =PI*R^2
		// 2. Exact Value of PI=3.14
		// 3. We can get it using Math.PI(Final Static Double Variable in Math Class)
		double ans1=areaOfCircle(4);
		System.out.println(ans1);
		
		//Q) Perfect Square
		// Given N, Chek if it's a Perfect Square or Not ?
		// Note : N is a perfect square, if it can be written as Product of Two Equal +ve Numbers
		// N   |  isPerfect()
		// 25		  5*5	:return true
		// 36		  6*6	:return true
		// 30		  		:return false
		boolean ans2=isPerfect(16);
		System.out.println(ans2);
		
		//Q) Given N, Return Sum of All Factors of N.
		//Note : A number i is said to be factor of N:--->if N%i==0
		//eg:
		//N    |  Sum of Factors
		//6			1,2,3,4 :return 12
		//10		1,2,3,10 :return 18
		//7			1,7 :return 8
		//12		1,2,3,4,6,12 :return 28
		
		//Obseravation : For Any N:
		//						 1 is Smallest Factor
		//						 N is Largest Factor
		//						 All Factors of N should be [1....N]
		
		int ans3=factorsSum(10);
		System.out.println(ans3);
				
	}

	private static int factorsSum(int n) 
	{
		 int sum=0;
		 for(int i=1;i<=n;i++)
		 {
			 //Check if i is Factor of N.
			 if(n%i==0) //i is a Factor
			 {
				 sum=sum+i;
			 }
		 }
		 return sum;
	}

	private static boolean isPerfect(int n) 
	{ 
		for(int i=1;i*i<=n;i++)
		{
			if(i*i==n)
			{
				return true;
			}
		}
		return false;
	}

	private static double areaOfCircle(int r) 
	{
		double area=Math.PI*r*r;
		
		return area; 
	}

	private static int evenSum(int n) 
	{
		 int sum=0;
		 for(int i=1;i<=n;i++)
		 {
			 if(i%2==0)
			 {
				 sum=sum+i;
			 }
		 }
		 return sum;
	}

}
