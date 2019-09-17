package school.chif2.bruchhue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author scre
 */
public class BruchTest {
	
	@Test
	public void testSetBruchForm() {
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
		Bruch expected = new Bruch();
		Bruch result = null;
		try {
			result = new Bruch(0, 1);
			assertEquals(expected, result);
			new Bruch(5, 0);
			fail();
		} catch (BruchException be) {
			assertTrue(be.getMessage().contains("Nenner") && be.getMessage().contains("0"));
		}
		try {
			new Bruch("");
			fail();
		} catch (BruchException be) {
		}
		result = new Bruch(0);
		assertEquals(expected, result);
		try {
			expected = new Bruch(12);
			result = new Bruch(12.0);
			assertEquals(expected, result);
			result = new Bruch(12, 1);
			assertEquals(expected, result);
			
			expected = new Bruch(23.345);
			result = new Bruch(4669, 200);
			assertEquals(expected, result);
			result = new Bruch("23.345");
			assertEquals(expected, result);
			
			expected = new Bruch("12/15");
			result = new Bruch(4, 5);
			assertEquals(expected, result);
			result = new Bruch(0.8);
			assertEquals(expected, result);
		} catch (BruchException be) {
			fail();
		}
	}
	
	/**
	 * Test of add method, of class Bruch.
	 */
	@Test
	public void testAdd() {
		Bruch bruch2 = new Bruch(0);
		Bruch bruch1 = new Bruch();
		Bruch result = null;
		Bruch expected = new Bruch(0.0);
		try {
			bruch1.add(result);
			fail();
		} catch (BruchException be) {
		}
		try {
			result = bruch1.add(bruch2);
			assertEquals(expected, result);
			
			result = bruch1.add(new Bruch(1));
			expected = new Bruch(1.0);
			assertEquals(expected, result);
			result = bruch1.add(new Bruch("1"));
			assertEquals(expected, result);
			
			expected = new Bruch(2.0);
			assertEquals(expected, result.add(result));
			
			bruch2 = new Bruch(12, 23);
			result = bruch1.add(bruch2);
			expected = new Bruch(12, 23);
			assertEquals(expected, result);
			
			result = bruch2.add(new Bruch(1));
			expected = new Bruch(35, 23);
			assertEquals(expected, result);
			
			bruch1 = new Bruch(23, 35);
			bruch2 = new Bruch(12, 40);
			result = bruch1.add(bruch2);
			expected = new Bruch(67, 70);
			assertEquals(expected, result);
			
			bruch1 = new Bruch(321, 56);
			bruch2 = new Bruch(123, 27);
			result = bruch1.add(bruch2);
			expected = new Bruch(5185, 504);
			assertEquals(expected, result);
		} catch (BruchException be) {
			fail();
		}
	}
	
	/**
	 * Test of sub method, of class Bruch.
	 */
	@Test
	public void testSub() {
		Bruch bruch1 = null;
		Bruch bruch2 = new Bruch();
		Bruch expected = null;
		Bruch result = null;
		
		try {
			bruch2.sub(bruch1);
			fail();
		} catch (BruchException be) {
		}
		try {
			expected = new Bruch();
			assertEquals(expected, bruch2);
			
			bruch1 = new Bruch();
			bruch2 = new Bruch(12);
			expected = new Bruch(-12.0);
			result = bruch1.sub(bruch2);
			assertEquals(expected, result);
			
			bruch1 = new Bruch(-12);
			bruch2 = new Bruch(-12);
			expected = new Bruch();
			result = bruch1.sub(bruch2);
			assertEquals(expected, result);
			
			bruch2 = new Bruch(-12, -45);
			bruch1 = new Bruch(-2.33);
			result = bruch2.sub(bruch1);
			expected = new Bruch(779, 300);
			assertEquals(expected, result);
			expected = new Bruch(0);
			assertEquals(expected, bruch2.sub(bruch2));
			
			bruch2 = new Bruch(12345, -4545);
			bruch1 = new Bruch(20);
			result = bruch2.sub(bruch1);
			expected = new Bruch(6883, -303);
			assertEquals(expected, result);
			
			expected = bruch2.sub(expected);
			result = new Bruch(20);
			assertEquals(expected, result);
			
			expected = bruch2.sub(new Bruch(12.321));
			result = new Bruch(-4556263, 303000);
			assertEquals(expected, result);
		} catch (BruchException be) {
			fail();
		}
	}
	
