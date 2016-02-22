package encoding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DescobreEncoding {
	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader( new FileInputStream(new File("./disciplinas.txt")), Charset.forName("US-ASCII") );
		BufferedReader br = new BufferedReader( isr );
		
		List<Integer> list = new LinkedList<Integer>();
		String line = null;
		while ( (line = br.readLine()) != null ) {
			list.add( Integer.parseInt( line, 16) );
			System.out.print( line + " ");
		}
		br.close();
		
		byte[] array = new byte[ list.size() ];
		Iterator<Integer> it = list.iterator();
		
		int i = 0;
		while (it.hasNext()) {
			array[i++] = it.next().byteValue();
		}
		
		String s = new String( array, Charset.forName("UTF-8"));
		System.out.println( "\n\n" + s );
		
		FileOutputStream fos = new FileOutputStream( new File("./disciplinas.dat") );
		for ( byte b : array ) {
			fos.write(b);
		}
		fos.close();
	}
}
