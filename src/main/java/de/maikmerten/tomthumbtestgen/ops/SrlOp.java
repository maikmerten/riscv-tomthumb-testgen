package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class SrlOp extends RegOp {


	@Override
	public String generateCode() {
		return "srl " + getDest().getName() + "," + getS1().getName() + "," + getS2().getName() + "\n";
	}

	@Override
	public int computeValue() {
		int shiftamount = getS2().getValue() & 0x1F;
		return getS1().getValue() >>> shiftamount;
	}
	
	
}