	/**
	 * Test of mult method, of class Bruch.
	 */
	@Test
	public void testMult() {
		Bruch bruch2 = null;
		Bruch bruch1 = new Bruch();
		Bruch result;
		try {
			bruch1.mult(bruch2);
			fail();
		} catch (BruchException be) {
		}
		try {
			bruch2 = new Bruch(0, 1);
			result = bruch1.mult(bruch2);
			Bruch expected = new Bruch(0, 1);
			assertEquals(expected, result);
			
			result = bruch1.mult(new Bruch(10, 2));
			expected = new Bruch();
			assertEquals(expected, result);
			
			bruch2 = new Bruch(-123, 345);
			bruch1 = new Bruch(234, -456);
			result = bruch2.mult(bruch1);
			expected = new Bruch(1599, 8740);
			assertEquals(expected, result);
			
			result = result.mult(bruch1);
			expected = new Bruch(62361, -664240);
			assertEquals(expected, result);
		} catch (BruchException be) {
			fail();
		}
	}
	
	/**
	 * Test of div method, of class Bruch.
	 */
	@Test
	public void testDiv() {
		Bruch bruch2 = new Bruch();
		Bruch bruch1 = new Bruch(1);
		Bruch expected = new Bruch(1);
		Bruch result;
		try {
			assertEquals(expected, bruch1.div(bruch1));
			bruch1.div(bruch2);
			fail();
		} catch (BruchException be) {
		}
		try {
			expected.div(null);
			fail();
		} catch (BruchException be) {
		}
		try {
			bruch2 = new Bruch(23, 56);
			bruch1 = new Bruch(5);
			result = bruch2.div(bruch1);
			expected = new Bruch(23, 280);
			assertEquals(expected, result);
			
			bruch1 = new Bruch(23, 280);
			result = bruch1.div(bruch2);
			expected = new Bruch(1, 5);
			assertEquals(expected, result);
		} catch (BruchException be) {
			fail();
		}
	}
	
	/**
	 * Test of hoch method, of class Bruch.
	 */
	@Test
	public void testHoch() {
		try {
			int exponent = 0;
			Bruch bruch = new Bruch();
			Bruch result = bruch.hoch(exponent);
			Bruch expected = new Bruch(1);
			assertEquals(expected, result);
			
			exponent = 10;
			result = bruch.hoch(exponent);
			expected = new Bruch();
			assertEquals(expected, result);
			
			exponent = -10;
			try {
				bruch.hoch(exponent);
				fail();
			} catch (BruchException be) {
			}
			
			bruch = new Bruch(-12, 34);
			exponent = -3;
			result = bruch.hoch(exponent);
			expected = new Bruch(-4913, 216);
			assertEquals(expected, result);
			
			exponent = 3;
			result = bruch.hoch(exponent);
			expected = new Bruch(-216, 4913);
			assertEquals(expected, result);
			
			exponent = -5;
			bruch = new Bruch(2.45);
			result = bruch.hoch(exponent);
			expected = new Bruch(3200000, 282475249);
			assertEquals(expected, result);
		} catch (BruchException be) {
			fail();
		}
	}
	
	/**
	 * Test of addThis method, of class Bruch.
	 */
	@Test
	public void testAddThis() {
		Bruch bruch2 = null;
		Bruch bruch1 = new Bruch();
		Bruch expected = new Bruch(1);
		
		bruch1.addThis(bruch2);
		assertEquals(bruch1, bruch1);
		
		bruch1.addThis(expected);
		assertEquals(expected, bruch1);
		
		try {
			bruch2 = new Bruch(12, 23);
			bruch1 = new Bruch();
			bruch1.addThis(bruch2);
			expected = new Bruch(12, 23);
			assertEquals(expected, bruch1);
			
			bruch1.addThis(new Bruch(1));
			expected = new Bruch(35, 23);
			assertEquals(expected, bruch1);
			
			bruch1 = new Bruch(23, 35);
			bruch2 = new Bruch(12, 40);
			bruch1.addThis(bruch2);
			expected = new Bruch(67, 70);
			assertEquals(expected, bruch1);
			
			bruch1 = new Bruch(321, 56);
			bruch2 = new Bruch(123, 27);
			bruch1.addThis(bruch2);
			expected = new Bruch(5185, 504);
			assertEquals(expected, bruch1);
		} catch (BruchException be) {
			fail();
		}
	}
	
