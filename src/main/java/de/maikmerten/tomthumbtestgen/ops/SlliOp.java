package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class SlliOp extends ImmOp {


	@Override
	public String generateCode() {
		return "slli " + getDest().getName() + "," + getS1().getName() + "," + (getImm() & 0x1F) + "\n";
	}

	@Override
	public int computeValue() {
		int shiftamount = getImm() & 0x1F;
		return getS1().getValue() << shiftamount;
	}
	
	
}
