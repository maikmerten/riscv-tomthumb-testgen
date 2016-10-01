package de.maikmerten.tomthumbtestgen;

import de.maikmerten.tomthumbtestgen.tests.TestCollection;

/**
 *
 * @author maik
 */
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		TestCollection tc = new TestCollection(16);
		String test = tc.generateCode();
	
		System.out.println(test);
		
	}
	
	
}
