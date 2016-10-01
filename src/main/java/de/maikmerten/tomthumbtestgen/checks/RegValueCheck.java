package de.maikmerten.tomthumbtestgen.checks;

import de.maikmerten.tomthumbtestgen.GeneratesCode;
import de.maikmerten.tomthumbtestgen.Register;

/**
 *
 * @author maik
 */
public class RegValueCheck implements GeneratesCode {
	
	Register regToBeChecked;
	int expectedValue;
	int checkid;
	
	public RegValueCheck(Register regToBeChecked, int expectedValue, int checkid) {
		this.regToBeChecked = regToBeChecked;
		this.expectedValue = expectedValue;
		this.checkid = checkid;
	}
	

	@Override
	public String generateCode() {
		Register compareReg = new Register(5, expectedValue);
		
		String result = compareReg.generateCode();
		
		result += "beq x5," + regToBeChecked.getName() + ",pass" + checkid + "\n";
		result += "li x5," + checkid + "\n";
		result += "j globalfail\n";
		result += "pass" + checkid + ":\n";
		
		return result;
	}
	
}
