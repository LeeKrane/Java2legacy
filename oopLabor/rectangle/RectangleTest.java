package school.chif2.oopLabor.rectangle;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class RectangleTest
{
	double delta = 0.000001;
	
	@Deployment
	public static JavaArchive createDeployment ()
	{
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(Rectangle.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Test
	public void testSetLengthAndSetWidth1 ()
	{
		Rectangle rec = new Rectangle();
		rec.setLength(25);
		rec.setWidth(25);
		
		double expectedResult = 20.0;
		double actualResult = rec.getLength();
		assertEquals(expectedResult, actualResult, delta);
		actualResult = rec.getWidth();
		assertEquals(expectedResult, actualResult, delta);
	}
	
	@Test
	public void testSetLengthAndSetWidth2 ()
	{
		Rectangle rec = new Rectangle();
		rec.setLength(17);
		rec.setWidth(17);
		
		double expectedResult = 17.0;
		double actualResult = rec.getLength();
		assertEquals(expectedResult, actualResult, delta);
		actualResult = rec.getWidth();
		assertEquals(expectedResult, actualResult, delta);
	}
	
	@Test
	public void testSetLengthAndSetWidth3 ()
	{
		Rectangle rec = new Rectangle();
		rec.setLength(-5);
		rec.setWidth(-5);
		
		double expectedResult = 1.0;
		double actualResult = rec.getLength();
		assertEquals(expectedResult, actualResult, delta);
		actualResult = rec.getWidth();
		assertEquals(expectedResult, actualResult, delta);
	}
	
	@Test
	public void testUmfang ()
	{
		Rectangle rec = new Rectangle();
		rec.setLength(6);
		rec.setWidth(5);
		
		double expectedResult = 22.0;
		double actualResult = rec.umfang();
		assertEquals(expectedResult, actualResult, delta);
	}
	
	@Test
	public void testSurface ()
	{
		Rectangle rec = new Rectangle();
		rec.setLength(6);
		rec.setWidth(5);
		
		double expectedResult = 30.0;
		double actualResult = rec.surface();
		assertEquals(expectedResult, actualResult, delta);
	}
}
