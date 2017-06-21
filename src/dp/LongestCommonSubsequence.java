package dp;

public class LongestCommonSubsequence 
{
	public static void findLengthOfLCS(String s1, String s2)
	{
		int length1 = s1.length();
		int length2 = s2.length();
		int[][] lcsMatrix = new int[length1+1][length2+1];
		for(int i=1;i<length1+1;i++)
		{
			for(int j=1; j<length2+1 ;j++)
			{
				if(s1.charAt(i-1)==s2.charAt(j-1))
					lcsMatrix[i][j] = 1+lcsMatrix[i-1][j-1];
				else
					lcsMatrix[i][j] = Math.max(lcsMatrix[i-1][j], lcsMatrix[i][j-1]);
			}
		}
		System.out.println("LCS length "+lcsMatrix[length1][length2]);
		getLCS(lcsMatrix, s1);
	} 
	
	public static void getLCS(int[][] lcsMatrix, String s1)
	{
		StringBuffer sb = new StringBuffer();
		int i = lcsMatrix.length-1;
		int j = lcsMatrix[i].length-1;
		while(i>0 && j>0)
		{
			if(lcsMatrix[i][j]==lcsMatrix[i-1][j])
				i--;
			else if(lcsMatrix[i][j]==lcsMatrix[i][j-1])
				j--;
			else if(lcsMatrix[i][j]>lcsMatrix[i-1][j-1])
			{
				sb.append(s1.charAt(i-1));
				i--;j--;
			}
		}
		System.out.println(sb.reverse());
	}
	
	public static int getLCSRecursive(String str1, String str2, int len1, int len2)
	{
		if(len1==str1.length() || len2==str2.length())
			return 0;
		else if(str1.charAt(len1)==str2.charAt(len2))
		{
			return 1+getLCSRecursive(str1, str2, len1+1, len2+1);
		}
		else
			return Math.max(getLCSRecursive(str1, str2, len1+1, len2), getLCSRecursive(str1, str2, len1, len2+1));
	}
	
	public static void main(String[] args) 
	{
		findLengthOfLCS("forgeeksskeegfor", "rofgeeksskeegrof"); //4.GTAB
		//System.out.println("LCS computed recursively: "+getLCSRecursive("AGGTAB", "GXTXAYB", 0, 0));//4.GTAB
	}
	
}
