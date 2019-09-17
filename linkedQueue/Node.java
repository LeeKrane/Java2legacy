package school.chif2.linkedQueue;

public class Node
{
	Object element;
	Node next;
	
	public Node ()
	{
		this("", null);
	}
	
	public Node (Object element)
	{
		this(element, null);
	}
	
	public Node (Node next)
	{
		this("", next);
	}
	
	public Node (Object element, Node next)
	{
		this.element = element;
		this.next = next;
	}
	
	public Node getNext ()
	{
		return next;
	}
	
	@Override
	public String toString ()
	{
		return "[" + element + "]";
	}
}