	/**
	 * Test of subThis method, of class Bruch.
	 */
	@Test
	public void testSubThis() {
		Bruch bruch2 = null;
		Bruch bruch1 = new Bruch();
		Bruch expected = new Bruch(0);
		
		bruch1.subThis(bruch2);
		assertEquals(expected, bruch1);
		try {
			bruch1 = new Bruch();
			bruch2 = new Bruch();
			bruch1.subThis(bruch2);
			assertEquals(expected, bruch1);
			bruch1.subThis(bruch2);     // x - 0 - 0 = x
			assertEquals(expected, bruch1);
			
			bruch1 = new Bruch(-12, -45);
			bruch2 = new Bruch(-2.33);
			bruch1.subThis(bruch2);
			expected = new Bruch(779, 300);
			assertEquals(expected, bruch1);
			
			bruch1.subThis(bruch1);
			expected = new Bruch(0);
			assertEquals(expected, bruch1);
			
			bruch1 = new Bruch(12345, -4545);
			bruch2 = new Bruch(20);
			bruch1.subThis(bruch2);
			expected = new Bruch(6883, -303);
			assertEquals(expected, bruch1);
			
			bruch1 = new Bruch(12345, -4545);
			bruch2 = new Bruch(6883, -303);
			bruch1.subThis(bruch2);
			expected = new Bruch(20);
			assertEquals(expected, bruch1);
			
			bruch1 = new Bruch(12345, -4545);
			bruch2 = new Bruch(12.321);
			bruch1.subThis(bruch2);
			expected = new Bruch(-4556263, 303000);
			assertEquals(expected, bruch1);
		} catch (BruchException be) {
			fail();
		}
	}
	
	/**
	 * Test of multThis method, of class Bruch.
	 */
	@Test
	public void testMultThis() {
		Bruch bruch2 = new Bruch();
		Bruch bruch1 = new Bruch();
		Bruch expected = new Bruch();
		
		bruch1.multThis(bruch2);
		assertEquals(expected, bruch1);
		
		bruch1.multThis(bruch2);
		assertEquals(expected, bruch1);
		
		try {
			bruch1 = new Bruch();
			bruch2 = new Bruch(10, 2);
			bruch1.multThis(bruch2);
			expected = new Bruch();
			assertEquals(bruch1, expected);
			
			bruch1 = new Bruch();
			bruch2 = new Bruch(10, 2);
			bruch2.multThis(bruch1);
			expected = new Bruch();
			assertEquals(bruch1, expected);
			
			bruch2 = new Bruch(-123, 345);
			bruch1 = new Bruch(234, -456);
			bruch2.multThis(bruch1);
			expected = new Bruch(1599, 8740);
			assertEquals(expected, bruch2);
			
			bruch2 = new Bruch(1599, 8740);
			bruch2.multThis(bruch1);
			expected = new Bruch(62361, -664240);
			assertEquals(expected, bruch2);
		} catch (BruchException be) {
			fail();
		}
	}
	
	/**
	 * Test of divThis method, of class Bruch.
	 */
	@Test
	public void testDivThis() {
		Bruch bruch2 = null;
		Bruch bruch1 = new Bruch();
		
		try {
			bruch1.divThis(bruch2);
			Bruch expected = new Bruch();
			assertEquals(expected, bruch1);
			
			bruch2 = new Bruch(1);
			bruch1.divThis(bruch2);
			assertEquals(expected, bruch1);
			
			try {
				expected.divThis(bruch1);
				fail();
			} catch (BruchException be) {
			}
			
			bruch2 = new Bruch(23, 56);
			bruch1 = new Bruch(5);
			bruch2.divThis(bruch1);
			expected = new Bruch(23, 280);
			assertEquals(expected, bruch2);
			
			bruch1 = new Bruch(23, 280);
			bruch2 = new Bruch(120, -69);
			bruch1.divThis(bruch2);
			expected = new Bruch(-529, 11200);
			assertEquals(expected, bruch1);
		} catch (BruchException be) {
			fail();
		}
	}
	
