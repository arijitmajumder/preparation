package dp;

public class EditDistance 
{
	public static void getMinimumEdits(String source, String destination)
	{
		int len1 = source.length();
		int len2 = destination.length();
		int[][] dpED = new int[len1+1][len2+1];
		for(int i=0; i<dpED.length; i++)
		{
			for(int j=0; j<dpED[i].length; j++)
			{
				//if i=0 i.e. source String is blank and target String is of length j
				if(i==0)
					dpED[i][j]=j;
				//if j=0 i.e. source String is of length i blank and target String is blank
				else if(j==0)
					dpED[i][j]=i;
				//if both the Chars are Matching then just copy diagonal element.
				else if(source.charAt(i-1)==destination.charAt(j-1))
				{
					dpED[i][j] = dpED[i-1][j-1];
				}
				//if do not match then take minimum of left, top or diagonal element + 1(for replacing current element to target element)
				else
				{
					dpED[i][j] = 1+getMin(dpED[i-1][j-1], dpED[i][j-1], dpED[i-1][j]);
				}
			}
		}
		System.out.println("Minimum edits required is: "+dpED[len1][len2]);
		
		/**
		 * For converting SATUR -> SUN
		 *      S  U  N
 			[0, 1, 2, 3], 
		   S[1, 0, 1, 2], S&S matches so from diagonal. S&U -> no match, so by memorization (previous computed result)
		   A[2, 1, 1, 3], 									   we know S->S = 0,		
		   T[3, 2, 2, 2], 											   0->S	= 1,
		   U[4, 3, 2, 3], 											   0->SU= 2. taking minimum(0)+1=1 operation required for S->SU
		   R[5, 4, 3, 3]
		 */
		getEdits(dpED, source, destination);
	}
	
	public static void getEdits(int[][] dpEd, String s1, String s2)
	{
		int i = dpEd.length-1;
		int j = dpEd[i].length-1;
		while(i>0 && j>0)
		{
			if(s1.charAt(i-1)!=s2.charAt(j-1))
			{
				if(dpEd[i][j-1]<=dpEd[i-1][j-1] && dpEd[i][j-1]<=dpEd[i-1][j])
				{
					System.out.println(s2.charAt(j-1)+" -> INSERT");
					j--;
				}
				else if(dpEd[i-1][j-1]<=dpEd[i-1][j] && dpEd[i-1][j-1]<=dpEd[i][j-1])
				{
					System.out.println(s1.charAt(i-1)+" -> "+s2.charAt(j-1));
					j--;i--;
				}
				else
				{
					System.out.println(s1.charAt(i-1)+" -> DELETE");
					i--;
				}
			}
			else
			{
				i--;j--;
			}
		}
		while(i!=0)
		{
			System.out.println(s1.charAt(i-1)+" -> DELETE");
			i--;
		}
		while(j!=0)
		{
			System.out.println(s2.charAt(j-1)+" -> INSERT");
			j--;
		}
	}
	
	public static int getMin(int diagonal, int left, int top)
	{
		if(diagonal<=left && diagonal<=top)
			return diagonal;
		if(left<=top && left<=diagonal)
			return left;
		return top;
	}
	public static void main(String[] args) {
		getMinimumEdits("SATUR", "SUN");
		//getMinimumEdits("SUN", "SATUR");
		//getMinimumEdits("CAT", "DOGS");
		//getMinimumEdits("DOGS", "CAT");
		//getMinimumEdits("INTENTION", "EXECUTION");
	}
}
