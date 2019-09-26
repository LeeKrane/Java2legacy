package package2_19;

import java.util.Random;

public class Main
{
	private Speaker []speakers;
	
	public static void main (String[] args)
	{
		Main m = new Main();
		
		System.out.println(m);
	}
	
	public Main ()
	{
		speakers = new Speaker[100];
		Random zufall = new Random();
		int j;
		
		for (int i = 0; i < 100; i++)
		{
			j = zufall.nextInt()%3;
			
			if (j == 0)
				speakers[i] = new Person();
			else if (j == 1)
				speakers[i] = new Dog();
			else
				speakers[i] = new Cat();
		}
	}
	
	public static boolean isHuman(Speaker s)
	{
		if (s.getClass() == Person)
		
		return false;
	}
	
	@Override
	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < this.speakers.length; i++)
		{
			sb.append(this.speakers[i].speaker()).append('\n');
		}
		
		return sb.toString();
	}
}
