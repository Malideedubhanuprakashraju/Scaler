package Bit_Manipulations_Basics;

public class Class_10_Bit_Manipulations 
{

	public static void main(String[] args) 
	{ 
		/* Decimal Number System
		 * 			|
		 * 			---> Each Digit : [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
		 * 			---> Each Power : [10]
		 * --> Base 10.
		 * 
		 * 
		 * 10^n	.	.	.	10^4	10^3	10^2	10^1	10^0
		 * 
		 * eg:1								  3		  4		  2		= 3*100 + 4*10 + 2*1 = 342
		 * 
		 * eg:2				      	  2		  5		  6		  3		= 2*1000 + 5*100 + 6*10 +3*1 = 2,563
		 *  
		 */
		
		/* Binary Number System
		 * 			|
		 * 			----> Each Digit : [ 0, 1]
		 * 			----> Each Power : [2]
		 * --> Base 2.
		 * 
		 * 2^n	.	.	.	2^5	2^4	2^3	2^2	2^1	2^0
		 * 
		 * eg:1				 1	 0	 0	 1	 0	 1		= 2^5*1 + 2^2*1 + 2^0*1	= 32 + 4 + 1 = 37
		 * 
		 * eg:2					 1	 0	 0	 1	 1		= 2^4*1	+ 2^1*1 + 2^0*1 = 16 + 2 + 1 = 19
		 * 
		 *  
		 */
		
		/* Decimal to Binary Conversion : Keep Dividing Number/2 till quotient reaches 0 & Consider all remainders from Bottom to Top.
		 * 				
		 * eg : 2|37|-1	^
		 * 		 ----	|
		 * 		2|18|-0	|
		 * 		 ----	|
		 * 		2|09|-1	|						
		 * 		 ----	|
		 * 		2|04|-0	|
		 * 		 ----	|
		 * 		2|02|-0	|
		 * 		 ----	|
		 * 		2|01|-1	|
		 * 		 ----	|
		 * 		 |0		|
		 * 		 ------>|
		 * 
		 * 	   2^5 2^4 2^3 2^2 2^1 2^0
		 * 37 : 1	0	0	1	0	1  = 32 + 4 + 1= 37
		 *  
		 */
		
		/* Add-2 Decimal Numbers : d=s%10,	c=s/10,	/10--> Decimal Number System
		 * 
		 * eg :
		 * 		13/10	11/10=1
		 *  C=	1		1	
		 * 9/10 7		8		  9
		 * 	0	1		4		  2
		 * --------------------------
		 * s=	9%10   13%10	  11%10
		 * d= 0	 9		  3			1			
		 *  
		 */
		
		/* Add-2 Binary Numbers : d=s%2, c=s/2,	/2--> Binary Number System
		 * 
		 * eg :
		 * 		1/2		3/2	    2/2		1/10
		 * C =	0		1		1		0
		 * 	1/2	1		0		1		1	 0 -->22
		 * 	0	0		0		1		1	 1 --> 7
		 * -----------------------------------	   |	
		 * 	|	1%2		1%2		3%2		2%2	 1%2   |
		 * 	0	 1		 1		 1		 0	 1	   29
		 *  
		 */
		
		/* Bitwise Operations : { AND, OR, XOR, Inverse, leftshift, rightshift}
		 * 								 ------> Same Same Puppy Shame :0
		 * 								 |
		 * 				AND		OR		XOR		INV
		 * 		A	B	A&B		A|B		A^B		~A 
		 * 		0	0	 0		 0		 0		 1
		 * 		0	1	 0		 1		 1		 1
		 * 		1	0	 0		 1		 1		 0
		 * 		1	1	 1		 1		 0		 0
		 * 
		 * Note : Binary -----> Decimal Conersions are internally done by the System.
		 * 
		 * Note : In Bitwise operators, Calculations are done bit by bit.
		 * 
		 * eg : A=29, B=19
		 * 
		 * 		   2^4	2^3	2^2	2^1	2^0	
		 * 		a :	1	 1	 1	 0	 1
		 * 								} System Convert	=	Decimal
		 * 		b : 1	 0	 0	 1	 1
		 * --------------------------------
		 * pr(a&b): 1	 0	 0	 0	 1--------------------->= 17
		 * pr(a/b):	1	 1	 1	 1	 1--------------------->= 31
		 * pr(a^b):	0	 1	 1	 1	 0--------------------->= 14
		 * 													------		
		 * 													  62
		 * 													------
		 * 
		 */
		/* Binary Representation of Negative Numbers.
		 * 
		 * 8 bit : 2^7		2^6		 2^5	2^4		2^3		2^2		2^1		2^0
		 * 			|
		 * 			-> Left Most Bit : MSB(Most Significant Bit)
		 * 			
		 * 		   2^7 >2^6+2^5+2^4+2^3+2^2+2^1+2^0	=	128 > 127
		 * 
		 * MSB : Most Significant Bit : Value of MSB position is -ve
		 * 
		 * -a = ~a+1 : Inverse a + 1, Internally in the system'
		 * 
		 * G.P :	2^0 + 2^1 + 2^2 +	.	.	.+2^N-1 = 2^N-1
		 * 
		 * 			Sum of Terms in G.P = a*{r^T-1}/r-1 ; a:1stTerm, r:common ratio, t:terms
		 * 		
		 * 			a=2^0,	r=2,	t=N------> 1*{2^N-1}/1 = 2^N-1
		 * 
		 */
		
		/* Range of DataTypes :
		 * 
		 * 8-bit :
		 * 
		 * -2^7	  2^6	2^5		2^4		2^3		2^2		2^1		2^0
		 *   1	   0	 0		 0		 0		 0		 0		 0  : Min= -2^7= -128
		 *   																			} Byte Range
		 *   0	   1	 1		 1		 1		 1		 1		 1	: Max=	2^7-1= 127
		 * 
		 * 16-bit :
		 * 
		 * Min : -2^15 = -32768 
		 * 						} Short
		 * Max : 2^15-1=  32767
		 * 
		 * 32-bit :
		 * 
		 * Min : -2^31= -2*10^9
		 * 						} Int range
		 * Max :  2^31-1= 2*10^9
		 * 
		 * 
		 * 64-bit :
		 * 
		 * Min : -2^63=	-8*10^18
		 * 						 } Long Range
		 * Max :  2^63-1= 8*10^18
		 * 
		 */
		
		/* Approximations :
		 * 
		 * 
		 * 2^10	= 1024 ~~ 1000= 10^3
		 * 
		 * 2^10 ~~ 10^3
		 * 
		 * 
		 * Case-1 : 2^10 ~~ 10^3
		 * 			Cube on Both Sides
		 * 			(2^10)^3 ~~ (10^3)^3
		 * 			
		 * 			 2^30	~~	10^9 {Multiply with 2 on Both Sides}
		 * 			 2*2^30 ~~  2*10^9
		 * 			 2^31 ~~ 2*10^9
		 * 
		 * Case-2 : 2^31 ~~ 2*10^9
		 * 			Square on Both Sides
		 * 
		 * 			(2^31)^2 ~~ (2*10^9)^2
		 * 			2^62	~~	4*10^18 {Multiply with 2 on Both Sides}
		 * 			2*2^62	~~ 2*4*10^18
		 * 			2^63	~~ 8*10^18
		 * 
		 * Q) Given Array[N] elements, Calculate Sum & Return it.
		 * 
		 * 1<= N <= 10^5
		 * 					} MaxSum : ar[10^5] = {10^9+10^9+10^9+......+10^9}
		 * 1<= ar[i] <= 10^9		   	
		 * 							   SumRange =[ 10^9 * 10^5 ] = 10^14
		 * 							   We need Long Data Type
		 * 
		 * Idea : 
		 * 		 *(int) long sum=0;
		 * 				for(int i=0;i<n;i++)
		 * 				{
		 * 					sum=sum+ar[i];
		 * 				}
		 * 				Print(sum);
		 * 
		 * Note : Based on Question, Calculate Range of Variables & Based on That we will get data type of Variables.
		 * 
		 */
	}

}
