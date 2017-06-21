package array;

import java.util.Arrays;

public class FindNextGreaterNumber 
{
	public static void main(String[] args) {
		FindNextGreaterNumber fg = new FindNextGreaterNumber();
		System.out.println(fg.getNext(534976));
	}
	
	public int getNext(int input)
	{
		int[] inpArray = getIntAsArray(input);
		//Step1: Find the first decreasing element in array and store it's index
		int firstDecreasingNum = inpArray[inpArray.length-1];
		int firstDecreasingNumIndex = Integer.MIN_VALUE;
		for(int i = inpArray.length-2; i>=0;i--)
		{
			if(inpArray[i]<firstDecreasingNum)
			{
				firstDecreasingNum = inpArray[i];
				firstDecreasingNumIndex = i;
				break;
			}
		}
		//If firstDecreasingNumIndex is the value that we set, then throw exception as the given number is the maximum number that can be formed.
		if(firstDecreasingNumIndex == Integer.MIN_VALUE)
			throw new IllegalArgumentException("Not possible");
		//Step2: Find the smallest number that is greater than first decreasing number and store it's index.
		int smallestNumberGreaterThanGivenBumber = Integer.MAX_VALUE;
		int smallestNumberGreaterThanGivenBumberIndex = Integer.MIN_VALUE;
		if(firstDecreasingNumIndex != Integer.MIN_VALUE)
		{
			for(int i = firstDecreasingNumIndex+1; i<inpArray.length; i++)
			{
				if(inpArray[i]>firstDecreasingNum && inpArray[i]<smallestNumberGreaterThanGivenBumber)
				{
					smallestNumberGreaterThanGivenBumber = inpArray[i];
					smallestNumberGreaterThanGivenBumberIndex = i;
				}
			}
				
		}
		//Step3: Swap the two elements - First decreasing number and the smallest number that is greater than First decreasing number.
		swap(inpArray, firstDecreasingNumIndex, smallestNumberGreaterThanGivenBumberIndex);
		//step4: Sort the second half of the array.i.e. Right half of First decreasing number.
		Arrays.sort(inpArray, firstDecreasingNumIndex+1, inpArray.length);
		return getIntFromArray(inpArray);
	}
	

	private void swap(int[] inpArray, int firstDecreasingNumIndex, int smallestNumberGreaterThanGivenBumberIndex) {
		int temp = inpArray[firstDecreasingNumIndex];
		inpArray[firstDecreasingNumIndex] = inpArray[smallestNumberGreaterThanGivenBumberIndex];
		inpArray[smallestNumberGreaterThanGivenBumberIndex] = temp;
	}

	public int getIntFromArray(int[] nums)
	{
		StringBuilder strNum = new StringBuilder();

		for (int num : nums) 
		{
		     strNum.append(num);
		}
		return Integer.parseInt(strNum.toString());
	}

	
	public int[] getIntAsArray(int num)
	{
		String temp = Integer.toString(num);
		int[] newGuess = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++)
		{
		    newGuess[i] = temp.charAt(i) - '0';
		}
		return newGuess;
	}
}
