package package2_17;

public abstract class Figur implements Transformations
{
	private double x;
	private double y;
	
	public Figur ()
	{
		this(0, 0);
	}
	
	public Figur (double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void translate (double x, double y)
	{
		this.x += x;
		this.y += y;
	}
	
	public double getX ()
	{
		return this.x;
	}
	
	public double getY ()
	{
		return this.y;
	}
}
