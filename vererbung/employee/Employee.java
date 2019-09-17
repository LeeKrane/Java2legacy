package school.chif2.vererbung.employee;

import java.text.NumberFormat;

public abstract class Employee implements Payable
{
	private String firstName;
	private String lastName;
	
	public Employee ()
	{
		this("N.", "N.");
	}
	
	public Employee (String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public static void main(String args[]) {
		Employee []f = new Employee[3];
		f[0] = new PermanentEmployee("Franz", "Schuster", 15000.0);
		f[1] = new ContractEmployee("Hans", "Huber", 100.0);
		f[2] = new TemporaryEmployee("Barbara", "Schmidt", 7.5);
		String hourlyRate;
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		for(Employee e : f) {
			System.out.print(e);
			hourlyRate = nf.format(e.calculateHourlyRate());
			System.out.println("Hourly rate: " + hourlyRate);
		}
	}
	
	public void setFirstName (String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getFirstName ()
	{
		return firstName;
	}
	
	public void setLastName (String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getLastName ()
	{
		return lastName;
	}
	
	@Override
	public String toString ()
	{
		return "First Name: " + firstName + ", Last Name: " + lastName;
	}
}
