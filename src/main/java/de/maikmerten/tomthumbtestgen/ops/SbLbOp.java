package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class SbLbOp extends MemOp {


	@Override
	public String generateCode() {
		StringBuilder sb = new StringBuilder();
		sb.append("sb ").append(getS1().getName()).append(",-1(sp)\n");
		sb.append("lb ").append(getDest().getName()).append(",-1(sp)\n");
		return sb.toString();
	}

	@Override
	public int computeValue() {
		int value = getS1().getValue();
		value <<= 24; // shift out 24 msb
		value >>= 24; // sign extend
		return value;
	}
	
	
}
