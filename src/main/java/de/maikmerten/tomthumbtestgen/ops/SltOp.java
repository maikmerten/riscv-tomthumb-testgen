package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class SltOp extends RegOp {


	@Override
	public String generateCode() {
		return "slt " + getDest().getName() + "," + getS1().getName() + "," + getS2().getName() + "\n";
	}

	@Override
	public int computeValue() {
		if(getS1().getValue() < getS2().getValue()) {
			return 1;
		}
		return 0;
	}
	
	
}
