package scjptricks;

public class Son1 extends Father1 {

	public Son1(boolean b) {
		// Superclass do not have default constructor, so
		// explicit call to one of superclass' constructor
		// must exist
		super(b);
	}

}
