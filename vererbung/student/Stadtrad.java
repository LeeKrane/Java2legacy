package school.chif2.vererbung.student;

public class Stadtrad extends Fahrrad
{
	private boolean licht;
	
	public Stadtrad ()
	{
		this("Unassigned", "Unassigned", false);
	}
	
	public Stadtrad (String fahrer, String farbe, boolean lichtPower)
	{
		super(fahrer, farbe);
		licht = lichtPower;
	}
	
	public void setLicht (boolean power)
	{
		this.licht = power;
	}
	
	public boolean isLicht ()
	{
		return licht;
	}
	
	public static void main(String args[]) {
		Fahrrad r = new Stadtrad("Thomas","schwarz", false);
		r.lenken(10);
		r.beschleunigen(0.3,9.8);
		((Stadtrad)r).setLicht(true);
		System.out.println(r);
	}
	
	@Override
	public String toString ()
	{
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append(", Licht: ").append(this.licht ? "an" : "aus");
		
		return sb.toString();
	}
}
