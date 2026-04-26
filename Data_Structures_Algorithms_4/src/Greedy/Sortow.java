package Greedy;

import java.util.Comparator;

public class Sortow implements Comparator<Pair>
{

	@Override
	public int compare(Pair o1, Pair o2) 
	{
		 //return o1.e-o2.e;// ascending order
		if (o1.e < o2.e) return -1;
		if (o1.e > o2.e) return 1;
		return 0;
	}
	
	/*
	 *  | Expression        | Result   | Meaning    | Order          |
		| ----------------- | -------- | ---------- | -------------- |
		| `o1.e - o2.e < 0` | Negative | o1 smaller | o1 comes first |
		| `o1.e - o2.e > 0` | Positive | o2 smaller | o2 comes first |
		| `o1.e - o2.e = 0` | Zero     | Equal      | No change      |

	 */

}
