package Stringss;

public class Class_11_Strings 
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
		 * 'A': 65 <--32-->	'a':97			'0':48
		 * 'B': 66 <--32--> 'b':98			'1':49
		 * 'C': 67 <--32-->	'c':99			'2':50
		 *  .				 .				 .
		 *  .				 .				 .
		 *  .				 .				 .
		 *  .				 .				 .
		 *  .				 .				 .
		 *  .				 .				 .
		 * 'Z': 90			'z':122			'9':57
		 * 
		 * ASCII Table : Total 128 Chars, Mapped With 0 to 127{0:127}=128(Number) as ASCII Codes.
		 * 
		 * Note : 1^st Char----> 0
		 * 		  128^th Char--> 127
		 * 
		 * Small in Bigger ---> Implicit
		 * Big in Small ------> Explicit
		 * 
		 * Note :
		 * 
		 * 1) char ---> int ;// 1B--->4B// Implict TypeCasting
		 * 
		 * eg: int x='a';// 97 ASCII value of a
		 * 	   print(x);// 97
		 * 
		 * eg: print('a'+2);// Char with arthmetic operators, char ASCII considered
		 * 			 char int---> Resultant is of int Data Type.
		 * 
		 * 2) int ---> char	;// 4B--->1B// Explicit TypeCasting
		 * 
		 * int x=97;
		 * char ch=(char)x;
		 * print(ch);//a
		 * 
		 */
		// Q) Given a String Convert All Uppper Case --> Lower Case & Return a String
		// Note : String Contains only Capital or Small.
		// eg : S = "Hello" ---> "hELLO";
		String s="AnaCon";
		String ans=Toggle(s);
		System.out.println(ans);
		
		// Way-1 : String is Immutable, We Cannot Modify
		
		// Way-2 : Every Time we Append a Char String a new String is Created.
		//		   A Single Append Takes : { Create a Copy of Original & Add to New };
		
		// Way-3 : Optimize
		//		   Whenever we have Modify Char.
		//		   String ---> char[] ---> Modify ---> String
		String ans1=Toggle1(s);
		System.out.println("Optimized Toggele using char Array : "+ans1);
		
		/* String Builder :
		 * 				   If we have to dynamically add characters.
		 * In sb, adding a Single Char = O(1)
		 * 
		 * Dynamic Array Implementation
		 * 
		 * String Builder sb=new StringBuilder();
		 * 
		 * for(int i=0;i<n;i++)
		 * {
		 * 		sb.append(char);// It will append char at Back; T.C= O(1)
		 * }
		 * return sb.toString();// It will convert StringBuilder to String & we can return.
		 * 
		 */
		// Way-4 : Using String Builder 
		String ans2=Toggle2(s);
		System.out.println("Using StringBuilder : "+ans2);
		
		/* SubString : The Concept of Subarray on String is Considered as SubString.
		 * 
		 * a) Continuous part of a String --> { Strat & end }
		 * b) Full String is a Substring.
		 * c) Single Character is also a Substring
		 * 
		 * eg :
		 * 
		 * s = " b x c d ";
		 * 
		 * s[0 0]= b;		s[1 1]= x;	  s[2 2]= c		s[3 3]= d
		 * s[0 1]= bx;		s[1 2]= xc;	  s[2 3]= cd
		 * s[0 2]= bxc;		s[1 3]= xcd;
		 * s[0 3]= bxcd;
		 *  
		 */
		
		/* Palindrome : { L-->R == R-->L}
		 * 
		 * eg : a) madam, b) malayalam
		 *  
		 */
		// Q) Check if a given substring is Palindrome or Not with given s & e ?
		String s1="anamadamspe";
		boolean ans3=isPal(s1,3,7);
		System.out.println("Is Palindrome : "+ans3);
		
		// Q) Given a String, return Length of Longest Palindromic Substring.
		// Constraints : 1<=N<=10^3
		// eg : s= a b a c a b ans=5
		//			 ---------
		//eg : s= a n b c ans=1 //Single Character is Substring & Palindrome
		
		// Idea-1 : For Every String , check if Palindrome or Not.
		
		// If Palindrome : Compare length & get Overall Max.
		
		String s2="feacabacabgf";
		int ans4=palindrome1(s2);
		System.out.println("Palindrome-1 : "+ans4);
		
		/* Optimize :
		 * 		 0	1	2	3	4	5	6	7	8	9	10	11	12	13	14	15
		 * str = x	b	d	y	z	z	y	d	e	b	d	y	z	y	d	x
		 * 				p1<-p1<-p1	p2->p2->p2->p2		p1<-p1<-p1p2-p2->p2->p2
		 * 
		 * Obs : SubString[p1+1 p2-1]				Obs : SubString[p1+1 p2-1]	
		 * len : p2-p1-1							len : p2-p1-1//Both Exclude
		 * 
		 * Idea :
		 * 
		 * 1) Odd Length Palindromes
		 * 	  |
		 * 	  ----> Take Every Character as Centre and expand on centre & get length of palindrome  & get Overall Max.			
		 * 
		 * 2) Even Length Palindromes
		 * 	  |
		 * 	  ----> Take Every Adajacent Character as Centre and Expand on Centres & get Length of Palindrome & get Overall Max
		 * 
		 * 3) Final Ans=Max(EvenPalindromeLength, OddPalindromeLength);
		 * 
		 * Note : To Expand at a Centre it take : O(N/2)
		 * 		  We do above proceess for odd centres & even centres
		 * T.C = O(2N * N/2)=O(N^2)
		 * S.C = O(1)
		 * 
		 */
		int ans5=palindrome2(s2);
		System.out.println("Optimized palindrome code : "+ans5);
	}
	
	private static int palindrome2(String s2) // T.C=O(2N*N/2)=O(N^2)
	{										  // S.C=O(1)
		int n=s2.length();
		int ans=0;
		
		// Step-1 : take Every Char as Centre & expand
		for(int i=0;i<n;i++)
		{
			//Expand at i^th char
			int p1=i,p2=i;
			while(p1>=0 && p2<n)
			{
				if(s2.charAt(p1)==s2.charAt(p2))
				{
					p1--;
					p2++;
				}
				else
				{
					break;
				}
			}
			ans=Math.max(ans, p2-p1-1);
		}
		
		// Step-2 : Take Every Adjacent Pair as Centre
		for(int i=0;i<n;i++)
		{
			//Expand at i^th char & i+1 char
			int p1=i,p2=i+1;
			while(p1>=0 && p2<n)
			{
				if(s2.charAt(p1)==s2.charAt(p2))
				{
					p1--;
					p2++;
				}
				else
				{
					break;
				}
			}
			ans=Math.max(ans, p2-p1-1);
		}
		return ans;
	}

	private static int palindrome1(String s2) // T.C = O(N^2*N)
	{										  // S.C = O(1)
		 int n=s2.length();
		 int ans=0;
		 for(int s=0;s<n;s++)
		 {
			 for(int e=s;e<n;e++)
			 {
				 //From [s...e]check palindrome or not ?
				 if(isPal(s2,s,e))
				 {
					 //[s..e]--> Len= e-s+1
					 ans=Math.max(ans, e-s+1);// Current ans compare to e-s+1 & get Max.
				 }
			 }
		 }
		 return ans;
	}

	private static boolean isPal(String st, int s, int e) // T.C = O(N/2)-->O(N)
	{													  // S.C = O(1)
		 int p1=s,p2=e;
		 
		 while(p1<p2)
		 {
			 if(st.charAt(p1)==st.charAt(p2))
			 {
				 p1++;
				 p2--;
			 }
			 else
			 {
				 return false;
			 }
		 }
		 return true;
	}

	private static String Toggle2(String s) // T.C = O(N)
	{										// S.C = O(N)
		 StringBuilder sb=new StringBuilder();
		 int n=s.length();
		 
		 for(int i=0;i<n;i++)
		 {
			 char ch=s.charAt(i);
			 if(ch>=65 && ch<=90)
			 {
				 ch=(char)(ch+32);
			 }
			 else
			 {
				 ch=(char)(ch-32);
			 }
			 sb.append(ch);
		 }
		 
		 return sb.toString();
	}

	private static String Toggle1(String s) // T.C = O(N+N+N) = O(N), S.C= O(N)
	{
		 char ch[]=s.toCharArray();// It will return a char[] with S-Data.
		 int n=s.length();
		 
		 for(int i=0;i<n;i++)
		 {
			 
			if(ch[i]>=65 && ch[i]<=90)
			{
				ch[i]=(char)(ch[i]+32);
			}
			else
			{
				ch[i]=(char)(ch[i]-32);
			}
		 }
		 return new String(ch);// With Given Char[] we will create a new String & return it.
	}

	private static String Toggle(String s) // T.C= O(N*N)= O(N^2)
	{
		int n=s.length();
		String ans=""; //Empty String
		
		for(int i=0;i<n;i++)
		{
			char ch=s.charAt(i);
			if(ch>=65 && ch<=90)
			{
				ch=(char)(ch+32);
			}
			else
			{
				ch=(char)(ch-32);
			}
			ans=ans+ch;
		}
	  return ans;	
	}

}
