package school.chif2.vererbung.speaker;

public class Persoon implements Speaker
{
	private boolean dumb;
	
	public Persoon (boolean dumb)
	{
		this.dumb = dumb;
	}
	
	public String speaker () throws DumbException
	{
		if (this.dumb)
			throw new DumbException(" ");
		
		return "Hallo";
	}
}
