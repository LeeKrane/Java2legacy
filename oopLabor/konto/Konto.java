package school.chif2.oopLabor.konto;

public class Konto
{
	private String kontoType;
	private double moneyAmount;
	private static final double maxOverdrawAmount = -10000;
	private double transactionCounter = 0;
	private boolean overdrawAllowed;
	private boolean gedeckt = true;
	
	@Override
	public String toString ()
	{
		String wahrheitswert = "nein";
		StringBuilder builder = new StringBuilder();
		
		if (this.kontoType == "Giro 1")
			wahrheitswert = "ja";
		
		if (!this.gedeckt)
		{
			builder.append("school.chif2.oopLabor.konto.Kontoo ").append('"').append(this.kontoType).append('"').append(" nicht gedeckt").append("\n");
			this.gedeckt = true;
		}
		
		builder.append("Kontoname: ").append(this.kontoType).append("\n");
		builder.append("Stand: ").append(this.moneyAmount).append("\n");
		builder.append("Transaktionen: ").append(this.transactionCounter).append("\n");
		builder.append("Girokonto: ").append(wahrheitswert).append("\n");
		builder.append("--------------------------").append("\n");
		
		return builder.toString();
	}
	
	public Konto (String type, double startAmmount, boolean overdrawAllowed)
	{
		switch (type)
		{
			case "Giro 1":
			case "Spar 1":
				this.kontoType = type;
				break;
			default:
				this.kontoType = null;
				this.moneyAmount = 0f;
				this.overdrawAllowed = false;
				System.out.println("Initialization Error!");
				return;
		}
		this.moneyAmount = startAmmount;
		this.overdrawAllowed = overdrawAllowed;
	}
	
	public void abheben (double wert)
	{
		if (this.kontoType != null)
		{
			switch (this.kontoType)
			{
				case "Giro 1":
					if (this.overdrawAllowed)
					{
						if (!(this.moneyAmount - wert >= maxOverdrawAmount))
						{
							this.gedeckt = false;
							this.transactionCounter--;
						}
						else
							this.moneyAmount -= wert;
					}
					else
					{
						if (!(this.moneyAmount - wert >= 0f))
						{
							this.gedeckt = false;
							this.transactionCounter--;
						}
						else
							this.moneyAmount -= wert;
					}
					
					this.transactionCounter++;
					break;
				case "Spar 1":
					if (!(this.moneyAmount - wert >= 0f))
					{
						this.gedeckt = false;
						this.transactionCounter--;
					}
					else
						this.moneyAmount -= wert;
					
					this.transactionCounter++;
					break;
				default:
					System.out.println("school.chif2.oopLabor.konto.Kontoo TypeDef Error!");
					return;
			}
		}
	}
	
	public void einzahlen (double wert)
	{
		this.moneyAmount += wert;
		this.transactionCounter++;
	}
	
	public static void umbuchen (Konto k1, Konto k2, double wert)
	{
		boolean transactionAllowed = false;
		
		if (k1.kontoType != null)
		{
			switch (k1.kontoType)
			{
				case "Spar 1":
					if (k1.moneyAmount - wert >= 0f)
						transactionAllowed = true;
					else
						transactionAllowed = false;
					break;
				case "Giro 1":
					if (k1.overdrawAllowed)
					{
						if (k1.moneyAmount - wert >= maxOverdrawAmount)
							transactionAllowed = true;
						else
							transactionAllowed = false;
					}
					else
					{
						if (k1.moneyAmount - wert >= 0f)
							transactionAllowed = true;
						else
							transactionAllowed = false;
					}
					break;
				default:
					System.out.println("Transaction Error!");
					return;
			}
			
			if (transactionAllowed)
			{
				k1.moneyAmount -= wert;
				k2.moneyAmount += wert;
				
				k1.transactionCounter++;
				k2.transactionCounter++;
			}
			else
				k1.gedeckt = false;
		}
	}
}
