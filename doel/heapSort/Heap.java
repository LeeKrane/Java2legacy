package school.chif2.doel.heapSort;

import java.util.Arrays;

public class Heap implements HeapInterface
{
	private int[] heapTree;
	private int swapVar;
	
	public Heap ()
	{
		this(1,9,2,8,3,7,4);
	}
	
	public Heap (int... values)
	{
		this.heapTree = new int[values.length];
		
		for (int i = 0; i < values.length; i++)
		{
			this.heapTree[i] = values[i];
		}
		
		int n = this.heapTree.length;
		
		this.heapify();
		while (n > 1)
		{
			this.swapVar = this.heapTree[n-1];
			this.heapTree[n-1] = this.heapTree[0];
			this.heapTree[0] = this.swapVar;
			n--;
			versickern(n, 0);
		}
	}
	
	public void heapify ()
	{
		for (int i = this.heapTree.length; i >= 0; i--)
		{
			versickern(this.heapTree.length, i);
		}
	}
	
	public int right (int i)
	{
		return (i + 1) * 2;
	}
	
	public int left (int i)
	{
		return (i + 1) * 2 - 1;
	}
	
	public void versickern (int n, int i)
	{
		boolean end = false;
		
		while (i < n/2 && !end)
		{
			int max = i;
			int r = this.right(i);
			int l = this.left(i);
			
			if (l < n && this.heapTree[max] < this.heapTree[l])
				max = l;
			if (r < n && this.heapTree[max] < this.heapTree[r])
				max = r;
			if (max != i)
			{
				this.swapVar = this.heapTree[i];
				this.heapTree[i] = this.heapTree[max];
				this.heapTree[max] = this.swapVar;
				i = max;
			}
			else
				end = true;
		}
	}
	
	@Override
	public String toString ()
	{
		return Arrays.toString(this.heapTree);
	}
	
	public static void main (String[] args)
	{
		Heap h = new Heap(8,2,3,4,5,6,7);
		
		System.out.println(h);
	}
}
