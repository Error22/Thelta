package com.error22.thelta.virtualsystem.java.ir;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.JavaProgram;

public class ObjectType implements IType {
	private String name;

	public ObjectType(String name) {
		this.name = name;
	}

	@Override
	public Object getDefault() {
		return null;
	}

	@Override
	public JavaClass getClass(JavaProgram program) {
		return program.getClass(name);
	}

	@Override
	public Object wrap(JavaProgram program, Object value) {
		return getClass(program).wrap(value);
	}

	@Override
	public Object unwrap(JavaProgram program, Object value) {
		return getClass(program).unwrap(value);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectType other = (ObjectType) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
