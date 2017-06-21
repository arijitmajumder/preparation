package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class Heap 
{
	private int size = 0;
	private int capacity = 10;
	int[] data = new int[capacity];
	
	public int getLeftChildIndex(int index)
	{
		return (2*index +1) < size ? 2*index +2 : Integer.MAX_VALUE;
	}
	
	public int getRightChildIndex(int index)
	{
		return (2*index +2)<size ? 2*index +2: Integer.MAX_VALUE;
	}
	
	public int getParentIndex(int index)
	{
		return (index -1)/2;
	}
	
	public int getLefChild(int index)
	{
		return (getLeftChildIndex(index) < Integer.MAX_VALUE)? data[getLeftChildIndex(index)] : Integer.MAX_VALUE;
	}
	
	public int getRightChild(int index)
	{
		return (getRightChildIndex(index) < Integer.MAX_VALUE)? data[getRightChildIndex(index)] : Integer.MAX_VALUE;
	}
	
	public int getParent(int index)
	{
		return data[getParentIndex(index)];
	}
	
	public boolean hasLeftChild(int index)
	{
		return getLeftChildIndex(index) != Integer.MAX_VALUE ? true : false;
	}
	
	public boolean hasRightChild(int index)
	{
		return getRightChildIndex(index) != Integer.MAX_VALUE ? true : false;
	}
	
	public void ensureCapacity()
	{
		if(size == capacity)
			data = Arrays.copyOf(data, 2*capacity);
		capacity *=2;
	}
	
	public void swap(int indexOne, int indexTwo)
	{
		int temp = data[indexOne];
		data[indexOne] = data[indexTwo];
		data[indexTwo] = temp;
	}
	
	public int peek()
	{
		if(size ==0)
			throw new IllegalStateException();
		return data[0];
	}
	
	public int poll()
	{
		int item = peek();
		data[0] = data[size-1];
		size--;
		heapifyDown();
		return item;
	}

	private void heapifyDown() 
	{
		int index = 0;
		int smallerChildIndex = 0;
		while(hasLeftChild(index))
		{
			smallerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && getRightChild(index)<getLeftChildIndex(index))
				smallerChildIndex = getRightChildIndex(index);
			if(data[index] > data[smallerChildIndex])
			{
				swap(index, smallerChildIndex);
			}
			else
			{
				break;
			}
			index = smallerChildIndex;
		}
	}
	
	public static void main(String[] args) 
	{
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(2);
		list.add(5);
		list.add(8);
		list.add(1);
		list.add(10);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.addAll(list);
		pq.add(3);
		Iterator<Integer> itr = pq.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
			
		}
		System.out.println("Done with iteration");
		System.out.println(pq.remove());
		System.out.println(pq.remove());
		System.out.println(pq.remove());
	}
}
