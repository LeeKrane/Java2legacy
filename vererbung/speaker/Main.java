package school.chif2.vererbung.speaker;

import java.util.Random;

public class Main
{
	private Speaker []speakers;
	private int humans;
	
	public static void main (String[] args)
	{
		Main ref = new Main();
		
		for (int i = 0; i < ref.speakers.length; i++)
		{
			if (isHuman(ref.speakers[i]))
				System.out.println("Speakers[" + i + "] is an instance of a Human!");
			try
			{
				System.out.println(ref.speakers[i].speaker() + '\n');
			}
			catch (DumbException de)
			{
				System.err.println("This person is dumb!");
			}
		}
		System.out.println("\nThere are " + ref.humans + " in this Array!");
	}
	
	public Main ()
	{
		this.humans = 0;
		this.speakers = new Speaker[100];
		Random zufall = new Random();
		int j;
		
		for (int i = 0; i < 100; i++)
		{
			j = zufall.nextInt()%3;
			
			if (j == 0)
			{
				if (isDumb())
					this.speakers[i] = new Persoon(true);
				else
					this.speakers[i] = new Persoon(false);
			}
			else if (j == 1)
				this.speakers[i] = new Dog();
			else
				this.speakers[i] = new Cat();
		}
	}
	
	public static boolean isHuman (Speaker s)
	{
		return s instanceof Persoon;
	}
	
	private boolean isDumb ()
	{
		Random zufall = new Random();
		int j = zufall.nextInt()%100;
		
		return j < 5;
	}
}
