package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class SbLbuOp extends MemOp {


	@Override
	public String generateCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("sb ").append(getS1().getName()).append(",-1(sp)\n");
		sb.append("lbu ").append(getDest().getName()).append(",-1(sp)\n");
		return sb.toString();
	}

	@Override
	public int computeValue() {
		int value = getS1().getValue() & 0xFF;
		return value;
	}
	
	
}
