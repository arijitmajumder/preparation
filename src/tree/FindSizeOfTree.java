package tree;

import java.util.LinkedList;

public class FindSizeOfTree 
{
	
	public int getSizeOfTree(BinrayTreeNode root)
	{
		LinkedList<BinrayTreeNode> ll = new LinkedList<>();
		ll.add(root);
		BinrayTreeNode temp = null;
		int count = 0;
		while(ll.getFirst() != null)
		{
			temp = ll.poll();
			count++;
			if(temp.leftNode!=null)
				ll.add(temp.leftNode);
			if(temp.rightNode != null)
				ll.add(temp.rightNode);
		}
		return count;
	}
}
