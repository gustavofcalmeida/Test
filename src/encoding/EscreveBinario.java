package encoding;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscreveBinario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] bytes = {0x6E, 0xC3, 0xA3, 0x6F, 0x20, 0x73, 0x65, 0x69, 0x20, 0x6C, 0x69, 0x67, 0x61, 0x72};

		try {
			FileOutputStream fos = new FileOutputStream( new File("./data.dat") );
		
			for ( int b : bytes ) {
				fos.write(b);
			}
			fos.close();
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
