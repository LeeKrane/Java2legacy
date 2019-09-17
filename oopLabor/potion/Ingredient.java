package school.chif2.oopLabor.potion;

public class Ingredient
{
	private String name;
	
	public Ingredient (String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString ()
	{
		return this.name;
	}
	
	public String getName ()
	{
		return this.name;
	}
	
	public void setName (String name)
	{
		this.name = name;
	}
	
	public int power ()
	{
		return this.name.length();
	}
}
