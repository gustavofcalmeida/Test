package encoding;

public class LeStringHexadecimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] bytes =     {0x6E, 0xC3, 0xA3, 0x6F, 0x20, 0x73, 0x65, 0x69, 0x20, 0x6C, 0x69, 0x67, 0x61, 0x72};
		String[] sBytes = {"6E", "C3", "A3", "6F", "20", "73", "65", "69", "20", "6C", "69", "67", "61", "72"};

		for ( String s : sBytes ) {
			System.out.print( Integer.parseInt( s, 16) + " ");
		}
		System.out.println();
		for ( int s : bytes ) {
			System.out.print( s + " ");
		}
	}

}
