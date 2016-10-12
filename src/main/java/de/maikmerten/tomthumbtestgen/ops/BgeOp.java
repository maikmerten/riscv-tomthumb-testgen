package de.maikmerten.tomthumbtestgen.ops;

/**
 *
 * @author maik
 */
public class BgeOp extends BranchOp {


	@Override
	public String generateCode() {
		String target = getBranchTarget();
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("li " + getDest().getName() + ",1\n");
		sb.append("bge " + getS1().getName() + "," + getS2().getName() + "," + target + "\n");
		sb.append("li " + getDest().getName() + ",0\n");
		sb.append(target + ":\n");

		return sb.toString();
	}

	@Override
	public int computeValue() {
		return getS1().getValue() >= getS2().getValue() ? 1 : 0;
	}
	
	
}
