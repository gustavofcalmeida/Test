package scjptricks;

public class Son extends Father {
	public Son() {
		
	}
	
	public static void main(String[] args) {
		// even without explicit call to any superclass
		// constructor, the default constructor is called
		System.out.println( new Son().isConstructed() );
				
		int x = 0;
		// conditional AND (&&) and bitwise AND (&)
		// are different, specially when side effects (++x==1)
		// are involved, because of shortcuts
		System.out.println( (10==5) && ++x == 1 );
		System.out.println( x );
	}
	
	@Override
	// visibility change is permitted since less
	// restrictive
	public int method() {
		return 1;
	}
}
