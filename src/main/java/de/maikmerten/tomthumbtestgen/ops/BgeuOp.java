package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class BgeuOp extends BranchOp {


	@Override
	public String generateCode() {
		String target = getBranchTarget();
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("li " + getDest().getName() + ",1\n");
		sb.append("bgeu " + getS1().getName() + "," + getS2().getName() + "," + target + "\n");
		sb.append("li " + getDest().getName() + ",0\n");
		sb.append(target + ":\n");

		return sb.toString();
	}

	@Override
	public int computeValue() {
		long s1 = getS1().getValue();
		long s2 = getS2().getValue();
		
		s1 &= 0xFFFFFFFFl;
		s2 &= 0xFFFFFFFFl;
		
		return s1 >= s2 ? 1 : 0;
	}
	
	
}
