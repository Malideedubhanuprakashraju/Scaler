package IntroductionToProgram2;

public class StringImplementation 
{
	public static void main(String[] args) 

	{ 

		/* Strings

		 * Character

		 * A character represents a single symbol. A symbol can be any of the following:

		 * Uppercase Characters [A - Z]

		 * Lowercase Characters [a - z]

		 * Numeric Characters [0 - 9]

		 * Special Characters [@ , $ , # , < , = , etc.]

		 * Syntax

		 * char name = 'single_character';

		 * Code :

		 * char ch = 'a';

		 * American Standard Code for Information Interchange

		 * https://i.imgur.com/AZTBm7N.png

		 * 

		 * Rules of Typecasting

		 * 1) Char to int is implicit typecasting, we get the ASCII value of the character

		 * Code 1:

		 * Line1:    int x = 'a';

		   Line2:    x = x+2;

		   Line3:    System.out.println(x);

		 * Output:

		 * 99

		 * Explanation:

		 * The ASCII value of 'a' is 97.

			So, 97 is stored in variable x. 

			Line 2 increments the value of x by 2

			Hence, Line 3 prints 99 in the output.



		 * Code 2:

		 * Line1:    char ch = 'A';

		   Line2:    int x = ch;

		   Line3:    System.out.println(x);



		 * Output:

		 * 65

		 * Explanation:

		 * The ASCII value of 'A' is 65.

		   So, when we try to store the value of ch into x, 65 is stored.

		   Hence, Line 3 prints 65 in the output.



		 * 2) Char to int gives error sometimes, so explicitly typecast

		 * Code 1:

		 * Line1:    char ch = 'A' + 2;

		   Line2:    System.out.println(ch);



		 * Output:

		 * C

		 * Explanation:

		 * When we perform operation between char and int we get int. 

		   65 + 2 gives 67 which is the ASCII value of 'C'

		   Line 2 prints C in the output.



		 * Code 2:

		 * Line1:    char ch5 = 'A';

		   Line2:    ch5 = ch5 + 32; 

		   Line3:    System.out.println(ch5);



		 * Output:

		 * Error : possible lossy conversion from int to char

		 * Explanation:

		 * When we perform operation between char and int we get int. 

		   We are trying to store int to char and it gives error. 



		 * Code 3:

		 * Line1:    char ch5 = 'A';

		   Line2:    ch5 = (char)(ch5 + 32); 

		   Line3:    System.out.println(ch5);



		 * Output:

		 * a

		 * Explanation:

		 * When we perform operation between char and int we get int. 

		   65 + 32 gives 97 which is the ASCII value of 'a'

		   Line 2 prints a in the output.



		 * 3) We can use operators with char

		 * Code 1:

		 * Line1:    char ch7 = 'B'; 

		   Line2:    if(ch7 >= 90)

		   			 {

		   Line3:        System.out.println("YES");

		   Line4:    }

		   Line5:    else

		   			 {

		   Line6:        System.out.println("NO");

		   Line7:    } 



		 * Output:

		 * NO

		 * Explanation:

		 * The ASCII value of 'B' is 66.

		   Since 66 is not greater than or equals to 90, the condition is false.

		   So, else block is executed.

		   Line 6 prints NO in the output.



		 * Code 2:

		 * Line1:    char ch1 = 'B'; 

		   Line2:    char ch2 = 'a';

		   Line3:    if(ch2 >= ch1)

		   			 {

		   Line4:        System.out.println("YES");

		   Line5:    }

		   Line6:    else

		   			 {

		   Line7:        System.out.println("NO");

	       Line8:    } 



		 * Output:

		 * YES

		 * Explanation:

		 * The ASCII value of 'B' is 66 and 'a' is 97.

		   Since 97 is greater than or equals to 66, the condition is true.

		   So, if block is executed.

		   Line 4 prints YES in the output.



		 * 

		 */

		

		/* Character Array

		 * Syntax

		 * char name[] = new char[size];

		 * 

		 * Code:

		 * static void printChar(char data[])

		 * {

    			int N = data.length; // Index : 0 to N-1 

    			for(int i=0;i<N;i++)

    			{

        			System.out.print(data[i] + " ");

    			}

    			System.out.println();

			}

			public static void main(String args[]) 

			{

    			char ch[] = new char[5];

    			ch[0] = 'A';

    			ch[1] = 'B';

    			ch[2] =  67;

    			ch[3] = 'D';

    			ch[4] = 'E';

    			printChar(ch);

			}



		 * Output:

		 * A

		 * B

		 * C

		 * D

		 * E

		 * Explanation:

		 * An array of character is created of size 5.

		   ch : [ 'A' | 'B' | 'C' | 'D' | 'E' ]

        		   0     1     2     3     4

		   We print all the elments of the array using the function printChar() 



		 * 

		 */

		

		/* String

		 * Syntax

		 * String name = "value";

		 * Code:

		 * String str = "MonaLisa";

		 * Each of the characters have indexes starting from 0.

		 *             "MonaLisa"

		   index:       01234567



		 * Properties

		 * 1) To get total number of characters present in string: name.length()

		 * Code:

		 * String str = "MonaLisa";

		   System.out.println(str.length());



		 * Output:

		 * 8

		 * Explanation:

		 * The given string has 8 characters.

		 * 

		 * 2) To access a character at any particular index: name.charAt(index)

		 * Code:

		 * String str = "MonaLisa";

		   System.out.println(str.charAt(4));



		 * Output:

		 * L

		 * 

		 * Explanation:

		 * The given string has 'L' at 4th index.

		 * 3) We cannot update characters at particular indices.

		 * 4) We can append a character or String at the start or end of a String

		 * Code 1:

		 * String str = "Hell";

		   str = str + 'o';

		   System.out.println(str);



		 * Output:

		 * Hello

		 * 

		 * Explanation:

		 * Here, we are appending a character at the end.

		 * 

		 * Code 2:

		 * String str = "Hello";

		   str = "Guys " + str;

		   System.out.println(str);



		 * Output:

		 * Guys Hello

		 * 

		 * Explanation:

		 * Here, we are appending a string at the start.

		 * StringBuilder

		 * In order to update character at particular indices we use StringBuilder.

		 * Syntax

		 * StringBuilder name = new StringBuilder(String_name);

		 * Code:

		 * String str = "Hello";

		   StringBuilder sb = new StringBuilder(str);

		   System.out.println(sb);



		 * Output:

		 * Hello

		 * 

		 * Explanation:

		 * StringBuilder sb is created having value "Hello" in it.

		 * Functions

		 * Code:

		 * Line1:    String str = "Hello";

		   Line2:    StringBuilder sb = new StringBuilder(str);

		   Line3:    System.out.println(sb.length());

		   Line4:    System.out.println(sb.charAt(1));

		   Line5:    sb.setCharAt(1, 'x');

		   Line6:    System.out.println(sb);

		   Line7:    System.out.println(sb.append("abc"));

		   Line8:    System.out.println(sb.append('w'));



		 * Output:

		 *  5

			e

			Hxllo

			Hxlloabc

			Hxlloabcw



		 * Explanation:

		 * name.length() -> gives total number of characters

		   name.charAt(index) -> gives character present at that index

		   name.setCharAt(index, character) -> helps us to update the character at particular index

		   name.append(String) -> helps us add the string at the end of the stringBuilder

		   name.append(character) -> helps us add a character at the end of stringBuilder



		 * NOTE: Whenever you want to make changes in your String prefer using StringBuilder.

		 * 

		 * Converting StringBuilder to String

		 * We can use name.toString() function to convert a StringBuilder into String.

		 * For eg. Write a code to change character at 1st index to 'x' in the given String.

		 * Code:

		 * String str = "Hello";

		   StringBuilder sb = new StringBuilder(str);

		   sb.setCharAt(1, 'x');

		   String ans = sb.toString();

		   System.out.println(ans);



		 * Output:

		 * Hxllo

		 * 

		 */

		

		/* Strings

		 * |

		 * ---> In Java Strings are immutable

		 * It means,When String is created, It cannot be Altered.

		 * Any operation that appears to modify the string actually creates a new String.

		 * 

		 * String Builder:

		 * 

		 * StringBuilder sb=new StringBuilder();

		 * sb.append("Hello");

		 * sb.append("World");

		 * 

		 * Note : Strings & StringBuilder are different

		 * 

		 * String result=sb.toString();// Return String of String Builder

		 * 

		 */

		

		// Q1) Write a Function that takes a String and Returns a String Containing only LowerCase Letters.

		// eg :"Cotton"

		// op : otton

		String s1="Cotton";

		String ans1=LowerCase(s1);

		System.out.println("Lower Case : "+ans1);

		

		// Q2) Write a Function That Takes a String and Char.

		// Return a String with Replacing All Occurences of ch-'a' in String with Character @

		// eg:

		//   s="abcad",ch=a

		// op:

		//	 @bc@d

		String s2="interviewbit";

		char c='i';

		String ans2=ReplaceChar(s2,c);

		System.out.println("Replace String With Char : "+ans2);

		

		// Q3) Length of Longest Word input String.

		// Given a string S, you have to find the length of the Logest Word in the input String.

		// eg:

		//	 S=" Hi Hello Bye";

		//  len= 2	  5	   3

		//	Return Max of All Lengths=5;

		String s3="Coding is Awesome";

		int ans3=LongestWord(s3);

		System.out.println(ans3);

		

		// Q4) Sum of digits in String with Character and digits

		// Calculate Sum of All Numbers embedded in a given Alphanumeric String.

		// The String COntain a Mix of Letters & Numbers.

		// Note : When Numbers are Continuous consider them as Single Number.

		// eg:

		//	 S="ab13de450a17"

		//		  13+450+17==>480

		// Need : Append digit d to back N:

		//	N	d	N=N*10+d;

		// 234	3	2343

		

		// Idea : Iterate on String

		//	1) if Char is numeric, add to back of number

		//	2) if Char is alphabet, add num to ans & num=0;

		

		String s4="ab13de450a17";

		int ans4=SumOfNumbers(s4);

		System.out.println(ans4);

		// Q5) Check Palindrome:
		// Given Start: s and end: e of String str
		// Check if from {s...e},is it Palindrome or not?
		// Palindrome : Data L-R & R-L is Same.
		//		   eg : racecar, SOS, 121,mom,malayalam
		// Note : We are Assuming all Characters are same, if not before comparing,convert them into same case & compare 
		String s5="MALAYALAM";
		boolean ans5=isPalindrome(s5,0,8);
		System.out.println("Palindrom Status : "+ans5);
		
		// Properties 
		// 1) name.indexOf(char ch)
		// 			|
		//			----> Returns the First Occurence index of char ch in String
		String a="Hellochalo";
		int i=a.indexOf('o');
		System.out.println("Index :"+i);
		// 2) name.indexOf(char ch,int i)
		//			  |
		//			  ---> Returns the First Occurence of char in String, Starting from i.
		int i1=a.indexOf('l',1);
		System.out.println(i1);
		
		// 3) name.indexOf(String s)
		//			  |
		//			  ----> Returns the First Occurence of SubString S: in String.
		
		int i2=a.indexOf("lo");
		System.out.println(i2);
		
		// 4) name.indexOf(String s,int i)
		//			  |
		//			  ----> Returns the First Occurence of Substring S :in String, Starting from i
		int i3=a.indexOf("lo",5);
		System.out.println(i3);
		// Note : If Char or String we are searching not presents : Returns-1
		
		// Equal Methods to Compare Two Strings
		String q1="hello";
		String q2="hello";
		
		if(q1==q2)
		{
			System.out.println("Working");
		}
		// Comparing Strings with == :SomeTimes it Works, SomeTimes Not
		// Note : Above Issue Persists with String/Integer/Float/Double..
		//											Wrapper Classes
		// Wrapper Classes--->Comparing Them with == : Sometimes it Fails.
		// All Warapepr Class have an inbuilt method .equals()method,
		// Use above function we can compare 2 value of wrapper Classes.
		// eg-1:
		boolean check=q1.equals(q2);
		System.out.println(check);
		// eg-2:
		Integer w1=123;
		Integer w2=123;
		boolean check1=w1.equals(w2);
		System.out.println(check1);
		// Note : if(w1==w2)-->Used for Primitive Datatypes Only not for Wrapper Classes.
		
	}



