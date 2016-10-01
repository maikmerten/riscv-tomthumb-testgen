package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class SubOp extends RegOp {


	@Override
	public String generateCode() {
		return "sub " + getDest().getName() + "," + getS1().getName() + "," + getS2().getName() + "\n";
	}

	@Override
	public int computeValue() {
		return getS1().getValue() - getS2().getValue();
	}
	
	
}
