package school.chif2.datumBiorythmus;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DatumTest {
	
	static String[] months = {"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"};
	static String[] tage = {"Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"};
	
	public DatumTest() {
		super();
	}
	
	@BeforeClass
	public static void setUpClass() throws Exception {
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}
	
	@Test
	public void testIsValid() {
		System.out.println("isValid");
		assertTrue(new Datum(29, 2, 2000).isValid());
		assertFalse(new Datum(29, 2, 1900).isValid());
		assertFalse(new Datum(35, 7, 2005).isValid());
		assertFalse(new Datum(29, 2, 2001).isValid());
		assertTrue(new Datum(31, 10, 1985).isValid());
		assertFalse(new Datum(31, 4, 2005).isValid());
		assertFalse(new Datum(-31, 10, 1985).isValid());
	}
	
	@Test
	public void testWochentag1() {
		System.out.println("Wochentag_1");
		Datum d = new Datum(25, 12, 1988);
		assertEquals("Sonntag", d.wochentag());
		assertEquals(6, d.wochentagNummer());
		d = new Datum(1, 3, 2011);
		assertEquals("Dienstag", d.wochentag());
		assertEquals(1, d.wochentagNummer());
		d = new Datum(31, 4, 1950);    // ungueltiges Datum
		assertNull(d.wochentag());
		assertEquals(-1, d.wochentagNummer());
	}
	
	@Test
	public void testKontruktorTage() {
		System.out.println("Konstruktor");
		Datum d = new Datum(17328);
		assertEquals(12, d.getTag());
		assertEquals(6, d.getMonat());
		assertEquals(1947, d.getJahr());
		d = new Datum(0);
		assertEquals(1, d.getTag());
		assertEquals(1, d.getMonat());
		assertEquals(1900, d.getJahr());
		d = new Datum(-13);
		assertFalse(d.isValid());
	}
	
	@Test
	public void testWochentag2() {
		System.out.println("Wochentag_2");
		Datum d = new Datum(31, 4, 1950);    // ungueltiges Datum
		assertNull(d.wochentag());
		assertEquals(-1, d.wochentagNummer());
	}
	
	@Test
	public void testAddTage1() {
		System.out.println("AddTage_1");
		Datum d = new Datum(28, 02, 2000);
		d.addiereTage(365);
		assertEquals("27.02.2001", d.toString());
	}
	
	@Test
	public void testAddTage2() {
		System.out.println("AddTage_2");
		Datum d = new Datum(100);
		d.addiereTage(-100);
		assertEquals("01.01.1900", d.toString());
	}
	
	@Test
	public void testAddTage3() {
		System.out.println("AddTage_3");
		Datum d = new Datum(100);
		d.addiereTage(-101);
		assertFalse(d.isValid());
//    d = new Datum(31, 12, 2999);
//    d.addiereTage(1);
		//TODO 3000-Test
	}
	
	@Test
	public void testDazwischen() {
		System.out.println("Dazwischen");
		Datum d1 = new Datum(1, 1, 2003);
		Datum d2 = new Datum(1, 1, 2004);
		assertEquals(365, Datum.tageZwischen(d1, d2));
		d1 = new Datum(6, 2, 1969);
		d2 = new Datum(10, 4, 2008);
		assertEquals(14308, Datum.tageZwischen(d1, d2));
		assertEquals(-14308, Datum.tageZwischen(d2, d1));
		d1 = new Datum(26, 2, 2008);
		d2 = new Datum(3, 3, 2008);
		assertEquals(6, Datum.tageZwischen(d1, d2));
	}
	
	@Test
	public void testToString() {
		System.out.println("toString");
		Datum d = new Datum(14, 4, 2008);
		assertEquals("14.04.08", d.toString(Datum.SHORT));
		assertEquals("14.04.2008", d.toString(Datum.NORMAL));
		assertEquals("14.April 2008, Montag", d.toString(Datum.LONG));
		assertEquals("2008/14/04", d.toString(Datum.US));
	}
	
	public void testCompareTo() {
		System.out.println("compareTo");
		Datum d1 = new Datum(12, 2, 2007);
		Datum d2 = new Datum(13, 2, 2007);
		Datum d3 = new Datum(12, 2, 2007);
		
		assertTrue(d1.compareTo(d2) < 0);
		assertTrue(d2.compareTo(d1) > 0);
		assertTrue(d1.compareTo(d3) == 0);
	}
	
	/**
	 * Test of getMonatByString method, of class Datum.
	 */
	@Test
	public void testGetMonatByString() {
		System.out.println("getMonatByString");
		for (int i = 1; i < months.length + 1; i++) {
			Datum d = new Datum(1, i, 1900);
			switch (i) {
				case 1:
					assertTrue("Jänner".equals(d.getMonatByString()) || "Jaenner".equals(d.getMonatByString()) || "Januar".equals(d.getMonatByString()));
					break;
				case 3:
					assertTrue("März".equals(d.getMonatByString()) || "Maerz".equals(d.getMonatByString()));
					break;
				default:
					assertEquals(months[i - 1], d.getMonatByString());
			}
		}
	}
	
	/**
	 * Test of wochentagNummer method, of class Datum.
	 */
	@Test
	public void testWochentagNummer() {
		System.out.println("wochentagNummer");
		Datum d = new Datum(5, 3, 2018);
		for (int i = 0; i < 7; i++) {
			assertEquals(i, d.wochentagNummer());
			d.addiereTage(1);
		}
		
	}
	
	/**
	 * Test of wochentag method, of class Datum.
	 */
	@Test
	public void testWochentag() {
		System.out.println("wochentag");
		Datum d = new Datum(5, 3, 2018);
		for (int i = 0; i < 7; i++) {
			assertEquals(tage[i], d.wochentag());
			d.addiereTage(1);
		}
	}
	
	/**
	 * Test of schaltjahr method, of class Datum.
	 */
	@Test
	public void testSchaltjahr() {
		System.out.println("schaltjahr");
		assertFalse(Datum.schaltjahr(1900));
		assertFalse(Datum.schaltjahr(1907));
		assertFalse(Datum.schaltjahr(1901));
		assertFalse(Datum.schaltjahr(1999));
		assertTrue(Datum.schaltjahr(2000));
		assertTrue(Datum.schaltjahr(1904));
		assertTrue(Datum.schaltjahr(2016));
	}
}