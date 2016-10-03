package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class ShLhuOp extends MemOp {


	@Override
	public String generateCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("sh ").append(getS1().getName()).append(",-2(sp)\n");
		sb.append("lhu ").append(getDest().getName()).append(",-2(sp)\n");
		return sb.toString();
	}

	@Override
	public int computeValue() {
		int value = getS1().getValue() & 0xFFFF;
		return value;
	}
	
	
}
