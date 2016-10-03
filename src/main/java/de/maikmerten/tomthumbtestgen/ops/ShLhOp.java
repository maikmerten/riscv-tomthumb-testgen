package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class ShLhOp extends MemOp {


	@Override
	public String generateCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("sh ").append(getS1().getName()).append(",-2(sp)\n");
		sb.append("lh ").append(getDest().getName()).append(",-2(sp)\n");
		return sb.toString();
	}

	@Override
	public int computeValue() {
		int value = getS1().getValue();
		value <<= 16; // shift out 16 msb
		value >>= 16; // sign extend
		return value;
	}
	
	
}
