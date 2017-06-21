package heap;

import java.util.Comparator;

public class CommandComparator implements Comparator<Commands>
{

	@Override
	public int compare(Commands o1, Commands o2) {
		return (o1.getEpochTime().longValue() - o2.getEpochTime().longValue()<0)?-1:0;
	}
	
}
