package intuit;

public class KingJump {
	
	public static int FindingMoves(int input1)
    {
		if(input1<0)
			return 0;
		int result = 8;
		for(int i=1;i<=input1+1; i++)
		{
			result*=i;
		}
		return result+1;
    }

	private static int helper(int input1) {
		if(input1 == 0)
			return 1;
		if(input1 == 1)
			return 8;
		return input1*helper(input1-1);
	}

	public static void main(String[] args) {
		System.out.println(FindingMoves(2));
	}
}
