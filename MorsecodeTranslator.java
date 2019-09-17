package school.chif2;

import java.util.Scanner;

public class MorsecodeTranslator
{
	public static void main (String[] args)
	{
		int len;
		Scanner sc = new Scanner(System.in);
		String output = "";
		
		System.out.println("Länge: ");
		len = sc.nextInt();
		System.out.println("Strings: ");
		
		for (int i = 0; i < len; i++)
		{
			output += translate(sc.next());
		}
		
		System.out.println(output);
	}
	
	private static String[] read ()
	{
		String[] output = new String[15];
		Scanner sc = new Scanner(System.in);
		int i = 0;
		boolean exit = false;
		
		while (exit == false)
		{
			if (sc.next().equals("exit"))
				exit = true;
			else
				output[i] = sc.next();
		}
		
		return output;
	}
	
	private static String translate (String input)
	{
		switch (input)
		{
			case ".-":
				return "A";
			case "-...":
				return "B";
			case "-.-.":
				return "C";
			case "-..":
				return "D";
			case ".":
				return "E";
			case "..-.":
				return "F";
			case "--.":
				return "G";
			case "....":
				return "H";
			case "..":
				return "I";
			case ".---":
				return "J";
			case "-.-":
				return "K";
			case ".-..":
				return "L";
			case "--":
				return "M";
			case "-.":
				return "N";
			case "---":
				return "O";
			case ".--.":
				return "P";
			case "--.-":
				return "Q";
			case ".-.":
				return "R";
			case "...":
				return "S";
			case "-":
				return "T";
			case "..-":
				return "U";
			case "...-":
				return "V";
			case ".--":
				return "W";
			case "-..-":
				return "X";
			case "-.--":
				return "Y";
			case "--..":
				return "Z";
			case ".----":
				return "1";
			case "..---":
				return "2";
			case "...--":
				return "3";
			case "....-":
				return "4";
			case ".....":
				return "5";
			case "-....":
				return "6";
			case "--...":
				return "7";
			case "---..":
				return "8";
			case "----.":
				return "9";
			case "-----":
		}
		return "0";
	}
	
	private static String transform (String[] transformString)
	{
		StringBuilder output = new StringBuilder();
		
		for (int i = 0; i < transformString.length; i++)
		{
			output.append(transformString[i]);
		}
		
		return output.toString();
	}
}
