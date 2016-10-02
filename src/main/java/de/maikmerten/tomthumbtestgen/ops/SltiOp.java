package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class SltiOp extends ImmOp {


	@Override
	public String generateCode() {
		return "slti " + getDest().getName() + "," + getS1().getName() + "," + getImm() + "\n";
	}

	@Override
	public int computeValue() {
		if(getS1().getValue() < getImm()) {
			return 1;
		}
		return 0;
	}
	
	
}
