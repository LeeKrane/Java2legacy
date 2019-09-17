package school.chif2.linkedListsOLD.linkedListDOEL;

import java.util.Scanner;

public class list
{
	listNode head;
	listNode tail;
	int size;
	
	public list ()
	{
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	public static void main (String[] args)
	{
		list liste = new list();
		boolean quit = false;
		Scanner scan = new Scanner(System.in);
		
		do
		{
			System.out.println("Data: ");
			if (scan.hasNextInt())
				liste.addNode(scan.nextInt());
			else
				quit = true;
		}
		while (!quit);
		
		System.out.println(liste.head.data + " " + liste.head.next.data + " " + liste.tail.data);
	}
	
	private void addNode (int data)
	{
		if (size == 0)
		{
			size++;
			head = new listNode(data, null, null);
		}
		else if (size == 1)
		{
			size++;
			tail = new listNode(data, null, head);
			head.next = tail;
		}
		else
		{
			size++;
			listNode newNode = new listNode(data, null, tail);
			tail.next = newNode;
			tail = newNode;
		}
	}
}
