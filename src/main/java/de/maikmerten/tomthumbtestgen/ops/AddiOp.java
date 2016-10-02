package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class AddiOp extends ImmOp {


	@Override
	public String generateCode() {
		return "addi " + getDest().getName() + "," + getS1().getName() + "," + getImm() + "\n";
	}

	@Override
	public int computeValue() {
		return getS1().getValue() + getImm();
	}
	
	
}
