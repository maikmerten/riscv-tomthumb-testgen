package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class SltiuOp extends ImmOp {


	@Override
	public String generateCode() {
		return "sltiu " + getDest().getName() + "," + getS1().getName() + "," + getImm() + "\n";
	}

	@Override
	public int computeValue() {
		long s1 = getS1().getValue();
		s1 &= 0xFFFFFFFFl;
		
		long s2 = getImm();
		s2 &= 0xFFFFFFFFl;
		
		if(s1 < s2) {
			return 1;
		}
		return 0;
	}
	
	
}
