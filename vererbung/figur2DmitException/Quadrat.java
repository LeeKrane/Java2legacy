package school.chif2.vererbung.figur2DmitException;

public class Quadrat extends Figur2D
{
	private double seite;
	
	public Quadrat (double seite) throws NegativException
	{
		if (seite < 0)
			throw new NegativException("Seite darf nicht kleiner 0 sein.");
		this.seite = seite;
	}
	
	public void info ()
	{
		System.out.println("Quadrat mit Seite " + seite);
	}
	
	public double umfang ()
	{
		return seite * 4;
	}
	
	public double flaeche ()
	{
		return Math.pow(seite, 2);
	}
}
