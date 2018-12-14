import org.junit.Test;
import junit.framework.TestCase;

public class TestBuilderPattern extends TestCase{
	@Test public void testOne(){ NutritionFacts nfObj = new NutritionFacts.Builder(240, 8).build();}
	@Test public void testTwo(){ NutritionFacts nfObj = new NutritionFacts.Builder(240, 8).calories(300).build();}
	@Test public void testThree(){ NutritionFacts nfObj = new NutritionFacts.Builder(240, 8).sodium(50).build();}
	@Test public void testFour(){ NutritionFacts nfObj = new NutritionFacts.Builder(240, 8).calories(300).sodium(50).fat(10).carbs(500).build();}
}