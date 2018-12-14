class DataStore
{
    public void visitData(Visitor visitor) { 
		// Invokes visitor with each item of data.
		Data d = new Data("Awesome!");
		visitor.visit(d);
	}
}