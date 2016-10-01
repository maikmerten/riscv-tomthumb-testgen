package de.maikmerten.tomthumbtestgen.ops;

import de.maikmerten.tomthumbtestgen.ComputesValue;
import de.maikmerten.tomthumbtestgen.GeneratesCode;
import de.maikmerten.tomthumbtestgen.Register;

/**
 *
 * @author maik
 */
public abstract class RegOp implements GeneratesCode, ComputesValue {
	
	private Register s1, s2, dest;
	
	public RegOp() {
		this(new Register(), new Register(), new Register());
	}
	
	public RegOp(Register s1, Register s2, Register dest) {
		this.s1 = s1;
		this.s2 = s2;
		this.dest = dest;
		
		// if both sources denote the same register, then make sure
		// "both" registers contain the same value
		if(s2.equals(s1)) {
			this.s2 = s1;
		}
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
