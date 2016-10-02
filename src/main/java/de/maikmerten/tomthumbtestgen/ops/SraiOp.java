package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class SraiOp extends ImmOp {


	@Override
	public String generateCode() {
		return "srai " + getDest().getName() + "," + getS1().getName() + "," + (getImm() & 0x1F) + "\n";
	}

	@Override
	public int computeValue() {
		int shiftamount = getImm() & 0x1F;
		return getS1().getValue() >> shiftamount;
	}
	
	
}
