package strings;

public class SpiralOrderMatrix 
{
	static void spiralPrint(int a[][])
	{
	    int i, startRowIndex = 0, startColIndex = 0;
	    int endRowIndex = a.length;
	    int endColIndex = a[0].length;
	 
	    /*  k - starting row index
	        m - ending row index
	        l - starting column index
	        n - ending column index
	        i - iterator
	    */
	 
	    while (startRowIndex < endRowIndex && startColIndex < endColIndex)
	    {
	        /* Print the first row from the remaining rows */
	        for (i = startColIndex; i < endColIndex; ++i)
	        {
	        	System.out.print(a[startRowIndex][i]+", ");
	        }
	        startRowIndex++;
	 
	        /* Print the last column from the remaining columns */
	        for (i = startRowIndex; i < endRowIndex; ++i)
	        {
	        	System.out.print(a[i][endColIndex-1]+", ");
	        }
	        endColIndex--;
	 
	        /* Print the last row from the remaining rows */
	        if ( startRowIndex < endRowIndex)
	        {
	            for (i = endColIndex-1; i >= startColIndex; --i)
	            {
	            	System.out.print(a[endRowIndex-1][i]+", ");
	            }
	            endRowIndex--;
	        }
	 
	        /* Print the first column from the remaining columns */
	        if (startColIndex < endColIndex)
	        {
	            for (i = endRowIndex-1; i >= startRowIndex; --i)
	            {
	            	System.out.print(a[i][i]+", ");
	            }
	            startColIndex++;    
	        }        
	    }
	}
	public static void spiralPrint1(int matrix[][]){
	    int i,  startRowIndex = 0, startColIndex = 0;
	    int endRowIndex = matrix.length-1;  
	    int endColIndex = matrix[0].length-1;      

	    while(startRowIndex <= endRowIndex && startColIndex <= endColIndex)
	    {
	        for(i = startColIndex; i <= endColIndex; ++i) {
	            System.out.print(matrix[startRowIndex][i]+ " ");
	        }           
	        startRowIndex++;

	        for(i = startRowIndex; i <= endRowIndex; ++i) {
	            System.out.print(matrix[i][endColIndex] + " ");
	        }
	        endColIndex--;

	        for(i = endColIndex; i >= startColIndex; --i) {
	                System.out.print(matrix[endRowIndex][i] + " ");
	        }
	        endRowIndex--;


	        for(i = endRowIndex; i >= startRowIndex; --i) {
	            System.out.print(matrix[i][startColIndex] + " ");
	        }
	        startColIndex++;
	    }
	}
	 
	/* Driver program to test above functions */
	public static void main(String[] args)
	{
	    /*int a[][] = { {1,  2,  3,  4,  5,  6},
	        {7,  8,  9,  10, 11, 12},
	        {13, 14, 15, 16, 17, 18}
	    };*/
		int a[][]= { {1, 2, 3, 4},
		             {5, 6, 7, 8},
		             {9, 10, 11, 12},
		             {13, 14, 15, 16}
		           };
		spiralPrint1(a);
	    //spiralPrint(a);
	}
}
