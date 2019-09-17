package school.chif2.vererbung.student;

public class Student extends Person
{
	private int matrikelnummer;
	
	public Student ()
	{
		this(null, null, 0);
	}
	
	public Student (String name, String vorname, int matrikelnummer)
	{
		super(name, vorname);
		this.matrikelnummer = matrikelnummer;
	}
	
	public static void main(String []args)
	{
		Student s1 = new Student("Huber", "Karl", 123456);
		System.out.println(s1); // Ausgabe: "Huber Karl, 123456"
		
		String[] vn = {"Alfred", "Bernd", "Carola", "Dieter", "Erich",
				"Gerda", "Hans", "Jochen", "Karin", "Maike"};
		String[] nn = {"Adler", "Baron", "Claus", "Dimov", "Eliot",
				"Gatti", "Heine","Jahn", "Kozak", "Miller"};
		int [] mn = {12345, 45671, 23456, 11111, 45667,
				98712, 23456, 65123, 12634, 22222 };
		
		Student[] students = Student.studentArrayMaker(vn, nn, mn);
		System.out.println(Student.tabellenAusgabe(students));
		
		System.out.println("\n");
		
		System.out.println("Gesuchte Studenten:");
		System.out.println(Student.tabellenAusgabe(search(students, "l")));
	}
	
	private static Student[] studentArrayMaker (String[] vnArr, String[] nnArr, int[] mnArr)
	{
		int laenge = 0;
		
		if (vnArr.length < nnArr.length)
		{
			if (vnArr.length < mnArr.length)
				laenge = vnArr.length;
			else
				laenge = mnArr.length;
		}
		else
		{
			if (nnArr.length < mnArr.length)
				laenge = nnArr.length;
			else
				laenge = mnArr.length;
		}
		
		Student[] students = new Student[laenge];
		
		for (int i = 0; i < laenge; i++)
		{
			students[i] = new Student(nnArr[i], vnArr[i], mnArr[i]);
		}
		
		return students;
	}
	
	public static Student[] search(Student[] f, String pattern)
	{
		if (f == null)
			return null;
		
		Student[] students = new Student[0];
		
		if (pattern == null)
			return null;
		
		for (int i = 0; i < f.length-1; i++)
		{
			if (f[i].getName().contains(pattern))
				students = Student.addFoundElement(students, f[i]);
		}
		
		return students;
	}
	
	private static Student[] addFoundElement(Student[] students, Student student)
	{
		if (students == null)
			return null;
		
		Student[] studentsNew = new Student[students.length+1];
		
		for (int i = 0; i < students.length; i++)
		{
			studentsNew[i] = students[i];
		}
		
		studentsNew[students.length] = student;
		
		return studentsNew;
	}
	
	@Override
	public String toString ()
	{
		StringBuilder sb = new StringBuilder(super.toString());
		
		sb.append(", Matrikelnummer: ").append(this.matrikelnummer);
		
		return sb.toString();
	}
	
	public static String tabellenAusgabe (Student[] students)
	{
		StringBuilder sb = new StringBuilder();
		int filler = 0;
		
		sb.append("Name       | Vorname    | Matrikelnummer");
		
		if (students == null)
			return null;
		
		for (int i = 0; i < students.length; i++)
		{
			sb.append('\n').append(String.format("%10s | %10s | %10d", students[i].getName(), students[i].getVorname(), students[i].matrikelnummer));
		}
		
		return sb.toString();
	}
}