	/**
	 * Test of hochThis method, of class Bruch.
	 */
	@Test
	public void testHochThis() {
		int exponent = 0;
		Bruch bruch = new Bruch();
		Bruch expected = new Bruch(1);
		
		try {
			bruch.hochThis(exponent);
			assertEquals(expected, bruch);
			
			exponent = 10;
			bruch = new Bruch();
			bruch.hochThis(exponent);
			expected = new Bruch();
			assertEquals(expected, bruch);
			
			exponent = -10;
			try {
				bruch.hochThis(exponent);
				fail();
			} catch (BruchException be) {
			}
			
			bruch = new Bruch(-12, 34);
			exponent = -3;
			bruch.hochThis(exponent);
			expected = new Bruch(-4913, 216);
			assertEquals(expected, bruch);
			
			exponent = 3;
			bruch = new Bruch(-12, 34);
			bruch.hochThis(exponent);
			expected = new Bruch(-216, 4913);
			assertEquals(expected, bruch);
			
			bruch = new Bruch(2.45);
			bruch.hochThis(-5);
			expected = new Bruch(3200000, 282475249);
			assertEquals(expected, bruch);
		} catch (BruchException be) {
			fail();
		}
	}
	
	/**
	 * Test of toString method, of class Bruch.
	 *
	 * @throws BruchException
	 */
	@Test
	public void testToString() throws BruchException {
		Bruch.setBruchFormat(true);
		Bruch bruch = new Bruch();
		String expected = "0/1";
		String result = bruch.toString();
		assertEquals(expected, result);
		
		bruch = new Bruch(-12, -45);
		result = bruch.toString();
		expected = "4/15";
		assertEquals(expected, result);
		
		Bruch.setBruchFormat(false);
		result = bruch.toString();
		expected = "0,267";
		assertEquals(expected, result);
		
		bruch = new Bruch();
		result = bruch.toString();
		expected = "0,000";
		assertEquals(expected, result);
		
		bruch = new Bruch(-134);
		result = bruch.toString();
		expected = "-134,000";
		assertEquals(expected, result);
		
		Bruch.setBruchFormat(true);
		result = bruch.toString();
		expected = "-134/1";
		assertEquals(expected, result);
		
		bruch = new Bruch(-12.45);
		result = bruch.toString();
		expected = "-249/20";
		assertEquals(expected, result);
		
		Bruch.setBruchFormat(false);
		result = bruch.toString();
		expected = "-12,450";
		assertEquals(expected, result);
	}
	
	/**
	 * Test of isBruchFormat method, of class Bruch.
	 */
	@Test
	public void testIsBruchFormat() {
		Bruch.setBruchFormat(true);
		boolean result = Bruch.isBruchFormat();
		assertTrue(result);
		
		Bruch.setBruchFormat(false);
		result = Bruch.isBruchFormat();
		assertFalse(result);
	}
	
	/**
	 * Test of ggT method, of class Bruch.
	 */
	@Test
	public void testGgT() {
		long result = Bruch.ggT(-12234, 2445);
		int expected = 3;
		assertEquals(expected, result);
		
		result = Bruch.ggT(-122345, -2445);
		expected = 5;
		assertEquals(expected, result);
		
		result = Bruch.ggT(5731630053L, -5737911553L);
		expected = 12563;
		assertEquals(expected, result);
		
		result = Bruch.ggT(256728, 2581918);
		expected = 1126;
		assertEquals(expected, result);
	}
	
	/**
	 * Test of kgV method, of class Bruch.
	 */
	@Test
	public void testKgV() {
		long result = Bruch.kgV(-1234, -64);
		int expected = 39488;
		assertEquals(expected, result);
		
		result = Bruch.kgV(1234, -64);
		assertEquals(expected, result);
		
		result = Bruch.kgV(-1234, 64);
		assertEquals(expected, result);
		
		result = Bruch.kgV(12134, 624);
		expected = 3785808;
		assertEquals(expected, result);
		
		result = Bruch.kgV(2134, 1);
		expected = 2134;
		assertEquals(expected, result);
	}
	
	/**
	 * Test of equals method, of class Bruch.
	 *
	 * @throws BruchException
	 */
	@Test
	public void testEquals() throws BruchException {
		Bruch bruch1 = new Bruch(1);
		Bruch bruch2 = new Bruch(1.000);
		assertEquals(bruch1, bruch2);
		
		bruch1 = new Bruch("1");
		bruch2 = new Bruch("1/1");
		assertEquals(bruch1, bruch2);
		
		bruch1 = new Bruch("15/-12");
		bruch2 = new Bruch(-5, 4);
		assertEquals(bruch1, bruch2);
		
		bruch1 = new Bruch("-1.25");
		bruch2 = new Bruch(5, -4);
		assertEquals(bruch1, bruch2);
		
		bruch1 = new Bruch("-1.25");
		bruch2 = new Bruch(-1.2500);
		assertEquals(bruch1, bruch2);
	}
	
}