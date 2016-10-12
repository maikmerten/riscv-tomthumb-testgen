package de.maikmerten.tomthumbtestgen.tests;

import de.maikmerten.tomthumbtestgen.checks.RegValueCheck;
import de.maikmerten.tomthumbtestgen.ops.BeqOp;
import de.maikmerten.tomthumbtestgen.ops.BgeOp;
import de.maikmerten.tomthumbtestgen.ops.BgeuOp;
import de.maikmerten.tomthumbtestgen.ops.BltOp;
import de.maikmerten.tomthumbtestgen.ops.BltuOp;
import de.maikmerten.tomthumbtestgen.ops.BneOp;
import de.maikmerten.tomthumbtestgen.ops.BranchOp;
import java.util.Random;

/**
 *
 * @author maik
 */
public class BranchOpTest extends Test {
	
	private final BranchOp op;
	private final int testid;
	
	
	public BranchOpTest(int testid) {
		op = selectOp();
		this.testid = testid;
	}
	
	private BranchOp selectOp() {
		Random r = new Random();
		
		int ops = 6;
		int choice = r.nextInt(ops);
		
		switch(choice) {
			case 0: return new BeqOp();
			case 1: return new BneOp();
			case 2: return new BltOp();
			case 3: return new BgeOp();
			case 4: return new BltuOp();
			case 5: return new BgeuOp();
			default: return new BeqOp();
		}
	}
		
	
	@Override
	public String generateCode() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(op.getS1().generateCode());
		if(!op.getS1().equals(op.getS2())) {
			sb.append(op.getS2().generateCode());
		}
		sb.append(op.generateCode());
		
		RegValueCheck check = new RegValueCheck(op.getDest(), op.computeValue(), testid);
		sb.append(check.generateCode());
		
		return sb.toString();
	}
	

	
}
