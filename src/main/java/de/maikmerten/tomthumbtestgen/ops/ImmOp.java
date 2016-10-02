package de.maikmerten.tomthumbtestgen.ops;

import de.maikmerten.tomthumbtestgen.ComputesValue;
import de.maikmerten.tomthumbtestgen.GeneratesCode;
import de.maikmerten.tomthumbtestgen.Register;
import java.util.Random;

/**
 *
 * @author maik
 */
public abstract class ImmOp implements GeneratesCode, ComputesValue {
	
	private Register s1, dest;
	private int imm;
	
	public ImmOp() {
		this(new Register(), 0, new Register());
		Random r = new Random();
		setImm(r.nextInt());
	}
	
	public ImmOp(Register s1, int imm, Register dest) {
		this.s1 = s1;
		this.dest = dest;
		setImm(imm);
	}
	
	private void setImm(int imm) {
		imm <<= 20; // shave off all but 12 bits
		imm >>= 20; // scale back, with sign extension
		this.imm = imm;
	}
	
	
	public Register getS1() {
		return s1;
	}
	

	public int getImm() {
		return imm;
	}
	
	public Register getDest() {
		return dest;
	}
	

}
