package C3_DataTypes_1;

public class Class_3 {

	public static void main(String[] args) 
	{
		/* Data Types and Variables:
		 * Basic Rules Of Variables:
		 * Rule1: In order to use a variable we need to declare and initialise it first.
		 * Rule2: We cannot have 2 variables with same name.
		 * Rule3: We can create multiple variables of same type in a single line separated by comma.
		 *  1. int x=20,y = 40;
            2. System.out.print(x+y);
            
         * Rules of naming a Variable:
         * 1) Name can only contain lowercase[a-z], uppercase alphabets[A-Z],
		   digits(0-9), ‘$’{Dollar} or ‘_’ {Underscore}, nothing else
		 * 2) Name cannot start with a digit
		 * 3) Cannot use reserve keywords as variable name :
				Reserve keywords : Words which already have a predefined
				meaning in java, they have a predefined use for them
				Ex : public, static, void, int, etc :
		 * Variable name is also case senstive.
		 * Link to read about all the keywords in Java:
		 * https://www.scaler.com/topics/what-is-keyword-in-java/
		 * 
		 */
		/* Different categories of data:
		 * There are 3 types of data:
		 * Numbers:
					Decimal Numbers
						Float
						Double
					Non Decimal Numbers
						Byte (Rarely used).
						Short (Rarely used).
						Int
						Long
					Text:
						Strings
						Char
						Boolean:
						boolean(T/F)

		 * Int Vs Long:
		   The difference between them is in range of digits.
						
						Range of int:
							-2(31) to 2(31)-1.
						Approximate range:
							-2* 10(9) to 2* 10(9)
						
						Range of long:
							-263 to 263-1.
						Approximate range:
							-8* 1018 to 8* 1018
		 * Rule1: In java, whenever we write a non-decimal number, it is considered as int type.
		 * Note : When we write “L” in front of the number it is telling the compiler that consider this number as long, not int.
		 * 
		 * TypeCasting:
		 * The process of converting from one data type to another type is referred to as Typecasting.
		 * 1)Implicit TypeCasting(Automatic):
						When the conversion is automatically performed by the compiler without the user's interference, it is called implicit type casting or widening type casting.
						
						In implicit typecasting, the conversion is from a smaller data type to the larger type type.

		 * https://i.imgur.com/DAgz4mo.png
		 * 
		 * 2)Explicit TypeCasting:
		 * Explicit type casting refers to the conversion of a larger data type into a lower one. It is also known as narrowing type casting.

		   It does not happen on its own. We must do it explicitly otherwise compilation error is thrown.
		 * https://i.imgur.com/tLlpood.png
		 * https://i.imgur.com/4qobUT5.png
		 */
		
		/*Taking Input from the User:
		 * To read input from the user, We use the tool Scanner.
		 * Syntax: Scanner scn=new Scanner(System.in);
		 * Here Scanner is the keyword and scn is the name of the variable. 
		 * In order to use Scanner, we need to import some libraries.
		 * import java.util.*; 
		 * Syntax to take inputs in different data types:
		 * 		int x=scn.nextInt();
				long y=scn.nextLong();
		 * To Remember:
		 * No such element Exception:	
		 * 							The NoSuchElementException is an unchecked exception in Java which indicate that the element being requested does not exist.
		 * Eg: Input : 20
				1. int a = sc.nextInt(); 
				2. int b = sc.nextInt();
				3. System.out.print(a+b);

		 * Exception :
		 * Exception in thread "main" java.util.NoSuchElementException
			at java.util.Scanner.throwFor(Scanner.java:862)
			at java.util.Scanner.next(Scanner.java:1485)
			at java.util.Scanner.nextInt(Scanner.java:2117)
			at java.util.Scanner.nextInt(Scanner.java:2076)
			at Main.main

		 * Explanation:
		 * In line1, "a" will have value 20.
		   In line2, for variable "b" user is not giving input, 
		   So compiler will give error. 

		 */
	}

}
