import org.junit.Test;
import junit.framework.TestCase;

public class TestNyPizzaTwo extends TestCase{
	
	@Test public void testOne(){ NyPizzaTwo nyPizza = new NyPizzaTwo.Builder(NyPizzaTwo.Base.BAKED).build(); nyPizza.print();}
	//@Test public void testOne(){ NyPizzaTwo nyPizza = new NyPizzaTwo.Builder(BAKED).build();}
	@Test public void testTwo(){ //NyPizzaTwo nyPizza = new NyPizzaTwo.Builder(NyPizzaTwo.Base.BAKED).addTopping(NyPizzaTwo.Topping.MUSHRUM).build();
		 // error: incompatible types: PizzaTwo cannot be converted to NyPizzaTwo
		PizzaTwo Pizza = new NyPizzaTwo.Builder(NyPizzaTwo.Base.BAKED).addTopping(NyPizzaTwo.Topping.MUSHRUM).build();
		Pizza.print();}
	@Test public void testThree(){ //NyPizzaTwo nyPizza = new NyPizzaTwo.Builder(NyPizzaTwo.Base.GRILLED).addTopping(NyPizzaTwo.Topping.ONION).build(); 
	//  error: incompatible types: PizzaTwo cannot be converted to NyPizzaTwo
	PizzaTwo Pizza = new NyPizzaTwo.Builder(NyPizzaTwo.Base.GRILLED).addTopping(NyPizzaTwo.Topping.ONION).build();
	Pizza.print();}
	@Test public void testFour(){ //NyPizzaTwo nyPizza = new NyPizzaTwo.Builder(NyPizzaTwo.Base.STUFFED).addTopping(NyPizzaTwo.Topping.ONION).addTopping(NyPizzaTwo.Topping.MUSHRUM).addTopping(NyPizzaTwo.Topping.PEPPER).build(); 
	//  error: incompatible types: PizzaTwo cannot be converted to NyPizzaTwo
	PizzaTwo Pizza = new NyPizzaTwo.Builder(NyPizzaTwo.Base.STUFFED).addTopping(NyPizzaTwo.Topping.ONION).addTopping(NyPizzaTwo.Topping.MUSHRUM).addTopping(NyPizzaTwo.Topping.PEPPER).build();
	Pizza.print();}
}