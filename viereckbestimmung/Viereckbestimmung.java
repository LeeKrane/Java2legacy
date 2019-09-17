package school.chif2.viereckbestimmung;

import java.util.Scanner;

/*
 * Allgemeines Viereck:	[10/10], [0/11], [-7/-2], [13/-7]
 * Parallelogramm:		[7/3], [1/3], [0/0], [6/0]
 * Rechteck:			[6/3], [0/3], [0/0], [6/0]
 * Quadrat:				[3/3], [0/3], [0/0], [3/0]
 * Raute:				[6/3], [1/3], [-2/-1], [3/-1]
 * Deltoid:				[0/6], [-2/4], [0/0], [2/4]
 *
 * Entartetes Viereck:
 * 		Dreieck:		[0/6], [-3/0], [3/0], [0/6]
 * 		Strich:			[3/0], [3/0], [0/0], [0/0]
 * 		Punkt:			[0/0], [0/0], [0/0], [0/0]
 */

public class Viereckbestimmung {
	
	/**
	 * Diese Methode dient dazu, ander Methoden aufzurufen um Punkte einzulesen.
	 * Danach gibt diese Methode die Vierecksart aus.
	 * @param args Argumente die durch das Aufrufen des Programms per CMD übergeben werden.
	 */

	public static void main (String[] args)
	{
		Punkt[] p = new Punkt[4];
		String type;
		double xBackUp = 0;
		
		for (int i = 0; i < p.length; i++)
		{
			System.out.println("Punkt " + (i+1) + ":");
			p[i] = liesPunkt();
			while (p[i] == null)
				p[i] = liesPunkt();
		}
		
		// Identifizierung des Viereck-Typs
		// Viereck
		if (isViereck(p))
		{
			// Parallelogramm
			if (isParallelogramm(p))
			{
				// Rechteck
				if (isRechteck(p))
				{
					// Quadrat
					// type --> Quadrat
					if (isQuadrat(p))
					{
						type = "Quadrat";
					}
					// type --> Rechteck
					else
					{
						type = "Rechteck";
					}
				}
				// Raute
				else if (isRaute(p))
				{
					// Quadrat
					// type --> Quadrat
					if (isQuadrat(p))
					{
						type = "Quadrat";
					}
					// type --> Raute
					else
					{
						type = "Raute";
					}
				}
				// type --> Parallelogramm
				else
				{
					type = "Parallelogramm";
				}
			}
			// Deltoid
			else if (isDeltoid(p))
			{
				// Raute
				if (isRaute(p))
				{
					// Quadrat
					// type --> Quadrat
					if (isQuadrat(p))
					{
						type = "Quadrat";
					}
					// type --> Raute
					else
					{
						type = "Raute";
					}
				}
				// type --> Deltoid
				else
				{
					type = "Deltoid";
				}
			}
			// type --> Viereck
			else
			{
				type = "allgemeines Viereck";
			}
		}
		// entartetes Viereck
		else
		{
			type = "entartetes Viereck";
		}
		
		System.out.format('\n' + "Die eingelesenen Punkte: " + '\n');
		
		for (int i = 0; i < p.length; i++)
		{
			System.out.println(i + ": " + p[i]);
		}
		
		System.out.printf("bilden ein");
		if (type.equals("Raute"))
			System.out.format("e");
		System.out.println(" " + type + '!');
	}
	
	/**
	 * Diese Methode prüft, ob das Objekt ein Viereck ist.
	 * @param p ist das Punkt Array, was alle 4 eingelesenen Punkte des Objekts enthält.
	 * @return true, wenn alle Seiten > 0 sind. Sonst false --> entartes Viereck.
	 */
	
	static boolean isViereck (Punkt[] p)
	{
		if (checker(p, 1))
			return true;
		return false;
	}
	
	/**
	 * Diese Methode prüft, ob das Objekt ein Quadrat ist.
	 * @param p ist das Punkt Array, was alle 4 eingelesenen Punkte des Objekts enthält.
	 * @return true, wenn alle Seiten > 0 sind und die Seiten (a, b, c, d) sowie (e, f) gleich sind.
	 */
	
	static boolean isQuadrat (Punkt[] p)
	{
		if (checker(p, 2))
			return true;
		return false;
	}
	
	/**
	 * Diese Methode prüft, ob das Objekt ein Rechteck ist.
	 * @param p ist das Punkt Array, was alle 4 eingelesenen Punkte des Objekts enthält.
	 * @return true, wenn alle Seiten > 0 sind und die Seiten (a, c) sowie (b, d) sowie (e, f) gleich sind.
	 */
	
