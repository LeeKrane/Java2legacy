package school.chif2.bruchhue;

public class Bruch
{
	/**
	 * @param zaehler ist der Zähler des Bruches.
	 * @param nenner ist der Nenner des Bruches.
	 * @param bruchFormat bestimmt, wie die Brüche ausgegeben werden sollen (true => gibt z/n aus)
	 */
	private long zaehler;
	private long nenner;
	private static boolean bruchFormat = false;
	
	/**
	 * Erzeugt ein Bruchobjekt (0/1) durch Konstruktorverkettung.
	 */
	public Bruch ()
	{
		this(0);
	}
	
	/**
	 * Erzeugt ein Bruchobjekt (z/1).
	 * @param z ist der Zähler, den das neue Bruchobjekt erhält.
	 */
	public Bruch (long z)
	{
		this.zaehler = z;
		this.nenner = 1;
	}
	
	/**
	 * Erzeugt ein Bruchobjekt (z/n).
	 * @param z ist der Zähler, den das neue Bruchobjekt erhält.
	 * @param n ist der Nenner, den das neue Bruchobjekt erhält, der nicht 0 sein darf.
	 * @throws BruchException, wenn der Nenner 0 ist.
	 */
	public Bruch (long z, long n) throws BruchException
	{
		setZaehlerUndNenner(z, n);
	}
	
	/**
	 * Erzeugt ein Bruchobjekt aus einem String (double wert oder Bruch im Format: z/n) durch parsen.
	 * @param bruch ist der String aus dem ein double wert oder ein Bruch (z/n) durch parsen ausgelesen wird.
	 * @throws BruchException, weder ein double, ein long noch zwei longs in "bruch" enthalten sind oder, wenn mehr als 2 Werte enthalten sind.
	 */
	public Bruch (String bruch) throws BruchException
	{
		String[] tokens = bruch.split("/");
		
		switch (tokens.length)
		{
			case 1:
				try
				{
					setZaehlerUndNenner(Long.parseLong(tokens[0]), 1);
					return;
				}
				catch (NumberFormatException nfe) {}
				try
				{
					setZaehlerUndNenner(Double.parseDouble(tokens[0]));
					return;
				}
				catch (NumberFormatException nfe)
				{
					throw new BruchException("Im übergebenen String ist weder ein Bruch noch ein Double Wert enthalten!");
				}
			case 2:
				try
				{
					setZaehlerUndNenner(Long.parseLong(tokens[0]), Long.parseLong(tokens[1]));
					return;
				}
				catch (NumberFormatException nfe)
				{
					throw new BruchException("Im übergebenen String ist kein Bruch enthalten!");
				}
		}
		
		throw new BruchException();
	}
	
	/**
	 * Erzeugt ein Bruchobjekt aus einem double wert mit dem Aufruf der Methode "setZaehlerUndNenner"
	 * @param wert ist der übergebene double wert, aus dem der Bruch erzeugt wird.
	 */
	public Bruch (double wert)
	{
		setZaehlerUndNenner(wert);
	}
	
	/**
	 * Erzeugt einen neuen Bruch der durch den Aufruf von addThis "this + b" retouriert.
	 * @param b ist der Bruch der in einem neuen Bruch mit "this" addiert und retouriert wird.
	 * @throws BruchException, wenn "b" null ist.
	 * @return den neu generierten Bruch der "this + b" ist.
	 */
	public Bruch add (Bruch b) throws BruchException
	{
		if (b != null)
		{
			Bruch returnBruch = new Bruch(this.zaehler, this.nenner);
			returnBruch.addThis(b);
			return returnBruch;
		}
		throw new BruchException();
	}
	
	/**
	 * Addiert "this" mit dem übergebenen Bruch "b", falls der Nenner ungleich ist, wird er mit kgV auf den selben gebracht.
	 * Am ende wird der Bruch noch gekürzt und der Nenner positiv gemacht durch "simplify" (und cancel in simplify).
	 * @param b ist der Bruch der zu "this" addiert wird.
	 */
	public void addThis (Bruch b)
	{
		if (b != null)
		{
			long kgV = kgV(this.nenner, b.nenner);
			this.zaehler = this.zaehler * (kgV / this.nenner) + b.zaehler * (kgV / b.nenner);
			this.nenner = kgV;
		}
		this.simplify();
	}
	
	/**
	 * Erzeugt einen neuen Bruch der durch den Aufruf von addThis "this - b" retouriert.
	 * @param b ist der Bruch der in einem neuen Bruch mit "this" subtrahiert und retouriert wird.
	 * @throws BruchException, wenn "b" null ist.
	 * @return den neu generierten Bruch der "this - b" ist.
	 */
	public Bruch sub (Bruch b) throws BruchException
	{
		if (b != null)
		{
			Bruch returnBruch = new Bruch(this.zaehler, this.nenner);
			returnBruch.subThis(b);
			return returnBruch;
		}
		throw new BruchException();
	}
	
