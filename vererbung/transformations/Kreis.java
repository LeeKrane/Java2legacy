package school.chif2.vererbung.transformations;

public class Kreis extends Figur
{
	private double r;
	
	public Kreis ()
	{
		this(0, 0, 0);
	}
	
	public Kreis (double x, double y, double r)
	{
		super(x, y);
		if (r < 0)
			throw new IllegalArgumentException("The Radius can not be scaled to a negative value!");
		this.r = r;
	}
	
	public void scale (double s)
	{
		if (this.r * s >= 0)
			this.r *= s;
		else
			throw new IllegalArgumentException("The Radius can not be scaled to a negative value!");
	}
	
	@Override
	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Kreis(");
		sb.append(this.getX()).append("/").append(this.getY()).append(";");
		sb.append(this.r).append(")");
		
		return sb.toString();
	}
}
