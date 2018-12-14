import org.junit.Test;
import junit.framework.TestCase;

public class TestNyPizza extends TestCase{
	
	@Test public void testOne(){ NyPizza nyPizza = new NyPizza.Builder(NyPizza.Base.BAKED).build(); nyPizza.print();}
	//@Test public void testOne(){ NyPizza nyPizza = new NyPizza.Builder(BAKED).build();}
	@Test public void testTwo(){ NyPizza nyPizza = new NyPizza.Builder(NyPizza.Base.BAKED).addTopping(NyPizza.Topping.MUSHRUM).build(); nyPizza.print();}
	@Test public void testThree(){ NyPizza nyPizza = new NyPizza.Builder(NyPizza.Base.GRILLED).addTopping(NyPizza.Topping.ONION).build(); nyPizza.print();}
	@Test public void testFour(){ NyPizza nyPizza = new NyPizza.Builder(NyPizza.Base.STUFFED).addTopping(NyPizza.Topping.ONION).addTopping(NyPizza.Topping.MUSHRUM).addTopping(NyPizza.Topping.PEPPER).build(); nyPizza.print();}
}