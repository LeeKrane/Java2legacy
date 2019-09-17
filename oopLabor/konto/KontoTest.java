package school.chif2.oopLabor.konto;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class KontoTest
{
	@Deployment
	public static JavaArchive createDeployment ()
	{
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(Konto.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	public static void main(String []args)
	{
		Konto k1 = new Konto("Giro 1", 50.0, true);
		System.out.println(k1);
		k1.einzahlen(100);
		k1.abheben(200);
		System.out.println(k1);
		Konto k2 = new Konto("Spar 1", 50.0, false);
		System.out.println(k2);
		k2.einzahlen(100);
		k2.abheben(200);
		System.out.println(k2);
		Konto.umbuchen(k1, k2, 33);
		System.out.println(k1);
		System.out.println(k2);
	}
}
