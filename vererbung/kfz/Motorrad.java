package school.chif2.vererbung.kfz;

public class Motorrad extends KFZ
{
	public Motorrad (String marke)
	{
		super();
		this.setMarke(marke);
	}
	
	public void info ()
	{
		if (!this.getMotorLaeuft())
		{
			StringBuilder sb = new StringBuilder();
			
			sb.append("Motorrad ").append(this.getMarke()).append(" nicht gestartet");
			
			System.out.println(sb.toString());
		}
	}
	
	public void starten ()
	{
		this.setMotorLaeuft(true);
	}
}