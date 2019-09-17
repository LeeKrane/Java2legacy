package school.chif2.oopLabor.adventOfCode;

import java.util.Scanner;

/*
DIESES
PROGRAMM
IST
ABSCHAUM
*/

public class AdventOfCode01
{
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		float number = 0f;
		float addition = 0f;
		String line;
		
		do
		{
			line = scan.nextLine();
			char[] lineUse = line.toCharArray();
			
			switch (lineUse[0])
			{
				case '+':
					addition = addFunct(lineUse);
					break;
				case '-':
					addition = remFunct(lineUse);
					break;
			}
			
			number += addition;
		}
		while (scan.hasNextLine());
		
		System.out.println(number);
	}
	
	private static float addFunct (char[] zahl)
	{
		float zahlRet = 0f;
		int j = zahl.length;
		
		for (int i = 1; i < zahl.length; i++)
		{
			zahlRet += (float)zahl[i] * ((float)(Math.pow(10, (double)j-1)));
			
			j -= 1;
		}
		
		return zahlRet;
	}
	
	private static float remFunct (char[] zahl)
	{
		float zahlRet = 0f;
		int j = zahl.length;
		
		for (int i = 1; i < zahl.length; i++)
		{
			zahlRet -= (float)zahl[i] * ((float)(Math.pow(10, (double)j-1)));
			
			j -= 1;
		}
		
		return zahlRet;
	}
}
