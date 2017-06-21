package general;

public class MaximumDifference 
{

	public static void main(String[] args) {
		int[] inp = {2, 3, 10, 6, 4, 8, 1};
		System.out.println(getMaxDiff(inp));
	}
	public static int getMaxDiff(int[] inp)
	{
		int min_so_far = inp[0];
		int max_diff = Integer.MIN_VALUE;
		for(int i=1; i<inp.length;i++)
		{
			if(inp[i]<=min_so_far)
				min_so_far = inp[i];
			else
			{
				int diff = inp[i]-min_so_far;
				if(diff>max_diff)
					max_diff = diff;
			}
		}
		return max_diff;
	}

}
