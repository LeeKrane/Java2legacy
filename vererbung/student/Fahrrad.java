package school.chif2.vererbung.student;

public class Fahrrad
{
	private String fahrer;
	private String farbe;
	private int richtung;
	private double geschwindigkeit;
	
	public Fahrrad ()
	{
		this("Unassigned", "Unassigned");
	}
	
	public Fahrrad (String fahrer, String farbe)
	{
		this.fahrer = fahrer;
		this.farbe = farbe;
	}
	
	public void lenken (int deltaR)
	{
		this.richtung += deltaR;
	}
	
	public void beschleunigen (double a, double sec)
	{
		this.geschwindigkeit = (this.geschwindigkeit + a) * sec;
	}
	
	public double getKmh ()
	{
		return geschwindigkeit * 3.6;
	}
	
	public static void main(String []args) {
		Fahrrad r = new Fahrrad("Strampler", "blau");
		r.lenken(10);
		r.beschleunigen(0.3,9.8); // v = v + 0.3 * 9.8
		System.out.println(r);
	}
	
	@Override
	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Fahrer: ").append(this.fahrer).append(", ");
		sb.append("Farbe: ").append(this.farbe).append(", ");
		sb.append("Richtung: ").append(this.richtung).append(", ");
		sb.append("kmh: ").append(this.getKmh());
		
		return sb.toString();
	}
}
