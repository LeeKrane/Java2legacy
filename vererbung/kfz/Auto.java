package school.chif2.vererbung.kfz;

public class Auto extends KFZ
{
	public Auto (String marke)
	{
		super();
		this.setMarke(marke);
	}
	
	public void info ()
	{
		if (this.getMotorLaeuft())
		{
			StringBuilder sb = new StringBuilder();
			
			sb.append("Auto ").append(this.getMarke()).append(" gestartet");
			
			System.out.println(sb.toString());
		}
	}
	
	public void starten ()
	{
		this.setMotorLaeuft(true);
	}
}
