package school.chif2.vererbung.figur2DmitException;

public abstract class ErbeVonFigur2D extends Figur2D
{
	private static char []art = {'k', 'q', 'q', 'q', 'k', 'q', 'k', 'k', 'q', 'q'};
	private static double []len = {3.8, 3.6, 2.5, 1.2, 4.5, 3.7, 4.5, 5.2, 3.8, 1.5};
	private static double []len2 = {3.8, -3.6, 2.5, -1.2, 4.5, 3.7, -4.5, 5.2, 3.8, 1.5};
	
	public static void main (String[] args)
	{
		erstellenUndBerechnen(art, len);
		erstellenUndBerechnen(art, len2);
	}
	
	private static void erstellenUndBerechnen (char []artenDerFiguren, double []werteDerFiguren)
	{
		Figur2D []figures = new Figur2D[artenDerFiguren.length];
		double quadratUmfaenge = 0;
		double kreisFlaechen = 0;
		
		for (int i = 0; i < figures.length; i++)
		{
			try
			{
				if (artenDerFiguren[i] == 'k')
					figures[i] = new Kreis(werteDerFiguren[i]);
				else
					figures[i] = new Quadrat(werteDerFiguren[i]);
			}
			catch (NegativException ne)
			{
				System.err.println(ne);
			}
		}
		
		for (int i = 0; i < figures.length; i++)
		{
			if (figures[i] != null)
			{
				figures[i].info();
				
				if (figures[i] instanceof Kreis)
					kreisFlaechen += figures[i].flaeche();
				else if (figures[i] instanceof Quadrat)
					quadratUmfaenge += figures[i].umfang();
			}
		}
		
		System.out.println("Umfänge aller erstellten Quadrate -> " + quadratUmfaenge);
		System.out.println("Flächen aller erstellten Kreise -> " + kreisFlaechen + '\n');
	}
}
