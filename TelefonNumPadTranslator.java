package school.chif2;

import java.util.Scanner;

public class TelefonNumPadTranslator
{
	private static String solution = "";
	private static String[][] tokens =
			{
					{"0"},
					{"1"},
					{"2", "A", "B", "C"},
					{"3", "D", "E", "F"},
					{"4", "G", "H", "I"},
					{"5", "J", "K", "L"},
					{"6", "M", "N", "O"},
					{"7", "P", "Q", "R", "S"},
					{"8", "T", "U", "V"},
					{"9", "W", "X", "Y", "Z"}
			};
	
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String code = sc.next();
		int holdup = code.charAt(0)-'0';
		int holdupNum = 0;
		
		for (int i = 0; i < code.length(); i++)
		{
			if (checkForAlpha(code.charAt(i)))
				solution += code.charAt(i);
			else
			{
				if (holdup == code.charAt(i)-'0')
				{
					if (holdupNum == 0)
					{
						holdup = code.charAt(i)-'0';
						holdupNum++;
					}
					else
					{
						holdup = code.charAt(i) - '0';
						holdupNum++;
					}
				}
				else
				{
					add(holdup, holdupNum == 0 ? 1 : holdupNum);
					holdup = -1;
					holdupNum = 0;
				}
			}
		}
		
		System.out.println(solution);
	}
	
	private static boolean checkForAlpha (int ascii)
	{
		return ascii >= 'a' && ascii <= 'z';
	}
	
	private static void add (int var, int num)
	{
		if (var >= 0 && var <= 1)
		{
			for (int i = 0; i < num; i++)
			{
				solution += var;
			}
		}
		else
		{
			solution += tokens[var == -1 ? 0 : var][num-1 == -1 ? 0 : num-1];
		}
	}
}
