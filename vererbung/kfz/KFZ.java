package school.chif2.vererbung.kfz;

import java.util.Random;

public abstract class KFZ
{
	public static String[] automarken = {"BMW", "Honda", "Suzuki", "VW", "Ferrari", "Alfa Romeo", "Mercedes", "Maserati"};
	public static String[] motomarken = {"BMW", "Honda", "Suzuki", "Ducati", "Moto Guzzi", "Kawasaki"};
	private String marke;
	private boolean motorLaeuft;
	private static Random rd = new Random();

	public KFZ ()
	{
		this.motorLaeuft = false;
	}

	public boolean getMotorLaeuft ()
	{
		return this.motorLaeuft;
	}
	
	public void setMotorLaeuft (boolean motorLaeuft)
	{
		this.motorLaeuft = motorLaeuft;
	}
	
	public String getMarke ()
	{
		return this.marke;
	}
	
	public final void setMarke (String marke)
	{
		this.marke = marke;
	}
	
	public abstract void info ();
	public abstract void starten ();
	
	public static void main (String []args) {
		KFZ []f = new KFZ[30];
		Random rd = new Random();
		
		for (int i = 0; i < f.length; i++)
		{
			switch (rd.nextInt(2))
			{
				case 0:
					f[i] = new Auto(automarken[rd.nextInt(automarken.length)]);
					break;
				case 1:
					f[i] = new Motorrad(motomarken[rd.nextInt(motomarken.length)]);
			}
		}

		for(int i = 0; i < f.length; i++) {
			if(rd.nextBoolean()) {
				f[i].starten();
			}
		}
		
		for (int i = 0; i < f.length; i++)
		{
				f[i].info();
		}
	}
}