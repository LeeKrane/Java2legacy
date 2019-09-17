package school.chif2.vererbung.employeeManager;

import school.chif2.vererbung.employee.ContractEmployee;
import school.chif2.vererbung.employee.Employee;
import school.chif2.vererbung.employee.PermanentEmployee;
import school.chif2.vererbung.employee.TemporaryEmployee;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeManager
{
	List<Employee> employeeList = new ArrayList<Employee>();
	
	public static void main(String args[])
	{
		firstAct();
		System.out.println("\n\n\n");
		secondAct("emplist.txt", "dataneu.txt");
		System.out.println("\n\n\n");
		secondAct("emplist2.txt", "dataneu2.txt");
	}
	
	private static void firstAct ()
	{
		EmployeeManager m = new EmployeeManager();
		
		actSupport(m);
		
		System.out.format("Anzahl der gespeicherten Employees: %3d\n", m.size());
		System.out.format("Anzahl der ContractEmployees: %3d\n", m.getNumberContractEmployees());
		System.out.format("Anzahl der PermanentEmployees: %3d\n", m.getNumberPermanentEmployees());
		System.out.format("Anzahl der TemporaryEmployees: %3d\n", m.getNumberTemporaryEmployees());
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.format("Durchschnittlicher Stundenlohn: %s\n", nf.format(m.calculateAverageHourlyRate()));
	}
	
	private static void secondAct (String listFilePath, String dataFilePath)
	{
		EmployeeManager m = new EmployeeManager();
		
		actSupport(m);
		
		try {
			m.readFromFile(new File("C:\\Data\\IntelliJ\\Projects\\PrivateLaborJ\\src\\school\\vererbung\\employeeManager\\" + listFilePath), new File("C:\\Data\\IntelliJ\\Projects\\PrivateLaborJ\\src\\school\\vererbung\\employeeManager\\emplog.txt"));
		}
		catch(IOException e) {
			System.out.println("Fehler beim Lesen der Daten");
		}
		System.out.format("Anzahl der gespeicherten Employees: %3d\n",
						  m.size());
		System.out.format("Anzahl der ContractEmployees: %3d\n",
						  m.getNumberPermanentEmployees());
		System.out.format("Anzahl der PermanentEmployees: %3d\n",
						  m.getNumberContractEmployees());
		System.out.format("Anzahl der TemporaryEmployees: %3d\n",
						  m.getNumberTemporaryEmployees());
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.format("Durchschnittlicher Stundenlohn: %s\n",
						  nf.format(m.calculateAverageHourlyRate()));
		try {
			m.writeToFile(new File("C:\\Data\\IntelliJ\\Projects\\PrivateLaborJ\\src\\school\\vererbung\\employeeManager\\" + dataFilePath));
		}
		catch(IOException e) {
			System.out.println("Fehler beim Schreiben der Daten");
		}
	}
	
	private static void actSupport (EmployeeManager m)
	{
		m.addEmployee(new ContractEmployee("Klaus", "Huber", 96));
		m.addEmployee(new PermanentEmployee("Eva", "Werner", 20000));
		m.addEmployee(new TemporaryEmployee("Hermann", "Schuster", 11));
		m.addEmployee(new TemporaryEmployee("Christine", "Winter", 12));
	}
	
	public void addEmployee (Employee employee)
	{
		if (employee != null)
			employeeList.add(employee);
	}
	
	public int size ()
	{
		return employeeList.size();
	}
	
	public int getNumberPermanentEmployees ()
	{
		int count = 0;
		
		for (Employee employee : employeeList)
		{
			if (employee instanceof PermanentEmployee)
				count++;
		}
		
		return count;
	}
	
	public int getNumberContractEmployees ()
	{
		int count = 0;
		
		for (Employee employee : employeeList)
		{
			if (employee instanceof ContractEmployee)
				count++;
		}
		
		return count;
	}
	
	public int getNumberTemporaryEmployees ()
	{
		int count = 0;
		
		for (Employee employee : employeeList)
		{
			if (employee instanceof TemporaryEmployee)
				count++;
		}
		
		return count;
	}
	
	public double calculateAverageHourlyRate ()
	{
		double average = 0;
		
		for (Employee employee : employeeList)
			average += employee.calculateHourlyRate();
		
		return average / size();
	}
	
	public void readFromFile (File data, File log) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(data));
		PrintWriter pw = new PrintWriter(new FileOutputStream(log, true));
		String firstLog = data.getAbsolutePath() + ": " + new Date().toString();
		String input;
		
		try
		{
			pw.println(firstLog);
			
			while ((input = br.readLine()) != null)
			{
				try
				{
					addEmployeeRecord(input);
					pw.println(input + " erfolgreich hinzugefügt");
				}
				catch (EmployeeDataCorruptedException edce)
				{
					pw.println(edce);
				}
			}
		}
		finally
		{
			pw.close();
		}
	}
	
	public void addEmployeeRecord (String anEmployee) throws EmployeeDataCorruptedException
	{
		String []splitted = anEmployee.split(":");
		
		if (splitted.length != 4)
			throw new EmployeeDataCorruptedException("Keine 4 Token: " + anEmployee);
		
		try
		{
			if (Double.parseDouble(splitted[3]) < 0)
				throw new EmployeeDataCorruptedException("Negativer Entlohnungswert " + splitted[3] + ": " + anEmployee);
			
		}
		catch (NumberFormatException nfe)
		{
			throw new EmployeeDataCorruptedException("Kein Doublewert " + splitted[3] + ": " + anEmployee);
		}
		
		try
		{
			switch (splitted[0])
			{
				case "C":
				case "c":
					addEmployee(new ContractEmployee(splitted[1], splitted[2], Double.parseDouble(splitted[3])));
					break;
				case "P":
				case "p":
					addEmployee(new PermanentEmployee(splitted[1], splitted[2], Double.parseDouble(splitted[3])));
					break;
				case "T":
				case "t":
					addEmployee(new TemporaryEmployee(splitted[1], splitted[2], Double.parseDouble(splitted[3])));
					break;
				default:
					throw new EmployeeDataCorruptedException("Falscher Employeetyp " + splitted[0] + ": " + anEmployee);
			}
		}
		catch (NumberFormatException nfe)
		{
			throw new EmployeeDataCorruptedException("Kein Doublewert " + splitted[3] + ": " + anEmployee);
		}
	}
	
	public void writeToFile (File data) throws IOException
	{
		PrintWriter pw = new PrintWriter(new FileOutputStream(data, true));
		Employee emp;
		
		try
		{
			for (int i = 0; i < employeeList.size(); i++)
			{
				emp = employeeList.get(i);
				//String data = emp.foo();
				// TODO: if, else if,... durch String data zeug ersetzen! mit abstract methode in Employee
				if (emp instanceof ContractEmployee)
					pw.println("C:" + emp.getFirstName() + ":" + emp.getLastName() + ":" + ((ContractEmployee) emp).getDailyRate());
				else if (emp instanceof PermanentEmployee)
					pw.println("C:" + emp.getFirstName() + ":" + emp.getLastName() + ":" + ((PermanentEmployee) emp).getSalary());
				else
					pw.println("C:" + emp.getFirstName() + ":" + emp.getLastName() + ":" + ((TemporaryEmployee) emp).getHourlyRate());
			}
		}
		finally
		{
			pw.close();
		}
	}
}
