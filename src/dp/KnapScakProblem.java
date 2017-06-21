package dp;

public class KnapScakProblem 
{

	public static int[][] knapsack(int[] val, int[] weight, int capacity)
	{
		int [][] dpHelper = new int[weight.length+1][capacity+1];
		
		for(int i=0; i<=weight.length;i++)
		{
			for(int j=0;j<=capacity;j++)
			{
				 if(i == 0 || j == 0)
				 {
	                    continue;
                 }
				 else if(j>=weight[i-1])
					dpHelper[i][j] = Math.max(dpHelper[i-1][j], (val[i-1]+dpHelper[i-1][j-weight[i-1]]));
				 else
					dpHelper[i][j] = dpHelper[i-1][j];
			}
		}
		System.out.println(dpHelper[weight.length][capacity]);
		return dpHelper;
	}
	
	public static void getElements(int[][] dpHelper, int[] val, int[] weight)
	{
		int i = dpHelper.length-1;
		int j = dpHelper[i].length-1;
		while(i >0 || j>0)
		{
			if(dpHelper[i][j] != dpHelper[i-1][j])
			{
				System.out.println("Item with value: "+val[i-1]+" Weight: "+weight[i-1]);
				j =j - weight[i-1];
			}
			else
			{
				i--;
			}
		}
	}
	
	public static void main(String[] args) 
	{
		int[] val = {1,4,5,7};
		int[] weight = {1,3,4,5};
		//int val[] = {60, 100, 120};
	    //int weight[] = {10, 20, 30};
		int[][] dpHelper = knapsack(val, weight, 7);
		getElements(dpHelper, val, weight);
	}

}
