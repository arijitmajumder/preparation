package linkedList;

import java.util.LinkedList;

public class MergeTwoSortedList 
{

	public static void main(String[] args) 
	{
		LinkedListNode l1 = new LinkedListNode(1);
		l1.next = new LinkedListNode(3);
		l1.next.next = new LinkedListNode(5);
		
		LinkedListNode l2 = new LinkedListNode(2);
		l2.next = new LinkedListNode(4);
		l2.next.next = new LinkedListNode(6);
		LinkedListUtility.printLinkedList(performMerge(l1, l2));
		LinkedListNode merged = perfornmMergeRecursive(l1, l2);
		LinkedListUtility.printLinkedList(merged);
		
	}
	public static LinkedListNode performMerge(LinkedListNode l1, LinkedListNode l2)
	{
		LinkedListNode output = null;
		LinkedListNode head = null;
		LinkedListNode head1 = l1;
		LinkedListNode head2 = l2;
		if(head1 == null)
			output = head2;
		if(head2 ==null)
			output = head1;
		//Below if else block is out of while loop in order to point the head.
		if(head1.data<head2.data)
		{
			head = new LinkedListNode(head1.data);
			head1 = head1.next;
		}
		else
		{
			head = new LinkedListNode(head2.data);
			head2 = head2.next;
		}
		output = head;
		while(head1 !=null && head2!=null)
		{
			if(head1.data <head2.data)
			{
				output.next = new LinkedListNode(head1.data);
				head1 = head1.next;
				output = output.next;
			}
			else
			{
				output.next = new LinkedListNode(head2.data);;
				head2 = head2.next;
				output = output.next;
			}
		}
		if(head1 != null)
			output.next = head1;
		if(head2 != null)
			output.next = head2;
		return head;
	}

	public static LinkedListNode perfornmMergeRecursive(LinkedListNode l1, LinkedListNode l2)
	{
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		LinkedListNode output = null;
		if(l1.data<=l2.data)
		{
			output = l1;
			output.next = perfornmMergeRecursive(l1.next, l2);
		} 	
		else
		{
			output = l2;
			output.next = perfornmMergeRecursive(l1, l2.next);
		}
		return output;
	}
}
