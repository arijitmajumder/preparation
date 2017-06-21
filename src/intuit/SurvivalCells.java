package intuit;

public class SurvivalCells 
{

	public static void survivalcells(int[] input1,int[] input2)
    {
		int row = input1[0];
		int col = input1[1];
		int s1 = input1[2];
		int s2 = input1[3];
		int b1 = input1[4];
		int b2 = input1[5];
		int generation = input1[6];
		int[][] mat = new int[row][col];
		int[][] temp = new int[row][col];
		int x=0;
		for(int i=0; i<row; i++)
		{
			for(int j=0; j<col; j++)
			{
				mat[i][j] = input2[x++];
			}
		}
		int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
        int item = 0;
        int count1 = 0;
		for(int i = 0; i<generation; i++)
		{
			for(int r=0; r<mat.length; r++)
			{
				for(int c=0; c<mat[0].length; c++)
				{
					item = mat[r][c];
					for (int k = 0; k < 8; ++k)
					{
						if(isSafe(mat, r + rowNbr[k], c + colNbr[k]))
						{
							if(mat[r+rowNbr[k]][c+colNbr[k]]==1)
								count1++;
						}
					}
					if(item == 0)
					{
						temp[r][c]=(b1<=count1 && count1<=b2)?1:0;
					}
					else
					{
						temp[r][c]=(s1<=count1 && count1<=s2)?1:0;
					}
					count1 = 0;
				}
			}
			mat=temp;
			temp=new int[row][col];
		}
		int[] output = new int[row*col];
		x=0;
		for(int r = 0; r<mat.length; r++)
		{
			for(int c=0; c<mat[0].length; c++)
			{
				output[x++]=mat[r][c];
			}
		}
		System.out.println();
    }
	
	static boolean isSafe(int mat[][], int row, int col)
	{
	  return (row >= 0) && (row < mat.length) &&
	         (col >= 0) && (col < mat[0].length);
	}
	public static void main(String[] args) 
	{
		int[] input1={3,4,2,3,3,3,3};
		int[] input2={0,1,0,0,0,1,1,0,1,0,1,0};
		survivalcells(input1,input2);	
	}

}
