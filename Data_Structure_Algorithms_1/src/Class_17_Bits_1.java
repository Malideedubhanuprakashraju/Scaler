
public class Class_17_Bits_1 
{

	public static void main(String[] args) 
	{
		/* Bitwise Operations : { AND, OR, XOR, Inverse, LeftShift, RightShift}
		 * 		 |
		 * 		 -----> Operations happen bit by bit.
		 * 
		 * 	A	B	A&B		A|B		A^B		~A
		 *  
		 *  0	0	 0		 0		 0		 1
		 * 	0	1	 0		 1		 1		 1
		 *  1	0	 0		 1		 1		 0
		 *  1	1	 1		 1		 0		 0
		 * 							 |
		 * 							 -----> Same Same : Puppy Shame =0
		 * 
		 * Eg : A=10 :	1	0	1	0
		 * 		B=14 :  1	1	1	0
		 * -----------------------------
		 * Print(A&B) :	1	0	1	0	= 10
		 * 
		 * Print(A|B) : 1	1	1	0	= 14
		 * 
		 * Print(A^B) : 0	1	1	0	=  4	
		 * 
		 * 
		 * Note : Decimal--> Binary : System will Take Care.
		 * 
		 * Bitwise Properties :
		 * 
		 * ===> Even Case :
		 * 
		 *  1) A = 10 :	1	0	1	0
		 * 		   1 :	0	0	0	1
		 * ---------------------------
		 *  A & 1	 :  0	0	0	0 = 0{val}
		 *  
		 *  2) A = 14 : 1	1	1	0
		 *  		1 : 0	0	0	1
		 *  --------------------------
		 *  A & 1	 :  0	0	0	0 = 0{val}
		 *  
		 *  ===> Odd Case :
		 *  
		 *  3) A = 11 : 1	0	1	1
		 *  	    1 : 0	0	0	1
		 *  --------------------------
		 *   A & 1	  : 0	0	0	1 = 1{val}
		 *   
		 *  4) A = 13 :	1	1	0	1
		 * 			1 : 0	0	0	1
		 *  --------------------------
		 *   A & 1	  : 0	0	0	1 = 1{val}
		 *   
		 *   					 ----> 0 : A is even.{If 0^th Bit in A is 0}
		 *   					 |
		 *  Observation :  A & 1 =  
		 *   					 |
		 *   					 ----> 1 : A is odd.{If 0^th Bit in A is 1}
		 *   
		 * For More Interesting Properties 
		 * 
		 * A) A & 1-----> 0 : A is even
		 * 		|
		 * 		--------> 1 : A is odd
		 * 
		 * B) A & 0-----> A : 1	 0	1	1
		 * 				  0 : 0	 0	0	0
		 * 				 -----------------
		 * 			  A & 0	: 0	 0	0	0 = 0{val}
		 * 
		 * C) A & A-----> A : 1	 0	1	1
		 * 				  A : 1	 0	1	1
		 * 				 -----------------
		 * 			  A & A : 1  0	1   1 = A{val}
		 * 
		 * D) A | A-----> A : 1  0	1	1
		 * 				  A : 1	 0	1	1
		 * 				 -----------------
		 * 			  A | A : 1	 0	1	1 = A{val}
		 * 
		 * E) A | 0-----> A : 1	 0	1	1
		 * 				  0 : 0	 0	0	0
		 * 				 -----------------
		 * 			  A | 0 : 1	 0	1	1 = A{val}
		 * 
		 * 
		 * F) A ^ A-----> A : 1  0	1	1
		 * 				  A : 1	 0	1	1
		 * 				 -----------------
		 * 			  A ^ A : 0	 0	0	0 = 0{val}
		 * 
		 * G) A ^ 0-----> A : 1	 0	1	1
		 * 				  0	: 0	 0	0	0
		 * 				 -----------------
		 * 			  A ^ 0 : 1	 0	1	1 = A{val}
		 * 
		 * Note : When we perform A^0 value will be A.
		 *  
		 */
		
		/* Property :
		 * 
		 * 1) A & B = B & A : Same
		 * 2) A | B = B | A : Same } Commutative Property
		 * 3) A ^ B = B ^ A : Same
		 * 
		 * [A]&[B&C] = [B&C]&[A] = [C&B]&[A] = C&A&B =B&A&C
		 * 
		 * [A^B^C] = B ^ C ^ A = C ^ A ^ B = B ^ A ^ C......
		 * 													 } Associative
		 * [A|B|C] = B | C | A = C | A | B = B | A | C......
		 * 
		 * Note : Order Doesn't Matter
		 * 
		 */
		
		/* XOR Calculations
		 * ----------------
		 * 
		 * 1) a^b^a^d^b = a^a^b^b^d = Ans = 0
		 * 				   0->b->0->d : d
		 * 
		 * 2) 1^3^5^3^2^1^5 = 1^1^3^3^5^5^2 = Ans = 2
		 * 	  -->->->->->->
		 * 				  1 : 0	 0	1
		 * 				  3 : 0	 1  1
		 * 				 -------------
		 * 			    1^3 : 0	 1	0
		 * 				  5 : 1  0  1
		 * 				--------------
		 * 			  1^3^5 : 1	 1	1
		 * 				  3 : 0	 1	1
		 * 			  ----------------
		 * 			1^3^5^3 : 1	 0	0
		 * 		  		  2 : 0  1  0
		 * 		  --------------------
		 * 		  1^3^5^3^2 : 1	 1	0
		 * 				  1 : 0	 0	1
		 * 		 ---------------------
		 * 		 1^3^5^3^2^1: 1	 1	1
		 * 				   5: 1  0	1
		 * 		----------------------
		 * 	   1^3^5^3^2^1^5: 0	 1	0 = 2{val}
		 * 
		 */
		
		// Q1) Given Array Every Element Repeats Twice Except 1, Return Unique Element.
		
		int ar[]= {1,3,5,3,2,1,5};
		int ans=unique(ar);	
		System.out.println(ans);
		
		/* LeftShift << ->It will move bit's to Left Side.
		 * 
		 * Say a is 8-bit number ? At MAx it can store '8'bits.
		 * 
		 * MSB :      -2^7		2^6		2^5		2^4		2^3		2^2		2^1		2^0
		 *  
		 * a = 10 :		0		 0		 0		 0		 1		 0       1		 0		= 10 -----> 2^0*10------>2^0*a
		 * 
		 * a<<1	  :  0	0		 0		 0		 1		 0		 1		 0		 0<-   	= 20 -----> 2^1*10------>2^1*a         
		 * a<<2   :  0	0		 0		 1		 0		 1		 0	     0		 0<-	= 40 -----> 2^2*10------>2^2*a
		 * a<<3   :  0	0		 1		 0		 1		 0		 0		 0		 0<-    = 80 -----> 2^3*10------>2^3*a
		 * a<<4   :  0	1		 0       1		 0		 0		 0		 0		 0<-	= -96-----> -2^7+2^5=-128+32=-96 != 2^4*10=160  
		 * a<<5	  : 1(*)0		 1		 0		 0		 0		 0		 0		 0<-    = Overflow : we are exceeding limit
		 * 																				  We looose data.
		 * 
		 * Observation : a<<n = 2^n * a : If No OverFlows 
		 * 				 |  |
		 * 				 1<<n = 2^n * a : 2^N
		 * 				 1<<3 = 2^3 * 1 : 2^3 = 8
		 * 				 5<<3 = 2^3 * 5 : 2^3*5= 40
		 * 				
		 * 
		 * Note : While doing << because of overflows.
		 * 		
		 */
		
		/* RightShift >> It will move bit's to Right Side.
		 *  
		 * Say a is 8-bit number ? At Max it can store '8'bits
		 * 
		 * LSB :		-2^7	2^6		2^5		2^4		2^3		2^2		2^1		2^0
		 * 
		 * a=20 :		  0		 0		 0		 1		 0		 1		 0		 0		: 20 --------> 20/2^0 = a/2^0
		 * 
		 * a>>1 :		->0		 0		 0		 0		 1		 0		 1		 0		: 10 --------> 20/2^1 = a/2^1
		 * a>>2 :		->0		 0		 0		 0       0		 1		 0		 1      :  5 --------> 20/2^2 = a/2^2
		 * a>>3 :		->0		 0		 0		 0		 0		 0		 1		 0		:  2 --------> 20/2^3 = a/2^3
		 * a>>4 :		->0		 0		 0		 0		 0		 0		 0		 1		:  1 --------> 20/2^4 = a/2^4
		 * a>>5 :		->0		 0		 0		 0		 0		 0		 0		 0		:  0 --------> 20/2^5 = a/2^5 = 0
		 * 
		 * 
		 * Observation : a >> n = a/2^N
		 * 
		 * Note : If we keep doing  >> a will become 0
		 *  
		 */
		
		/* Power of LeftShift : Set : 1, Unset:0
		 * 
		 * 	  1 : 0	 0	0	0	0	0	0	1
		 * 
		 * 1<<2 : 0	 0	0	0	0	1	0	0  = 2^2 = 4
		 * 1<<3 : 0  0  0   0   1   0   0	0  = 2^3 = 8
		 * 
		 * 
		 * << with OR 
		 * 
		 * 	ODD :	N=45 :  0	0	1	0	1|	1	0	1
		 * 			1<<2 :  0	0	0	0	0|	1	0	0
		 * 									 |
		 * 	 N | (1<<2)	 :  0	0	1	0	1|	1	0	1	= 45
		 * 
		 * ODD :	N=41 :	0	0	1	0	1|	0	0	1
		 * 			1<<2 :  0	0	0	0	0|	1	0	0
		 * 									 |
		 *   N | (1<<2)	 :  0	0	1	0	1|	1	0	1	= 45
		 *   
		 * Even :   N=42 :	0	0	1	0	1	0	1	0
		 * 			1<<3 :	0	0	0	0	1	0	0	0
		 * 
		 * 	 N | (1<<3)	 :  0	0	1	0	1	0	1	0	= 42
		 * 
		 * Even :	N=34 :	0	0	1	0	0	0	1	0
		 * 			1<<3 :	0	0	0	0	1	0	0	0
		 * 
		 * 	 N | (1<<3)	 : 	0	0	1	0	1	0	1	0	= 42
		 * 
		 * 
		 * Observation : N | (1<<i) : At i^th : If it's already set remains set
		 * 									  : If it's unset it become set.
		 * 
		 * Conclusion : Given N,i : Make i^th Bit of N as Set, If already  Set, Leave it.
		 * 
		 * Set i^th Bit
		 * 
		 * N = N | (1<<i) : i^th bit in N will become 1.
		 * 	   | |
		 * 	   |  --------> If it's already 1, it will remain 1.
		 * 	   |		
		 * 	   -----------> After performing operations Re-Initialize to N.
		 */
		
		/* << with XOR
		 * 
		 * Observation : N = N ^ (1<<i) : If i^th bit in N is Set, It will Unset.
		 * 						|		  If i^th bit in N is Unset, It will Set.
		 * 						|
		 * 						|
		 * 					 N^ith bit 1
		 * 					 In i^th bit of N,Flip bit.
		 * 	Toggle i^th Bit
		 */
		
		// Q3) Given N & i, check if i^th bit in N is Set=1 or Not=0 ?
		/* Eg : 
		 * 			2^5	2^4	2^3	2^2	2^1	2^0	 
		 * N = 21	0	1	0	1	0	1
		 * i = 2				|
		 * 						----> Return True.
		 * 
		 * Idea-1 :
		 * 
		 * 										i
		 * 1)	N=45	1	0	1	0	1	1 	0	: N&1==1 : Set else Unset
		 * 		  1		0	0	0	0	0	1
		 * 
		 * 										i							
		 * 2)	N=45	1	0	1	0	1	1	1	: (N>>1)&1 == 1 : Set else Unset
		 * 		N>>1	0	1	0	1	0	1	
		 * 										i
		 * 3)	N=45	1	0	1	0	1	1	2	: (N>>2)&1 == 1 : Set else Unset
		 * 		N>>2	0	0	1	0	1	0
		 *	
		 */
		boolean ans2=CheckBit(45,2);
		System.out.println("Check Bit is :"+ans2);
		
		// Q4) Given N, return count of set bit's in N.
		
		// eg : N=21 => 0	1	0	1	0	1 =>Return 3
		// Idea-1 : For Every bit in N : 
		//							   Check if it's Set or Not.
				
		int ans3=CountSetBits(21);
		System.out.println("Set Bits Count "+ans3);
		
		// Idea-2 : Shift N>>1 & check 0^th bit is Set or Not.
		
		int ans4=CountSetBitsOpti(21);
		System.out.println(ans4);
		
		// Q4) Given N & i, Unset i^th Bit of Number N, if it's a Set.
		
		int ans5=UnsetBit(21,2);
		System.out.println(ans5);
		
		/* Set Bit's in range :
		 * 
		 * Set i^th Bit[OR] , UnSet i^th Bit[XOR]
		 * 
		 * Given B, C Create a Binary Numbers with B 1's & C 0's & Return Decimal.
		 * 
		 * Eg :	B	C	
		 * 		3	2	:	0	1	1	1	0	0	= 2^4+2^3+2^2 = 28
		 * 		4	2	:	1	1	1	1	0	0	= 2^5+2^4+2^2 = 60
		 * 
		 * Idea :
		 * 
		 * Say B=5, C=?
		 * 
		 * Ele = 1	1	1	1	1 = 2^0+2^1+2^2+2^3+2^4 = 2^5-1 =31
		 * 
		 * Observation-1 : Say B 1's
		 * 				   Ele = 2^b-1 
		 * 
		 * Observation-2 : Say B 1's & C 1's
		 * 				   Ele = B 1's => Need to Add C's at Back so perform leftshift C time
		 * Ele = Ele << C:
		 * 
		 * Final Obs :
		 * 			 Given B,C;
		 * 			 Ele = 2^b-1
		 * 			 Ele = (1<<b)-1;
		 * 			 Ele = Ele << c
		 * 			 Ele = {(1<<b)-1} << C;
		 * 
		 * Output : print(((1<<b)-1)<<C);
		 * 
		 */
		
	}

