package school.chif2.bruchhue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author maus
 */

public class BruchTestOld
{
	
	public BruchTestOld () {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}
	
	/**
	 * Test of setBruchForm method, of class Bruch.
	 */
	@Test
	public void testSetBruchForm() {
		System.out.println("isBruchOderDezimal");
		//Startzustand
		Bruch.setBruchFormat(true);
		boolean expResult = true;
		boolean result = Bruch.isBruchFormat();
		assertEquals(expResult, result);
		Bruch.setBruchFormat(false);
		assertFalse(Bruch.isBruchFormat());
		Bruch.setBruchFormat(true);
		assertTrue(Bruch.isBruchFormat());
	}
	
	/**
	 * Test of Constructor, of class Bruch.
	 */
	@Test
	public void testBruch() {
		System.out.println("Constructor");
		Bruch instance = null;
		Bruch expResult = null;
		Bruch result = null;
		
		instance = new Bruch();
		try {
			assertEquals(new Bruch(0, 1), instance);
			expResult = new Bruch(5, 0);
		} catch (BruchException be) {
			assertTrue(be.getMessage().contains("Nenner") && be.getMessage().contains("0"));
			System.out.println("Fehler richtig behandelt");
		}
		try {
			result = new Bruch("");
		} catch (BruchException be) {
			System.out.println("Fehler richtig behandelt");
		}
		
		assertEquals(new Bruch(0), instance);
		try {
			instance = new Bruch(12);
			expResult = new Bruch(23.345);
			result = new Bruch("12/15");
			assertEquals(new Bruch(12.0), instance);
			assertEquals(new Bruch(12, 1), instance);
			assertEquals(new Bruch(4669, 200), expResult);
			assertEquals(new Bruch("23.345"), expResult);
			assertEquals(new Bruch(4, 5), result);
			assertEquals(new Bruch(0.8), result);
		} catch (BruchException be) {
			System.err.println("Fehler falsch behandelt");
		}
	}
	
	/**
	 * Test of add method, of class Bruch.
	 */
	@Test
	public void testAdd() {
		System.out.println("add");
		Bruch b = new Bruch(0);
		Bruch instance = new Bruch();
		Bruch result = null;
		Bruch expResult = new Bruch(0.0);
		try {
			result = instance.add(result);
		} catch (BruchException be) {
			System.out.println("Fehler richtig behandelt");
		}
		try {
			result = instance.add(b);
			assertEquals(expResult, result);
			result = instance.add(new Bruch(1));
			assertEquals(new Bruch(1.0), result);
			result = instance.add(new Bruch("1"));
			assertEquals(new Bruch(1.0), result);
			assertEquals(new Bruch(2.0), result.add(result));
			b = new Bruch(12, 23);
			result = instance.add(b);
			assertEquals(new Bruch(12, 23), result);
			result = b.add(new Bruch(1));
			assertEquals(new Bruch(35, 23), result);
			instance = new Bruch(23, 35);
			b = new Bruch(12, 40);
			result = instance.add(b);
			expResult = new Bruch(67, 70);
			assertEquals(expResult, result);
			instance = new Bruch(321, 56);
			b = new Bruch(123, 27);
			result = instance.add(b);
			expResult = new Bruch(5185, 504);
			assertEquals(expResult, result);
		} catch (BruchException be) {
			System.err.println("Fehler falsch behandelt");
		}
	}
	