	/**
	 * Subtrahiert den übergebenen Bruch "b" von "this", falls der Nenner ungleich ist, wird er mit kgV auf den selben gebracht.
	 * Am ende wird der Bruch noch gekürzt und der Nenner positiv gemacht durch "simplify" (und cancel in simplify).
	 * @param b ist der Bruch der von "this" subtrahiert wird.
	 */
	public void subThis (Bruch b)
	{
		if (b != null)
		{
			long kgV = kgV(this.nenner, b.nenner);
			this.zaehler = this.zaehler * (kgV / this.nenner) - b.zaehler * (kgV / b.nenner);
			this.nenner = kgV;
		}
		this.simplify();
	}
	
	/**
	 * Erzeugt einen neuen Bruch der durch den Aufruf von addThis "this * b" retouriert.
	 * @param b ist der Bruch der in einem neuen Bruch mit "this" mulipliziert und retouriert wird.
	 * @throws BruchException, wenn "b" null ist.
	 * @return den neu generierten Bruch der "this * b" ist.
	 */
	public Bruch mult (Bruch b) throws BruchException
	{
		if (b != null)
		{
			Bruch returnBruch = new Bruch(this.zaehler, this.nenner);
			returnBruch.multThis(b);
			return returnBruch;
		}
		throw new BruchException();
	}
	
	/**
	 * Multipliziert "this" mit dem übergebenen Bruch "b".
	 * Am ende wird der Bruch noch gekürzt und der Nenner positiv gemacht durch "simplify" (und cancel in simplify).
	 * @param b ist der Bruch der mit "this" multipliziert wird.
	 */
	public void multThis (Bruch b)
	{
		if (b != null)
		{
			try
			{
				this.setZaehlerUndNenner(this.zaehler * b.zaehler, this.nenner * b.nenner);
			}
			catch (BruchException be)
			{
				System.err.println();
			}
		}
		simplify();
	}
	
	/**
	 * Erzeugt einen neuen Bruch der durch den Aufruf von addThis "this / b" retouriert.
	 * @param b ist der Bruch der in einem neuen Bruch mit "this" dividiert und retouriert wird.
	 * @throws BruchException, wenn "b" null ist.
	 * @return den neu generierten Bruch der "this / b" ist.
	 */
	public Bruch div (Bruch b) throws BruchException
	{
		if (b != null)
		{
			if (b.zaehler == 0 || b.nenner == 0)
				throw new BruchException("Bruch b: Nenner oder Zähler darf nicht 0 enthalten");
			Bruch returnBruch = new Bruch(this.zaehler, this.nenner);
			returnBruch.divThis(b);
			return returnBruch;
		}
		throw new BruchException("Bruch b darf nicht null sein");
	}
	
	/**
	 * Dividiert "this" durch dem übergebenen Bruch "b", indem "multThis" mit den Kehrwerten aufgerufen wird.
	 * Falls dessen Nenner oder Zähler 0 ist, wird eine Exception geworfen.
	 * Am ende wird der Bruch noch gekürzt und der Nenner positiv gemacht durch "simplify" (und cancel in simplify).
	 * @param b ist der Bruch durch den "this" dividiert wird.
	 * @throws BruchException, wenn der Nenner oder Zähler des übergebenen Bruchs "b" 0 ist.
	 */
	public void divThis (Bruch b) throws BruchException
	{
		if (b != null)
		{
			if (b.zaehler == 0 || b.nenner == 0)
				throw new BruchException("Bruch b Nenner oder Zähler darf nicht 0 enthalten");
			
			this.multThis(new Bruch(b.nenner, b.zaehler));
		}
		simplify();
	}
	
	/**
	 * Erzeugt einen neuen Bruch der durch den Aufruf von addThis "this ^ b" retouriert.
	 * @param e ist die Zahl mit der in einem neuen Bruch "this" potenziert und retouriert wird.
	 * @throws BruchException, wenn der Nenner des neu erzeugten Bruch Objekts aus irgendeinem Grund 0 ergibt.
	 * @return den neu generierten Bruch der "this ^ b" ist.
	 */
	public Bruch hoch (int e) throws BruchException
	{
		Bruch returnBruch = new Bruch(this.zaehler, this.nenner);
		returnBruch.hochThis(e);
		return returnBruch;
	}
	
