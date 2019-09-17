package school.chif2.rekursionen;

public class Rekursionen
{
	private double divisor;
	private boolean positive;
	
	public Rekursionen ()
	{
		this.divisor = 1;
		this.positive = true;
	}
	
	double rekursivEins (int index)
	{
		double value = 0;
		
		if (index <= 0)
			return 0;
		
		if (index > 1)
		{
			if (positive)
				value += rekursivEins(index-1);
			else
				value -= rekursivEins(index-1);
			
			divisor += 2;
			positive = !positive;
		}
		
		if (positive)
			value += 1/ divisor;
		else
			value -= 1/ divisor;
		
		return value;
	}
	
	int fib (int index)
	{
		if (index <= 2 && index >= 1)
			return 1;
		else if (index == 0)
			return 0;
		
		return fib(index-1) + fib(index-2);
	}
	
	int ggT (int x, int y)
	{
		if (y == 0)
			return x;
		
		return ggT(y, x%y);
	}
	
	int pa (int n, int k)
	{
		if (k > n || n < 0 || k < 0)
			return 0;
		
		if (k == 0 || k == n || n == 0)
			return 1;
		
		return pa(n-1, k-1) + pa(n-1, k);
	}
	
	public static void main (String[] args)
	{
		Rekursionen rek = new Rekursionen();
		
		System.out.println(rek.rekursivEins(-1));
		System.out.println("rekursive Zahl (1 / +-(1,3,5...) 5");
		System.out.println(rek.rekursivEins(5));
		System.out.println();
		System.out.println("Fibonachi Zahl 6");
		System.out.println(rek.fib(6));
		System.out.println();
		System.out.println("ggT von 52 und 36");
		System.out.println(rek.ggT(52, 36));
		System.out.println();
	
		System.out.println("Wert des Pascalschen Dreiecks an der Stelle [5, 3]");
		System.out.println(rek.pa(5, 3));
		System.out.println();
		
		System.out.println("rekursive Zahlen (1 / +-(1,3,5...) von 0 bis 7");
		rek.rekursivEinsAufruf(7);
		
		System.out.println();
		
		System.out.println("Fibonachizahlen von 0 bis 7");
		rek.fibAufruf(7);
	}
	
	public void rekursivEinsAufruf (int index)
	{
		for (int i = 0; i < index; i++)
		{
			System.out.println(this.rekursivEins(i));
		}
	}
	
	public void fibAufruf (int index)
	{
		for (int i = 0; i < index; i++)
		{
			System.out.println(this.fib(i));
		}
	}
}