	private static int UnsetBit(int N, int i) 
	{
		if((N>>i&1)==1)// i^th bit in N is Set.
		{
			N=N^(1<<i);// Flip i^th Bit
		}
		return N; 
	}

	private static int CountSetBitsOpti(int N) // T.C = O(log^N)
	{										   // S.C = O(1)
		int c=0;
		while(N>0)
		{
			if((N&1)==1)
			{
				c++;
			}
			N=N>>1;// N=N/2 { After update equate to N }
		}
		return c;
	}

	private static int CountSetBits(int N) // T.C = O(1)
	{									   // S.C = O(1)
		 int c=0;
		 
		 for(int i=0;i<=31;i++)
		 {
			 if(((N>>i)&1)==1)
			 {
				 c++;
			 }
		 }
		 return c;
	}

	private static boolean CheckBit(int N, int i) 
	{
		 if((N>>i&1)==1)
		 {
			 return true; //i^th bit is Set
		 }
		 else
		 {
			 return false; //i^th bit is Unset
		 }
		 
		 // return (N>>i)&1 == 1
	}

	private static int unique(int[] ar) // T.C = O(N)
	{									// S.C = O(1)
		int n=ar.length;
		int ans=0;// A^0 =A----> 0 won't effect XOR
		for(int i=0;i<n;i++)
		{
			 ans=ans^ar[i];
		}
		return ans;
	}

}
