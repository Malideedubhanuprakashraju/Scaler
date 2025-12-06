package C4_DataTypes2;

public class Client 
{

	public static void main(String[] args) 
	{
		/*Data Types and Variables:
		 * Float Vs Double:
		 * The difference between float and double lies between number of digits they have after decimal points.
		 * Float -> can have upto 6 to 7 digits after decimal point.
		   Double -> can have upto 15 to 16 digits after decimal point.
		 * Rule1: In JAVA, Any decimal number is considered as double by default.
		 * Note : Here we are writing "f" after the value, compiler will considered this number as float. 
		 * 
		 * Type Casting Float vs Double:
		 * Rule 1: When we store float to double no loss of data, hence no issue. {Implicit Type Casting}.
		 * Rule 2. When we store double to float there can be a loss of data, So complier will raise an error.
		 * Rule 3. If we still want to force the compiler to convert, We need to explicitly typecast it. {Explicit Type Casting}.
		 */
		/* Type Casting Decimal vs Non Decimal:
		 * Rule 1: From non-decimal to decimal is Implicit Typecast.
		 * Note : From int to double no loss of data, Therefore it is implicit Typecasting. 
		 * Rule 2: If there is even a slight chance of data loss the compiler will give error. But we can still do it by Explicit Typecast from decimal to non-decimal.
		*/
		
		/* Reading Inputs for Float and Double:
		 * Input: 19.25
				float x = sc.nextFloat();
				System.out.println(x);

		 * Here we don't need to specify "f", since we are using nextFloat so this value will be taken as float only. 
		 * 
		 * Input: 19.25
				double y = sc.nextDouble();
				System.out.println(y);
		 * Here also by using nextDouble, compiler will take the value as double only. 
		 */
		/* Input Mismatch Exception:
		 * The exception can occur when the input we provide cannot be implicitly stored in the given datatype.
		 * Input : 3.14 20
 
					Scanner sc = new Scanner(System.in); 
					1. int a = sc.nextInt(); 
					2. int b = sc.nextInt();
					3. System.out.print(a+b);

		 * Note : Exception in thread "main" java.util.InputMismatchException
		 * Division by Zero:
					Dividing an integer by zero will result in an ArithmeticException:

		 * System.out.println(4/0);
		 * [NonZeroExitCode] Your code encountered a runtime error
		   Exception in thread "main" java.lang.ArithmeticException: / by zero
		 * Dividing a floating-point number with zero, won't give any exception, but will give Infinity.
		 * System.out.println(4.0/0);
		 * [Success] Your code was executed successfully
		   Infinity
		 * Dividing floating-point zero values by zero will give NAN(Not A Number).
		 */
		/* Reading String Inputs:
		 * For taking String inputs, we use:
		 * 1 .next(); - next() method in Java is used to read the input before the space is encountered. next() method is unable to read two words separated by space.
						After reading the input, it keeps the cursor in the same line.
		 * 2 .nextLine(); - .nextLine() method reads text until it reaches the end of the line.
							 It moves the cursor to the next line after reading the complete line.
		 * Boolean Datatype and Reading Input:
		 * Boolean can take true or false only. 
		 * boolean x = false;
		   System.out.println(x);
		 * Boolean can take true or false only. 
		 *Input: True
				Scanner sc = new Scanner(System.in);
				boolean y = sc.nextBoolean();
				System.out.println(y);
		 *Boolean can only have true / false, it will work on True/False, but give answer in lowercase only.
		 */
	}

}
