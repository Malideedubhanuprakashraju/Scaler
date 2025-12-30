package DSA_1;

public class Class_7_Memory_Management 
{

	public static void main(String[] args) 
	{ 
		/* Stack Data Structure :
		 * 						 DataStructure where both insert & delete from Top.
		 * We can only Access top Element.
		 * 
		 * eg:
		 * 
		 * |Insert Top:	 |
		 * |Delete Top:	 |
		 * |	3:----	 |
		 * |	2:----	 |
		 * |	1:---- 	 |
		 * ---------------
		 * 
		 * Function Calls:
		 * 
		 * 1) When we call a function, it is inserted at top of Stack.
		 * 2) When function call execution is completed, it will be removed from Stack.
		 * 										  |
		 * 										  -----> a) Execute Return Statement or	
		 * 										  -----> b) Execute Last Line of Function.
		 * 
		 * Note : Once Function call is completed all memory allocated to it in Stack will be Erased.
		 * 
		 */
		
		/* Memory Management in Java.
		 * 
		 * Stack : All primitive data types & reference variable & function calls are Stored in Stack.
		 * 					|								|
		 * 					----> int/long/float/double	    ----> Variable which Stores Address.
		 * Note : All Variable Rules Applied to reference variables as well.
		 * 
		 * Heap : Container of that reference variable present in Heap.
		 * 
		 * eg : Array/ArrayList/Object Stored in Heap
		 * 
		 * eg : public static void main()			Stack			|		Heap
		 * 		{									main:			|			  0 1 2
		 * 			int x=10;						x:10			|			 -------
		 * 			int ar[]=new int[3];			ar=ad1--------------->	#ad1 |0|0|0|
		 * 			println(ar);												 -------
		 * 			println(ar[2]);
		 *  	}
		 *  
		 */
		
		/* Difference Between .equals() and == in Java
		 * 
		 * ==
		 * 1) Used to Comapre primitives or check two references point to the same Object.
		 * 2) For primitive data types, it compares the Values.
		 * 	  For object references, it compares the reference locations(Memory Addresses).
		 * 3) For Objects, Checks reference equality.
		 * 	  For primitives, checks value equality.
		 * 4) We can't override == is an operator and it's behavior cannot be changed.
		 * 5) Primitive Comparison Applicable and compares values directly.
		 * 6) Object Comparison checks if two reference variables point to the same object instance.
		 * 
		 * .equals()
		 * 1) Used to compare the content or state of two objects.
		 * 2) Compares the values stored in two objects, based on the implementation of the .equals()method in the object's class.
		 * 3) In the Object Class,it behaves the same as ==,checking reference equality.
		 * 	  However, it is often overridden in child classes to check content equality.
		 * 4) Overridable Yes, Classes can override the .equals()method to define their own criteria for equality.
		 * 5) Primitive Comparison Not Applicable directly to primitives.
		 * 	  Primitives must be wrapped as objects(Integer,Character)to use .equals().
		 * 6) Object Comparison checks if the contents of two objects are logically equivalent,depending on the implementation of .equals().
		 * 
		 */
		
		/* What is .equals() in Java?
		 * 
		 * The .equals() method in Java is used to compare two objects for equality based on the data or content of the objects rather than their reference identities.
		 * By default,the .equals()method in the Object class compares the memory addresses or references of the objects, essentially checking if the two references point to the same object in memory.
		 * However,the .equals() method is often overridden in user-defined classes to perform a content-based comparison,checking if the data within two objects is the same.
		 * 
		 */
	}

}
