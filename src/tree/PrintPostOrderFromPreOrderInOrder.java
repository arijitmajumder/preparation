package tree;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintPostOrderFromPreOrderInOrder {

	int search(int arr[], int x, int n)
	{
	    for (int i = 0; i < n; i++)
	      if (arr[i] == x)
	         return i;
	    return -1;
	}
	
	void printPostOrder(int in[], int inIndex, int pre[], int preIndex, int n)
	{
	   // The first element in pre[] is always root, search it
	   // in in[] to find left and right subtrees
	   int root = search(in, pre[preIndex], n);
	 
	   // If left subtree is not empty, print left subtree
	   if (root != 0)
	      printPostOrder(in, inIndex, pre, preIndex+1,  root);
	 
	   // If right subtree is not empty, print right subtree
	   if (root != n-1)
	      printPostOrder(in, inIndex+root+1, pre, preIndex+root+1, n-root-1);
	 
	   // Print root
	   System.out.println(pre[preIndex]);
	}
	
    public static void main(String args[]) {
        /*int preorder[] = {10, 5, 3, 21, 20, 18, 9 , 16};
        int inorder[] = {3, 5, 21, 10, 18, 9, 20, 16};*/
    	int preorder[] = {1,2,4,5,3,6};
        int inorder[] = {4,2,5,1,3,6};
        PrintPostOrderFromPreOrderInOrder ppp = new PrintPostOrderFromPreOrderInOrder();
       ppp.printPostOrder(inorder, 0, preorder, 0, preorder.length-1);;
    }
}