package heap;

import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;

public class Commands implements Comparator<Commands>
{
	private AtomicLong epochTime;

	public Commands(long time) {
		epochTime = new AtomicLong(time);
		}
	
	public AtomicLong getEpochTime() {
		return epochTime;
	}

	public void setEpochTime(AtomicLong epochTime) {
		this.epochTime = epochTime;
	}

	@Override
	public int compare(Commands o1, Commands o2) {
		return (o1.getEpochTime().longValue() - o2.getEpochTime().longValue()<0)?-1:0;
	}
	
	
}
