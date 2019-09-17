package school.chif2.oopLabor.potion;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class PotionTest
{
	@Deployment
	public static JavaArchive createDeployment ()
	{
		return ShrinkWrap.create(JavaArchive.class)
				.addClass(Potion.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	public static void main (String[] args) {
		// Zutaten werden erstellt
		Ingredient ingredient1 = new Ingredient("Toad");
		Ingredient ingredient2 = new Ingredient("Lizard");
		Ingredient ingredient3 = new Ingredient("Spider");
		// set name of ingredient1 to "Fly"
		ingredient1.setName("Fly");
		// Zaubertrank wird mit 2 Zutaten erstellt
		Potion potion = new Potion(ingredient1, ingredient2, ingredient3);
		// Zaubertrank wird dreimal umgerührt
		potion.stir();
		potion.stir();
		potion.stir();
		// Information ueber den Zaubertrank wird ausgegeben
		System.out.println(potion);
		// wie die Ausgabe aussehen koennte:
		//
		// Ingredients: Fly, Lizard, Spider
		// Power: 15
		// Ready: no
		// Zaubertrank wird noch zwei mal umgerührt
		potion.stir();
		potion.stir();
		// Informationen ueber Zaubertrank wird erneut ausgegeben
		System.out.println(potion);
		// wie die Ausgabe aussehen koennte:
		//
		// Ingredients: Fly, Lizard, Spider
		// Power: 30
		// Ready: yes
	}
}
