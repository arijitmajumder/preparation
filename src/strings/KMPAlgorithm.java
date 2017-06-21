package strings;

import java.util.Arrays;

public class KMPAlgorithm 
{

	public static void main(String[] args) {
		char[] inp = {'a','a','b','a','a','b','a','a','a'};
		int[] out = computeTemporaryArray(inp);
		Arrays.stream(out).forEach(System.out::println);
	}
	private static int[] computeTemporaryArray(char pattern[])
	{
		int[] lps = new int[pattern.length];
		int j=0;
		for(int i=1; i<pattern.length;)
		{
			if(pattern[i]==pattern[j])
			{
				lps[i] = j+1;
				i++;
				j++;
			}
			else
			{
				if(j != 0)
				{
					j = lps[j-1];
				}
				else
				{
					lps[i]=0;
					i++;
				}
			}
		}
		return lps;
    }
}
