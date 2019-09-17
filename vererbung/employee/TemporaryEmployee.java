package school.chif2.vererbung.employee;

import java.text.NumberFormat;

public class TemporaryEmployee extends Employee
{
	private double hourlyRate;
	
	public TemporaryEmployee ()
	{
	
	}
	
	public TemporaryEmployee (String firstName, String lastName, double hourlyRate)
	{
		super(firstName, lastName);
		this.hourlyRate = hourlyRate;
	}
	
	public double getHourlyRate ()
	{
		return hourlyRate;
	}
	
	public void setHourlyRate (double hourlyRate)
	{
		this.hourlyRate = hourlyRate;
	}
	
	@Override
	public String toString ()
	{
		String empDetails = super.toString();
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String formattedPay = nf.format(hourlyRate);
		
		return "Temporary Employee:\n" + empDetails + ", Hourly Rate: " + formattedPay + '\n';
	}
	
	@Override
	public double calculateHourlyRate ()
	{
		return hourlyRate;
	}
}
