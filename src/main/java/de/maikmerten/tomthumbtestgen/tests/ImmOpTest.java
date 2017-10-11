package de.maikmerten.tomthumbtestgen.tests;

import de.maikmerten.tomthumbtestgen.checks.RegValueCheck;
import de.maikmerten.tomthumbtestgen.ops.AddiOp;
import de.maikmerten.tomthumbtestgen.ops.AndiOp;
import de.maikmerten.tomthumbtestgen.ops.ImmOp;
import de.maikmerten.tomthumbtestgen.ops.OriOp;
import de.maikmerten.tomthumbtestgen.ops.SlliOp;
import de.maikmerten.tomthumbtestgen.ops.SltiOp;
import de.maikmerten.tomthumbtestgen.ops.SltiuOp;
import de.maikmerten.tomthumbtestgen.ops.SraiOp;
import de.maikmerten.tomthumbtestgen.ops.SrliOp;
import de.maikmerten.tomthumbtestgen.ops.XoriOp;
import java.util.Random;

/**
 *
 * @author maik
 */
public class ImmOpTest extends Test {
	
	private final ImmOp op;
	private final int testid;
	
	
	public ImmOpTest(int testid) {
		op = selectOp();
		this.testid = testid;
	}
	
	private ImmOp selectOp() {
		Random r = new Random();
		
		int ops = 9;
		int choice = r.nextInt(ops);
		
		switch(choice) {
			case 0: return new AddiOp();
			case 1: return new SltiOp();
			case 2: return new SltiuOp();
			case 3: return new XoriOp();
			case 4: return new OriOp();
			case 5: return new AndiOp();
			case 6: return new SlliOp();
			case 7: return new SrliOp();
			case 8: return new SraiOp();
			default: return new AddiOp();
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
