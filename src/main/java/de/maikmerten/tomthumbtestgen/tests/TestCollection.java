package de.maikmerten.tomthumbtestgen.tests;

import de.maikmerten.tomthumbtestgen.GeneratesCode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author maik
 */
public class TestCollection implements GeneratesCode {
	
	private List<Test> tests = new ArrayList<>();
	
	public TestCollection(int testnum) {
		for(int i = 0; i < testnum; ++i) {
			tests.add(new RegOpTest(i));
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
		String result = "\nglobalpass:\n";
		result += "li x5,-1\n"; // no test failed
		result += "globalfail:\n";
		result += "ret\n";
		return result;
	}
	
	
}
