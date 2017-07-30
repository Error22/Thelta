package com.error22.thelta.virtualsystem.java.instructions;

import com.error22.thelta.virtualsystem.java.ir.IType;

public class StoreLocalInstruction implements IInstruction {
	private IType type;
	private int index;

	public StoreLocalInstruction(IType type, int index) {
		this.type = type;
		this.index = index;
	}

}
