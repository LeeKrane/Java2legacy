/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package labor_05;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author reio
 */
public class BarPlotTest {
    
    public BarPlotTest() {
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

    /**
     * Test of repeat method, of class BarPlot.
     */
    @Test
    public void testRepeat_1() {
        System.out.println("repeat_1");
        String result = BarPlot.repeat('*', 4);
        assertEquals("****", result);
    }
    
    @Test
    public void testRepeat_2() {
        System.out.println("repeat_2");
        String result = BarPlot.repeat(' ', 5);
        assertEquals("     ", result);
    }
    
    @Test
    public void testRepeat_3() {
        System.out.println("repeat_3");
        String result = BarPlot.repeat('a', 0);
        assertEquals("", result);
    }

    /**
     * Test of drawLabel method, of class BarPlot.
     */
    @Test
    public void testDrawLabel_1() {
        System.out.println("drawLabel_1");
        String result = BarPlot.drawLabel("abc", 6);
        assertEquals("abc   ", result);
    }
    
    @Test
    public void testDrawLabel_2() {
        System.out.println("drawLabel_2");
        String result = BarPlot.drawLabel("abcdefghijk", 6);
        assertEquals("abcdef", result);
    }

    /**
     * Test of drawBar method, of class BarPlot.
     */
    @Test
    public void testDrawBar_String_int_1() {
        System.out.println("drawBar_1");
        String result = BarPlot.drawBar("WS2009", 15);
        assertEquals("WS2009  |###############               |", result);
    }
    
    @Test
    public void testDrawBar_String_int_2() {
        System.out.println("drawBar_2");
        String result = BarPlot.drawBar("DiesIstEinTest", 3);
        assertEquals("DiesIstE|###                           |", result);
    }
    
    @Test
    public void testDrawBar_String_int_3() {
        System.out.println("drawBar_3");
        String result = BarPlot.drawBar("Informatik", 33);
        assertNull(result);
    }

    /**
     * Test of drawBar method, of class BarPlot.
     */
    @Test
    public void testDrawBar_String_double_1() {
        System.out.println("drawBar_4");
        
        String result = BarPlot.drawBar("ColdMonths", 0.8);
        assertEquals("ColdMont|########################      |", result);
    }
    
    @Test
    public void testDrawBar_String_double_2() {
        System.out.println("drawBar_5");
        
        String result = BarPlot.drawBar("WarmMonths", 0.15);
        assertEquals("WarmMont|#####                         |", result);
    }
    
    @Test
    public void testDrawBar_String_double_3() {
        System.out.println("drawBar_6");
        
        String result = BarPlot.drawBar("WarmMonths", 1.15);
        assertNull(result);
    }
}
