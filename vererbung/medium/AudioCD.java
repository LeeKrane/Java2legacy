package school.chif2.vererbung.medium;

public class AudioCD extends Medium
{
	private double spielzeit;
	
	public AudioCD ()
	{
		this("Unbekannt");
	}
	
	public AudioCD (String bezeichnung)
	{
		this(bezeichnung, 0.0);
	}
	
	public AudioCD (String bezeichnung, double preis)
	{
		this(bezeichnung, preis, 0);
	}
	
	public AudioCD (String bezeichnung, double preis, double spielzeit)
	{
		super(bezeichnung, preis);
		this.spielzeit = spielzeit;
	}
	
	public void info ()
	{
		System.out.println("------------------------------------");
		System.out.println("AudioCD:   " + this.getBezeichnung());
		System.out.println("Preis:     " + this.getPreis() + " Euro");
		System.out.println("Spielzeit: " + this.spielzeit + " Minuten");
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
