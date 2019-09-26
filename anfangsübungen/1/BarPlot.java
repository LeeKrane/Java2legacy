// @author Kranabetter Christian

import java.util.Scanner;

public class BarPlot
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String ausgabe = "";
		
		System.out.println("Functions Available:");
		System.out.println("	Repeat");
		System.out.println("	DrawLabel");
		System.out.println("	DrawBar1");
		System.out.println("	DrawBar2");
		System.out.print("What Function do you wanna use? --> ");
		String funct = scan.next();
		
		if (!(!funct.equals("Repeat") && !funct.equals("DrawLabel") && !funct.equals("DrawBar1") && !funct.equals("DrawBar2")))
		{
			switch (funct)
			{
				case "Repeat":
					char ch = '\0';
					int value = 0;
					System.out.print("Char --> ");
					if (scan.hasNext())
					{
						ch = scan.next().charAt(0);
					}
					System.out.print("Value --> ");
					if (scan.hasNextInt())
					{
						value = scan.nextInt();
					}
					
					ausgabe = repeat(ch, value);
					
					break;
				case "DrawLabel":
					String eingabeStr0 = "";
					int value1 = 0;
					System.out.print("String --> ");
					if (scan.hasNext())
					{
						eingabeStr0 = scan.next();
					}
					System.out.print("Value --> ");
					if (scan.hasNextInt())
					{
						value1 = scan.nextInt();
					}
					
					ausgabe = drawLabel(eingabeStr0, value1);
					
					break;
				case "DrawBar1":
					String eingabeStr1 = "";
					int value2 = 0;
					System.out.print("String --> ");
					if (scan.hasNext())
					{
						eingabeStr1 = scan.next();
					}
					System.out.print("Value --> ");
					if (scan.hasNextInt())
					{
						value2 = scan.nextInt();
					}
					
					ausgabe = drawBar(eingabeStr1, value2);
					
					break;
				case "DrawBar2":
					String eingabeStr2 = "";
					double value3 = 0;
					System.out.print("String --> ");
					if (scan.hasNext())
					{
						eingabeStr2 = scan.next();
					}
					System.out.print("Value --> ");
					if (scan.hasNextDouble())
					{
						value3 = scan.nextDouble();
					}
					
					ausgabe = drawBar(eingabeStr2, value3);
					
					break;
				default:
					System.out.println("Falsche Eingabe!");
			}
		}
		if (ausgabe != null)
			System.out.println(ausgabe);
		else
			System.out.println("Error");
	}
	
	private static String repeat (char c, int n)
	{
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++)
			sb.append(c);
		
		return sb.toString();
	}
	
	/**
	 * Liefert den übergebenen String mit exakt n Zeichen zurück
	 *
	 * @param label "String";
	 * @param n     gewünschte Länge;
	 * @return String exakt mit Länge n
	 */
	private static String drawLabel (String label, int n)
	{
		if (label.length() <= n)
			return label + repeat(' ', n - label.length());
		
		return label.substring(0, n);
	}
	
	private static String drawBar (String label, int value)
	{
		double max = 30;
		int count = 0;
		StringBuilder bar;
		
		if (0 > value || max < value)
		{
			return null;
		}
		
		bar = new StringBuilder(label + "  |");
		for (int i = 0; i < value; i++)
		{
			bar.append('#');
			count++;
		}
		for (int i = count; i < max; i++)
			bar.append(' ');
		bar.append('|');
		
		return bar.toString();
	}
	
	private static String drawBar (String label, double value)
	{
		double max = 30;
		int count = 0;
		StringBuilder bar;
		
		if (0 > value || max < value)
		{
			return null;
		}
		
		if (1 >= value && 0 <= value)
		{
			bar = new StringBuilder(label + "  |");
			for (int i = 0; i < ((max * value) / 1); i++)
			{
				bar.append('#');
				count++;
			}
			for (int i = count; i < max; i++)
				bar.append(' ');
			bar.append('|');
		}
		else
		{
			bar = new StringBuilder(label + "  |");
			for (int i = 0; i < value; i++)
			{
				bar.append('#');
				count++;
			}
			for (int i = count; i < max; i++)
				bar.append(' ');
			bar.append('|');
		}
		
		return bar.toString();
	}
}
