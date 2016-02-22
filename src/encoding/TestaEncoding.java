package encoding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class TestaEncoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] bytes = {0x6E, 0xC3, 0xA3, 0x6F, 0x20, 0x73, 0x65, 0x69, 0x20, 0x6C, 0x69, 0x67, 0x61, 0x72};

		System.out.println("Bytes:");
		for (int b : bytes ) {
			System.out.print( b + " " );
		}
		
		System.out.println("\n\nCada byte em UTF-16:");
		for (int b : bytes ) {
			char c = (char)b;
			System.out.print( c );
		}
		
		System.out.println("\n\nTodos os bytes em UTF-8:");
		byte[] realBytes = new byte[ bytes.length ];		
		for ( int i = 0; i < realBytes.length; i++ ) {
			realBytes[i] = (byte)bytes[i];
		}
		String s = new String( realBytes, Charset.forName("UTF-8"));
		System.out.println( s );
		
		System.out.println("\nArquivo lido em UTF-8:");
		try {
			InputStreamReader isr = new InputStreamReader( new FileInputStream(new File("./data.dat")), Charset.forName("UTF-8") );
			BufferedReader br = new BufferedReader( isr );
			System.out.println( br.readLine() );
			br.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
