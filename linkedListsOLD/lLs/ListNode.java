package school.chif2.linkedListsOLD.lLs;

public class ListNode
{
	private Object data;  //zu kapselnde Daten
	private ListNode next, previous;  //nächster Eintrag in der Liste
	
	public ListNode getPrevious ()
	{
		return previous;
	}
	
	public void setPrevious (ListNode previous)
	{
		this.previous = previous;
	}
	
	public ListNode (Object data)
	{
		this.data = data;
	}
	
	public Object getData ()
	{
		return data;
	}
	
	public void setData (Object data)
	{
		this.data = data;
	}
	
	public ListNode getNext ()
	{
		return next;
	}
	
	public void setNext (ListNode next)
	{
		this.next = next;
	}
	
	@Override
	public String toString ()
	{
		return data.toString();
	}
}