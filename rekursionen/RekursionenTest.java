package school.chif2.rekursionen;

import org.junit.Test;

import static org.junit.Assert.*;

public class RekursionenTest
{
	@Test
	public void testRekursivEins ()
	{
		Rekursionen rek = new Rekursionen();
		double eps = 0.0001;
		
		assertEquals(0.0000, rek.rekursivEins(0), eps);
		rek = new Rekursionen();
		assertEquals(1.0000, rek.rekursivEins(1), eps);
		rek = new Rekursionen();
		assertEquals(0.6666, rek.rekursivEins(2), eps);
		rek = new Rekursionen();
		assertEquals(0.8666, rek.rekursivEins(3), eps);
		rek = new Rekursionen();
		assertEquals(0.7238, rek.rekursivEins(4), eps);
		rek = new Rekursionen();
		assertEquals(0.8349, rek.rekursivEins(5), eps);
	}
	
	@Test
	public void testFib ()
	{
		Rekursionen rek = new Rekursionen();
		assertEquals(0, rek.fib(0));
		assertEquals(1, rek.fib(1));
		assertEquals(1, rek.fib(2));
		assertEquals(2, rek.fib(3));
		assertEquals(3, rek.fib(4));
		assertEquals(5, rek.fib(5));
		assertEquals(8, rek.fib(6));
		assertEquals(13, rek.fib(7));
		assertEquals(21, rek.fib(8));
		assertEquals(34, rek.fib(9));
		assertEquals(55, rek.fib(10));
	}
	
	@Test
	public void testGgT ()
	{
		Rekursionen rek = new Rekursionen();
		assertEquals(2, rek.ggT(2, 2));
		assertEquals(7, rek.ggT(7, 49));
		assertEquals(21, rek.ggT(21, 42));
		assertEquals(2, rek.ggT(38, 6));
		assertEquals(7, rek.ggT(21, 56));
		assertEquals(1, rek.ggT(23, 26));
		assertEquals(56, rek.ggT(0, 56));
	}
	
	@Test
	public void testPa ()
	{
		Rekursionen rek = new Rekursionen();
		assertEquals(1, rek.pa(0, 0));
		assertEquals(0, rek.pa(5, 7));
		assertEquals(1, rek.pa(7, 7));
		assertEquals(2, rek.pa(2, 1));
		assertEquals(10, rek.pa(5, 2));
		assertEquals(0, rek.pa(-1, 1));
		assertEquals(0, rek.pa(1, -1));
		assertEquals(0, rek.pa(-1, -2));
	}
}