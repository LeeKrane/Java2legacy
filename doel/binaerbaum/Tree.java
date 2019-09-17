package school.chif2.doel.binaerbaum;

public class Tree
{
	private Node root = null;
	
	public boolean insert (int value)
	{
		if (root == null)
		{
			root = new Node(value);
			return true;
		}
		return root.insert(value);
	}
	
	public int sum ()
	{
		return root.sum();
	}
	
	public void list ()
	{
		if (root == null)
			System.err.println("The Binary Tree is empty!");
		else
			root.list();
	}
	
	public boolean delete (int value)
	{
		if (this.root == null)
			return false;
		else if (this.root.getData() == value)
		{
			this.root = this.root.delete();
			return true;
		}
		return this.root.delete(value);
	}
	
	public static void main (String[] args)
	{
		Tree a = new Tree();
		int []arr = {15,1,14,2,13,3,12,4,11,5,10,6,9,7,8};
		int []arr2 = {15,1,13,3,11,5,9};
		int []arr3 = {17, 0, 3};
		
		for (int i = 0; i < arr.length; i++)
		{
			a.insert(arr[i]);
		}
		for (int i = 0; i < arr2.length; i++)
		{
			a.delete(arr2[i]);
		}
		for (int i = 0; i < arr3.length; i++)
		{
			a.insert(arr3[i]);
		}
		a.list();
		Tree b = new Tree();
		b.list();
		System.out.println(a.sum());
	}
}