	static boolean isRechteck (Punkt[] p)
	{
		if (checker(p, 3))
			return true;
		return false;
	}
	
	/**
	 * Diese Methode prüft, ob das Objekt ein Parallelogramm ist.
	 * @param p ist das Punkt Array, was alle 4 eingelesenen Punkte des Objekts enthält.
	 * @return true, wenn alle Seiten > 0 sind und die Seiten (a, c) sowie (b, d) gleich sind.
	 */
	
	static boolean isParallelogramm (Punkt[] p)
	{
		if (checker(p, 4))
			return true;
		return false;
	}
	
	/**
	 * Diese Methode prüft, ob das Objekt eine Raute ist.
	 * @param p ist das Punkt Array, was alle 4 eingelesenen Punkte des Objekts enthält.
	 * @return true, wenn alle Seiten > 0 sind und die Seiten (a, b, c, d) gleich sind.
	 */
	
	static boolean isRaute (Punkt[] p)
	{
		if (checker(p, 5))
			return true;
		return false;
	}
	
	/**
	 * Diese Methode prüft, ob das Objekt ein Deltoid ist.
	 * @param p ist das Punkt Array, was alle 4 eingelesenen Punkte des Objekts enthält.
	 * @return true, wenn alle Seiten > 0 sind und die Seiten ((a, d) sowie (b, c)) ODER ((a, b) sowie (c, d)) gleich sind. Die Seitenvergleichungen sind a,d & b,c ODER a,b & c,d aufgrund von der Möglichkeit, das Objekt IM oder GEGEN den Uhrzeigersinn einzugeben.
	 */
	
	static boolean isDeltoid (Punkt[] p)
	{
		if (checker(p, 6))
			return true;
		return false;
	}
	
	/**
	 * Diese Methode liest einen Punkt mit zwei DOUBLE Werten (x und y) ein.
	 * Falls etwas anderes eingegeben wird, wird ein Fehler ausgegeben und man muss den ganzen Punkt neu eingeben.
	 * @return Der eingelesene Punkt wird returned. Falls ein Fehler auftritt, wird NULL returned
	 */
	
	static Punkt liesPunkt ()
	{
		Punkt p = new Punkt();
		Scanner scan = new Scanner(System.in);
		
		System.out.format("x --> ");
		if (scan.hasNextDouble())
			p.x = scan.nextDouble();
		else
		{
			errorReport();
			return null;
		}
		
		System.out.format("y --> ");
		if (scan.hasNextDouble())
			p.y = scan.nextDouble();
		else
		{
			errorReport();
			return null;
		}
		
		System.out.println();
		
		return p;
	}
	
	/**
	 * Diese Methode überprüft ob einer der übergebenen Punkte NULL ist.
	 * @param p Punkte Array, aus der Punkte auf NULL überprüft werden.
	 * @return Falls einer der Punkte im übergebenen Punkte Array NULL ist, true. Sonst false.
	 */
	
	private static boolean isNull (Punkt[] p)
	{
		if (p == null)
			return true;
		
		for (int i = 0; i < p.length; i++)
		{
			if (p[i] == null)
				return true;
		}
		
		return false;
	}
	
	/**
	 * Diese Methode überprüft das Punkte Array auf ein spezifisches Objekt, das durch einen Index (type) identifiziert wird.
	 * @param p ist das Punkt Array, was alle 4 eingelesenen Punkte des Objekts enthält.
	 * @param type ist der Wert um zu identifizieren, auf welches Objekt man das Punkte Array überprüfen soll.
	 * @return true, wenn das Punke Array das spezifische Objekt bildet. False, wenn dem nicht so ist.
	 */
	
