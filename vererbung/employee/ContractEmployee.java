package school.chif2.vererbung.employee;

import java.text.NumberFormat;

public class ContractEmployee extends Employee
{
	private double dailyRate;
	
	public ContractEmployee ()
	{
		this("N.N.", "N.N.", 0.0);
	}
	
	public ContractEmployee (String firstName, String lastName, double dailyRate)
	{
		super(firstName, lastName);
		this.dailyRate = dailyRate;
	}
	
	public double getDailyRate ()
	{
		return dailyRate;
	}
	
	public void setDailyRate (double dailyRate)
	{
		this.dailyRate = dailyRate;
	}
	
	@Override
	public String toString ()
	{
		String empDetails = super.toString();
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String formattedPay = nf.format(dailyRate);
		
		return "Contract Employee:\n" + empDetails + ", Daily Rate: " + formattedPay + '\n';
	}
	
	@Override
	public double calculateHourlyRate ()
	{
		return dailyRate/DEFAULT_WORK_HOURS_PER_DAY;
	}
}
