package school.chif2.linkedListsOLD.linkedListDOEL;

public class listNode
{
	int data;
	listNode next;
	listNode previous;
	
	public listNode ()
	{
		this.data = 0;
		this.next = null;
		this.previous = null;
	}
	
	public listNode (int data, listNode next, listNode previous)
	{
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
}