	/**
	 * Test of sub method, of class Bruch.
	 */
	@Test
	public void testSub() {
		System.out.println("sub");
		Bruch b = null;
		Bruch instance = new Bruch();
		Bruch expResult = new Bruch(-12.0);
		Bruch result = null;
		
		try {
			result = instance.sub(b);
		} catch (BruchException be) {
			System.out.println("Fehler richtig behandelt");
		}
		try {
			assertEquals(instance.sub(instance), instance);
			assertEquals(new Bruch(12), instance.sub(expResult));
			assertEquals(expResult, expResult.sub(instance));
			instance = new Bruch(-12, -45);
			b = new Bruch(-2.33);
			result = instance.sub(b);
			assertEquals(new Bruch(779, 300), result);
			assertEquals(new Bruch(0), instance.sub(instance));
			instance = new Bruch(12345, -4545);
			b = new Bruch(20);
			result = instance.sub(b);
			expResult = new Bruch(6883, -303);
			assertEquals(expResult, result);
			expResult = instance.sub(expResult);
			assertEquals(expResult, new Bruch(20));
			expResult = instance.sub(new Bruch(12.321));
			assertEquals(expResult, new Bruch(-4556263, 303000));
		} catch (BruchException be) {
			System.err.println("Fehler falsch behandelt");
		}
	}
	
	/**
	 * Test of mult method, of class Bruch.
	 */
	@Test
	public void testMult() {
		System.out.println("mult");
		Bruch b = null;
		Bruch instance = new Bruch();
		Bruch result;
		try {
			result = instance.mult(b);
		} catch (BruchException be) {
			System.out.println("Fehler richtig behandelt");
		}
		try {
			Bruch expResult = new Bruch(0, 1);
			result = instance.mult(expResult);
			assertEquals(expResult, result);
			result = instance.mult(new Bruch(10, 2));
			assertEquals(instance, result);
			b = new Bruch(-123, 345);
			instance = new Bruch(234, -456);
			result = b.mult(instance);
			assertEquals(new Bruch(1599, 8740), result);
			result = result.mult(instance);
			assertEquals(new Bruch(62361, -664240), result);
		} catch (BruchException be) {
			System.err.println("Fehler falsch behandelt");
		}
	}
	
	/**
	 * Test of div method, of class Bruch.
	 */
	@Test
	public void testDiv() {
		System.out.println("div");
		Bruch b = null;
		Bruch instance = new Bruch();
		Bruch expResult = new Bruch(1);
		Bruch result;
		try {
			assertEquals(instance.div(expResult), instance);
			b = expResult.div(instance);
		} catch (BruchException be) {
			System.out.println("Fehler richtig behandelt");
		}
		try {
			b = expResult.div(null);
		} catch (BruchException be) {
			System.out.println("Fehler richtig behandelt");
		}
		try {
			b = new Bruch(23, 56);
			instance = new Bruch(5);
			result = b.div(instance);
			expResult = new Bruch(23, 280);
			assertEquals(expResult, result);
			result = expResult.div(b);
			assertEquals(new Bruch(1, 5), result);
		} catch (BruchException be) {
			System.err.println("Fehler falsch behandelt");
		}
	}
	
	/**
	 * Test of hoch method, of class Bruch.
	 */
	@Test
	public void testHoch() {
		System.out.println("hoch");
		int e = 0;
		Bruch instance = new Bruch();
		Bruch expResult = new Bruch(1);
		try {
			Bruch result = instance.hoch(e);
			assertEquals(expResult, result);
			e = 10;
			result = instance.hoch(e);
			assertEquals(instance, result);
			e = -10;
			try {
				result = instance.hoch(e);
			} catch (BruchException be) {
				System.out.println("Fehler richtig behandelt");
			}
			
			instance = new Bruch(-12, 34);
			e = -3;
			result = instance.hoch(e);
			assertEquals(new Bruch(-4913, 216), result);
			e = 3;
			result = instance.hoch(e);
			assertEquals(new Bruch(-216, 4913), result);
			result = new Bruch(2.45).hoch(-5);
			assertEquals(new Bruch(3200000, 282475249), result);
		} catch (BruchException be) {
			System.err.println("Fehler falsch behandelt");
		}
	}
	
