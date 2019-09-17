package school.chif2.linkedStack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LinkedStack
{
	private Node topOfStack = new Node();
	private int size;
	
	public static void main (String[] args) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("list.txt"));
		LinkedStack list = new LinkedStack();
		
		while (scan.hasNextLine())
			list.push(scan.nextLine());
		
		System.out.println(list);
	}
	
	public void push (Object o)
	{
		Node newNode;
		
		if (topOfStack == null)
			newNode = new Node(o);
		else
			newNode = new Node(o, topOfStack);
		
		size++;
		topOfStack = newNode;
	}
	
	public Object pop ()
	{
		if (size == 0)
			return null;
		
		Node tosOld = topOfStack;
		topOfStack = topOfStack.getNext();
		size--;
		
		return tosOld.element;
	}
	
	public boolean isEmpty ()
	{
		return size == 0;
	}
	
	public int size ()
	{
		return size;
	}
	
	public Object element ()
	{
		if (size == 0)
			return null;
		
		return topOfStack.element;
	}
	
	@Override
	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
		Node out = topOfStack;
		
		for (int i = 0; i < size; i++)
		{
			sb.append(out.element).append('\n');
			out = out.next;
		}
		
		return sb.toString();
	}
}
