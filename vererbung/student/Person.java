package school.chif2.vererbung.student;

public class Person
{
	private String name;
	private String vorname;
	
	public Person ()
	{
		this(null, null);
	}
	
	public Person (String name, String vorname)
	{
		this.name = name;
		this.vorname = vorname;
	}
	
	public static void main(String []args) {
		Person p1;
		p1 = new Person();
		p1.setName("Schoettle");
		p1.setVorname ("Lothar");
		System.out.println("Vorname : " + p1.getVorname());
		System.out.println ("Name : " + p1.getName());
		Person p2 = new Person("Klammer", "Franz");
		System.out.println(p2); // Ausgabe: "Klammer Franz"
	}
	
	String getVorname ()
	{
		return this.vorname;
	}
	
	String getName ()
	{
		return this.name;
	}
	
	private void setVorname (String vorname)
	{
		this.vorname = vorname;
	}
	
	private void setName (String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("Name: ").append(this.name).append(", Vorname: ").append(this.vorname);
	
		return sb.toString();
	}
}
