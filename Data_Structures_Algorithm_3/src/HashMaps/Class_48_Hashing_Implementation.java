package HashMaps;

import java.util.HashMap;

public class Class_48_Hashing_Implementation {

	public static void main(String[] args) 
	{
		 HashMap<Integer,Integer> hm=new HashMap<>();
		 hm.put(1, 10);
		 hm.put(2, 20);
		 hm.put(3, 30);
		 
		 System.out.println(hm.get(2));
		 hm.remove(2);
		 System.out.println(hm);
	}

}
