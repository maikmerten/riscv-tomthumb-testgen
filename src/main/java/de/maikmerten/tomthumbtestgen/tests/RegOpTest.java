package de.maikmerten.tomthumbtestgen.tests;

import de.maikmerten.tomthumbtestgen.checks.RegValueCheck;
import de.maikmerten.tomthumbtestgen.ops.AddOp;
import de.maikmerten.tomthumbtestgen.ops.AndOp;
import de.maikmerten.tomthumbtestgen.ops.OrOp;
import de.maikmerten.tomthumbtestgen.ops.RegOp;
import de.maikmerten.tomthumbtestgen.ops.SllOp;
import de.maikmerten.tomthumbtestgen.ops.SltOp;
import de.maikmerten.tomthumbtestgen.ops.SltuOp;
import de.maikmerten.tomthumbtestgen.ops.SraOp;
import de.maikmerten.tomthumbtestgen.ops.SrlOp;
import de.maikmerten.tomthumbtestgen.ops.SubOp;
import de.maikmerten.tomthumbtestgen.ops.XorOp;
import java.util.Random;

/**
 *
 * @author maik
 */
public class RegOpTest extends Test {
	
	private final RegOp op;
	private final int testid;
	
	
	public RegOpTest(int testid) {
		op = selectOp();
		this.testid = testid;
	}
	
	private RegOp selectOp() {
		Random r = new Random();
		
		int ops = 10;
		int choice = r.nextInt(ops-1);
		
		switch(choice) {
			case 0: return new AddOp();
			case 1: return new SubOp();
			case 2: return new AndOp();
			case 3: return new OrOp();
			case 4: return new XorOp();
			case 5: return new SllOp();
			case 6: return new SrlOp();
			case 7: return new SraOp();
			case 8: return new SltOp();
			case 9: return new SltuOp();
			default: return new AddOp();
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
