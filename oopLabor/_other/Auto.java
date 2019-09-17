package school.chif2.oopLabor._other;

public class Auto
{
	private String typ;
	private boolean motorAn;
	
	@Override
	public String toString ()
	{
		String motor = "aus";
		if (this.motorAn)
			motor = "an";
		
		return this.typ + ", Motor " + motor;
	}
	
	public Auto (String typ, boolean motorAn)
	{
		this.typ = typ;
		this.motorAn = motorAn;
	}
	
	public Auto (String typ)
	{
		this.typ = typ;
		this.motorAn = false;
	}
	
	public void starten ()
	{
		this.motorAn = true;
	}
	
	public void abstellen ()
	{
		this.motorAn = false;
	}
	
	public static void main(String args[]) {
		Auto a1 = new Auto("BMW"); // BMW, Motor aus
		Auto a2 = new Auto("Porsche", true); // Porsche, Motor an
		System.out.println(a1); //Ausgabe: BMW, Motor aus
		a1.starten();
		System.out.println(a1); //Ausgabe: BMW, Motor an
		System.out.println(a2); //Ausgabe: Porsche, Motor an
		a2.abstellen();
		System.out.println(a2); //Ausgabe: Porsche, Motor aus
	}
}
