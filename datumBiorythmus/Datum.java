package school.chif2.datumBiorythmus;

import java.time.LocalDate;

public class Datum
{
	private int tag;
	private int monat;
	private int jahr;
	public static final int SHORT = 1;
	public static final int NORMAL = 2;
	public static final int LONG = 3;
	public static final int US = 4;
	
	private void ungueltigesDatum ()
	{
		this.tag = 31;
		this.monat = 12;
		this.jahr = 1899;
	}
	
	private void monatPlusPlus ()
	{
		this.monat++;
		this.tag = 1;
	}
	
	private void monatMinusMinus ()
	{
		this.monat--;
		
		switch (this.monat)
		{
			case 0:
				this.jahr--;
				this.monat = 12;
				this.tag = 31;
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				this.tag = 31;
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				this.tag = 30;
				break;
			case 2:
				if (Datum.schaltjahr(this.jahr))
					this.tag = 29;
				else
					this.tag = 28;
		}
	}
	
	public Datum ()
	{
		LocalDate today = LocalDate.now();
		this.tag = today.getDayOfMonth();
		this.monat = today.getMonthValue();
		this.jahr = today.getYear();
	}
	
	public Datum (int tag)
	{
		this(1, 1, 1900);
		if (tag < 0)
			ungueltigesDatum();
		else
			this.addiereTage(tag);
	}
	
