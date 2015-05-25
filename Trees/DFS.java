// program to implement the depth first search in a tree.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS{

	// tree node class
	public static class node
	{
		Object value;	
		node left;
		node right;

		node(int input)
		{
			value = input;
			left = right = null;
		}
	}

	// print the tree in in-order traversal format
	public static String toString(node input)
	{
		if(input == null)
			return ("") ;
		
		return (toString(input.left) + " : " + input.value + " : " + toString(input.right));
	}
	
	// implementing depth first search to find if the element exists
	public static boolean isPresent(Integer inputValue, node start)
	{
		if(start == null || inputValue == null)
		{
			return false;
		}
		
		Stack<node> searchS = new Stack<node>();				
		searchS.push( start);
		
		while(!searchS.isEmpty())
		{
			node temp = searchS.pop();
		
			if(temp.value == inputValue)
			{
				return true;
			}
			
			if(temp.right != null)
			{
				searchS.add(temp.right);
			}
			
			if(temp.left != null)
			{
				searchS.add(temp.left);
			}	
			
		}
	
		return false;
	}
	
	// main function with tree creation and basic test cases.
	public static void main(String args[])
	{		
		node head = new node(7);
		node firstLeft = new node(5);
		node firstRight = new node(9);
		node second1Left = new node(3);
		node second1Right = new node(6);
		node second2Left = new node(8);
		node second2Right = new node(11);
		node thirdLeft = new node(2);
		node thirdRight = new node(4);

		// Tree creation
		head.left = firstLeft;
		head.right = firstRight;
		firstLeft.left = second1Left;
		firstLeft.right = second1Right;
		firstRight.left = second2Left;
		firstRight.right = second2Right;
		second1Left.left = thirdLeft;
		second1Left.right = thirdRight;
		second2Right.right = new node(12);
		
		node testNode = null;
		
		System.out.println(toString(head));
		System.out.println(isPresent(25, head));
		System.out.println(isPresent(11, head));
		System.out.println(isPresent(1, testNode));
		System.out.println(isPresent(null, head));

		
	}	
}