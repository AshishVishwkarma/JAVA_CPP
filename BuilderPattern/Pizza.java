import java.util.Set;
import java.util.EnumSet;
import java.util.Objects;
public abstract class Pizza{
	public enum Topping{HUM, MUSHRUM, ONION, PEPPER, SAUSAGE}
	final Set<Topping> toppings;
	
	abstract static class Builder<T extends Builder<T>>{
	//abstract static class Builder<T>{
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
		
		public T addTopping(Topping topping){
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}
				
		public abstract Pizza build();
		
		protected abstract T self();
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
	
	protected Pizza(Builder<?> builder){
		toppings = builder.toppings.clone();
	}
}