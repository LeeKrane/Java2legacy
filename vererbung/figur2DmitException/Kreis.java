package school.chif2.vererbung.figur2DmitException;

public class Kreis extends Figur2D
{
	private double radius;
	
	public Kreis (double radius) throws NegativException
	{
		if (radius < 0)
			throw new NegativException("Radius darf nicht kleiner 0 sein.");
		this.radius = radius;
	}
	
	public void info ()
	{
		System.out.println("Kreis mit Radius " + radius);
	}
	
	public double umfang ()
	{
		return 2 * Math.PI * radius;
	}
	
	public double flaeche ()
	{
		return Math.PI * Math.pow(radius, 2);
	}
}
