package school.chif2.vererbung.employeeManager;

public class EmployeeDataCorruptedException extends Exception
{
	public EmployeeDataCorruptedException ()
	{
		super();
	}
	
	public EmployeeDataCorruptedException (String message)
	{
		super(message);
	}
}
