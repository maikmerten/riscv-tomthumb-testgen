package de.maikmerten.tomthumbtestgen;

import de.maikmerten.tomthumbtestgen.tests.TestCollection;
import java.io.File;
import java.io.FileOutputStream;

/**
 *
 * @author maik
 */
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		TestCollection tc = new TestCollection(16);
		String test = tc.generateCode();
		
		FileOutputStream fos = new FileOutputStream(new File("/tmp/tests/test.s"));
		fos.write(test.getBytes());
		fos.close();
		
		System.out.println(test);
		
	}
	
	
}
