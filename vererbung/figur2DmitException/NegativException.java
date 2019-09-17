package school.chif2.vererbung.figur2DmitException;

public class NegativException extends Exception
{
	public NegativException ()
	{
		super();
	}
	
	public NegativException (String msg)
	{
		super(msg);
	}
}
