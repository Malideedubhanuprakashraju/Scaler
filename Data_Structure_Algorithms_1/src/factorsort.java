import java.util.Comparator;

public class factorsort implements Comparator <Integer>
{
	 

	@Override
	public int compare(Integer o1, Integer o2)
	{
		 int fs1=factors(o1);
		 int fs2=factors(o2);
		 
		 if(fs1<fs2)
		 {
			 return -1;
		 }
		 else if(fs2<fs1)
		 {
			 return 1;
		 }
		 else
		 {
			 if(o1<o2)
			 {
				 return -1;
			 }
			 else if(o2<o1)
			 {
				 return 1;
			 }
			 else
			 {
				 return 0;
			 }
		 }
		 
		 
	}

	private int factors(Integer N) 
	{
		 int c=0;
		 
		 for(int i=1;i*i<=N;i++)
		 {
			 if(N%i==0)
			 {
				 if(i==N/i)
				 {
					 c=c+1;
				 }
				 else
				 {
					 c=c+2;
				 }
			 }
		 }
		 return c;
	}
	

}
