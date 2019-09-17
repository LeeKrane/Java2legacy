package school.chif2.vererbung.student;

public class Kontoo
{
	private double kontostand;
	private Person inhaber;
	
	public Kontoo ()
	{
		this(null, null, 0);
	}
	
	public Kontoo (String name, String vorname, double amount)
	{
		this.inhaber = new Person(name, vorname);
		this.kontostand = amount;
	}
	
	public static void main(String []args) {
		Kontoo konto1 = new Kontoo("Schmidt", "Hans", 500.0);
		Kontoo konto2 = new Kontoo("Krause", "Peter", 1500.0);
		Kontoo konto3 = new Kontoo("Bauer", "Harald", 500.0);
		Kontoo.vergleich(konto1, konto2);
		Kontoo.vergleich(konto2, konto3);
		Kontoo.vergleich(konto1, konto3);
	}
	
	private static void vergleich (Kontoo konto1, Kontoo konto2)
	{
		if (konto1.kontostand > konto2.kontostand)
			System.out.println(konto1.inhaber + " hat mehr Geld auf dem Kontoo als " + konto2.inhaber);
		else if (konto1.kontostand < konto2.kontostand)
			System.out.println(konto2.inhaber + " hat mehr Geld auf dem Kontoo als " + konto1.inhaber);
		else
			System.out.println(konto1.inhaber + " und " + konto2.inhaber + " haben den gleichen Kontostand");
	}
}
