package tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

public class LevelByLevelPrintTree 
{
	
	void printLevelByLevel(BinrayTreeNode node)
	{
		Queue<BinrayTreeNode> q1 = new LinkedList<>();
		Queue<BinrayTreeNode> q2 = new LinkedList<>();
		Stack<BinrayTreeNode> s1 =new Stack<>();
		if(null != node)
			q1.add(node);
		while(!q1.isEmpty() || !q2.isEmpty())
		{
			
		}
		
		Map<Integer, String> map = new TreeMap<>();
		Set<Entry<Integer, String>> entrySet = map.entrySet();
		Iterator<Entry<Integer, String>> asd = entrySet.iterator();
		for(String as : map.values())
		{
			System.out.println(as);
		}
			
	}
}
