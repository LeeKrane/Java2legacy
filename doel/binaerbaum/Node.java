package school.chif2.doel.binaerbaum;

public class Node
{
	// TODO: find() Funktion
	
	private int data;
	private Node left;
	private Node right;
	
	public Node ()
	{
		this(0);
	}
	
	public Node (int value)
	{
		this.data = value;
		this.left = null;
		this.right = null;
	}
	
	public void setData (int data)
	{
		this.data = data;
	}
	
	public int getData ()
	{
		return data;
	}
	
	public void setLeft (Node left)
	{
		this.left = left;
	}
	
	public Node getLeft ()
	{
		return left;
	}
	
	public void setRight (Node right)
	{
		this.right = right;
	}
	
	public Node getRight ()
	{
		return right;
	}
	
	public boolean insert (int value)
	{
		if (this.data != value)
		{
			if (this.data > value)
			{
				if (this.left == null)
				{
					this.left = new Node(value);
					return true;
				}
				return this.left.insert(value);
			}
			else
			{
				if (this.right == null)
				{
					this.right = new Node(value);
					return true;
				}
				return this.right.insert(value);
			}
		}
		return false;
	}
	
	public boolean delete (int value)
	{
		if (this.data > value)
			return deleteNode(this.left, value);
		return deleteNode(this.right, value);
	}
	
	private boolean deleteNode (Node node, int value)
	{
		if (node != null)
		{
			if (node.getData() == value)
			{
				node = node.delete();
				return true;
			}
			return node.delete(value);
		}
		return false;
	}
	
	public Node delete ()
	{
		if (this.left == null)
			return this.right;
		else if (this.right == null)
			return this.left;
		else if (this.right.getLeft() == null)
		{
			this.data = this.right.getData();
			this.right = this.right.delete();
			return this;
		}
		this.data = (this.right.deleteMinimum()).getData();
		return this;
	}
	
	private Node deleteMinimum()
	{
		if (this.left.getLeft() == null)
		{
			Node nodeToDelete = this.left;
			this.left = this.left.delete();
			return nodeToDelete;
		}
		return this.left.deleteMinimum();
	}
	
	public void list ()
	{
		if (this.left != null)
			this.left.list();
		
		System.out.format(this.data + " ");
		
		if (this.right != null)
			this.right.list();
	}
	
	public int sum ()
	{
		int i = this.data;
		if (this.left != null)
			i += this.left.sum();
		if (this.right != null)
			i += this.right.sum();
		return i;
	}
}
