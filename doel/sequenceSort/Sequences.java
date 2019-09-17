package school.chif2.doel.sequenceSort;

public class Sequences
{
	private int []valueArray;
	private int []sequenceArray;
	private int []indexArray;
	private int maxSequence;
	
	public Sequences (int... values)
	{
		this.valueArray = new int[values.length];
		
		for (int i = 0; i < values.length; i++)
			this.valueArray[i] = values[i];
		
		this.sequenceArray = this.getSequences();
		this.maxSequence = setMaxSequence();
		this.indexArray = new int[maxSequence];
	}
	
	public static void main (String[] args)
	{
		Sequences fr = new Sequences(7, 2, 1, 3, 8, 4, 9, 1, 2, 6, 5, 9, 3, 8, 1);
		
		System.out.println(fr);
		
		fr.getIndexes();
	}
	
	private int setMaxSequence ()
	{
		int max = 0;
		
		for (int i = 0; i < this.sequenceArray.length; i++)
		{
			if (this.sequenceArray[i] > max)
				max = this.sequenceArray[i];
		}
		
		return max;
	}
	
	private boolean checkIfMoreSequencesAvailable (int index)
	{
		for (int i = index; i >= 0; i--)
		{
			if (this.sequenceArray[i] == this.maxSequence)
				return true;
		}
		
		return false;
	}
	
	private void getIndexes ()
	{
		int sequenceChecker = this.sequenceArray.length-1;
		
		do
		{
			for (int i = sequenceChecker; i >= 0; i--)
			{
				if (this.sequenceArray[i] == this.maxSequence)
				{
					this.indexArray[0] = i;
					break;
				}
			}
			
			int remover = 1;
			
			for (int i = this.indexArray[0]; i >= 0; i--)
			{
				if (this.sequenceArray[i] == this.sequenceArray[this.indexArray[0]] - remover)
				{
					this.addIndex(i);
					remover++;
				}
			}
			
			System.out.println(this.toIndexString());
			
			sequenceChecker = this.indexArray[0]-1;
		}
		while (this.checkIfMoreSequencesAvailable(sequenceChecker));
	}
	
	private void addIndex (int value)
	{
		for (int i = 0; i < this.indexArray.length; i++)
		{
			if (this.indexArray[i] == 0)
			{
				this.indexArray[i] = value;
				break;
			}
		}
	}
	
	private int[] getSequences ()
	{
		int []arr = new int[this.valueArray.length];
		
		for (int i = 0; i < this.valueArray.length; i++)
		{
			arr[i] = 0;
			
			for (int j = i-1; j >= 0; j--)
			{
				if (this.valueArray[i] > this.valueArray[j] && arr[i] < arr[j])
					arr[i] = arr[j];
			}
			
			arr[i]++;
		}
		
		return arr;
	}
	
	@Override
	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("[").append(this.valueArray[0]);
		for (int i = 1; i < this.valueArray.length; i++)
		{
			sb.append(",  ").append(this.valueArray[i]);
		}
		sb.append("]").append('\n');
		
		sb.append("[").append(this.sequenceArray[0]);
		for (int i = 1; i < this.sequenceArray.length; i++)
		{
			sb.append(",  ").append(this.sequenceArray[i]);
		}
		sb.append("]").append('\n').append('\n');
		
		return sb.toString();
	}
	
	public String toIndexString ()
	{
		StringBuilder sb = new StringBuilder();
		
		if (this.indexArray[0] < 10)
			sb.append(" ");
		sb.append(this.indexArray[0]);
		for (int i = 1; i < this.indexArray.length; i++)
		{
			if (this.indexArray[i] < 10)
				sb.append(",  ").append(this.indexArray[i]);
			else
				sb.append(", ").append(this.indexArray[i]);
		}
		sb.append('\n');
		
		sb.append("[").append(this.valueArray[indexArray[0]]);
		for (int i = 1; i < this.indexArray.length; i++)
		{
			sb.append(",  ").append(this.valueArray[indexArray[i]]);
		}
		sb.append("]").append('\n');
		
		sb.append("[").append(this.sequenceArray[indexArray[0]]);
		for (int i = 1; i < this.indexArray.length; i++)
		{
			sb.append(",  ").append(this.sequenceArray[indexArray[i]]);
		}
		sb.append("]").append('\n').append('\n');
		
		return sb.toString();
	}
}
