package de.maikmerten.tomthumbtestgen.tests;

import de.maikmerten.tomthumbtestgen.checks.RegValueCheck;
import de.maikmerten.tomthumbtestgen.ops.MemOp;
import de.maikmerten.tomthumbtestgen.ops.SbLbOp;
import de.maikmerten.tomthumbtestgen.ops.SbLbuOp;
import de.maikmerten.tomthumbtestgen.ops.ShLhOp;
import de.maikmerten.tomthumbtestgen.ops.ShLhuOp;
import de.maikmerten.tomthumbtestgen.ops.SwLwOp;
import java.util.Random;

/**
 *
 * @author maik
 */
public class MemOpTest extends Test {
	
	private final MemOp op;
	private final int testid;
	
	
	public MemOpTest(int testid) {
		op = selectOp();
		this.testid = testid;
	}
	
	private MemOp selectOp() {
		Random r = new Random();
		
		int ops = 5;
		int choice = r.nextInt(ops);
		
		switch(choice) {
			case 0: return new SbLbOp();
			case 1: return new SbLbuOp();
			case 2: return new ShLhOp();
			case 3: return new ShLhuOp();
			case 4: return new SwLwOp();
			default: return new SbLbOp();
		}
	}
		
	
	@Override
	public String generateCode() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(op.getS1().generateCode());
		sb.append(op.generateCode());
		
		RegValueCheck check = new RegValueCheck(op.getDest(), op.computeValue(), testid);
		sb.append(check.generateCode());
		
		return sb.toString();
	}
	

	
}
