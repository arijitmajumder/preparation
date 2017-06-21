package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://stackoverflow.com/questions/14948258/given-an-input-array-find-all-subarrays-with-given-sum-k
 * @author Arijit_Majumder
 *
 */
public class AllSubArrWithSum 
{

	public static void main(String[] args) {
	    /*int[] INPUT = {5, 6, 1, -2, -4, 3, 1, 5};
	    printSubarrays(INPUT, 5);*/
		int[] INPUT = {10, 2, -2, -20, 10};
	    printSubarrays(INPUT, -10);
	}

	private static void printSubarrays(int[] input, int k) {
	    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
	    List<Integer> initial = new ArrayList<Integer>();
	    initial.add(-1);
	    map.put(0, initial);
	    int preSum = 0;

	    // Loop across all elements of the array
	    for(int i=0; i< input.length; i++) {
	        preSum += input[i];
	        // If point where sum = (preSum - k) is present, it means that between that 
	        // point and this, the sum has to equal k
	        if(map.containsKey(preSum - k)) {   // Subarray found 
	            List<Integer> startIndices = map.get(preSum - k);
	            for(int start : startIndices) {
	                System.out.println("Start: "+ (start+1)+ "\tEnd: "+ i);
	            }
	        }

	        List<Integer> newStart = new ArrayList<Integer>();
	        if(map.containsKey(preSum)) { 
	            newStart = map.get(preSum);
	        }
	        newStart.add(i);//It means from start till this point(i) sum is preSum. 
	        map.put(preSum, newStart);
	    }
	}
	
}
