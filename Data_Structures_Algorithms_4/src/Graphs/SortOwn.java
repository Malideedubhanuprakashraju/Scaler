package Graphs;

import java.util.Comparator;

public class SortOwn implements Comparator<pair>
{

	@Override
	public int compare(pair o1, pair o2) 
	{
		 if(o1.i<o2.i)
		 {
			return -1;
		 }
		 else
		 {
			 return 1;
		 }
	}
	
}