	private static boolean checker (Punkt[] p, int type)
	{
		double a, b, c, d, e, f;
		boolean objectIdentifier;
		
		if (isNull(p))
			return false;
		
		a = distanz(p[0], p[1]);
		b = distanz(p[1], p[2]);
		c = distanz(p[2], p[3]);
		d = distanz(p[3], p[0]);
		e = distanz(p[0], p[2]);
		f = distanz(p[1], p[3]);
		
		double eps = 0.000001;
		
		switch (type)
		{
			case 1: // isViereck
				objectIdentifier = true;
				break;
			case 2: // isQuadrat
				objectIdentifier = (isEqual(eps, a, b, c, d) && isEqual(eps, e, f));
				break;
			case 3: // isRechteck
				objectIdentifier = (isEqual(eps, a, c) && isEqual(eps, b, d) && isEqual(eps, e, f));
				break;
			case 4: // isParallelogramm
				objectIdentifier = (isEqual(eps, a, c) && isEqual(eps, b, d));
				break;
			case 5: // isRaute
				objectIdentifier = (isEqual(eps, a, b, c, d));
				break;
			case 6: // isDeltoid
				objectIdentifier = ((isEqual(eps, a, d) && isEqual(eps, b, c)) || (isEqual(eps, a, b) && isEqual(eps, c, d)));
				break;
			default:
				objectIdentifier = false;
		}
		
		if (objectIdentifier && sidesGreaterNull(a, b, c, d, e, f))
			return true;
		
		return false;
	}
	
	/**
	 * Diese Methode überprüft, ob alle übergebenen Werte (Seiten/Diagonalen: a,b,c,d,e,f) größer als 0 sind.
	 * @param a Die Seite "a": Die Distanz zwischen dem Punkt "A" und "B".
	 * @param b Die Seite "b": Die Distanz zwischen dem Punkt "B" und "C".
	 * @param c Die Seite "c": Die Distanz zwischen dem Punkt "C" und "D".
	 * @param d Die Seite "d": Die Distanz zwischen dem Punkt "D" und "A".
	 * @param e Die Diagonale "e": Die Distanz zwischen dem Punkt "A" und "C".
	 * @param f Die Diagonale "f": Die Distanz zwischen dem Punkt "B" und "D".
	 * @return true, wenn alle Werte größer 0 sind.
	 */
	
	private static boolean sidesGreaterNull (double a, double b, double c, double d, double e, double f)
	{
		return (a > 0 && b > 0 && c > 0 && d > 0 && e > 0 && f > 0);
	}
	
	/**
	 * Vergleicht die beiden übergebenen Werte "d1" und "d2" auf die Nachkommastelle "eps".
	 * @param eps Enthält den Wert, auf welche Nachkommastelle geprüft wird.
	 * @param d1 Erster Wert, der mit dem zweiten Wert (d2) verglichen wird.
	 * @param d2 Zweiter Wert, der mit dem ersten Wert (d1) verglichen wird.
	 * @return true, wenn die beiden Werte "d1" und "d2" bis zur Nachkommastelle "eps" gleich sind.
	 */
	
	static boolean isEqual (double eps, double d1, double d2)
	{
		double d = d1 - d2;
		return Math.abs(d) <= eps;
		
	}
	
	/**
	 * Vergleicht alle übergebenen Werte im Varargs "values" auf die Nachkommastelle "eps".
	 * @param eps Enthält den Wert, auf welche Nachkommastelle geprüft wird.
	 * @param values Varargs mit mindestens 2 Werten die per erster isEqual Methode verglichen werden.
	 * @return true, wenn alle Werte im Varargs "values" bis zur Nachkommastelle "eps" gleich sind.
	 */
	
	static boolean isEqual (double eps, double... values)
	{
		if (values.length < 2 || eps > 1)
			return false;
		
		for (int i = 0; i < values.length - 1; i++)
		{
			if (!isEqual(eps, values[i], values[i+1]))
				return false;
		}
		
		return true;
	}
	
	/**
	 * Diese Methode misst die Distanz zwischen den zwei übergebenen Punkten p und q.
	 * @param p Punkt um die Distanz zwischen diesem Punkt und q zu messen.
	 * @param q Punkt um die Distanz zwischen diesem Punkt und p zu messen.
	 * @return Die gemessene Distanz zwischen den beiden übergebenen Punkten p und q.
	 */
	
	static double distanz (Punkt p, Punkt q)
	{
		// Formel aus der Angabe
		return Math.sqrt((Math.pow((p.x - q.x), 2) + Math.pow((p.y - q.y), 2)));
	}
	
	/**
	 * Diese Methode wird aufgerufen um den Fehler, dass einer der eingelesenen Punkte keinen Double Wert bekommen hat, auszugeben.
	 */
	
	private static void errorReport ()
	{
		System.err.println("Fehler: Der eingelesene Punkt benötigt einen DOUBLE Wert.");
	}
}

class Punkt
{
	
	double x;
	double y;
	
	public Punkt ()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public Punkt (double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString ()
	{
		return "[" + x + ", " + y + "]";
	}
	
}