package package2_17;

public class Main
{
	public static void main(String []args) {
		Figur f1 = new Kreis(3.0, 4.0, 5.0); // M(3/4) r = 5
		Figur f2 = new Rechteck(3.0, 4.0, 5.0, 6.0);
		// O(3/4) l = 5 b = 6
		System.out.println(f1); // Kreis(3.0/4.0;5.0)
		f1.translate(1.0, 2.0);
		System.out.println(f1); // Kreis(4.0/6.0;5.0)
		f1.scale(1.5);
		System.out.println(f1); // Kreis(4.0/6.0;7.5)
		System.out.println(f2); // Rechteck(3.0/4.0;5.0;6.0)
		f2.translate(2.0, 3.0);
		System.out.println(f2); // Rechteck(5.0/7.0;5.0;6.0)
		f2.scale(2);
		System.out.println(f2); // Rechteck(5.0/7.0;10.0;12.0)
	}
}
