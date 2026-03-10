package Stacks;

import java.util.Stack;

class Arrays
{
	int ar[]=new int[10];
	int top=-1;
	void push(int x)
	{
		if(top==ar.length-1)
		{
			return;
		}
		ar[++top]=x;
	}
	void pop()
	{
		if(top==-1)
		{
			return;
		}
		top=top-1;
	}
	
	int size()
	{
		return top+1;
	}
	int peek()
	{
		if(top==-1)
		{
			return 0;
		}
		return ar[top];
	}
}

public class Class_31_Stacks_1 
{

	public static void main(String[] args) 
	{
		 // Stack
		/*	  |
		 * 	  -----> Stack is a Data Structure where Insert &  Delete happens on Same Side
		 * 
		 * Property : LIFO : Last in First Out (Stacks)
		 * 			
		 * 			  FILO : First in Last Out (Stacks)
		 * 
		 * Use Case :
		 * 
		 * 1) Recursion
		 * 
		 * 2) Undo/Redo
		 * 
		 * 3) Arithmetic Expression
		 * 
		 * Functions :
		 * ----------
		 * 
		 * 1) push(X) : Insert X on Top of Stack
		 * 
		 * 2) pop()	  : Delete Top most Element
		 * 
		 * 3) peek()  : Return Top Element
		 * 
		 * 4) size()  : Return no:of Elements in Stack
		 * 
		 * Note : Whenever we use Array Stack we can only use Above 4-Functions
		 * 
		 * Note : Only Element we can Access in Stack is Top-Most Element
		 * 
		 * Note : Both Push & Pop happens from Same Side
		 * 
		 * Note : In Stack --> A Single Function : O(1)
		 * 
		 * 
		 * Stack Implementation :
		 * ---------------------
		 * 
		 * 1) Using Arrays
		 * 
		 * 2) Using LinkedList
		 * 
		 * 3) Inbuilt Stack Library
		 * 
		 *  	
		 */
		 Arrays a=new Arrays();
		 a.push(10);
		 a.push(20);
		 a.push(30);
		 a.push(40);
		 a.push(50);
		 System.out.println(a.size());
		 System.out.println(a.peek());
		 a.pop();
		 System.out.println(a.peek());
		 
		 // Inbuilt Library Functions --> Stacks
		 
		 Stack<Integer> st=new Stack<>();
		 st.push(10);
		 st.push(20);
		 st.push(30);
		 st.push(40);
		 st.push(50);
		 st.push(60);
		 System.out.println(st);
		 System.out.println(st.peek());
		 System.out.println(st.pop());
		 System.out.println(st.size());
		
		 
		 // Q1) Check if a Given Sequence of Parenthesis is Balanced or Not ?
		 
		 // Type of Brackets : { } , [ ] , ( )
		 
		 /* Balanced Parenthesis :
		  * 		 			   A Sequence is Balanced, if for every opening, there is a closing bracket and they have to be correctly Matched.
		  * 
		  * Eg : ( ( { } ) ) : Yes
		  * 
		  * Eg : { { } ) : No
		  * 
		  * 
		  * Idea : Which ever Bracket opened Last, That i need to close First.
		  * 
		  * Observation : LIFO = Stack Data Structure
		  * 
		  * Note : 
		  * 
		  * 1) If Closing Bracket not Matching with Top Bracket : Not Balanced
		  * 
		  * 2) For a Closing Bracket :
		  *    						 If Stack Empty : Not Balanced
		  *    
		  * 3) After a Complete Iteration :
		  * 						 Stack Not Empty : Not Balanced
		  * 
		  * 4) Only if it satisfies all Cases : Balanced
		  * 									
		  *  
		  */
		 boolean ans=isBalanced("{[()]}");
		 System.out.println("isBalanced :"+ans);
		 
		 // Q2) Double Character Trouble
		 /*
		  * Given a String S, Remove Equal Pair of Adjacent Characters 
		  * 
		  * Return the String without Adjacent Duplicates
		  * 
		  * Eg-1 : 
		  * 				  Output
		  * a	b	b	d ---->	ad
		  * 
		  * Eg-2 :
		  * 
		  * a	b	a	b	a	b ----> ababab
		  * 
		  * 
		  * Obser-1 : Curr is Matching with Last Ele : Pop()
		  * 
		  * Obser-2 : Insert Back, Deleting : Use Stack
		  * 
		  * 
		  * Idea-1 :
		  * 
		  * Steps :
		  * 
		  * 1) If Stack is Empty : Push
		  * 
		  * 2) If st.peek() != ch : Push
		  * 
		  * 3) If st.peek() == ch : Pop
		  * 
		  * Final : Create the STring by Popping Elements from Stack
		  * 
		  * Ans = dea ==> Expected Ans = ade
		  * 
		  * Note : Traverse Right to Left to get Correct Ans.
		  *  
		  */
		 String s="abbd";
		 String ans1=characterD(s);
		 
		 /* Expression Evaluation
		  * 
		  * 1) In General Expressions we write are infix
		  * 
		  * Our Infix Expressions are Converted to Postfix & Evaluated Postfix
		  * 
		  * Infix Expression : Operators between Operands
		  * 
		  * Postfix Expression : Operators after Operands
		  * 
		  * 
		  * Eg-1 :
		  * 
		  * Infix Expression		Postfix Expression
		  * 
		  * 	a + b						ab +
		  * 
		  * 	a - b						ab -
		  * 
		  * 	a+(b*c)						a + bc*	--> abc*+
		  *  
		  */
		 
		 /* Given a Postfix Expression, Evaluate Expression & Return Final Ans
		  * 
		  * Eg : 4 3 3 * + 2 -
		  * 
		  * 
		  * Step-1 : Iterate on Expression
		  * 
		  * 1) If it's Operand :
		  * 					Insert in Stack
		  * 
		  * 2) If it's Operator :
		  * 					Pop 2-Elements & insert Their Result in Stack.
		  * 
		  * 3) Return top of Stack
		  * 
		  */
		 
		 /* Evaluating Postfix :
		  * 
		  * 1) We need a Stack
		  * 
		  * 2) Iterate on Postfix Expression
		  * 
		  * 	a) Operand ==> Push in to Stack
		  * 
		  * 	b) Operator ch ==> Get Top Ele in Stack = b & Pop it
		  * 				   ==> Get Top Ele in Stack = a & Pop it
		  * 				   ==> Perform a ch b & insert in Stack
		  * 3) Return Top of Stack
		  * 
		  */
		 
		 String ar[]= {"50","200","*","3","-"}; // Input is Array of Strings.
		 
		 int ans2=EvaluateExp(ar);
		 System.out.println("PostFix : "+ans2);
		 
		 /* Given Infix ---> Postfix
		  * 
		  * a) Take a Stack<Character>
		  * 
		  * b) Iterate on Infix
		  * 
		  * 
		  * 1) Operand -----> Add to Postfix
		  * 
		  * 2) Open Bracket ----> Add to Stack
		  *    ==(
		  * 3) Closed Bracket ----> Pop from Stack & Add them Postfix till you get an Open Bracket :( Delete it,Don't add in Postfix )
		  *    ==)
		  * 4) Operator ch ----> If Stack is Empty : push ch
		  *    == +,-,*,/		 If Top of Stack is ( : push ch
		  * 					 while(stack.size()>0 && pre(ch) <= pre(stack.peek())
		  * 					 {
		  * 						Pop() & Add it into Postfix
		  * 					 }
		  * 					 Add ch to Stack
		  * 
		  * Note : Higher Precedence will be on top than Lower Precedence
		  * 
		  * 					 Pop & Add in Postfix till Stack is Empty
		  * 
		  * 						
		  */
	}

