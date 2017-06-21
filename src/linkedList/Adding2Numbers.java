package linkedList;

import java.util.Random;

public class Adding2Numbers 
{
	public void performSummation(LinkedListNode l1, LinkedListNode l2)
	{
		int len1 = findLen(l1);
		int len2 = findLen(l2);
		if(len1 != len2)
		{
			if(len1 > len2) 	
			{
				l2 = padWithZero(l2, len1 - len2);
			}
			else
			{
				l1 = padWithZero(l1, len2 - len1);
			}
		}
		LinkedListNode result = new LinkedListNode(0);
		int carry = performSummationRecursiveReturningCarry(l1, l2, result);
		if (carry>0) 
		{
			result.data = carry;
		}
		else
		{
			result = result.next;
		}
		printLinkedList(result);
	}
	
	private int performSummationRecursiveReturningCarry(LinkedListNode l1, LinkedListNode l2, LinkedListNode result) 
	{
		if(l1 == null && l2 == null)
		{
			return 0;
		}
		LinkedListNode newNode = new LinkedListNode(0);
		result.next = newNode;
		int carry = performSummationRecursiveReturningCarry(l1.next,l2.next, newNode);
		int sum = carry+l1.data+l2.data;
		newNode.data = sum%10;
		return sum/10;
	}
	
	private int findLen(LinkedListNode node) 
	{
		int length = 0;
		while(node != null)
		{
			length++;
			node = node.next;
		}
		return length;
	}
	
	public static LinkedListNode padWithZero(LinkedListNode node, int count)
	{
		LinkedListNode newNode = null;
		while(count != 0)
		{
			newNode = new LinkedListNode(0);
			newNode.next = node;
			node = newNode;
			count--;
		}
		return node;
	}
	
	public static void printLinkedList(LinkedListNode node)
	{
		System.out.println("\n Printing the Linked List...");
		while(node != null)
		{
			System.out.print(node.data+" ");
			node = node.next;
		}
	}
	
	
	public static void main(String[] args) 
	{
		LinkedListNode l1 = createRandomLinkedList(2);
		printLinkedList(l1);
		LinkedListNode l2 = createRandomLinkedList(4);
		printLinkedList(l2);
		Adding2Numbers as = new Adding2Numbers();
		as.performSummation(l1, l2);
	}
	
	public static LinkedListNode createRandomLinkedList(int length)
	{
		Random r = new Random();
		LinkedListNode llNode = null;
		LinkedListNode tempNode = null;
		LinkedListNode headNode = new LinkedListNode(r.nextInt(10));
		tempNode = headNode;
		while(--length > 0)
		{
			llNode = new LinkedListNode(r.nextInt(10));
			tempNode.next = llNode;
			tempNode = llNode;
		}
		return headNode;
	}
}

