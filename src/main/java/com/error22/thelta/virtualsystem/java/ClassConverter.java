package com.error22.thelta.virtualsystem.java;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import com.error22.thelta.NotImplementedException;
import com.error22.thelta.virtualsystem.java.ir.IType;
import com.error22.thelta.virtualsystem.java.ir.JavaClass;
import com.error22.thelta.virtualsystem.java.ir.JavaMethod;
import com.error22.thelta.virtualsystem.java.ir.MethodSignature;
import com.error22.thelta.virtualsystem.java.ir.StaticField;

import scala.Console;

public class ClassConverter extends ClassVisitor {
	private JavaProgram program;
	private JavaClass clazz;

	public ClassConverter(JavaProgram program) {
		super(Opcodes.ASM4);
		this.program = program;
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		clazz = new JavaClass(program, name, superName, interfaces);
		clazz.setCanBeExtended(true);
		program.addClass(clazz);
	}

	@Override
	public void visitOuterClass(String owner, String name, String desc) {
		System.out.println("visitOuterClass");
	}

	@Override
	public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
		System.out.println(access + "  " + name + " " + desc + " " + signature + " " + value);
		if ((access & Opcodes.ACC_PUBLIC) == Opcodes.ACC_PUBLIC) {
			clazz.addStaticField(
					new StaticField(ConversionUtils.parseFieldSignature(clazz.getName(), name, desc), value));
		} else {
			throw new NotImplementedException();
		}

		return super.visitField(access, name, desc, signature, value);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature1, String[] exceptions) {
		System.out.println("\n" + name + desc);

		MethodSignature signature = ConversionUtils.parseMethodSignature(clazz.getName(), name, desc);
		JavaMethod method = new JavaMethod(signature);
		clazz.addMethod(method);
		return new MethodConverter(method);
	}

	public JavaClass getClazz() {
		return clazz;
	}

}