package linkedList;

public class ReverseLinkedList 
{
	private LinkedListNode head = null;
	public void performReverse(LinkedListNode node)
	{
		if(node.next == null)
		{
			head = node;
			return;
		}
		performReverse(node.next);
		LinkedListNode temp = node.next;
		node.next = null;
		temp.next = node;
	}
	
	public void performReverseWithoutModifingHead(LinkedListNode node, LinkedListNode head)
	{
		//LinkedListNode head = null;
		if(node.next == null)
		{
			head = node;
			return;
		}
		performReverseWithoutModifingHead(node.next, head);
		LinkedListNode temp = node.next;
		node.next = null;
		temp.next = node;
	}
	
	public LinkedListNode iterativeReverse(LinkedListNode node)
	{
		LinkedListNode current = node;
		LinkedListNode prev = null;
		LinkedListNode next = null;
		while(current != null)
		{
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	
	public static void main(String[] args) 
	{	
		ReverseLinkedList rll = new ReverseLinkedList();
		rll.head = LinkedListUtility.createRandomLinkedList(3);
		LinkedListUtility.printLinkedList(rll.head);
		LinkedListNode asd = null;
		rll.performReverseWithoutModifingHead(rll.head,asd);
		LinkedListUtility.printLinkedList(asd);
		/*rll.performReverse(rll.head);
		LinkedListUtility.printLinkedList(rll.head);
		LinkedListUtility.printLinkedList(rll.performReverseWithoutModifingHead(rll.head));
		LinkedListUtility.printLinkedList(rll.iterativeReverse(rll.head));*/
	}
}