	/**
	 * Potenziert "this" mit dem übergebenen Wert "e", wenn "e" negativ ist, wird der Kehrwert, mit hilfe eines Dreieckstausches potenziert.
	 * Am ende wird der Bruch noch gekürzt und der Nenner positiv gemacht durch "simplify" (und cancel in simplify).
	 * @param e ist der Wert mit dem "this" potenziert wird.
	 */
	public void hochThis (int e) throws BruchException
	{
		if (e < 0)
			this.setZaehlerUndNenner(this.nenner, this.zaehler);
		
		this.nenner = (long)Math.pow(this.nenner, Math.abs(e));
		this.zaehler = (long)Math.pow(this.zaehler, Math.abs(e));
	}
	
	/**
	 * Macht den Nenner positiv, wenn er negativ ist und kürzt den Bruch durch den Aufruf von "cancel".
	 */
	private void simplify ()
	{
		if (this.nenner < 0)
		{
			this.nenner *= -1;
			this.zaehler *= -1;
		}
		cancel();
	}
	
	/**
	 * Kürzt den Bruch mithilfe von ggT.
	 * Wenn der ggT 0 oder 1 ist, wird der Vorgang beendet, da eine Division durch 0 nicht erlaubt und eine durch 1 unnötig ist.
	 */
	private void cancel ()
	{
		long ggT = ggT(this.zaehler, this.nenner);
	
		if (ggT == 0 ||ggT == 1)
			return;
		
		this.zaehler /= ggT;
		this.nenner /= ggT;
	}
	
	/**
	 * Gibt den Bruch je nach "bruchFormat" in Bruch- oder Doubleformat aus.
	 * @return den Bruch in Bruch- oder Doubleformat.
	 */
	@Override
	public String toString ()
	{
		this.simplify();
		
		if (bruchFormat)
			return String.format("%d/%d", this.zaehler, this.nenner);
		
		return String.format("%.03f", (double)this.zaehler/(double)this.nenner);
	}
	
	/**
	 * Vergleicht den Bruch mit dem übergebenen Objekt.
	 * @param o ist das Objekt das mit dem Bruch verglichen wird (evtl. kein Bruch).
	 * @return true, wenn "o" ein Bruch ist und die gekürzten Brüche den selben Zähler sowie Nenner haben.
	 */
	@Override
	public boolean equals (Object o)
	{
		if (o instanceof Bruch)
		{
			Bruch thisBruch = this;
			Bruch oBruch = (Bruch) o;
			
			thisBruch.simplify();
			oBruch.simplify();
			
			return thisBruch.zaehler == oBruch.zaehler && thisBruch.nenner == oBruch.nenner;
		}
		
		return false;
	}
	
	/**
	 * Errechnet den ggT der beiden übergebenen Zahlen rekursiv.
	 * @param a erster Wert des ggT's.
	 * @param b zweiter Wert des ggT's.
	 * @return den berechneten ggT, oder wenn dieser noch nicht errechnet ist "ggT" (rekursion).
	 */
	static long ggT (long a, long b)
	{
		a = Math.abs(a);
		b = Math.abs(b);
		
		if (b == 0)
			return a;
		return ggT(b, a%b);
	}
	
	/**
	 * Errechnet das kgV der beiden übergebenen Zahlen.
	 * @param a erster Wert des kgV's.
	 * @param b zweiter Wert des kgV's.
	 * @return Formel für das kgV mithilfe des ggT's.
	 */
	static long kgV (long a, long b)
	{
		a = Math.abs(a);
		b = Math.abs(b);
		return (a*b)/(ggT(a, b));
	}
	
	/**
	 * Setzt den Zähler und Nenner auf die übergebenen Werte, wenn der übergebene Nenner nicht 0 ist.
	 * @param zaehler der neue Zähler, wenn der Nenner nicht 0 ist.
	 * @param nenner der neue Nenner, wenn dieser nicht 0 ist.
	 */
	private void setZaehlerUndNenner (long zaehler, long nenner) throws BruchException
	{
		if (nenner == 0)
			throw new BruchException();
		
		this.zaehler = zaehler;
		this.nenner = nenner;
	}
	
	/**
	 * Setzt den Zähler und Nenner auf die berechneten Werte des Wertes "zahl".
	 * @param zahl ist die Dezimalzahl des Bruches.
	 */
	private void setZaehlerUndNenner (double zahl)
	{
		int e = 1;
		while ((double) Math.round(zahl * e) / e != zahl)
			e *= 10;
		this.zaehler = (long)(zahl * e);
		this.nenner = e;
	}
	
	/**
	 * Setzt das Ausgabeformat aller Brüche auf "set".
	 * @param set gewolltes Bruchformat.
	 */
	public static void setBruchFormat (boolean set)
	{
		bruchFormat = set;
	}
	
	/**
	 * Gibt per boolean zurück, welches Format die Bruchausgabe hat.
	 * @return aktuelles Bruchausgabeformat.
	 */
	public static boolean isBruchFormat ()
	{
		return bruchFormat;
	}
}
