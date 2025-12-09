package C11_Patterns_1;

import java.util.Scanner;

public class Class_11 
{

	public static void main(String[] args) 
	{
	 //Code 1:
		//Given a +ve Number N and a Single digit number d,Attach d to the Back of N
		//eg : 135, 6=1356(O/P)
		//Explanation = Idea : Add d to back of N=N*10+d;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a N value :");
		int n=sc.nextInt();
		System.out.println("Enter d value :");
		int d=sc.nextInt();
		AttachBack(n,d);
	//Code 2:
		//Given a Number N, Store it's Reverse in another variable & Print it
		//eg : 135=531;
		//Approach:
		//Repeat N>0
		//1. int d=N%10;--Getting Last Digit of N
		//2. rev=rev*10+d;--Attach d to back of Rev
		//3. N=N/10;--Remove Last digit from N
		Reverse(n);
	//Code 3:
		//Given a Number,check if it's Palindrome or Not.
		//eg :121==>Palindrome
		//Explanation : Given N, Calculate rev & compare Them
		//if same :Palindrome, else:Not Palindrome
		Palindrome(n);
		
	//Code 4:
		//Given T numbers, for every number Print if it's palindrome or Not
		for(int i=121;i<=140;i++)
		{
			
			System.out.print(i+" The iTh No is");
			Palindrome(i);
		}
		
	//Code 5:
		//Read a +ve N, Print if it's amstrong or not
		//A number is Amstrong if sum of cubes of each digit==N
		//eg : 153= 1^3+5^3+3^3= 153==>Amstrong
		
		int n1=153;
		Amstrong(n1);
		
	//Code 6:
		//Given N,Print All Amstrong Numbers from 1...N
		int n2=1350;
		Amstro(n2);
		
		
		
		
		
	}

	private static void Amstro(int n2) 
	{
		 
		 for(int i=1;i<=n2;i++)
		 {
			 int n=i;
			 int sum=0,copy=n;
			 while(n>0)
			 {
				 int d=n%10;
				 sum=sum+d*d*d;
				 n=n/10;
			 }
			 if(copy==sum)
			 {
				 System.out.println(copy);
			 }
			 
		 }
	}

	private static void Amstrong(int n1) 
	{
		 int sum=0,copy=n1;
		 while(n1>0)
		 {
			 int d=n1%10;
			 sum=sum+d*d*d;
			 n1=n1/10;
		 }
		 if(copy==sum)
		 {
			 System.out.println("Amstrong ");
		 }
		 else
		 {
			 System.out.println("Not Amstrong");
		 }
	}

	private static void Palindrome(int n) 
	{
		int copy=n,rev=0;
		if(n<0)
		{
			n=n*-1;
		}
		while(n>0)
		{
			int d=n%10;
			rev=rev*10+d;
			n=n/10;
		}
		if(copy<0)
		{
			rev=rev*-1;
		}
		if(rev==copy)
		{
			System.out.println(" Palindrome");
		}
		else
		{
			System.out.println(" Not Palindrome");
		}
	}

	private static void Reverse(int n) 
	{
		int rev=0,copy=n;
		 if(n<0)
		 {
			 n=n*-1;
		 }
		 while(n>0)
		 {
			 int d=n%10;
			 rev=rev*10+d;
			 n=n/10;
		 }
		 if(copy<0)
		 {
			 rev=rev*-1;
		 }
		 System.out.println("Reverse of N is :"+rev);
	}

	private static void AttachBack(int n, int d) 
	{
		 int ans=n*10+d;
		 System.out.println(ans);
	}

}
