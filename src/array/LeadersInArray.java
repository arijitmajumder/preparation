package array;

public class LeadersInArray 
{
	public static void main(String[] args) {
		int[] arr = {1,3,2,4};
		int[] arr1 = {4, 25,5, 2};
		getLeaderInArray(arr1);
	}
	
	public static void getLeaderInArray(int[] inp)
	{
		int max_array = Integer.MIN_VALUE;
		for(int i = inp.length-1; i>=0; i--)
		{
			if(inp[i]>max_array)
			{
				max_array = inp[i];
				System.out.println(max_array);
			}
		}
	}
}
