package strings;

import java.util.Arrays;

public class ReverseWordsInStrings 
{
	
	public static void main(String[] args) {
		String inp = "geeks quiz practice code";
		reverse(inp);
	}
	private static void reverse(String input) {
		String[] tokens = input.split(" ");
		String temp = null;
		int len = tokens.length-1;
		for(int i = 0; i<tokens.length/2 ; i++)
		{
			temp = tokens[i];
			tokens[i] = tokens[len];
			tokens[len] = temp;
			len--;
		}
		System.out.println(Arrays.toString(tokens));
	}
}
