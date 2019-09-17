package school.chif2.vererbung.figur;

import java.util.Random;

public class Kreis extends Figur
{
	private double radius;
	
	public Kreis (double radius) throws IllegalArgumentException
	{
		if (radius <= 0)
			throw new IllegalArgumentException("");
		
		this.radius = radius;
	}
	
	public Kreis (double minRadius, double maxRadius) throws IllegalArgumentException
	{
		if (minRadius >= maxRadius || minRadius < 0)
			throw new IllegalArgumentException("");
		
		Random rand = new Random();
		this.radius = rand.nextDouble()%(maxRadius-minRadius) + minRadius;
	}
	
	public double flaeche ()
	{
		return Math.PI * Math.pow(this.radius, 2);
	}
	
	public double umfang ()
	{
		return Math.PI * this.radius * 2;
	}
	
	@Override
	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Kreis:\n");
		sb.append("Radius: ").append(this.radius).append('\n');
		sb.append("Flaeche: ").append(this.flaeche()).append('\n');
		sb.append("Umfang: ").append(this.umfang()).append('\n');
		
		return sb.toString();
	}
}
