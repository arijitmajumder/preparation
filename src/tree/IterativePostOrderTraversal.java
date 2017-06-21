package tree;

import java.util.Stack;

public class IterativePostOrderTraversal 
{
	
	public void itrPostOrderTraversal(BinrayTreeNode root)
	{
		Stack<BinrayTreeNode> s1 = new Stack<>();
		Stack<BinrayTreeNode> s2 = new Stack<>();
		BinrayTreeNode temp = null;
		if(root != null)
			s1.push(root);
		while(!s1.isEmpty())
		{
			temp = s1.pop();
			if(null != temp.leftNode)
				s1.push(temp.leftNode);
			if(null != temp.rightNode)
				s1.push(temp.rightNode);
			s2.push(temp);
		}
		while(!s2.isEmpty())
		{
			System.out.println(s2.pop().data);
		}
	}
}
