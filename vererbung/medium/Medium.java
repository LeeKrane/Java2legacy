package school.chif2.vererbung.medium;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Medium
{
	private String bezeichnung;
	private double preis;
	
	public Medium (String bezeichnung, double preis)
	{
		this.bezeichnung = bezeichnung;
		this.preis = preis;
	}
	
	public abstract void info ();
	public abstract int compareTo (Medium other);
	
	public String getBezeichnung ()
	{
		return bezeichnung;
	}
	
	public double getPreis ()
	{
		return preis;
	}
	
	public static void main (String[] args)
	{
		firstAct();
		System.out.println("\n\n\n");
		secondAct();
	}
	
	private static void firstAct ()
	{
		Medium []m = {
				new Buch("Coding with Java", 44.99, 730),
				new AudioCD("A Tenno's Dream", 59.95, 4.11),
				new Buch("Coding with Ruby", 34.95, 333),
				new AudioCD("Orokin Legacy", 27.75, 3.57)
		};
		
		sortSout(m);
	}
	
	private static void secondAct ()
	{
		try
		{
			Scanner sc = new Scanner(new File("C:\\Data\\IntelliJ\\Projects\\PrivateLaborJ\\src\\school\\vererbung\\medium\\items.csv"));
			Medium[] arr = new Medium[1];
			Medium[] zwischenspeicher;
			String[] splitted;
			int i = 0;
			
			while (sc.hasNextLine())
			{
				splitted = sc.nextLine().split(";");
				
				if (i > 0)
				{
					zwischenspeicher = arr;
					arr = new Medium[arr.length+1];
					
					for (int j = 0; j < arr.length - 1; j++)
						arr[j] = zwischenspeicher[j];
				}
				
				try
				{
					arr[i] = new Buch(splitted[0], Double.parseDouble(splitted[1]), Integer.parseInt(splitted[2]));
				}
				catch (NumberFormatException nfe)
				{
					try
					{
						arr[i] = new AudioCD(splitted[0], Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2]));
					}
					catch (NumberFormatException nfe2)
					{
						System.err.println("Initialization failed, because of wrong Input types.");
					}
				}
				
				++i;
			}
			
			sortSout(arr);
		}
		catch (FileNotFoundException fnfe)
		{
			System.err.println(fnfe);
		}
	}
	
	private static void sortSout (Medium[] array)
	{
		for (int i = 0; i < array.length; i++)
			array[i].info();
		
		Medium []sortedArray = Medium.bubblesort(array);
		System.out.println("\nSorted Array:\n");
		
		for (int i = 0; i < sortedArray.length; i++)
			sortedArray[i].info();
	}
	
	public static Medium[] bubblesort(Medium[] zusortieren) {
		Medium temp;
		for(int i=1; i<zusortieren.length; i++) {
			for(int j=0; j<zusortieren.length-i; j++) {
				if(zusortieren[j].compareTo(zusortieren[j+1]) == 1) {
					temp=zusortieren[j];
					zusortieren[j]=zusortieren[j+1];
					zusortieren[j+1]=temp;
				}
				
			}
		}
		return zusortieren;
	}
}
