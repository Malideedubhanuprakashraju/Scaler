package Array_1D;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Array_3D 
{

	public static void main(String[] args) 
	{
		// Q) Given 2 Numbers a & b, Swap Their Values
		// eg: a=3, b=7
		//	   After Swapping
		//	   a=7, b=3
		int a=3,b=7;
		System.out.println("A-Value "+a+" B-Value "+b);
		swap(a,b);
		System.out.println("A-Value "+a+" B-Value "+b);
		
		// Q) Given an Array[N], Reverse Entire Array
		int ar[]= {10,20,30,40,50};
		for(int x:ar)
		{
			System.out.print(x+" ");
		}
		reverse(ar);
		System.out.println();
		System.out.println("After Reversing Array");
		for(int x:ar)
		{
			System.out.print(x+" ");
		}
		
		//Drawbacks of an Array:
		// 1) Once Created Size is Fixed
		// 2) We can't increase size Automatically
		
		// To Overcome These Problem New Concept Introduced
		// Called ArrayList
		
		// ArrayList : It is a Dynamic Array, Similar to an Ordinary Array. But added Benefit of being able to resize as elements are added or removed.
		// Note :
		// ArrayList : Java8(oracle-jdk-1.8)
		// Arrays : Java8(ArraySupport)
		// Syntax :
		//		  ArrayList<DataType> Name=new ArrayList<DataType>();
		
		// DataType is Type of the elements, that will be Stored
		// int, DataType= Integer
		// float, DataType=Float
		// long, DataType=Long
		// char, DataType=Character
		
		ArrayList<Integer> al=new ArrayList<>();
		
		// Inbuilt_Functions
		// 1) add(element)
		//Adding an Element to end of ArrayList.
		
		al.add(30);
		al.add(40);
		al.add(10);
		al.add(60);
		System.out.println();
		System.out.println(al);
		
		// 2) size()
		//It Will Return Total No.of Elements
		int n=al.size();
		System.out.println(n);
		
		// 3) get(index)
		//It returns ith index element of arrayList
		int ele=al.get(2);
		System.out.println(ele);
		System.out.println(al.get(1));
		
		// 4) set(index,value)
		//Update value to a particular index
		al.set(2, 5);
		al.set(3,70);
		System.out.println(al);
		
		// 5) remove(index)
		//Remove Element at That index & remaining Element come forward
		al.remove(1);
		System.out.println(al);
		
		// 6) Collections.sort(ArrayList)
		//It will sort Array List in increasing Order
		Collections.sort(al);
		System.out.println(al);
		
		
		// Q) Write a Function, Which takes ArrayList & Print Each Element
		printArrayList(al);
		
		ArrayList<Integer> arr=new ArrayList<>();
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(40);
		arr.add(50);
		System.out.println(arr);
		
		ArrayList<Integer> ans=IncresingByOne(arr);
		System.out.println(ans);
		
		ArrayList<Integer> arr1=new ArrayList<>();
		arr1.add(10);
		arr1.add(15);
		arr1.add(20);
		arr1.add(23);
		arr1.add(30);
		arr1.add(41);
		System.out.println(arr1);
		// Write a Function, which Takes ArrayList as input and Create & Return Another arrayList With All Even Numbers.
		ArrayList<Integer> ans1=EvenNo(arr1);
		System.out.println(ans1);
		
		// Q) Given an ArrayList, Return all Unique Elements
		// Unique: An Element with Occ=1, is said to be Unique
		
		ArrayList<Integer> arr2=new ArrayList<>();
		arr2.add(6);
		arr2.add(10);
		arr2.add(8);
		arr2.add(2);
		arr2.add(8);
		arr2.add(10);
		arr2.add(11);
		System.out.println(arr2);
		ArrayList<Integer> ans2=uniqueEle(arr2);
		System.out.println(ans2);
		
		// Q) Given an Array[N], Return ArrayList of Elements Where Each Element has atleast 1 Element Greater Than itself.
		// Ar[]={1,3,10,6,3,2,10,9};
		// Ans={1,3,6,3,2,9};
		
		// Idea-1: Otheer Than Max Ele, All other Elements Will Atleast have 1 Element greater Than itself
		
		int arr4[]= {2,3,10,7,3,2,10,8,6};
		ArrayList<Integer> arr3=CountGreater(arr4);
		System.out.println(arr3);
		
	
		
		
	}

	private static ArrayList<Integer> CountGreater(int[] ar) 
	{
		 int n=ar.length;
		 int max=Integer.MIN_VALUE;
		 for(int i=0;i<n;i++)
		 {
			 if(ar[i]>max)
			 {
				max=ar[i]; 
			 }
		 }
		 //System.out.println("Max"+ max);
		 ArrayList<Integer> ans=new ArrayList<>();
		 for(int i=0;i<n;i++)
		 {
			 if(max>ar[i])
			 {
				 ans.add(ar[i]);
			 }
		 }
		 return ans;
	}

	private static ArrayList<Integer> uniqueEle(ArrayList<Integer> arr2) 
	{ 
		ArrayList<Integer> ans=new ArrayList<>();
		int n=arr2.size();
		for(int i=0;i<n;i++)
		{
			int temp=arr2.get(i);
			int c=0;
			for(int j=0;j<n;j++)
			{
				if(arr2.get(j)==temp)
				{
					c++;
				}
			}
			if(c==1)
			{
				ans.add(arr2.get(i));
			}
		}
		return ans;
	}

	private static ArrayList<Integer> EvenNo(ArrayList<Integer> arr) 
	{ 
		ArrayList<Integer> ans=new ArrayList<>();
		int n=arr.size();
		
		for(int i=0;i<n;i++)
		{
			if(arr.get(i)%2==0)
			{
				ans.add(arr.get(i));
			}
		}
		
		return ans;
	}

	private static ArrayList<Integer> IncresingByOne(ArrayList<Integer> a) 
	{
		 int n=a.size();
		 for(int i=0;i<n;i++)
		 {
			 int x=a.get(i);
			 a.set(i,x+1);
		 }
		 return a;
	}

	private static void printArrayList(ArrayList<Integer> al)
	{ 
		int n=al.size();
		for(int i=0;i<n;i++)
		{
			System.out.println(al.get(i));
		}
	}

	private static void reverse(int[] ar) 
	{
		 int p1=0,p2=ar.length-1;
		 while(p1<p2)
		 {
			 int t=ar[p1];
			 ar[p1]=ar[p2];
			 ar[p2]=t;
			 p1++;
			 p2--;
		 }
	}

	private static void swap(int a, int b) 
	{ 
		int temp=a;
		a=b;
		b=temp;
		System.out.println("After Swapping ");
		System.out.println("A-Value "+a+" B-Value "+b);
	}

}
