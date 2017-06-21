package linkedList;

import java.util.Random;

public class LinkedListUtility 
{
	public static int findLen(LinkedListNode node) 
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
		LinkedListNode tempNode;
		while(--count != 0)
		{
			newNode = new LinkedListNode(0);
			tempNode = node;
			newNode.next = node;
			node = newNode;
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
