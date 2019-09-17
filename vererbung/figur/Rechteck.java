package school.chif2.vererbung.figur;

import java.util.Random;

public class Rechteck extends Figur
{
	private double laenge;
	private double breite;
	
	public Rechteck (double laenge, double breite) throws IllegalArgumentException
	{
		if (laenge <= 0 || breite <= 0)
			throw new IllegalArgumentException("");
		
		this.laenge = laenge;
		this.breite = breite;
	}
	
	public Rechteck (double minLaenge, double maxLaenge, double minBreite, double maxBreite) throws IllegalArgumentException
	{
		if (minLaenge >= maxLaenge || minBreite >= maxBreite)
			throw new IllegalArgumentException("");
		
		Random rand = new Random();
		this.laenge = rand.nextDouble()%(maxLaenge-minLaenge) + minLaenge;
		this.breite = rand.nextDouble()%(maxBreite-minBreite) + minBreite;
	}
	
	public double flaeche ()
	{
		return this.laenge * this.breite;
	}
	
	public double umfang ()
	{
		return (this.laenge + this.breite) * 2;
	}
	
	@Override
	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Rechteck:\n");
		sb.append("Laenge: ").append(this.laenge).append('\n');
		sb.append("Breite: ").append(this.breite).append('\n');
		sb.append("Flaeche: ").append(this.flaeche()).append('\n');
		sb.append("Umfang: ").append(this.umfang()).append('\n');
		
		return sb.toString();
	}
}
