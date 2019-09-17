package school.chif2.oopLabor.rectangle;

public class Rectangle
{
	private double length = 1.0;
	private double width = 1.0;
	
	public void setLength (double length)
	{
		if (!(length >= 1.0 && length <= 20.0))
		{
			if (length < 1.0)
			{
				this.length = 1.0;
				System.out.println("Die angegebene Length ist zu klein und wurde auf 1.0 gesetzt!");
			}
			else
			{
				this.length = 20.0;
				System.out.println("Die angegebene Length ist zu groß und wurde auf 20.0 gesetzt!");
			}
		}
		else
		{
			this.length = length;
		}
	}
	
	public void setWidth (double width)
	{
		if (!(width >= 1.0 && width <= 20.0))
		{
			if (width < 1.0)
			{
				this.width = 1.0;
				System.out.println("Die angegebene Width ist zu klein und wurde auf 1.0 gesetzt!");
			}
			else
			{
				this.width = 20.0;
				System.out.println("Die angegebene Width ist zu groß und wurde auf 20.0 gesetzt!");
			}
		}
		else
		{
			this.width = width;
		}
	}
	
	public double getLength ()
	{
		return this.length;
	}
	
	public double getWidth ()
	{
		return this.width;
	}
	
	public double umfang ()
	{
		return (this.length + this.width)*2;
	}
	
	public double surface ()
	{
		return this.length * this.width;
	}
}
