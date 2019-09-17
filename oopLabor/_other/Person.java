package school.chif2.oopLabor._other;

import java.time.LocalDate;

public class Person
{
	private String zuname;
	private String vorname;
	private int geb;
	
	@Override
	public String toString()
	{
		return (this.zuname + " " + this.vorname);
	}
	
	public Person ()
	{
		this.vorname = "N.N.";
		this.zuname = "N.N.";
		this.geb = 0;
	}
	
	public Person (String zuname, String vorname, int geb)
	{
		this.zuname = zuname;
		this.vorname = vorname;
		this.geb = geb;
	}
	
	public Person (String zuname, int geb)
	{
		this.vorname = "N.N.";
		this.zuname = zuname;
		this.geb = geb;
	}
	
	public Person (int geb)
	{
		this.vorname = "N.N.";
		this.zuname = "N.N.";
		this.geb = geb;
	}
	
	public void setVorname (String vorname)
	{
		this.vorname = vorname;
	}
	
	public void setZuname (String zuname)
	{
		this.zuname = zuname;
	}
	
	public int getAlter ()
	{
		LocalDate today = LocalDate.now();
		int todayYear = today.getYear();
		return todayYear - this.geb;
	}
	
	public boolean gleichAlt (Person p)
	{
		if (this.geb == p.geb)
			return true;
		return false;
	}
	
	public static boolean gleichAlt (Person p1, Person p2)
	{
		if (p1.geb == p2.geb)
			return true;
		return false;
	}
	
	public static void main (String[] args)
	{
		Person p = new Person(); // name = vorname = "N.N.", geb = 0
		Person p1 = new Person(1978); // name = vorname = "N.N."
		Person p2 = new Person("Maier", 1967); // vorname = "N.N."
		Person p3 = new Person("Schmidt", "Franz", 1967);
		p1.setZuname("Bauer");
		p1.setVorname("Hans");
		p2.setVorname("Eva");
		System.out.println(p1 + " ist " + p1.getAlter() + " Jahre alt.");
		if (p2.gleichAlt(p3))  // Instanzmethode gleichAlt()
		{
			System.out.println(p2 + " und " + p3 + " sind gleich alt.");
		}
		if (Person.gleichAlt(p2,p3))  // Klassenmethode gleichAlt()
		{
			System.out.println(p2 + " und " + p3 + " sind gleich alt.");
		}
	}
}
