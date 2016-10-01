package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class XorOp extends RegOp {


	@Override
	public String generateCode() {
		return "xor " + getDest().getName() + "," + getS1().getName() + "," + getS2().getName() + "\n";
	}

	@Override
	public int computeValue() {
		return getS1().getValue() ^ getS2().getValue();
	}
	
	
}
