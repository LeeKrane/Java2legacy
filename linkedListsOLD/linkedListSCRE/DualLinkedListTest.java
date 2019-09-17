package school.chif2.linkedListsOLD.linkedListSCRE;

import java.util.Objects;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DualLinkedListTest {
	
	LinkedList list;
	
	@Before
	public void setUp() {
		list = new LinkedList();
		list.add("Eins");
		list.add("Zwei");
		list.add("Drei");
	}
	
	/**
	 * Vergleicht zwei LinkedList Objekte auf equals-Gleichheit.
	 *
	 * @param l1 erste LinkedList
	 * @param l2 zweite LinkedList
	 * @return true wenn komplett gleich, sonst false
	 */
	private static boolean equal(LinkedList l1, LinkedList l2) {
		if (l1 == null && l2 == null) {
			return true;
		}
		if (l1 == null || l2 == null) {
			return false;
		}
		if (l1.size() != l2.size()) {
			return false;
		}
		for (int i = 0; i < l1.size(); i++) {
			boolean equal = Objects.equals(l1.get(i), l2.get(i));
			if (!equal) {
				return false;
			}
		}
		testConsistent(l1);
		return true;
	}
	
	/**
	 * Testet, ob die doppelt verkettete Liste von vorn und hinten gelesen gleich
	 * ist.
	 *
	 * @param list doppelt verkettete Liste
	 */
	private static void testConsistent(LinkedList list) {
	
	}
	
	/**
	 * Test of size method, of class LinkedList.
	 */
	@Test
	public void testSize() {
		System.out.println("size");
		assertEquals(3, list.size());
		list = new LinkedList();
		assertEquals(0, list.size());
		list.add(3);
		assertEquals(1, list.size());
		list.add(3);
		assertEquals(2, list.size());
	}
	
	/**
	 * Test of delNode method, of class LinkedList.
	 */
	@Test
	public void testDel() {
		System.out.println("del");
		LinkedList tmp = new LinkedList();
//    assertNull(tmp.del(0));
//    assertNull(list.del(-5));
//    assertNull(list.del(3));
		assertEquals("Eins", list.del(0));
		testConsistent(tmp);
		LinkedList ref = new LinkedList();
		ref.add("Zwei");
		ref.add("Drei");
		assertTrue(equal(ref, list));
		testConsistent(list);
		setUp();
		assertEquals("Zwei", list.del(1));
		testConsistent(list);
		ref = new LinkedList();
		ref.add("Eins");
		ref.add("Drei");
		assertTrue(equal(ref, list));
		testConsistent(list);
		setUp();
		assertEquals("Drei", list.del(2));
		testConsistent(list);
		ref = new LinkedList();
		ref.add("Eins");
		ref.add("Zwei");
		assertTrue(equal(ref, list));
		testConsistent(list);
		setUp();
		tmp.add("Eins");
		tmp.add("Zwei");
		tmp.add("Drei");
		tmp.add("Vier");
		tmp.add(null);
		assertNull(tmp.del(4));
		assertEquals("Vier", tmp.del(3));
		testConsistent(tmp);
		setUp();
		assertTrue(equal(tmp, list));
		testConsistent(list);
	}
	
	/**
	 * Test of toString method, of class LinkedList.
	 */
	@Test
	public void testToString() {
		System.out.println("toString");
		assertEquals("[Eins, Zwei, Drei]", list.toString());
		list = new LinkedList();
		assertEquals("[]", list.toString());
	}
	
	/**
	 * Test of add method, of class LinkedList.
	 */
	@Test
	public void testAdd() {
		System.out.println("add");
		String toAdd = "new";
		list.add(toAdd, 0);
		assertEquals(toAdd, list.get(0));
		assertEquals("Eins", list.get(1));
		testConsistent(list);
		setUp();
		list.add(toAdd, 1);
		assertEquals("Eins", list.get(0));
		assertEquals(toAdd, list.get(1));
		assertEquals("Zwei", list.get(2));
		testConsistent(list);
		setUp();
		list.add(toAdd, 2);
		assertEquals("Eins", list.get(0));
		assertEquals("Zwei", list.get(1));
		assertEquals(toAdd, list.get(2));
		assertEquals("Drei", list.get(3));
		testConsistent(list);
	}
	
	/**
	 * Test of get method, of class LinkedList.
	 */
	@Test
	public void testGet() {
		System.out.println("get");
		assertEquals("Eins", list.get(0));
		assertEquals("Zwei", list.get(1));
		assertEquals("Drei", list.get(2));
	}
	
	@Test
	public void testDelAll() {
		LinkedList exp = new LinkedList();
		exp.add("Zwei");
		exp.add("Drei");
		
		list.delAll("Eins");
		assertTrue(equal(exp, list));
		
		list.add("Eins");
		list.delAll("Eins");
		System.out.println(list);
		assertTrue(equal(exp, list));
		
		list = new LinkedList();
		exp = new LinkedList();
		list.delAll(-1);
		assertTrue(equal(exp, list));
		
		list = new LinkedList();
		exp = new LinkedList();
		list.add(42);
		exp.add(42);
		list.delAll(-1);
		assertTrue(equal(exp, list));
		
		list = new LinkedList();
		exp = new LinkedList();
		list.add(42);
		list.delAll(42);
		assertTrue(equal(exp, list));
		
		list = new LinkedList();
		list.add(42);
		list.add(42);
		list.add(42);
		list.delAll(-1);
		exp = new LinkedList();
		exp.add(42);
		exp.add(42);
		exp.add(42);
		assertTrue(equal(exp, list));
		
		list = new LinkedList();
		list.add(42);
		list.delAll(42);
		exp = new LinkedList();
		assertTrue(equal(exp, list));
		
		list = new LinkedList();
		list.add(42);
		list.add(42);
		list.delAll(42);
		exp = new LinkedList();
		assertTrue(equal(exp, list));
		
		list = new LinkedList();
		list.add(42);
		list.add(42);
		list.add(42);
		list.delAll(42);
		exp = new LinkedList();
		assertTrue(equal(exp, list));
		
		list = new LinkedList();
		list.add(42);
		list.add(42);
		list.add(-1);
		list.add(42);
		list.add(42);
		list.add(0);
		list.add(42);
		list.add(42);
		list.delAll(42);
		exp = new LinkedList();
		exp.add(-1);
		exp.add(0);
		assertTrue(equal(exp, list));
	}
}