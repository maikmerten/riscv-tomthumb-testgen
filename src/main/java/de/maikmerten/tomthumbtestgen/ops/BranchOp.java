package de.maikmerten.tomthumbtestgen.ops;

import de.maikmerten.tomthumbtestgen.ComputesValue;
import de.maikmerten.tomthumbtestgen.GeneratesCode;
import de.maikmerten.tomthumbtestgen.Register;

/**
 *
 * @author maik
 */
public abstract class BranchOp implements GeneratesCode, ComputesValue {
	
	private Register s1, s2, dest;
	private static long id = 0;
	
	public BranchOp() {
		this.s1 = new Register();
		this.s2 = new Register();
		this.dest = new Register();

		// if both sources denote the same register, then make sure
		// "both" registers contain the same value
		if(s2.equals(s1)) {
			this.s2 = s1;
		}
		
		// ensure that we don't target one of the source registers
		while(this.dest.equals(this.s1) || this.dest.equals(this.s2)) {
			this.dest = new Register();
		}
		
	}
	
	public String getBranchTarget() {
		if(BranchOp.id > Integer.MAX_VALUE) {
			BranchOp.id = 0;
		}
	
		return "branchtarget" + BranchOp.id++;
	}
	
	public Register getS1() {
		return s1;
	}
	

	public Register getS2() {
		return s2;
	}
	
	public Register getDest() {
		return dest;
	}
	

}
