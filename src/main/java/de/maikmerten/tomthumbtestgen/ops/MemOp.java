package de.maikmerten.tomthumbtestgen.ops;

import de.maikmerten.tomthumbtestgen.ComputesValue;
import de.maikmerten.tomthumbtestgen.GeneratesCode;
import de.maikmerten.tomthumbtestgen.Register;
import java.util.Random;

/**
 *
 * @author maik
 */
public abstract class MemOp implements GeneratesCode, ComputesValue {
	
	private Register s1, dest;
	
	public MemOp() {
		this(new Register(), new Register());
	}
	
	public MemOp(Register s1, Register dest) {
		this.s1 = s1;
		this.dest = dest;
	}
	
	
	public Register getS1() {
		return s1;
	}

	
	public Register getDest() {
		return dest;
	}

}
