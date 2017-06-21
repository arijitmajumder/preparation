package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class DiagonalTraversal 
{
	int diagonalLevel = 0;
	public void getDiagonalTraversal(TreeNode node, int distance)
	{
		Queue<TreeNode> queue = new LinkedList<>();
		Map<Integer, List<TreeNode>> map = new TreeMap<>();
		List<TreeNode> list = null;
		node.vd = 0;
		queue.offer(node);
		TreeNode temp = null;
		while(!queue.isEmpty())
		{
			temp = queue.poll();
			list = map.get(temp.vd);
			if(list == null)
			{
				list = new ArrayList<>();
				list.add(temp);
				map.put(temp.vd, list);
			}
			else
			{
				list.add(temp);
				map.put(temp.vd, list);
			}
			if(temp.left != null)
			{
				temp.left.vd = temp.vd+1;
				queue.offer(temp.left);
			}
			if(temp.right != null)
			{
				temp.right.vd=temp.vd;
				queue.offer(temp.right);
			}
		}
		
		for(List<TreeNode> list1 : map.values())
		{
			for(TreeNode te : list1)
			{
				System.out.print(te.data+", ");
			}
			System.out.println();
		}
	}
	
	public void getDiagonalTraversalWithoutMap(TreeNode node)
	{
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(node);
		queue.offer(null);
		TreeNode temp = null;
		while(!queue.isEmpty())
		{
			temp = queue.poll();
			if(temp == null)
			{
				System.out.println();
				queue.offer(null);
				temp = queue.poll();
				if(temp == null)
					break;
			}
			while(temp != null)
			{
				if(temp.left != null)
				{
					temp.left.vd = temp.vd+1;
					queue.offer(temp.left);
				}
				System.out.print(temp.data+", ");
				temp = temp.right;
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(11);
        root.left.left.right = new TreeNode(10);
        
        DiagonalTraversal dt = new DiagonalTraversal();
        dt.getDiagonalTraversal(root, 0);
        System.out.println("Printing without using map");
        dt.getDiagonalTraversalWithoutMap(root);
        
	}
}
