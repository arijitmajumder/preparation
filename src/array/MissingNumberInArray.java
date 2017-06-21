package array;

import java.util.Arrays;

public class MissingNumberInArray {

	public static void main(String[] args) {
		int[] inp = {1,2,3,5};
		System.out.println(findMissingNumberInArray(inp));
	}
	public static int findMissingNumberInArray(int[] input)
	{
		int arrayLenght = input.length+1;
		int sum = (arrayLenght*(arrayLenght+1))/2;
		int arraySum = Arrays.stream(input).map(i->i).sum();
		return sum-arraySum;
	}
}
