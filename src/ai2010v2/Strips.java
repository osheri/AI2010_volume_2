package ai2010v2;

import java.util.Vector;

public class Strips {

	// this is the main strips stack which will hold the predicates and operators
	// which are used to solve the algorithm
	
	private Vector<Item> stack;  
		
	public void push(Item item) // adds new item in the end of the stack
	{
		stack.add(item);
	}
	
	public void pop() // removes the last item of the stack
	{
		stack.remove(stack.size()-1);
	}
	
	public boolean isempty() // checks if the stack is empty
	{
		if (stack.size() > 0)
			return true;
		else 
			return false;
	}
	
	public int finditem(Item item) // returns the index of the last occurrence for given item 
	{
		return stack.lastIndexOf(item);
	}
	
	public Item top() // returns the last item in the stack
	{
		return stack.lastElement();
	}
}
