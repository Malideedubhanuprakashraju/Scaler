package IntroductionToProgram2;

import java.util.ArrayList;
import java.util.Scanner;

public class Strings_1 
{

	public static void main(String[] args) 
	{
		String str="World@123";
		// Anything in " " is Considered as String
		System.out.println(str);
		
		/* String : Sequence of Characters
		 * 
		 * Character : Anything as a Single Symbol--> A single Symbol in ' '--> For Character
		 * 
		 * A) Alphabets : 1) 'A'-'Z'
		 * 				  2) 'a'-'z'	
		 * 
		 * B) Numbers   : 1) '0'-'9'
		 * 
		 * C) Special Characters : 1) '@', '#', '%', '&'.......
		 * 						   2) '+', '-'.......
		 * 
		 * 
		 * Character : Syntax :
		 * 					  char x='A';
		 					  Sysout(x); // A
		 					  
		 * 					  char y='AB';
		 * 					  Sysout(y);// Error : Only Single SYmbol is a Character
		 * 
		 * How Char is Stored ?
		 * 
		 * Java--> Compiler--> Computer
		 * 1) Number--> x=7;//{Decimal Number ->Binary System}
		 * 2) Text--> y="ab";//{Mapped Each Character-> Number -> Binary}
		 * 
		 * ASCII : American Standard Code for Information Exchange
		 * |
		 * -->Every Character is associated with an Integer Value
		 * 'A': 65			'a':97			'0':48
		 * 'B': 66			'b':98			'1':49
		 * 'C': 67			'c':99			'2':50
		 *  .				 .				 .
		 *  .				 .				 .
		 *  .				 .				 .
		 *  .				 .				 .
		 *  .				 .				 .
		 *  .				 .				 .
		 * 'Z': 90			'z':122			'9':57
		 * 
		 * ASCII Table : Total 128 Chars, Mapped With 0 to 127{0:127}=128(Number) as ASCII Codes
		 *
		 * Operation on Characters :
		 * 
		 * String --> Sequence of Characters
		 * 
		 * Access Any Character : stringName.charAt(index)
		 * 
		 */
		String s="Scaler";
		System.out.println(s);
		System.out.println(s.charAt(2));//a
		
		/* Total Length : name.length();
		 * |						  |-->No Parameters 	
		 * -->It will return no : of characters in a String
		 *
		 */
		System.out.println("Length :"+s.length());
		
		/* Inbuilt Function
		 * 
		 * 1) Substring : Continous Part of String is Considered as SubString
		 * Note : A single length & complete length are also substrings
		 * eg:
		 * 
		 * String str="God";
		 * Substring : G{0}
		 * 			   GO{0,1}
		 * 			   GOD{0,1,2}
		 * 
		 * 			   O{1}
		 * 			   OD{1,2}
		 * 
		 * 			   D{2}
		 * 
		 * 	More Inbuilt String Functions :
		 *  sName.substring(int i);// Parameter:INT
		 *  Returns a Substring from start index i to end of String
		 */		   
		 String txt="Helloyo";
		 String eg=txt.substring(2);
		 System.out.println(eg);//lloyo
		 
		 /*	substring(int i,int j);// Parameter:INT,INT
		  * Returns a substring from index[i,j)->j-Excluded.
		  */
		 String ex1=txt.substring(2, 6);
		 System.out.println(ex1);
		 
		 /* indexOf(char c);
		  * |
		  * --> Used to Search for char or substring within a String
		  * More Inbuilt String Functions :
		  * 
		  * sName.indexOf(char ch);
		  * Returns The FirstOccurence index of char ch in String
		  * 
		  */
		 String ex2="Helloworld!";
		 int i=ex2.indexOf('o');
		 System.out.println(i);//4
		 
		 /* indexOf(char ch,int i)
		  * Returns The FirstOccurence of char in String, Starting from i
		 */
		 int i1=ex2.indexOf('o',5);
		 System.out.println(i1);//6
		 
		 /* indexOf(String S)
		  * Returns The FirstOccurence of SubString S : in String
		  * 
		  */
		 int i2=ex2.indexOf("lo");
		 System.out.println(i2);//3
		 
		 /* indexOf(String s, int i)
		  * Returns The FirstOccurence of SubString S : in String, Starting from i
		  */
		 String ex3="HelloChalo";
		 int i3=ex3.indexOf("lo",5);
		 System.out.println(i3);//8
		 
		 /* Iteration on String :
		  * String str="AbCA";
		  * Return Sum of ASCII Value of Each Character
		  * eg: 65+98+67+65= 295
		  * 
		  * Approach :
		  * Iterate on each character & get it's ASCII value & Add
		  * 
		  * sum=0;
		  * String atr="AbCA";
		  * sum=sum+atr.charAt(0);
		  * sum=sum+atr.charAt(1);
		  * sum=sum+atr.charAt(2);
		  * sum=sum+atr.charAt(3);
		  * 
		  * Generalize :
		  * If a String Length is N, Last index is N-1
		  * 
		  */
		 String atr="AbCA";
		 int ans=ascii(atr);
		 System.out.println(ans);
		 
		 
		 /* Concatenation:
		  * Adding Strings
		  * String+ Char-->String
		  * char-->String : Implicit
		  * String-->int : Explicit
		  */
		 String s1="Hello";
		 String s2=s1+"Everyone";
		 System.out.println(s2);
		 
		 /* String Input
		  * 1) Scanner sc=new Scanner(System.in);
		  * 
		  * a) next()
		  * 
		  * Takes Input Untill Space is Encountered or End of Line
		  * Input : "Hello World"
		  * String s1=sc.next();
		  * sysout(s1);//Hello
		  * String s2=sc.next();
		  * sysout(s2);//World
		  * 
		  * b) nextLine();
		  * 
		  * Takes Input Untill next line is encountered
		  * String s2=sc.nextLine();
		  * Input : "Hello World"
		  * sysout(s2);//Hello World
		  * 
		  * Special Rule :{nextLine()}
		  * 1) When each input is given in a separate lines, and we take a String input using nextLine(), after taking a number on single word
		  * we get empty line in String.
		  * eg:
		  * 
		  */
		 System.out.println("Enter n Value ");
		 Scanner sr=new Scanner(System.in);
		 int x=sr.nextInt();
		 String r1=sr.nextLine();
		 String r2=sr.nextLine();
		 System.out.println(r1);
		 System.out.println(r2);
		 
		/* Extract Numbers
		 * Str="ab123ac4523eg970";
		 * num=0->1+2+3+4+5+2+3+9+7+0
		 * ans=ans+num
		 * 
		 * Explanation :
		 * ch		  d		d
		 * 0 		48-48=	0
		 * 1		49-48=	1
		 * 2		50-48=	2
		 * .		.
		 * .		.
		 * .		.
		 * .		.
		 * 9		57-48= 9
		 * 
		 */
		 String n="ab120cd3e45";

		 long anss= extractNumber(n);
		 System.out.println(anss);
		 
		 /* 2D-ArrayList
		  * 
		  * 
		  */
		 ArrayList<Integer> ar=new ArrayList<>();
		 ar.add(10);
		 ar.add(20);
		 ar.add(30);
		 ar.add(20);
		 ar.get(1);
		 System.out.println(ar);
		 
		 
		 
		 
		/*Class Room  */ 
		// import java.util.*;
		// class Main {
		 	// Create a funciton which takes input as array and print it. 


		 	//public static void main(String args[]) {
		 		// 
		     /*
		 			Ascii characters
		 			'A' 65		+32-	'a'	97		'0'	48
		 			'B' 66		+32-	'b'	98		'1'	49	
		 			'C'	67		+32-	'c'	99		'2'	50
		 			.
		 			.
		 			'Z'	90		+32-	'z'	122		'9'	57					
		 		*/	
		         
		     /* Char Rules : 
		       char {1B} and int {4B}

		 			1.  Char{samll} to Int{large} implicit type casting, We wil get Ascii value of that character
		 			2.  Int{larger} to Char{small} possible data loss : Ideally never work.
		                 a. At time it stores without typecasting
		                 b. At times we will get error without typecasting
		                 c. So good pratice is when we store int to char always explicitly typecast.
		             3.  char 1Byte and int 4B
		                 [char] int , int is bigger
		             4.  We will take ascii value of character when we perform any operators on character with numbers  
		 		*/
		         
		         
		             /*
		                 char ch1 = 'A';
		                 System.out.println(ch1);  // Output : A
		             */
		             
		             /*
		                 int v = 'A'; // char --> int : Implicit : 65 --> int
		                 System.out.println(v);
		             */    
		             
		             /* 
		                 char ch2 = 65; // int --> char : Not work
		 			          System.out.println(ch2);  // Works in this case 
		                 // int --> char : Explivit TypeCasting
		             */    
		             
		             
		             
		             /*
		                 int a = 'A';  //a=65 char --> int impltii
		                 a = a+2; // a= 67
		                 System.out.println(a); // 67
		                 
		                 int b = 'a'; //b = 97 char --> int implicit
		                 b = b+2; // b = 99
		                 System.out.println(b);  // 99  
		             */    
		 			      
		             
		             
		               /*
		                 char ch4 = ('A' + 2); //char('A' --> 65) + int(2) --> int(67) --> char{C}
		 				        System.out.println(ch4); 
		                 // Idealy it should not work without typecasting in the above it workls.
		               */
		  
		               /*
		                 char ch4 = 'A'; 
		                 ch4 = (ch4+2); //char('A'-->65) + int(2) --> int(67) --> char{}
		                 System.out.println(ch4);
		                 // In this case int--> char fails.
		               */

		               // Conclustion : Always explicitly typecast from int --> char
		                
		               
		             
		             /* 
		                 char ch5 = 'A';
		                 ch5 = (char)(ch5 + 32); 
		                 System.out.println(ch5); 
		             */  
		                 
		                
		                      
		               
		             /*            
		                 char ch7 = 'B'; 
		                 if(ch7 >= 90){ // character on operations, it uses its ascii
		                     System.out.println("Greater ch7");
		                 }
		                 else{
		                     System.out.println("Its lesser");
		                 }
		                 // Output : Its lesser
		             */
		             /*
		                 char ch8 = 'a';
		                 if(ch8 >= 90){ 
		                     System.out.println("Greater ch8");
		                 }
		                 else{
		                     System.out.println("Its lesser");
		                 }
		                 // Output : Greater ch8
		             */

		             /*
		               char ch = (char)('A' + 1000);
		               System.out.println("Valus is : "+ch);
		             */
		         /*  
		           Note 
		             :Issue with nextLine occurs if before we are reading other 
		             inputs using next()/number and inputs are given newlines
		         */

		       /*     
		         Scanner sc = new Scanner(System.in);
		         int a = sc.nextInt();
		         String s1 = sc.nextLine();
		         String s2 = sc.nextLine();
		         System.out.println("Number "+a);
		         System.out.println("Text1 "+s1);
		         System.out.println("Text2 "+s2);
		       */

		       /*
		         Scanner scn = new Scanner(System.in);
		         int x = scn.nextInt();
		         String str = scn.nextLine();
		         System.out.println(x);
		         System.out.println(str);   
		       */

		       /*
		         Scanner scn = new Scanner(System.in);
		         int x = scn.nextInt();
		         String str = scn.nextLine();
		         System.out.println(x);
		         System.out.println(str);
		         System.out.println("The End");
		       */

		       /*
		         Scanner sc = new Scanner(System.in);
		                                 //  0
		         String str = sc.next(); // "a"
		         System.out.println("String "+str);
		         System.out.println("length "+str.length());
		         System.out.println("Char 0th index "+str.charAt(0));
		       */


		       // There is no separate functoin to read a char 
		       /*
		         Steps: 
		         1. Read the String 
		         2. Extraxct the 0th index from string 
		         3. Store it in the char 
		       */
		       // Reading Characters 
		       /*
		          In 2 lines
		          Scanner sc = new Scanner(System.in);
		                                  //  0
		          String str = sc.next(); // "a"
		          char ch = str.charAt(0); // Return char at 0th index : return 'a'
		       */

		       /*
		          In 1 line
		          Scanner sc = new Scanner(System.in);
		                                  //  0
		          char ch = sc.next().charAt(0); // 
		          //char ch = "b".charAt(0); = {'b'}
		          char ch = str.charAt(0); // Return char at 0th index : return 'a'
		       */

		       //   System.out.println((int)ch);

		       
		 				
		 	//}
		 //}
		 
		 
		 
		 
		 
		 
		
	}

	private static long extractNumber(String s) 
	{
		 long ans=0,num=0;
		 int n=s.length();
		 for(int i=0;i<n;i++)
		 {
			 char ch=s.charAt(i);
			 if(ch>=48 && ch<=57)
			 {
				 char ch1=s.charAt(i);
				 int d=ch1;
				 d=d-48;
				 num=num*10+d;
			 }
			 else
			 {
				 ans=ans+num;
				 num=0;
			 }
		 }
		 ans=ans+num;
		 
		 return ans;
	}

	private static int ascii(String atr) 
	{
		 int n=atr.length();
		 int sum=0;
		 for(int i=0;i<n;i++)
		 {
			 sum=sum+atr.charAt(i);
		 }
		 return sum;
	}

}
