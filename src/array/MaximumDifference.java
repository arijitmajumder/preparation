package array;

public class MaximumDifference 
{
	public static void getMaximumDiff(int[] arr)
	{
		int minElem = Integer.MAX_VALUE;
		int maxElem = Integer.MIN_VALUE;
		int minIndex = Integer.MAX_VALUE;
		int maxIndex = Integer.MIN_VALUE;
		for(int i=0; i< arr.length;i++)
		{
			if(arr[i]<minElem)
			{
				minElem = arr[i];
				minIndex = i;
			}
			else
			{
				maxElem = arr[i];
				maxIndex = i;
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//int[] arr = {80, 2, 6, 3, 100};
		int[] arr = {1, 2, 90, 10, 110};
		getMaximumDiff(arr);
	}
}
