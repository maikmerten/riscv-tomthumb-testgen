package de.maikmerten.tomthumbtestgen;

import java.util.Random;

/**
 *
 * @author maik
 */
public class Register implements GeneratesCode {
	
	private int value;
	private int regnum;
	
	public Register() {
		Random r = new Random();

		// assign random value
		this.value = r.nextInt();
		
		// select random register (6 to 14)
		this.regnum = r.nextInt(9) + 6;
	}
	
	public Register(int regnum, int value) {
		this.regnum = regnum;
		this.value = value;
	}
	
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int val) {
		this.value = val;
	}
	
	public String getName() {
		return "x" + regnum;
	}
	

	@Override
	public String generateCode() {
		return "li " + getName() + "," + getValue() + "\n";
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Register) {
			Register other = (Register)o;
			return other.regnum == this.regnum;
		}
		return false;
	}
	
	
	
}