	private static boolean isPalindrome(String s5, int s, int e) 
	{
		 int n=s5.length();
		 while(s<e)
		 {
			 if(s5.charAt(s)==s5.charAt(e))
			 {
				 s++;
				 e--;
			 }
			 else
			 {
				 return false;
			 }
		 }
		 return true;
	}



	private static int SumOfNumbers(String s4) 		// Char Number ==>int

	{												// char ch='1';

													// int d=ch; -->char->int

													// print(d);//49//ASCII Value of 1

													// d=d-48//49-48=1;

		 int ans=0,num=0;

		 int n=s4.length();

		 for(int i=0;i<n;i++)

		 {

			 char ch=s4.charAt(i);

			 if(ch>=48 && ch<=57)// ch is Numeric Character

			 {

				 int d=ch-48;

				 num=num*10+d;

			 }

			 else// End of Number

			 {

				 ans=ans+num;

				 num=0;

			 }

		 }

		 // At the end we might have num : Add to it final Ans.
		 System.out.println(num);
		 ans=ans+num;

		 

		 return ans;

	}



	private static int LongestWord(String s3) 

	{

		 int ans=0,l=0;

		 int n=s3.length();

		 for(int i=0;i<n;i++)

		 {

			 if(s3.charAt(i)==' ')// End of Word & it's Length is in=l;

			 {

				 if(ans<l)

				 {

					 ans=l;// Out of word lengths need Max.

				 }

				 l=0;// Going to new Word

			 }

			 else

			 {

				 l++;// In Same word

			 }

		 }

		 // Once Loop end Indicate Words End :For Last Word Update ans;

		 if(ans<l)

		 {

			 ans=l;

		 }

		 return ans;

	}



	private static String ReplaceChar(String s2, char c) 

	{

		 StringBuilder sb=new StringBuilder();

		 int n=s2.length();

		 for(int i=0;i<n;i++)

		 {

			  if(c==s2.charAt(i))

			  {

				  sb=sb.append("@");

			  }

			  else

			  {

				  sb=sb.append(s2.charAt(i));

			  }

		 }

		 return sb.toString();

	}



	private static String LowerCase(String s1) 

	{

		 StringBuilder sb=new StringBuilder();

		 for(int i=1;i<s1.length();i++)

		 {

			 char c=s1.charAt(i);

			 if(c>='a'&&c<='z')

			 {

				 sb.append(c);

			 }

		 }

		 return sb.toString();

	}



}

