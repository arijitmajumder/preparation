package sortingSearching;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JAVAComparatorSorting {

	
	public static void main(String[] args) {
		List<Integer> inp = Arrays.asList(-1,4,1,6,-3,2);
		System.out.println(insertSort(inp));
	}
	
	/**;
	 * Insertion sort algo implementation
	 * @param numbers
	 * @return
	 */
	public static List<Integer> insertSort(final List<Integer> numbers) 
	{
		final List<Integer> sortedList = new LinkedList<>();
		originalList: for (Integer number : numbers) {
			for (int i = 0; i < sortedList.size(); i++) {
				if (number < sortedList.get(i)) {
					sortedList.add(i, number);
					continue originalList;
				}
			}
			sortedList.add(sortedList.size(), number);
		}
		return sortedList;
	}
}

class EmplyoeeSortable implements Comparable<EmplyoeeSortable>
{
	private int id;
	private String empName;
	
	@Override
	public int compareTo(EmplyoeeSortable o) {
		return this.id-o.id;
	}
	
}
