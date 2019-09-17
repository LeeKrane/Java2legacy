package school.chif2.oopLabor.schuettbunker;

public class Schuettbunker
{
	private int pos = 0;
	private int []silos;
	private int anzSilos;
	private int anzFuellwert;
	
	public Schuettbunker (int silosAnz, int fuellwert)
	{
		this.anzSilos = silosAnz;
		this.anzFuellwert = fuellwert;
		this.silos = new int[silosAnz];
	}
	
	public void nachRechts (int i)
	{
		if (this.pos + i > anzSilos-1)
			this.pos = anzSilos-1;
		else
			this.pos += i;
	}
	
	public void nachLinks (int i)
	{
		if (this.pos - i < 0)
			this.pos = 0;
		else
			this.pos -= i;
	}
	
	public void fuell (int x)
	{
		int x2 = x;
		if (x2 > anzFuellwert)
			x2 = anzFuellwert;
		else if (x < 0)
			return;
		
		silos[pos] += x2;
	}
	
	public int gibAlles ()
	{
		int anz = silos[pos];
		silos[pos] = 0;
		return anz;
	}
	
	public String toString ()
	{
		String ausgabe = "Aktuelle Kranposition: " + (this.pos+1) + ". Silofuellwerte: ";
		
		ausgabe += silos[0];
		for (int i = 1; i < silos.length; i++)
		{
			ausgabe += ", " + silos[i];
		}
		
		return ausgabe;
	}
}
