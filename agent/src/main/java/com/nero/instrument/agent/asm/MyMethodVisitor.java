package com.nero.instrument.agent.asm;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.io.PrintStream;

public class MyMethodVisitor extends MethodVisitor {
    MyMethodVisitor(int api, MethodVisitor mv) {
        super(api, mv);
    }

    @Override
    public void visitCode() {
        super.visitCode();
        System.out.println("start hack before");
        hack(mv, "asm insert before");
    }


    @Override
    public void visitInsn(int opcode) {
        if (opcode == Opcodes.DRETURN) {
            System.out.println("start hack after");
            hack(mv, "asm insert after");
        }
        super.visitInsn(opcode);
    }

    private static void hack(MethodVisitor mv, String msg) {
        mv.visitFieldInsn(
                Opcodes.GETSTATIC,
                Type.getInternalName(System.class),
                "out",
                Type.getDescriptor(PrintStream.class)
        );
        mv.visitLdcInsn(msg);
        mv.visitMethodInsn(
                Opcodes.INVOKEVIRTUAL,
                Type.getInternalName(PrintStream.class),
                "println",
                "(Ljava/lang/String;)V",
                false
        );
    }
}