package sort;

import test.Main;

public class Quicksort 
{
	public void performQucikSort(int[] input)
	{
		quickSort(input,0,input.length-1);
	}

	private void quickSort(int[] input, int start, int end) 
	{
		if(start >= end)
			return;
		int pivotIndex = partition(input, start, end);
		quickSort(input, start, pivotIndex-1);
		quickSort(input, pivotIndex+1, end);
	}

	private int partition(int[] input, int start, int end) 
	{
		int pivotIndex = start;
		int pivot = input[end];
		for(int i=start; i<end; i++)
		{
			if(input[i]<=pivot)
			{
				swap(input, pivotIndex, i);
				pivotIndex++;
			}
		}
		swap(input, pivotIndex, end);
		return pivotIndex;
	}

	private void swap(int[] input, int pivotIndex, int i) {
		int temp = input[i];
		input[i] = input[pivotIndex];
		input[pivotIndex] = temp;
	}
	
	public static void main(String[] args) {
		Quicksort qs = new Quicksort();
		//int[] input = {2,4,1,6,8,5,3,9,7};;
		int[] input = {2,4,1};
		qs.performQucikSort(input);
		System.out.println();
	}
}
