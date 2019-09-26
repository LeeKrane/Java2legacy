package package2_17;

public class Rechteck extends Figur
{
	private double breite;
	private double hoehe;
	
	public Rechteck ()
	{
		this(0, 0, 0, 0);
	}
	
	public Rechteck (double x, double y, double breite, double hoehe)
	{
		super(x, y);
		if (breite < 0)
			throw new IllegalArgumentException("The Width can not be scaled to a negative value!");
		if (hoehe < 0)
			throw new IllegalArgumentException("The Height can not be scaled to a negative value!");
		
		this.breite = breite;
		this.hoehe = hoehe;
	}
	
	public void scale (double s)
	{
		if (this.breite * s < 0)
			throw new IllegalArgumentException("The Width can not be scaled to a negative value!");
		if (this.hoehe * s < 0)
			throw new IllegalArgumentException("The Height can not be scaled to a negative value!");
		
		this.breite *= s;
		this.hoehe *= s;
	}
	@Override
	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Rechteck(");
		sb.append(this.getX()).append("/").append(this.getY()).append(";");
		sb.append(this.breite).append(";").append(this.hoehe).append(")");
		
		return sb.toString();
	}
}
