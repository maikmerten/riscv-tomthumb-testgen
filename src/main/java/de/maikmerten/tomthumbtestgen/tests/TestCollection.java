package de.maikmerten.tomthumbtestgen.tests;

import de.maikmerten.tomthumbtestgen.GeneratesCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author maik
 */
public class TestCollection implements GeneratesCode {
	
	private List<Test> tests = new ArrayList<>();
	
	public TestCollection(int testnum) {
		Random r = new Random();
		
		
		for(int i = 0; i < testnum; ++i) {
			float f = r.nextFloat();
			
			if(f < 0.35) {
				tests.add(new RegOpTest(i));
			} else if(f < 0.7) {
				tests.add(new ImmOpTest(i));
			} else if(f < 0.85) {
				tests.add(new MemOpTest(i));
			} else {
				tests.add(new BranchOpTest(i));
			}
		}
	}
	
	

	@Override
	public String generateCode() {
		StringBuilder sb = new StringBuilder();
		sb.append(codeHeader());
		
		for(int i = 0; i < tests.size(); ++i) {
			Test t = tests.get(i);
			
			sb.append("# Test ").append(i).append("\n");
			sb.append(t.generateCode());
			sb.append("\n");
		}
		
		
		
		sb.append(codeFooter());
		
		return sb.toString();
	}
	
	private String codeHeader() {
		return ".text\ntestcase:\n\n";
	}
	
	
	private String codeFooter() {
		// -1 in x5 denotes that all tests passed
		return "li x5,-1\nret\n";
	}
	
	
}
