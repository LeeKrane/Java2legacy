package school.chif2.vererbung.figur;

import java.util.Random;

public class FigurTest
{
	public static void main (String[] args)
	{
		Figur[] fig = new Figur[20];
		Random rand = new Random();
		double sumFlaechen = 0;
		double sumUmfaenge = 0;
		
		for (int i = 0; i < fig.length; i++)
		{
			int j = rand.nextInt()%2;
			
			if (j == 0)
				fig[i] = new Kreis(0, 20);
			else
				fig[i] = new Rechteck(0, 20, 0, 20);
		}
		
		for (int i = 0; i < fig.length; i++)
		{
			System.out.println(fig[i]);
			sumFlaechen += fig[i].flaeche();
			sumUmfaenge += fig[i].umfang();
		}
		
		System.out.println("Summe aller Flächen: " + sumFlaechen);
		System.out.println("Summe alle Umfänge: " + sumUmfaenge);
	}
}