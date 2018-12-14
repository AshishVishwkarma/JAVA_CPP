import org.junit.Test;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
//import org.junit.*;
//import junit.framework.TestCase;
import java.util.Map;


//public class TestTokenizer extends TestCase{
public class TestTokenizer{
   
	//public static void main(String[] args) {}
	
   @Test
   public void testOne() {
      System.out.println(">> testOne:");
	  Tokenizer tokenizer = new Tokenizer();
	  Map<Integer, String> tokens = tokenizer.tokenize("One|Two|Three", "\\|");
      assertFalse(tokens.isEmpty());
	  assertEquals("One", tokens.get(1));
	  assertEquals("Two", tokens.get(2));
	  assertEquals("Three", tokens.get(3));
	  System.out.println("<< testOne");
   }
   
   @Test
   public void testTwo() {
      System.out.println(">> testTwo:");
	  Tokenizer tokenizer = new Tokenizer();
	  Map<Integer, String> tokens = tokenizer.tokenize("One,Two,Three", ",");
      assertFalse(tokens.isEmpty());
	  assertEquals("One", tokens.get(1));
	  assertEquals("Two", tokens.get(2));
	  assertEquals("Three", tokens.get(3));
	  System.out.println("<< testTwo");
   }
   
   @Test
   public void testThree() {
      System.out.println(">> testThree:");
	  Tokenizer tokenizer = new Tokenizer();
	  Map<Integer, String> tokens = tokenizer.tokenize("One,Two,Three\n", ",");
      assertFalse(tokens.isEmpty());
	  assertEquals("One", tokens.get(1));
	  assertEquals("Two", tokens.get(2));
	  assertEquals("Three", tokens.get(3));
	  System.out.println("<< testThree");
   }
   
   @Test
   public void testFour() {
      System.out.println(">> testFour:");
	  Tokenizer tokenizer = new Tokenizer();
	  Map<Integer, String> tokens = tokenizer.tokenize("One,Two Three, Four\n", ",");
      assertFalse(tokens.isEmpty());
	  assertEquals("One", tokens.get(1));
	  assertEquals("Two Three", tokens.get(2));
	  assertEquals("Four", tokens.get(3));
	  System.out.println("<< testFour");
   }
   
   @Test
   public void testFive() {
      System.out.println(">> testFive:");
	  Tokenizer tokenizer = new Tokenizer();
	  Map<Integer, String> tokens = tokenizer.tokenize("One@Sym,Two$Sym, Three%Sym\n", ",");
      assertFalse(tokens.isEmpty());
	  assertEquals("One@Sym", tokens.get(1));
	  assertEquals("Two$Sym", tokens.get(2));
	  assertEquals("Three%Sym", tokens.get(3));
	  System.out.println("<< testFive");
   }
   
   @Test
   public void testSix() {
      System.out.println(">> testSix:");
	  Tokenizer tokenizer = new Tokenizer();
	  Map<Integer, String> tokens = tokenizer.tokenize("One | Two| Three ", "\\|");
      assertFalse(tokens.isEmpty());
	  assertEquals("One", tokens.get(1));
	  assertEquals("Two", tokens.get(2));
	  assertEquals("Three", tokens.get(3));
	  System.out.println("<< testSix");
   }
   
   @Test
   public void testSeven() {
      System.out.println(">> testSeven:");
	  Tokenizer tokenizer = new Tokenizer();
	  Map<Integer, String> tokens = tokenizer.tokenize("One	|	Two|	Three	", "\\|"); // Tab
      assertFalse(tokens.isEmpty());
	  assertEquals("One", tokens.get(1));
	  assertEquals("Two", tokens.get(2));
	  assertEquals("Three", tokens.get(3));
	  System.out.println("<< testSeven");
   }
   
   @Test
   public void testEight() {
      System.out.println(">> testEight:");
	  Tokenizer tokenizer = new Tokenizer();
	  Map<Integer, String> tokens = tokenizer.tokenize("One 	| 	Two| 	Three 	", "\\|"); // <Space>Tab
      assertFalse(tokens.isEmpty());
	  assertEquals("One", tokens.get(1));
	  assertEquals("Two", tokens.get(2));
	  assertEquals("Three", tokens.get(3));
	  System.out.println("<< testEight");
   }
   
   @Test
   public void testNine() {
      System.out.println(">> testNine:");
	  Tokenizer tokenizer = new Tokenizer();
	  Map<Integer, String> tokens = tokenizer.tokenize("One	 |	 Two|	 Three	 ", "\\|"); // Tab<Space>
      assertFalse(tokens.isEmpty());
	  assertEquals("One", tokens.get(1));
	  assertEquals("Two", tokens.get(2));
	  assertEquals("Three", tokens.get(3));
	  System.out.println("<< testNine");
   }
   
   @Test
   public void testTen() {
      System.out.println(">> testTen:");
	  Tokenizer tokenizer = new Tokenizer();
	  Map<Integer, String> tokens = tokenizer.tokenize("One,Two|Three, Four\n", ",");
      assertFalse(tokens.isEmpty());
	  assertEquals("One", tokens.get(1));
	  assertEquals("Two|Three", tokens.get(2));
	  assertEquals("Four", tokens.get(3));
	  System.out.println("<< testTen");
   }
   
   @Test
   public void testEleven(){
		System.out.println(">> testEleven:");
		Tokenizer tokenizer = new Tokenizer();
		Map<Integer, String> tokens = tokenizer.tokenize("One,Two,Three\nFour,Five,Six", ",");
		assertFalse(tokens.isEmpty());
		assertEquals("One", tokens.get(1));
		assertEquals("Two", tokens.get(2));
		assertEquals("Three", tokens.get(3));
		assertEquals("Four", tokens.get(4));
		assertEquals("Five", tokens.get(5));
		assertEquals("Six", tokens.get(6));
		System.out.println("<< testEleven");
   }
   
   
}