	private static int EvaluateExp(String[] ar)// T.C = O(N)
	{										   // S.C = O(N)
		 Stack<Integer> st=new Stack<>();
		 
		 int n=ar.length;
		 
		 for(int i=0;i<n;i++)
		 {
			 String s=ar[i];
			 
			 if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
			 {														// |---> For Comparing Two Strings == : Not Performed
				 int b=st.peek();									// |---> Use .equals(); => For Comparing Two Strings
				 st.pop();
				 int a=st.peek();
				 st.pop();
				 
				 if(s.equals("+"))
				 {
					 st.push(a+b);
				 }
				 else if(s.equals("-"))
				 {
					 st.push(a-b);
				 }
				 else if(s.equals("*"))
				 {
					 st.push(a*b);
				 }
				 else
				 {
					 st.push(a/b);
				 }
			 }
			 else// It is a number
			 {
				 st.push(Integer.parseInt(ar[i]));// Int Value in String Format
			 }
		 }
		 return st.peek();
	}

	private static String characterD(String s) // T.C = O(N)
	{										   // S.C = O(N)
		 Stack<Character> st=new Stack<>();
		 
		 int n=s.length();
		 
		 for(int i=n-1;i>=0;i--)
		 {
			 char ch=s.charAt(i);
			 
			 if(st.size()==0)
			 {
				 st.push(ch);
			 }
			 else if(st.peek()!=ch)
			 {
				 st.push(ch);
			 }
			 else
			 {
				 st.pop();
			 }
		 }
		 
		 // Final Step : Get Each char from Stack & Append Them
		 
		 StringBuilder sb=new StringBuilder();
		 while(st.size()>0)
		 {
			 char c=st.peek();
			 st.pop();
			 sb.append(c);
		 }
		 return sb.toString(); // String Builder ---> String & Return
		 
		 // Note : In String Builder Append Back : O(1)
		 
		 // Note : In String Append at Back : O(N)
		 
	}

	private static boolean isBalanced(String s) 
	{
		 Stack<Character> st=new Stack<>();
		 int n=s.length();
		 
		 for(int i=0;i<n;i++)
		 {
			 char ch=s.charAt(i);
			 
			 if(ch=='{' || ch=='(' || ch=='[')
			 {
				 st.push(ch);
			 }
			 else
			 {
				 if(st.size()==0)
				 {
					 return false;
				 }
				 
				 if(ch==')' && st.peek()=='(')
				 {
					 st.pop();
				 }
				 else if(ch=='}' && st.peek()=='{')
				 {
					 st.pop();
				 }
				 else if(ch==']' && st.peek()=='[')
				 {
					 st.pop();
				 }
				 else
				 {
					 return false;
				 }
			 }
		 }
		 if(st.size()==0)
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	}

}
