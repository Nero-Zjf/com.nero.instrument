package com.nero.instrument.agent.asm;


import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class MyVisitor extends ClassVisitor {

    public MyVisitor(ClassVisitor cv) {
        super(Opcodes.ASM6, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        System.out.println("=====================");
        System.out.println("acce== " + access);
        System.out.println("name== " + name);
        System.out.println("desc== " + desc);
        System.out.println("sign== " + signature);
        System.out.println("=====================");

        MethodVisitor mv = super.visitMethod(access, name, desc, signature, exceptions);

        mv = new MyMethodVisitor(Opcodes.ASM6, mv);

        return mv;
    }
}