	public Datum (int tag, int monat, int jahr)
	{
		boolean fail = false;
		
		if (tag <= 0)
		{
			ungueltigesDatum();
			fail = true;
		}
		else if (jahr < 1900 || jahr > 3000)
		{
			ungueltigesDatum();
			fail = true;
		}
		switch (monat)
		{
			case 2:
				if (Datum.schaltjahr(jahr))
				{
					if (tag > 29)
					{
						ungueltigesDatum();
						fail = true;
					}
				}
				else
				{
					if (tag > 28)
					{
						ungueltigesDatum();
						fail = true;
					}
				}
				break;
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if (tag > 31)
				{
					ungueltigesDatum();
					fail = true;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				if (tag > 30)
				{
					ungueltigesDatum();
					fail = true;
				}
		}
		
		if (!fail)
		{
			this.tag = tag;
			this.monat = monat;
			this.jahr = jahr;
		}
	}
	
	public final boolean isValid()
	{
		// TODO: Prüfe ob this.jahr <= 3000 für den "Datum(tag)" Constructor OK sind!
		switch (this.monat)
		{
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return (this.jahr >= 1900 && this.jahr <= 3000 && this.tag >= 1 && this.tag <= 31) || (this.tag == 31 && this.monat == 12 && this.jahr == 1899);
			case 4:
			case 6:
			case 9:
			case 11:
				return (this.jahr >= 1900 && this.jahr <= 3000 && this.tag >= 1 && this.tag <= 30);
		}

		if (Datum.schaltjahr(this.jahr))
			return (this.jahr >= 1900 && this.jahr <= 3000 && this.tag >= 1 && this.tag <= 29);
		return (this.jahr >= 1900 && this.jahr <= 3000 && this.tag >= 1 && this.tag <= 28);
	}
	
	public int getJahr ()
	{
		return this.jahr;
	}
	
	public int getMonat ()
	{
		return this.monat;
	}
	
	public String getMonatByString ()
	{
		switch (this.monat)
		{
			case 1: return "Jaenner";
			case 2: return "Februar";
			case 3: return "Maerz";
			case 4: return "April";
			case 5: return "Mai";
			case 6: return "Juni";
			case 7: return "Juli";
			case 8: return "August";
			case 9: return "September";
			case 10: return "Oktober";
			case 11: return "November";
		}
		return "Dezember";
	}
	
	public int getTag ()
	{
		return this.tag;
	}
	
	public void addiereTage (int tag)
	{
		if (tag > 0)
		{
			for (int i = tag; i > 0; i--)
			{
				switch (this.monat)
				{
					case 2:
						if (this.tag == 30 && Datum.schaltjahr(this.jahr))
							this.monatPlusPlus();
						else if (this.tag == 29)
							this.monatPlusPlus();
						break;
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:
						if (this.tag == 32)
							this.monatPlusPlus();
						break;
					case 4:
					case 6:
					case 9:
					case 11:
						if (this.tag == 31)
							this.monatPlusPlus();
				}
				if (this.monat == 13)
				{
					this.jahr++;
					this.monat = 1;
				}
				this.tag++;
			}
		}
		else if (tag < 0)
		{
			for (int i = tag; i < 0; i++)
			{
				if (this.tag == 0)
					this.monatMinusMinus();
				
				this.tag--;
			}
		}
	}
	
	private double initC ()
	{
		if (this.monat == 1 || this.monat == 2)
			return ((double)this.jahr-1) / 100;
		return ((double)this.jahr) / 100;
	}
	
	public int wochentagNummer ()
	{
		if (!this.isValid())
			return -1;
		
		int d = this.tag;
		int m = this.monat;
		int y = this.jahr;
		
		if (m < 3) y--;
		
		return (int)((d + Math.floor(2.6 * ((m + 9) % 12 + 1) - 0.2) + y % 100 + Math.floor(y % 100 / 4) + Math.floor(y / 400) - 2 * Math.floor(y / 100) - 1) % 7 + 7) % 7;
	}
	
	public String wochentag ()
	{
		if (!this.isValid())
			return null;
		
		String tagDerWoche;
		
		switch (wochentagNummer())
		{
			case 0: tagDerWoche = "Sonntag"; break;
			case 1: tagDerWoche = "Montag"; break;
			case 2: tagDerWoche = "Dienstag"; break;
			case 3: tagDerWoche = "Mittwoch"; break;
			case 4: tagDerWoche = "Donnerstag"; break;
			case 5: tagDerWoche = "Freitag"; break;
			case 6: tagDerWoche = "Samstag"; break;
			default: return null;
		}
		
		return tagDerWoche;
	}
	
	public static int tageZwischen (Datum d1, Datum d2)
	{
		int tage = 0;
		
		if (d1.compareTo(d2) == 0)
			return 0;
		else if (d1.compareTo(d2) == -1)
		{
			do
			{
				d1.addiereTage(1);
				tage++;
			}
			while (d1.compareTo(d2) != 0);
		}
		else
		{
			do
			{
				d1.addiereTage(-1);
				tage--;
			}
			while (d1.compareTo(d2) != 0);
		}
		return tage;
	}
	
	public int compareTo (Datum d)
	{
		if (this.tag == d.tag && this.monat == d.monat && this.jahr == d.jahr)
			return 0;
		else if (this.jahr == d.jahr && this.monat == d.monat)
		{
			if (this.tag > d.tag)
				return 1;
			return -1;
		}
		else if (this.jahr == d.jahr)
		{
			if (this.monat > d.monat)
				return 1;
			return -1;
		}
		else if (this.jahr > d.jahr)
			return 1;
		return -1;
	}
	
	// TODO: schaltjahr
	public static boolean schaltjahr (int jahr)
	{
		return (jahr%4 == 0 && jahr%100 != 0) || jahr%400 == 0;
	}
	
	// TODO: toString
	@Override
	public String toString ()
	{
		if (!this.isValid())
			return "ungueltig";
		return String.format("%02d", this.tag) + "." + String.format("%02d", this.monat) + "." + this.jahr;
	}
	
	// TODO: toString2
	public String toString (int format)
	{
		if (!this.isValid())
			return "ungueltig";
		
		switch (format)
		{
			case 1: return String.format("%02d", this.tag) + "." + String.format("%02d", this.monat) + "." + String.format("%02d", this.jahr%100);
			case 2: return this.toString();
			case 3: return String.format("%02d", this.tag) + "." + this.getMonatByString() + " " + this.jahr + ", " + this.wochentag();
			case 4: return this.jahr + "/" + String.format("%02d", this.tag) + "/" + String.format("%02d", this.monat);
		}
		return "";
	}
}
