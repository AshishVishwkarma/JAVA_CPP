import java.util.Objects;
public class NyPizzaTwo extends PizzaTwo{
	public enum Base{BAKED, GRILLED, STUFFED}
	private final Base base;
	
	public static class Builder extends PizzaTwo.Builder{
		private final Base base;
		
		public Builder(Base base){this.base = Objects.requireNonNull(base);}
		
		@Override public NyPizzaTwo build(){return new NyPizzaTwo(this);}
	}

	@Override public void print(){
		System.out.println("Base:");
		switch(base){
			case BAKED:	System.out.println("BAKED"); break;
			case GRILLED: System.out.println("GRILLED"); break;
			case STUFFED: System.out.println("STUFFED"); break;
		}
		super.print();
	}
	
	private NyPizzaTwo(Builder builder){
		super(builder);
		base = builder.base;
	}
}