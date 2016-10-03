package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class SwLwOp extends MemOp {


	@Override
	public String generateCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("sw ").append(getS1().getName()).append(",-4(sp)\n");
		sb.append("lw ").append(getDest().getName()).append(",-4(sp)\n");
		return sb.toString();
	}

	@Override
	public int computeValue() {
		return getS1().getValue();
	}
	
	
}
