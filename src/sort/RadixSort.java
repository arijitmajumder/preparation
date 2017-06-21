package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class RadixSort 
{
	public int getMax(int[] input)
	{
		int max = Integer.MIN_VALUE;
		for(int i=0; i<input.length; i++)
		{
			if(input[i]>max)
				max = input[i];
		}
		return max;
	}
	
	public List<Integer> performRadixSort(int[] input)
	{
		List<Integer> input1 = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		for(int i=0; i<input.length; i++)
		{
			if(input[i]>max)
				max = input[i];
			input1.add(input[i]);
		}
		for(int exp=10; exp<max; exp*=10)
		{
			performCountSort(input1,exp);
		}
		return input1;
	}

	private void performCountSort(List<Integer> input, int exp) 
	{
		Map<Integer, List<Integer>> map = new LinkedHashMap<>();
		List<Integer> temp = null;
		List<Integer> output = new ArrayList<>();
		for(int i=0; i<10;i++)
		{
			map.put(i, new ArrayList<>());
		}
		for(int i=0; i<input.size(); i++)
		{
			temp = map.get((input.get(i)%exp)/10);
			temp.add(input.get(i));
		}
		for(int i=0; i<10;i++)
		{
			temp = map.get(i);
			if(!temp.isEmpty())
				output.addAll(temp);
		}
		input.clear();
		input.addAll(output);
	}
	
	public static void main(String args[]){
        int arr[] = {101,10,11,66,94,26,125};
        RadixSort rs = new RadixSort();
        List<Integer> output = rs.performRadixSort(arr);
        for (Integer i: output) {
            System.out.println(i);
        }

    }
}
