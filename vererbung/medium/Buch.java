package school.chif2.vererbung.medium;

public class Buch extends Medium
{
	private int seiten;
	
	public Buch ()
	{
		this("Unbekannt");
	}
	
	public Buch (String bezeichnung)
	{
		this(bezeichnung, 0.0);
	}
	
	public Buch (String bezeichnung, double preis)
	{
		this(bezeichnung, preis, 0);
	}
	
	public Buch (String bezeichnung, double preis, int seiten)
	{
		super(bezeichnung, preis);
		this.seiten = seiten;
	}
	
	public void info ()
	{
		System.out.println("------------------------------------");
		System.out.println("Buch:      " + this.getBezeichnung());
		System.out.println("Preis:     " + this.getPreis() + " Euro");
		System.out.println("Seiten:    " + this.seiten);
	}
	
	public int compareTo (Medium other)
	{
		if (this.getPreis() < other.getPreis())
			return -1;
		else if (this.getPreis() == other.getPreis())
			return 0;
		else
			return 1;
	}
}
