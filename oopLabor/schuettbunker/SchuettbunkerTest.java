package school.chif2.oopLabor.schuettbunker;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class SchuettbunkerTest
{
	@Deployment
	public static JavaArchive createDeployment ()
	{
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(Schuettbunker.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	public static void main(String []args) {
		Schuettbunker sb = new Schuettbunker(5,10);
// 5 Silos, Maximalwert 10
		sb.fuell(4);
		sb.fuell(1);
		sb.nachRechts(2); // Kran 2 Positionen nach rechts
		sb.fuell(20); // Maximalwert 10
		sb.nachRechts(2); // Kran 2 Positionen nach rechts
		sb.fuell(1);
		sb.nachLinks(42); // ganz nach Links, keine Randueberschreitung
		int temp = sb.gibAlles();
		sb.nachRechts(1);
		sb.fuell(temp);
		System.out.println(sb);
	}
}
