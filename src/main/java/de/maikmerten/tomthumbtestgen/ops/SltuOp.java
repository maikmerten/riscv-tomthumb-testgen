package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class SltuOp extends RegOp {


	@Override
	public String generateCode() {
		return "sltu " + getDest().getName() + "," + getS1().getName() + "," + getS2().getName() + "\n";
	}

	@Override
	public int computeValue() {
		long s1 = getS1().getValue();
		s1 &= 0xFFFFFFFFl;
		
		long s2 = getS2().getValue();
		s2 &= 0xFFFFFFFFl;
		
		if(s1 < s2) {
			return 1;
		}
		return 0;
	}
	
	
}
