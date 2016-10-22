package de.maikmerten.tomthumbtestgen;

import de.maikmerten.tomthumbtestgen.tests.TestCollection;

/**
 *
 * @author maik
 */
public class Main {
	
	public static void main(String[] args) throws Exception {
		
		int numtest = 16;
		if(args.length > 0) {
			numtest = Integer.parseInt(args[0]);
			
			numtest = numtest < 1 ? 1 : numtest;
			numtest = numtest > 65536 ? 65536 : numtest;
		}
		
		TestCollection tc = new TestCollection(numtest);
		String test = tc.generateCode();
	
		System.out.println(test);
		
	}
	
	
}
