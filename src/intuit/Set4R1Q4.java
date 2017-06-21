package intuit;

/**
 * http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 * @author Arijit_Majumder
 *
 */
public class Set4R1Q4 
{
	public static void main(String[] args) {
		//int[] inp = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		int[] inp = {0, 1, 2, 0, 2};
		sort012(inp);
		for(Integer i : inp)
		{
			System.out.println(i);
		}
	}
	static void sort012(int a[])
    {
        int lo = 0;
        int hi = a.length - 1;
        int mid = 0,temp=0;
        while (mid <= hi)
        {
            switch (a[mid])
            {
            case 0:
            {
                temp   =  a[lo];
                a[lo]  = a[mid];
                a[mid] = temp;
                lo++;
                mid++;
                break;
            }
            case 1:
                mid++;
                break;
            case 2:
            {
                temp = a[mid];
                a[mid] = a[hi];
                a[hi] = temp;
                hi--;
                break;
            }
            }
        }
    }
}
