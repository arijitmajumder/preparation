package general;

/**
 * http://www.geeksforgeeks.org/trapping-rain-water/
 * @author Arijit_Majumder
 *
 */
public class WaterTrapping 
{

	private static int getWaterAmount(int arr[], int n) 
	{
		    int left[] = new int[n]; //will contain elements which is greater than current left element
		 
		    int right[] = new int[n];//will contain elements which is greater than current right element
		 
		    int water = 0;
		 
		    left[0] = arr[0];
		    for (int i = 1; i < n; i++)
		       left[i] = Math.max(left[i-1], arr[i]);
		 
		    right[n-1] = arr[n-1];
		    for (int i = n-2; i >= 0; i--)
		       right[i] = Math.max(right[i+1], arr[i]);
		 
		    for (int i = 0; i < n; i++)
		       water += Math.min(left[i],right[i]) - arr[i]; //it is 
		 
		    return water;
	}
	
	public static void main(String[] args) 
	{
		 //int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		 int arr[]   = {3, 0, 0, 2, 0, 4};
		 System.out.println(getWaterAmount(arr,arr.length));
	}
}
