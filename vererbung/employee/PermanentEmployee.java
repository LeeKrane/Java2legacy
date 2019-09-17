package school.chif2.vererbung.employee;

import java.text.NumberFormat;

public class PermanentEmployee extends Employee
{
	private double salary;
	
	public PermanentEmployee ()
	{
		this("N.N.", "N.N.", 0.0);
	}
	
	public PermanentEmployee (String firstName, String lastName, double salary)
	{
		super(firstName, lastName);
		this.salary = salary;
	}
	
	public static void main(String args[])
	{
		Employee pe = new PermanentEmployee();
		Employee ce = new ContractEmployee("Hans", "Huber", 100.0);
		Employee te = new TemporaryEmployee("Barbara", "Schmidt", 7.5);
		System.out.println(pe);
		System.out.println(ce);
		System.out.println(te);
	}
	
	public double getSalary ()
	{
		return salary;
	}
	
	public void setSalary (double salary)
	{
		this.salary = salary;
	}
	
	@Override
	public String toString ()
	{
		String empDetails = super.toString();
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		String formattedPay = nf.format(salary);
		
		return "Permanent Employee:\n" + empDetails + ", Salary: " + formattedPay + '\n';
	}
	
	@Override
	public double calculateHourlyRate ()
	{
		return salary/(DEFAULT_WORK_DAYS_PER_YEAR*DEFAULT_WORK_HOURS_PER_DAY);
	}
}
