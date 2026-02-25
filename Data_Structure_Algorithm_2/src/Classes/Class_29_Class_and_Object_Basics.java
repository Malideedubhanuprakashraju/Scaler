package Classes;


class Node
{
	int data;
	Node next;
	
	Node(int x)
	{
		this.data=x;
		this.next=null;
	}
}
public class Class_29_Class_and_Object_Basics 
{

	public static void main(String[] args) 
	{
		/* Class : It is a Blue Print
		 * 
		 * Object : Real Instance of Class : Blue Print
		 * 
		 * 
		 * Note : A Single Class can have Multiple Objects.
		 * 
		 * 		 --------> Attributes / Variables : Information That we want to Store
		 * Class |
		 * 		 --------> Functions / Methods : Actions that we want to perform
		 * 
		 * class Car
		 * {
		 * 	
		 * 	Inf : Attributes
		 * 
		 * 		 Color :
		 * 		 Model :
		 * 		 Price :
		 * 
		 *  Functions : Created in Class
		 *  
		 *  	Break()
		 *  	Accelerate()
		 *  	Ac()
		 *  
		 *  }
		 *  
		 * Object 
		 * -------
		 * Car 	 : Vivek 
		 * 
		 * Color : Black
		 * Model : BMW
		 * Price : 25l
		 * 
		 * Object 
		 * -------
		 * Car	 : Himanshu
		 * 
		 * Color : white
		 * Model : Audi
		 * Price : 50l
		 * 
		 * 
		 * Functions : Functions created in Class & Shared across All Objects 
		 * 
		 * 
		 * Note :
		 * 
		 * Class can have only Attributes
		 * 
		 * Class can have only Functions
		 * 
		 * Class can have only Functions & Attributes
		 * 
		 * 
		 * Note :
		 * 			int		float	String
		 * 
		 * Default	 0		 0.0f	 " "
		 * 
		 * 
		 * Class Creation
		 * --------------
		 * 
		 * class Student
		 * {
		 * 	// Attributes = info
		 *  
		 *  int roollNo;
		 *  
		 *  String name ="john"
		 *  
		 * }
		 * 
		 * 
		 * Object Creation
		 * ---------------
		 * 
		 * ClassName obj = new ClassName();
		 * 
		 * Object Reference : Stores Address of That Class Object.
		 * 
		 * Eg :
		 * 
		 * Student s1 = new Student();
		 *   
		 */
		
		/* Main()
		 * {
		 * 		Student s1 = new Student();
		 * 		Print(s1);
		 * 		
		 * 		s1.rollNo = 10;
		 * 		s1.name	= "syed";
		 * 
		 * 		Student s2 = new Student();
		 * 
		 * 		s2.rollNo = 20;
		 * 		s2.name = "Kavya";
		 * 
		 * 	    // Multiple Object Reference 
		 * 
		 * 		Student s3=s2;
		 * 		Print(s3.rollNo);
		 * 		s3=s1;
		 * 		s3.rollNo=50;
		 * 
		 * 		// Null as Reference
		 * 
		 * 		Student s4 = null; // No Address
		 * 		Print(s4); // Null
		 * 		Print(s4.rollNo); // Null.rollNo => Asking Roll No from Null Address
		 * 
		 * 		Note : When we want data at Null 
		 * 		Error : Null Pointer Exception
		 * 
		 * 		Note : To Use Any Attributes or Methods . operator is Must.
		 * 
		 * 		Note : We can initialize Attribute with default values at class Creation 
		 * 			   Every Time Object Created it will initialized with Default Values.
		 *  
		 */
		
		/* Class : Attributes
		 * ------------------
		 * 
		 * Class Student
		 * {
		 * 	 // Attributes -----> Class Variables => Once Created in Class, They can be used Anyware in Class
		 * 	
		 * 		String name;
		 * 	    int rollNo;
		 * 		int age;	
		 * 
		 *   // Methods/Functions
		 *   
		 *   	Void inf( )
		 *   	{
		 *   		print(name);
		 *   		print(rollNo);
		 *   		print(age);
		 *      }
		 *      
		 * }
		 * 
		 * Student s1=new Student();
		 * 
		 * s1.name="Bhanu";
		 * s1.rollNo=24;
		 * s1.age=40;
		 * 
		 * Student s2=new Student();
		 * 
		 * s2.name="Raju";
		 * s2.rolllNo=28;
		 * s2.age=50;
		 * 
		 * s1.info();
		 * s2.info();
		 * 
		 * Student s3=null;
		 * s3.info();// Error;
		 *  
		 */
		
		/* Constructor
		 * -----------
		 * 
		 * It is used to initialize Attribute of a Class, Only at the Time of Object Creation.
		 * 
		 * Rules :
		 * 
		 * a) Constructor name should be same as Class Name.
		 * 
		 * b) It is similar to Function but no Return Type.
		 * 
		 * c) Constructor invoked at the Time of Object Creation.
		 * 
		 * d) When we call Constructor --> Object Created
		 * 							   --> Initialized
		 * 
		 * e) If Class has no Constructor :
		 * 								  ----> Java will include a Default Constructor
		 * 								  ----> It will have no Arguments & Body.
		 * 
		 * f) If we Create a Constructor, Java Won't Add Default Constructor.
		 * 
		 * g) We can only invoke Constructors which are Present
		 * 
		 * h) We can have Multiple Constructors, but Java Should be able to Differentiate Them.
		 * 
		 * 	  a) No : of Parameters
		 * 
		 * 	  b) Data Types of Parameters.
		 *  
		 */
		
		/* Class Pair
		 * {
		 * 		int a,b;
		 * 
		 * 		Pair(int p1,int p2)
		 * 		{
		 * 			a=p1;
		 * 			b=p2;
		 * 		}
		 * }
		 * 
		 * main()
		 * {
		 * 		Pair t1=new Pair(10,20);
		 * 		
		 * 		// Steps :
		 * 				  1) Object Created
		 * 
		 * 				  2) Constructor Initializes Attributes
		 * 
		 * 				  3) Address is Stored in t1
		 * 
		 * 		Pair t2=new Pair(30);
		 * 
		 * 		Note : We Cannot call Constructor which doesn't Exist.
		 * 
		 * 
		 */
		
		/* Linked List Basics
		 * 
		 * Class Node
		 * {
		 * 		int data; // Variable used for Data Storage
		 * 		
		 * 		Node next; // Object Reference : Can Store Address Value of Node Object
		 * 
		 * 		Node(int x)
		 * 		{
		 * 			data = x;
		 * 
		 * 			next = null; // We can initilaize it with Null
		 * 		}
		 * }
		 * 
		 * Void Main()
		 * {
		 * 		Node h = new Node(10);
		 * 
		 * 		Node t = h;
		 * 
		 * 		print(t.data);
		 * 
		 * 		t.next = new Node(20);
		 * 		t = t.next;
		 * 
		 * 		t.next = new Node(30);
		 * 		t = t.next;
		 * 
		 * 		t.next = new Node(40);
		 * 		t = t.next;
		 * 
		 * 	    Observation : Address of 1^st Object : ad1--> We can access entire Linked List.
		 * }
		 * 
		 * Note : In Linked List Questions, we are given a Linked List at Start Itself.
		 * 
		 * Note : If we Loose Head Node Address, we can no Longer Access Linked List hence use Temp & upadte them.
		 *  
		 */
		
		// Q1) Given a Head Node of a Linked List, Return Size of it.
		
		Node h=new Node(10);
		Node t=h;
		
		t.next=new Node(20);
		t=t.next;
		
		t.next=new Node(30);
		t=t.next;
		
		t.next=new Node(40);
		t=t.next;
		
		int ans=Size(h);
		System.out.println(" Size of Linked List : "+ans);
		
	}

	private static int Size(Node h) // T.C = O(N)
	{								// S.C = O(1)
		Node t=h;
		
		int c=0;
		
		while(t!=null)
		{
			c++;
			t=t.next;
		}
		return c;
	}
	

}
