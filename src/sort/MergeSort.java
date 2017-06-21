package sort;

import java.util.Arrays;

public class MergeSort 
{
	public void performMergeSort(int[] result)
	{
		if(result.length<2)
			return;
		int mid = result.length/2;
		int[] partition1 = Arrays.copyOf(result, mid);
		int[] partition2 = Arrays.copyOfRange(result, mid, result.length);
			
		performMergeSort(partition1);
		performMergeSort(partition2);
		
		merge(partition1,partition2,result);
	}

	private void merge(int[] partition1, int[] partition2, int[] result) 
	{
		int i = 0;
		int j = 0;
		int index = 0;
		while(i<partition1.length && j<partition2.length)
		{
			if(partition1[i]<=partition2[j])
			{
				result[index] = partition1[i];
				i++;
				index++;
			}
			else
			{
				result[index] = partition2[j];
				j++;
				index++;
			}
		}
		if(i<partition1.length)
		{
			while(i<partition1.length)
				result[index++] = partition1[i++];
		}
		else if(j<partition2.length)
		{
			while(j<partition2.length)
				result[index++] = partition2[j++];
		}
	}
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		//int[] input = {2,4,1,6,8,5,3,9,7};
		int[] input = {4,2,1,3};
		ms.performMergeSort(input);
		System.out.println();
	}
	
}
