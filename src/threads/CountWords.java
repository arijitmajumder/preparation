package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class CountWords 
{
	
	
}

class CountWordHelper implements Callable<AtomicInteger>
{
	ConcurrentHashMap<String, AtomicInteger> resultMap = null;
	
	public CountWordHelper(ConcurrentHashMap map) 
	{
		this.resultMap = map;
	}
	
	@Override
	public AtomicInteger call() throws Exception 
	{
		if(resultMap.contains(value))
	}
	
}