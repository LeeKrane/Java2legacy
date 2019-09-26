package testing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class MathToolsTest {

  private final MathTools candidate = new MathTools();
  private static final double EPS = 1e-6;

  public MathToolsTest() {
  }

  @BeforeClass
  public static void setUpClass() throws Exception {
    System.out.println("testing..."); //vor dem ERSTEN Test
  }

  @AfterClass
  public static void tearDownClass() throws Exception {
    System.out.println("finished testing"); //nach dem LETZTEN Test
  }

  @Before
  public void setUp() throws Exception {
    System.out.println("new test"); //vor JEDEM Test
  }

  @After
  public void tearDown() throws Exception {
    System.out.println("test done");  //nach JEDEM Test
  }

  @Test
  public void testDivideDouble() {
    assertEquals(0.3, candidate.divide(0.9, 3), EPS);
    assertEquals(1, candidate.divide(5.0, 5), EPS);
    assertEquals(Double.POSITIVE_INFINITY, candidate.divide(Double.POSITIVE_INFINITY, 3), EPS);
    assertEquals(Double.NEGATIVE_INFINITY, candidate.divide(Double.POSITIVE_INFINITY, -3), EPS);
    assertEquals(Double.POSITIVE_INFINITY, candidate.divide(1.0, 0), EPS);
    assertEquals(Double.NaN, candidate.divide(Double.NaN, 2), EPS);
  }

  @Test
  public void testDivideInt() {
    assertEquals(3, candidate.divide(15, 5), EPS);
    assertEquals(3, candidate.divide(3, 1), EPS);
  }

  @Test(expected = ArithmeticException.class)
  public void testDivide0() {
    candidate.divide(1, 0);
  }

  public void testOhNoes() {
    assertEquals(0.3, 0.1 * 3, EPS);
    assertEquals(0.3, 0.1 * 3, 1e-17);
  }

  @Test
  public void testMultiply() {
    assertEquals(10, candidate.multiply(2,5), EPS);
    assertEquals(169, candidate.multiply(13,13), EPS);
    assertEquals(0, candidate.multiply(0,0), EPS);
    assertEquals(Double.NaN, candidate.multiply(Double.POSITIVE_INFINITY,0), EPS);
  }

}
