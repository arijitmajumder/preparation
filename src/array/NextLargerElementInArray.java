package array;

import java.util.LinkedList;
import java.util.Stack;

public class NextLargerElementInArray 
{

	public static void main(String[] args) {
		int[] arr = {1,3,2,4};
		int[] arr1 = {4, 5, 2, 25};
		getNextLargerElement(arr1);
	}
	/**
	 *   For every new element from array, 
	 * 		while(stack is not empty)
	 * 		{
	 * 			compare it with stack top, if stacktop<new element, 
	 * 			then 
	 * 	  	 		stacktop --> new element and Pop the element
	 * 			else
	 * 				break	
	 * 		 }
	 * 		 push current element in stack
	 */
	public static void getNextLargerElement(int[] array)
	{
		Stack<Integer> temp = new Stack<Integer>();
		for(Integer val : array)
		{
			while(!temp.isEmpty())
			{
				int data = temp.peek();
				if(data < val)
				{
					System.out.println(data+"->"+val);
					temp.pop();
				}
				else
				{
					break;
				}
			}
			temp.push(val);
		}
		
		while(!temp.isEmpty())
		{
			System.out.println(temp.pop()+"->-1");
		}
	}
	
}
