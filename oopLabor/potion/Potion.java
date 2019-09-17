package school.chif2.oopLabor.potion;

public class Potion
{
	private Ingredient[] ings = new Ingredient[3];
	private int stirred = 0;
	
	public Potion (Ingredient ing1, Ingredient ing2, Ingredient ing3)
	{
		ings[0] = ing1;
		ings[1] = ing2;
		ings[2] = ing3;
	}
	
	@Override
	public String toString ()
	{
		String fertig = "nicht fertiggestellt!";
		int power = 0;
		
		for (int i = 0; i < 3; i++)
		{
			power += ings[i].power();
		}
		
		if (ready())
		{
			fertig = "fertiggestellt!";
			power *= 2;
		}
		
		return "Zutaten: " + ings[0].getName() + ", " + ings[1].getName() + ", " + ings[2].getName() + ". Der Trank wurde " + fertig + " Seine Stärke ist " + power + ".";
	}
	
	public void stir ()
	{
		stirred++;
	}
	
	public boolean ready ()
	{
		if (stirred == 5)
			return true;
		return false;
	}
}
