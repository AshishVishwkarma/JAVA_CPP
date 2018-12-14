import java.util.Set;
import java.util.EnumSet;
import java.util.Objects;
public abstract class PizzaTwo{
	public enum Topping{HUM, MUSHRUM, ONION, PEPPER, SAUSAGE}
	final Set<Topping> toppings;
	
	abstract static class Builder{
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		
		public Builder addTopping(Topping topping){
			toppings.add(Objects.requireNonNull(topping));
			return this;
		}
				
		public abstract PizzaTwo build();
	}
	
	public void print(){
		System.out.println("Toppings:");
		for(Object e : toppings){
			switch((Topping)e){
				case HUM: System.out.println("HUM"); break;
				case MUSHRUM: System.out.println("MUSHRUM"); break;
				case ONION: System.out.println("ONION"); break;
				case PEPPER: System.out.println("PEPPER"); break;
				case SAUSAGE: System.out.println("SAUSAGE"); break;
			}
		}
	}
	
	protected PizzaTwo(Builder builder){
		toppings = builder.toppings.clone();
	}
}