import java.util.Objects;
public class NyPizza extends Pizza{
	public enum Base{BAKED, GRILLED, STUFFED}
	private final Base base;
	
	public static class Builder extends Pizza.Builder<Builder>{
		private final Base base;
		
		public Builder(Base base){this.base = Objects.requireNonNull(base);}
		
		@Override public NyPizza build(){return new NyPizza(this);}
		@Override protected Builder self(){return this;}
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
	
	private NyPizza(Builder builder){
		super(builder);
		base = builder.base;
	}
}