package school.chif2.base64;

import java.util.Scanner;

public class Base64EncodeDecode
{
	private static final String indexTableString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	private String input;
	private String binaryInput;
	private String encodedInput;
	
	public Base64EncodeDecode ()
	{
		super();
		this.binaryInput = "";
		this.encodedInput = "";
	}
	
	public static void main (String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Base64EncodeDecode b64 = new Base64EncodeDecode();
		b64.input = scan.next();
		b64.encode();
		System.out.println(b64.input);
		System.out.println(b64.binaryInput);
		System.out.println(b64.encodedInput);
	}
	
	private void decode ()
	{
	
	}
	
	private void encode ()
	{
		if (this.input.length() % 3 != 0)
			addEquals();
		
		for (int i = 0; i < this.input.length() - 2; i+=3)
		{
			encodePart(this.input.substring(i, i+3));
		}

		if (this.binaryInput.length()%6 != 0)
			addBinZero();
		
		for (int i = 0; i < this.binaryInput.length() - 5; i+=6)
		{
			encodeToBase64(this.binaryInput.substring(i, i+6));
		}
	}
	
	private void encodePart (String code)
	{
		if (!pruefe(code))
			return;
		
		String binaryString = "";
		
		for (int i = 0; i < 3; i++)
		{
			if (code.charAt(i) != '=')
				binaryString += Integer.toBinaryString(code.charAt(i));
		}
		
		this.binaryInput += binaryString;
	}
	
	private void encodeToBase64 (String code)
	{
		if (!pruefe(code))
			return;
		
		int binToInt = Integer.parseInt(code, 2);
		
		this.encodedInput += Character.toString(indexTableString.charAt(binToInt));
	}
	
	private void addEquals ()
	{
		String addEquals = "";
		
		for (int i = this.input.length()%3; i < 3; i++)
			addEquals += "=";
		
		this.input += addEquals;
	}
	
	private void addBinZero ()
	{
		String addBinZero = "";
		
		for (int i = this.binaryInput.length()%6; i < 6; i++)
			addBinZero += "0";
		
		this.binaryInput = addBinZero + this.binaryInput;
	}
	
	private boolean pruefe (String i)
	{
		if (i == null)
			return false;
		
		// TODO: Überprüfung ob im Index
		/*
		for (int i = 0; i < i.length(); i++)
		{
			if (!Character.toString(i.charAt(i)).equals("=") || !(indexTableString.contains(Character.toString(i.charAt(i)))))
				return false;
		}
		*/
		
		return true;
	}
}