	/**
	 * Test of addThis method, of class Bruch.
	 */
	@Test
	public void testAddThis() {
		System.out.println("addThis");
		Bruch b = null;
		Bruch instance = new Bruch();
		Bruch expResult = new Bruch(1);
		
		instance.addThis(b);
		assertEquals(instance, instance);
		instance.addThis(expResult);
		assertEquals(expResult, instance);
		try {
			b = new Bruch(12, 23);
			instance = new Bruch();
			instance.addThis(b);
			assertEquals(new Bruch(12, 23), instance);
			instance.addThis(new Bruch(1));
			assertEquals(new Bruch(35, 23), instance);
			instance = new Bruch(23, 35);
			b = new Bruch(12, 40);
			instance.addThis(b);
			expResult = new Bruch(67, 70);
			assertEquals(expResult, instance);
			instance = new Bruch(321, 56);
			b = new Bruch(123, 27);
			instance.addThis(b);
			expResult = new Bruch(5185, 504);
			assertEquals(expResult, instance);
		} catch (BruchException be) {
			System.err.println("Fehler falsch behandelt");
		}
	}
	
	/**
	 * Test of subThis method, of class Bruch.
	 */
	@Test
	public void testSubThis() {
		System.out.println("subThis");
		Bruch b = null;
		Bruch instance = new Bruch();
		Bruch expResult = new Bruch(0);
		
		instance.subThis(b);
		assertEquals(expResult, instance);
		try {
			instance = new Bruch();
			instance.subThis(expResult);
			assertEquals(expResult, instance);
			instance.subThis(expResult);
			assertEquals(expResult, instance);
			instance = new Bruch(-12, -45);
			b = new Bruch(-2.33);
			instance.subThis(b);
			assertEquals(new Bruch(779, 300), instance);
			instance.subThis(instance);
			assertEquals(new Bruch(0), instance);
			instance = new Bruch(12345, -4545);
			b = new Bruch(20);
			instance.subThis(b);
			expResult = new Bruch(6883, -303);
			assertEquals(expResult, instance);
			instance = new Bruch(12345, -4545);
			instance.subThis(expResult);
			assertEquals(instance, new Bruch(20));
			instance = new Bruch(12345, -4545);
			instance.subThis(new Bruch(12.321));
			assertEquals(instance, new Bruch(-4556263, 303000));
		} catch (BruchException be) {
			System.err.println("Fehler falsch behandelt");
		}
	}
	
	/**
	 * Test of multThis method, of class Bruch.
	 */
	@Test
	public void testMultThis() {
		System.out.println("multThis");
		Bruch b = null;
		Bruch instance = new Bruch();
		Bruch expResult = new Bruch(0);
		
		instance.multThis(b);
		assertEquals(expResult, instance);
		instance.multThis(expResult);
		assertEquals(expResult, instance);
		try {
			instance = new Bruch();
			expResult = new Bruch(10, 2);
			expResult.multThis(instance);
			assertEquals(instance, expResult);
			b = new Bruch(-123, 345);
			instance = new Bruch(234, -456);
			b.multThis(instance);
			expResult = new Bruch(1599, 8740);
			assertEquals(expResult, b);
			expResult.multThis(instance);
			assertEquals(new Bruch(62361, -664240), expResult);
		} catch (BruchException be) {
			System.err.println("Fehler falsch behandelt");
		}
	}
	
	/**
	 * Test of divThis method, of class Bruch.
	 */
	@Test
	public void testDivThis() {
		System.out.println("divThis");
		Bruch b = null;
		Bruch instance = new Bruch();
		Bruch expResult = new Bruch(1);
		try {
			instance.divThis(b);
			assertEquals(instance, instance);
			instance.divThis(expResult);
			assertEquals(instance, instance);
			try {
				expResult.divThis(instance);
			} catch (BruchException be) {
				System.out.println("Fehler richtig behandelt");
			}
			b = new Bruch(23, 56);
			instance = new Bruch(5);
			b.divThis(instance);
			expResult = new Bruch(23, 280);
			assertEquals(expResult, b);
			expResult.divThis(new Bruch(120, -69));
			assertEquals(new Bruch(-529, 11200), expResult);
		} catch (BruchException be) {
			System.err.println("Fehler falsch behandelt");
		}
	}
	
