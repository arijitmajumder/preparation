package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.sound.midi.ControllerEventListener;

public class LongestIncreasingSubsequenceDP 
{

	public static void  getLengthOfLIS(int[] input)
	{
		int[] dpTemp = new int[input.length];
		for(int i=0;i<input.length;i++)
			dpTemp[i]=1;
		
		for(int i=1;i<input.length;i++)
		{
			for(int j=0; j<i; j++)
			{
				if(input[i]>input[j])
					dpTemp[i]=Integer.max(dpTemp[i], dpTemp[j]+1);
			}
		}
		
		Arrays.sort(dpTemp);
		System.out.println(dpTemp[dpTemp.length-1]);
	}
	
	
	public static void main(String[] args) 
	{
		int[] arr = {3,4,-1,0,6,2,3};
		int[] arr1 = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		int[] arr2 = {3, 10, 2, 1, 20};
		int[] arr3 = {3, 2};
		int[] arr4 = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		getLengthOfLIS(arr4);
		/**
		 * Test getLargestList  method
		 */
		/*ArrayList<Integer> tempList = new ArrayList<Integer>();
		List<List<Integer>> sequenceList = new ArrayList<>();
		tempList.add(9);
		sequenceList.add(cloneList(tempList));
		tempList.clear();
		tempList.add(10);
		sequenceList.add(cloneList(tempList));
		tempList.clear();
		tempList.addAll(Arrays.asList(10,21));
		sequenceList.add(cloneList(tempList));
		tempList.clear();
		tempList.addAll(Arrays.asList(10,21,33));
		sequenceList.add(cloneList(tempList));
		tempList.clear();
		List<Integer> op = getLargestList(sequenceList, 33);*/
	}
}
