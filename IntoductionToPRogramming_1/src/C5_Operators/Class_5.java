package C5_Operators;

public class Class_5 
{

	public static void main(String[] args) 
	{
		/* Operators
		 * Type Casting Revision
		 * Rules :
				While type casting if there is no chance of data loss, we will not get any error.
					Implicit/ Widening (Automatically)
				If there is even slight possibility of dataloss in that case we get error. If we still want to typecast we forcefully have to do it.
					Explicit/ Narrowing (forcefully)
		 * Rule 1: When we do operation between non decimal & decimal, the result is of decimal type
		 * When we perform operation between int and double, the output is double.
		   And when we try to store double value into int type variable we get error.
		 * Rule 2: Whenever you perform operation between two operands of same category then the result of bigger type
		 * When we perform operation between int and long, the output is long.
		   And when we try to store long value into int type variable we get error.
		 */
		/* Operators
		 * 1. Arithmetic Operators : Arithmetic operators include ( + , - , * , / , % )
		 * Line 1:    int a = 10, b = 24;
		   Line 2:    System.out.println(a+b);
		   Line 3:    System.out.println(a-b);
		   Line 4:    System.out.println(a*b);
		   Line 5:    System.out.println(b/a);
		 * Modulus operator ( % )	
		 * This operator gives remainder as output.			
		 * 2. Relational Operators : Relational operators include ( > , >= , < , <= , != , == )
		 * 						   : Output : true/false
		 * 3. Logical Operators : The logical operators include AND (&&) , OR (||) , NOT (!)
		 * 4. Assignment Operators : The assignment operators include ( = , += , -= , *= , /=, %= )
		 * 5. Unary Operators : 
		 * Post Operator - Post Increment - First use and then increment
		 * 				   Line 1: int a = 10;
						   Line 2: int b = a++;
						   Line 3: System.out.println(a);//11
						   Line 4: System.out.println(b);//10
						   Output :
						   a++ is a post increment operator. 
						   So, value of variable a which is 10 is stored in variable b 
						   And then value of a is incremented to 11
			   
		 * 				 - Post decrement - First use and then decrement
		 * 				   Line 1: int a = 10;
						   Line 2: int b = a--;
						   Line 3: System.out.println(a);//9
						   Line 4: System.out.println(b);//10
						   Output :
						   a-- is a post decrement operator. 
						   So, value of variable a which is 10 is stored in variable b 
						   And then value of a is decremented to 9.
						   	
		 * Pre Operator - Pre Increment - Increment first and then use
		 * 				  Line 1: int a = 10;
						  Line 2: int b = ++a;
						  Line 3: System.out.println(a);//11
						  Line 4: System.out.println(b);//11
						  Output :
						  ++a is a pre increment operator. 
						  So, value of variable a is updated to 11 
						  And then 11 is stored in variable b


		 * 				- Pre Decrement - Decrement first and then use
		 * 				  Line 1: int a = 10;
						  Line 2: int b = --a;
 						  Line 3: System.out.println(a);//9
						  Line 4: System.out.println(b);//9
						  Output :
						  --a is a pre increment operator. 
						  So, value of variable a is updated to 9.
						  And then 9 is stored in variable b
					 
		 * Java operator precedence and associativity
		 * https://i.imgur.com/tjaYKFW.png
		 */
	}

}