	/**
	 * Test of hochThis method, of class Bruch.
	 */
	@Test
	public void testHochThis() {
		System.out.println("hochThis");
		int e = 0;
		Bruch instance = new Bruch();
		Bruch expResult = new Bruch(1);
		
		try {
			instance.hochThis(e);
			assertEquals(expResult, instance);
			e = 10;
			instance = new Bruch();
			instance.hochThis(e);
			assertEquals(instance, new Bruch(0));
			e = -10;
			try {
				instance.hochThis(e);
			} catch (BruchException be) {
				System.out.println("Fehler richtig behandelt");
			}
			instance = new Bruch(-12, 34);
			e = -3;
			instance.hochThis(e);
			assertEquals(new Bruch(-4913, 216), instance);
			e = 3;
			instance = new Bruch(-12, 34);
			instance.hochThis(e);
			assertEquals(new Bruch(-216, 4913), instance);
			instance = new Bruch(2.45);
			instance.hochThis(-5);
			assertEquals(new Bruch(3200000, 282475249), instance);
		} catch (BruchException be) {
			System.err.println("Fehler falsch behandelt");
		}
	}
	
	/**
	 * Test of toString method, of class Bruch.
	 * @throws BruchException
	 */
	@Test
	public void testToString() throws BruchException {
		System.out.println("toString");
		Bruch.setBruchFormat(true);
		Bruch instance = new Bruch();
		String expResult = "0/1";
		String result = instance.toString();
		assertEquals(expResult, result);
		instance = new Bruch(-12, -45);
		assertEquals(instance.toString(), "4/15");
		Bruch.setBruchFormat(false);
		assertEquals(instance.toString(), "0,267");
		instance = new Bruch();
		assertEquals(instance.toString(), "0,000");
		instance = new Bruch(-134);
		assertTrue(instance.toString().equals("-134,000"));
		Bruch.setBruchFormat(true);
		assertTrue(instance.toString().equals("-134/1"));
		instance = new Bruch(-12.45);
		assertEquals(instance.toString(), "-249/20");
		Bruch.setBruchFormat(false);
		assertEquals(instance.toString(), "-12,450");
	}
	
	/**
	 * Test of isBruchFormat method, of class Bruch.
	 */
	@Test
	public void testIsBruchFormat() {
		System.out.println("isBruchFormat");
		Bruch.setBruchFormat(true);
		boolean result = Bruch.isBruchFormat();
		assertTrue(result);
		Bruch.setBruchFormat(false);
		assertFalse(Bruch.isBruchFormat());
	}
	
	/**
	 * Test of ggT method, of class Bruch.
	 */
	@Test
	public void testGgT() {
		System.out.println("ggT");
		long result = Bruch.ggT(-12234, 2445);
		assertEquals(3, result);
		assertEquals(Bruch.ggT(-122345, -2445), 5);
		assertEquals(Bruch.ggT(5731630053L, -5737911553L), 12563);
		assertEquals(Bruch.ggT(256728, 2581918), 1126);
	}
	
	/**
	 * Test of kgV method, of class Bruch.
	 */
	@Test
	public void testKgV() {
		System.out.println("kgV");
		assertEquals(Bruch.kgV(-1234, -64), 39488);
		assertEquals(Bruch.kgV(1234, -64), 39488);
		assertEquals(Bruch.kgV(-1234, 64), 39488);
		assertEquals(Bruch.kgV(12134, 624), 3785808);
		assertEquals(Bruch.kgV(2134, 1), 2134);
	}
	
	/**
	 * Test of equals method, of class Bruch.
	 * @throws BruchException
	 */
	@Test
	public void testEquals() throws BruchException {
		System.out.println("equals");
		assertEquals(new Bruch(1), new Bruch(1.000));
		assertEquals(new Bruch("1"), new Bruch("1/1"));
		assertEquals(new Bruch("15/-12"), new Bruch(-5,4));
		assertEquals(new Bruch("-1.25"), new Bruch(5,-4));
		assertEquals(new Bruch("-1.25"), new Bruch(-1.2500));
	}
	
	
}
