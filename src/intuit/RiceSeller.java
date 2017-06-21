package intuit;

public class RiceSeller {

	public static int getMaxProfit(int n, int[] amount)
	{
		int max = Integer.MIN_VALUE;
		int current = 0;
		int[] temp = amount;
		if(null == amount || amount.length==0)
			return 0;
		if(amount.length==1)
			return amount[0];
		for(int i=2; i<=amount.length; i++)
		{
			current = temp[i-1];
			for(int j=i-1; j>=i/2; j--)
			{
				int price = temp[i-j-1]+temp[j-1];
				current = Math.max(current, price);
			}
			temp[i-1] = current;
			max = current;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] amount = {1,5,8,9};
		System.out.println(getMaxProfit(4, amount));
	}
}
