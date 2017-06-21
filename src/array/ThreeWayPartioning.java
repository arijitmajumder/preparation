package array;

import java.util.Arrays;
import java.util.stream.Stream;

import general.Swap;

public class ThreeWayPartioning 
{

	public static void main(String[] args) {
		int[] inp = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
		performPartion(inp, 20, 87);
	}
	public static void performPartion(int[] input, int low, int high)
	{
		int start = 0;
		int end = input.length-1;
		for(int i=0;i<=end;)
		{
			if(input[i] < low)
			{
				Swap.swap(input, i++, start++);
			}
			else if(input[i]>high)
			{
				Swap.swap(input, i, end--);
			}
			else
				i++;
		}
		Arrays.stream(input).forEach(System.out::println);
	}
}
